package domain;

import utils.DateTimeUtils;

import java.time.LocalDateTime;

import static utils.DateTimeUtils.format;

public class PlaySchedule {
    private final LocalDateTime startDateTime;
    private int capacity;

    public PlaySchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public boolean isCapacityAvailable(int headCount) {
        return capacity >= headCount;
    }

    public boolean isPastSchedule() {
        return LocalDateTime.now().isAfter(startDateTime);
    }

    public boolean isOneHourRange() {
        return DateTimeUtils.isOneHourWithinRange(LocalDateTime.now(), startDateTime);
    }

    public void minusCapacity(int headCount) {
        capacity -= headCount;
    }

}
