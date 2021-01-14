package com.luckybag.service;


import com.luckybag.bean.Node;
import com.luckybag.bean.PersonInfo;
import com.luckybag.dao.LuckyBagDao;
import com.luckybag.poi.LuckyBagParser;

import java.io.File;
import java.util.*;

public class LuckyBagService {
    private static int id = 10;


    public void insertExcelIntoDB(File file) {
        LuckyBagParser luckyBagParser = new LuckyBagParser();

        List<PersonInfo> personInfos = null;
        try {
            personInfos = luckyBagParser.parseExcelFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Node node = insertDepartment(personInfos);
        insertUserInfo(node, personInfos);


    }

    private void insertUserInfo(Node tree, List<PersonInfo> personInfos) {
        Iterator<PersonInfo> iterator = personInfos.iterator();
        while(iterator.hasNext()){
            LuckyBagDao.insertUser(iterator.next());
        }
        System.out.println("用户表初始化成功！");
    }

    private String getDepartmentIdByPerson(Node tree, PersonInfo personInfo) {
        String level1 = personInfo.getLevel1();
        String level2 = personInfo.getLevel2();
        String level3 = personInfo.getLevel3();
        String level4 = personInfo.getLevel4();

        Node node1 = getNodeByDeparementName(level1, tree);
        if(node1 != null){
            Node node2 = getNodeByDeparementName(level2, node1);
            if(node2 != null){
                Node node3 = getNodeByDeparementName(level3, node1);
                if(node3 != null){
                    Node node4 = getNodeByDeparementName(level4, node1);
                    if(node4 != null){
                        return node4.getCode();
                    }
                    return node3.getCode();
                }
                return node2.getCode();

            }
            return node1.getCode();


        } else {
            return tree.getCode();
        }
    }

    private Node getNodeByDeparementName(String departmentName, Node tree) {
        List<Node> children = tree.getChildren();
        Iterator<Node> iterator = children.iterator();
        while(iterator.hasNext()){
            Node node = iterator.next();
            if(node.getName().equalsIgnoreCase(departmentName)){
                return node;
            }
        }

        return null;
    }


    /**
     * 解析excel表中的数据，初始化department表，形成上下级关系
     * @param personInfos
     */
    private Node insertDepartment(List<PersonInfo> personInfos) {
        Iterator<PersonInfo> iterator = personInfos.iterator();
        Node tree = new Node();
        tree.setName("-");
        tree.setCode("0");
        while (iterator.hasNext()) {
            PersonInfo person = iterator.next();
            List<String> levelList = new ArrayList<>();
            levelList.add(person.getLevel1());
            if (person.getLevel2() != null) {
                levelList.add(person.getLevel2());
                if (person.getLevel3() != null) {
                    levelList.add(person.getLevel3());
                    if (person.getLevel4() != null) {
                        levelList.add(person.getLevel4());
                    }
                }
            }

            buildDepartmentTree(levelList, tree, person);


        }
        LuckyBagDao.insertIntoDepartment(tree);
        System.out.println("部门表初始化成功！");
        return tree;
    }

    /**
     * 构建部门树
     * @param levelList
     * @param node
     */
    private void buildDepartmentTree(List<String> levelList, Node node, PersonInfo personInfo) {

        if(levelList.size() == 0 ){
            personInfo.setDepartmentid(node.getCode());
            return;
        }
        String current = levelList.get(0);
        if(current == null){
            return;
        }
        levelList.remove(0);
        Result result = departInChildren(current, node.getChildren());

        if(result.inList){

            buildDepartmentTree(levelList,result.node, personInfo);

        }else{
            Node n = new Node(current,id++,new ArrayList<Node>(),node);
            node.getChildren().add(n);
            personInfo.setDepartmentid(n.getCode());
        }

    }

    /**
     * 判断部门是否存在当前节点下
     * @param departmentName
     * @param children
     * @return
     */
    private Result departInChildren(String departmentName, List<Node> children) {
        Iterator<Node> iterator = children.iterator();
        Result result = new Result();
        while (iterator.hasNext()){
            Node next = iterator.next();
            if(next.getName().equals(departmentName)){
                result.inList = true;
                result.node = next;
                break;
            }
        }
        return result;
    }


    /**
     * 用于保存判断结果
     */
    class Result{
        boolean inList;
        Node node;

        public Result() {
            this.inList = false;
        }
    }

}
