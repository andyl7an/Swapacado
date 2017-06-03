package com.cpe307.swapacado.swapacado;
import java.util.Random;
/**
 * A class to represent the Post class
 * Created by aalok_000 on 5/21/2017.
 */

public class Post {
    public String posterId;
    public boolean isWant;
    public String wantString;
    public String hasString;
    public long epochTime;

    private String privateName;
    private String privateDistance;
    private String privateDate;
    private String privateWant;
    private int index = -1;
    private String privateHave;
    private String faceURL;
    private int nameIndex;
    private boolean isMan;

    static final String [] goods = new String [] {"Eggs", "Cereal", "Fruit", "Bagels", "Avocadoes", "Milk",
        "Plus Dollars", "Ice Cream", "Chocolate", "Tea", "Apple Juice", "Coke",
        "Bread","Granola bars","Ramen","Chips","Cookies","Wine",};
    //Need empty constructor for db
    public Post()
    {
        privateName = null;
        privateDistance = null;
        privateDate = null;
        privateWant = null;
        privateHave = null;
    }

    public static Post createPost(String posterId, boolean isWant, String wantString, String hasString)
    {
        Post p = new Post();
        p.posterId = posterId;
        p.isWant = isWant;
        p.wantString = wantString;
        p.hasString = hasString;
        p.epochTime = System.currentTimeMillis() / 1000;

        p.populateHiddenVariables();
        return p;
    }

    //A method to set the private variables for the program
    private void populateHiddenVariables() {
        getName();
        getDistanceString();
        getHaveString();
        getWantString();
        getPostTimeString();
    }

    //Stub method returning dummy data
    public String getName()
    {
        Random r = new Random();
        if(privateName != null)
        {
            return privateName;
        }
        String [] names = new String [] {"Davide", "Zach", "Bill", "Andy", "Josh", "Aalok", "Brandon", "Michael", "Mark", "Harry", "Richard", "Tim", "Russell",
            "Alex", "Mary", "Barbara", "Sam", "Linda", "Sophia", "Emma", "Olivia", "Ava", "Lily", "Zoe", "Allison", "Anne"};
        int rand = r.nextInt(names.length);

        if(faceURL == null)
        {
            if (rand < names.length / 2) {
                nameIndex = rand;
                faceURL = getRandomMaleFace();
                isMan = true;
            } else {
                nameIndex = rand - names.length/2;
                faceURL = getRandomWomenFace();
                isMan = false;
            }
        }
        privateName =  names[rand];
        return getName();
    }

    //Unused: removed from code
    private String getRandomMaleFace() {
        Random r = new Random();
        final String [] faces = new String []{
            "https://s-media-cache-ak0.pinimg.com/736x/ff/97/9f/ff979fc66dcb9cfb401cf2d5ccbdf295.jpg",
            "http://1.bp.blogspot.com/-crCjfff-csY/UeOBkw_DCuI/AAAAAAAAATI/QXzsnQLIZv4/s1600/Facial-mask-for-men-at-home.jpg",
            "https://menfash.us/wp-content/uploads/2014/01/face-hair-removal-creams.jpg",
            "http://starcastinguk.com/wp-content/uploads/2012/10/arthur-1.jpg",
            "https://cdn0.artstation.com/p/assets/images/images/001/041/304/large/andor-kollar-andorkollar-malehead1.jpg?1443932143",
            "https://i.ytimg.com/vi/2sikJPJzgaA/maxresdefault.jpg",
            "http://i1.ytimg.com/vi/FhtQKF5knO0/maxresdefault.jpg",
            "http://www.coolmenhairstyles.com/wp-content/uploads/Hairstyles-Men-Face-Shape-14.jpg",
            "https://s-media-cache-ak0.pinimg.com/736x/54/f9/fe/54f9fe92e3c7deeac8134cf5ae875e24.jpg",
            "https://c2.staticflickr.com/6/5038/13564741125_94d042571f_b.jpg",
            "https://cdn.pixabay.com/photo/2015/09/18/11/46/man-945482_960_720.jpg",
            "http://facialexercisesguide.com/wp-images/man-face.jpg",
            "https://www.drhilinski.com/wp-content/uploads/2010/12/RevRhino72FrontalAfter.jpg",
            "https://www.drhilinski.com/wp-content/uploads/2010/12/RevRhino72FrontalAfter.jpg",
            "http://photo.elsoar.com/wp-content/images/Joyful-man-face.jpg",
            "http://image.brands-list.com/articleimg/20150408/20150408171536_64345.jpg",
            "https://s-media-cache-ak0.pinimg.com/736x/3c/e7/fb/3ce7fb4af79d08b5466c3bbfc4075e5d.jpg",
            "http://www.taylorherring.com/blog/wp-content/uploads/2015/03/Archetypal-Male-Face-of-Beauty-embargoed-to-00.01hrs-30.03.15.jpg",
            "http://www.organiconline.com.sg/rg/face/rg-men-face-1.jpg",
        };
        int i = r.nextInt(faces.length);
        return faces[i];
    }

