package mapgen;
import java.awt.*;
import java.applet.*;

/**
* BasicTileMapper2.java<p>
* Draws a simple tile based image on the screen
* @author Eric R. Northam (enorth1@gl.umbc.edu)
* @version 1.0 28 March 1999
*/

public class BasicTileMapper2 extends Applet
{
  Image screenImage;  // Image used for double buffering and its respective
  Graphics screenGC;  // graphics context
  static final int SW = 400;
  static final int SH = 400;
  Image tileImage; // Use to store the image for the tiles
  static final int NUMTILES = 6; // The number of tiles
  int tileWidth;
  int tileImageHeight;
  int tileHeight;
  Tile[] tiles; // An array to hold all of the tiles
  static final byte[][] BGMAP = {
      {1,1,1}};
static final int BGW = 20;
  static final int BGH = 16;
  int numXtiles;
  int numYtiles;
  int mapX = 0;
  int mapY = 0;


  /**
  * Loads an image, splits it into tiles, and then displays each of the tiles
  * diagonally.
  * note: Netscape does not properly load the applet if calls to getImage() are
  * in the init() method, so I decided to put them in the start() method
  */
  public void start()
  {
    tileImage = getImage(getDocumentBase(), "tile/grass.png");

    // Wait for the image to load
    MediaTracker tracker = new MediaTracker(this);
    tracker.addImage(tileImage, 0);
    try { tracker.waitForID(0); }
    catch (InterruptedException e) {}

    // Get tile dimensions
    tileImageHeight = tileImage.getHeight(this);
    tileWidth = tileImage.getWidth(this);
    tileHeight = tileImageHeight/NUMTILES;

    // Create an offsreen image for double buffering
    screenImage = createImage(SW, SH);
    screenGC = screenImage.getGraphics();

    // Break image into tiles.
    prepareTiles();

    // Draw the upper left portion of the map
    numXtiles = SW/tileWidth;
    numYtiles = SH/tileHeight;
    drawMap();

  }

  /**
  * Break the tile image into tiles
  */
  public void prepareTiles()
  {
    tiles = new Tile[NUMTILES];

    // Assume the tile images are arranged vertically
    for(int i = 0; i < NUMTILES; i++)
      tiles[i] = new Tile(tileImage, tileWidth, tileHeight, i);
  }

  /**
  * Draw a portion of the map
  */
  public void drawMap()
  {
    int curX = 0;
    int curY = 0;
    for(int i = 0; i <= numYtiles; i++){
      for(int j = 0; j <= numXtiles; j++){
        tiles[BGMAP[i][j]].paint(screenGC, curX, curY);
        curX += tileWidth;
      }
      curY += tileHeight;
      curX = 0;
    }
  }


  public void update(Graphics g)
  {
    paint(g);
  }

  public void paint(Graphics g)
  {
    g.drawImage(screenImage, 0, 0, null);
  }

  public void destroy()
  {
    screenGC.dispose();
  }
}

