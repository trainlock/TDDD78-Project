package highscores;

import javax.swing.*;
import java.awt.*;

/**
 * Generates a JPanel that contains the JTextArea
 * where the highscores are written.
 */
public class HighscorePanel extends JPanel
{
    /** Text area where the highscore will be written */
    private JTextArea textArea;
    /** Height of textArea */
    public static final int TEXT_AREA_HEIGHT = 100;
    /** Width of textArea */
    public static final int TEXT_AREA_WIDTH = 100;
    /** Size of the font use to write the highscore with */
    public static final int FONT_SIZE = 20;

    public HighscorePanel() {
	this.textArea = new JTextArea(" Highscore "+ "\n");
	textArea.setSize(new Dimension(TEXT_AREA_WIDTH, TEXT_AREA_HEIGHT));
	textArea.setFont(new Font("MONOSPACE", Font.PLAIN, FONT_SIZE));
	textArea.setEnabled(false);
	textArea.setVisible(true);

	this.add(textArea);
    }

    public void setWinnerInfo(String name, int timeValue) {
	textArea.setText(name + " : " + timeValue);
    }

    public JTextArea getTextArea() {
        return textArea;
    }
}

