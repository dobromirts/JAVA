import java.util.Scanner;

public class Article {
    static class article{
        private String title;
        private String content;
        private String autor;

        public article(String title,String content,String autor){
            this.title=title;
            this.content=content;
            this.autor=autor;
        }
        public void editMethod(String newContent){
            this.content=newContent;
        }
        public void changeAutor(String newAutor){
            this.autor=newAutor;
        }
        public void rename(String newTitle){
            this.title=newTitle;
        }

        @Override
        public String toString() {
            return String.format("%s - %s: %s",this.title,this.content,this.autor);
        }
    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String[]input=scanner.nextLine().split(", ");

        article article=new article(input[0],input[1],input[2]);

        int n=Integer.parseInt(scanner.nextLine());
        while (n-->0){
            String []command=scanner.nextLine().split(": ");
            String com=command[0];
            if (com.equals("Edit")){
                article.editMethod(command[1]);

            }else if (com.equals("ChangeAuthor")){
                article.changeAutor(command[1]);

            }else {
                article.rename(command[1]);

            }



        }
        System.out.println(article.toString());

    }
}
