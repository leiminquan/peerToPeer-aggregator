package com.lxit.p2p.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lxit.p2p.bean.Foreshow;
/**
 * 预告表
 * @author lmq
 *
 */
@Repository
public interface ForeshowDao {
	/**
	 * 插入预告
	 * @param foreshow
	 * @return
	 */
	public int insertForeshow(Foreshow foreshow);
	/**
	 * 修改预告
	 * @param foreshow
	 * @return
	 */
	public int updateForeshow(Foreshow foreshow);
	
	/**
	 * 删除预告（逻辑删除，将其状态改成已失效）
	 * @param foreshowId
	 * @return
	 */
	public int deleteForeshow(Foreshow foreshow);
	/**
	 * 预告管理中的页面显示，可模糊查询
	 * @param map
	 * @return
	 */
	public List<Foreshow> selectForeshowAll(Map<String, Object> map);
	/**
	 * 查询预告的详细内容
	 * @param foreshowId
	 * @return
	 */
	public Foreshow selectForeshowOne(int foreshowId);
			
}
