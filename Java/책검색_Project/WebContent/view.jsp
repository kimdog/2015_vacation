<%@page contentType="text/html; charset=UTF8"%>
<%@page import="java.util.*,entity.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="stylesheets/jumbotron.css" rel="stylesheet">
<link href="stylesheets/bootstrap.min.css" rel="stylesheet">
<link href="stylesheets/dashboard.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<style>
	.myBookImg {
		width : 50%;
	}
</style>
<title></title>
</head>
<body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Library Management System</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#">Book List<span class="sr-only">(current)</span></a></li>
            <li><a href="#">Book Register</a></li>
            <li><a href="#">Book Delete</a></li>
            <li><a href="#">Book Update</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Book List</h1>

          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>Image</th>                  
                  <th>Title</th>
                  <th>ISBN</th>
                  <th>Price</th>
                  <th>Author</th>
                </tr>
              </thead>
              <tbody>
                <% 
           		    // result로 넣었으므로 result라는 이름으로 뺀다
                	ArrayList<BookEntity> list =
                		(ArrayList<BookEntity>) request.getAttribute("result");
                		//getAttribute는 object로 data를 넘겨준다. 
                		//따라서 어떠한 type이든 casting 가능
                	for( int i=0; i < list.size(); i++ ) {
                		// 형태만 다를뿐 자료구조 쓰는방법은 다 비슷하다
                		BookEntity entity = list.get(i);
                %>
                <tr>
                  <td><img class="myBookImg" src="<%= entity.getBimgurl() %>"></td>
                  <td><%= entity.getBtitle() %></td>
                  <td><%= entity.getBisbn() %></td>
                  <td><%= entity.getBprice() %></td>
                  <td><%= entity.getBauthor() %></td>
                </tr>
                <%
                	}
                	// java코드로 html을 반복하는 방법 .
                %>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
      

<svg xmlns="http://www.w3.org/2000/svg" width="200" height="200" viewBox="0 0 200 200" preserveAspectRatio="none" style="visibility: hidden; position: absolute; top: -100%; left: -100%;"><defs></defs><text x="0" y="10" style="font-weight:bold;font-size:10pt;font-family:Arial, Helvetica, Open Sans, sans-serif;dominant-baseline:middle">200x200</text></svg></body>
</html>