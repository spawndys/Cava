/*
Notes while merging code :
1.) Getting rid of the shortest coords arraylist
If the search is optimized, the locations arraylist will be 
in sorted order anyways, so when saving to the user file
only the locations array will need to  be saved. 
2.) Add userName as member var. 
3.) No need for isValid function, seasrches can't be made in a invalid form. 
4.) Kept your main commented out at the bottom of the file, should be deleted 
once you don't need it anymore
*/

package coolgle;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/*****************************************
 ** File: Search
 ** Team Name: Cava++
 *Date: 10/18/13
 ** E-mail: Daniel Brandes bradan1@umbc.edu, 
 ** Lizset Chavez <lizset1@umbc.edu>
 ** Patrick Ritchie <ritc1@umbc.edu>,
 ** Xiaofei He <xiaofei2@umbc.edu>,
 ** Yo-Han Kim <ykim18@umbc.edu>,
 ** Jim Millican <jmill1@umbc.edu>
 ** Decription- Class that represents a users search
***********************************************/
public class Search 
{
	//class variables
	
        // Arraylist of midlocations
        ArrayList<Location> locations = new ArrayList<Location>();
        
	Location start, end;
	double distance;
	boolean optimized;
        double startTime;
        
        String userName;
        
        // How many locations you can add to a trip, NOT including starting and ending locations. 
        private static final int TRIP_LIMIT = 30; 
        
	/**
	 * constructor for SEARCH object
	 */
	public Search()
        {
            //Default Contructor 
            startTime = 8.00;  // Default time in GUI 
            optimized = false; 
            start = new Location();
            end = new Location();
            userName = "";
	}
        
         /**
	 * constructor for SEARCH object
	 */
	public Search(String userName, Location start, Location end, 
			ArrayList<Location> locations)
        {
		this.userName = userName;
		this.start = start;
		this.end = end;
		this.locations = locations;
                startTime = 8.00;  // Default time in GUI 
                optimized = false; 
	}       
        
        
	/**
	 * hasShortest
	 * Description- Returns whether or not the search has been optimized.
	 */
        public boolean hasShortest()
        {
            return optimized;
        }
        
        /**
	 * setOptimized
	 * Description - sets optimized to boolean parameter
	 */
        public void setOptimized(boolean isOptimized)
        {
            optimized = isOptimized;
        }
	
        /**
	 * getMidLocations
	 * Description - returns arraylist of midlocations. 
	 */
        public ArrayList<Location> getMidLocations()
        {
            return locations; 
        }
        
        /**
	 * setStartTime
	 * Description - Set start time to new double passed in
	 */
        public void setStartTime(double newTime)
        {
            startTime = newTime; 
        }
        
        /**
	 * getStartTime
	 * Description - Returns start time. 
	 */
        public double getStartTime()
        {
            return startTime;
        }
        
	/*
	 * getStart
	 * Description - Returns start location. 
	 */
        public Location getStart()
        {
            return start;
        }
        
        /*
	 * setStart
	 * Description - Sets the start location 
	 */
        public void setStart(Location newStart)
        {
            start = newStart; 
        }
	
	/**
	 * getEnd
	 * Description- Returns end location
	 */
        public Location getEnd()
        {
            return end;
        }
        
        /*
	 * setEnd
	 * Description - Sets the end location 
	 */
        public void setEnd(Location newEnd)
        {
            end = newEnd; 
        }
        
        public String getUserName() 
        {
		return userName;
	}

	/**
	 * addLocation
	 * Description - Adds the given location to the arraylist of midlocation
	 */
        public void addLocation(Location newLocation)
        {
            // Add unless you're reached the limit. 
            if (locations.size() < TRIP_LIMIT)
                locations.add(newLocation);
            else
                JOptionPane.showMessageDialog(null, "You have reached the maximun amount of \n"
                                              + "locations allowed per trip (" + TRIP_LIMIT + ")"
                                              , "Failure", JOptionPane.ERROR_MESSAGE);
        }
        
