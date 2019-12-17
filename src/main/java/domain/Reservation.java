package domain;

public class Reservation {
    private static final String NEW_LINE = "\n";

    private int reservationId;
    private int customerId;
    private String title;
    private PlaySchedule playSchedule;
    private double movieFee;

    public Reservation(int reservationId, int customerId, String title, PlaySchedule playSchedule, double movieFee) {
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.title = title;
        this.playSchedule = playSchedule;
        this.movieFee = movieFee;
    }

    @Override
    public String toString() {
        return "예약번호 : " + reservationId + NEW_LINE
                + "고객 번호 : " + customerId + NEW_LINE
                + "영화 제목 : " + title + NEW_LINE
                + "시작 시간 : " + playSchedule.getStartDateTime() + NEW_LINE
                + "결제 금액 : " + movieFee + "원" + NEW_LINE;
    }


}
