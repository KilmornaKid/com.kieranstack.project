//Movie.java

public class Movie {
    private String name;
    private float duration;
    private String ageRating;
    private float price;


    //setters
    public String getName() { return name; }

    public float getDuration() { return duration; }

    public String getAgeRating() { return ageRating; }

    public float getPrice() { return price; }



    //getters
    public void setName(String name) { this.name = name; }

    public void setDuration(float duration) { this.duration = duration; }

    public void setAgeRating(String ageRating) { this.ageRating = ageRating; }

    public void setPrice(float price) { this.price = price; }


    public Movie(){
        this("No Name",0f,"NR",0.00f);
    }

    public Movie(String name, float duration, String ageRating, float price){
        this.name = name;
        this.duration = duration;
        this.ageRating = ageRating;
        this.price = price;

    }


}

