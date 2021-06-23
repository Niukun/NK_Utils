package com.db.mysql;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;

public class MySQLDaoTest extends TestCase {

    @Test
    public void test01(){
        try {
            MySQLDao.InsertMillionRecords();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}