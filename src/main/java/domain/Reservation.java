package domain;

import java.time.LocalDateTime;

public class Reservation {
    private static final String NEW_LINE = "\n";

    private static int supportNumber = 0;

    private int reservationId;
    private int customerId;
    private String title;
    private LocalDateTime startDateTime;
    private int headCount;
    private double movieFee;

    public Reservation(int customerId, String title, LocalDateTime startDateTime, int headCount, double movieFee) {
        reservationId = supportNumber++;
        this.customerId = customerId;
        this.title = title;
        this.startDateTime = startDateTime;
        this.headCount = headCount;
        this.movieFee = movieFee;
    }

    @Override
    public String toString() {
        return "예매 번호 : " + reservationId + NEW_LINE
                + "고객 번호 : " + customerId + NEW_LINE
                + "영화 제목 : " + title + NEW_LINE
                + "시작 시간 : " + startDateTime + NEW_LINE
                + "예매 인원 : " + headCount + NEW_LINE
                + "결제 금액 : " + movieFee + "원" + NEW_LINE;
    }


}
