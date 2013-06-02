package mapgen;

public class TileCheck extends TileMapper {
	int tileWidth = BGMAPTILEWIDTH;
	int tileHeight = BGMAPTILEHEIGHT;
	int xCenterTile = tileWidth / 2;
	int yCenterTile = tileHeight / 2;
	private int a, b, c, d, e, f, g, h, pos;

	private void caculateTilesAround() {

		a = (xCenterTile + tileWidth) + (yCenterTile + tileHeight);
		b = (yCenterTile + tileHeight);
		c = (xCenterTile - tileWidth) + (yCenterTile + tileHeight);
		d = (xCenterTile - tileWidth);
		e = (xCenterTile + tileWidth) + (yCenterTile - tileHeight);
		f = (yCenterTile - tileHeight);
		g = (xCenterTile + tileWidth) + (yCenterTile + tileHeight);
		h = (xCenterTile + tileWidth);
	}

	/**
	 * places the check in the tiles surrounding the tile in question moves to
	 * the centre of the tile each time.
	 * 
	 * @param canAccessTile
	 *            boolean; if you can Access the tile, can be done manually or
	 *            automatically
	 * @return pos. Int values placing the imaginary cursor in the 8 surrounding
	 *         tiles. 0 when finished or unable to check.
	 */
	public int checkTile(Boolean canAccessTile) {
		if (canAccessTile) {
			int pos;
			for (int i = 1; i > 8; i++) {
				switch (i) {
				case 1:
					pos = a;
					return pos;

				case 2:
					pos = b;
					return pos;

				case 3:
					pos = c;
					return pos;

				case 4:
					pos = d;
					return pos;

				case 5:
					pos = e;
					return pos;

				case 6:
					pos = f;
					return pos;

				case 7:
					pos = g;
					return pos;

				case 8:
					pos = h;
					return pos;
				default:
					System.out
							.println("Unable to check tiles, i is more then 8. Error.");
					pos = 0;
					return pos;
				}

			}
		}
		return 0;
	}
}
