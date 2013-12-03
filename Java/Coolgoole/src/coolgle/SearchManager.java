// Given a search, the searchManager sorts it into the shortest path

package coolgle;

import java.util.ArrayList;

public class SearchManager 
{
        /**
         * sortShortestDistance
         * Description- 
         * Pre- 
         * Post -
         */
        
        public void sortShortestDistance(Search search)
        {
                //get start and end locations from search
                //sort locations start-end with shortest distance 
                ArrayList<Location> temp = new ArrayList<Location>();
                Location curr = search.start;
                double totalDist = 0.0;
                
                int size = search.locations.size();
                
                for(int i = 0; i < size; i++){
                        double shortestD = Double.MAX_VALUE;
                        int shortest = -1;
                        for(int j = 0; j < search.locations.size(); j++)
                        {
                                double dist = curr.distanceTo(search.locations.get(j));
                                if((shortest==-1) || dist<shortestD)
                                {
                                        shortest = j;
                                        shortestD = dist;
                                }
                        }
                        temp.add(search.locations.remove(shortest));  //add to end of temp list, removing nearest neighbor from list of candidates
                        totalDist+=shortestD;
                        curr = temp.get(temp.size() - 1);
                }
                
                
                search.locations = temp;
                search.optimized = true;
                
                search.distance = totalDist + search.end.distanceTo(search.locations.get(search.locations.size()-1)); //add distance from last element to ending location.
        }
}

