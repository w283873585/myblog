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
	// mybatis session factoty
	private static SqlSessionFactory factory; 
	private StaticFactory() {}
	
	
	public static void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		if (factory == null && sqlSessionFactory != null) {
			factory=sqlSessionFactory;
		}
	}
	/**
	 * 鑾峰彇SqlSession 榛樿闈炶嚜鍔ㄦ彁浜�
	 * 缁撳熬 close(); 鍓嶄竴瀹氳sqlSession.commit();
	 * @return
	 */
	public static SqlSession getSqlSession(){
		if(StaticFactory.factory==null){
			createFactory();
			if(factory==null) return null;
		}
		return factory.openSession();
	}
	
	/**
	 *  鑾峰彇SqlSession  conn 鎻愪氦绫诲瀷
	 * @param autocommit 
	 * @return
	 */
	public static SqlSession getSqlSession(boolean autocommit){
		if (StaticFactory.factory == null) { 
			createFactory();
			if (factory == null) return null;
		}
		return factory.openSession(autocommit);
	}
	
	public static Configuration getConfiguration(){
		return factory.getConfiguration();
	}
	
	private synchronized static void createFactory() {
		if(factory!=null) return ;
		System.out.println("---------start----mybatis");
		InputStream inputStream;
		try {
			// System.getProperty("admin.myouth.root");
			String path = System.getProperty("admin.myouth.root");
			if (path != null && !"".equals(path)) {
				inputStream = new BufferedInputStream(
						new FileInputStream(path + "WEB-INF/mybatis-config.xml"));
			} else {
				String file = "mybatis-config.xml";
				inputStream = Resources.getResourceAsStream(file);
			}
			factory = new SqlSessionFactoryBuilder().build(inputStream);
			if(factory == null) {
				System.out.println("-------mybatis 鍒濆鍖栧け璐");
			} else {
				System.out.println("-------mybatis 鍒濆鍖栨垚鍔�");
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("-------mybatis 閰嶇疆鏂囦欢涓嶅瓨鍦�");
		}
		return;
	}
}
