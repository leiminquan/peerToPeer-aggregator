package com.lxit.p2p.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Service;

import com.lxit.p2p.bean.Pager;
import com.lxit.p2p.bean.Refundplan;
import com.lxit.p2p.dao.RefundplanDao;
import com.lxit.p2p.service.RefundplanService;

@Service
@MapperScan("com.lxit.p2p.dao")
public class RefundplanServiceImpl implements RefundplanService{
	
	@Resource
	private RefundplanDao refundplanDao;

	public RefundplanDao getRefundplanDao() {
		return refundplanDao;
	}

	public void setRefundplanDao(RefundplanDao refundplanDao) {
		this.refundplanDao = refundplanDao;
	}

	@Override
	public Pager<Refundplan> selectRefundplanAll(Map<String, Object> map) {
		List<Refundplan> ct = refundplanDao.selectRefundplanAll(map);		
		int count = ct.size();
		int initiate = (int) map.get("commence");
		int pageIndex = (int) map.get("pageIndex");
		int pageSize = (int) map.get("pageSize");
		map.put("initiate", initiate);
		List<Refundplan> list = refundplanDao.selectRefundplanAll(map);
		Pager<Refundplan> page = new Pager<>();
		if (list.size()>0) {
			for (Refundplan refundplan : list) {
				if (refundplan.getLastRepayDate()!=null&&refundplan.getLastRepayDate()!="") {
					refundplan.setLastRepayDate(refundplan.getLastRepayDate().substring(0, refundplan.getLastRepayDate().length() - 2));
				}
			}
	
		}
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		page.setSumCount(count);
		page.setData(list);
		return page;
	}

	@Override
	public int updateRefundplan(Refundplan refundplan) {
		return refundplanDao.updateRefundplan(refundplan);
	}

	
}
