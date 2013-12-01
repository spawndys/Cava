package coolgle;

import java.util.ArrayList;
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
public class Search {
	//class variables
	ArrayList<Location> locations = new ArrayList<Location>();
	Location start, end;
	double distance;
	boolean optimized;
        double startTime;
        
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
	}
	
	/**
	 * hasShortest
	 * Description- 
	 * Pre- 
	 * Post -
	 */
        public boolean hasShortest()
        {
            return optimized;
        }
        
        public void optimized(boolean isOptimized)
        {
            optimized = isOptimized;
        }
	
        public ArrayList<Location> getMidLocations()
        {
            return locations; 
        }
        
        public void setStartTime(double newTime)
        {
            startTime = newTime; 
        }
        
        public double getStartTime()
        {
            return startTime;
        }
	/*
	 * getStart
	 * Description- 
	 * Pre- 
	 * Post -
	 */
        public Location getStart()
        {
            return start;
        }
        public void setStart(Location newStart)
        {
            start = newStart; 
        }
	
	/**
	 * getEnd
	 * Description- 
	 * Pre- 
	 * Post -
	 */
        public Location getEnd()
        {
            return end;
        }
        public void setEnd(Location newEnd)
        {
            end = newEnd; 
        }
        
	/**
	 * addLocation
	 * Description- 
	 * Pre- 
	 * Post -
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
	 * Description- 
	 * Pre- 
	 * Post -
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
        
        public void removeAtPosition(int pos)
        {
            locations.remove(pos);
        }
        
        public int getNumMidLocations()
        {
            return locations.size();
        }
	/**
	 * setKey
	 * Description- 
	 * Pre- 
	 * Post -
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
	
}
