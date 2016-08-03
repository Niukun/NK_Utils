package business.com.fzhong.service.kg.utils.segment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import business.com.fzhong.service.kg.utils.FileOperation;
import business.com.fzhong.service.kg.utils.dict.IDictionary;
import business.com.fzhong.service.kg.utils.dict.impl.HashSetDictionaryImpl;

public class Segmentation {

	private int threshold;	// 粗粒度词长度阈值
	private IDictionary dic;	//词典
	
	public Segmentation(String dicFilePath){
		this.threshold = 11;
		this.dic = new HashSetDictionaryImpl();
		FileOperation fileOperator = new FileOperation();
		File dicFile = new File(dicFilePath);
		
		try {
			List<String> dicItems = fileOperator.readTxtFile(dicFile);
			dic.addAll(dicItems);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 双向切词
	 * @param text 需要切词的句子
	 * @param dic 词典
	 * @return 切词结果
	 */
	public List<String> segBDMM(String text, IDictionary dic,int threshold) {

		// 分别执行FMM与RMM
		List<String> ret1 = segFMM(text, dic);
		List<String> ret2 = segRMM(text, dic);

		if (singleCount(ret1) == singleCount(ret2)) {
			if (coarsnessCount(ret1) > coarsnessCount(ret2))
				return ret1;
			else
				return ret2;
		} else if (singleCount(ret1) < singleCount(ret2)) {
			return ret1;
		} else {
			return ret2;
		}
	}
	
	/**
	 * 正向切词
	 * @param text 需要切词的句子
	 * @param dic 词典
	 * @return 切词结果
	 */
	public List<String> segFMM(String text, IDictionary dic){          
        List<String> result = new ArrayList<String>();  
        while(text.length()>0){  
            int len=dic.getMaxLength();  
            if(text.length()<len){  
                len=text.length();  
            }  
            //取指定的最大长度的文本去词典里面匹配  
            String tryWord = text.substring(0, 0+len);  
            while(!dic.contains(tryWord)){  
                //如果长度为1且在词典中未找到匹配，则按长度为1切分  
                if(tryWord.length()==1){  
                    break;  
                }  
                //如果匹配不到，则长度减1继续匹配  
                tryWord=tryWord.substring(0, tryWord.length()-1);  
            }  
            result.add(tryWord);  
            //从待分词文本中去除已经分词的文本  
            text=text.substring(tryWord.length());  
        }  
        return result;  
    }
	
	/**
	 * 反向切词
	 * @param text 需要切词的句子
	 * @param dic 词典
	 * @return 切词结果
	 */
	public List<String> segRMM(String text, IDictionary dic){          
	    Stack<String> result = new Stack<String>();  
	    while(text.length()>0){  
	        int len=dic.getMaxLength();  
	        if(text.length()<len){  
	            len=text.length();  
	        }  
	        //取指定的最大长度的文本去词典里面匹配  
	        String tryWord = text.substring(text.length() - len);  
	        while(!dic.contains(tryWord)){  
	            //如果长度为一且在词典中未找到匹配，则按长度为一切分  
	            if(tryWord.length()==1){  
	                break;  
	            }  
	            //如果匹配不到，则长度减一继续匹配  
	            tryWord=tryWord.substring(1);  
	        }  
	        result.push(tryWord);  
	        //从待分词文本中去除已经分词的文本  
	        text=text.substring(0, text.length()-tryWord.length());  
	    }  
	    int len=result.size();  
	    List<String> list = new ArrayList<String>(len);  
	    for(int i=0;i<len;i++){  
	        list.add(result.pop());  
	    }  
	    return list;  
	}  


	/**
	 * 计算分词结果中单字的个数
	 * @param wordList 分词的结果
	 * @return 单字个数
	 */
	private int singleCount(List<String> wordList) {
		int singleNum = 0;
		for (String item : wordList) {
			if (item.length() == 1)
				singleNum++;
		}
		return singleNum;
	}

	/**
	 * 计算粗粒度词个数
	 * @param wordList 分词的结果
	 * @param threshold 
	 * @return 粗粒度词个数
	 */
	private int coarsnessCount(List<String> wordList) {
		int coarsnessNum = 0;
		for (String item : wordList) {
			if (item.length() >= threshold)
				coarsnessNum++;
		}
		return coarsnessNum;
	}

	
	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}
	
}
