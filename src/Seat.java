public class Seat {

    private boolean seatsAvailable = true;
    private char seatRow;
    private int seatNo;

    public boolean isSeatsAvailible() {
        return seatsAvailable;
    }

    public char getSeatRow() {
        return seatRow;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatsAvailible(boolean seatsAvailible) {
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

}
