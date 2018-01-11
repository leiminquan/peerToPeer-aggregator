package com.lxit.p2p.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lxit.p2p.bean.Tree;

@Repository
public interface TreeDao {
	
	public List<Tree> selectTreeAll(int nid);
}
