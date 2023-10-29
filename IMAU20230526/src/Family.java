public class Family {
    TV homeTV;
    public void buyTv(TV tv){
        this.homeTV = tv;
    }
    public void remoterControl(int id){
        homeTV.setChannel(id);
    }
    public void seeTv(){
        homeTV.showProram();
    }

}
