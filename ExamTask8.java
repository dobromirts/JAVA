import java.util.Scanner;

public class ExamTask8 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String []input=scanner.nextLine().split("\\s+");
        double result=0;

        for (String s : input) {
            char first=s.charAt(0);
            char last=s.charAt(s.length()-1);

            double num=Double.parseDouble(s.substring(1,s.length()-1));

            if (Character.isUpperCase(first)){
                num=num/(first-'A'+1);
            }else {
                num=num*(first-'a'+1);
            }

            if (Character.isUpperCase(last)){
                num=num-(last-'A'+1);
            }else {
                num=num+(last-'a'+1);
            }
            result+=num;



        }

//        for (int i = 0; i <input.length ; i++) {
//            String currentTag=input[0];
//            String modified=currentTag.substring(1,currentTag.length()-1);
//            double number=Double.parseDouble(modified);
//
//
//            if (Character.isLowerCase(currentTag.charAt(0))){
//                result+=number*(modified.charAt(0)-'a'+1);
//
//            }else {
//                result+=number/(currentTag.charAt(0)-'A'+1);
//            }
//        }
//        for (int i = 0; i <input.length ; i++) {
//            String currentTag=input[0];
//            String modified=currentTag.substring(1,currentTag.length()-1);
//            double number=Double.parseDouble(modified);
//
//            if (Character.isLowerCase(currentTag.charAt(0))){
//                result+=number+(modified.charAt(0)-'a'+1);
//
//            }else {
//                result+=number-(modified.charAt(0)-'A'+1);
//            }
//        }

        System.out.printf("%.2f",result);


    }

}

