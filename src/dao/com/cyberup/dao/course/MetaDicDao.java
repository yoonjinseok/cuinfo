package com.cyberup.dao.course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.course.DataProvider;
import com.cyberup.model.course.History;
import com.cyberup.model.course.MetaDic;
import com.cyberup.model.course.Schedule;

@Repository
public class MetaDicDao extends BaseDAO {
	public List<MetaDic> selectList(String collType)
	{
		Map param = new HashMap();
		param.put("collType", collType);
		
		return queryForList("MetaDicDao.selectList", param);
	}
	
	public int deleteInfo(Integer metadicId)
	{
		return delete("MetaDicDao.deleteInfo", metadicId);
	}

	public int updateInfo(MetaDic metaDic)
	{
		return update("MetaDicDao.updateInfo", metaDic);
	}

	public Integer insertInfo(MetaDic metaDic)
	{
		Integer key = (Integer)insert("MetaDicDao.insertInfo", metaDic);
		metaDic.setMetadicId(key);
		
		return key;
	}

	public MetaDic selectInfo(Integer metadicId)
	{
		return (MetaDic)queryForObject("MetaDicDao.selectInfo", metadicId);
	}
}
