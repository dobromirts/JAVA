import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
         int size=Integer.parseInt(scanner.nextLine());
         String[][]matrix=new String[size][size];

         int snakeRow=-1;
         int snaceCol=-1;
         int snakeLenght=1;

         int food=0;

         String[]commands=scanner.nextLine().split(", ");

        for (int row = 0; row <size ; row++) {
            String[]tokens=scanner.nextLine().split(" ");
            for (int col = 0; col <size ; col++) {
                char current=tokens[col].charAt(0);
                if (current=='s'){
                    snakeRow=row;
                    snaceCol=col;
                }
                if (current=='f'){
                    food++;
                }
                matrix[row][col]=current+"";
            }
        }


        for (int i = 0; i <commands.length ; i++) {
            String command=commands[i];

            switch (command){
                case "left":
                    snaceCol-=1;
                    if (matrix[snakeRow][snaceCol].equals("*")){
                        continue;
                    }else if (matrix[snakeRow][snaceCol].equals("f")){
                        food--;
                        snakeLenght+=1;
                    }else if (matrix[snakeRow][snaceCol].equals("s")){
                        continue;
                    } else {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    }

                    break;
                case "right":
                    snaceCol+=1;
                    if (snaceCol==size){
                        snaceCol=0;
                    }
                    if (matrix[snakeRow][snaceCol].equals("*")){
                        continue;
                    }else if (matrix[snakeRow][snaceCol].equals("f")){
                        food--;
                        snakeLenght+=1;
                    }else if (matrix[snakeRow][snaceCol].equals("s")){
                        continue;
                    } else {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    }
                    break;
                case "up":
                    snakeRow-=1;
                    if (matrix[snakeRow][snaceCol].equals("*")){
                        continue;
                    }else if (matrix[snakeRow][snaceCol].equals("f")){
                        food--;
                        snakeLenght+=1;
                    }else if (matrix[snakeRow][snaceCol].equals("s")){
                        continue;
                    } else {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    }
                    break;
                case "down":
                    snakeRow+=1;
                    if (matrix[snakeRow][snaceCol].equals("*")){
                        continue;
                    }else if (matrix[snakeRow][snaceCol].equals("f")){
                        food--;
                        snakeLenght+=1;
                    }else if (matrix[snakeRow][snaceCol].equals("s")){
                        continue;
                    } else {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    }
                    break;
            }

        }

        if (food==0){
            System.out.printf("You win! Final snake length is %d",snakeLenght);
        }
        else {
            System.out.printf("You lose! There is still %d food to be eaten.",food);
        }

        System.out.println();
    }
}
