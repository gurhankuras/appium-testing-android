package app.dataclass;

public class ReservationFormData {
    String checkInDate;
    String checkOutDate;
    String numberOfChild;
    String numberOfPerson;
    String city;

    public ReservationFormData(String checkInDate, String checkOutDate, String numberOfChild, String numberOfPerson, String city) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfChild = numberOfChild;
        this.numberOfPerson = numberOfPerson;
        this.city = city;
    }
/*
    public static ReservationFormData valid() {
        return ReservationFormData("14/02/2022", "16/02/2022", )
    }

 */
}
