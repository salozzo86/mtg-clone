package models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ExilePileModel {
    private final List<CardModel> cards;

    public ExilePileModel() {
        this.cards = new ArrayList<>();
    }

    public void addCard(CardModel card) {
        cards.add(card);
    }
}
