<%@include file="/WEB-INF/views/partials/header.jsp"%>
<main role="main">
	<div class="container" style="margin-top: 50px">
		<div class="row">
			<div class="col-lg-9">
				<form>
					<div class="form-group">
						<label>Name</label> <input type="text" class="form-control">
					</div>
					<div class="form-group">
						<label>Description</label>
						<textarea class="form-control" rows="3"></textarea>
					</div>
					<div class="form-row align-items-center">
						<div class="col-lg-4">
							<label>Product Category</label> <select class="form-control">
								<option>Hardware</option>
								<option>Software</option>
							</select>
						</div>
						<div class="col-lg-4">
							<label>Product Condition</label> <select class="form-control">
								<option>New</option>
								<option>Used</option>
							</select>
						</div>
						<div class="col-lg-4">
							<label>Product Status</label> <select class="form-control">
								<option>Active</option>
								<option>InActive</option>
							</select>
						</div>
					</div>
					<br>
					<div class="form-row align-items-center">
						<div class="col-lg-4">
							<label>Price</label> <input type="number" class="form-control">
						</div>
						<div class="col-lg-4">
							<label>Unit Stocks</label> <input type="number"
								class="form-control">
						</div>
						<div class="col-lg-4">
							<label>Manufacturer</label> <input type="text"
								class="form-control">
						</div>
					</div>
					<br>
					<div class="form-group">
						<label>Product Image</label> <input type="file"
							class="form-control-file">
					</div>
					<button type="submit" class="btn btn-block btn-primary">Submit</button>
				</form>
			</div>
		</div>
		<hr class="featurette-divider">
	</div>

	<%@include file="/WEB-INF/views/partials/footer.jsp"%>
</main>
</body>
</html>

