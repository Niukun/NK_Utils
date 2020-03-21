package com.niukun.tree;

import javax.swing.tree.TreePath;
import java.util.ArrayList;
import java.util.List;

public class JavaTreePathTest {
    public static void main(String[] atgs){
        String[] path1 = new String[]{"a","b","c"};
        String[] path2 = new String[]{"a","d","c"};

        List<String> list = new ArrayList();

        TreePath tp1 = new TreePath(path1);
        TreePath tp2 = new TreePath(path2);
        for(int i = 0;i< tp1.getPathCount(); i++){
            if(!tp1.getPathComponent(i).equals(tp2.getPathComponent(i))){
                System.out.println(tp1.getPathComponent(i));
                System.out.println(tp2.getPathComponent(i));
            }
        }



//        System.out.println(tp1.getParentPath());
//        System.out.println(tp1.getLastPathComponent());
//        System.out.println(tp1.isDescendant(tp2));
//        System.out.println(tp1.getPath().toString());
//        System.out.println(tp1.getPathCount());

    }

}
