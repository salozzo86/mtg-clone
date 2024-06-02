package controllers;

import models.CardModel;
import models.DeckModel;
import models.LandModel;
import models.SubType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DeckController {

    public DeckModel generateDeck(int deckCapacity) {
        List<CardModel> cards = new ArrayList<>();
        String[] landTypes = new String[]{"Mountain", "Plain", "Island", "Swamp", "Forest"};
        Random rand = new Random();

        for (int i = 0; i < deckCapacity; i++) {
            String randomLand = landTypes[rand.nextInt(5)];
            cards.add(new LandModel(randomLand, CardModel.rarity.COMMON, new SubType(randomLand)));
        }
        return new DeckModel(cards);
    }

    public void shuffleDeck(DeckModel deck) {
        Collections.shuffle(deck.getCards());
    }
}
