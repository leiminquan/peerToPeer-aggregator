package com.lxit.p2p.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Service;

import com.lxit.p2p.bean.Applyloans;
import com.lxit.p2p.bean.Investment;
import com.lxit.p2p.bean.Pager;
import com.lxit.p2p.bean.User;
import com.lxit.p2p.dao.ApplyLoansDao;
import com.lxit.p2p.dao.InvestmentDao;
import com.lxit.p2p.dao.UserDao;
import com.lxit.p2p.service.ApplyLoansService;

@Service
@MapperScan("com.lxit.p2p.dao")
public class ApplyLoansServiceImpl implements ApplyLoansService {
	
	@Resource
	private ApplyLoansDao applyLoansDao;
	@Resource
	private UserDao userDao;
	@Resource
	private InvestmentDao investmentDao;

	public ApplyLoansDao getApplyLoansDao() {
		return applyLoansDao;
	}

	public void setApplyLoansDao(ApplyLoansDao applyLoansDao) {
		this.applyLoansDao = applyLoansDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public InvestmentDao getInvestmentDao() {
		return investmentDao;
	}

	public void setInvestmentDao(InvestmentDao investmentDao) {
		this.investmentDao = investmentDao;
	}

	@Override
	public Pager<Applyloans> selectApplyLoansAll(Map<String, Object> map) {
		List<Applyloans> ct = applyLoansDao.selectApplyLoansAll(map);		
		int count = ct.size();
		int initiate = (int) map.get("commence");
		int pageIndex = (int) map.get("pageIndex");
		int pageSize = (int) map.get("pageSize");
		map.put("initiate", initiate);
		List<Applyloans> list = applyLoansDao.selectApplyLoansAll(map);
		if (list.size() > 0) {
			for (Applyloans applyloans : list) {
				if (applyloans.getModificationTime()!=null&&applyloans.getModificationTime()!="") {
					applyloans.setModificationTime(applyloans.getModificationTime().substring(0, applyloans.getModificationTime().length() - 2));
				}
				if (applyloans.getCreationTime()!=null&&applyloans.getCreationTime()!="") {
					applyloans.setCreationTime(applyloans.getCreationTime().substring(0, applyloans.getCreationTime().length() - 2));
				}
				if (applyloans.getTime()!=null&&applyloans.getTime()!="") {
					applyloans.setTime(applyloans.getTime().substring(0, applyloans.getTime().length() - 2));
				}
				if (applyloans.getStartTime()!=null&&applyloans.getStartTime()!="") {
					applyloans.setStartTime(applyloans.getStartTime().substring(0, applyloans.getStartTime().length() - 2));
				}
				if (applyloans.getFullTime()!=null&&applyloans.getFullTime()!="") {
					applyloans.setFullTime(applyloans.getFullTime().substring(0, applyloans.getFullTime().length() - 2));
				}
				if (applyloans.getLoanTime()!=null&&applyloans.getLoanTime()!="") {
					applyloans.setLoanTime(applyloans.getLoanTime().substring(0, applyloans.getLoanTime().length() - 2));
				}
			}
		}
		Pager<Applyloans> page = new Pager<>();
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		page.setSumCount(count);
		page.setData(list);
		return page;
	}

	@Override
	public Applyloans selectApplyLoansOne(int applyLoansId) {
		Applyloans applyloans = applyLoansDao.selectApplyLoansOne(applyLoansId);
		if (applyloans.getModificationTime()!=null&&applyloans.getModificationTime()!="") {
			applyloans.setModificationTime(applyloans.getModificationTime().substring(0, applyloans.getModificationTime().length() - 2));
		}
		if (applyloans.getCreationTime()!=null&&applyloans.getCreationTime()!="") {
			applyloans.setCreationTime(applyloans.getCreationTime().substring(0, applyloans.getCreationTime().length() - 2));
		}
		if (applyloans.getTime()!=null&&applyloans.getTime()!="") {
			applyloans.setTime(applyloans.getTime().substring(0, applyloans.getTime().length() - 2));
		}
		if (applyloans.getStartTime()!=null&&applyloans.getStartTime()!="") {
			applyloans.setStartTime(applyloans.getStartTime().substring(0, applyloans.getStartTime().length() - 2));
		}
		if (applyloans.getFullTime()!=null&&applyloans.getFullTime()!="") {
			applyloans.setFullTime(applyloans.getFullTime().substring(0, applyloans.getFullTime().length() - 2));
		}
		if (applyloans.getLoanTime()!=null&&applyloans.getLoanTime()!="") {
			applyloans.setLoanTime(applyloans.getLoanTime().substring(0, applyloans.getLoanTime().length() - 2));
		}
		return applyloans;
	}

	@Override
	public int updateApplyLoans(Applyloans applyLoans) {
		int count = applyLoansDao.updateApplyLoans(applyLoans);
		if ("已流标".equals(applyLoans.getState())) {
			List<Investment> investmentList = investmentDao.selectInvestmentAll(applyLoans.getApplyLoansId());
			if (investmentList.size()>0) {
				for (Investment investment : investmentList) {
					User user = new User();
					user.setUserId(investment.getUser().getUserId());
					user.setMoney(investment.getMoney());
					count = userDao.updateUserMoney(user);
				}
			}
		}
		return count;
	}

	@Override
	public int insertDay(Map<String, Object> map) {
		return applyLoansDao.insertDay(map);
	}

	@Override
	public Pager<Applyloans> selectOfftimeApplyloansAll(Map<String, Object> map) {
		List<Applyloans> ct = applyLoansDao.selectOfftimeApplyloansAll(map);		
		int count = ct.size();
		int initiate = (int) map.get("commence");
		int pageIndex = (int) map.get("pageIndex");
		int pageSize = (int) map.get("pageSize");
		map.put("initiate", initiate);
		List<Applyloans> list = applyLoansDao.selectOfftimeApplyloansAll(map);
		if (list.size() > 0) {
			for (Applyloans applyloans : list) {
				if (applyloans.getStartTime()!=null&&applyloans.getStartTime()!="") {
					applyloans.setStartTime(applyloans.getStartTime().substring(0, applyloans.getStartTime().length() - 2));
				}
				if (applyloans.getOfftime()!=null&&applyloans.getOfftime()!="") {
					applyloans.setOfftime(applyloans.getOfftime().substring(0, applyloans.getOfftime().length() - 2));
				}
				
			}
		}
		Pager<Applyloans> page = new Pager<>();
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		page.setSumCount(count);
		page.setData(list);
		return page;
	}
	
}
