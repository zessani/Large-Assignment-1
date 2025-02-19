package LA1.Model;

import java.io.BufferedReader;
import java.io.File;

public class LibraryModel {

	public static void main(String[] args) {
		MusicStore musicStore = new MusicStore();
		musicStore = initiliazeMusicStore(musicStore);
	}
	
	
	public MusicStore initializeMusicStore(MusicStore musicStore){
		String folder = "C:\\Users\\Budim\\210Workspace\\Githubaaa\\Large-Assignment-1\\eclipse-workspace335\\Long_assignment1\\src\\LA1\\Resources";
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
