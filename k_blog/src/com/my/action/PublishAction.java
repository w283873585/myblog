package com.my.action;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.db.StaticFactory;
import com.my.model.Article;
import com.my.util.MapUtil;

@Controller
@RequestMapping("/publish")
public class PublishAction {
	
	@RequestMapping("/doPublish")
	public String publish(Article article) {
		SqlSession sqlSession = StaticFactory.getSqlSession();
		try {
			
			
//			String[] arr = {"username", "password"};
//			int result = sqlSession.selectOne("login.checkLogin", MapUtil.put(arr, username, password));
//			if (result == 1) {
//				System.out.println("you successed");
//				return "../../index";
//			} else {
//				System.out.println("you failed");
//				return "login/signIn";
//			}
			return null;
		} finally {
			sqlSession.close();
		}
	}
}
