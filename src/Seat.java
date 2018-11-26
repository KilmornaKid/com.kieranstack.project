import java.io.Serializable;

public class Seat implements Serializable {

    private boolean seatsAvailable;
    private char seatRow;
    private int seatNo;

    public boolean isSeatsAvailable() {
        return seatsAvailable;
    }

    public char getSeatRow() {
        return seatRow;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatsAvailable(boolean seatsAvailible) {
        this.seatsAvailable = seatsAvailible;
    }

    public void setSeatRow(char seatRow) {
        this.seatRow = seatRow;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public Seat(){
        this(true,'A',0);
    }

    public Seat(boolean seatsAvailable, char seatRow, int seatNo){
        this.seatsAvailable = seatsAvailable;
        this.seatRow = seatRow;
        this.seatNo = seatNo;
    }

    public String toString(){
        return "Seat Availability: " + isSeatsAvailable() + "\nSeat Row: " + getSeatRow() + "\nSeat Number: " + getSeatNo();
    }

}
