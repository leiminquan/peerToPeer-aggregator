package com.lxit.p2p.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lxit.p2p.bean.Product;

@Repository
public interface ProductDao {
	
	/**
	 * 产品列表查询
	 * @param map
	 * @return
	 */
	public List<Product> selectProductAll(Map<String, Object> map);
	
	/**
	 * 产品发布
	 * @param product
	 * @return
	 */
	public int insertProduct(Product product);
	
	/**
	 * 主动修改
	 * @param product
	 * @return
	 */
	public int updateProduct(Product product);
	
	/**
	 * 定时任务修改
	 * @return
	 */
	public int updateProductAll(Map<String,Object> map);
	/***
	 * 产品详细查询
	 * @param productId
	 * @return
	 */
	public Product selectProductOne(int productId);
	/**
	 * 根据选择返回相应得模板信息
	 * @param name
	 * @return
	 */
	public Product selectProductName(Map<String,Object> map);
}
