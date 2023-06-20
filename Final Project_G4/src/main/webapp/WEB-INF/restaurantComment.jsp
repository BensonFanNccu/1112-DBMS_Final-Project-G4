<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Restaurant Chooser</title>  
        <link rel="stylesheet" type="text/css" href="login.css"/> 
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

        <!--餐廳名稱--> <h3>餐廳名稱</h3>
        <!--和後端結合，可以看到每個餐廳的評價和星級-->
        <div>
          <label>此餐廳之使用者評論</label>
         
        </div>
        <!--我的設想是會有一個長方形顯示使用者評論，這個要從後端呼叫-->

        <div>
          <label>此餐廳之使用者評級</label>
         
        </div>
        <!--我的設想是會有一個長方形顯示使用者評級，這個要從後端呼叫-->

          
          <h5 onclick="show_hide1()">返回至功能選單</h5>
      </div>
    </div>
  </div>
  </body>
</html>