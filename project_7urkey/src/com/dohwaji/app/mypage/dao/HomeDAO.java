package com.dohwaji.app.mypage.dao;

import java.util.ArrayList;
import java.util.List;

import com.dohwaji.app.member.dao.MemberBean;
import com.dohwaji.app.member.dao.MemberDAO;
import com.dohwaji.app.member.dao.MemberFilesDAO;

public class HomeDAO {
   public HomeDAO() {;}
   
   public List<MypageBean> topList() {
      MypageDAO m_dao = new MypageDAO();
      MemberDAO u_dao = new MemberDAO();
      MemberFilesDAO uf_dao = new MemberFilesDAO();
      
      List<Integer> numList = m_dao.getTopFollower();
      List<MypageBean> topInfo = new ArrayList<>();
      
      for(int i : numList) {
         MemberBean info = m_dao.getMemberInfo(i);
         MypageBean temp = new MypageBean();
         temp.setUsernum(i);
         temp.setUserid(info.getUserid());
         temp.setUsername(info.getUsername());
         temp.setFollowernum(info.getFollowernum());
         temp.setUserfileimg(uf_dao.selectFiles(i));
         topInfo.add(temp);
      }
      return topInfo;
   }
}
