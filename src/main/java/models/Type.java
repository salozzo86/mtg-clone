package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Type {
     public enum typeEnum {
        ARTIFACT,
        CREATURE,
        ENCHANTMENT,
        INSTANT,
        LAND,
        PLANESWALKER,
        SORCERY
    }

    private final typeEnum type;

}
