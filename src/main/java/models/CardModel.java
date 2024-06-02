package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class CardModel {
    String name;

    int manaCost; // this will become a reference once we implement more card types

    public enum rarity {
        COMMON,
        UNCOMMON,
        RARE,
        MYTHICAL
    }

    private final rarity rarity;
    private final Type type;
    private final SubType subType;

}
