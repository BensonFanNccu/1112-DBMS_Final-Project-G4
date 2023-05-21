<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
        <meta charset="utf-8">
        <title>RestaurantChooser</title>  
        <link rel="stylesheet" type="text/css" href="css/restaurantChooser.css"/> 
        <meta name="viewpoint" content="width=device-width,initial-scale=1.0">
</head>
<body>
  <div class="choosefunction_page">
        <div id="container3">
          <div class="functions">
            <h3>功能選單</h3>
            
            <form action='/Final_Project_G4/SelectPage' method='get'>
            <img src="images/select.png" width="30" height="30">
            <input type="submit" value="選擇功能" class="submit">
            <div class="tab" ></div>
            </form>
            
            <form>
            <img src="images/search.png" width="30" height="30">
            <input type="button" value="餐廳查詢" class="submit" onclick="">
            <div class="tab" ></div>
            </form>
            
            <form>
            <img src="images/myFavorite.png" width="30" height="30">
            <input type="button" value="我的最愛" class="submit" onclick="">
            <div class="tab" ></div>
            </form>
            
            <form>
            <img src="images/food.png" width="30" height="30">
            <input type="button" value="飲食紀錄" class="submit" onclick="">
            <div class="tab" ></div>
            </form>
            
            <form>
            <img src="images/setting.png" width="30" height="30">
            <input type="button" value="設定個人資料" class="submit" onclick=""> 
            </form>
          <h5><a href = "/Final_Project_G4/LoginPage">sign out</a>></h5>
        </div>
      </div><!-- container3 end-->
    </div>
</body>
</html>