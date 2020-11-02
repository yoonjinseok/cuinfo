package com.cyberup.framework.dao;

import java.util.List;
import java.util.Map;

public interface GenericDao<T> {
	List<T> selectList(Object... objects);
	
	int selectCount(Object... objects);
	
	T selectInfo(Object... objects);
	
	int insertInfo(T entity);

	int updateInfo(T entity);

	int deleteInfo(Object...objects);
	
	int deleteList(Object...objects);
}
