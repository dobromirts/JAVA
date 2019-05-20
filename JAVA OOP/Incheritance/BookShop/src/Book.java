public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String author, String title, double price) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPrice(price);
    }

    private void setTitle(String title) {
        if (title.length()<3){
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title=title;

    }

    private void setAuthor(String author) {
        String[]autorNames=author.split(" ");
        if (Character.isDigit(autorNames[1].charAt(0))){
            throw new IllegalArgumentException("Author not valid!");
        }
        this.author=author;

    }

    private void setPrice(double price) {
        if (price<1){
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price=price;
    }

    private String getTitle() {
        return title;
    }

    private String getAuthor() {
        return author;
    }

    protected double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(this.getPrice())
                .append(System.lineSeparator());
        return sb.toString();

    }
}