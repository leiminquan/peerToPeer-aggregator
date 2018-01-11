package com.lxit.p2p.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lxit.p2p.bean.Tree;
import com.lxit.p2p.service.TreeService;

@RestController
@ComponentScan(basePackages={"com.lxit.p2p.service"})
public class TreeAction {
	@Resource
	private TreeService treeService;

	public TreeService getTreeService() {
		return treeService;
	}

	public void setTreeService(TreeService treeService) {
		this.treeService = treeService;
	}
	
	@RequestMapping("/selectTreeAll")
	public List<Tree> selectTreeAll(@RequestParam(defaultValue="0",required=false,value="id")int id){			
		
		Date date = new Date();
		String sss = SimpleDateFormat.getInstance().format(date);
		List<Tree> list = treeService.selectTreeAll(id);
		return list;
	}
}
