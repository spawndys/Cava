package coolgle;
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
***********************************************/
public class UserAuthentication {
	//class variables
	FileManager fm = new FileManager();
	/**
	 * constructor for UserAuthentication object
	 */
	public UserAuthentication(){
		
	}

	/**
	 * logUser
	 * Description- 
	 * Pre- 
	 * Post -
	 */
	public void logUser(){
		
		
	}
	/**addUser
	 * Description- 
	 * Pre- 
	 * Post -
	 */
	public void addUser(String userName){
		//add search txt file
		fm.addUserFile(userName);
		//add UID-pass info
		
	}
	/**removeUser
	 * Description- 
	 * Pre- 
	 * Post -
	 */
	public void removeUser(String userName){
		//add search txt file
		fm.removeUserFile(userName);
		//add UID-pass info
				
		
	}
	/**promoteUser
	 * Description- 
	 * Pre- 
	 * Post -
	 */
	public void promoteUser(){
		
		
	}
	/**demoteUser
	 * Description- 
	 * Pre- 
	 * Post -
	 */
	public void demoteUser(){
		
	}
	/**addLocation
	 * Description- 
	 * Pre- 
	 * Post -
	 */
	public void addLocation(){}
	/**removeLocation
	 * Description- 
	 * Pre- 
	 * Post -
	 */
	public void removeLocation(){}
	
	
}
