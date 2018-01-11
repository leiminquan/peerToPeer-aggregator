package com.lxit.p2p.controller;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lxit.p2p.bean.Applyloans;
import com.lxit.p2p.bean.Pager;
import com.lxit.p2p.service.ApplyLoansService;

@RestController
@ComponentScan(basePackages={"com.lxit.p2p.service"})
public class ApplyLoansAction {
	
	@Resource
	private ApplyLoansService applyLoansService;

	public ApplyLoansService getApplyLoansService() {
		return applyLoansService;
	}

	public void setApplyLoansService(ApplyLoansService applyLoansService) {
		this.applyLoansService = applyLoansService;
	}
	
	@RequestMapping(value = "/applyLoansPageQuery")
	public Pager<Applyloans> applyLoansPageQuery(int pageIndex, int pageSize, String applyLoansType,
			String applyLoansBegin, String applyLoansEnd,String state) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		int initiate = (pageIndex - 1) * pageSize;
		map.put("state", state);
		map.put("applyLoansType", applyLoansType);
		map.put("applyLoansBegin", applyLoansBegin);
		map.put("applyLoansEnd", applyLoansEnd);
		map.put("pageSize", pageSize);
		map.put("pageIndex", pageIndex);
		map.put("commence", initiate);
		Pager<Applyloans> page = applyLoansService.selectApplyLoansAll(map);
		return page;
	}
	
	@RequestMapping("/updateApplyLoans")
	public int updateApplyLoans(String ids,String state) {
		int count = 0;
		String[] idList = ids.split(",");
		for (String string : idList) {
			Applyloans applyLoans = new Applyloans();
			applyLoans.setApplyLoansId(Integer.parseInt(string));
			applyLoans.setState(state);
			applyLoans.setModifier(2);
			count = applyLoansService.updateApplyLoans(applyLoans);
			if (count == 0) {
				break;
			}
		}	
		return count;
	}
	
	
	@RequestMapping("/selectApplyLoansOne")
	public Applyloans selectApplyLoansOne(int applyLoansId) {
		return applyLoansService.selectApplyLoansOne(applyLoansId);
	}
	@RequestMapping("/insertDay")
	public boolean insertDay() {
		boolean flag = false;
		Map<String, Object> map = new HashMap<>();
		for (int i = 1; i <= 5; i++) {
			int count = i * 30;
			map.put("count", count);
			flag = applyLoansService.insertDay(map)>0;
		}
		return flag;
	}
	@RequestMapping(value = "/selectOfftimeApplyloansAll")
	public Pager<Applyloans> selectOfftimeApplyloansAll(int pageIndex, int pageSize, String refundplanType
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		int initiate = (pageIndex - 1) * pageSize;
		map.put("refundplanType", refundplanType);
		map.put("pageSize", pageSize);
		map.put("pageIndex", pageIndex);
		map.put("commence", initiate);
		Pager<Applyloans> page = applyLoansService.selectOfftimeApplyloansAll(map);
		return page;
	}
}
