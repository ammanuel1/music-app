import java.io.Serializable;
import java.util.ArrayList;

public class Playlist implements Serializable
{	
	private ArrayList<Song> playlist;


	//Creates a Playlist object that contains an ArrayList for Songs.
	public Playlist()
	{
		playlist = new ArrayList<Song>();
	}

	//Adds a Song to a Playlist.
	public void addSong(Song song)
	{
		playlist.add(song);
	}
	
	//Returns the size of a Playlist.
	public int getPlaylistSize()
	{
		return playlist.size();
	}
	
	//Returns the artist of the Song at position (index) of a Playlist.
	public String getArtist(int index)
	{
		return playlist.get(index).getArtist();
	}
	
	//Returns the title of the Song at position (index) of a Playlist.
	public String getTitle(int index)
	{
		return playlist.get(index).getTitle();
	}
	
	//Returns the genre of the Song at position (index) of a Playlist.
	public String getGenre(int index)
	{
		return playlist.get(index).getGenre();
	}
	
	//Sets the artist of the Song at position (index) to artist.
	public void updateArtist(int index, String artist)
	{
		playlist.get(--index).setArtist(artist);
	}
	
	//Sets the title of the Song at position (index) to the title.
	public void updateTitle(int index, String title)
	{
		playlist.get(--index).setTitle(title);
	}
	
	//Sets the genre of the Song at position (index) to genre.
	public void updateGenre(int index, String genre)
	{
		playlist.get(--index).setGenre(genre);
	}
	
	//Removes the song located at the specified index from the Playlist.
	public void removeSong(int index)
	{
			playlist.remove(index);
	}
	
	//Clears the Playlist of all Songs in it by using clear() on a Playlist.
	public void deletePlaylist()
	{
		if(playlist.size() == 0)
		{
			System.out.print("Playlist is empty!\n");
		}
		else
		{
			playlist.clear();
			System.out.print("Playlist has been deleted.\n");
		}
	}
	
} //End class