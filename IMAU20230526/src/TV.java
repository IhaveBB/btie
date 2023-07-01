public class TV {
    int channel;
    public int getChannel(int id) {
        return channel;
    }
    public TV(){
        channel = 1;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }
    public void showProram(){
        switch (channel) {
            case 1:
                System.out.println("综合频道");
                break;
            case 2:
                System.out.println("经济频道");
                break;
            case 3:
                System.out.println("文艺频道");
                break;
            case 4:
                System.out.println("国际频道");
                break;
            case 5:
                System.out.println("体育频道");
                break;
            default:
                System.out.println("其他频道暂未开通");
        }

    }
}
