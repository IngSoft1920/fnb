var disponible=false;
var numerodemesas=9;
var x=75;
var y=55;
var capacidad=1;
function setup() {
  createCanvas(400, 400);
  background(0,0,200);
}
function draw(){
  while(numerodemesas!=0){
    if(disponible==true){
      fill(200,0,0);
      disponible=false;
    }
    else if(disponible==false){
      fill(255,255,255);
      disponible=true;
    }
    rect(x,y,60,40);
    fill(0,0,0);
    textSize(24);
    text(capacidad,x+23,y+28);
    capacidad=capacidad+1;
    if(y<260){
      y=y+80;
    }
    else if(y>260&&x<240){
      x=x+100;
      y=55;
    }
    numerodemesas=numerodemesas-1;
  }
  
}
function mousePressed(){
  createCanvas(1000,1000);
  background(250,0,200);
  text('word',10,60);
}