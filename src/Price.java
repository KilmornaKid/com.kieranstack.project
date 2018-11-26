public class Price {
    private double adultPrice;
    private double studentPrice;
    private double childPrice;

    public void setAdultPrice(double adultPrice) {
        this.adultPrice = adultPrice;
    }

    public void setStudentPrice(double studentPrice) {
        this.studentPrice = studentPrice;
    }

    public void setChildPrice(double childPrice) {
        this.childPrice = childPrice;
    }

    public double getAdultPrice() {
        return adultPrice;
    }

    public double getStudentPrice() {
        return studentPrice;
    }

    public double getChildPrice() {
        return childPrice;
    }

    public Price(){
        this(0f,0f,0f);
    }

    public Price(double AdultPrice, double studentPrice, double childPrice) {
        this.adultPrice = adultPrice;
        this.studentPrice = studentPrice;
        this.childPrice = childPrice;
    }

    public String toString(){
        return "Adult Price " + String.format("%.2f",getAdultPrice());
    }
}
