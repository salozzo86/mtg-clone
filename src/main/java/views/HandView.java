package views;

import com.googlecode.lanterna.gui2.Direction;
import com.googlecode.lanterna.gui2.LinearLayout;
import com.googlecode.lanterna.gui2.Panel;
import lombok.Getter;

@Getter
public class HandView {
    private final Panel mainPanel;

    public HandView() {
        this.mainPanel = new Panel(new LinearLayout(Direction.HORIZONTAL));
    }

    public void addCard(CardView cardView) {
        mainPanel.addComponent(cardView.getMainPanel());
    }
}
