package com.my.action.main;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.db.StaticFactory;
import com.my.util.MapUtil;

@Controller
@RequestMapping("/login")
public class LoginAction {
	
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login/signIn";
	}
	
	@RequestMapping("/checkLogin")
	public String checkLogin(String username, String password) {
		SqlSession sqlSession = StaticFactory.getSqlSession();
		try {
			String[] arr = {"username", "password"};
			int result = sqlSession.selectOne("login.checkLogin", MapUtil.put(arr, username, password));
			if (result == 1) {
				System.out.println("you successed");
				return "../../index";
			} else {
				System.out.println("you failed");
				return "login/signIn";
			}
		} finally {
			sqlSession.close();
		}
	}
}
