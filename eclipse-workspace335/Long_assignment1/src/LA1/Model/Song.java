package LA1.Model;

public class Song {
	private String name;
	private String artist;
	private String album;
	private int userRating;
	
	public Song(String song, String artist, String album){
		this.name = song;
		this.artist = artist;
		this.album = album;
	}
	
	public String getSongTitle(){
		return this.name;
	}
	
	public String getArtistName(){
		return this.artist;
	}

	public String getAlbumTitle(){
		return this.album;
	}
	
}
