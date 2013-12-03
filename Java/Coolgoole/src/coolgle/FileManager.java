/*
Notes while merging code :
1.) I have all the code for adding / deleting locations from the main 
locationDatabase.txt in the addLocationGui.java file, since that's where we update 
the locations from anyways. You can move it in here if you'd like, but it should be 
fine there. 
2.) Here's what I was thinking the file manager would do, in addition to what you already have coded. 
2a.) print current searches to the user's file. Called from mainGui.java (There is a TODO note where it should be)
2b.) Load the previous searches of the user into the previous search dropdown 
(Can be called from the mainGui.java constructor)
2c.) Maybe other stuff related to user authentication....??
3.) I left your main method at the bottom but commented out

To keep things constant, just use the location.fileToString() method. That returns a nicely formatted string to be 
printed to a file. You can also use that same string in the constuctor to return a location with those attri.s 
*/


package coolgle;
import java.io.*;
import java.util.*;
/*****************************************
 ** File: KMlCreator
 ** Team Name: Cava++
 *Date: 10/18/13
 ** E-mail: Daniel Brandes bradan1@umbc.edu, 
 ** Lizset Chavez <lizset1@umbc.edu>
 ** Patrick Ritchie <ritc1@umbc.edu>,
 ** Xiaofei He <xiaofei2@umbc.edu>,
 ** Yo-Han Kim <ykim18@umbc.edu>,
 ** Jim Millican <jmill1@umbc.edu>
 ** Decription- File that Parses Search into a txt file
 ** and a txt File into search
***********************************************/
public class FileManager 
{
	//class variables
	private String path = "C:\\Users\\Owner\\Documents\\GitHub\\Cava\\Java\\Coolgoole\\";
        /**
	 * constructor for FileManager object
	 */
	public FileManager()
        {
		
	}
	
