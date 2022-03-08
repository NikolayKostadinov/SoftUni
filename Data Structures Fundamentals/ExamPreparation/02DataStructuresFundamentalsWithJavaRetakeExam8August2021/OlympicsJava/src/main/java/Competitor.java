import interfaces.Modify;

import java.util.Objects;

public class Competitor implements Comparable<Competitor>, Modify<Competitor> {

    private int id;
    private String name;
    private long totalScore;

    public Competitor(int id, String name) {
        this.totalScore = 0;
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(long totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public int compareTo(Competitor o) {
        int result =  Long.compare(this.getTotalScore(), getTotalScore());
        if (result == 0) {
            result = Integer.compare(id, o.getId());
        };

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Competitor that = (Competitor) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public void decrease(long score) {
        this.totalScore -= score;
        if (this.totalScore < 0 ) this.totalScore = 0;
    }

    @Override
    public void increase(long score) {
        this.totalScore +=   score;
    }
}
