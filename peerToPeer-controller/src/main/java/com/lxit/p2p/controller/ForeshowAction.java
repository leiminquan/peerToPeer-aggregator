package com.lxit.p2p.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lxit.p2p.bean.Foreshow;
import com.lxit.p2p.bean.Pager;
import com.lxit.p2p.service.ForeshowService;

@RestController
@ComponentScan(basePackages = { "com.lxit.p2p.service" })
public class ForeshowAction {

	@Resource
	private ForeshowService foreshowService;

	public ForeshowService getForeshowService() {
		return foreshowService;
	}

	public void setForeshowService(ForeshowService foreshowService) {
		this.foreshowService = foreshowService;
	}
	
	@RequestMapping(value = "/foreshowPageQuery")
	public Pager<Foreshow> foreshowPageQuery(int pageIndex, int pageSize, int foreshowState, String foreshowText,
			String foreshowBegin, String foreshowEnd) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		int initiate = (pageIndex - 1) * pageSize;
		map.put("foreshowState", foreshowState);
		map.put("foreshowText", foreshowText);
		map.put("foreshowBegin", foreshowBegin);
		map.put("foreshowEnd", foreshowEnd);
		map.put("pageSize", pageSize);
		map.put("pageIndex", pageIndex);
		map.put("commence", initiate);
		Pager<Foreshow> page = foreshowService.selectForeshowAll(map);
		return page;
	}
	
	@RequestMapping("/insertForeshow")
	public int insertForeshow(String text,String timeBegin,String timeEnd) {
		Foreshow f = new Foreshow();
		f.setHeadline(text);
		f.setIssueTime(timeBegin);
		f.setFinishTime(timeEnd);
		f.setState(1);
		f.setCreationor(1);
		return foreshowService.insertForeshow(f);
	}
	
	@RequestMapping("/deleteForeshow")
	public int deleteForeshow(String ids) {
		int count = 0;
		String[] idList = ids.split(",");
		for (String string : idList) {
			Foreshow f = new Foreshow();
			f.setForeshowId(Integer.parseInt(string));
			f.setState(2);
			f.setModifier(2);
			count = foreshowService.deleteForeshow(f);
			if (count == 0) {
				break;
			}
		}	
		return count;
	}
	
	@RequestMapping("/updateForeshow")
	public int updateForeshow(@RequestBody Foreshow foreshow) {
		foreshow.setModifier(2);
		return foreshowService.updateForeshow(foreshow);
	}
	
	@RequestMapping("/selectForeshowOne")
	public Foreshow selectForeshowOne(int foreshowId) {
		return foreshowService.selectForeshowOne(foreshowId);
	}

}
