package domain;

public class Reservation {
    private static int number = 0;

    private int reservationId;
    private PickedScreening screening;

    public Reservation(PickedScreening screening){
        this.screening = screening;
        reservationId = ++number;
    }

    @Override
    public String toString(){
        return "예약 번호 : " + reservationId + "\n"
                + screening.toString() + "\n";
    }
}
