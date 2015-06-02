package highscores;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * HighScoreManager generates a textfile in which
 * current and former highscores are saved.
 * The textfile gets the highscores, of type Score, from a
 * list cointaining all the previous and current score.
 */
public final class HighscoreManager
{
    private BufferedWriter writer = null;
    private String filePath;
    private final Logger logger;

    public HighscoreManager() {
	filePath = System.getProperty("user.home") + File.separator + "scores.txt";
        logger = Logger.getLogger(HighscoreManager.class.getName());
        logger.info("Construction successful!");

        try
        {
            writer = new BufferedWriter(new FileWriter(filePath, true));
        }
        catch ( IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Closes the scores.txt-file, no further changes can be
     * made until we create a new FileInputStream
    */
    public void cleanUp() throws IOException {
        writer.close();
    }

    /**
     * Loops through all results in scores.txt and returns a list of the
     * type Score, containing all the results saved in the file.
     *
     * @return      list of the type Score
     */
    public List<Score> getScores() {
	List<Score> result = new ArrayList<Score>();
	try {
	    InputStream fis = new FileInputStream(filePath);
	    InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
	    BufferedReader br = new BufferedReader(isr);
	    String line;
            // We tried to move br.readLine outside of the while-argument
            // but that caused the program to "crasch". Therefore line is
            // still assaigned it's value in the while-statement.
	    while ((line = br.readLine()) != null)
	    {
		String[] tokens = line.replaceAll("\\s+", "").split("=");
		String name = tokens[0];
		int score = Integer.valueOf(tokens[1]);
		Score newScore = new Score(name, score);
		result.add(newScore);
	    }

	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	    return result;
	} catch (IOException e) {
	    e.printStackTrace();
	    return result;
	}
        logger.info("Highscore-file successfully loaded!");
        return result;
    }

    /**
     * Adds the given name and time-value to the file scores.txt
     *
     * @param name          currently inputed name of type String
     * @param time          current time, type int, that represents how long the game was running.
     * @throws IOException
     */
    public void addScore(String name, int time) throws IOException {
	String entry = name + " = " + time;
	writer.write(entry);
	writer.newLine();
	writer.flush();
    }
}