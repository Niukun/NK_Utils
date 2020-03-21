package com.niukun.tree;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TreeTest {
    static final String LINE_SEPARATOR = System.getProperty("line.separator");
    public static void main(String[] args) {
        System.out.println("LINE_SEPARATOR is: " + LINE_SEPARATOR);

        List jobList = new ArrayList<String>();

        //0. 准备数据
        jobList.add("a");
        jobList.add("b");
        jobList.add("c");


        TreeNode tree = new TreeNode("", new ArrayList(), null);

//        addANode(tree, "a\\ b", jobList);
        List jobList2 = new ArrayList();
        jobList2.add("dddddddd");
//        addANode(tree, "a\\ c", jobList2);
//        addANode(tree, "a\\ d", jobList2);
//        addANode(tree, "a\\ b\\ ab", jobList2);
//        addANode(tree, "root\\ nd2", jobList2);


        addToTree(tree, "a\\\\ b", jobList);
        addToTree(tree, "a\\\\ c", jobList2);
        addToTree(tree, "a\\\\ d\\\\ f", jobList2);
        addToTree(tree, "a\\\\ c\\\\ sd", jobList2);
        addToTree(tree, "a\\\\ d\\\\ ki", jobList2);
        addToTree(tree, "a\\\\ b\\\\ ae\\\\ aaaa", jobList2);
        System.out.println("tree: \n" + tree.toString());

//        Test();
    }

    private static void addToTree(TreeNode tree, String path, List jobList) {
        if(tree.getChildren() == null || tree.getChildren().size() == 0 ){
            TreeNode node = diGuiPathTree("" ,path, jobList);
            tree.getChildren().add(node);
        }else if(path.startsWith(tree.getChildren().get(0).getPath())){
            TreeNode node = diGuiPathTree(path.substring(0,path.lastIndexOf("\\\\")) ,path, jobList);
            tree.getChildren().add(node);
        }else{
            boolean isInserted = false;
            for(TreeNode n : tree.getChildren()){
                if(path.indexOf(n.getPath()) > -1){
                    isInserted = true;
                    addToTree(n, path,jobList);
                    return;
                }
            }
            if(!isInserted){

                String parentPath = tree.getChildren().get(0).getPath().contains("\\\\")?tree.getChildren().get(0).getPath().substring(0,tree.getChildren().get(0).getPath().lastIndexOf("\\\\")):"";
                String restPath = path.substring(parentPath.length()+1);
//                addToTree(children, path,jobList);\\
//                TreeNode temp = new TreeNode(path,new ArrayList<TreeNode>(),jobList);
                TreeNode node = diGuiPathTree(parentPath ,restPath, jobList);
                tree.getChildren().add(node);

            }
        }
    }

    private static TreeNode diGuiPathTree(String parentPath, String path, List jobList) {
        String[] pathArr = path.split("\\\\\\\\");
        List<TreeNode> list = new ArrayList<TreeNode>();
        int parentIndex= -1;
        if(!"".equalsIgnoreCase(parentPath)){
//            parentPath +=  "\\\\";
            for (int i =0;i<pathArr.length;i++){
                if(pathArr[i].equalsIgnoreCase(parentPath)){
                    parentIndex = i;
                    break;
                }
            }
        }
        for (int i = parentIndex + 1; i < pathArr.length; i++) {
//            TreeNode temp = new TreeNode(parentPath + StringUtils.join(Arrays.asList(Arrays.copyOfRange(pathArr, 0,i+1)), "\\\\"), new ArrayList<TreeNode>(), null);
            TreeNode temp = new TreeNode(pathArr[i], new ArrayList<TreeNode>(), null);
            if(i == pathArr.length -1)
                temp.setJobs(jobList);
            list.add(temp);
        }
        for (int i = 0; i < list.size() -1; i++) {
            list.get(i).getChildren().add(list.get(i+1));
            if(i == list.size() -1){
                list.get(i).setJobs(jobList);
            }
        }
        return list.get(0);
    }

    private static void addANode(TreeNode tree, String path, List jobs) {
        String[] pathArr = path.split("\\\\");
        List<TreeNode> list = new ArrayList<TreeNode>();
        for (int i = 0; i < pathArr.length; i++) {
            list.add(new TreeNode(StringUtils.join(Arrays.asList(Arrays.copyOfRange(pathArr, 0,i+1)), "\\\\"), new ArrayList<TreeNode>(), null));
//            System.out.println("===============================");
//            System.out.println("pathArr: " + pathArr[i]);
//            System.out.println("real path is: " + StringUtils.join(Arrays.asList(Arrays.copyOfRange(pathArr, 0,i+1)), "\\\\ "));
//            System.out.println("rest: " + StringUtils.join(Arrays.asList(Arrays.copyOfRange(pathArr, i + 1,pathArr.length)), "\\\\ "));
        }
//        list.get(pathArr.length -1).setJobs(jobs);
//        list.get(0).setParent(tree);
        for (int i = 0; i < list.size() -1; i++) {
            list.get(i).getChildren().add(list.get(i+1));
//            list.get(i+1).setParent(list.get(i));
        }
        tree.getChildren().add(list.get(0));
        System.out.println(list.get(0));
    }

    private static void Test() {
        String[] arr1 = new String[]{"a", "b"};
        String[] arr2 = new String[]{"a", "b", "c", "d"};
        List<String> list1 = Arrays.asList(arr1);

        List<String> list2 = Arrays.asList(arr2);
        System.out.println(Arrays.equals(arr1, arr2));
        System.out.println(Collections.indexOfSubList(list2, list1) + list1.size());
        List l1 = new ArrayList(list1);
        List l2 = new ArrayList(list2);
        l2.removeAll(list1);
        System.out.println(l2);
    }


}
