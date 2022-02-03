package date_2022_01_31;
import java.util.Scanner;
public class SWEA_1940 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		int speed;
        int recnum;
        int order;
        int amount;
        int move;
		for(int test_case = 1; test_case <= T; test_case++)
		{
            move=0;
			recnum = sc.nextInt();
            speed=0;
            for(int i=0;i<recnum;i++){
                order = sc.nextInt();
                if(order == 1){
                    amount = sc.nextInt();
                    speed+=amount;
                }
                if(order == 2){
                    amount = sc.nextInt();
                    speed -= amount;
                    if(speed < 0){
                        speed =0;
                    }
                }
                move+=speed;
            }
            System.out.println("#" + test_case + " " +move);
			
		}
		sc.close();
	}

}
