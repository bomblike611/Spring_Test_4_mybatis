package com.iu.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO {

	@Inject
	private SqlSession sqlSession;
	private String namespace="NoticeMapper.";//여러가지 mapper들중에서 무슨 mapper를 사용할 것인지 설정
	
	public NoticeDTO selectOne(int num) throws Exception{
		return sqlSession.selectOne(namespace+"selectOne", num);//namespace+id값,파라미터값(딱 1개만 들어감)
	}
	
	public int insert(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.insert(namespace+"insert", noticeDTO);
	}
	
	public int delete(int num) throws Exception{
		return sqlSession.delete(namespace+"delete", num);
	}
	public int update(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.update(namespace+"update", noticeDTO);
	}
	public List<NoticeDTO> selectList(int startRow,int lastRow) throws Exception{
		NoticeDTO n1=new NoticeDTO();
		NoticeDTO n2=new NoticeDTO();
		n1.setNum(startRow);
		n2.setNum(lastRow);
		Map<String,NoticeDTO> map=new HashMap<>();
		map.put("startRow", n1);
		map.put("lastRow", n2);
		return sqlSession.selectList(namespace+"selectList",map);
	}
	
	
/*	public List<NoticeDTO> selectList() throws Exception{
		List<NoticeDTO> ar=new ArrayList<NoticeDTO>();
		Connection con=DBConnector.getConnect();
		
		String sql="select * from (select rownum R,N.* from (select * from notice order by num desc) N)"
				+ " where R between 1 and 10";
		PreparedStatement st=con.prepareStatement(sql);
		ResultSet rs=st.executeQuery();
		NoticeDTO noticeDTO=null;
		while(rs.next()){
			noticeDTO=new NoticeDTO();
			noticeDTO.setNum(rs.getInt("num"));
			
			noticeDTO.setTitle(rs.getString("title"));
			noticeDTO.setWriter(rs.getString("writer"));
			noticeDTO.setContents(rs.getString("contents"));
			noticeDTO.setHit(rs.getInt("hit"));
			noticeDTO.setReg_date(rs.getString("reg_date"));
			ar.add(noticeDTO);
		}
		DBConnector.disConnect(rs, st, con);
		return ar;
	}
	
	public int insert(NoticeDTO noticeDTO) throws Exception{
		Connection con=DBConnector.getConnect();
		
		String sql="insert into notice values (board_seq.nextval,?,?,?,sysdate,0)";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1, noticeDTO.getTitle());
		st.setString(2, noticeDTO.getWriter());
		st.setString(3, noticeDTO.getContents());
		
		int result=st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;
		
	}*/
	
	
/*	public int delete(int num) throws Exception{
		Connection con=DBConnector.getConnect();
		String sql="delete notice where num=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1, num);
		
		int result=st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
	
	public int update(NoticeDTO noticeDTO) throws Exception{
		Connection con=DBConnector.getConnect();
		String sql="update notice set title=?,contents=? where num=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1, noticeDTO.getTitle());
		st.setString(2, noticeDTO.getContents());
		st.setInt(3, noticeDTO.getNum());
		int result=st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
	*/
}
