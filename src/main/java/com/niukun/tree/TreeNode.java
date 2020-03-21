package com.niukun.tree;

import java.util.List;

public class TreeNode {
    private String path;
    private List<TreeNode> children;
    private List<String> jobs;

    public TreeNode(String path,List<TreeNode> children, List<String> jobs) {
        this.path = path;
        this.children = children;
        this.jobs = jobs;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
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
//                ", \"parent\":" + parent +
                ", \"children\":" + children +
                ", \"jobs\":" + jobs +
                '}';
    }
}
