package models;

import lombok.Getter;

@Getter
public class LifePointsModel {
    private int lifePoints;

    public LifePointsModel() {
        this.lifePoints = 20;
    }

    public void decreaseLifePoints(int lifePoints) {
        // using Math.max to avoid negative life points
        this.lifePoints = Math.max(0, this.lifePoints - lifePoints);
    }

    public void increaseLifePoints(int lifePoints) {
        this.lifePoints += lifePoints;
    }

    // how and where to check for player's defeat? what about simultaneous defeat?
}
