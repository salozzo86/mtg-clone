package controllers;

import models.CardModel;
import models.GrimoireModel;
import models.LandModel;
import models.SubType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GrimoireController {

    public GrimoireModel generateDeck(int deckCapacity) {
        List<CardModel> cards = new ArrayList<>();
        String[] landTypes = new String[]{"Mountain", "Plain", "Island", "Swamp", "Forest"};
        Random rand = new Random();

        for (int i = 0; i < deckCapacity; i++) {
            String randomLand = landTypes[rand.nextInt(5)];
            cards.add(new LandModel(randomLand, CardModel.rarity.COMMON, new SubType(randomLand)));
        }
        return new GrimoireModel(cards);
    }

    public void shuffleDeck(GrimoireModel deck) {
        Collections.shuffle(deck.getCards());
    }
}
