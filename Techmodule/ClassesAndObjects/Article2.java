import java.util.ArrayList;
        import java.util.Comparator;
        import java.util.List;
        import java.util.Scanner;

class Articles2 {
    String title;
    String contetnt;
    String autor;

    public Articles2(String title, String contetnt, String autor) {
        this.title = title;
        this.contetnt = contetnt;
        this.autor = autor;
    }
    public String getTitle(){
        return this.title;
    }
    public String getContetnt(){
        return this.contetnt;
    }
    public String getAutor(){
        return this.autor;
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s",this.getTitle(),this.getContetnt(),this.getAutor());
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());
        List<Articles2> articl=new ArrayList<>();
        while (n-->0){
            String[]tokens=scanner.nextLine().split(", ");
            Articles2 articles2=new Articles2(tokens[0],tokens[1],tokens[2]);

            articl.add(articles2);

        }
        String keyWord=scanner.nextLine();

        if (keyWord.equals("title")){
            articl.stream().sorted(Comparator.comparing(Articles2::getTitle)).forEach(p-> System.out.println(p));

        }else if (keyWord.equals("content")){
            articl.stream().sorted(Comparator.comparing(Articles2::getContetnt)).forEach(w-> System.out.println(w));

        }else if (keyWord.equals("author")){
            articl.stream().sorted(Comparator.comparing(Articles2::getAutor)).forEach(p-> System.out.println(p));

        }




    }


}
