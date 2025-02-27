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
	
	public song findSong(Song song){
		String songTitle = "";
		String findSongTitle = song.getSongTitle();
		for (int i = 0; i < songList.length(); i++){
			songTitle = songList[i].getSongTitle();
			if (findSongTitle.equals(songTitle)){
				return songList[i].clone();				
			}
		}
		System.out.println("Song titled " + findSongTitle + " cannot be found.\n");
		return null;
	}
	
	
	public album findAlbum(Album album){
		String albumTitle = "";
		String findAlbumTitle = album.getTitle();
		for (int i = 0; i < albumList.length(); i++){
			albumTitle = albumList[i].getTitle();
			if (findAlbumTitle.equals(albumTitle)){
				return albumList[i].clone();
			}
		}
		System.out.println("Album titled " + findAlbumTitle + " cannot be found.\n");
		return null;
	}
	
	public int getNumberOfSongs(){
		return this.songList.size();
	}
	
	public int getNumberOfAlbums(){
		return this.albumList.size();
	}
	
	private void initializeMusicStore(){
		String folder = "";
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
