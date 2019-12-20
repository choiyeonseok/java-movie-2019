package domain;

public class PickedScreening {
    private Movie movie;
    private int sequence;
    private PlaySchedule playSchedule;
    private int headCount;

    public PickedScreening(Movie movie, int sequence) {
        this.movie = movie;
        this.sequence = sequence;
        this.playSchedule = movie.getPlaySchedule(sequence);
    }

    public boolean isNotCapableCount(int headCount) {
        return playSchedule.isOverCapacity(headCount);
    }

    public void minusCapacityAndSaveHeadCount(int headCount){
        playSchedule.minusCapacity(headCount);
        this.headCount = headCount;
    }

    public int getMoviePrice(){
        return movie.getPrice();
    }

}
