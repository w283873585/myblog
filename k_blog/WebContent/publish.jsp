<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.all.min.js"></script>
<style type="text/css">
.editor_box {
	height: 300px;
}
.container_box {
	width: 800px;
	padding: 30px;
}
.editor_container {
	height: 380px;
}
</style>

</head>
<body>
	<div class="container_box">
		<form>
		  	<div class="form-group">
				<label for="title">标题：</label>
				<input id="title" class="form-control" type="text" />
			</div>
			<div class="form-group editor_container">
				<div id="editor_box" class="editor_box"></div>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Submit</button>
				&nbsp;&nbsp;&nbsp;
				<button type="reset" class="btn btn-default">Reset</button>
			</div>
		</form>
	</div>
	<script type="text/javascript">
	 	UE.getEditor('editor_box');
	</script>
</body>
</html>