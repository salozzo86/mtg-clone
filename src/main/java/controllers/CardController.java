package controllers;

import models.CardModel;
import models.LandModel;
import models.SubType;

import java.util.Random;

public class CardController {

    public LandModel[] generateCards(int numberOfCards) {
        Random rand = new Random();
        LandModel[] lands = new LandModel[numberOfCards];
        String[] landTypes = new String[]{"Mountain", "Plain", "Island", "Swamp", "Forest"};

        for (int i = 0; i < lands.length; i++) {
            int randomIndex = rand.nextInt(landTypes.length);
            String randomLand = landTypes[randomIndex];
            lands[i] = new LandModel(randomLand, CardModel.rarity.COMMON, new SubType(randomLand));
        }

        return lands;
    }

}
