class BMI{
    double weight;
    double height;
    BMI(double w,double h){
        weight=w;
        height=h;
    }
    double getBMI(){
        return weight/(height*height);
    }

}
