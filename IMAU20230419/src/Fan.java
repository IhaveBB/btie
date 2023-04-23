public class Fan {
    final static int SLOW=1;
    final static int MEDIUM=2;
    final static int FAST=3;
    private int speed=1;
    private boolean on = false;
    private double radius =5;
    private String color="blue";
    public void setSpeed(int speed){
        this.speed=speed;
    }
    public void setOn(String state){
        if(state=="off"){
            on=false;
        }
        else if(state=="on"){
            on=true;
        }
    }
    public void setRadius(int radius){
        this.radius=radius;
    }
    public void setColor(String color){
        this.color=color;
    }
    public int getSpeed(){
        return speed;
    }
    public boolean getOn(){
        return on;
    }
    public double getRadius(){
        return radius;
    }
    public String getColor(){
        return color;
    }
    Fan(){
    }
    public String toString(){
        if(on){
            return "速度:"+speed+"|"+"颜色"+color+"|"+"半径"+radius;
        }
        else{
            return "Fan is off"+"|"+"颜色"+color+"|"+"半径"+radius;
        }
    }

}
