package com.lxit.p2p.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Service;

import com.lxit.p2p.bean.RealTimeFinancial;
import com.lxit.p2p.dao.RealTimeFinancialDao;
import com.lxit.p2p.service.RealTimeFinancialService;

@Service
@MapperScan("com.lxit.p2p.dao")
public class RealTimeFinancialServiceImpl implements RealTimeFinancialService {
	
	@Resource
	private RealTimeFinancialDao realTimeFinancialDao;
	
	public RealTimeFinancialDao getRealTimeFinancialDao() {
		return realTimeFinancialDao;
	}

	public void setRealTimeFinancialDao(RealTimeFinancialDao realTimeFinancialDao) {
		this.realTimeFinancialDao = realTimeFinancialDao;
	}

	@Override
	public RealTimeFinancial selectFinancialOne() {
		return realTimeFinancialDao.selectFinancialOne();
	}

	@Override
	public List<RealTimeFinancial> selectLoanBalanceAll() {
		return realTimeFinancialDao.selectLoanBalanceAll();
	}

	@Override
	public List<RealTimeFinancial> selectSecondAll() {
		return realTimeFinancialDao.selectSecondAll();
	}

	@Override
	public List<RealTimeFinancial> selectDailyTurnoverAll() {
		return realTimeFinancialDao.selectDailyTurnoverAll();
	}

	@Override
	public List<RealTimeFinancial> selectPersonNumberAll() {
		return realTimeFinancialDao.selectPersonNumberAll();
	}

}
