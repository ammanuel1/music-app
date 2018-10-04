public class SongLibrary
{
	public static void main( String[] arg)
	{
		Menu menu = new Menu();	// new object called menu
		
		menu.loadPlaylist();		//uses saved playlist class with menu options
		menu.runMenu();

	}
	
} //End SongLibrary class

