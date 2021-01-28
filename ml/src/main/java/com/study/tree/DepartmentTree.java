package com.study.tree;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hrssc.utils.FileUtils;
import org.junit.jupiter.api.Test;


public class DepartmentTree {


    @Test
    public void testIt() throws Exception {
        String filePath = "src/main/java/com/study/tree/11.log";

        JSONArray jsonArrayFromFile = FileUtils.getJSONArrayFromFile(filePath);

//        System.out.println(jsonArrayFromFile);
        Object o = jsonArrayFromFile.get(0);
        JSONObject jsonObject = JSON.parseObject(o.toString());
        String children = jsonObject.getString("children");
        System.out.println(JSON.parseObject(o.toString()));
        System.out.println(JSON.parseArray(children.toString()));
        
        int number = getUserNumFromArray(jsonArrayFromFile);
        System.out.println("总人数"+number);

//        JSONArray children = (JSONArray) ((JSONObject) jsonArrayFromFile.get(0)).get("children");
//        System.out.println(children.size());


    }

    private int getUserNumFromArray(JSONArray jsonArray) {
        int userNum = 0;

        for(int i =0; i< jsonArray.size();i++){
            Object o = jsonArray.get(i);
            JSONObject jsonObject = JSON.parseObject(o.toString());
            if(jsonObject.containsKey("children")){
                int children = getUserNumFromArray(jsonObject.getJSONArray("children"));
                Object o1 = jsonObject.get("DEPARTMENTNAME");
                System.out.println(o1.toString() + children);
                userNum += children;
            }else{
                userNum++;
            }

        }

        return userNum;
    }


}
