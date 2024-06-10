package models;

import java.util.ArrayList;
import java.util.List;

public class GraveyardModel {
    private final List<CardModel> cards;

    public GraveyardModel() {
        this.cards = new ArrayList<>();
    }

    public List<CardModel> getCards() {
        return new ArrayList<>(cards);
    }

    public void addCard(CardModel card) {
        cards.add(card);
    }

    public void removeCard(CardModel card) {
        cards.remove(card);
    }
}