    //Unused : removed from code
    private String getRandomWomenFace() {
        Random r = new Random();
        final String [] faces = new String []{
            "https://beautysaloon.files.wordpress.com/2010/03/beautiful-face-wallpapers_11213_1280x1024.jpg",
            "http://wallstreetinsanity.com/wp-content/uploads/This-Survey-Shows-Us-How-Different-Men-And-Women-View-The-Perfect-Female-Face-.jpg",
            "https://www.laprogressive.com/wp-content/uploads/2012/03/woman-face.gif",
            "https://images7.alphacoders.com/548/548682.jpg",
            "http://www.simplethingcalledlife.com/wp-content/uploads/2015/02/yana-russian-model-1.jpg",
            "http://www.mrwallpaper.com/wallpapers/beautiful-woman-face.jpg",
            "http://wallpoper.com/images/00/39/87/82/women-faces_00398782.jpg",
            "https://s-media-cache-ak0.pinimg.com/736x/5e/1d/98/5e1d9840bd04e3277aa47c48443a083d.jpg",
            "http://cdn.blackenterprise.com/wp-content/blogs.dir/1/files/2011/03/woman-face-620x480.jpg",
            "http://perfectskinsolutions.co.uk/wp-content/uploads/2014/06/woman-face-mobile.png",
            "http://res-v.com/wp-content/uploads/2014/10/bigstock-Beautiful-Woman-Face-Beauty-P-52669777.jpg",
            "http://www.mishwarek.com/wp-content/uploads/2014/07/Womans-face.jpg",
            "http://spachiara.com/wp-content/uploads/2015/03/woman_touching_her_face_and_head_spa.jpg",
            "http://www.wallpaperup.com/uploads/wallpapers/2013/06/19/104800/6ac15eb680378a19c0c721766c52cb6f.jpg",
            "http://ckplasticsurgeryinc.com/wp-content/uploads/2014/12/Beauty-portrait-of-young-woman-with-beautiful-healthy-face_s.png",
            "http://www.mulierchile.com/face/face-004.jpg",
            "http://wallpoper.com/images/00/36/80/84/women-faces_00368084.jpg",
            "http://percamaestheticclinic.co.uk/wp-content/uploads/2014/12/picture-3.jpg",
            "http://media32.onsugar.com/files/2011/09/36/1/1798/17982701/c0f25015b4289dd6_face_of_a_young_chinese_woman_is098uk2u.jpg",
            "http://www.uni-regensburg.de/Fakultaeten/phil_Fak_II/Psychologie/Psy_II/beautycheck/english/kindchenschema/kindfrau_c/kindfrau_c_60_gr.jpg",

        };
        int i = r.nextInt(faces.length);
        return faces[i];
    }
    public String getFaceURL()
    {
        return faceURL;
    }

