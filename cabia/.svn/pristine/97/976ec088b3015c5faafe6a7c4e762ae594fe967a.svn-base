package business.com.fzhong.service.kg.utils.dict;

import java.util.List;

/**
 * 词典接口
 * @author Administrator
 *
 */
public interface IDictionary {
	/**
     * 词典中的词的最大长度，即有多少个字符
     * @return 长度
     */
    public int getMaxLength();

    /**
     * 判断指定的文本是不是一个词
     * @param item 文本
     * @param start 指定的文本从哪个下标索引开始
     * @param length 指定的文本的长度
     * 比如：contains("我爱写程序",  3, 2);
     * 表示的意思是“程序”是不是一个定义在词典中的词
     * @return 是否
     */
    public boolean contains(String item, int start, int length);

    /**
     * 判断文本是不是一个词
     * @param item 文本
     * @return 是否
     */
    public boolean contains(String item);

    /**
     * 批量将词加入词典
     * @param items 集合中的每一个元素是一个词
     */
    public void addAll(List<String> items);

    /**
     * 将单个词加入词典
     * @param item 词
     */
    public void add(String item);

    /**
     * 批量将词从词典中删除
     * @param items 集合中的每一个元素是一个词
     */
    public void removeAll(List<String> items);

    /**
     * 将单个词从词典中删除
     * @param item 词
     */
    public void remove(String item);

    /**
     * 清空词典中的所有的词
     */
    public void clear();
}
