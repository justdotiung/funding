<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

id:${list.id },
aid:${list.admin_id },
mid:${list.member_id },
cid:${list.category_id },
reg:${list.regdate },
title:${list.title },
am:${list.amount },
state:${list.state }
<a href="buying?id=${list.id}">구매</a>
</body>
</html>