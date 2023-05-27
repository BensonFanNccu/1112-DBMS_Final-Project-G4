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
    <div class="system_name">
      <h2>餐廳選擇器</h2>
    </div>
    <div class="option_page">
        <div id="container4">
          <div class="options">
            <h3 style = "position: center">選擇介面</h3>
            <div class="tab"></div> 
            <b>預算:</b>
    
              <label><input type="checkbox" name="預算1" value="50-100">50-100</label>
              <label><input type="checkbox" name="預算2" value="100-150">100-150</label>
              <label><input type="checkbox" name="預算3" value="150-200">150-200</label>
              <label><input type="checkbox" name="預算4" value="200-250">200-250</label>
              <label><input type="checkbox" name="預算5" value="250-300">250-300</label>
              <label><input type="checkbox" name="預算6" value="不限">不限</label>
        
           
            <div class="tab"></div> 
            <b><label>用餐時間：</label></b>
              <label><input type="checkbox" name="用餐時間1" value="10min-30min">10min-30min</label>
              <label><input type="checkbox" name="用餐時間2" value="30min-1hr">30min-1hr</label>
              <label><input type="checkbox" name="用餐時間3" value="1hr以上">1hr以上</label>
              <label><input type="checkbox" name="預算6" value="不限">不限</label>

            <div class="tab"></div> 
            <b><label>口味：</label></b>
              <label><input type="checkbox" name="口味1" value="中式餐廳">中式餐廳</label>
              <label><input type="checkbox" name="口味2" value="韓式、日式、美式、義式餐廳">韓式、日式、美式、義式餐廳</label>
              <label><input type="checkbox" name="口味3" value="輕食、速食">輕食、速食</label>
              <label><input type="checkbox" name="預算6" value="不限">不限</label>
          
           
              <div class="tab"></div> 
              <b><label>離何處較近</label></b>
                <label><input type="checkbox" name="位置1" value="麥側">麥側</label>
                <label><input type="checkbox" name="位置2" value="正門">正門</label>
                <label><input type="checkbox" name="位置3" value="東側門">東側門</label>
                <label><input type="checkbox" name="預算6" value="不限">不限</label>
                
                <h5 style="position: relative;bottom:12px;"><a href="/Final_Project_G4/FunctionListPage">返回主選單</a></h5>
              
        
          </div>
        </div><!-- container3 end-->
      </div>
</html>