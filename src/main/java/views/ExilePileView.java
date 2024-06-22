package views;


import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.Panel;
import lombok.Getter;
import models.ExilePileModel;

@Getter
public class ExilePileView {
    private final Panel panel;

    public ExilePileView(ExilePileModel exilePileModel) {
        Label exilePileLabel = new Label("Exiled Cards: " + exilePileModel.getCards().size());
        panel = new Panel(new GridLayout(1));
        panel.addComponent(exilePileLabel);
    }
}
