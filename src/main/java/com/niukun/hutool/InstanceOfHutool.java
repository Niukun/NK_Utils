package com.niukun.hutool;

import cn.hutool.core.util.RuntimeUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;

public class InstanceOfHutool {

    public static void main(String[] args) {
        System.out.println(StrUtil.getContainsStr("qweqweqweqsaweqwe","aweq"));

        System.out.println(SecureUtil.md5("123"));


    }



}
