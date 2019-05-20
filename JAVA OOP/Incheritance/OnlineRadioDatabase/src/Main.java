import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SongDatabase songDatabase=new SongDatabase();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {

            String[]tokens=scanner.nextLine().split(";");

            try {
                Song song = new Song(tokens[0], tokens[1], tokens[2]);
                songDatabase.addSong(song);
                System.out.println("Song added.");
            } catch (InvalidSongException ex) {
                System.out.println(ex.getMessage());
            }
        }

        System.out.println("Songs added: "+songDatabase.getSongsCount());
        System.out.println("Playlist length "+songDatabase.getTotalLengthOfSongs());
    }
}