    public String getDistanceString()
    {
        Random r = new Random();
        if(privateDistance != null)
        {
            return privateDistance;
        }
        int rand = r.nextInt(50) + 1;
        double milesAway = rand / 10.0;
        privateDistance = String.format("%.1f miles", milesAway);
        return getDistanceString();
    }
    public String getPostTimeString()
    {
        Random r = new Random();
        if(privateDate != null)
        {
            return privateDate;
        }
        String output = "";
        int hr = 8 + r.nextInt(12);
        int min =  r.nextInt(60);
        if(hr < 12)
        {
            output = hr + ":";
            if(min < 10)
            {
                output = output + "0" + min;
            }
            else
            {
                output = output + min;
            }
            output += " am";
        }
        else if(hr == 12)
        {
            output = "12:";
            if(min < 10)
            {
                output = output + "0" + min;
            }
            else
            {
                output = output + min;
            }
            output += " pm";
        }
        else
        {
            hr -= 12;
            output = hr + ":";
            if(min < 10)
            {
                output = output + "0" + min;
            }
            else
            {
                output = output + min;
            }
            output += " pm";

        }
        privateDate = output;
        return getPostTimeString();
    }
    public String getWantString()
    {
        Random r = new Random();
        if(privateWant != null)
        {
            return privateWant;
        }
        int rand = r.nextInt(goods.length);
        while(index == rand)
        {
            rand = r.nextInt(goods.length);
        }
        index = rand;
        privateWant = "I want: " + goods[rand];
        return getWantString();
    }
    public String getHaveString()
    {
        Random r = new Random();
        if(privateHave != null)
        {
            return privateHave;
        }
        int rand = r.nextInt(goods.length);
        while(index == rand)
        {
            rand = r.nextInt(goods.length);
        }
        index = rand;
        privateHave = "I have: " + goods[rand];
        return getHaveString();
    }
    public boolean matchesSearchQuery(String query)
    {
        String upperQuery;
        String searchString = "";
        if(privateName != null)
        {
            searchString += privateName;
        }
        if(privateWant != null)
        {
            searchString += privateWant;
        }
        if(privateHave != null)
        {
            searchString += privateHave;
        }
        searchString = searchString.toUpperCase();
        upperQuery = query.toUpperCase();
        return searchString.indexOf(upperQuery) != -1;
    }

    public boolean matchesHaves(String query) {
        if(privateHave != null)
        {
            return privateHave.toUpperCase().indexOf(query.toUpperCase()) != -1;
        }
        return false;
    }
    public boolean matchesWants(String query) {
        if(privateWant != null)
        {
            return privateWant.toUpperCase().indexOf(query.toUpperCase()) != -1;
        }
        return false;
    }

    public int getFaceRID() {
        if(isMan)
        {
            switch(nameIndex){
                case 0: return R.drawable.man1;
                case 1: return R.drawable.man2;
                case 2: return R.drawable.man3;
                case 3: return R.drawable.man4;
                case 4: return R.drawable.man5;
                case 5: return R.drawable.man6;
                case 6: return R.drawable.man7;
                case 7: return R.drawable.man8;
                case 8: return R.drawable.man9;
                case 9: return R.drawable.man10;
                case 10: return R.drawable.man11;
                case 11: return R.drawable.man12;
                case 12: return R.drawable.man13;
                case 13: return R.drawable.man14;
                default: return R.drawable.man15;
            }
        }
        else
        {
            switch(nameIndex){
                case 0 : return R.drawable.woman1;
                case 1 : return R.drawable.woman2;
                case 2 : return R.drawable.woman3;
                case 3 : return R.drawable.woman4;
                case 4 : return R.drawable.woman5;
                case 5 :return R.drawable.woman6;
                case 6 : return R.drawable.woman7;
                case 7 : return R.drawable.woman8;
                case 8 : return R.drawable.woman9;
                case 9 : return R.drawable.woman10;
                case 10 : return R.drawable.woman11;
                case 11 : return R.drawable.woman12;
                case 12 : return R.drawable.woman13;
                case 13 : return R.drawable.woman14;
                case 14 : return R.drawable.woman15;
                default :  return R.drawable.woman16;
            }

        }

    }

}
