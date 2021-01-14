package com.luckybag.bean;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String name;
    private String code;
    private List<Node> children = new ArrayList<Node>();
    private Node parent;

    public Node() {
    }

    public Node(String name, int code, List<Node> children, Node parent) {
        this.name = name;
        this.code = Integer.toString(code);
        this.children = children;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
