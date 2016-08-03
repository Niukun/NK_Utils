package business.com.fzhong.service.kg.utils;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 读取xml文件
 * @author Revan
 *
 */
public class XmlReader {
	
	/**
	 * 地址标准化所用正则表达式文件路径
	 */
	public static final String NORM_REGEX_FILE = "NormalizeRegex.xml";
	public static final Element NORM_REGEX_ROOT_ELEMENT =  getRootNode(NORM_REGEX_FILE);

	/**
	 * 获取xml的根元素
	 * @param filePath 文件路径
	 * @return
	 */
	public static Element getRootNode(String filePath){
		DocumentBuilderFactory dfactory = DocumentBuilderFactory.newInstance();  
		Element element = null;
		try {
			DocumentBuilder builder = dfactory.newDocumentBuilder();
			Document document = builder.parse(XmlReader.class.getClassLoader().getResourceAsStream(filePath));
			element = document.getDocumentElement();
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return element;
	}
	
	/**
	 * 根据名称返回xml中对应值
	 * @param prop 名称
	 * @return
	 */
	public static String getNormRegex(String prop){
		String value = null;
		NodeList childNodes = NORM_REGEX_ROOT_ELEMENT.getChildNodes();
		for (int i = 0; i < childNodes.getLength(); i++) {
			Node node = childNodes.item(i);
		    if (prop.equals(node.getNodeName())) {
		    	value = node.getTextContent();
		    }
		}
		return value;
	}
	
}
