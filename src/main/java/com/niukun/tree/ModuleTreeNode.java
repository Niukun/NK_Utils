package com.niukun.tree;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.helper.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ModuleTreeNode {
    private String path;
    private String fullPath;
    private List<ModuleTreeNode> children;
    private List<String> jobs;

    public ModuleTreeNode(String path, String fullPath, List<ModuleTreeNode> children, List<String> jobs) {
        this.path = path;
        this.fullPath = fullPath;
        this.children = children;
        this.jobs = jobs;
    }

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<ModuleTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<ModuleTreeNode> children) {
        this.children = children;
    }

    public List<String> getJobs() {
        return jobs;
    }

    public void setJobs(List<String> jobs) {
        this.jobs = jobs;
    }

    @Override
    public String toString() {
        return "{" +
                "\"path\":'" + path + '\'' +
                ", \"fullPath\":" + fullPath +
                ", \"children\":" + children +
                ", \"jobs\":" + jobs +
                '}';
    }

    public void addNode(String nodePath, List jobList) {
        List<ModuleTreeNode> children = this.getChildren();
        boolean shouldInsertChildren = false;
        if(children.size() == 0){
            this.diguiCreate(nodePath, jobList);
        }
        for (ModuleTreeNode c : children){
            //判断是否需要插入到子节点
            if(nodePath.contains(c.getFullPath())){
                shouldInsertChildren = true;
                c.addNode(nodePath,jobList);
            }
        }
        //作为兄弟节点插入进来
        if(!shouldInsertChildren){
            String parentPath = this.getFullPath().substring(0, this.getFullPath().length() - this.getPath().length());
            String restPath = nodePath.substring(parentPath.length());
            String[] pathArray = restPath.split("\\\\\\\\");
            List<ModuleTreeNode> list=  new ArrayList<>();
            for(String path: pathArray){
                ModuleTreeNode temp = new ModuleTreeNode(path,parentPath + "\\\\" + path, new ArrayList<>(), null);
                parentPath += "\\\\" + path;

                list.add(temp);
            }
            for(int i =0; i< list.size()-1;i++){
                if(i == list.size()-1){
                    list.get(i).setJobs(jobList);
                }
                list.get(i).getChildren().add(list.get(i+1));
            }
            this.getChildren().add(list.get(0));
        }

    }

    private void diguiCreate(String nodePath, List jobList) {
        String[] pathArray = nodePath.split("\\\\\\\\");
        List<ModuleTreeNode> list = new ArrayList();
        for(int i = 0; i < pathArray.length-1; i++){
            String[] parentPath = Arrays.copyOfRange(pathArray,0, i+1);
            ModuleTreeNode temp = new ModuleTreeNode(pathArray[i], StringUtils.join(Arrays.asList(parentPath),"\\\\"), new ArrayList<>(),null);
            if(i == pathArray.length -1){
                temp.setJobs(jobList);
            }
            list.add(temp);
        }
        for(int i = 0; i < list.size()-1;i++){
            list.get(i).getChildren().add(list.get(i+1));
        }
        this.getChildren().add(list.get(0));

    }
}
