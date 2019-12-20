package domain;

import java.util.ArrayList;
import java.util.List;

public class ReservationList {
    private List<Reservation> reservationList = new ArrayList<>();

    public void addList(Reservation reservation){
        reservationList.add(reservation);
    }

    public String toString(){
        String list = "";
        for (Reservation reservation : reservationList){
            list += reservation.toString() + "\n";
        }
        return list;
    }
}
