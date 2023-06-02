<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
      <img src="images/logo.png" width="200" height="150"  >
    </div>
    <div class="option_page">
        <div id="container4">
          <div class="options">
            <h3  style="position: relative;bottom:12px;">選擇介面</h3>
            <br><b><label style="position: relative;bottom:30px;">預算: </label></b>
                <label><input type="checkbox" name="budget" value="below100" ><span>50-100</span></label>
		<label><input type="checkbox" name="budget" value="100-150"><span>100-150</span></label>
		<label><input type="checkbox" name="budget" value="150-200"> <span>150-200</span>  </label>
		<label><input type="checkbox" name="budget" value="200-250"><span>200-250</span></label>
		<label><input type="checkbox" name="budget" value="250up"><span>250-300</span></label>
		<label><input type="checkbox" id="checkAllB"><span>不限</span></label>
        
           
            <div class="tab"></div> 
            <br><b><label style="position: relative;bottom:30px;">用餐時間: </label></b>
                <label><input type="checkbox" name="time" value="below 30min"><span>30分以下</span></label>
                <label><input type="checkbox" name="time" value="30min-1hr"><span>30分-1小時</span></label>
                <label><input type="checkbox" name="time" value="1hr up"><span>1小時以上</span></label>
                <label><input type="checkbox" id="checkAllt"><span>不限</span></label>
             
            <div class="tab"></div> 
            <br><b><label style="position: relative;bottom:30px;">口味: </label></b>
                <label><input type="checkbox" name="type" value="type1"><span>中式餐廳</span></label>
                <label><input type="checkbox" name="type" value="type2"><span>韓式、日式、美式、義式餐廳</span></label>
                <label><input type="checkbox" name="type" value="type3"><span>輕食、速食</span></label>
                <label><input type="checkbox" id="checkAllT"><span>不限</span></label>
  
            <div class="tab"></div> 
            <br><b><label style="position: relative;bottom:30px;">距離何處較近: </label></b>
                <label><input type="checkbox" name="dist" value="dist1"><span>麥側</span></label>
                <label><input type="checkbox" name="dist" value="dist2"><span>正門</span></label>
                <label><input type="checkbox" name="dist" value="dist3"><span>東側門</span></label>
                <label><input type="checkbox" id="checkAllD"><span>不限</span></label>
                
              <h5 style="position: relative;bottom:30px;"><a href="recommand.html">選擇完成</a></h5>    
              <h5 style="position: relative;bottom:30px;"><a href="javascript:void(0)" onclick = "toFunctionList()">返回主選單</a></h5>                      
          </div>
        </div><!-- container3 end-->
     </div>
  </body>
  <script>
  	function toFunctionList(){
  		window.location.replace("/Final_Project_G4/FunctionListPage${user}");
  	}
  	
  	document.getElementById('checkAllB').onclick = function() {
  	    var checkboxes = document.getElementsByName('budget');
  	    for (var checkbox of checkboxes) {
  	        checkbox.checked = this.checked;
  	    }
  	}
  	
  	var checkboxesB = document.getElementsByName('budget');
  	for (var i = 0; i < checkboxesB.length; i++) {
  	    checkboxesB[i].onclick = function() {
  	        var checkedCount = 0;
  	        for (var j = 0; j < checkboxesB.length; j++) {
  	            if (checkboxesB[j].checked) {
  	                checkedCount++;
  	            }
  	        }
  	        
  	        var checkAllBCheckbox = document.getElementById('checkAllB');
  	        if (checkedCount == 5) {
  	            checkAllBCheckbox.checked = true;
  	        }
  	        
  	        if(checkedCount == 4 && checkAllBCheckbox.checked) {
  	        	checkAllBCheckbox.checked = false;
  	        }
  	    };
  	}
  	
  	document.getElementById('checkAllt').onclick = function() {
  	    var checkboxes = document.getElementsByName('time');
  	    for (var checkbox of checkboxes) {
  	        checkbox.checked = this.checked;
  	    }
  	}
  	
  	var checkboxest = document.getElementsByName('time');
  	for (var i = 0; i < checkboxest.length; i++) {
  		checkboxest[i].onclick = function() {
  	        var checkedCount = 0;
  	        for (var j = 0; j < checkboxest.length; j++) {
  	            if (checkboxest[j].checked) {
  	                checkedCount++;
  	            }
  	        }
  	        
  	        var checkAlltCheckbox = document.getElementById('checkAllt');
  	        if (checkedCount == 3) {
  	            checkAlltCheckbox.checked = true;
  	        }
  	        
  	        if(checkedCount == 2 && checkAlltCheckbox.checked) {
  	        	checkAlltCheckbox.checked = false;
  	        }
  	    };
  	}
  	
  	document.getElementById('checkAllT').onclick = function() {
  	    var checkboxes = document.getElementsByName('type');
  	    for (var checkbox of checkboxes) {
  	        checkbox.checked = this.checked;
  	    }
  	}
  	
  	var checkboxesT = document.getElementsByName('type');
  	for (var i = 0; i < checkboxesT.length; i++) {
  		checkboxesT[i].onclick = function() {
  	        var checkedCount = 0;
  	        for (var j = 0; j < checkboxesT.length; j++) {
  	            if (checkboxesT[j].checked) {
  	                checkedCount++;
  	            }
  	        }
  	        
  	        var checkAllTCheckbox = document.getElementById('checkAllT');
  	        if (checkedCount == 3) {
  	        	checkAllTCheckbox.checked = true;
  	        }
  	        
  	        if(checkedCount == 2 && checkAllTCheckbox.checked) {
  	        	checkAllTCheckbox.checked = false;
  	        }
  	    };
  	}
  	
  	document.getElementById('checkAllD').onclick = function() {
  	    var checkboxes = document.getElementsByName('dist');
  	    for (var checkbox of checkboxes) {
  	        checkbox.checked = this.checked;
  	    }
  	}
  	
  	var checkboxesD = document.getElementsByName('dist');
  	for (var i = 0; i < checkboxesD.length; i++) {
  		checkboxesD[i].onclick = function() {
  	        var checkedCount = 0;
  	        for (var j = 0; j < checkboxesD.length; j++) {
  	            if (checkboxesD[j].checked) {
  	                checkedCount++;
  	            }
  	        }
  	        
  	        var checkAllDCheckbox = document.getElementById('checkAllD');
  	        if (checkedCount == 3) {
  	        	checkAllDCheckbox.checked = true;
  	        }
  	        
  	        if(checkedCount == 2 && checkAllDCheckbox.checked) {
  	        	checkAllDCheckbox.checked = false;
  	        }
  	    };
  	}

  </script>
</html>