	/**
	 * removeLocation
	 * Description - Removes the given location from the arraylist of mid locations. 
	 */
        public boolean removeLocation(Location newLocation)
        {
            //Search through the arraylist, if object exist remove it. 
            boolean removed = false; 
            for ( int i = 0; i < locations.size() && !removed; i++ )
            {
                if (locations.get(i).isSame(newLocation))
                {
                    locations.remove(i);
                    removed = true; 
                }
            }
            return removed; 
        }
        
        
        /**
	 * removeAtPosition
	 * Description - Removes the mid location at the given position. 
	 */
        public void removeAtPosition(int pos)
        {
            locations.remove(pos);
        }
        
        /**
	 * getNumMidLocations
	 * Description - Returns the number of mid locations. 
	 */
        public int getNumMidLocations()
        {
            return locations.size();
        }
	
        /**
	 * isInSearch
	 * Description - Returns whether or not the given location is in the
         *               arraylist of mid locations. 
	 */
        public boolean isInSearch(Location testLocation)
        {
            boolean alreadyListed = false; 
            
            // Firstly check the start and ending locations
            if (getStart().isSame(testLocation))
                alreadyListed = true;
            else if (getEnd().isSame(testLocation))
                alreadyListed = true;
            else
            {
                // then the middle locations
                for (int i = 0; i < locations.size(); i++)
                {
                    if (locations.get(i).isSame(testLocation))
                        alreadyListed = true;
                }
            }
            
            return alreadyListed;
        }
        
        
        /**
	 * clearData
	 * Description - Resets all fields, to be used when user clicks
         *               the clear search button in the main gui
	 */
        public void clearData()
        {
            locations.clear();
            start = new Location(); 
            end = new Location(); 
            distance = 0;
            optimized = false;
            startTime = 8;
        }
        
        // Override of toString
        // This should be used in the the pervious search dropdown. 
        public String toString()
        {
            String returnString = "";
            returnString += "" + getStart().getName() + " -> ";
            returnString += "" + getEnd().getName() + " ( ";
            returnString += " +" + getNumMidLocations() + " Other Locations ) ";
            return returnString;
        }
        
        // Writes the search to a users file, pass in name of user file (TODO)
        // (I quickly fleshed out what this should do, I haven't tested it)
        public String fileToString()
        {
                String msg;
                msg = "**new search**" + '\n';
 
                // Print add all locations
                msg += start.fileToString();
                Iterator<Location> itrA = locations.iterator();
                while(itrA.hasNext())
                {
                        msg += itrA.next().toString() + "\n";
                }
                msg += end.fileToString();
                
                msg += "** end new search**\n";
                return msg;
	}
	
}



	/*
	public static void main(String[] args){
		
        String userName = "Dan";		

        ArrayList<Location> locations = new ArrayList<Location>(); 
        ArrayList<Coord> shortestCoords =  new ArrayList<Coord>();

        //build search attributes
        String name = "Tim";		
        float x = (float) 3.24;
        float y = (float) 5.25;
        Coord coord = new Coord(x,y);
        String city = "tim";
        String state = "MD"; 
        String address = "101 H rd";			
        Location loc = new Location(name,coord,city,state,address);	
        //label start
        Location start = new Location(loc); 
        locations.add(loc);
        shortestCoords.add(new Coord(x,y));

        name = "UMBC";		
        x = (float) 6.24;
        y = (float) 8.25;
        coord = new Coord(x,y);
        city = "balt";
        state = "MD"; 
        address = "901 C rd";
        loc = new Location(name, coord, city, state, address);	
        locations.add(loc);
        shortestCoords.add(new Coord(x,y));		
        //label end		
        Location end = new Location(loc); 

        //make search
        Search search= new Search(userName, start, end, locations, shortestCoords);


        System.out.println(search.toString());
        System.out.println("done");
*/
