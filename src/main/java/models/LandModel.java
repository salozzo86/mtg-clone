package models;

public class LandModel extends CardModel{

    public LandModel(String name, rarity rarity, SubType subType) {
        super(name, 0, rarity, new Type(Type.typeEnum.LAND), subType);
    }
}
