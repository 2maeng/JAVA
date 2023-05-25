import java.util.Scanner;

public class Test07 {

    public static void main(String[] args) {

        int[] score = new int[6];
        String[] name = new String[6];

        Scanner sc=new Scanner(System.in);
        Scanner sc2=new Scanner(System.in);


        //6명 입력받기
        for(int i=0; i<score.length; i++) {
            System.out.print((i+1)+"번째 학생의 점수를 입력해주세요: ");
            score[i] =sc.nextInt();

            System.out.print((i+1)+"번째 학생의 이름을 입력해주세요: ");
            name[i] =sc2.nextLine();

        }



        //정렬
        for(int i=0; i<score.length; i++) {
            //이미 정렬된 인덱스의 다음부터 비교시작
            for(int k=i+1; k<score.length; k++) {
                //교환 알고리즘
                if(score[k]<score[i]) {
                    int tmp = score[k];
                    score[k] = score[i];
                    score[i] = tmp;

                    String tmp2 = name[k];
                    name[k] = name[i];
                    name[i] = tmp2;
                }
            }
        }

        //출력
        for(int i=0; i<score.length; i++) {
            System.out.println((i+1)+"등한 학생 "+name[i]+"의 점수는"+score[i]+"점입니다");
        }
    }

}