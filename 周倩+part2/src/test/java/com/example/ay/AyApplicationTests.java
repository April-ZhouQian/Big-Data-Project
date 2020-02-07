package com.example.ay;

import com.example.ay.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
class AyApplicationTests {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    public void testMySql(){
        List<Map<String,Object>>result=jdbcTemplate.queryForList("select  * from table1");
        System.out.println("result is: "+result);
        System.out.println("success");
    }
    @Test
    public void updateMySql(){
        jdbcTemplate.execute("update table1 set name='zhouqian' where id='1527'");
        System.out.println("success");
    }

}
