/*****************************************
 ** File: UserAuthentication
 ** Team Name: Cava++
 *Date: 10/18/13
 ** E-mail: Daniel Brandes bradan1@umbc.edu, 
 ** Lizset Chavez <lizset1@umbc.edu>
 ** Patrick Ritchie <ritc1@umbc.edu>,
 ** Xiaofei He <xiaofei2@umbc.edu>,
 ** Yo-Han Kim <ykim18@umbc.edu>,
 ** Jim Millican <jmill1@umbc.edu>
 ** Decription- File that simulates an authenticator to application
 ** for a user
***********************************************
* To be called from the adminGui class / Signin Gui class 
* and signupGui class / and switching to and from admin view. 
* The userAuthentication acts as
* a communicator between the application and the userFiles. 
* ***********************************************/

package coolgle;

public class UserAuthentication 
{
	//class variables
	/**
	 * constructor for UserAuthentication object
	 */
	public UserAuthentication()
        {
		
	}

	/**
	 * logUser
	 * Description - Given a UN / Password and userType, checks to see 
         *               the credentials are correct. Note : passwords are stored as char[]
         *               Note, user types are 1 = admin, 0 = user
	 * Pre- 
	 * Post -
	 */
	public boolean logUser(String userName, char[] password, int type)
        {
            return false; 
        }
        
	/**addUser
	 * Description - Given a new un / pw / email adds the user to the list of users
         *               Note : All users are created as users, an admin must promote them to admin
         *               returns true if user was successfully created. 
         *               Note : Also needs to create a user File to store recent searches, named same as username
	 * Pre- 
	 * Post -
	 */
	public boolean addUser(String name, String pass, String email)
        {
            return false;
        }
        
	/**removeUser
	 * Description- Given the userName, removes them from the file of users
         *              Also, removes their file. 
	 * Pre- 
	 * Post -
	 */
	public void removeUser(String userName)
        {
            
        }
        
	/**promoteUser
	 * Description- Given user name, if of type user, change to type admin else return false.
	 * Pre- 
	 * Post -
	 */
	public boolean promoteUser(String userName)
        {
            return false;
        }
        
	/**demoteUser
	 * Description- Given user name, if of type admin, change to type user else return false. 
	 * Pre- 
	 * Post -
	 */
	public boolean demoteUser(String userName)
        {
            return false;
        }
        
        
        /**getEmail
	 * Description- Given user name, return the users email
	 * Pre- 
	 * Post -
	 */
	public String getEmail(String useName)
        {
            return "";
        }
        
        /**getKey
	 * Description- Given user name, returns the users is a user (0) or admin (1)
	 * Pre- 
	 * Post -
	 */
	public int getKey(String useName)
        {
            return 0; 
        }
}
