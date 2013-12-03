/*
* Search object
* Each use has a collection of different searches
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
        private ArrayList<Location> locations = new ArrayList<Location>();
        private ArrayList<Coord> shortestPath = new ArrayList<Coord>();
        private Location start, end;
        private double distance;
        private boolean optimized;
        private double startTime;
        private String userName;

        // How many locations you can add to a trip, NOT including starting and ending locations.
        private static final int TRIP_LIMIT = 30;
        
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
         * constructor for SEARCH object, pass in username, everything else is set to default
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
         * constructor for SEARCH object
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
         * arraylist of mid locations.
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
        
        // Override of toString
        // This should be used in the the pervious search dropdown.
        public String toString()
        {
            String returnString = "";
            returnString += "" + getStart().getName().substring(0, Math.min(getStart().getName().length(), 16)) + " -> ";
            returnString += "" + getEnd().getName().substring(0, Math.min(getEnd().getName().length(), 16)) + " (";
            returnString += " +" + getNumMidLocations() + " Mid Points) ";
            return returnString;
        }
        
        // Returns a string that can be printed into the users file.
        // The returned string will look something along the lines of
        // "
        // 8
        // The Kreeger Museum|2401 Foxhall Road Northwest|Washington|District of Columbia|38.9217585|-77.0892007
        // Fairfax Museum & Visitors Center|10209 Main Street|Fairfax|Virginia|38.8444887|-77.3005546
        // Thurgood Marshall Airport|7062 Elm Road|Baltimore|Maryland|39.180862|-76.6675476
        // "
        // The first location is the starting location, last is ending, middles are mid, ect..
        // The first number is the start time of the trip
        // Trips will be sorted and valid before they need to be saved.
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
               
                // Print shortest Path (1 line)
                Iterator<Coord> itrB = shortestPath.iterator();
                msg += "shortestCoords" + '\n';
                while(itrB.hasNext())
                {        
                        String temp = itrB.next().toString();
                                        System.out.println("temp is " + temp);
                        msg += temp ;
                        
                        if(itrB.hasNext()){
                                msg += " ; ";
                        }
                }
                
                msg += " | \n";

                return msg;
        }

        public void setLocations(ArrayList<Location> locations) 
        {
                this.locations = locations;
        }

        public void setShortestPath(ArrayList<Coord> shortestPath) 
        {
                this.shortestPath = shortestPath;
        }

        public void setDistance(double distance) 
        {
                this.distance = distance;
        }

        public void setUserName(String userName) 
        {
                this.userName = userName;
        }

        public static void main(String[] args){
                
        String userName = "Dan";                

        ArrayList<Location> locations = new ArrayList<Location>();
        ArrayList<Coord> shortestCoords = new ArrayList<Coord>();

        //build search attributes
        String name = "Tim";                
        float x = (float) 3.24;
        float y = (float) 5.25;
        Coord coord = new Coord(x,y);
        String city = "tim";
        String state = "MD";
        String address = "101 H rd";                        
        Location loc = new Location(name,address,city,state, coord);        
        //label start
        Location start = new Location(loc);
       // locations.add(loc);
        shortestCoords.add(new Coord(x,y));

        name = "UMBC";                
        x = (float) 6.24;
        y = (float) 8.25;
        coord = new Coord(x,y);
        city = "balt";
        state = "MD";
        address = "901 C rd";
        loc = new Location(name,address,city,state, coord);        
        //locations.add(loc);
        shortestCoords.add(new Coord(x,y));                
        //label end                
        Location end = new Location(loc);

        //make search
        Search search = new Search("3",userName, start, end, locations, shortestCoords);

        System.out.println("main print");
        System.out.println(search.fileToString());
        System.out.println("done");

        }
}