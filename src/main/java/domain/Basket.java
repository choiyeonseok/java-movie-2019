package domain;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<PickedScreening> baskets = new ArrayList<>();
    private int totalFee;

    public void addScreening(PickedScreening screening){
        baskets.add(screening);
        addToTotalFee(screening);
    }

    private void addToTotalFee(PickedScreening screening){
        totalFee += screening.getMoviePrice();
    }

    public void createReservation(ReservationList reservationList){
        for (PickedScreening screening : baskets){
            reservationList.addList(new Reservation(screening));
        }
        baskets = new ArrayList<>();
    }

    public int getTotalFee(){
        return totalFee;
    }
}
