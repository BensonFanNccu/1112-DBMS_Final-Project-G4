<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>RestaurantChooser</title>  
		<link rel="stylesheet" type="text/css" href="css/restaurantChooser.css"> 
		<meta name="viewpoint" content="width=device-width,initial-scale=1.0">
	</head>
	<body>
		<div class="system_name">
			<img src="images/logo.png" width="200" height="150"  >
		</div>
		
		<div class="choosefunction_page">
			<div id="container3">
				<div class="functions">
					<h3 style="position: relative;left:25px;top:10px">功能選單</h3><br>
					           
					<img src="images/select.png" style=" position: relative; top:12px;" width="30" height="30">
					<input type="button" value="選擇功能" class="submit" onclick="toSelect()">
					<div class="tab" ></div>
            
					<img src="images/search.png" style=" position: relative; top:12px;" width="30" height="30">
					<input type="button" value="餐廳查詢" class="submit" onclick="toSearch()">
					<div class="tab" ></div>
            
					<img src="images/myFavorite.png" style=" position: relative; top:12px;" width="30" height="30">
					<input type="button" value="我的最愛" class="submit" onclick="toMyFavorite()">
					<div class="tab" ></div>
            
					<img src="images/turntable.jpg" style=" position: relative; top:12px;" width="30" height="30">
					<input type="button" value="選擇障礙專用" class="submit" onclick="toTurnTable()">
					<div class="tab" ></div>
            
					<img src="images/food.png" style=" position: relative; top:12px;" width="30" height="30">
					<input type="button" value="飲食紀錄" class="submit" onclick="">
					<div class="tab" ></div>
            
					<img src="images/setting.png" style=" position: relative; top:12px;" width="30" height="30">
					<input type="button" value="設定個人資料" class="submit" onclick="">
					<div class="tab" ></div>
 
					<h5><a href = "javascript:void(0)" onclick = "signOut()">sign out</a></h5>
				</div>
			</div><!-- container3 end-->
		</div>
	</body>
	<script>
		function toSelect(){
			document.location.assign("/Final_Project_G4/SelectPage?${user}");
		}
	
		function toSearch(){
			document.location.assign("/Final_Project_G4/SearchPage?${user}");
		}
	
		function toMyFavorite(){
			document.location.assign("/Final_Project_G4/MyFavoritePage?${user}");
		}
	
		function toTurnTable(){
			document.location.assign("/Final_Project_G4/TurnTablePage?${user}");
		}
		
		function signOut(){
			window.location.replace("/Final_Project_G4/LoginPage");
		}
	</script>
</html>