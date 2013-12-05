/*****************************************
 ** File: UIManager
 ** Team Name: Cava++
 ** Date: 10/18/13
 ** E-mail: Daniel Brandes bradan1@umbc.edu, 
 ** Lizset Chavez <lizset1@umbc.edu>
 ** Patrick Ritchie <ritc1@umbc.edu>,
 ** Xiaofei He <xiaofei2@umbc.edu>,
 ** Yo-Han Kim <ykim18@umbc.edu>,
 ** Jim Millican <jmill1@umbc.edu>
 ** Description- Interface for user to use to interact with
***********************************************
* Is created from driver class, is class that begins to show the gui
***********************************************/
package coolgle;

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
}
