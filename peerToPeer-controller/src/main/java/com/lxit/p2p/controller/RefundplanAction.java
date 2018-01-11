package com.lxit.p2p.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lxit.p2p.bean.Pager;
import com.lxit.p2p.bean.Refundplan;
import com.lxit.p2p.service.RefundplanService;

@RestController
@ComponentScan(basePackages={"com.lxit.p2p.service"})
public class RefundplanAction {
	@Resource
	private RefundplanService refundplanService;

	public RefundplanService getRefundplanService() {
		return refundplanService;
	}

	public void setRefundplanService(RefundplanService refundplanService) {
		this.refundplanService = refundplanService;
	}
	
	@RequestMapping(value = "/selectRefundplanAll")
	public Pager<Refundplan> selectRefundplanAll(int pageIndex, int pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		int initiate = (pageIndex - 1) * pageSize;
		map.put("pageSize", pageSize);
		map.put("pageIndex", pageIndex);
		map.put("commence", initiate);
		Pager<Refundplan> page = refundplanService.selectRefundplanAll(map);
		return page;
	}
	
	@RequestMapping("/updateRefundplan")
	public int updateRefundplan(String ids,String state) {
		int count = 0;
		String[] idList = ids.split(",");
		for (String string : idList) {
			Refundplan refundplan = new Refundplan();
			refundplan.setRid(Integer.parseInt(string));
			refundplan.setState(state);
			refundplan.setModifier(2);
			count = refundplanService.updateRefundplan(refundplan);
			if (count == 0) {
				break;
			}
		}	
		return count;
	}
	
}
