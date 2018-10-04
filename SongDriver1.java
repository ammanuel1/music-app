

public class SongDriver{

	public static void main (String [] args){

      System.out.println("Welcome to your music library");


        //Usig a do while loop so that the program keeps running until 
        //a specific condition is met, in this case it's when 0 is selected.
        do 
        {

          //Menu Prompts printed to the screen for the user to select from
            System.out.println("........ \n");
            System.out.println("Press 0 to Exit\n");
            System.out.println("Press 1 to Add a Song\n");
            System.out.println("Press 2 to View All Songs\n");
            System.out.println("Press 3 to Remove a Song\n");
            System.out.println("Press 4 to Search song by name");
            

          //Monitors the next Int the user types
            int opt = IO.readInt();


            //"if" statements
            if (opt == 0) 
            {  
             System.out.println("Peace!");  
            } 


            else if (opt == 1)                 
            { 
             //This method allows the user to add a song to the library.
             //With the format being Title, Artist, Year.
            System.out.println("Enter the name of the song:");
           String newName = IO.readString();
            songName.add(newName);
            System.out.println("Enter the name of the Artist:");
            String newArtist = IO.readString();
            songArtist.add(newArtist);
            System.out.println("Enter Album of this track:");
            String newAlbum = IO.readString();
            songAlbum.add(newAlbum);
            System.out.println("What year was the track released?");
            int newYear = IO.readInt();
            songYear.add(newYear);

            System.out.println("Thanks," + newName + " has been added to the library.");
            System.out.println("Press 2 to view your library");
            }




            else if (opt == 2)
            {
              //This method prints the contents of the Array List to the screen  
               songApp.print();
              
            } 




            else if (opt == 3)             
            {
              //This method allows the user to remove an indiviual song from
              //their music library
              System.out.println("Which song would you live to remove?:");
              songApp.print();
              String removeThis = IO.readString();
              songApp.removeSong(removeThis); 
              System.out.println("This song has been removed.");
              songApp.print();
            } 



            else if (opt == 4) 
            {
              System.out.println("Enter the song's name:");
              String songName = IO.readString();
              songApp.searchByName(songName);
            } 

            else 
            {
              //If the user selects an incorrect number, the console will 
              //tell the user to try again and the main menu will print again

                System.out.println("Incorrect Entry, please try again");
            }


         //do-while loop
        while (opt > 0);{

        }


}

}

public class Song{
private String name;		// use private in order to only access these within this class
private String artist;
private String album;
private int year;
private int ratings;		// ratings 1(worst) to 5(best)

public Song(String name) {
this.name = name;	// use "this dot" for whenever i want to refer to the object inside of a method 
}
public String getName() {		// use this type of string to find the name and spit it back out (makes the code shorter) thanks to youtube for teaching me! HAhA
return name;
}
public String getArtist() {			// do the same throughout for the rest
return artist;
}
public String getAlbum() {
return album;
}
public int getYear() {
return year;
}
public int getRatings() {
return ratings;
}
public void setName(String name) {			// same as starting at line 11 but no return value just setting each variable
this.name = name;
}
public void setAlbum(String album) {
this.album = album;
}
public void setArtist(String artist) {
this.artist = artist;
}
public void setYear(int year) {
this.year = year;
}
public void setRatings(int ratings) {
this.ratings = ratings;
}
public String toString() {			// to return string of all values stated in Autolab page (name year ratings)
return "Song Name: " + name + " " + "Year:" + year + " " + "Ratings: " + ratings;
}

public boolean equals(Object other) {		// AUTOLAB SAYS if two objects are equal if they have the same name, director, and were released at the same year;
Song otherSong = (Song) other;						
if (artist.equals(otherSong.artist)){
	return true;
}
if (name.equals(otherSong.name)){
return true;
}
if (year == (otherSong.year)){
return true;
}
else {
	return false;
}

}

public int compareTo(Song other) {
if (name.equals(other.name)) {
return 0;
} else if (name.compareTo(other.name) < 0) {
return -1;
} else {
return 1;
}
}
}

