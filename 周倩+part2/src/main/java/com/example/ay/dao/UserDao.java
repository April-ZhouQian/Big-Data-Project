package com.example.ay.dao;

import com.example.ay.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<User,Integer> , JpaSpecificationExecutor<User> {

    @Query(value = "SELECT * FROM  t_user where id=?1",nativeQuery = true)
    public  User findId(Integer id);
}
