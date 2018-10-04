import java.util.ArrayList;
import java.io.Serializable;
import java.io.*;

public class Menu
{
	
	private Playlist playlist = new Playlist();	
	
	//Display a menu that asks for user input (int option), and returns the input.
	public int showMenu()
	{
		int option;

		System.out.print("\nWhat would you like to do?"
						+ "\n1- Add song"+ "\n2- View playlist"
						+ "\n3- Nothing" + "\n4- Remove song" + "\n5- Delete playlist"
						+ " \n6- Exit" + "\nOption: ");
		option = IO.readInt();
		System.out.print("\n");

		return option;
	}
	
	//Displays menu from showMenu(): Contains a switch,
	//executes case based on returned int from showMenu().
	public void runMenu()
	{

		int option = showMenu();

		switch (option) {
		case 1:
			addSong();
			savePlaylist();
			runMenu();
			break;
		case 2:
			viewPlaylist();
			runMenu();
			break;
		case 3:
			runMenu();
			break;
		case 4:
			removeSong();
			savePlaylist();
			runMenu();
			break;
		case 5:
			playlist.deletePlaylist();
			runMenu();
			break;
		case 6:
			savePlaylist();
			System.exit(0);
			break;
		default:
			System.out.println("\nThat is not a valid option!\n");
			runMenu();
		}

	}
	
	//Creates a new Song with user to input for artist, title,
	//genre; adds Song to a Playlist.
	//I tried putting in the artist, title
	public void addSong()
	{
		Song newSong = new Song(null, null, null);
		
		System.out.print("Enter artist: ");
		newSong.setArtist(IO.readString());
		System.out.print("Enter title: ");
		newSong.setTitle(IO.readString());
		
		System.out.print("Enter genre: ");
		newSong.setGenre(IO.readString());
		
		playlist.addSong(newSong);
	}
	
	//Formats and displays all Songs in Playlist.
	public void viewPlaylist()
	{
		if(playlist.getPlaylistSize() == 0)
		{
			System.out.println("\nPlaylist empty!");
		}
		else
		{
			for(int i = 0; i < playlist.getPlaylistSize(); i++)
			{
				System.out.print("\n#" + (i+1) + " ");
				System.out.print(""+ playlist.getArtist(i) + " - ");
				System.out.print("\"" +playlist.getTitle(i)+ "\"" + ", ");
				System.out.print(playlist.getGenre(i) + ", ");
			}
			System.out.print("\n");
		}
	}
	
	
	//Displays Playlist; prompts user to select Song to delete and removes it from Playlist.
	public void removeSong()
	{
		if(playlist.getPlaylistSize() == 0)
		{
			System.out.println("\nPlaylist is empty!");
		}
		else
		{
			viewPlaylist();
			boolean x = false;
			do
			{
				System.out.print("\nSelect a song to remove: ");
				int removeSelection = IO.readInt();
				
				if(removeSelection < playlist.getPlaylistSize() || removeSelection > playlist.getPlaylistSize())
				{
					System.out.print("That is not a valid selection!\n");
				}
				else
				{
					playlist.removeSong(--removeSelection);
					x = true;
				}
			} while(x == false);
		}
	}
	
	//Write the contents of Playlist to a file called playlist.
	public void savePlaylist()
	{
		try
		{
			FileOutputStream fileOutputStream = new FileOutputStream("playlist");
			
			ObjectOutputStream outObjectStream = new ObjectOutputStream(fileOutputStream);
			
			outObjectStream.writeObject(playlist);
			
			outObjectStream.flush();
			outObjectStream.close();
		}
		catch(FileNotFoundException fnfException)
		{
			System.out.println("No file");
		}
		catch(IOException ioException)
		{	
			System.out.println("bad IO");
		}

	}
	
	//Reads the file contents containing to a Playlist.
	public void loadPlaylist()
	{
		try
		{
			FileInputStream saveFile = new FileInputStream("playlist");
			
			ObjectInputStream load = new ObjectInputStream(saveFile);
				
			playlist = (Playlist)load.readObject();
				
			load.close();
		}
		catch(FileNotFoundException fnfException)
		{
			System.out.println("No File");
		}
		catch(IOException ioException)
		{	
			System.out.println("IO no good");
		}
			
		catch(ClassNotFoundException cnfException)
		{	
			System.out.println("This is not a Playlist.");
		}
		
	}
	
	
}//End class