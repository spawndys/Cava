package coolgle;
/*****************************************
 ** File: Gui
 ** Team Name: Cava++
 *Date: 10/18/13
 ** E-mail: Daniel Brandes bradan1@umbc.edu, 
 ** Lizset Chavez <lizset1@umbc.edu>
 ** Patrick Ritchie <ritc1@umbc.edu>,
 ** Xiaofei He <xiaofei2@umbc.edu>,
 ** Yo-Han Kim <ykim18@umbc.edu>,
 ** Jim Millican <jmill1@umbc.edu>
 ** Decription- Interface for user to use to interact with
***********************************************
* Is created from driver class, is class that begins to show the gui
***********************************************/
public class UIManager 
{
	public UIManager()
        {
            displayLogInGui();
        }
        
        /**
	 * displayLogInGui()
	 * Description- This will be a function to load login screen
	 * Pre-
	 * Post-
	 */
	private void displayLogInGui()
        {
		SignInGui logInPage = new SignInGui();
                logInPage.setVisible(true);
	}
	/**displayUserGui()
	 * Description- This will be a function to load an user screen
	 * Pre-
	 * Post-
	 */
	private void displayUserGui()
        {
		
	}
	/**displayAdminGui()
	 * Description- This will be a function to load an admin screen
	 * Pre-
	 * Post-
	 */
	private void displayAdminInGui()
        {
	
	}
	/**
	 * displaySearchGui()
	 * Description- This will be a function to load a search screen
	 * Pre-
	 * Post-
	 */
	private void displaySearchInGui()
        {
		
	}
}
