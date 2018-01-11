package com.lxit.p2p.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Service;

import com.lxit.p2p.bean.Tree;
import com.lxit.p2p.dao.TreeDao;
import com.lxit.p2p.service.TreeService;
@Service
@MapperScan("com.lxit.p2p.dao")
public class TreeServiceImpl implements TreeService {
	
	@Resource
	private TreeDao treeDao;
	
	public TreeDao getTreeDao() {
		return treeDao;
	}


	public void setTreeDao(TreeDao treeDao) {
		this.treeDao = treeDao;
	}


	@Override
	public List<Tree> selectTreeAll(int nid) {
		return treeDao.selectTreeAll(nid);
	}

}
