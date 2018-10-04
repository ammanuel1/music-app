import java.io.Serializable;
public class Song implements Serializable
{
	private String artist;
	private String title;
	private String genre;
	
	//Creates a playlist object constructor with an artist, title, and a genre.
	public Song(String artist, String title, String genre)
	{
		this.artist = artist;
		this.title = title;
		this.genre = genre;
	}
	
	
	public void setArtist(String artist)
	{
		this.artist = artist;
	}
	
	public String getArtist()
	{
		return artist;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public void setGenre(String genre)
	{
		this.genre = genre;
	}
	
	public String getGenre()
	{
		return this.genre;
	}
	
	
} 
