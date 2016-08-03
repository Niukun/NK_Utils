package business.com.fzhong.service.kg.preprocess.normalize;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderErrors;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.definition.KnowledgePackage;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;

import business.com.fzhong.service.kg.dto.req.AddressReqDto;
import business.com.fzhong.service.kg.dto.req.DataReqDto;

/**
 * 启用规则进行地址标准化
 * @author Revan
 *
 */
@SuppressWarnings("deprecation")
public class FireRulesService {
	
	/**
	 * 用于规程使用的地址列表
	 */
	public List<AddressReqDto> addressList;
	
	/**
	 * 构造函数
	 * 将地址列表中的地址抽取出来做成列表，便于规则调用
	 * @param dataList
	 */
	public FireRulesService(List<DataReqDto> dataList){
		this.addressList = new ArrayList<AddressReqDto>();
		Iterator<DataReqDto> dataIter = dataList.iterator();
		while(dataIter.hasNext()){
			DataReqDto data = dataIter.next();
			this.addressList.addAll(data.getAddress());
		}
	}
	
	/**
	 * 启用规则
	 * @param roolFilePath 规则文件路径
	 */
	public void fireRules(String roolFilePath){
		//加载规则文件
		StatefulKnowledgeSession normalizeAddressSession = loadRules(roolFilePath);
		//将地址信息列表加入Working Memory
		Iterator<AddressReqDto> addressIter = addressList.iterator();
		while (addressIter.hasNext()) {
			normalizeAddressSession.insert(addressIter.next());
		}
		//启动规则
		normalizeAddressSession.fireAllRules();
		//注销规则
		normalizeAddressSession.dispose();
	}
	
	/**
	 * 加载规则文件
	 * @param ruleFilePath 规则文件路径
	 * @return
	 */
	private StatefulKnowledgeSession loadRules(String ruleFilePath){
		KnowledgeBuilder kb = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kb.add(ResourceFactory.newClassPathResource(ruleFilePath), ResourceType.DRL);
		if (kb.hasErrors() ) {  
            KnowledgeBuilderErrors kbe = kb.getErrors();
            for(Iterator<?> iter = kbe.iterator();iter.hasNext();){
            	System.out.println(iter.next());
            }
        } 
		Collection<KnowledgePackage> collection = kb.getKnowledgePackages();
		KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
		knowledgeBase.addKnowledgePackages(collection);
		StatefulKnowledgeSession statefulSession = knowledgeBase.newStatefulKnowledgeSession();
		
		return statefulSession;
	}

}
