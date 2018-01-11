package com.lxit.p2p.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Service;

import com.lxit.p2p.bean.Foreshow;
import com.lxit.p2p.bean.Pager;
import com.lxit.p2p.dao.ForeshowDao;
import com.lxit.p2p.service.ForeshowService;

@Service
@MapperScan("com.lxit.p2p.dao")
public class ForeshowServiceImpl implements ForeshowService {

	@Resource
	private ForeshowDao foreshowDao;

	public ForeshowDao getForeshowDao() {
		return foreshowDao;
	}

	public void setForeshowDao(ForeshowDao foreshowDao) {
		this.foreshowDao = foreshowDao;
	}

	@Override
	public int insertForeshow(Foreshow foreshow) {
		return foreshowDao.insertForeshow(foreshow);
	}

	@Override
	public int updateForeshow(Foreshow foreshow) {
		return foreshowDao.updateForeshow(foreshow);
	}

	@Override
	public int deleteForeshow(Foreshow foreshow) {
		return foreshowDao.deleteForeshow(foreshow);
	}

	@Override
	public Pager<Foreshow> selectForeshowAll(Map<String, Object> map) {
		List<Foreshow> ct = foreshowDao.selectForeshowAll(map);
		int count = ct.size();
		int initiate = (int) map.get("commence");
		int pageIndex = (int) map.get("pageIndex");
		int pageSize = (int) map.get("pageSize");
		map.put("initiate", initiate);
		List<Foreshow> list = foreshowDao.selectForeshowAll(map);
		if (list.size() > 0) {
			for (Foreshow foreshow : list) {
				if (foreshow.getIssueTime()!=null&&foreshow.getIssueTime()!="") {
					foreshow.setIssueTime(foreshow.getIssueTime().substring(0, foreshow.getIssueTime().length() - 2));
				}
				if (foreshow.getFinishTime()!=null&&foreshow.getFinishTime()!="") {
					foreshow.setFinishTime(foreshow.getFinishTime().substring(0, foreshow.getFinishTime().length() - 2));
				}
				if (foreshow.getRegistTime()!=null&&foreshow.getRegistTime()!="") {
					foreshow.setRegistTime(foreshow.getRegistTime().substring(0, foreshow.getRegistTime().length() - 2));
				}
				if (foreshow.getModificationTime()!=null&&foreshow.getModificationTime()!="") {
					foreshow.setModificationTime(foreshow.getModificationTime().substring(0, foreshow.getModificationTime().length() - 2));
				}
			}
		}
		Pager<Foreshow> page = new Pager<>();
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		page.setSumCount(count);
		page.setData(list);
		return page;
	}

	@Override
	public Foreshow selectForeshowOne(int foreshowId) {
		
		Foreshow foreshow=foreshowDao.selectForeshowOne(foreshowId);
		if (foreshow.getIssueTime()!=null&&foreshow.getIssueTime()!="") {
			foreshow.setIssueTime(foreshow.getIssueTime().substring(0, foreshow.getIssueTime().length() - 2));
		}
		if (foreshow.getFinishTime()!=null&&foreshow.getFinishTime()!="") {
			foreshow.setFinishTime(foreshow.getFinishTime().substring(0, foreshow.getFinishTime().length() - 2));
		}
		if (foreshow.getRegistTime()!=null&&foreshow.getRegistTime()!="") {
			foreshow.setRegistTime(foreshow.getRegistTime().substring(0, foreshow.getRegistTime().length() - 2));
		}
		if (foreshow.getModificationTime()!=null&&foreshow.getModificationTime()!="") {
			foreshow.setModificationTime(foreshow.getModificationTime().substring(0, foreshow.getModificationTime().length() - 2));
		}
		return foreshow;
	}

}
