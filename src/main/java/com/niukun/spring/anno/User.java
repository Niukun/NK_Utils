package com.niukun.spring.anno;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 注解创建对象
 * Component/Controller/Service/Repository
 * 目前这四个关键词的功能是一样的。
 * 
 * @author Niukun
 *
 */
@Component(value="user")
@Scope
public class User {

	public void add() {
		System.out.println("add .....");
	}
}
