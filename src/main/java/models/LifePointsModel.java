package models;

import lombok.Getter;

@Getter
public class LifePointsModel {
    private int lifePoints;

    public LifePointsModel() {
        this.lifePoints = 20;
    }

    public void takeDamage(int damage) {
        // using Math.max to avoid negative life points
        this.lifePoints = Math.max(0, this.lifePoints - damage);
    }
}
