package business.com.fzhong.service.kg.utils.dict.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import business.com.fzhong.service.kg.utils.dict.IDictionary;


public class HashSetDictionaryImpl implements IDictionary {
	
	private Set<String> set = new HashSet<String>();  
    
	private int maxLength;  
    
	/**
	 * 获取词典单词最大长度
	 */
    public int getMaxLength() {  
        return maxLength;  
    }  
     
    /**
     * 判断一个字符串的部分是否存在于词典中
     */
    public boolean contains(String item, int start, int length) {  
        return set.contains(item.substring(start, start+length));  
    }  

    /**
     * 判断一个字符串是否存在于词典中
     */
    public boolean contains(String item) {  
        return set.contains(item);  
    }  
  
    /**
     * 增加字符串List到词典中
     */
    public void addAll(List<String> items) {  
        
    	for(String item : items){  
            this.add(item);  
        }  
    }  
  
    /**
	 * 增加一个字符串到词典中
	 */	
    public void add(String item) {  
        //去掉首尾空白字符  
        item=item.trim();  
        int len = item.length();  
        if(len < 1){  
            //长度小于1则忽略  
            return;  
        }  
        if(len>maxLength){  
            maxLength=len;  
        }  
        set.add(item);  
    } 
	

    /**
     * 清除词典内容
     */
	public void clear() {
		set.clear();

	}

	/**
	 * 清除词典单个词
	 */
	public void remove(String item) {
		set.remove(item);
		
	}

	/**
	 * 根据词列表,清除词典中对应的词
	 */
	public void removeAll(List<String> items) {
		set.removeAll(items);

	}

}
