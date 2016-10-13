package codebrains.edufind.Controllers;

import android.app.Activity;

import org.json.JSONObject;

import codebrains.edufind.Models.BookModel;

/**
 * Controller class that handles the calling of all the necessary methods in order to finish
 * the book addition process. This class follows the MVC architecture idea.
 */
public class BookController {

    private JSONObject newBookData;

    //Constructor
    public BookController() {
        this.newBookData = new JSONObject();
    }

    /**
     * Control method for the book addition process.
     * @param mActivity The activity that called the event.
     * @return Returns a boolean that represents the status of the process.
     */
    public boolean BookAdditionProcess(Activity mActivity, JSONObject userdata) {

        BookModel bm = new BookModel();
        this.newBookData = bm.GetAddNewBookFormData(mActivity, userdata);

        if(this.newBookData == null)
            return false;

        return true;
    }

    /**
     * Method that returns the initialized book json.
     * @return Returns the private book json object.
     */
    public JSONObject GetNewBookJson() {
        return this.newBookData;
    }

}