package com.sds.icto.emaillist.test;

import java.util.List;

import com.sds.icto.eamillist.dao.EmailListDao;
import com.sds.icto.eamillist.vo.EmailListVo;

public class TestEmailListDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {// 1. Insert 테스트
			testInsert();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void testInsert() throws Exception {
		EmailListVo vo = new EmailListVo();
		vo.setFirstName("BK");
		vo.setLastName("Park");
		vo.setEmail("kkk");

		EmailListDao dao = new EmailListDao();
		dao.insert(vo);
	}
	
	public static void testFetchList() throws Exception{
		EmailListDao dao=new EmailListDao();
		List<EmailListVo> list=dao.fetchList();
		
		for(EmailListVo vo:list){
			System.out.println(vo.getNo()+":"+vo.getFirstName()+":"+vo.getLastName()+":"+vo.getEmail());
		}
		
	}
	
	
}
