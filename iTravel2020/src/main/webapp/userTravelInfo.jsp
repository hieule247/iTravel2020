<!DOCTYPE html>
<html lang="en">
<head>
  	<title>Bootstrap Example</title>
  	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/userTravelInfo.js"></script>
	<link href="resources/css/userinfo.css" type="text/css" rel="stylesheet" />

<%--	 <script src="register.js" type="text/javascript"></script>--%>

</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Itravel</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Activities</a></li>
        <li><a href="#">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-md-2 sidenav">
    
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
    </div>
    <div class="col-md-8 text-left"> 
    	
    	<div class="row">
        	<div class="col-md-12">	
   				<div class="panel panel-info">
            		<div class="panel-heading">
              			<h3 class="panel-title">Upload your photo here</h3>
            		</div>

            		<div class="panel-body">
              			<div class="row">
                			<div class="col-md-5"> <img alt="User Pic" src="resources/images/bg/avatar.jpeg" class="img-circle img-responsive">
                		
                			<input type="button" value="Upload" onclick="chooseFile();">
                 		</div>
                
          
                			<div class="col-md-7">
								<table class="userinfo table">
									<tr><td><label for="id">User ID</label></td><td><span id="id"></span></td></tr>
									<tr><td><label for="name">Name</label></td><td><span id="name"></span></td></tr>
									<tr><td><label for="gender">Gender</label></td><td><span id="gender" ></span></td></tr>
									<tr><td><label for="year">Year Of Birth</label></td><td><span id="year"></span></td></tr>
									<tr><td><label for="email">Email</label></td><td><span id="email" ></span></td></tr>
									<tr><td><label for="address">Address</label></td><td><span id="address"></span></td></tr>
									<tr><td></td><td>
										<input type="hidden" value="false" id="isValid">
										<input type="button" value="Edit" id="edit">

									</td></tr>
								</table>
        					</div>
      					</div>
      				</div>
      			</div>
      		</div>
      	</div>
      
      	<div class="row">
        <div class="col-md-12">
          <!--create 2 tabs for introduction and photo-->
           	<div class="container">
  
  				<ul class="nav nav-tabs">
    				<li class="active"><a data-toggle="tab" href="#home">Introduction</a></li>
    				<li><a data-toggle="tab" href="#menu1">Photo</a></li>
  				</ul>

  				<div class="tab-content">
    				<div id="home" class="tab-pane fade in active">
      					<form action="/action_page.php">
  						What i am doing for my life?<br>
  						<form>
  						<textarea></textarea>
  						<br>
  						<input type="button" value="Submit">
						</form>
						I’m really good at<br>
  						<form>
  						<textarea></textarea>
  						<br>
  						<input type="button" value="Submit">
						</form>
						Things are interesting for me<br>
  						<form>
  						<textarea></textarea>
  						<br>
  						<input type="button" value="Submit">
						</form>
						You should message me if:<br>
  						<form>
  						<textarea></textarea>
  						<br>
  						<input type="button" value="Submit">
						</form>
						</form>
						   				
					</div>
    				<div id="menu1" class="tab-pane fade">
      					<h3>Upload your photo</h3>
      					<form action="">
  							<input type="file" name="pic" accept="image/*">
  							<br>
  							<input type="submit">
						</form>
    				</div>
    
  				</div>
			</div>
          
        </div>
    </div>
    </div>
    <div class="col-md-2 sidenav">
      <div class="well">
        <p>ADS</p>
      </div>
      <div class="well">
        <p>ADS</p>
      </div>
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Designed by Ha Le</p>
</footer>

</body>
</html>
