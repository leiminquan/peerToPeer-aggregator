package com.lxit.p2p.service;

import java.util.Map;

import com.lxit.p2p.bean.Pager;
import com.lxit.p2p.bean.Product;

public interface ProductService {
	/**
	 * 产品列表查询
	 * @param map
	 * @return
	 */
	public Pager<Product> selectProductAll(Map<String, Object> map);
	
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
