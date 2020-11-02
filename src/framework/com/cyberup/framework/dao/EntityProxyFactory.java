package com.cyberup.framework.dao;



public interface EntityProxyFactory {
	<T> T createProxy(Class<T> clazz, GenericDao<T> dao, int id);
}
