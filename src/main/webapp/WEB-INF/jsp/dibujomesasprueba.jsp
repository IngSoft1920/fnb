<%@page import="ingsoft1920.fnb.Beans.ComandaBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
  <head>
   
  
    <meta charset="utf-8"/>
	<script src="https://cdn.jsdelivr.net/npm/p5@1.0.0/lib/p5.js"></script>
  
  
  <label>esto funciona</label>
  
  	<script type="text/javascript">
	
  	var x=55;
    var y=55;
    var capacidad=1;
    var barrera=true;
    
	var nom = [];
    var mesa1={
      x:350,
      y:250,
      color:'blanco',
      id:1
    };
    var mesa2={
      x:350,
      y:350,
      color:'blanco',
      id:2
    };
    var mesa3={
      x:350,
      y:450,
      color:'blanco',
      id:3
    };
    var mesa4={
      x:500,
      y:250,
      color:'blanco',
      id:4
    };
    var mesa5={
      x:500,
      y:350,
      color:'blanco',
      id:5
    };
    var mesa6={
      x:500,
      y:450,
      color:'blanco',
      id:6
    };
    var mesa7={
      x:640,
      y:355,
      color:'blanco',
      id:7
    };
    var mesa8={
      x:640,
      y:455,
      color:'blanco',
      id:8
    };
    var mesa9={
      x:640,
      y:250,
      color:'blanco',
      id:9
    };
    var mesa10={
      x:750,
      y:350,
      color:'blanco',
      id:10
    };
    var mesa11={
      x:840,
      y:250,
      color:'blanco',
      id:11
    };    
    
    var consulta= new Array();
    
    <c:forEach items="${luisBean.getListaMesas()}" var="country"> 
    countryDetails = new Object();
    countryDetails.id = ${country.getMesa_id()};
    countryDetails.op = ${country.getDisponible()};
    consulta.push(countryDetails);
