package com.iu.qna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QnaDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private String namespace="QnaMapper.";

	public int insert(QnaDTO qnaDTO) throws Exception{
		return sqlSession.insert(namespace+"insert", qnaDTO);
		
	}
	public int update(QnaDTO qnaDTO) throws Exception{
		return sqlSession.update(namespace+"update", qnaDTO);
	}
	public int delete(int num) throws Exception{
		return sqlSession.delete(namespace+"delete", num);
	}
	public QnaDTO selectOne(int num) throws Exception{
		return sqlSession.selectOne(namespace+"selectOne", num);
	}
	public List<QnaDTO> selectList(int startRow,int lastRow) throws Exception{
		Map<String, Integer> map=new HashMap<>();
		map.put("startRow", startRow);
		map.put("lastRow", lastRow);
		return sqlSession.selectList(namespace+"selectList", map);
	}
	public int reply(QnaDTO qnaDTO,QnaDTO parent) throws Exception{
		sqlSession.update(namespace+"replyUpdate", parent);
		Map<String, QnaDTO> map=new HashMap<>();
		map.put("parent", parent);
		map.put("qnaDTO", qnaDTO);
		return sqlSession.insert(namespace+"replyInsert", map);
	}
	
}
