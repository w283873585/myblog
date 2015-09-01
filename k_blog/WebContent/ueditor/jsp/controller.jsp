<%@page import="java.io.File"%>
<%@page import="com.eightzero.admin.util.OssUpload"%>
<%@page import="com.eightzero.admin.util.U"%>
<%@page import="java.util.Date"%>
<%@page import="com.eightzero.admin.util.FileUtil"%>
<%@page import="com.alibaba.fastjson.JSONArray"%>
<%@page import="com.eightzero.admin.CommonAPI"%>
<%@page import="com.alibaba.fastjson.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.baidu.ueditor.ActionEnter"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%!private String ForOss(String result, HttpServletRequest request) {
		JSONObject obj = JSONObject.parseObject(result);
		JSONObject obj2;
		String url2;
		String path;
		if ("SUCCESS".equals(obj.getString("state"))) {
			String fileServer = CommonAPI.fileServer;
			if (CommonAPI.fileServer.endsWith("/")) {
				fileServer = fileServer.substring(0, fileServer.length() - 1);
			}
			String url = obj.getString("url");
			JSONArray arr;
			if (url == null) {
				arr = obj.getJSONArray("list");
			} else {
				arr = new JSONArray();
				arr.add(obj);
			}
			for (int i = 0; i < arr.size(); i++) {
				obj2 = arr.getJSONObject(i);
				url = obj2.getString("url");
				path = request.getSession().getServletContext()
						.getRealPath(url);
				//Images/2015/05/27/

				String fileName = FileUtil.GetFileName(path);
				String key = "Images/ueditor"
						+ U.DF_Path_Date.format(new Date());
				File file = new File(path);
				OssUpload.ossUploadImg(file, key, fileName);// 上传图片到阿里云
				url2 = fileServer + "/" + key + fileName;
				obj2.put("url", url2);
			}
		}
		return obj.toJSONString();
	}%>
<%
	request.setCharacterEncoding("utf-8");
	response.setHeader("Content-Type", "text/html");

	String rootPath = application.getRealPath("/");
	String result = new ActionEnter(request, rootPath).exec();
	String actionName = (String) request.getParameter("action");

	if ("uploadimage".equals(actionName)
			|| "catchimage".equals(actionName)) {
		result = ForOss(result, request);
	}

	out.write(result);
%>