</c:forEach> 
    
    
    
    var miMapa = new Map();
    var i=0;
   // for (i = 0; i < consulta.size(); i++) {
    	 
    	//miMapa.set(consulta[i].getNum_mesa(),consulta[i].getDisponible());
    	
    //	}
    
  
    
    function setup() {
    	createCanvas(3000, 3000);
    	background(255,255,255);//Blanco
    }
    function draw(){
    	if(barrera){	
    		fill(255,255,255);
    		//rect(240,40,1070,550);
    		//rect(250,50,1050,530);
    		line(240,40,240,140);
    		line(250,50,250,140);
    		line(240,220,240,590);
    		line(250,220,250,580);
    		line(240,590,900,590);
    		line(250,580,900,580);
    		line(1050,590,1310,590);
    		line(1050,580,1300,580);
    		line(1310,590,1310,40);
    		line(1300,580,1300,50);
    		line(1310,40,240,40);
    		line(1300,50,250,50);
    		line(250,130,450,130);
    		line(250,140,450,140);
    		line(550,130,700,130);
    		line(550,140,710,140);
    		line(700,130,700,50);
    		line(710,140,710,50);
    		line(710,130,1060,130);
    		line(710,140,1050,140);
    		line(1060,130,1060,270);
    		line(1050,140,1050,280);
    		line(1060,270,1200,270);
    		line(1050,280,1190,280);
    		line(1200,270,1200,370);
    		line(1190,280,1190,370);
    	
    		line(730,50,730,75);
    		line(730,75,1225,75);
    		line(1225,75,1225,50);
    		line(1300,90,1275,90);
    		line(1275,90,1275,300);
    		line(1275,300,1300,300);
    		//fill(0,250,250);
    		rect(1150,130,50,100);
    		rect(1190,430,20,150);
    		fill(255,255,255);
    	
    		//mesa1
    		rect(350,250,40,40);
    		//asientos
    		rect(365,240,10,10);
    		rect(340,265,10,10);
    		rect(365,290,10,10);
    		rect(390,265,10,10);
    	
    		//mesa2
    		rect(350,350,40,40);
    		//
    		rect(365,340,10,10);
    		rect(340,365,10,10);
    		rect(365,390,10,10);
    		rect(390,365,10,10);
    		//mesa3
    		rect(350,450,40,40);
    		//
    		rect(365,440,10,10);
    		rect(340,465,10,10);
    		rect(365,490,10,10);
    		rect(390,465,10,10);
    
    	
    		//mesa4
    		rect(500,250,40,40);
    		//asientos
    		rect(515,240,10,10);
    		rect(490,265,10,10);
    		rect(515,290,10,10);
    		rect(540,265,10,10);
    	
    		//mesa5
    		rect(500,350,40,40);
    		//
    		rect(515,340,10,10);
    		rect(490,365,10,10);
    		rect(515,390,10,10);
    		rect(540,365,10,10);
    		//mesa6
    		rect(500,450,40,40);
    		//
    		rect(515,440,10,10);
    		rect(490,465,10,10);
    		rect(515,490,10,10);
    		rect(540,465,10,10);
    	
    		//
    		//mesa7
    		rect(640,355,30,30);
    		//
    		rect(650,345,10,10);
    		rect(650,385,10,10);
    		//mesa8
    		rect(640,455,30,30);
    		//
    		rect(650,445,10,10);
    		rect(650,485,10,10);
    		//mesa9
    		rect(640,250,80,40);
    		//
    		rect(660,240,10,10);
    		rect(720,265,10,10);
    		rect(660,290,10,10);
    		rect(630,265,10,10);
    		rect(690,240,10,10);
    		rect(690,290,10,10);
    		//mesa 10
    		rect(750,350,40,120);
    		//
    		rect(740,365,10,10);
    		rect(740,405,10,10);
    		rect(740,445,10,10);
    		rect(790,365,10,10);
    		rect(790,405,10,10);
    		rect(790,445,10,10);
    		rect(765,340,10,10);
    		rect(765,470,10,10);
    
    		//mesa11
    		rect(840,250,80,40);
    		//
    		rect(860,240,10,10);
    		rect(920,265,10,10);
    		rect(860,290,10,10);
    		rect(830,265,10,10);
    		rect(890,240,10,10);
    		rect(890,290,10,10);
    	
    	
    		fill(255,0,0);
    		textSize(20);
    		text('ASEOS',380,90);
    		text('COCINA',1050,105);
    		text('COMEDOR',690,200);
    	
    	
        }
    	
    	
		
    	
     
    }
      

    function mouseClicked(){
    	if(mouseX>mesa1.x&&mouseX<mesa1.x+40){
    	    if(mouseY>mesa1.y&&mouseY<mesa1.y+40){
    	  
              if(mesa1.color=='rojo'){
                mesa1.color='blanco';
    	        fill(255,0,0);
    	      }
    	      else if(mesa1.color=='blanco'){
    	        mesa1.color='rojo';
    	        fill(255,255,255);
    	      }
    	    rect(mesa1.x,mesa1.y,40,40);
    	  	rect(365,240,10,10);
    		rect(340,265,10,10);
    		rect(365,290,10,10);
    		rect(390,265,10,10);
    	    barrera=false;
    	    }
    	    else if(mouseY>mesa2.y&&mouseY<mesa2.y+40){
    	      if(mesa2.color=='blanco'){
    	        mesa2.color='rojo';
    	        fill(255,0,0);
    	        
    	      }
    	      else if(mesa2.color=='rojo'){
    	        mesa2.color='blanco';
    	        fill(255,255,255);
    	        
    	      }
    	      rect(mesa2.x,mesa2.y,40,40);
    	      rect(365,340,10,10);
      		  rect(340,365,10,10);
      		  rect(365,390,10,10);
      		  rect(390,365,10,10);
    	      barrera=false;
    	    }
    	    else if(mouseY>mesa3.y&&mouseY<mesa3.y+40){
    	      if(mesa3.color=='blanco'){
    	        mesa3.color='rojo';
    	        fill(255,0,0);
    	      }
    	      else{
    	        mesa3.color='blanco';
    	        fill(255,255,255);
    	      }
    	      rect(mesa3.x,mesa3.y,40,40);
    	      rect(365,440,10,10);
      		  rect(340,465,10,10);
      		  rect(365,490,10,10);
      		  rect(390,465,10,10);
      
    	      barrera=false;
    	    }
    	}
    	else if(mouseX>mesa4.x&&mouseX<mesa4.x+40){
    	    if(mouseY>mesa4.y&&mouseY<mesa4.y+40){
    	      if(mesa4.color=='blanco'){
    	        mesa4.color='rojo';
    	        fill(255,0,0);
    	      }
    	      else{
    	        mesa4.color='blanco';
    	        fill(255,255,255);
    	      }
    	      rect(mesa4.x,mesa4.y,40,40);
    	      rect(515,240,10,10);
      		rect(490,265,10,10);
      		rect(515,290,10,10);
      		rect(540,265,10,10);
    	      barrera=false;
    	    }
           else if(mouseY>mesa5.y&&mouseY<mesa5.y+40){
    	      if(mesa5.color=='blanco'){
    	        mesa5.color='rojo';
    	        fill(255,0,0);
    	      }
    	      else{
    	        mesa5.color='blanco';
    	        fill(255,255,255);
    	      }
    	      rect(mesa5.x,mesa5.y,40,40);
    	      rect(515,340,10,10);
      		rect(490,365,10,10);
      		rect(515,390,10,10);
      		rect(540,365,10,10);
    	      barrera=false;
    	    }
           else if(mouseY>mesa6.y&&mouseY<mesa6.y+40){
    	      if(mesa6.color=='blanco'){
    	        mesa6.color='rojo';
    	        fill(255,0,0);
    	      }
    	      else{
    	        mesa6.color='blanco';
    	        fill(255,255,255);
    	      }
    	      rect(mesa6.x,mesa6.y,40,40);
    	      rect(515,440,10,10);
      		rect(490,465,10,10);
      		rect(515,490,10,10);
      		rect(540,465,10,10);
      	
    	      barrera=false;
    	    }
    
   
    	}
    	else if(mouseX>mesa7.x&&mouseX<mesa7.x+30){
    		if(mouseY>mesa7.y&&mouseY<mesa7.y+30){
       	      if(mesa7.color=='blanco'){
       	        mesa7.color='rojo';
       	        fill(255,0,0);
       	      }
       	      else{
       	        mesa7.color='blanco';
       	        fill(255,255,255);
       	      }
       	      rect(mesa7.x,mesa7.y,30,30);
       	   rect(650,345,10,10);
   		rect(650,385,10,10);
       	      barrera=false;
       	    }
    		else if(mouseY>mesa8.y&&mouseY<mesa8.y+30){
       	      	if(mesa8.color=='blanco'){
       	        	mesa8.color='rojo';
       	        	fill(255,0,0);
       	      	}
       	      	else{
      	        	mesa8.color='blanco';
      	        	fill(255,255,255);
      	     	}
       	     	rect(mesa8.x,mesa8.y,30,30);
       	 	rect(650,445,10,10);
    		rect(650,485,10,10);
       	     	barrera=false;
       	    }
    	}
    	else if(mouseX>mesa9.x&&mouseX<mesa9.x+80){
    	
    	    if(mouseY>mesa9.y&&mouseY<mesa9.y+40){
   	      		if(mesa9.color=='blanco'){
   	        		mesa9.color='rojo';
   	        		fill(255,0,0);
   	      		}
   	      		else{
   	        		mesa9.color='blanco';
   	        		fill(255,255,255);
   	      		}
   	      		rect(mesa9.x,mesa9.y,80,40);
   	      	rect(660,240,10,10);
    		rect(720,265,10,10);
    		rect(660,290,10,10);
    		rect(630,265,10,10);
    		rect(690,240,10,10);
    		rect(690,290,10,10);
   	      		barrera=false;
   	    	}
    	}
    	else if(mouseX>mesa10.x&&mouseX<mesa10.x+40){
        	
    	 	if(mouseY>mesa10.y&&mouseY<mesa10.y+120){
   	      		if(mesa10.color=='blanco'){
   	        		mesa10.color='rojo';
   	        		fill(255,0,0);
   	      		}
   	      		else{
   	        		mesa10.color='blanco';
   	        		fill(255,255,255);
   	      		}
   	      		rect(mesa10.x,mesa10.y,40,120);
   	 		rect(740,365,10,10);
    		rect(740,405,10,10);
    		rect(740,445,10,10);
    		rect(790,365,10,10);
    		rect(790,405,10,10);
    		rect(790,445,10,10);
    		rect(765,340,10,10);
    		rect(765,470,10,10);
   	      		barrera=false;
   	    	}
    	}
    	else if(mouseX>mesa11.x&&mouseY<mesa11.x+80){
    		if(mouseY>mesa11.y&&mouseY<mesa11.y+40){
   	      		if(mesa11.color=='blanco'){
   	        		mesa11.color='rojo';
   	        		fill(255,0,0);
   	      		}
   	      		else{
   	        		mesa11.color='blanco';
   	        		fill(255,255,255);
   	      		}
   	      		rect(mesa11.x,mesa11.y,80,40);
   	     	rect(860,240,10,10);
    		rect(920,265,10,10);
    		rect(860,290,10,10);
    		rect(830,265,10,10);
    		rect(890,240,10,10);
    		rect(890,290,10,10);
   	      		barrera=false;
   	    	}
    	}
   }

	
    
  
    </script>
    <script type="text/javascript" src="sketch.js"></script>
    
    </head>
  </body>
</html>
