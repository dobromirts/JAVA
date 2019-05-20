import java.util.Arrays;

public class Song {
    private String artistName;
    private String songName;
    private String length;

    public Song(String artistName, String songName, String length) throws InvalidSongException {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setLength(length);
    }

    private void setArtistName(String artistName) throws InvalidArtistNameException {
        if (artistName.length()<3 || artistName.length()>20){
            throw new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
        }
        this.artistName = artistName;
    }

    private void setSongName(String songName) throws InvalidSongNameException {
        if (songName.length()<3 || songName.length()>30){
           throw new InvalidSongNameException("Song name should be between 3 and 30 symbols.");
        }
        this.songName = songName;
    }

    private void setLength(String length) throws InvalidSongLengthException {
        int[]totalLength= Arrays.stream(length.split(":")).mapToInt(Integer::parseInt).toArray();
        int minutes=totalLength[0];
        int seconds=totalLength[1];

        if (minutes<0 || minutes>14){
            throw new InvalidSongMinutesException("Song minutes should be between 0 and 14.");
        }

        if (seconds<0 || seconds>59){
            throw new InvalidSongSecondsException("InvalidSongSecondsException");
        }

        this.length = length;
    }

    public String getLength(){
       return this.length;

    }


}
