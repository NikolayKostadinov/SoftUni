package viceCity.models.players;

import viceCity.common.ExceptionMessages;
import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.Repository;

import static viceCity.common.ExceptionMessages.*;

public class BasePlayer implements Player {
    private String name;
    private int lifePoints = 0;
    private Repository<Gun> gunRepository;

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new NullPointerException(PLAYER_NULL_USERNAME);
        this.name = name;
    }

    protected void setLifePoints(int lifePoints) {
        if (lifePoints < 0)
            throw new IllegalArgumentException(PLAYER_LIFE_POINTS_LESS_THAN_ZERO);
        this.lifePoints = lifePoints;
    }

    @Override
    public boolean isAlive() {
        return this.lifePoints > 0;
    }

    @Override
    public void takeLifePoints(int points) {
        this.lifePoints--;
        if (this.lifePoints < 0) this.lifePoints = 0;
    }
}
