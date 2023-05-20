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
    <div class="system_name">
      <h2>餐廳選擇器</h2>
    </div>
	 <div class="signup_page">
      <div id="container2">
        <div class="signup">  
          
          <h3>註冊 Sign Up</h3>
         
          <form action='/Final_Project_G4/RegisterPage' method='post'>
            <input type="text" id="username2" name="account" placeholder="使用者帳號需混合4~8個英文字母和數字" required>
            <div class="tab" ></div>
            <input type="text" id="username2" name="email" placeholder="信箱" required>
            <div class="tab"></div>
            <input type="text" id="password2" name="password" placeholder="密碼" required>
            <div class="tab"></div>
            <input type="text" id="comfirm_password" name="comfirm_password" placeholder="確認密碼" required>
            <div class="tab"></div>            
            <input type="submit" value="註冊" class="submit">
          </form>  
          <h5 onclick = "toLogin"><a href = "/Final_Project_G4/LoginPage">登入帳號</a></h5>
          <!-- 當使用者點擊按鈕呼叫函示-->
        </div><!-- signup end-->
      </div><!-- container2 end-->
    </div><!-- signup_page end--> 
  </body>
  <script>
  	function toLogin(){
  		document.getElementById("username2").value="";
        document.getElementById("email").value="";
        document.getElementById("password2").value="";
        document.getElementById("comfirm_password").value="";
  	}  	
  </script>
</html>