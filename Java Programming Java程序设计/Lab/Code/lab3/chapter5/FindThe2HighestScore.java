package lab3.chapter5;
// 5.9

import java.util.Scanner;

public class FindThe2HighestScore {

    public static void main(String[] args) {
        int studentNumber;
        int topScore = -1, secondScore = -1;
        String topStudent = "", secondStudent = "";

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the number of students");
        studentNumber = input.nextInt();
        input.close();

        if(studentNumber<2){
            throw new IllegalArgumentException("The number of students is at least 2");
        }

        System.out.println("Please enter the student name and score");
        for (int i = 0; i < studentNumber; i++) {
            String name = input.next();
            int score = input.nextInt();

            if(score > topScore){
                secondScore = topScore;
                secondStudent = topStudent;
                topScore = score;
                topStudent = name;
            }else if(score > secondScore){
                secondScore = score;
                secondStudent = name;
            }
        }

        //displays the student with the highest score and the student with the second-highest score
        System.out.println("The student with the highest score is:");
        System.out.println(topStudent + " Score: " + topScore);

        System.out.println("The student with the second-highest score is:");
        System.out.println(secondStudent + " Score " + secondScore);

    }
}

