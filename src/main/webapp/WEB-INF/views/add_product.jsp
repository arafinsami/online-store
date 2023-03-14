<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/partials/header.jsp"%>
<main role="main">
	<div class="container" style="margin-top: 50px">
		<div class="row">
			<div class="col-lg-9">
				<form:form
					action="${pageContext.request.contextPath}/admin/add-product"
					method="post" modelAttribute="productModel"
					enctype="multipart/form-data">
					<div class="form-group">
						<label>Name</label>
						<form:errors path="name" cssStyle="color: #ff0000;" />
						<form:input path="name" type="text" class="form-control" />
					</div>
					<div class="form-group">
						<label>Description</label>
						<form:errors path="description" cssStyle="color: #ff0000;" />
						<form:textarea path="description" class="form-control" rows="3" />
					</div>
					<div class="form-row align-items-center">
						<div class="col-lg-4">
							<label>Product Category</label>
							<form:select path="productCategory" class="form-control">
								<form:option value="HARDWARE" label="Hardware">Hardware</form:option>
								<form:option value="SOFTWARE" label="Software">Hardware</form:option>
							</form:select>
						</div>
						<div class="col-lg-4">
							<label>Product Condition</label>
							<form:select path="productCondition" class="form-control">
								<form:option value="NEW" label="New">New</form:option>
								<form:option value="USED" label="Used">Used</form:option>
							</form:select>
						</div>
						<div class="col-lg-4">
							<label>Product Status</label>
							<form:select path="productStatus" class="form-control">
								<form:option value="ACTIVE" label="Active">Active</form:option>
								<form:option value="IN_ACTIVE" label="InActive">InActive</form:option>
							</form:select>
						</div>
					</div>
					<br>
					<div class="form-row align-items-center">
						<div class="col-lg-4">
							<label>Price</label>
							<form:errors path="price" cssStyle="color: #ff0000;" />
							<form:input path="price" type="number" class="form-control" />
						</div>
						<div class="col-lg-4">
							<label>Unit Stocks</label>
							<form:errors path="unitInStock" cssStyle="color: #ff0000;" />
							<form:input path="unitInStock" type="number" class="form-control" />
						</div>
						<div class="col-lg-4">
							<label>Manufacturer</label>
							<form:errors path="manufacturer" cssStyle="color: #ff0000;" />
							<form:input path="manufacturer" type="text" class="form-control" />
						</div>
					</div>
					<br>
					<div class="form-group">
						<label>Product Image</label> <input type="file" name="image"
							class="form-control-file">
					</div>
					<button type="submit" class="btn btn-block btn-primary">Submit</button>
				</form:form>
			</div>
		</div>
		<hr class="featurette-divider">
	</div>

	<%@include file="/WEB-INF/views/partials/footer.jsp"%>
</main>
</body>
</html>

