package models;

import java.util.ArrayList;
import java.util.List;

public class ExilePileModel {
    private final List<CardModel> cards;

    public ExilePileModel() {
        this.cards = new ArrayList<>();
    }

    public List<CardModel> getCards() {
        return new ArrayList<>(cards);
    }

    public void addCard(CardModel card) {
        cards.add(card);
    }
}
