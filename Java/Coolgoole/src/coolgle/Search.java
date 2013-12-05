/*****************************************
** File: Search
** Team Name: Cava++
** Date: 10/18/13
** E-mail: Daniel Brandes bradan1@umbc.edu,
** Lizset Chavez <lizset1@umbc.edu>
** Patrick Ritchie <ritc1@umbc.edu>,
** Xiaofei He <xiaofei2@umbc.edu>,
** Yo-Han Kim <ykim18@umbc.edu>,
** Jim Millican <jmill1@umbc.edu>
** Description- Class that represents a users search
***********************************************/
package coolgle;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class Search
{
        //class variables
        
        // Arraylist of midlocations
        private ArrayList<Location> locations = new ArrayList<Location>();
        private ArrayList<Coord> shortestPath = new ArrayList<Coord>();
        private Location start, end;
        private double distance;
        private boolean optimized;
        private double startTime;
        private String userName;

        // How many locations you can add to a trip, NOT including starting and ending locations.
        private static final int TRIP_LIMIT = 30;
        // This is the maximun len of the start/end location names it will show in the previous search dropdown
        private static final int TO_STRING_LEN = 23;
        
        /**
         * constructor for SEARCH object
         */
        public Search()
        {
            //Default Contructor
            startTime = 8.00; // Default time in GUI
            optimized = false;
            start = new Location();
            end = new Location();
            userName = "";
        }
        
        /**
         * Blank constructor for creating with just userName
         */
        public Search(String un)
        {
            //Default Contructor
            startTime = 8.00; // Default time in GUI
            optimized = false;
            start = new Location();
            end = new Location();
            userName = un;
        }
        
   
        /**
         * Initialized constructor for creating  valid search (Coord included) */
        public Search(String startTime, String userName, Location start, Location end,
                        ArrayList<Location> locations, ArrayList<Coord> shortestPath)
        {
                
                this.startTime = Double.parseDouble(startTime);
                this.userName = userName;
                this.start = start;
                this.end = end;
                this.locations = locations;
                this.shortestPath = shortestPath;
                optimized = false;
                
        }
        /**
         * Initialized constructor for creating  valid search (Coord not included) 
         */
        public Search(String userName, Location start, Location end,
                        ArrayList<Location> locations)
        {
                this.userName = userName;
                this.start = start;
                this.end = end;
                this.locations = locations;
                this.shortestPath = shortestPath;
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
         * Description - returns array list of mid locations.
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
        
        /**
         * getStart
         * Description - Returns start location.
         */
        public Location getStart()
        {
            return start;
        }
        
        /**
         * setStart
         * Description - Sets the start location
         */
        public void setStart(Location newStart)
        {
            start = newStart;
            optimized = false;
        }
        
        /**
         * getEnd
         * Description- Returns end location
         */
        public Location getEnd()
        {
            return end;
        }
        
        /**
         * setEnd
         * Description - Sets the end location
         */
        public void setEnd(Location newEnd)
        {
            end = newEnd;
            optimized = false;
        }
        /**
         * Description - getUserName
         */
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
            if (locations.size() < TRIP_LIMIT){
                locations.add(newLocation);
                optimized = false;
            }
            else
                JOptionPane.showMessageDialog(null, "You have reached the maximun amount of \n"
                                              + "locations allowed per trip (" + TRIP_LIMIT + ")"
                                              , "Failure", JOptionPane.ERROR_MESSAGE);
        }
        
        /**
         * removeLocation
         * Description - Removes the given location from the array list of mid locations.
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
                    optimized = false;
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
            optimized = false;
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
         * array list of mid locations.
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
         * the clear search button in the main gui
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
        
        /** Description - Override of toString
        // This should be used in the the pervious search drop down.*/
        public String toString()
        {
            String returnString = "";
            returnString += "" + getStart().getName().substring(0, Math.min(getStart().getName().length(), TO_STRING_LEN)) + " -> ";
            returnString += "" + getEnd().getName().substring(0, Math.min(getEnd().getName().length(), TO_STRING_LEN)) + " (";
            returnString += " +" + getNumMidLocations() + " Mid Points) ";
            return returnString;
        }
        
        /** Description - Returns a string that can be printed into the users file.
        // Additional: The returned string will look something along the lines of
        // "
        // 8
        // The Kreeger Museum|2401 Foxhall Road Northwest|Washington|District of Columbia|38.9217585|-77.0892007
        // Fairfax Museum & Visitors Center|10209 Main Street|Fairfax|Virginia|38.8444887|-77.3005546
        // Thurgood Marshall Airport|7062 Elm Road|Baltimore|Maryland|39.180862|-76.6675476
        // "
        // The first location is the starting location, last is ending, middles are mid, ect..
        // The first number is the start time of the trip
        // Trips will be sorted and valid before they need to be saved.*/
        public String fileToString()
        {
                String msg;
                
                msg = "StartTime " + this.startTime + '\n';
                
                msg += start.fileToString() + '\n';
                // Print add all locations
                Iterator<Location> itrA = locations.iterator();
                while(itrA.hasNext())
                {
                        msg += itrA.next().fileToString() + '\n';
                }
                msg += end.fileToString() + '\n';
                
                msg += "***endSearch" + '\n';

                return msg;
        }
        /**
         * setter for locations
         * @param locations
         */
        public void setLocations(ArrayList<Location> locations) 
        {
                this.locations = locations;
                optimized = false;
        }
        /**
         * setter for ShortestPath
         * @param locations
         */
        public void setShortestPath(ArrayList<Coord> shortestPath) 
        {
                this.shortestPath = shortestPath;
        }
        /**
         * setter for distance
         */
        public void setDistance(double distance) 
        {
                this.distance = distance;
        }
        /**
         * getter for distance
         */
        public double getDistance(){
        	return distance;
        }
        /**
         * setter for userName
         */
        public void setUserName(String userName) 
        {
                this.userName = userName;
        }
}