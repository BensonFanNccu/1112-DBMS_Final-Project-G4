<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Restaurant Chooser</title>  
        <link rel="stylesheet" type="text/css" href="css/restaurantChooser.css"/> 
        <meta name="viewpoint" content="width=device-width,initial-scale=1.0">
    </head>
  <body>
    <div class="system_name">
      <img src="images/logo.png" width="200" height="150"  >
    </div>
  <div class="commentView">
    <div id="container7">
      <div class="View"> 
        <!--點進各個餐廳後會顯示comment，所以這個html會跟後端結合到-->

        <!--餐廳名稱--> <h3>${Rest}</h3>
        <!--和後端結合，可以看到每個餐廳的評價和星級-->
		<table>${comment}</table>

          
          <h5><a href = "javascript:void(0)" onclick = "toRestaurant()">返回至功能選單</a></h5>
      </div>
    </div>
  </div>
  </body>
  <script>
	function toRestaurant(){
		document.location.assign("/Final_Project_G4/RestaurantPage?${user}&${RestID}");
	}
  </script>
</html>