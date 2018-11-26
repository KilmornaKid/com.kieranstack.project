//Movie.java

import java.io.Serializable;

public class Movie implements Serializable {
    private String name;
    private int duration;
    private String ageRating;



    //setters
    public String getName() { return name; }

    public int getDuration() { return duration; }

    public String getAgeRating() { return ageRating; }




    //getters
    public void setName(String name) { this.name = name; }

    public void setDuration(int duration) { this.duration = duration; }

    public void setAgeRating(String ageRating) { this.ageRating = ageRating; }




    public Movie(){
        this("No Name",0,"NR");
    }

    public Movie(String name, int duration, String ageRating){
        this.name = name;
        this.duration = duration;
        this.ageRating = ageRating;


    }

    public String toString(){
        return "Movie: " + getName() + "\nDuration: " + getDuration() + "\nageRating: " + getAgeRating();
    }


}

