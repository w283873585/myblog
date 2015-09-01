package com.my.db;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class StaticFactory {

	private static SqlSessionFactory factory; 
	private StaticFactory() {}
	
	
	public static void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		if (factory == null && sqlSessionFactory != null) {
			factory = sqlSessionFactory;
		}
	}
	
	
	public static SqlSession getSqlSession() {
		if (StaticFactory.factory == null) {
			createFactory();
			if (factory == null) return null;
		}
		return factory.openSession();
	}
	
	
	public static SqlSession getSqlSession(boolean autocommit) {
		if (StaticFactory.factory == null) { 
			createFactory();
			if (factory == null) return null;
		}
		return factory.openSession(autocommit);
	}
	
	
	public static Configuration getConfiguration() {
		return factory.getConfiguration();
	}
	
	
	private synchronized static void createFactory() {
		if (factory != null) return;
		InputStream inputStream;
		try {
			String path = System.getProperty("admin.myouth.root");
			if (path != null && !"".equals(path)) {
				inputStream = new BufferedInputStream(
						new FileInputStream(path + "WEB-INF/mybatis-config.xml"));
			} else {
				String file = "mybatis-config.xml";
				inputStream = Resources.getResourceAsStream(file);
			}
			factory = new SqlSessionFactoryBuilder().build(inputStream);
			if (factory == null) {
				System.out.println("-------mybatis 工厂生成失败");
			} else {
				System.out.println("-------mybatis 生成成功");
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("-------mybatis 工厂生成异常");
		}
		return;
	}
}
