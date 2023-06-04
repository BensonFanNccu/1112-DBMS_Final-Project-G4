<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>

<style>
   
             *{
                margin: 0;
                padding: 0;
                }
                .rate {
                display: center;
                align-items: center;
                height: 46px;
                margin: 200px;
                padding: 10px;
                margin-top: 10px;
                }
                .rate:not(:checked) > input {
                    position:absolute;
                    top:-9999px;
                }
                .rate:not(:checked) > label {
                    float:right;
                    width:1em;
                    overflow:hidden;
                    white-space:nowrap;
                    cursor:pointer;
                    font-size:30px;
                    color:#ccc;
                }
                
                .rate > input:checked ~ label {
                    color: #ffc700;    
                }
                .rate:not(:checked) > label:hover,
                .rate:not(:checked) > label:hover ~ label {
                    color: #deb217;  
                }
                .rate > input:checked + label:hover,
                .rate > input:checked + label:hover ~ label,
                .rate > input:checked ~ label:hover,
                .rate > input:checked ~ label:hover ~ label,
                .rate > label:hover ~ input:checked ~ label {
                    color: #c59b08;
                }       
</style>
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
    <div id="container4">
    <form action = "/Final_Project_G4/FunctionListPage?${user}&${RestID}" method = "get">
        <h3>Your Comment:</h3>
        <textarea id="myTextbox" name="myTextbox" rows="10" cols="80"></textarea>

        <h3>Rating:</h3>
        <div class="rate">
            <input type="radio" id="star5" name="rate" value="5" />
            <label for="star5" title="text">&#9733;</label>

            <input type="radio" id="star4" name="rate" value="4" />
            <label for="star4" title="text">&#9733;</label>

            <input type="radio" id="star3" name="rate" value="3" />
            <label for="star3" title="text">&#9733;</label>

            <input type="radio" id="star2" name="rate" value="2" />
            <label for="star2" title="text">&#9733;</label>

            <input type="radio" id="star1" name="rate" value="1" />
            <label for="star1" title="text">&#9733;</label>
    
    	</div>
    	<h5 style="position: relative;bottom:195px;"><a href="javascript:void(0)" onclick = "submit()">送出</a></h5>
    	<h5 style="position: relative;bottom:190px;"><a href="javascript:void(0)" onclick = "toRestaurant()">返回餐廳</a></h5>
    	<h5 style="position: relative;bottom:185px;"><a href="javascript:void(0)" onclick = "toFunctionList()">返回主選單</a></h5>
    	</form>
  
    

    


</div>
</body>
<script>
	function submit(){
		document.location.assign("/Final_Project_G4/RestaurantPage?${user}&${RestID}");
	}

	function toRestaurant(){
		document.location.assign("/Final_Project_G4/RestaurantPage?${user}&${RestID}");
	}

	function toFunctionList(){
		document.location.assign("/Final_Project_G4/FunctionListPage?${user}");
	}
</script>
</html>