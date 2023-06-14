<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>RestaurantChooser</title>
<link rel="stylesheet" type="text/css" href="css/restaurantChooser.css"/> 
<meta name="viewpoint" content="width=device-width,initial-scale=1.0">
</head>
<body>
	<div class="restaurant_page">
    	<div id="container7">
    		<div class="intro">
	    		<div class="tab"></div>
				<h3>${name}的菜單</h3>
				<div class="tab"></div>
				<label style="position: relative; left: -320px; top: 20px; font-weight: bold;">菜單圖片：</label>
				<h4 style="position: relative; left: -200px; bottom: 5px; top: 10px; text-align: left">${source}</h4>
				<div class="tab"></div>
				<label style="position: relative; right: -75px; top: -315px; font-weight: bold;">菜單細項：</label>
				<div style="height: 320px; width: 330px; overflow: auto; position: relative; right: -217px; bottom: 310px; text-align: left;">
    				<table>${menu}</table>
				</div>
			<input type="button" value="返回上一頁" class="submit" onclick="toLastPage()">
            <input type="button" value="返回至功能選單" class="submit" onclick="toFunctionList()">
			</div>
		</div>
	</div>
</body>
<script>
function toLastPage(){
	document.location.assign("${last}");
}

function toFunctionList(){
		document.location.assign("/Final_Project_G4/FunctionListPage?${user}");
}
</script>
</html>
