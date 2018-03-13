package com.iu.s4;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestSqlSession extends AbstractTest {
	@Inject
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		assertNotNull(sqlSession);
	}

}
