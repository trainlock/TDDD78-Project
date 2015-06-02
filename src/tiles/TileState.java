package tiles;

/**
 * Contains the STATEs that the tiles can have.
 */
public enum TileState
{
    /** Represents when the darkgray side should be visible */
    TURNED_DOWN,

    /** Represents when the image should be displayed */
    TURNED_UP,

    /** Represents when the darkgray side should be visible
     *  and that the tile shouldn't be altered anymore. */
    IS_SAME_TILE,
}
