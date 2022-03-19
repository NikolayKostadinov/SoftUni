import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class OlympicsImpl implements Olympics {

    private final Map<Integer, Competitor> competitorsById;
    private final Map<Integer, Competition> competitionsById;

    public OlympicsImpl() {
        this.competitorsById = new TreeMap<>();
        this.competitionsById = new TreeMap<>();
    }


    @Override
    public void addCompetitor(int id, String name) {
        if (this.competitorsById.containsKey(id)) {
            throw new IllegalArgumentException();
        }
        Competitor competitor = new Competitor(id, name);
        this.competitorsById.putIfAbsent(id, competitor);
    }

    @Override
    public void addCompetition(int id, String name, int score) {
        if (this.competitionsById.containsKey(id)) {
            throw new IllegalArgumentException();
        }

        Competition competition = new Competition(name, id, score);
        this.competitionsById.put(id, competition);
    }

    @Override
    public void compete(int competitorId, int competitionId) {
        ensureCompetitorInCompetition(competitorId, competitionId);
        Competition competition = this.competitionsById.get(competitionId);
        Competitor competitor = this.competitorsById.get(competitorId);
        competitor.setTotalScore(competitor.getTotalScore() + competition.getScore());
        competition.getCompetitors().add(competitor);
    }

    @Override
    public void disqualify(int competitionId, int competitorId) {
        ensureCompetitorInCompetition(competitorId, competitionId);
        Competition competition = this.competitionsById.get(competitionId);
        Competitor competitor = this.competitorsById.get(competitorId);
        if (!competition.getCompetitors().remove(competitor)) {
            throw new IllegalArgumentException();
        }
        competitor.setTotalScore(competitor.getTotalScore() - competition.getScore());
    }

    @Override
    public Iterable<Competitor> findCompetitorsInRange(long min, long max) {
        return this.competitorsById
                .entrySet()
                .stream()
                .filter(x -> min < x.getValue().getTotalScore()
                        && x.getValue().getTotalScore() <= max)
                .map(x -> x.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Competitor> getByName(String name) {
        List<Competitor> competitors =
                this.competitorsById
                        .entrySet()
                        .stream()
                        .filter(c -> c.getValue().getName().equals(name))
                        .map(c -> c.getValue())
                        .collect(Collectors.toList());
        if (competitors.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return competitors;
    }

    @Override
    public Iterable<Competitor> searchWithNameLength(int minLength, int maxLength) {
        return this.competitorsById
                .entrySet()
                .stream()
                .filter(x -> minLength <= x.getValue().getName().length()
                        && x.getValue().getName().length() <= maxLength)
                .map(x -> x.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public Boolean contains(int competitionId, Competitor comp) {
        if (!this.competitionsById.containsKey(competitionId)) {
            throw new IllegalArgumentException();
        }
        return this.competitionsById.get(competitionId).getCompetitors().contains(comp);
    }

    @Override
    public int competitionsCount() {
        return this.competitionsById.size();
    }

    @Override
    public int competitorsCount() {
        return this.competitorsById.size();
    }

    @Override
    public Competition getCompetition(int id) {
        if (!this.competitionsById.containsKey(id)) {
            throw new IllegalArgumentException();
        }

        return this.competitionsById.get(id);
    }

    private void ensureCompetitorInCompetition(int competitorId, int competitionId) {
        if (!(this.competitorsById.containsKey(competitorId)
                && this.competitionsById.containsKey(competitionId))) {
            throw new IllegalArgumentException();
        }
    }
}
