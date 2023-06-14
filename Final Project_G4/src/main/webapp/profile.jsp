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
    <div class="personal_info_page">
      <div id="container1">
        <div class="personal info"> 
          <h3>個人資料頁面</h3>
          <br><b><label>帳號：${account}</label></b>
          <h5><a href="Accountchange.html">更改帳號名稱</a></h5>
          
            <!-- 這邊貌似要和後端結合，可以顯示＋更改使用者帳號 -->
          <br><b><label>電子信箱：${email}</label></b>
          <h5><a href="Emailchange.html">更改電子信箱</a></h5>
          
            <!-- 這邊貌似要和後端結合，可以顯示＋更改使用者用戶名 -->
          <br><b><label>密碼：${password}</label></b>
          <h5><a href="passwordchange.html">更改密碼</a></h5>
          
            <!-- 這邊貌似要和後端結合，可以顯示＋更改使用者email -->
          <a href="javascript:void(0)" onclick = "toFunctionList()">
          <input type="button" value="返回至主選單" class="submit"  style="position: relative;" onclick="">
          </a>
        </div>  
      </div> 
    </div>
  </body>
  <script>
	function toFunctionList(){
		window.location.replace("/Final_Project_G4/FunctionListPage?${user}");
	}
  </script>
</html>