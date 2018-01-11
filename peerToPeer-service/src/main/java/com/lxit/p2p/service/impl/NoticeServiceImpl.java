package com.lxit.p2p.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Service;
import com.lxit.p2p.bean.Notice;
import com.lxit.p2p.bean.Pager;
import com.lxit.p2p.dao.NoticeDao;
import com.lxit.p2p.service.NoticeService;

@Service
@MapperScan("com.lxit.p2p.dao")
public class NoticeServiceImpl implements NoticeService{

	@Resource
	private NoticeDao noticeDao;
	
	public NoticeDao getNoticeDao() {
		return noticeDao;
	}

	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	@Override
	public int insertNotice(Notice notice) {
		return noticeDao.insertNotice(notice);
	}

	@Override
	public int updateNotice(Notice notice) {
		return noticeDao.updateNotice(notice);
	}

	@Override
	public int deleteNotice(Notice notice) {
		return noticeDao.deleteNotice(notice);
	}

	@Override
	public Pager<Notice> selectNoticeAll(Map<String, Object> map) {
		List<Notice> ct = noticeDao.selectNoticeAll(map);		
		int count = ct.size();
		int initiate = (int) map.get("commence");
		int pageIndex = (int) map.get("pageIndex");
		int pageSize = (int) map.get("pageSize");
		map.put("initiate", initiate);
		List<Notice> list = noticeDao.selectNoticeAll(map);
		if (list.size() > 0) {
			for (Notice notice : list) {
				notice.setIssueTime(notice.getIssueTime().substring(0, notice.getIssueTime().length() - 2));
				notice.setFinishTime(notice.getFinishTime().substring(0, notice.getFinishTime().length() - 2));
				notice.setRegistTime(notice.getRegistTime().substring(0, notice.getRegistTime().length() - 2));
				if (notice.getModificationTime()!=null&&notice.getModificationTime()!="") {
					notice.setModificationTime(notice.getModificationTime().substring(0, notice.getModificationTime().length() - 2));
				}
			}
		}
		Pager<Notice> page = new Pager<>();
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		page.setSumCount(count);
		page.setData(list);
		return page;
	}

	@Override
	public Notice selectNoticeOne(int noticeId) {
		Notice notice =noticeDao.selectNoticeOne(noticeId);
		notice.setIssueTime(notice.getIssueTime().substring(0, notice.getIssueTime().length() - 2));
		notice.setFinishTime(notice.getFinishTime().substring(0, notice.getFinishTime().length() - 2));
		if (notice.getRegistTime()!=null&&notice.getRegistTime()!="") {
			notice.setRegistTime(notice.getRegistTime().substring(0, notice.getRegistTime().length() - 2));
		}
		if (notice.getModificationTime()!=null&&notice.getModificationTime()!="") {
			notice.setModificationTime(notice.getModificationTime().substring(0, notice.getModificationTime().length() - 2));
		}
		return notice;
	}

}
