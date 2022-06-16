package com.dohwaji.app.bttip.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dohwaji.config.SqlMapConfig;

public class BeautytipMultiTextDao {
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public BeautytipMultiTextDao() {
		sqlsession = sessionf.openSession(true);
	}
	
	
	public boolean insertMultiContents(BeautytipMultiTextBean bmt_bean) {
		boolean check = false;
		if(sqlsession.insert("BeautytipMultiFile.insertBTContents", bmt_bean) == 1) {
			check = true;
		}
		return check;
	}

	public List<BeautytipMultiTextBean> getMultiTextDetail(int bttipnum) {
		List<BeautytipMultiTextBean> MultifilesBeanList = sqlsession.selectList("BeautytipMultiFile.getMultiTextDetail", bttipnum);
		return MultifilesBeanList;
	}
	
	public boolean deleteMultiText(int bttipnum) {
		boolean result = false;
		if(sqlsession.delete("BeautytipMultiFile.deleteMultiText", bttipnum) != 0) {
			result = true;
		}
		return result;
	}

}

