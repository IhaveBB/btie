import java.util.Arrays;
import java.util.Scanner;

public class Demo7 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			int T = input.nextInt();
			for(int i = 0; i < T; i++){

				double values =0;

				int size = input.nextInt();
				Commodity[] commodity = new Commodity[5];
				for(int j1=0;j1<5;j1++) {
					commodity[j1]=new Commodity();
				}
				for(int j3=0;j3<5;j3++) {
					double Weight=input.nextDouble();
					commodity[j3].setWeight(Weight);
				}
				for(int j2=0;j2<5;j2++) {
					double value= input.nextDouble();
					commodity[j2].setValue(value);
				}
				Arrays.sort(commodity);
				int N=0;
				while(size>0 ) {
					if(size>commodity[N].weight) {
						size= (int) (size-commodity[N].weight);
						values=values+commodity[N].value;
						N++;
					}else {
						values=values+(commodity[N].value/commodity[N].weight)*size;
						size=0;
					}

				}

				System.out.printf("%.2f\n",values);

			}
		}
	}
}
class Commodity implements Comparable<Commodity>{
	double value;
	double weight;
	Commodity(){
	}

	public void setValue(double value) {
		this.value = value;
	}

	public void setWeight(double weight){
		this.weight=weight;
	}

	@Override
	public int compareTo(Commodity o) {
		return Double.compare((double) (o.value/o.value),(double) this.value/this.value);
	}



}
