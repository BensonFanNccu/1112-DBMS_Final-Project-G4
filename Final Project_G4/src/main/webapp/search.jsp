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
		
		<div class="search_page">
  			<div id="container6">
    			<div class="search">
     				<h3>餐廳查詢</h3>
      				<form action = '/Final_Project_G4/SearchPage?${user}' method = 'post'>
        				<input type="text" name = "name" placeholder="輸入關鍵字"> <!--這邊我不知道要怎麼跳出推薦搜尋結果（chatGPT說要用什麼AJAX技術）-->
        				<input type="submit" value="搜尋"><!--這里應該用submit-->
      				</form>
      				<input type="button" value="返回至功能選單" class="submit" onclick="toFunctionList()">
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