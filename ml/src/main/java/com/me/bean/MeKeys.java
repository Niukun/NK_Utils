package com.me.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MeKeys {
    private String[] keys;

    public MeKeys() {
    }

    public MeKeys(String[] keys) {
        this.keys = keys;
    }

    public String[] getKeys() {
        return keys;
    }

    public void setKeys(String[] keys) {
        this.keys = keys;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if ( null == obj) return false;
        if(this.getClass() != obj.getClass()) return false;
        if (!(obj instanceof MeKeys)) return false;

        String[] tempKeys = ((MeKeys) obj).getKeys();
        String[] localKeys = this.getKeys();

        //如果key长度不一样，后面就不用比了
        if (tempKeys.length != localKeys.length) {
            return false;
        }

        //逐一对比
        for (int i = 0; i < localKeys.length; i++) {
            if (!tempKeys[i].equals(localKeys[i])) {
                return false;
            }
        }
        return true;

    }


    @Override
    public int hashCode() {
        return Objects.hash(this.getKeys());
    }

    public static void main(String[] args) {

        String[] a1 = new String[]{"aa"};
        String[] a2 = new String[]{"aa","bb","aa","bb","aa","bb"};
        MeKeys aa = new MeKeys(a1);
        MeKeys bb = new MeKeys(a2);
        System.out.println(aa.equals(bb));
        System.out.println(aa.hashCode());
        System.out.println(bb.hashCode());





    }

}
