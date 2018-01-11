package com.lxit.p2p.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lxit.p2p.bean.Refundplan;

@Repository
public interface RefundplanDao {

	public List<Refundplan> selectRefundplanAll(Map<String, Object> map);
	
	public int updateRefundplan(Refundplan refundplan);
}
