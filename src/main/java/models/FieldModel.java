package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FieldModel {
    /*
    [x] playerHand
    [x] opponentHand

    [x] playerLifePoints
    [x] opponentLifePoints

    [x] playerDeck
    [x] opponentDeck

    [x] playerGraveyard
    [x] opponentGraveyard

    [x] playerExilePile
    [x] opponentExilePile

    [] actionMenu
     */

    private LifePointsModel playerLifePoints;
    private LifePointsModel opponentLifePoints;
    private DeckModel playerDeck;
    private DeckModel opponentDeck;
    private GraveyardModel playerGraveyard;
    private GraveyardModel opponentGraveyard;
    private ExilePileModel playerExilePile;
    private ExilePileModel opponentExilePile;
    private HandModel playerHand;
    private HandModel opponentHand;


}
