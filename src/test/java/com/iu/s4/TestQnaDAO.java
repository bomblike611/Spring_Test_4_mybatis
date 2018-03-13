package com.iu.s4;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.qna.QnaDAO;
import com.iu.qna.QnaDTO;

public class TestQnaDAO extends AbstractTest {

	@Inject
	private QnaDAO QnaDAO;
	
	@Test
	public void test() {
		//////reply//////////////////////////////
		QnaDTO qnaDTO=new QnaDTO();
		qnaDTO.setTitle("ppp11");
		qnaDTO.setWriter("f");
		qnaDTO.setContents("ppp11");
		QnaDTO qnaDTO2=null;
		try {
			qnaDTO2=QnaDAO.selectOne(81);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			int result=QnaDAO.reply(qnaDTO, qnaDTO2);
			assertEquals(1, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		////////////////selectList/////////////////////
		/*try {
			List<QnaDTO> ar=QnaDAO.selectList(5, 8);
			for(QnaDTO qnaDTO:ar){
				System.out.println(qnaDTO.getContents());
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		
		/////////////////selectOne//////////////////
		/*try {
			QnaDTO qnaDTO=QnaDAO.selectOne(81);
			assertNotNull(qnaDTO);
			System.out.println(qnaDTO.getTitle());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		///////delete//////////////////
		/*try {
			int result=QnaDAO.delete(101);
			assertEquals(1, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		////////////update///////////
		/*QnaDTO qnaDTO=new QnaDTO();
		qnaDTO.setTitle("ppp11");
		qnaDTO.setWriter("f");
		qnaDTO.setContents("ppp11");
		qnaDTO.setNum(101);
		try {
			int result=QnaDAO.update(qnaDTO);
			assertNotEquals(0, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/////////////insert////////////////
		/*try {
			int result=QnaDAO.insert(qnaDTO);
			assertNotEquals(0, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

}
