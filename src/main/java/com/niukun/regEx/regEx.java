package com.niukun.regEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式知识点：
 * 1.任意字符串都可以当成正则表达式使用
 * 2.正则表达式中特殊字符：$^*?.|等
 * 3.正则表达式中预定义字符: . \d \D \s \S \w \W
 * 4.正则表达式中的方括号表达式表示范围[ab][a-k]
 * 5.边界匹配符: $^\b\z
 * 6.三种匹配模式： 贪婪模式：默认使用
 * 最小匹配模式：用?后缀
 */
public class regEx {

    public static void main(String[] args) {
        // 要验证的字符串
        String str = "sadf <img  src=\"photo get\" data-src=\"failed\">";
        // 正则表达式规则
        String regEx = "<img[ ]*src=\"(.*?)\".*?>";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        // 查找字符串中是否有匹配正则表达式的字符/字符串
//	    System.out.println(matcher.find());
//	    System.out.println(str);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            //匹配模式测试
            str = "Hello world!";
            System.out.println("贪婪模式: " + str.replaceFirst("\\w*", "%"));//贪婪模式
            System.out.println("最小匹配模式: " + str.replaceFirst("\\w*?", "%"));//最小匹配模式

            str = "tel : 13511112222 and my number is 15021597239 my person is 16312345678";
            Matcher m = Pattern.compile("((13)|(15))\\d{9}").matcher(str);
            while (m.find()) {
                System.out.println(m.group());
            }
            str = "java is very easy";
            m = Pattern.compile("\\w+dc").matcher(str);
            while (m.find()) {
                System.out.println(m.group() + ": " + m.start() + " : " + m.end());
            }
        }
    }
}
