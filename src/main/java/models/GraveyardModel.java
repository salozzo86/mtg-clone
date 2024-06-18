package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GraveyardModel {
    private final List<CardModel> cards;

    public void addCard(CardModel card) {
        cards.add(card);
    }

    public void removeCard(CardModel card) {
        cards.remove(card);
    }
}
