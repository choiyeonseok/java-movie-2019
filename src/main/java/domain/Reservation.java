package domain;

public class Reservation {
    private static final String NEW_LINE = "\n";

    private int reservationId;
    private int customerId;
    private String title;
    private PlaySchedule playSchedule;
    private int headCount;
    private double movieFee;

    public Reservation(int reservationId, int customerId, String title, PlaySchedule playSchedule, int headCount, double movieFee) {
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.title = title;
        this.playSchedule = playSchedule;
        this.headCount = headCount;
        this.movieFee = movieFee;
    }

    @Override
    public String toString() {
        return "예매 번호 : " + reservationId + NEW_LINE
                + "고객 번호 : " + customerId + NEW_LINE
                + "영화 제목 : " + title + NEW_LINE
                + "시작 시간 : " + playSchedule.getStartDateTime() + NEW_LINE
                + "예매 인원 : " + headCount + NEW_LINE
                + "결제 금액 : " + movieFee + "원" + NEW_LINE;
    }


}
