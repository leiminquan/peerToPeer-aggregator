package com.lxit.p2p.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lxit.p2p.bean.Notice;
import com.lxit.p2p.bean.Pager;
import com.lxit.p2p.service.NoticeService;

@RestController
@ComponentScan(basePackages = { "com.lxit.p2p.service" })
public class NoticeAction {
	@Resource
	private NoticeService noticeService;

	public NoticeService getNoticeService() {
		return noticeService;
	}

	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	@RequestMapping(value = "/noticePageQuery")
	public Pager<Notice> noticePageQuery(int pageIndex, int pageSize, int noticeState, String noticeText,
			String noticeBegin, String noticeEnd) {
		Map<String, Object> map = new HashMap<String, Object>();

		int initiate = (pageIndex - 1) * pageSize;
		map.put("state", noticeState);
		map.put("headline", noticeText);
		map.put("issueTime", noticeBegin);
		map.put("finishTime", noticeEnd);
		map.put("pageSize", pageSize);
		map.put("pageIndex", pageIndex);
		map.put("commence", initiate);
		Pager<Notice> page = noticeService.selectNoticeAll(map);
		return page;
	}
	
	@RequestMapping("/insertNotice")
	public int insertNotice(@RequestBody Notice notice) {
		notice.setState(1);
		notice.setCreationor(1);
		return noticeService.insertNotice(notice);
	}
	
	@RequestMapping("/deleteNotice")
	public int deleteNotice(String ids) {
		int count = 0;
		String[] idList = ids.split(",");
		for (String string : idList) {
			Notice f = new Notice();
			f.setNoticeId(Integer.parseInt(string));
			f.setState(2);
			f.setModifier(2);
			count = noticeService.deleteNotice(f);
			if (count == 0) {
				break;
			}
		}	
		return count;
	}
	
	@RequestMapping("/updateNotice")
	public int updateNotice(@RequestBody Notice notice) {
		notice.setModifier(2);
		return noticeService.updateNotice(notice);
	}
	
	@RequestMapping("/selectNoticeOne")
	public Notice selectNoticeOne(int noticeId) {
		return noticeService.selectNoticeOne(noticeId);
	}

}
