package LA1.Model;

import java.util.ArrayList;

public class Album {

	private String title;
	private String artist;
	private String genre;
	private int year;
	private ArrayList<Song> songs;
	
	
	public Album (String title, String artist, String genre, int year){
		this.title = title;
		this.artist = artist;
		this.genre = genre;
		this.year = year;
		this.songs = new ArrayList<>();
		
		
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public int getYear() {
		return year;
	}
	
	public ArrayList<Song> getSongs(){
		return new ArrayList<>(songs);
	}
	
	public Integer countSongs() {
		return songs.size()
;	}
	
	//public Song getSong(String title) {
		//
	//}
	
	//public void addSong (String songTitle) {
		
	//}

}