	/**
	 * pullLocation(String userId)
	 * Description- search.txt to SEARCH (get database entry)
	 * Pre-
	 * Post-
	 * @return 
	 */
	public Search[] pullLocations(String userId)
        {
		Search[] previousSearchs;
		//see if userfile exists
		//get file
		//parse file into SEARCH object
			//find out how many searchs there are
		return null;
	}
	public Search getPrev( String userName, int searchIndex)
    {
	try {					
		String temp;
		temp = path;
		String newLine = "StartTime";
		String endMidLocs = "shortestCoords";
		Location mid;
		//get user name
		temp += userName+ ".txt";
		//System.out.println(temp.toString());			
		File file = new File(temp);
		
		//System.out.println("file full is" + a);
		//System.out.println("path is " + path);
		System.out.println("file exits is " + file.exists());
		if(file.exists()){		
			//getPrev search with index
			Scanner line = new Scanner(file);
			//get all lines from file
			int index =0;
			while(line.hasNext()){
				String currLine = line.nextLine();
				Scanner inLine = new Scanner(currLine);
				//align scanner to searchIndex
				if(inLine.next().equals(newLine)){
					System.out.println("**newSearch**" );
					index ++;
					String locName; 
					Coord coord; 
					String address = ""; 
					String city; 
					String state; 
					Location loc;
					String msg;
					String lat;
					String lon;
					Coord locCoord;
					String startTime;
					ArrayList<Location> locations = new ArrayList<Location>();
					ArrayList<Coord> shortestPath = new ArrayList<Coord>();
					if(index == searchIndex){
						String tempTxt;
						//make search object
						Search prevSearch  = new Search();
						//System.out.println("currLine is " + currLine);
						
						//get userName						
						inLine = new Scanner(currLine);
						System.out.println("currLine is" + currLine);
						inLine.next();
						startTime= inLine.next();
						System.out.println("startTime is" + startTime);
						

						//get start location components
						currLine = line.nextLine();
						System.out.println("currLine is" + currLine);
						inLine = new Scanner(currLine);
						//get name
						locName = inLine.next();
						inLine.next();					
						msg = "";
						while(!msg.equals("|")){ 
							msg = inLine.next();
							if(!msg.equals("|")){
								address += msg + " ";		
							}
						}
						System.out.println("address is" + address);
						//get city						
						city = inLine.next();
						inLine.next();
						//get state						
						state = inLine.next();
						inLine.next();
						//get Coord
						lat = inLine.next();
						lon = inLine.next();
						locCoord = new Coord(lat,lon);
						Location start = new Location(locName, address, city, state, locCoord);
						System.out.println("start is " + start.fileToString());
						
						
						//get end location components
						currLine = line.nextLine();
						System.out.println("currLine is" + currLine);
						inLine = new Scanner(currLine);
						//get name
						locName = inLine.next();
						inLine.next();					
						msg = "";
						while(!msg.equals("|")){ 
							msg = inLine.next();
							if(!msg.equals("|")){
								address += msg + " ";		
							}
						}
						System.out.println("address is" + address);
						//get city						
						city = inLine.next();
						inLine.next();
						//get state						
						state = inLine.next();
						inLine.next();
						//get Coord
						lat = inLine.next();
						lon = inLine.next();
						locCoord = new Coord(lat,lon);
						Location end = new Location(locName, address, city, state, locCoord);						
						System.out.println("end is " + end.fileToString());
					
						//check for mid locations
						currLine = line.nextLine();
						while(!currLine.equals(endMidLocs)){
							//add mid location
							//get end location components
							currLine = line.nextLine();
							System.out.println("currLine is" + currLine);
							inLine = new Scanner(currLine);
							//get name
							locName = inLine.next();
							inLine.next();					
							msg = "";
							while(!msg.equals("|")){ 
								msg = inLine.next();
								if(!msg.equals("|")){
									address += msg + " ";		
								}
							}
							System.out.println("address is" + address);
							//get city						
							city = inLine.next();
							inLine.next();
							//get state						
							state = inLine.next();
							inLine.next();
							//get Coord
							lat = inLine.next();
							lon = inLine.next();
							locCoord = new Coord(lat,lon);
							mid = new Location(locName, address, city, state, locCoord);						
							locations.add(mid);
							System.out.println("end is " + end.fileToString());
						}
						//get shortestCoords line
						System.out.println("currLine is" + currLine);
						currLine = line.nextLine();
						//get pairs of coords till done
						inLine = new Scanner(currLine);
						msg = "";
						//System.out.println("inLine is " + inLine.next());
						//System.out.println("inLine is " + inLine.next());
						//System.out.println("inLine is " + inLine.next());
						//System.out.println("inLine is " + inLine.next());
						while(!msg.equals("|")){		
							lat= inLine.next();
							lon= inLine.next();
							msg = inLine.next();
							locCoord = new Coord(lat,lon);
							shortestPath.add(locCoord);
						}
						
						
						System.out.println("***shortestPath size is " + shortestPath.size());
						prevSearch = new Search(startTime, userName, start, end, locations, shortestPath);
						System.out.println("***finished is " + prevSearch.fileToString());				
						return prevSearch;
					}
				}				
			}			
				
			
			
		}
		else{
			System.out.println("File not found(addSearch)");				
		}
		
        } catch (IOException e) {
        	
        	System.out.println("File error");
        }
	return null;
}
	
