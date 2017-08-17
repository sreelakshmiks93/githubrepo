<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminLTE 2 | Blank Page</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/_all-skins.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dataTables.bootstrap.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/fragma.css">
  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

  <!-- Google Font -->
</head>
<body class="hold-transition skin-blue sidebar-mini">
<form >
<!-- Site wrapper -->
<div class="wrapper">

  <header class="main-header">
    <!-- Logo -->
    <a href="#" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>F</b></span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>FRAGMA</b>Coding Test</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </a>

      <div class="navbar-custom-menu">
          
      </div>
    </nav>
  </header>

  <!-- =============================================== -->

  <!-- Left side column. contains the sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu" data-widget="tree">
        <li class="treeview">
          <a href="${pageContext.request.contextPath}/">
            <i class="fa fa-dashboard"></i> <span>Dashboard</span>
          </a>
        </li>
        
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- =============================================== -->

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Dashboard
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Dashboard</a></li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
    <div id="upperDiv" style="display: none">
	<div class="row">
		<div class="col-md-6">
		<div class="form-group">
				<label for="state" class="col-sm-2 control-label"></label>
				 <div class="col-sm-10 checkbox">
			      <label><input type="checkbox" checked id="noGrouping" onclick="checkGrouping()")>No Grouping </label>
			    </div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="form-group">
				<label for="state" class="col-sm-2 control-label">State</label>
				<div class="col-sm-10">
					 <select   class="form-control" id="state">
					 <option value="">-Any-</option>
				      </select>
				</div>
			</div>
		</div>
		
	</div>
	<div class="row">
	<div class="col-md-6">
			<div class="form-group">
				<label for="district" class="col-sm-2 control-label">District</label>
				<div class="col-sm-10">
					 <select   class="form-control" id="district">
					 <option value="">-Any-</option>
				      </select>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="form-group">
				<label for="crop" class="col-sm-2 control-label">Crop</label>
				<div class="col-sm-10">
					 <select   class="form-control" id="crop">
					 <option value="">-Any-</option>
				      </select>
				</div>
			</div>
		</div>
		</div>
		<div class="row"> 
		<div class="col-md-6">
			<div class="form-group">
				<label for="season" class="col-sm-2 control-label">Season</label>
				<div class="col-sm-10">
					<select class="form-control" id="season">
					<option value="">-Any-</option>
					</select>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="form-group">
				<label for="year" class="col-sm-2 control-label">Year</label>
				<div class="col-sm-10">
					<select class="form-control" id="year"  onchange="checkYear()">
					<option value="">-Any-</option>
					</select>
				</div>
			</div>
		</div>
	</div> 
	<div class="row">
	
		<div class="col-md-6">
			<div class="form-group">
				<label for="start_year" class="col-sm-2 control-label">Start Year</label>
				<div class="col-sm-10">
					<select class="form-control" id="start_year"  onchange="checkYear()">
					<option value="">-Any-</option>
					</select>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="form-group">
				<label for="end_year" class="col-sm-2 control-label">End Year</label>
				<div class="col-sm-10">
					<select class="form-control" id="end_year" onchange="checkYear()">
					<option value="">-Any-</option>
					</select>
				</div>
			</div>
		</div>
		
	</div>
	<div class="row">
	
		<div class="col-md-6">
			<div class="form-group">
				<label for="production_min" class="col-sm-2 control-label">Production From</label>
				<div class="col-sm-10">
					<input type="number" class="form-control"  id="production_min" value=""  >
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="form-group">
				<label for="production_max" class="col-sm-2 control-label">Production To</label>
				<div class="col-sm-10">
					<input type="number" class="form-control" id="production_max"  value=""  >
				</div>
			</div>
		</div>
	</div>
	<div class="row">
	
		<div class="col-md-6">
			<div class="form-group">
				<label for="area_min" class="col-sm-2 control-label">Area From</label>
				<div class="col-sm-10">
					<input type="number" class="form-control"  id="area_min" value=""  >
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="form-group">
				<label for="area_max" class="col-sm-2 control-label">Area To</label>
				<div class="col-sm-10">
					<input type="number" class="form-control" id="area_max"  value=""  >
				</div>
			</div>
		</div>
		
	</div>
	<div class="row">
	<div class="col-md-6">
			<div class="form-group">
				<label  class="col-sm-2 control-label"> </label>
				<div class="col-sm-10">
					<input type="button" class="btn btn-primary form-control" value="Filter Results" onclick="filterResults()">
				</div>
			</div>
		</div>
	</div>
	<div class="row" id="metricsDiv">
	<div class="col-md-4">
			<div class="form-group">
				<div class="col-sm-12">
					<label class="radio-inline"> <input checked type="radio"
						name="optradio" value="production" onchange="checkValueOfCheckBox()">Production
					</label> <label class="radio-inline"> <input type="radio"
						name="optradio"  value="area" onchange="checkValueOfCheckBox()">Area
					</label> <label class="radio-inline"> <input type="radio"
						name="optradio"  value="both" onchange="checkValueOfCheckBox()">See Both
					</label>
				</div>
			</div>
		</div>
	<div class="col-md-4 " id="productionDiv">
	<div class="form-group ">
				<div class="col-sm-12 shadow">
				Maximum Production :<span id="maxProduction"></span><br>
				Average Production :<span id="avgProduction"></span>
				</div>
			</div>
	</div>
	<div class="col-md-4 ">
	<div class="form-group " id="areaDiv" style="display: none">
				<div class="col-sm-12 shadow">
				Maximum Area :<span id="maxArea"></span><br>
				Average Area :<span id="avgArea"></span>
				</div>
			</div>
	</div>
	</div>
	</div>
					<!-- Default box -->
      <div class="box">
        <div class="box-body">
          <table id="cropDataTable" class="table table-hover table-striped table-bordered ">
          <thead>
          <tr>
          <th>State</th>
          <th>District</th>
          <th>Year</th>
          <th>Season</th>
          <th>Crop</th>
          <th>Area</th>
          <th>Production</th>
          </tr>
          </thead>
          <tbody>
          </tbody>
          </table>
        </div>
        <!-- /.box-body -->
        
        <!-- /.box-footer-->
      </div>
      <!-- /.box -->

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
 
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- jQuery 3 -->
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="${pageContext.request.contextPath}/js/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="${pageContext.request.contextPath}/js/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${pageContext.request.contextPath}/js/demo.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/js/dataTables.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.blockUI.js"></script>
<script src="${pageContext.request.contextPath}/js/fragma.js"></script>
<script>
  $(document).ready(function () {
    $('.sidebar-menu').tree()
  })
</script>
<input type="hidden" id="contextPath" value="${pageContext.request.contextPath}">
</form>
</body>
</html>
