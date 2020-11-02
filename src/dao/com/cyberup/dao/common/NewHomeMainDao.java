package com.cyberup.dao.common;

import com.cyberup.framework.dao.NewBaseDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class NewHomeMainDao extends NewBaseDAO {
	
	//뉴스목록
	public List selectAdminCount(){
		return queryForList("NewHomeMainDao.selectAdminCount");
	}

}
