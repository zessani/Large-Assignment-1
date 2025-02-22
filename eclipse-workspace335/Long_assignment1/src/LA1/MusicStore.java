package LA1;

import java.io.BufferedReader;
import java.io.File;

public class MusicStore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");
	}
	
	public MusicStore initializeMusicStore(MusicStore musicStore){
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
					musicStore.addAlbum(newAlbum);
					break;
				}
				else{
					Song newSong = new Song(album,artist,album);
					newAlbum.addSong(newSong);
					musicStore.addSong(newSong);
				}
				musicStore.addAlbum(newAlbum);
			}
		}
		return musicStore;
	}

}
