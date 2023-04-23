class Computer {
    private String name;
    private String cpu;
    private String memory;
    private String mainBoard;
    private String disk;
    private String gpu;

    Computer(String na, String cp, String me, String ma, String di, String gp) {
        System.out.printf("名称：%s,处理器:%s,内存:%s,主板:%s,硬盘:%s,显卡:%s\n", na, cp, me, ma, di, gp);
    }

}
