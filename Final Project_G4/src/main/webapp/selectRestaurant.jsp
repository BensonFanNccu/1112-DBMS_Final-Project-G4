<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<style>
		/*checkbox*/
		label {
			padding: 0;
			margin-right: 3px;
			cursor: pointer;
			position: relative;bottom:12px;
		}
		
		input[type=checkbox] {
			display: none;
			position: relative;bottom:12px;
		}
		
		input[type=checkbox]+span {
			display: inline-block;
			background-color: #f8f2f2;
			padding: 3px 6px;
			border: 1px solid rgb(255, 251, 251);
			color: #000000;
			border-radius: 10px;
			user-select: none;
			position: relative;bottom:12px; /* 防止文字被滑鼠選取反白 */
		}

		input[type=checkbox]:checked+span {
			color: rgb(220, 160, 62);
			background-color: #dcd5d5;
			position: relative;bottom:12px;
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
			<img src="images/logo.png" width="200" height="150">
		</div>
    	
		<div class="option_page">
			<div id="container4">
				<div class="options">
					<h3 style="position: relative;bottom:12px;">選擇介面</h3>
            		
					<form action='/Final_Project_G4/RecommandPage' method='get'>
						<br><b><label style="position: relative;bottom:30px;">預算</label></b>
						<label><input type="checkbox" name="預算1" value="50-100" ><span>50-100</span></label>
						<label><input type="checkbox" name="預算2" value="100-150"><span>100-150</span></label>
						<label><input type="checkbox" name="預算3" value="150-200"> <span>150-200</span>  </label>
						<label><input type="checkbox" name="預算4" value="200-250"><span>200-250</span></label>
						<label><input type="checkbox" name="預算5" value="250-300"><span>250-300</span></label>
						<label><input type="checkbox" class="checkAll"><span>不限</span></label>           
						<div class="tab"></div>
						 
						<br><b><label style="position: relative;bottom:30px;">用餐時間</label></b>
						<label><input type="checkbox" name="用餐時間1" value="10min-30min"><span>10min-30min</span></label>
						<label><input type="checkbox" name="用餐時間2" value="30min-1hr"><span>30min-1hr</span></label>
						<label><input type="checkbox" name="用餐時間3" value="1hr以上"><span>1hr以上</span></label>
						<label><input type="checkbox" class="checkAll"><span>不限</span></label>             
						<div class="tab"></div>
						 
						<br><b><label style="position: relative;bottom:30px;">口味</label></b>
						<label><input type="checkbox" name="口味1" value="中式餐廳"><span>中式餐廳</span></label>
						<label><input type="checkbox" name="口味2" value="韓式、日式、美式、義式餐廳"><span>韓式、日式、美式、義式餐廳</span></label>
						<label><input type="checkbox" name="口味3" value="輕食、速食"><span>輕食、速食</span></label>
						<label><input type="checkbox" class="checkAll"><span>不限</span></label>
						<div class="tab"></div>
						 
						<br><b><label style="position: relative;bottom:30px;">離何處較近</label></b>
						<label><input type="checkbox" name="位置1" value="麥側"><span>麥側</span></label>
						<label><input type="checkbox" name="位置2" value="正門"><span>正門</span></label>
						<label><input type="checkbox" name="位置3" value="東側門"><span>東側門</span></label>
						<label><input type="checkbox" class="checkAll"><span>不限</span></label>
						<br>
						
						<input type="submit" value="選擇完成" class="submit" style="position: relative;bottom:30px;">
					</form>   
					<h5 style="position: relative;bottom:30px;"><a href="javascript:void(0)" onclick = "toFunctionList()">返回主選單</a></h5>                      
				</div>
			</div><!-- container3 end-->
		</div>
	</body>
	<script>
		function toFunctionList(){
			window.location.replace("/Final_Project_G4/FunctionListPage${user}");
		}
	</script>
</html>