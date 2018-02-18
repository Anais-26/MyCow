package pe.com.mycow.models;

public class ReserveSpace {
    private int id;
    private String reservationDate;
    private int numHours;
    private int numDays;

    public ReserveSpace(int id, String reservationDate, int numHours, int numDays) {
        this.id = id;
        this.reservationDate = reservationDate;
        this.numHours = numHours;
        this.numDays = numDays;
    }

    public ReserveSpace() {
    }

    public int getId() {
        return id;
    }

    public ReserveSpace setId(int id) {
        this.id = id;
        return this;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public ReserveSpace setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
        return this;
    }

    public int getNumHours() {
        return numHours;
    }

    public ReserveSpace setNumHours(int numHours) {
        this.numHours = numHours;
        return this;
    }

    public int getNumDays() {
        return numDays;
    }

    public ReserveSpace setNumDays(int numDays) {
        this.numDays = numDays;
        return this;
    }
}

