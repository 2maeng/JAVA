package homework;

import java.util.Scanner;

public class HomeWork {

	// 짝수이고 0보다 클때 호출할 함수
	public static int countEvenNumber(int[] numbers){
		int res = 0;
		for(int i = 0; i < numbers.length ; i++) {
			if(numbers[i] % 2 == 0 && numbers[i] > 0) {
				res++;
			}
		}
		return res;
	}
	
	// 음수일때 호출할 함수
	public static int countNeagativeNumber(int[] numbers) {
		int res = 0;
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] < 0) {
				res++;
			}
		}
		return res;
	}

	// 배열 쓸 필요 없음 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        int[] data = new int[10];
        int cntEvenNum = 0, cntNegativeNum = 0;

        //숫자 10개 입력받기
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d번째 정수 입력: ", i + 1);
            int number = sc.nextInt();

            if (number == 0) {
                System.out.println("입력한 정수가 0입니다. 프로그램 종료.");
                return;
            }
            data[i] = number;
        }
        
        cntEvenNum = countEvenNumber(data);
        cntNegativeNum = countNeagativeNumber(data);
        
        System.out.println("10번 입력하였습니다." + "a = " + cntEvenNum + " " + "b = " + cntNegativeNum);



	}
}	
