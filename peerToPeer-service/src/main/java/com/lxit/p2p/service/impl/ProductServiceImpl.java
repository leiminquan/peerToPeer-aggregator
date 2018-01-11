package com.lxit.p2p.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Service;
import com.lxit.p2p.bean.Pager;
import com.lxit.p2p.bean.Product;
import com.lxit.p2p.dao.ProductDao;
import com.lxit.p2p.service.ProductService;

@Service
@MapperScan("com.lxit.p2p.dao")
public class ProductServiceImpl implements ProductService{

	@Resource
	private ProductDao productDao;
	
	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public Pager<Product> selectProductAll(Map<String, Object> map) {
		List<Product> ct = productDao.selectProductAll(map);		
		int count = ct.size();
		int initiate = (int) map.get("commence");
		int pageIndex = (int) map.get("pageIndex");
		int pageSize = (int) map.get("pageSize");
		map.put("initiate", initiate);
		List<Product> list = productDao.selectProductAll(map);
		if (list.size() > 0) {
			for (Product product : list) {
				if (product.getModificationTime()!=null&&product.getModificationTime()!="") {
					product.setModificationTime(product.getModificationTime().substring(0, product.getModificationTime().length() - 2));
				}
				if (product.getCreationTime()!=null&&product.getCreationTime()!="") {
					product.setCreationTime(product.getCreationTime().substring(0, product.getCreationTime().length() - 2));
				}
				if (product.getStartTime()!=null&&product.getStartTime()!="") {
					product.setStartTime(product.getStartTime().substring(0, product.getStartTime().length() - 2));
				}
				if (product.getEndTime()!=null&&product.getEndTime()!="") {
					product.setEndTime(product.getEndTime().substring(0, product.getEndTime().length() - 2));
				}
			}
		}
		Pager<Product> page = new Pager<>();
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		page.setSumCount(count);
		page.setData(list);
		return page;
	}

	@Override
	public int insertProduct(Product product) {
		return productDao.insertProduct(product);
	}

	@Override
	public int updateProduct(Product product) {
		return productDao.updateProduct(product);
	}

	@Override
	public int updateProductAll(Map<String, Object> map) {
		return productDao.updateProductAll(map);
	}

	@Override
	public Product selectProductOne(int productId) {
		Product product = productDao.selectProductOne(productId);
		if (product.getModificationTime()!=null&&product.getModificationTime()!="") {
			product.setModificationTime(product.getModificationTime().substring(0, product.getModificationTime().length() - 2));
		}
		if (product.getCreationTime()!=null&&product.getCreationTime()!="") {
			product.setCreationTime(product.getCreationTime().substring(0, product.getCreationTime().length() - 2));
		}
		if (product.getStartTime()!=null&&product.getStartTime()!="") {
			product.setStartTime(product.getStartTime().substring(0, product.getStartTime().length() - 2));
		}
		if (product.getEndTime()!=null&&product.getEndTime()!="") {
			product.setEndTime(product.getEndTime().substring(0, product.getEndTime().length() - 2));
		}
		return product;
	}

	@Override
	public Product selectProductName(Map<String, Object> map) {
		Product product = productDao.selectProductName(map);
		if (product.getModificationTime()!=null&&product.getModificationTime()!="") {
			product.setModificationTime(product.getModificationTime().substring(0, product.getModificationTime().length() - 2));
		}
		if (product.getCreationTime()!=null&&product.getCreationTime()!="") {
			product.setCreationTime(product.getCreationTime().substring(0, product.getCreationTime().length() - 2));
		}
		if (product.getStartTime()!=null&&product.getStartTime()!="") {
			product.setStartTime(product.getStartTime().substring(0, product.getStartTime().length() - 2));
		}
		if (product.getEndTime()!=null&&product.getEndTime()!="") {
			product.setEndTime(product.getEndTime().substring(0, product.getEndTime().length() - 2));
		}
		return product;
	}

}
