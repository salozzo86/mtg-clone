package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter

public class GraveyardModel {
    private final List<CardModel> cards;

    public GraveyardModel() {
        this.cards = new ArrayList<>();
    }

    public void addCard(CardModel card) {
        cards.add(card);
    }

    public void removeCard(CardModel card) {
        cards.remove(card);
    }
}
