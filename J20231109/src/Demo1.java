import java.util.*;
public class Demo1 {
	public static void main(String[] args)
	{Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int n=sc.nextInt();
			for (int i = 0; i <n ; i++) {

				int Totalnumber=sc.nextInt();//参加考试的总人数
				int [] a=new int[Totalnumber];//建立数组存放成绩
				int Enrolment=sc.nextInt();//输入最多可以录取的人数
				int Max=0;//存放最高成绩
				for (int j = 0; j <Totalnumber; j++) {
					a[j]=sc.nextInt();
					if(a[j]>=Max) Max=a[j];//存放最高成绩
				}
				Arrays.sort(a);//方法，快排；
				int s=0;//存放高分的人数
				int k=0;//存放分数重复的人的个数
				int Max2=0;//Max会在最高分的人数不满足需求的时候改为次高分，这时用来保存最大值（Max），防止次高分人数过多时候舍去次高分的人时返回原先的录取分数；
				for (int j = Totalnumber-1; j >=0; j--) {//排序后最大值在最后，所以用倒序循环；
					if(a[j]==Max)
					{
						s++;k++;
						if(s>Enrolment)//如果过多，直接返回-1；
						{fuction(i+1,-1,-1);break;}
						if(s==Enrolment)//如果人数满足所需要的人数；
						{
							if(j!=0){//j!=0代表循环没有到最后一个数；
								if (a[j-1]!=a[j])
								{fuction(i+1,Enrolment,Max);break;}
								else if (a[j-1]==a[j])
								{fuction(i+1,Enrolment-k,Max2);break;}
							}
							else if(Enrolment==Totalnumber) {fuction(i+1,Enrolment,Max);break;}//代表判断最后一个数是否满足需要，最后一个数需要单独拿出来判断，如果继续用a[j-1]==a[j]会造成数组的溢出，因为a[0]不能和a[-1]比较吧；
						}
					}
					else {
						Max2=Max;
						Max=a[j];
						j++;
						k=0;//清空原Max的个数，因为执行这条代码时候一定是和Max等价的值不够用了；
					}
				}

			}
		}
	}
	public static void fuction(int i,int a,int b) {
		if(a!=0 && b!=0)
		System.out.println("Case #"+i+": "+a+" "+b);
		else System.out.println("Case #"+i+": "+-1+" "+-1);
	}
}