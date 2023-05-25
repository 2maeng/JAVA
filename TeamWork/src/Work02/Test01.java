package Work02;

import java.util.Scanner;

class Student {

   int num; // 학생 번호
   String name; // 학생 이름
   int score; // 학생 점수

   public Student(int num, String name, int score) { // 학생 생성
      this.num = num;
      this.name = name;
      this.score = score;
   }

   void printStudent() { // 학생 1명 출력 메서드
      System.out.println(this.num + "번 " + this.name + " " + this.score + "점");
   }

   void changeScore(int score) { // 학생 점수 변경 메서드
      this.score = score;
   }

   int printScore() { // main에서 학생 점수값을 가져가는 메서드
      return this.score;
   }

} // Student

public class Test01 {
   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);

      Student[] stu = new Student[3];
      int select; // 선택값 저장용도
      int index = 0; // 입력된 학생 수 확인용

      while (true) { // 무한반복
         System.out.println("==== 학생부 프로그램 ====");
         System.out.println("1. 학생목록 출력");
         System.out.println("2. 학생 1명 출력");
         System.out.println("3. 프로그램 종료");
         System.out.println("====================");

         select = sc.nextInt(); // 목차 선택값 입력
         sc.nextLine(); // 버퍼처리

         if (select == 1) { // 학생목록출력
            if (index == 0) { // 입력된 학생이 없을때
               System.out.println("출력할 학생목록이 없습니다!");
               continue; // 처음으로
            }

            System.out.println("=== 학생목록 ===");
            for (int i = 0; i < index; i++) { // 기록된 학생수 만큼
               stu[i].printStudent(); // 학생 기록 출력
            }
            System.out.println("==============");
         } // 학생 목록 출력 완료

         else if (select == 2) { // 학생1명 출력
            int num = 0;
            if (index == 0) { // 입력된 학생이 없을때
               System.out.println("출력할 학생목록이 없습니다!");
               continue; // 처음으로
            }

            System.out.print("학생번호를 입력해주세요 : ");
            num = sc.nextInt() - 1; // 학생 인덱스번호
            sc.nextLine(); // 남는 입력값 처리 == 버퍼 처리

            if (num >= stu.length || num < 0) { // 입력번호가 유효하지 않을 때
               System.out.println("해당 번호는 유효하지 않은 번호입니다");
               continue; // 처음으로
            } else if (num >= index) { // 입력번호가 존재하지 않을 때
               System.out.println((num + 1) + "번 학생은 정보가 존재하지 않습니다");
               continue; // 처음으로
            }
            stu[num].printStudent(); // 학생 정보 출력 메서드
         }

         else if (select == 3) { // 프로그램 종료

            System.out.println("프로그램을 종료합니다");
            break; // 반복 종료
         }

         else if (select == 777) { // 관리자 모드
            int count = 0; // 비밀번호 틀린 횟수

            while (true) { // 비밀번호 입력 반복용

               System.out.print("Password : "); // 비밀번호
               int password = sc.nextInt(); // 임시변수
               sc.nextLine(); // 버퍼처리

               if (password == 1234) { // 관리자 모드
                  System.out.println("관리자 모드입니다.");

                  while (true) { // 관리자 페이지
                     System.out.println();
                     System.out.println("==== 학생부 프로그램 관리자 모드 ====");
                     System.out.println("1. 학생 생성");
                     System.out.println("2. 학생목록 출력");
                     System.out.println("3. 학생 점수 변경");
                     System.out.println("4. 관리자 모드 종료");
                     System.out.println("==============================");

                     System.out.print("입력 : ");
                     select = sc.nextInt(); // 입력값
                     sc.nextLine(); // 버퍼처리

                     if (select == 1) { // 학생생성
                        String name; // 이름 임시변수
                        int score; // 점수 임시변수

                        while (true) {
                           if (index == stu.length) {// 학생의 수와 최대 학생의 수가 같음
                              System.out.println("학생은 3명까지만 만들 수 있습니다..");
                              break;// 종료
                           }
                           System.out.println((index + 1) + "번 학생의 이름을 입력해주세요");
                           System.out.print("입력 : ");
                           name = sc.next();// 학생 이름 입력
                           sc.nextLine(); // 버퍼처리

                           while (true) {// 학생이름 유효성 검사
                              int tmp;

                              System.out.println("정말 " + name + " 학생으로 하시겠습니까?");
                              System.out.println("1) 예 2) 아니오");
                              tmp = sc.nextInt();
                              sc.nextLine(); // 버퍼처리

                              if (tmp == 1) {// 예
                                 break;
                              } else if (tmp == 2) {// 아니오
                                 name = "";
                                 System.out.println("이름을 다시 입력해주세요");
                                 break;
                              } else { // 입력값이 잘못되었다면
                                 System.out.println("잘못된 입력입니다");
                                 System.out.println("다시 입력해주세요...");
                                 continue;// 잘못된 입력이라면 예 아니오 다시 물어보기
                              } // end if
                           } // end while

                           if (name.equals("")) { // 이름이 비워져있다면 입력부분으로 돌아가기
                              continue; // 다시 이름 입력받기
                           }

                           while (true) {
                              System.out.println("점수를 입력해주세요.");
                              System.out.print("입력 : ");
                              score = sc.nextInt(); // 점수 입력 받음
                              sc.nextLine(); // 버퍼처리

                              if (score < 0 || score > 100) {// 점수의 유효성 검사

                                 System.out.println("점수는 0점 미만 또는 100점을 초과할 수 없습니다..");
                                 continue; // 다시 입력

                              } else {
                                 break;
                              } // 점수 유효성 검사 완료

                           } // end while
                           stu[index] = new Student(index + 1, name, score);// 번호, 이름과 점수를 객체 배열에 저장

                           stu[index].printStudent(); // 학생정보출력
                           System.out.println( // 저장된 학생수 안내
                                 (index + 1) + "명 입력되어있습니다. 앞으로 " + (3 - (index + 1)) + "명 만큼 입력할 수 있습니다.");
                           index++;// 저장 성공 -> 인덱스 값 증가
                           break;
                        } // end while

                     } // 학생 생성 완료

                     else if (select == 2) { // 학생목록출력
                        if (index == 0) { // 입력된 학생이 없을때
                           System.out.println("출력할 학생목록이 없습니다!");
                           continue; // 처음으로
                        }

                        System.out.println("=== 학생목록 ===");
                        for (int i = 0; i < index; i++) { // 기록된 학생수 만큼
                           stu[i].printStudent(); // 학생 기록 출력
                        }
                        System.out.println("==============");
                     } // 학생 목록 출력 완료

                     else if (select == 3) { // 학생점수변경

                        if (index == 0) { // 입력된 학생이 없을때
                           System.out.println("점수 변경할 학생목록이 없습니다!");
                           continue; // 처음으로
                        }
                        while (true) {
                           System.out.println("몇 번 학생의 점수를 변경하시겠습니까?");
                           for (int i = 0; i < index; i++) { // 학생 정보 출력
                              stu[i].printStudent();
                           }
                           int cnt = sc.nextInt(); // 몇 번째 학생을 선택할 것인지
                           sc.nextLine(); // 버퍼처리

                           if (cnt <= 0 || cnt > stu.length) { // 아직 생성되지 않은 값이나, 배열 범위를 넘는다면
                              System.out.println("유효하지 않은 값입니다");
                              System.out.println("다시 선택해주세요");
                              continue; // 다시 실행
                           } else if (cnt > index) { // 생성되지 않은 배열번호
                              System.out.println("학생 정보가 없습니다");
                              System.out.println("다시 선택해주세요");
                              continue;
                           }

                           int score = stu[cnt - 1].printScore(); // 점수 불러오기
                           System.out.println(cnt + " 번 학생의 현재 점수는 " + score + " 입니다.");
                           while (true) {
                              System.out.println("몇 점으로 변경하시겠습니까?");

                              int change = sc.nextInt(); // 사용자 입력
                              sc.nextLine(); // 버퍼처리

                              if (change < 0 || change > 100) { // 점수 유효값 확인
                                 System.out.println("점수는 0~100점 사이입니다.");
                                 System.out.println("다시 선택해주세요");
                                 continue;
                              }
                              stu[cnt - 1].changeScore(change); // 변경 할 점수
                              score = stu[cnt - 1].printScore(); // 점수 불러오기 --> 변경이 제대로 되었는지 확인

                              System.out.println(cnt + " 번 학생의 점수가 " + score + "로 변경되었습니다.");

                              break;
                           }
                           break;
                        }

                     } // 관리자모드 3

                     else if (select == 4) { // 관리자모드 종료
                        System.out.println("관리자모드를 종료합니다");
                        break;
                     }

                     else { // 입력값이 잘못되었을때
                        System.out.println("잘못된 입력값입니다");
                        System.out.println("다시 입력해 주십시오");
                     } // 관리자모드 목차 선택
                  } // 관리자 페이지 종료
                  break; // 비밀번호 입력 종료하고 처음으로

               } else { // 관리자 password 가 틀렸을 때
                  System.out.println("Wrong password");
                  count++; // 첫번째 입력 틀렸을때 1
               } // 관리자모드 접속실패

               if (count == 3) { // 비밀번호가 3회 틀렸다면
                  System.out.println("처음으로 돌아갑니다");
                  count = 0;
                  break; // 반복종료
               }
            } // 비밀번호 입력 반복

         } else { // 입력값이 잘못되었을때
            System.out.println("잘못된 입력값입니다");
            System.out.println("다시 입력해 주십시오");
         } // 사용자모드 목차 선택

      } // while
      sc.close(); // 스케너 종료
   } // main

} // class