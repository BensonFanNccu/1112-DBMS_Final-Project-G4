<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>RestaurantChooser</title>  
		<link rel="stylesheet" type="text/css" href="css/restaurantChooser.css"/> 
		<meta name="viewpoint" content="width=device-width,initial-scale=1.0">
	</head>
	<body>
		<div class="system_name">
			<img src="images/logo.png" width="200" height="150"  >
		</div>
	
		<div class="system_name">
			<h2>餐廳選擇器</h2>
		</div>
		
		<div id="container2">
			<h3 style="position: center; left: 92px">驗證</h3>
			
			<form action='/Final_Project_G4/VerifyPage' method='post'>
				<input type="text" id="verification" name="email" placeholder="您的信箱" required>
				<div class="tab"></div>
			</form>
		</div>
	</body>
</html>