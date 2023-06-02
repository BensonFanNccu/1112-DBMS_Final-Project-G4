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
            		
            		<img src="images/redheart.png" width="30" height="30" style="position: relative;bottom:5px;">
            		<b style="position: relative;bottom:15px;">餐廳名稱連DB</b><!--加入收藏的按鈕-->
            		<div class="tab"></div>
            		
            		<img src="images/location.png" width="30" height="30">
            		<b style="position: relative;bottom:10px;">地址（連DB）</b>
            		<div class="tab"></div>
            		
            		<img src="images/clock.png" width="30" height="30">
            		<b style="position: relative;bottom:10px;">用餐時間（連DB）</b>
            		<div class="tab"></div>
            		
            		<img src="images/star.png" width="30" height="30">
            		<div class="div1">
            		<h5 style="position: relative;bottom:10px;">點我到評價頁面</h5>
            		</div>
            		
            		<div class="menu">      <!--不確定可不可以用table連menu-->
             			 <!--  <table>
                    		<tr>
                        		<th>品項</th>
                        		<th>價格</th>
                    		</tr>
                    		<tr>
                        		<td>資料1</td>
                        		<td>資料2</td>
                    		</tr>
                    		<tr>
                        		<td>資料4</td>
                        		<td>資料5</td>
                    		</tr>
                		</table>-->
            		</div>
            		
            		<input type="button" value="返回至餐廳查詢" class="submit" onclick="toSearch()">
            		<div class="tab"></div>
            		
            		<input type="button" value="返回至功能選單" class="submit" onclick="toFunctionList()">
        		</div>
    		</div>
		</div>
	</body>
	<script>
		function toSearch(){
			window.location.replace("/Final_Project_G4/SearchPage${user}");
		}
	
  		function toFunctionList(){
			window.location.replace("/Final_Project_G4/FunctionListPage${user}");
		}
  	</script>
</html>