package com.lxit.p2p.service;


import java.util.Map;

import com.lxit.p2p.bean.Pager;
import com.lxit.p2p.bean.Refundplan;

public interface RefundplanService {
	/**
	 * 还款逾期
	 * @return
	 */
	public Pager<Refundplan> selectRefundplanAll(Map<String, Object> map);
	
	/**
	 * 修改还款逾期
	 * @param refundplan
	 * @return
	 */
	public int updateRefundplan(Refundplan refundplan);
}
