package com.lxit.p2p.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lxit.p2p.bean.Pager;
import com.lxit.p2p.bean.Product;
import com.lxit.p2p.service.ProductService;

@RestController
@ComponentScan(basePackages = { "com.lxit.p2p.service" })
public class ProductAction {
	@Resource
	private ProductService productService;

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * 产品列表查询
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/selectProductAll")
	public Pager<Product> selectProductAll(int pageIndex, int pageSize, String productName, String productState,
			String productStartTime, String productEndTime) {
		Map<String, Object> map = new HashMap<String, Object>();
		int initiate = (pageIndex - 1) * pageSize;
		map.put("name", productName);
		map.put("state", productState);
		map.put("startTime", productStartTime);
		map.put("endTime", productEndTime);
		map.put("pageSize", pageSize);
		map.put("pageIndex", pageIndex);
		map.put("commence", initiate);
		Pager<Product> page = productService.selectProductAll(map);
		return page;
	}

	/**
	 * 产品发布
	 * 
	 * @param product
	 * @return
	 */
	@RequestMapping("/insertProduct")
	public int insertProduct(@RequestBody Product product) {
		product.setCreationor(1);
		return productService.insertProduct(product);
	}

	/**
	 * 主动修改
	 * 
	 * @param product
	 * @return
	 */	
	@RequestMapping("/updateProduct")
	public int updateProduct(@RequestBody Product product) {
		product.setModifier(2);
		return productService.updateProduct(product);
	}

	/**
	 * 定时任务修改
	 * 
	 * @return
	 */
	@RequestMapping("/updateProductAll")
	public int updateProductAll(Map<String, Object> map) {
		return 0;
	}

	/***
	 * 产品详细查询
	 * 
	 * @param productId
	 * @return
	 */
	@RequestMapping("/selectProductOne")
	public Product selectProductOne(int productId) {
		return productService.selectProductOne(productId);
	}

	/**
	 * 根据选择返回相应得模板信息
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping("/selectProductName")
	public Product selectProductName(String productName) {
		Map<String, Object> map = new HashMap<>();
		map.put("name", productName);
		return productService.selectProductName(map);
	}

}
