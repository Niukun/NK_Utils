package com.niukun.test;

import java.sql.Connection;
import java.sql.Statement;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.sql.DataSource;


public class test {
	public static void main(String[] args) throws Exception {
		
		ExecutorService executor = Executors.newSingleThreadExecutor();    
		FutureTask<String> future =    
		       new FutureTask<String>(new Callable<String>() {//使用Callable接口作为构造参数    
		         public String call() {    
		           //真正的任务在这里执行，这里的返回值类型为String，可以为任意类型    
		       }});    
		executor.execute(future);    
		//在这里可以做别的任何事情    
		try {    
		    result = future.get(5000, TimeUnit.MILLISECONDS); //取得结果，同时设置超时执行时间为5秒。同样可以用future.get()，不设置执行超时时间取得结果    
		} catch (InterruptedException e) {    
		    futureTask.cancel(true);    
		} catch (ExecutionException e) {    
		    futureTask.cancel(true);    
		} catch (TimeoutException e) {    
		    futureTask.cancel(true);    
		} finally {    
		    executor.shutdown();    
		}    
		
		
	}	
	public boolean checkDBStatus() {  
	    boolean bdStatus = false;  
	  
	    final ExecutorService exec = Executors.newFixedThreadPool(1);  
	    Callable<String> call = new Callable<String>() {  
	        public String call() throws Exception {  
	            DataSource dataSource = getJdbcTemplate().getDataSource();  
	            Connection connection = dataSource.getConnection();  
	            Statement statement = connection.createStatement();  
	            statement.executeQuery("select * from citirisk_menu_node");  
	            return "true";  
	        }  
	    };  
	  
	    try {  
	        Future<String> future = exec.submit(call);  
	        // set db connection timeout to 10 seconds  
	        String obj = future.get(1000 * 10, TimeUnit.MILLISECONDS);   
	        bdStatus = Boolean.parseBoolean(obj);  
	        System.out.println("the return value from call is :" + obj);  
	    } catch (TimeoutException ex) {  
	        System.out.println("====================task time out===============");  
	        ex.printStackTrace();  
	        bdStatus = false;  
	    } catch (Exception e) {  
	        System.out.println("failed to handle.");  
	        e.printStackTrace();  
	        bdStatus = false;  
	    }  
	    // close thread pool  
	    exec.shutdown();  
	  
	    return bdStatus;  
	}  
}
