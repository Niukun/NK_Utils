package com.niukun.tree;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TreeTest01 {
    static final String LINE_SEPARATOR = System.getProperty("line.separator");
    public static void main(String[] args) {
        System.out.println("LINE_SEPARATOR is: " + LINE_SEPARATOR);

        List jobList = new ArrayList<String>();

        //0. 准备数据
        jobList.add("a");
        jobList.add("b");
        jobList.add("c");


        ModuleTreeNode tree = new ModuleTreeNode("","", new ArrayList(), null);

//        addANode(tree, "a\\ b", jobList);
        List jobList2 = new ArrayList();
        jobList2.add("dddddddd");
//        addANode(tree, "a\\ c", jobList2);
//        addANode(tree, "a\\ d", jobList2);
//        addANode(tree, "a\\ b\\ ab", jobList2);
//        addANode(tree, "root\\ nd2", jobList2);

        tree.addNode("a\\\\b", jobList);
        tree.addNode("a\\\\c", jobList);
        tree.addNode("a\\\\d\\\\f", jobList);

//        addToTree(tree.getChildren(), "a\\\\ c\\\\ sd", jobList2);
//        addToTree(tree.getChildren(), "a\\\\ d\\\\ ki", jobList2);
//        addToTree(tree.getChildren(), "a\\\\ b\\\\ ae\\\\ aaaa", jobList2);
        System.out.println("tree: \n" + tree.toString());

    }

    private static void addToTree(ModuleTreeNode tree, String s, List jobList) {



    }


}
