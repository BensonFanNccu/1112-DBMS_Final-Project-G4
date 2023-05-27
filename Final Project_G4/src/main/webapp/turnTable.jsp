<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<style>

*{
margin: 0;
padding: 0;
box-sizing: border-box;
font-family: sans-serif;
}

.container{
position:relative;top:30px ;
width: 350px;
height: 350px;
display: flex;
justify-content: center;
align-items: center;
}

.container .spinBtn{
position: absolute;
width: 60px;
height: 60px;
background: #fff;
border-radius: 50%;
z-index: 10;
display: flex;
justify-content: center;
align-items: center;
text-transform: uppercase;
letter-spacing: 0.1em;
font-weight: 600;
color: #333;
border: 4px solid rgba(0,0,0,0.75);
cursor: pointer;
user-select: none;
}

.container .spinBtn::before{
content: '';
position: absolute;
top: -28px;
width: 20px;
height: 30px;
background: #fff;
clip-path: polygon(50% 0,15% 100%,85% 100%);
}

.container .wheel{
position: absolute;
top: 0;
left: 0;
width: 100%;
height: 100%;
background: #333;
border-radius: 50%;
overflow: hidden;
box-shadow: 0 0 0 5px #333,0 0 0 15px #fff,0 0 0 18px #111;
transition: transform 5s ease-in-out;
}

.container .wheel .number{
position: absolute;
width: 50%;
height: 50%;
background: var(--clr);
transform-origin: bottom right;
transform: rotate(calc(45deg * var(--i)));
clip-path: polygon(0 0,56% 0,100% 100%,0 56%);
display: flex;
justify-content: center;
align-items: center;
user-select: none;
cursor: pointer;
}

/* 360 / 8 = 45deg */
.container .wheel .number span{
position: relative;
transform: rotate(45deg);
font-size: 0.6em;
font-weight: 700;
color: #fff;
text-shadow: 3px 5px 2px rgba(0,0,0,0.15);
}

.container .wheel .number span::after{
position: absolute;
font-size: 0.75em;
font-weight: 500;

}
</style>
<head>
	<meta charset="utf-8">
    <title>RestaurantChooser</title>
    <meta name="viewpoint" content="width=device-width,initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/restaurantChooser.css">
</head>
<body>
	<div class="system_name">
        <img src="images/logo.png" width="200" height="150"  >
      </div>
        <div id="container7">
            <div class="container">
                <div class="spinBtn">Spin</div>
                    <div class="wheel">
                        <div class="number" style="--i:1;--clr:#db7093;">
                            <span>餐廳名稱（寫死？）</span></div>
                        <div class="number" style="--i:2;--clr:#20b2aa;">
                            <span>餐廳名稱（寫死？）</span></div>
                        <div class="number" style="--i:3;--clr:#daa520;">
                            <span>餐廳名稱（寫死？）</span></div>
                        <div class="number" style="--i:4;--clr:#ff340f;">
                            <span>餐廳名稱（寫死？）</span></div>
                        <div class="number" style="--i:5;--clr:#4169e1;">
                            <span>餐廳名稱（寫死？）</span></div>
                        <div class="number" style="--i:6;--clr:#3cb371;">
                            <span>餐廳名稱（寫死？）</span></div>
                        <div class="number" style="--i:7;--clr:#d63e92;">
                            <span>餐廳名稱</span></div>
                        <div class="number" style="--i:8;--clr:#ff7f50;">
                            <span>餐廳名稱</span></div>
                    </div>
                <h5 style="position: relative;top:210px;" ><a href="javascript:void(0)" onclick = "toFunctionList()">返回主選單</a></h5>                        
            </div>
        </div>
</body>
<script>
	let wheel = document.querySelector('.wheel');
	let spinBtn = document.querySelector('.spinBtn');
	let value = Math.ceil(Math.random() * 3600);

	spinBtn.onclick = function(){
    	wheel.style.transform = "rotate(" + value + "deg)"
    	value += Math.ceil(Math.random() * 3600);
	}
	
	function toFunctionList(){
  		window.location.replace("/Final_Project_G4/FunctionListPage${user}");
  	}
</script>
</html>