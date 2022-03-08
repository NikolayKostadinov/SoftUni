package entities;

public class Competitor implements Comparable<Competitor> {

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
        return Integer.compare(this.id, o.id);
    }
}
