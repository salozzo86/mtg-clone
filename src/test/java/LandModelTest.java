import models.CardModel;
import models.LandModel;
import models.SubType;
import models.Type;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LandModelTest {
    @Test
    public void landModelTestCreation() {
        String name = "Mountain";
        CardModel.rarity rarity = CardModel.rarity.COMMON;
        SubType subType = new SubType("Mountain");

        LandModel landModel = new LandModel(name, rarity, subType);
        assertThat(landModel.getName()).isEqualTo(name);
        assertThat(landModel.getManaCost()).isEqualTo(0);
        assertThat(landModel.getRarity()).isEqualTo(CardModel.rarity.COMMON);
        assertThat(landModel.getSubType()).isEqualTo(subType);
        assertThat(landModel.getType().getType()).isEqualTo(Type.typeEnum.LAND);
    }


}
