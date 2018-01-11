package com.lxit.p2p.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lxit.p2p.bean.Notice;

/**
 * 公告表
 * @author lmq
 *
 */
@Repository
public interface NoticeDao {
	/**
	 * 插入公告
	 * @param foreshow
	 * @return
	 */
	public int insertNotice(Notice notice);
	/**
	 * 修改公告
	 * @param foreshow
	 * @return
	 */
	public int updateNotice(Notice notice);
	
	/**
	 * 删除公告（逻辑删除，将其状态改成已失效）
	 * @param foreshowId
	 * @return
	 */
	public int deleteNotice(Notice notice);
	/**
	 * 公告管理中的页面显示，可模糊查询
	 * @param map
	 * @return
	 */
	public List<Notice> selectNoticeAll(Map<String, Object> map);
	/**
	 * 查询公告的详细内容
	 * @param foreshowId
	 * @return
	 */
	public Notice selectNoticeOne(int noticeId);
}
