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
** Decription- Given a search, the searchManager sorts it into the shortest path
***********************************************/
package coolgle;

import java.util.ArrayList;

public class SearchManager
{
        /**
         * sortShortestDistance
         * Description-  need valid search, sort locations start-end with shortest distance
         */
        
        public void sortShortestDistance(Search search)
        {
        	//if search already calculated the shortest distance, don't have to go farther
        	if(search.hasShortest()) return;
                //get start and end locations from search
                //sort locations start-end with shortest distance
                ArrayList<Location> temp = new ArrayList<Location>();
                Location curr = search.getStart();
                double totalDist = 0.0;
                
                int size = search.getMidLocations().size();
                
                for(int i = 0; i < size; i++){
                        double shortestD = Double.MAX_VALUE;
                        int shortest = -1;
                        for(int j = 0; j < search.getMidLocations().size(); j++)
                        {
                                double dist = curr.distanceTo(search.getMidLocations().get(j));
                                if((shortest==-1) || dist<shortestD)
                                {
                                        shortest = j;
                                        shortestD = dist;
                                }
                        }
                        temp.add(search.getMidLocations().remove(shortest)); //add to end of temp list, removing nearest neighbor from list of candidates
                        totalDist+=shortestD;
                        curr = temp.get(temp.size() - 1);
                }
                
                
                search.setLocations(temp) ;
                search.setOptimized(true);
                
                search.setDistance(totalDist + search.getEnd().distanceTo(search.getMidLocations().get(search.getMidLocations().size()-1))); //add distance from last element to ending location.
        }
        
        //public static void main(String args[]){
        //	Search s = new Search();
        //}
}