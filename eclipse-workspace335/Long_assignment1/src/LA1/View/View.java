package LA1.View;

import java.util.ArrayList;
import java.util.Scanner;

import LA1.MusicStore;
import LA1.Model.Album;
import LA1.Model.LibraryModel;
import LA1.Model.Playlist;
import LA1.Model.Song;

public class View {
    private LibraryModel model;
    private MusicStore store;
    private Scanner scanner;
    
    public View(LibraryModel model, MusicStore store) {
        this.model = model;
        this.store = store;
        this.scanner = new Scanner(System.in);
    }
    
    public void start() {
        System.out.println("Welcome to Music Library!");
        boolean running = true;
        
        while (running) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Search Music");
            System.out.println("2. My Library");
            System.out.println("3. Playlists");
            System.out.println("4. Rate & Favorite");
            System.out.println("0. Exit");
            System.out.print("> ");
            
            String choice = scanner.nextLine().trim();
            
            switch (choice) {
                case "1": searchMusic(); break;
                case "2": viewLibrary(); break;
                case "3": managePlaylists(); break;
                case "4": rateAndFavorite(); break;
                case "0": running = false; break;
                default: System.out.println("Invalid choice.");
            }
        }
        
        System.out.println("Thanks for using Music Library!");
        scanner.close();
    }
    
    private void searchMusic() {
        System.out.println("\n--- SEARCH ---");
        System.out.println("1. Find song");
        System.out.println("2. Find album");
        System.out.println("0. Back");
        System.out.print("> ");
        
        String choice = scanner.nextLine().trim();
        
        if (choice.equals("0")) return;
        
        System.out.print("Enter search term: ");
        String term = scanner.nextLine().trim();
        
        if (choice.equals("1")) {
            ArrayList<Song> songs = store.searchSongByTitle(term);
            if (songs != null && !songs.isEmpty()) {
                System.out.println("\nFound songs:");
                for (int i = 0; i < songs.size(); i++) {
                    Song song = songs.get(i);
                    System.out.println((i+1) + ". " + song.getSongTitle() + " - " + song.getArtistName());
                }
                System.out.print("\nAdd to library? (song #/n): ");
                String answer = scanner.nextLine().trim();
                
                if (!answer.equalsIgnoreCase("n")) {
                    try {
                        int index = Integer.parseInt(answer) - 1;
                        if (index >= 0 && index < songs.size()) {
                            Song song = songs.get(index);
                            model.addSong(song.getSongTitle(), song.getArtistName());
                            System.out.println("Song added to library!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number.");
                    }
                }
            } else {
                System.out.println("No songs found.");
            }
        } else if (choice.equals("2")) {
            ArrayList<Album> albums = store.searchAlbumByTitle(term);
            if (albums != null && !albums.isEmpty()) {
                System.out.println("\nFound albums:");
                for (int i = 0; i < albums.size(); i++) {
                    Album album = albums.get(i);
                    System.out.println((i+1) + ". " + album.getTitle() + " - " + album.getArtist());
                }
                System.out.print("\nAdd to library? (album #/n): ");
                String answer = scanner.nextLine().trim();
                
                if (!answer.equalsIgnoreCase("n")) {
                    try {
                        int index = Integer.parseInt(answer) - 1;
                        if (index >= 0 && index < albums.size()) {
                            Album album = albums.get(index);
                            model.addAlbum(album.getTitle(), album.getArtist());
                            System.out.println("Album added to library!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number.");
                    }
                }
            } else {
                System.out.println("No albums found.");
            }
        }
    }
    
    private void viewLibrary() {
        System.out.println("\n--- MY LIBRARY ---");
        System.out.println("1. Songs");
        System.out.println("2. Albums");
        System.out.println("3. Favorites");
        System.out.println("0. Back");
        System.out.print("> ");
        
        String choice = scanner.nextLine().trim();
        
        switch (choice) {
            case "1": // Songs
                ArrayList<String> songs = model.getAllSongTitles();
                if (songs.isEmpty()) {
                    System.out.println("No songs in library.");
                } else {
                    System.out.println("\nYour songs:");
                    for (int i = 0; i < songs.size(); i++) {
                        System.out.println((i+1) + ". " + songs.get(i));
                    }
                }
                break;
                
            case "2": // Albums
                ArrayList<String> albums = model.getAllAlbumTitles();
                if (albums.isEmpty()) {
                    System.out.println("No albums in library.");
                } else {
                    System.out.println("\nYour albums:");
                    for (int i = 0; i < albums.size(); i++) {
                        System.out.println((i+1) + ". " + albums.get(i));
                    }
                }
                break;
                 
            case "3": // Favorites
                ArrayList<Song> favorites = model.getFavorites();
                if (favorites.isEmpty()) {
                    System.out.println("No favorite songs.");
                } else {
                    System.out.println("\nYour favorites:");
                    for (int i = 0; i < favorites.size(); i++) {
                        Song song = favorites.get(i);
                        System.out.println((i+1) + ". " + song.getSongTitle() + " - " + song.getArtistName());
                    }
                }
                break;
            
                
                
        }
        
    }
    
    private void managePlaylists() {
        System.out.println("\n--- PLAYLISTS ---");
        System.out.println("1. View playlists");
        System.out.println("2. Create playlist");
        System.out.println("3. Add to playlist");
        System.out.println("0. Back");
        System.out.print("> ");
        
        String choice = scanner.nextLine().trim();
        
        switch (choice) {
            case "1": // View playlists
                ArrayList<String> playlists = model.getAllPlaylists();
                if (playlists.isEmpty()) {
                    System.out.println("No playlists.");
                } else {
                    System.out.println("\nYour playlists:");
                    for (int i = 0; i < playlists.size(); i++) {
                        System.out.println((i+1) + ". " + playlists.get(i));
                    }
                    
                    System.out.print("\nView playlist details? (playlist #/n): ");
                    String answer = scanner.nextLine().trim();
                    
                    if (!answer.equalsIgnoreCase("n")) {
                        try {
                            int index = Integer.parseInt(answer) - 1;
                            if (index >= 0 && index < playlists.size()) {
                                String name = playlists.get(index);
                                Playlist playlist = model.searchPlaylistByName(name);
                                System.out.println("\nSongs in '" + name + "':");
                                ArrayList<Song> songs = playlist.getSongs();
                                if (songs.isEmpty()) {
                                    System.out.println("Playlist is empty.");
                                } else {
                                    for (int i = 0; i < songs.size(); i++) {
                                        Song song = songs.get(i);
                                        System.out.println((i+1) + ". " + song.getSongTitle() + " - " + song.getArtistName());
                                    }
                                }
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number.");
                        }
                    }
                }
                break;
                
            case "2": // Create playlist
                System.out.print("Enter playlist name: ");
                String name = scanner.nextLine().trim();
                if (!name.isEmpty()) {
                    model.newPlaylist(name);
                    System.out.println("Playlist created!");
                }
                break;
                
            case "3": // Add to playlist
                addToPlaylist();
                break;
        }
    }
    
    private void addToPlaylist() {
        ArrayList<String> playlists = model.getAllPlaylists();
        if (playlists.isEmpty()) {
            System.out.println("Create a playlist first.");
            return;
        }
        
        System.out.println("\nSelect playlist:");
        for (int i = 0; i < playlists.size(); i++) {
            System.out.println((i+1) + ". " + playlists.get(i));
        }
        System.out.print("> ");
        
        try {
            int playlistIndex = Integer.parseInt(scanner.nextLine().trim()) - 1;
            if (playlistIndex >= 0 && playlistIndex < playlists.size()) {
                String playlistName = playlists.get(playlistIndex);
                
                ArrayList<String> songTitles = model.getAllSongTitles();
                if (songTitles.isEmpty()) {
                    System.out.println("Add songs to your library first.");
                    return;
                }
                
                System.out.println("\nSelect song:");
                for (int i = 0; i < songTitles.size(); i++) {
                    System.out.println((i+1) + ". " + songTitles.get(i));
                }
                System.out.print("> ");
                
                int songIndex = Integer.parseInt(scanner.nextLine().trim()) - 1;
                if (songIndex >= 0 && songIndex < songTitles.size()) {
                    String songTitle = songTitles.get(songIndex);
                    ArrayList<Song> songs = model.searchSongByTitle(songTitle);
                    
                    if (songs.isEmpty()) {
                        System.out.println("Song not found.");
                    } else {
                        Song song = songs.get(0);
                        model.addToPlaylist(playlistName, song.getSongTitle(), song.getArtistName());
                        System.out.println("Song added to playlist!");
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number.");
        }
    }
    
    private void rateAndFavorite() {
        ArrayList<String> songTitles = model.getAllSongTitles();
        if (songTitles.isEmpty()) {
            System.out.println("No songs in library to rate.");
            return;
        }
        
        System.out.println("\n--- RATE & FAVORITE ---");
        System.out.println("Select song:");
        for (int i = 0; i < songTitles.size(); i++) {
            System.out.println((i+1) + ". " + songTitles.get(i));
        }
        System.out.print("> ");
        
        try {
            int songIndex = Integer.parseInt(scanner.nextLine().trim()) - 1;
            if (songIndex >= 0 && songIndex < songTitles.size()) {
                String songTitle = songTitles.get(songIndex);
                ArrayList<Song> songs = model.searchSongByTitle(songTitle);
                
                if (songs.isEmpty()) {
                    System.out.println("Song not found.");
                } else {
                    Song song = songs.get(0);
                    
                    System.out.println("\n1. Rate song");
                    System.out.println("2. Toggle favorite");
                    System.out.print("> ");
                    
                    String choice = scanner.nextLine().trim();
                    
                    if (choice.equals("1")) {
                        System.out.print("Rating (1-5): ");
                        try {
                            int rating = Integer.parseInt(scanner.nextLine().trim());
                            if (rating >= 1 && rating <= 5) {
                                model.rateSong(song.getSongTitle(), song.getArtistName(), rating);
                                System.out.println("Song rated " + rating + "/5!");
                                if (rating == 5) {
                                    System.out.println("(Added to favorites)");
                                }
                            } else {
                                System.out.println("Rating must be 1-5.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid rating.");
                        }
                    } else if (choice.equals("2")) {
                        boolean newState = !song.isFavorite();
                        model.markFavorite(song.getSongTitle(), song.getArtistName(), newState);
                        if (newState) {
                            System.out.println("Added to favorites!");
                        } else {
                            System.out.println("Removed from favorites.");
                        }
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number.");
        }
    }
    
    
    // Main method for testing
    public static void main(String[] args) {
        MusicStore store = new MusicStore();
        LibraryModel model = new LibraryModel(store);
        View view = new View(model, store);
        
        // Add sample data for testing
       
        
        // Start application
        view.start();
    }
}