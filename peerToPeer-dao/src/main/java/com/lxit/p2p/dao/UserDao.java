package com.lxit.p2p.dao;

import org.springframework.stereotype.Repository;

import com.lxit.p2p.bean.User;

@Repository
public interface UserDao {
	
	public int updateUserMoney(User user);
}
