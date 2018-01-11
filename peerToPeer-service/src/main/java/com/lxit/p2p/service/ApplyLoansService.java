package com.lxit.p2p.service;

import java.util.Map;

import com.lxit.p2p.bean.Applyloans;
import com.lxit.p2p.bean.Pager;

public interface ApplyLoansService {
	/**
	 * 列表查询
	 * @param map
	 * @return
	 */
	public Pager<Applyloans> selectApplyLoansAll(Map<String, Object> map);
	
	/**
	 * 贷款申请详细查询
	 * @param applyLoansId
	 * @return
	 */
	public Applyloans selectApplyLoansOne(int applyLoansId);
	
	/**
	 * 贷款申请审核
	 * @param applyLoans
	 * @return
	 */
	public int updateApplyLoans(Applyloans applyLoans);
	
	public int insertDay(Map<String, Object> map);
	
	/**
	 * 已流标查询
	 * @return
	 */
	public Pager<Applyloans> selectOfftimeApplyloansAll(Map<String, Object> map);
	
}
