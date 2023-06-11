<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<style>
		.div1 {
    		float: right;
   			margin-right: 100px;
		}
	</style>
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
		
		<div class="restaurant_page">
    		<div id="container7">
        		<div class="intro">
            		<div class="tab"></div>
            		<h4>餐廳介紹</h4>
            		<div class="tab"></div>
            		
            		<img src="images/myFavorite.png" width="30" height="30" style="position: relative;bottom:5px;">
            		<b style="position: relative;bottom:15px;">${Name}</b><!--加入收藏的按鈕-->
            		<div class="tab"></div>
            		
            		<img src="images/location.png" width="30" height="30">
            		<b style="position: relative;bottom:10px;">${Address}</b>
            		<div class="tab"></div>
            		
            		<img src="images/clock.png" width="30" height="30">
            		<b style="position: relative;bottom:10px;">${DiningTime}</b>
            		<div class="tab"></div>
            		
            		<img src="images/star.png" width="30" height="30">
              		<b><a href = "javascript:void(0)" onclick = "toComment()" style="position: relative;bottom:10px;" >點我到評價頁面</a></b>
            		<br>
            		
            		<form action='/Final_Project_G4/MyFavoritePage?${user}&${RestID}' method='post'>
            		<input type="submit" value="加入我的最愛" name = "${user}" class="submit">
            		<div class="tab"></div>
            		</form>
            		
            		<input type="button" value="返回上一頁" class="submit" onclick="window.history.back(-1);">
            		<div class="tab"></div>
            		
            		<input type="button" value="返回至功能選單" class="submit" onclick="toFunctionList()">
        		</div>
    		</div>
		</div>
	</body>
	<script>
		function toComment(){
			document.location.assign("/Final_Project_G4/CommentPage?${user}&${RestID}");
		}
		
		function toSearch(){
			document.location.assign("/Final_Project_G4/SearchPage?${user}");
		}
	
  		function toFunctionList(){
  			document.location.assign("/Final_Project_G4/FunctionListPage?${user}");
		}
  	</script>
</html>