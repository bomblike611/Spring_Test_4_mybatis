package com.iu.s4;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.notice.NoticeDAO;
import com.iu.notice.NoticeDTO;

public class TestNoticeDAO extends AbstractTest {
	
	@Inject
	private NoticeDAO NoticeDAO;
		
	@Test
	public void test(){
		
		/*try{
		NoticeDTO noticeDTO=NoticeDAO.selectOne(1);
		System.out.println(noticeDTO.getContents());
		assertNotNull(noticeDTO);
		}catch (Exception e) {
			// TODO: handle exception
		}*/
	/*	NoticeDTO noticeDTO=new NoticeDTO();
		noticeDTO.setContents("kkkkkkkkkkkkkkkkkkkkkk");
		noticeDTO.setWriter("rrr");
		noticeDTO.setTitle("k2kk22kk222k2k2k2k2k2");
		try {
			int result=NoticeDAO.insert(noticeDTO);
			assertNotEquals(0, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*try {
			int result=NoticeDAO.delete(281);
			assertNotEquals(0, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		NoticeDTO noticeDTO=new NoticeDTO();
		noticeDTO.setContents("kkkkkkkkkkkkkkkkkkkkkk");
		noticeDTO.setTitle("k2kk22kk222k2k2k2k2k2");
		noticeDTO.setNum(472);
		try {
			int result=NoticeDAO.update(noticeDTO);
			assertNotEquals(0, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		List<NoticeDTO> ar = null;
		try {
			ar = NoticeDAO.selectList(1,4);
			assertNotNull(ar);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(NoticeDTO noticeDTO: ar){
			System.out.println("title : "+noticeDTO.getContents());
		}
		
	}

}
