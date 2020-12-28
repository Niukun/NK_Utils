package com.study.gui;

import java.util.Set;

import static com.study.gui.CONTANTS.userMap;

public class FakeLogin {

    /**
     * {<15000000003@123@8008>}
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(userMap);
        Set<String> set = userMap.keySet();
        for (String name: set) {
            ControlPanel controlPanel = new ControlPanel(userMap.get(name));
            controlPanel.showEventDemo();
        }

    }
}
