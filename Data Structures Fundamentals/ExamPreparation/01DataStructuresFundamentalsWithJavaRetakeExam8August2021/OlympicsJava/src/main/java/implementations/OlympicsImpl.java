package implementations;

import entities.Competition;
import entities.Competitor;
import interfaces.AbstractBinarySearchTree;
import interfaces.Olympics;

import java.util.ArrayList;
import java.util.List;

public class OlympicsImpl implements Olympics {

    private final BinarySearchTree<Competitor> competitors;
    private final BinarySearchTree<Competition> competitions;

    public OlympicsImpl() {
        this.competitors = new BinarySearchTree<>();
        this.competitions = new BinarySearchTree<>();
    }


    @Override
    public void addCompetitor(int id, String name) {
        this.competitors.insert(new Competitor(id, name));
    }

    @Override
    public void addCompetition(int id, String name, int score) {
        this.competitions.insert(new Competition(name, id, score));
    }

    @Override
    public void compete(int competitorId, int competitionId) {
        Competitor competitor = this.competitors.searchElement(new Competitor(competitorId, ""));
        Competition competition = this.competitions.searchElement(new Competition("", competitionId, 0));

        competition.getCompetitors().add(competitor);
        competitor.setTotalScore(competitor.getTotalScore() + competition.getScore());
    }

    @Override
    public void disqualify(int competitionId, int competitorId) {
        Competitor competitor = this.competitors.searchElement(new Competitor(competitorId, ""));
        Competition competition = this.competitions.searchElement(new Competition("", competitionId, 0));

        if(!competition.getCompetitors().remove(competitor)) throw new IllegalArgumentException();
        competitor.setTotalScore(competitor.getTotalScore() - competition.getScore());
    }

    @Override
    public Iterable<Competitor> findCompetitorsInRange(long min, long max) {
        List<Competitor> result = new ArrayList<>();
        competitors.forEachInOrder(c -> {
            if (min < c.getTotalScore() && c.getTotalScore() <= max){
                result.add(c);
            }
        });
        return result;
    }

    @Override
    public Iterable<Competitor> getByName(String name) {
        List<Competitor> result = new ArrayList<>();
        competitors.forEachInOrder(c -> {
            if (c.getName().equals(name)){
                result.add(c);
            }
        });
        if (result.isEmpty()) throw new IllegalArgumentException();
        return result;
    }

    @Override
    public Iterable<Competitor> searchWithNameLength(int minLength, int maxLength) {
        List<Competitor> result = new ArrayList<>();
        competitors.forEachInOrder(c -> {
            if (minLength <= c.getName().length() && c.getName().length() <= maxLength){
                result.add(c);
            }
        });
        return result;
    }

    @Override
    public Boolean contains(int competitionId, Competitor comp) {
        Competition competition = this.competitions.searchElement(new Competition("", competitionId, 0));
        return competition.getCompetitors().contains(comp);
    }

    @Override
    public int competitionsCount() {
        return competitions.getSize();
    }

    @Override
    public int competitorsCount() {
        return competitors.getSize();
    }

    @Override
    public Competition getCompetition(int id) {
        return this.competitions.searchElement(new Competition("",id,0));
    }
}
