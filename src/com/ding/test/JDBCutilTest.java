package com.ding.test;

import com.ding.util.JdbcUtils;
import org.junit.Test;

public class JDBCutilTest {
    @Test
    public void testJdbcUtils(){
        for(int i = 0;i < 100;i++){

            System.out.println(JdbcUtils.getConnection());
        }
    }
}
