package com.lcode;

import org.junit.Test;

import java.util.*;

/**
 * 账户合并
 * 描述：
 * 给定一个列表 accounts，每个元素 accounts[i]是一个字符串列表，其中第一个元素 accounts[i][0]是名称 (name)，其余元素是 emails 表示该账户的邮箱地址。
 * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。
 * 一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
 * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。账户本身可以以任意顺序返回。
 *
 * 示例：
 * 输入：
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * 输出：
 * [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * 解释：
 * 第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。
 * 第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
 * 可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
 * ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的。
 *
 *提示：
 * accounts的长度将在[1，1000]的范围内。
 * accounts[i]的长度将在[1，10]的范围内。
 * accounts[i][j]的长度将在[1，30]的范围内。
 *
 *
 */

public class Solution721 {

    @Test
    public void test(){
        ArrayList<List<String>> accounts = new ArrayList<>();
        ArrayList<String> user1 = new ArrayList<>();
        user1.add("John");
        user1.add("johnsmith@mail.com");
        user1.add("john_newyork@mail.com");
        user1.add("john@mail.com");
        user1.add("johnnybravo@mail.com");

        ArrayList<String> user2 = new ArrayList<>();
        user2.add("John");
        user2.add("johnnybravo@mail.com");

        ArrayList<String> user3 = new ArrayList<>();
        user3.add("John");
        user3.add("johnsmith@mail.com");
        user3.add("john00@mail.com");


        ArrayList<String> user4 = new ArrayList<>();
        user4.add("Mary");
        user4.add("mary@mail.com");



        accounts.add(user1);
        accounts.add(user2);
        accounts.add(user3);
        accounts.add(user4);
        List<List<String>> lists = accountsMerge(accounts);
        System.out.println(lists);

    }


    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        for(int i = 0; i<accounts.size()-1;i++){
            for(int j = i+1; j<accounts.size();j++){
                String user1 = accounts.get(i).remove(0);
                String user2 = accounts.get(j).remove(0);
                boolean disjoint = Collections.disjoint(accounts.get(i), accounts.get(j));
                if(!disjoint){
                    accounts.get(i).addAll(accounts.get(j));
                    Set set = new TreeSet(accounts.get(i));
                    List<String> strings = accounts.get(i);
                    strings = new ArrayList<String>(set);
                    strings.add(0,user1);
                    accounts.get(i).clear();
                    accounts.get(j).add(0,"");
                    accounts.get(i).addAll(strings);
                }
            }
        }
        for(int i = 0; i<accounts.size();i++){
            if(accounts.get(i).get(0) == ""){
                accounts.remove(i);
            }
        }




        return accounts;
    }

}
