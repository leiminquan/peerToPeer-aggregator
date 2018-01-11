package com.lxit.p2p.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lxit.p2p.bean.RealTimeFinancial;

@Repository
public interface RealTimeFinancialDao {
	/**
	 * 实时财务，已完成交易额，已还款总额
	 * @return
	 */
	public RealTimeFinancial selectFinancialOne();
	/**
	 * 实时财务，贷款余额
	 * @return
	 */
	public List<RealTimeFinancial> selectLoanBalanceAll();
	
	/**
	 * 实时财务，平均满标时间
	 * @return
	 */
	public List<RealTimeFinancial> selectSecondAll();
	/**
	 * 实时财务，30天日成交量
	 * @return
	 */
	public List<RealTimeFinancial> selectDailyTurnoverAll();
	/**
	 * 每月贷款人数与投资人数
	 * @return
	 */
	public List<RealTimeFinancial> selectPersonNumberAll();
}
