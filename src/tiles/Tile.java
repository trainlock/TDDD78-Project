package tiles;

import java.awt.Color;

/**
 * The class represents an object of type Tile.
 * A Tile consists of a TileType, a Color,
 * a TileState and a size. The constructor takes as
 * parameters a type, a color and a state and
 * generates an object from those.
 */
public class Tile
{
    private final static int TILE_SIZE = 100;
    private TileTypes tileType;
    private TileState state;
    private Color backsideColour;

    public Tile(TileTypes tileType, Color backsideColour, TileState state) {
        this.tileType = tileType;
        this.backsideColour = backsideColour;
        this.state = state;
    }

    // The method name and the name of the variable doesn't match.
    // We prefer it as it is now since it's easier to see what
    // is what with the names that's currently used.
    public final static int getTileSize() {
        return TILE_SIZE;
    }

    public TileState getState() {
        return state;
    }

    public void setState(TileState state) {
        this.state = state;
    }

    public TileTypes getTileType() {
        return tileType;
    }

    public Color getBacksideColour() {
        return backsideColour;
    }

    /**
     * Checks whether this class is equal to another
     *
     * @param other     The other class which is compare to this class
     * @return          True if the classes are equal, else returns false
     */
    @Override
    public boolean equals(Object other) {
        if (other == null || other.getClass() != this.getClass()) return false;

        Tile that = (Tile) other;

        return this.tileType == that.tileType &&
               this.backsideColour.equals(that.backsideColour);
    }
}
