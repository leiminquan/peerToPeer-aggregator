package com.lxit.p2p.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lxit.p2p.bean.Investment;

@Repository
public interface InvestmentDao {
	
	public List<Investment> selectInvestmentAll(int applyLoansId); 
	
}
