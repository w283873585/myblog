package com.my.action;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.db.StaticFactory;
import com.my.util.MapUtil;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping("/check")
	public String login(String username, String password) {
		
		SqlSession sqlSession = StaticFactory.getSqlSession();
		try {
			String[] arr = {"username", "password"};
			int result = sqlSession.selectOne("login.checkLogin", MapUtil.put(arr, username, password));
			if (result == 1) {
				System.out.println("you successed");
				return "main";
			} else {
				System.out.println("you failed");
				return null;
			}
		} finally {
			sqlSession.close();
		}
	}
}
