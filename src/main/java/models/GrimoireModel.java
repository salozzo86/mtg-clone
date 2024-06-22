package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GrimoireModel {
    List<CardModel> cards;
}
