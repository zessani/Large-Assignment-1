package LA1;

import java.io.BufferedReader;
import java.io.File;


public class MusicStore {
	private ArrayList<Song> songList;
	private ArrayList<Album> albumList;
	
	public MusicStore(){
		this.songList = new ArrayList<Song>();
		this.albumList = new ArrayList<Album>();
		initializeMusicStore();
	}

	public void addSong(Song song){
		songList.add(song);
	}
	
	public void addAlbum(Album album){
		albumList.add(album);
	}
	
	public Song searchSongByTitle(String title){
		title = title.toLowerCase();
		String songTitle = "";
		ArrayList<Song> result = new ArrayList<>();
		for ( Song song : this.songList) {
			songTitle = song.getSongTitle();
			if (songTitle.toLowerCase().equals(title)) {
				result.add(song);
			}
		}
		if (result.size() == 0) {
			System.out.println("Song titled " + title + " cannot be found.\n");
			return null;	
		}
		return result;

		}
	
	public Song searchSongByArtist(String artist) {
		artist = artist.toLowerCase();
		String songArtist = "";
		ArrayList<Song> result = new ArrayList<>();
		for ( Song song : this.songList) {
			songArtist = song.getArtistName();
			if (songArtist.toLowerCase().equals(artist)) {
				result.add(song);
			}
		}
		if (result.size() == 0) {
			System.out.println("Song made by " + artist + " cannot be found.\n");
			return null;	
		}
		return result;
		}
	
	public Album searchAlbumByTitle(String title){
		title = title.toLowerCase();
		String albumTitle = "";
		ArrayList<Song> result = new ArrayList<>();
		for ( Album album : this.albumList) {
			albumTitle = album.getTitle();
			if (albumTitle.toLowerCase().equals(title)) {
				result.add(album);
			}
		}
		if (result.size() == 0) {
			System.out.println("Album titled " + title + " cannot be found.\n");
			return null;	
		}
		return result;
		}
	
	public Album searchAlbumByArtist(String artist){
		artist = artist.toLowerCase();
		String albumArtist = "";
		ArrayList<Song> result = new ArrayList<>();
		for ( Album album : this.albumList) {
			albumArtist = album.getArtist();
			if (albumArtist.toLowerCase().equals(artist)) {
				result.add(album);
			}
		}
		if (result.size() == 0) {
			System.out.println("Album made by " + artist + " cannot be found.\n");
			return null;	
		}
		return result;
		}
	
	public int getNumberOfSongs(){
		return this.songList.length();
	}
	
	public int getNumberOfAlbums(){
		return this.albumList.length();
	}
	
	private void initializeMusicStore(){
		String folder = "https://github.com/zessani/Large-Assignment-1/tree/zayyan/eclipse-workspace335/Long_assignment1/src/LA1/Resources";
		File folder = new File(folder);
		File files[] = folder.listFiles();
		BufferedReader br = new BufferedReader();
		String[] albumInfoSplit = new String[4];
		String albumInfo, album, artist, genre, year;
		for (int i = 0; i < files.length; i++){
			albumInfo = br.readLine();
			albumInfoSplit = albumInfo.split(',');
			album = albumInfoSplit[0];
			artist = albumInfoSplit[1];
			genre = albumInfoSplit[2];
			year = albumInfoSplit[3];
			Album newAlbum = new Album(album,artist,genre,year);
			while (true){
				albumInfo = br.readLine();
				if (albumInfo == null){
					this.addAlbum(newAlbum);
					break;
				}
				else{
					Song newSong = new Song(album,artist,album);
					newAlbum.addSong(newSong);
					this.addSong(newSong);
				}
				this.addAlbum(newAlbum);
			}
		}
	}
}