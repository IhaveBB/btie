
public class bankAccount {
    int account;
    double deposit;
    double withdrawal;
    double interest;
    double balance;
    bankAccount(int account) {
        this.account=account;
    }
    //存款
    void depositInfo(double deposit){
        this.deposit=deposit;
        balance=balance+deposit;
        System.out.printf("存款成功，当前余额%f",balance);
    }

    //取款
     void withdrawalInfo(double withdrawal){
        this.withdrawal=withdrawal;
        if(balance>=withdrawal){
            balance=balance-withdrawal;
            System.out.printf("取款成功，当前余额%f",balance);
        }
        else{
            System.out.println("余额不足");
        }
    }
    //查询利息
    void interestInfo(){
        System.out.printf("您的利息为%f",balance*0.013);
    }

    //查询剩余多少余额
    void balanceInfo(){
        System.out.printf("您的余额为%f",balance);
    }





}
