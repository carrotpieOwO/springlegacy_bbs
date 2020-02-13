package com.carrot.bbs;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.carrot.bbs.dto.BoardVO;
import com.carrot.bbs.mapper.BoardMapper;

@RunWith(SpringJUnit4ClassRunner.class)
//junit: 테스트하는 애
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
//root-context 의 설정을 테스트할거다. 이게 되야 junit을 쓸 수 있는 상태가된다.
public class DBTest {

	@Inject // 바로주입 
	private SqlSessionFactory sqlFactory;
	
	@Inject
	private BoardMapper mapper;
	
	@Test //얘가 테스트라는걸 알려줌
	public void testFactory() {
		System.out.println(">>>> sqlFactory:"+sqlFactory);
	}
	
	@Test
	public void testSession() throws Exception{
		try (SqlSession session = sqlFactory.openSession()){
				System.out.println(">>>> session : "+session+"\n");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetList() {
		List<BoardVO> list = mapper.getList();
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	
	
}
