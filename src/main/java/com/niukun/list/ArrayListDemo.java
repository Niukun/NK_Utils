package com.niukun.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 测试一个列表是否包含某个字符串元素
 * 
 * @author Niukun
 *
 */
public class ArrayListDemo {
	private List<String> list = new ArrayList<String>();
	public static void main(String[] args) {
		new ArrayListDemo().remove3Test();
	}

	/**
	 * 判断一个ArrayList里面是否包含某个字符串
	 */
	private void containsTest(){
		for (int i = 0; i < 100; i++) {
			list.add("abc" + i);
		}
		System.out.println("包含abc吗？" + list.contains("abc222"));
		System.out.println("包含abc吗？" + list.contains("abc2"));
		System.out.println("包含abc吗？" + list.contains("ab"));
	}

	/**
	 * 删除ArrayList中所有的元素,默认从头开始删
	 *
	 */
	public void removeTest(){
		System.out.println("removeTest 删除ArrayList中所有的元素,默认从头开始删：" );
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		System.out.println("删除以前：" + list);
		while(list.size() != 0){
			System.out.println( "remove: " + list.get(0));
			list.remove(list.get(0));
		}
		System.out.println("删除以后：" + list);
	}

	/**
	 * https://www.cnblogs.com/flotang/archive/2018/06/23/9216098.html
	 * 删除操作——正序删
	 * 删除操作——倒序删
	 * 迭代器remove()方法删除（推荐）
	 * 增强for循环
	 */

	/**
	 * 正序删
	 *
	 * 如果只删除至多1个元素，那只需要在删除后使用break语句跳出循环即可，如果需要删除多个元素，
	 * 若不注意控制当前列表的size和下一个元素的index，容易报java.lang.IndexOutOfBoundsException异常
	 */

	public void remove1Test(){
		System.out.println("remove1Test 正序删：" );
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		System.out.println("删除b以前：" + list);
		for(int i =0;  i< list.size(); i++){
			if(list.get(i) == "b"){
				list.remove(list.get(i));
			}
		}
		System.out.println("删除b以后：" + list);
	}

	/**
	 * 倒序删
	 *
	 * 倒序删可以克服正序删需要额外管理列表size和下一个元素的index的问题，使用起来也很方便
	 */
	public void remove2Test(){
		System.out.println("remove2Test 倒序删：" );
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		System.out.println("删除以前：" + list);
		for(int i = list.size()-1;  i >= 0; i--){
			System.out.println( "remove: " + list.get(i));
			list.remove(list.get(i));
		}
		System.out.println("删除以后：" + list);
	}

	/**
	 * 迭代器remove()方法删除（推荐）
	 *
	 * 迭代器remove()方法虽然方便，但仍有需要注意的地方，
	 * 要用此法删除元素的前提是该 List 的实现类的iterator()方法返回的Iterator实现类支持remove()方法，
	 * 否则会报 java.lang.UnsupportedOperationException异常，
	 * 常用的ArrayList的Iterator支持remove()方法
	 */
	public void remove3Test(){
		System.out.println("remove3Test 迭代器remove()方法删除：" );
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		System.out.println("删除以前：" + list);
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			String item = iter.next();
			if (item.equals("c")) {
				System.out.println( "remove: " + item);
				iter.remove();
			}
		}
		System.out.println("删除以后：" + list);
	}

	/**
	 * 增强for循环
	 *
	 * 增强for循环中删除元素后继续循环会报java.util.ConcurrentModificationException 异常，
	 * 因为元素在使用的时候发生了并发的修改，导致异常抛出，
	 * 但是删除完毕马上使用break语句跳出循环，则不会触发报错，
	 * 所以它适合删除至多1个元素。
	 */
	public void remove4Test(){
		System.out.println("remove4Test 增强for循环：" );
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		System.out.println("删除以前：" + list);
		for(String s : list){
			if("c".equals(s)){
				System.out.println( "remove: " + s);
				list.remove("c");
				break;
			}
		}
		System.out.println("删除以后：" + list);
	}



}
