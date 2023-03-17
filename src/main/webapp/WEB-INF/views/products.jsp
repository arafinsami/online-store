<%@include file="/WEB-INF/views/partials/header.jsp"%>
	<main role="main">
		<div class="container" style="margin-top: 50px">
			<div class="row">
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">#</th>
							<th scope="col">Image</th>
							<th scope="col">Name</th>
							<th scope="col">Category</th>
							<th scope="col">Condition</th>
							<th scope="col">Status</th>
							<th scope="col">Price</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${products}" var="product">
							<tr>
								<th>${product.id}</th>
								<th><img height="50px" width="50px" src="${pageContext.servletContext.contextPath }/product-upload-path/${product.image}" /></th>
								
								<th>${product.name}</th>
								<th>${product.productCategory.getlabel()}</th>
								<th>${product.productCondition.getlabel()}</th>
								<th>${product.productStatus.getlabel()}</th>
								<th>${product.price}</th>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<hr class="featurette-divider">
		</div>

		<%@include file="/WEB-INF/views/partials/footer.jsp"%>
	</main>
</body>
</html>

