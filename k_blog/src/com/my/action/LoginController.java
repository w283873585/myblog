package com.my.action;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.db.StaticFactory;
import com.my.model.LoginInfo;
import com.my.util.MapUtil;

@Controller
@RequestMapping("/login1")
public class LoginController {

	@RequestMapping("/check")
	public String login(String username, String password
			// 利用JSR验证表单提交的星系
			, @Validated LoginInfo info) {
		
		SqlSession sqlSession = StaticFactory.getSqlSession();
		try {
			String[] arr = {"username", "password"};
			int result = sqlSession.selectOne("login.checkLogin", MapUtil.put(arr, username, password));
			if (result == 1) {
				System.out.println("you successed");
				return "main";
			} else {
				System.out.println("you failed");
				return "";
			}
		} finally {
			sqlSession.close();
		}
	}
	
	
	@RequestMapping(value= "/{username}", method=RequestMethod.GET, params = "new")
	public String get(@PathVariable String userName,
			
			// 利用JSR验证表单提交的星系
			@Validated LoginInfo info, Model model) {
		return "hello";
	}
}
