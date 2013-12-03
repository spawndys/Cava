package coolgle;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
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
        private static final String PATH = "UserFiles\\";
        private static final int MAX_PREVIOUS_TRIPS = 10;
        private static final String SUFFIX = ".txt";
                
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
            Search prevSearch = new Search();
            try 
            {                                        
                String temp = PATH + userName + SUFFIX;
                String newLine = "StartTime";           //This is the indicator that we've reached a new search
                String endMidLocs = "shortestCoords";   //This is the indicator that we've reached the end of a seach
                Location mid;                
                File file = new File(temp);
                
                String startTime = "";
                ArrayList<Location> locations = new ArrayList<Location>();
                                                                
                if(file.exists())
                {                
                        BufferedReader br = new BufferedReader(new FileReader(temp));
                        //get all lines from file
                        int index = 0;
                        String currLine;
                        while ((currLine = br.readLine()) != null)
                        {
                                //align scanner to searchIndex
                                if( currLine.startsWith(newLine) ) // If start of a search
                                {
                                        index++;
                                        if(index == searchIndex) //If this is the right search
                                        {
                                                startTime = currLine;
                                                
                                                String startingTime = currLine.substring(10);
                                                //prevSearch.setStartTime(Integer.parseInt(startingTime));
                                                
                                                //Then as long as the next line isn't the end of search line, make locations
                                                boolean hasMoreLocation = true;
                                                while (hasMoreLocation)
                                                {
                                                    currLine = br.readLine();
                                                    if (currLine.compareTo(endMidLocs) == 0)
                                                        hasMoreLocation = false;
                                                    else //Its a location
                                                    {
                                                        Location newLocation = new Location(currLine);
                                                        locations.add(newLocation);
                                                    }
                                                }
                                                prevSearch.setStart(locations.get(0));
                                                locations.remove(0);
                                                prevSearch.setEnd(locations.get(locations.size() - 1));
                                                locations.remove(locations.size() - 1);
                                                for ( int i = 0; i < locations.size(); i++ )
                                                {
                                                     prevSearch.addLocation(locations.get(i));
                                                }
                                        }
                                }                                
                        }                        
                }
                else
                {
                        System.out.println("File not found(addSearch)");                                
                }
                
        } 
        catch (IOException e) 
        {
                System.out.println("File error");
        }
            
        return prevSearch;
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
                                if(inLine.next().equals(newLine))
                                {
                                        searchCount +=1;
                                        if(searchCount >= MAX_PREVIOUS_TRIPS)
                                        {
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
        public void addSearch(Search search)
        {
                try 
                {                
                        String line;                        
                        String temp = PATH + search.getUserName() + SUFFIX;               
                        File file = new File(temp);

                        if( file.exists() )
                        {
                                if( isFull(file) )
                                {
                                        JOptionPane.showMessageDialog(null, "File is full, cannot save search"
                                        , "Failure", JOptionPane.ERROR_MESSAGE);
                                }
                                else
                                {                                   
                                        //append data to end of file
                                        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));                                
                                        out.write(search.fileToString().replaceAll("\n", System.lineSeparator()));                                
                                        out.close();
                                }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "User (" + search.getUserName() + ") file not found, Cannot save seach"
                                    , "Failure", JOptionPane.ERROR_MESSAGE);                     
                        }
                        
         } 
         catch (IOException e) 
         {
                 
                 JOptionPane.showMessageDialog(null, "IOException when opening file, search will not be saved"
                                        , "Failure", JOptionPane.ERROR_MESSAGE);
         }
                
        }
        
        /**removeUser()
         * Description- removes users searches
         * Pre- user exists
         * Post- removes text file for user
         */
        public void removeUserFile(String userName)
        {
                //REMOVES new user SEARCH file
                String temp = "";
                temp += PATH + userName + SUFFIX;
                File file = new File(temp);                
                if( !file.exists() )
                {
                        JOptionPane.showMessageDialog(null, "User File Doesn't Exist", "Failure", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                        file.deleteOnExit();
                }
        }
        
        /**addUser()
         * Description- adds file for users search
         * Pre-
         * Post-adds text file for user
         */
        public void addUserFile(String userName)
        {
                //adds new user SEARCH file
                String temp = "";
                temp += PATH + userName + SUFFIX;                
                File file = new File(temp);
                try 
                {
                        if(file.exists())
                        {
                                JOptionPane.showMessageDialog(null, "File Already Exists", "Failure", JOptionPane.ERROR_MESSAGE);
                        }
                        else
                        {
                                file.createNewFile();
                        }
                } 
                catch (IOException e) 
                {
                        JOptionPane.showMessageDialog(null, "IOException Error", "Failure", JOptionPane.ERROR_MESSAGE);
                }                        
        }
        
}