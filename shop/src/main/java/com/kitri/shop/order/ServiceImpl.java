package com.kitri.shop.order;

import java.util.List;
import java.util.Map;

@Component("orderService")
public class ServiceImpl implements Service {
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	private OrderMapper orderMapper;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public Order getOrder(int num) {
		orderMapper = sqlSession.getMapper(OrderMapper.class);
		return orderMapper.select(num);
	}

	@Override
	public List getOrderAll(String consumer_id, int result) {
		orderMapper = sqlSession.getMapper(OrderMapper.class);
		Map map = new HashMap();
		map.put("consumer_id", consumer_id);
		map.put("result", result);
		return orderMapper.selectAll(map);
	}
	
	@Override
	public void editResult(int num, int result) {
		orderMapper = sqlSession.getMapper(OrderMapper.class);
		Map map = new HashMap();
		map.put("num", num);
		map.put("result", result);
		orderMapper.update(map);
	}

	@Override
	public void delOrder(int num) {
		orderMapper = sqlSession.getMapper(OrderMapper.class);
		orderMapper.delete(num);
	}
	
	@Override
	public void addOrder(Order o) {
		
	}

}
