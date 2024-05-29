<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>


<title>It is Todo Management</title>

<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>

	<div class="container">

		<table class="table table-striped">

			<caption>To do List</caption>


			<thead>
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is Completed</th>
				</tr>
			</thead>

			<tbody>

				<c:forEach var="todo" items="${todoUserList}">
					<tr>
						<td>${todo.desc}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.done}</td>
						<td><a href="/delete-todos?id=${todo.id}"  class="btn btn-danger">Delete</a></td>
					</tr>
				</c:forEach>

			</tbody>





		</table>
		
		<div>
		
		   <a type="button" class="btn btn-success" href="/add-todos">Add</a>
		
		</div>
		


	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>




</html>



