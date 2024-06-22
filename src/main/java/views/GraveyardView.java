package views;

import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.Panel;
import lombok.Getter;
import models.GraveyardModel;

@Getter
public class GraveyardView {
    private final Panel panel;

    public GraveyardView(GraveyardModel graveyardModel) {
        Label graveyardLabel = new Label("Graveyard: " + graveyardModel.getCards().size());
        panel = new Panel(new GridLayout(1));
        panel.addComponent(graveyardLabel);
    }
}
