package com.lxit.p2p.dao;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.lxit.p2p.bean.Applyloans;

@Repository
public interface ApplyLoansDao {
	/**
	 * 列表查询
	 * @param map
	 * @return
	 */
	public List<Applyloans> selectApplyLoansAll(Map<String, Object> map);
	
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
	public List<Applyloans> selectOfftimeApplyloansAll(Map<String, Object> map);

}
