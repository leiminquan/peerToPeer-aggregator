package com.lxit.p2p.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lxit.p2p.bean.RealTimeFinancial;
import com.lxit.p2p.service.RealTimeFinancialService;

@RestController
@ComponentScan(basePackages = { "com.lxit.p2p.service" })
public class realTimeFinancialAction {
	@Resource
	private RealTimeFinancialService realTimeFinancialService;

	public RealTimeFinancialService getRealTimeFinancialService() {
		return realTimeFinancialService;
	}

	public void setRealTimeFinancialService(RealTimeFinancialService realTimeFinancialService) {
		this.realTimeFinancialService = realTimeFinancialService;
	}
	
	@RequestMapping("/selectFinancialOne")
	public RealTimeFinancial selectFinancialOne() {
		return realTimeFinancialService.selectFinancialOne();
	}
	
	@RequestMapping("/selectLoanBalanceAll")
	public List<RealTimeFinancial> selectLoanBalanceAll() {
		return realTimeFinancialService.selectLoanBalanceAll();
	}
	@RequestMapping("/selectSecondAll")
	public List<RealTimeFinancial> selectSecondAll() {
		return realTimeFinancialService.selectSecondAll();
	}
	@RequestMapping("/selectDailyTurnoverAll")
	public List<RealTimeFinancial> selectDailyTurnoverAll() {
		return realTimeFinancialService.selectDailyTurnoverAll();
	}
	@RequestMapping("/selectPersonNumberAll")
	public List<RealTimeFinancial> selectPersonNumberAll() {
		return realTimeFinancialService.selectPersonNumberAll();
	}
}
