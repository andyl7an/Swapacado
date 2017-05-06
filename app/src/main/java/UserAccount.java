/**
 * Created by imeanigeese on 5/5/2017.
 */

public class UserAccount {
    protected String name;
    protected int id;
    protected String phoneNumber;
    protected double rating;
    protected String imagepath;

    //constructor
    public UserAccount(){

    }

    public String getName(){
        return this.name;
    }

    public int getID(){
        return this.id;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public double getRating(){
        return this.rating;
    }

    public String getImagepath(){
        return this.imagepath;
    }

    public boolean setName(){
        return true;
    }

    public boolean setId(){
        return true;
    }

    public boolean setPhoneNumber(){
        return true;
    }

    public boolean setRating(){
        return true;
    }

    public boolean setImagePath(){
        return true;
    }

}
