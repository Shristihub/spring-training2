<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="search-by-category">
Enter category<input type="text" name="category">
<input type="submit" value="search">
</form>
<br/>
<form action="search-by-author">
Enter author<input type="text" name="author">
<input type="submit" value="search">
</form>
<br/>
${bookList }
</body>
</html>