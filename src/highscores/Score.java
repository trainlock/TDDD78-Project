package highscores;

/**
 * Takes as parameters a String and int.
 * Converts them into a string on the format
 * "String: int"
 */
public class Score
{
    private String name;
    private int timeScore;
    private static final int SEC_IN_MIN = 60;

    public Score(String name, int timeScore) {
        this.name = name;
        this.timeScore = timeScore;
    }

    @Override public String toString()
    {
	int minutes = timeScore / SEC_IN_MIN;
	int seconds = timeScore - (minutes * SEC_IN_MIN);
	return name + ": " + String.format("%02d:%02d", minutes, seconds);
    }
}

