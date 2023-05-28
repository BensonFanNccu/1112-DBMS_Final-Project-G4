<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>RestaurantChooser</title>
		<link rel="stylesheet" type="text/css" href="css/restaurantChooser.css" />
		<meta name="viewpoint" content="width=device-width,initial-scale=1.0">
	</head>
	<body>
		<div class="system_name">
  			<img src="images/logo.png" width="200" height="150"  >
		</div>

		<div class="login_page">
  			<div id="container7">
    			<div class="favorite">
      				<h3>推薦結果</h3>
      				
      				<br>
      				<img src="images/firstplace.png" width="30" height="30" style="position: relative;top:12px;">
      				<a href="">推薦第一名</a>
      				<br><br>
      				
      				<img src="images/secondplace.png" width="30" height="30" style="position: relative;top:12px;">
      				<a href="">推薦第二名</a>
      				<br><br>
      				
      				<img src="images/thirdplace.png" width="30" height="30" style="position: relative;top:12px;">
      				<a href="">推薦第三名</a>
      				<br><br>
      				
      				<input type="button" value="返回至主選單" class="submit"  style="position: relative;top:30px;" onclick="toFunctionList()">
    			</div>
  			</div>
		</div>
	</body>
	<script>
  		function toFunctionList(){
			window.location.replace("/Final_Project_G4/FunctionListPage${user}");
		}
	</script>
</html>