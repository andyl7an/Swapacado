package com.cpe307.swapacado.swapacado;

/* The User Account class contains all variable that define a individual on the Swapacado platform.
 * Copy of code not in package
 *@author Andy Tan
 *@version 1.0
 *@since 2017-05-06
 */

public class UserAccount {
    protected String username;
    protected String firstName;
    protected String lastName;
    protected int id;
    protected String phoneNumber;
    protected double rating;
    protected String imagePath;

    /**
     * Constructor for new user account
     */
    public UserAccount()
    {
        //initialize variables here
    }

    /**
     * This method returns the user's username
     * @return this.username
     */
    public String getUsername()
    {
        return this.username;
    }

    /**
     * This method returns the user's first name
     * @return this.firstName
     */
    public String getFirstname()
    {
        return this.firstName;
    }

    /**
     * This method returns the user's last name
     * @return this.Lastname
     */
    public String getLastname()
    {
        return this.lastName;
    }

    /**
     * This method returns the user's unique id
     * @return this.id
     */
    public int getID()
    {
        return this.id;
    }

    /**
     * This method returns the user's phone number
     * @return this.phoneNumber
     */
    public String getPhoneNumber()
    {
        return this.phoneNumber;
    }

    /**
     * This method returns the user's rating
     * @return this.rating
     */
    public double getRating()
    {
        return this.rating;
    }

    /**
     * This method returns the user's image path
     * @return this.imagepath
     */
    public String getImagepath()
    {
        return this.imagePath;
    }

    /**
     * This method returns the user's unique id
     * @param input username of user
     * @return true if successfully set, false otherwise
     */
    public boolean setUsername(String input)
    {
        int userLen = input.length();
        if (userLen > 20 || userLen < 4)
        {
            return false;
        }
        this.username = input;
        return true;
    }

    /**
     * This method returns the user's unique id
     * @param input first name of user
     * @return true if successfully set, false otherwise
     */
    public boolean setFirstname(String input)
    {
        for (int i = 0; i < input.length(); i++)
        {
            char c = input.charAt(i);
            if (Character.isDigit(c))
            {
                return false;
            }
        }
        this.firstName = input;
        return true;
    }

    /**
     * This method returns the user's unique id
     * @param input last name of user
     * @return true if successfully set, false otherwise
     */
    public boolean setLastname(String input)
    {
        for (int i = 0; i < input.length(); i++)
        {
            char c = input.charAt(i);
            if (Character.isDigit(c))
            {
                return false;
            }
        }
        this.lastName = input;
        return true;
    }

    /**
     * This method returns the user's unique id
     * @param input id of user
     * @return true if successfully set, false otherwise
     */
    public boolean setId(int input)
    {
        this.id = input;
        return true;
    }

    /**
     * This method returns the user's unique id
     * @param input phone number of user
     * @return true if successfully set, false otherwise
     */
    public boolean setPhoneNumber(String input)
    {
        if (input.length() != 10)
        {
            return false;
        }
        for (int i = 0 ; i < input.length(); i++)
        {
            char c = input.charAt(i);
            if (!Character.isDigit(c))
            {
                return false;
            }
        }
        this.phoneNumber = input;
        return true;
    }

    /**
     * This method returns the user's unique id
     * @param input rating of user
     * @return true if successfully set, false otherwise
     */
    public boolean setRating(float input)
    {
        if (input > 5 || input < 0)
        {
            return false;
        }
        this.rating = input;
        return true;
    }

    /**
     * This method returns the user's unique id
     * @param input image path to profile picture of user
     * @return true if successfully set, false otherwise
     */
    public boolean setImagePath(String input)
    {
        this.imagePath = input;
        return true;
    }

}