	public boolean isFull(File file)
        {
		int searchCount = 0;
		
		String newLine = "StartTime";
		try {
			Scanner line = new Scanner(file);
			//get all lines from file
			while(line.hasNext()){
				String currLine = line.nextLine();
				Scanner inLine = new Scanner(currLine);
				//find new search token
				if(inLine.next().equals(newLine)){
					System.out.println("**Found**" );
					searchCount +=1;
					System.out.println("SearchCount is " + searchCount);
					if(searchCount>=7){
						return true;
					}
				}				
			}			
		} 
		catch (FileNotFoundException e) {
			System.out.println(e.toString());
			System.out.println("file not found(error)");
		}
		
		//System.out.println("search count is "+ searchCount);
		
		return false;
	}
	
	
	/**
	 * addSearch(SEARCH search)
	 * Description- SEARCH to search.txt (add database entry)
	 * Pre- user must exist
	 * Post- adds a valid completed search to users history 
	 */
	public void addSearch(Search search){
		try {		
	
			String line;			
			String temp;
			temp = path;
			//get user name
			temp += search.getUserName()+ ".txt";
			System.out.println(temp.toString());			
			File file = new File(temp);
			
			//System.out.println("file full is" + a);
			System.out.println("path is " + path);
			System.out.println("file exits is " + file.exists());
			if(file.exists()){
				boolean full = isFull(file);
				if(full){
					//remove last search and put in new one
					
					System.out.println("File is full please remove an entry");
				
				
				}
				else{
					//append data to end of file
					System.out.println("File found");
					//TODO: check for valid search first
					PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));				
					out.write(search.fileToString().replaceAll("\n", System.lineSeparator()));				
					out.close();
					System.out.println("Search added");
				}
			}
			else{
				System.out.println("File not found(addSearch)");				
			}
			
	        } catch (IOException e) {
	        	
	        	System.out.println("File error");
	        }
		
	}
	
	/**removeUser()
	 * Description- removes users searches 
	 * Pre- user exists
	 * Post- removes text file for user
	 */
	public void removeUserFile(String userName){
		//REMOVES new user SEARCH file
		String temp;
		temp = path;
		temp += userName;
		File file = new File(temp);		
		if(file.exists()){
			System.out.println("user does not exist");
		}
		else{
			file.deleteOnExit();	
			System.out.println("file deleted");
		}
	}
	
	/**addUser()
	 * Description- adds file for users search
	 * Pre- 
	 * Post-adds text file for user
	 */
	public void addUserFile(String userName){
		//adds new user SEARCH file
		String temp;
		temp = path;
		temp += userName;		
		System.out.println("temp is " + temp);
		File file = new File(temp);
		
		try {
			System.out.println(temp.toString());
			if(file.exists()){
				System.out.println("file already exists");
			}
			else{
				file.createNewFile();
				System.out.println("file created");
				
			}
		} catch (IOException e) {
			System.out.println(e.toString());
			System.out.println("file cant be created");
		}			
	}
	
        
	public static void main(String[] args)
        {
		FileManager fm = new FileManager();

		ArrayList<Location> locations = new ArrayList<Location>(); 
		ArrayList<Coord> shortestCoords =  new ArrayList<Coord>();
	
		//build search attributes
		String userName = "Dan";		
		//fm.addUserFile(userName);
		
		String name = "Tim";
		float x = (float) 3.24;
		float y = (float) 5.25;
		Coord coord = new Coord(x,y);
		String city = "tim";
		String state = "MD"; 
		String address = "101 H rd";			
		Location start = new Location(name,address,city,state, coord);	
		//mid1
		//Location loc = new Location(name,coord,city,state,address);	
		//locations.add(loc);
		shortestCoords.add(new Coord(x,y));
		 
		//make search
		 
		name = "UMBC";		
		x = (float) 6.24;
		y = (float) 8.25;
		coord = new Coord(x,y);
		city = "balt";
		state = "MD"; 
		address = "901 C rd";
		Location end = new Location(name,address,city,state, coord);
		//mid2
		//locations.add(loc);
		shortestCoords.add(new Coord(x,y));		
			
		
		
		
		Search search ;//= new Search("4", userName, start, end, locations,shortestCoords);		
		//System.out.println("**appending existing search**");
		//try existing user
		//fm.addUserFile(userName);
		//fm.addSearch(search);
		//label end		
		
		
		
		//get a prev search
		search = fm.getPrev(userName, 3);
		System.out.println("**main print**");
		System.out.println(search.fileToString());
		
		
		//try non existing user
		userName = "Tom";
		
		
		/*search = new Search(userName, start, end, locations);			
		System.out.println("**add to non exist user**");
		fm.addSearch(search);
		
		//add new user
		search = new Search(userName, start, end, locations);			
		System.out.println("**add new user**");
		fm.addUserFile(userName);
		
		//remove new user
		System.out.println("**removing user**");
		fm.removeUserFile(userName);*/
		System.out.println("**done**");
	}
        
}
