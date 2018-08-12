package com.niukun.spring.anno;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service(value="userService")
public class UserService {
	//得到dao对象
	//1 定义dao类型属性
	//在dao属性上面使用注解完成对象注入
//	@Autowired //根据类名自动注入对象属性
//	private UserDao userDao;
	
	//name属性值为注解创建对象value值
	@Resource(name="userDao")
	private UserDao userDao;
	public void add() {
		System.out.println("service.......");
		userDao.add();
	}
}
