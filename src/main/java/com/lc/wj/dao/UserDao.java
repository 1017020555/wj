package com.lc.wj.dao;

import com.lc.wj.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {

    User findByUsername(String username);

    User findByUsernameAndPassword(String username,String password);

}
