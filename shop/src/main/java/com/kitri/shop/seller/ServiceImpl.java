package com.kitri.shop.seller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("sellerService")
public class ServiceImpl implements Service {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	private ProductMapper productMapper;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void addProduct(Product p) {
		productMapper = sqlSession.getMapper(ProductMapper.class);
		productMapper.insert(p);
	}

	@Override
	public Product getProductByNum(int num) {
		productMapper = sqlSession.getMapper(ProductMapper.class);
		return productMapper.selectByNum(num);
	}

	@Override
	public List getProductByName(String name) {
		productMapper = sqlSession.getMapper(ProductMapper.class);
		return null;
	}

	@Override
	public List getProductByPrice(int min, int max) {
		productMapper = sqlSession.getMapper(ProductMapper.class);
		Map<K, V> map = new HashMap();
		map.put("min", min);
		map.put("max", max);
		return productMapper.selectByPrice(map);
	}

	@Override
	public List getProductBySellerId(String seller_id) {
		productMapper = sqlSession.getMapper(ProductMapper.class);
		return productMapper.selectBySellerId(seller_id);
	}

	@Override
	public List getProductByC1(int c1) {
		productMapper = sqlSession.getMapper(ProductMapper.class);
		return productMapper.selectByC1(c1);
	}

	@Override
	public List getProductByC2(int c2) {
		productMapper = sqlSession.getMapper(ProductMapper.class);
		return productMapper.selectByC2(c2);
	}

	@Override
	public List getProductByC3(int c3) {
		productMapper = sqlSession.getMapper(ProductMapper.class);
		return productMapper.selectByC3(c3);
	}

	@Override
	public List getProductAll() {
		productMapper = sqlSession.getMapper(ProductMapper.class);
		return productMapper.selectAll();
	}

	@Override
	public void editProduct(Product p) {
		productMapper = sqlSession.getMapper(ProductMapper.class);
		productMapper.update(p);
	}

	@Override
	public void delProduct(int num) {
		productMapper = sqlSession.getMapper(ProductMapper.class);
		productMapper.delete(num);
	}

	@Override
	public int getNum() {
		productMapper = sqlSession.getMapper(ProductMapper.class);
		return productMapper.getNum();
	}

}
