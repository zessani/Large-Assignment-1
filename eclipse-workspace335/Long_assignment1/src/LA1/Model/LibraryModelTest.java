package LA1.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import LA1.MusicStore;

class LibraryModelTest {

	@Test
	void test() {
		MusicStore store = new MusicStore();
		LibraryModel library = new LibraryModel(store);
		
		Song song1 = new Song("NOKIA", "Drake", "New Drake");
        Song song2 = new Song("Distance", "AP", "New AP");
        
        library.songs.add(song1);
    
	}

}
