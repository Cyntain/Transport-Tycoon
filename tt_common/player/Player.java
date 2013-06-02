package player;

import java.applet.Applet;

import lib.Direction;
import lib.ScreenUtils;
import mapgen.BasicTileMapper;
/** 
 * player utils, checks and sets.
 * @author Cyntain
 * */
public class Player {
	private int left = 0;
	private int right = 0;
	private int forward = 0;
	private int backwards = 0;
	private String userName;

	/**
	 * Check if the player is on the screen
	 * 
	 * @param x
	 *            pos of player on the x
	 * @param y
	 *            pos of the player on the y
	 * @return true if on the screen false if not
	 */

	public boolean isPlayerOnScreen(int x, int y) {
		if (x < ScreenUtils.SCREEN_WIDTH && y < ScreenUtils.SCREEN_HEIGHT)
			return false;
		{
			if (x < ScreenUtils.SCREEN_WIDTH && y >= ScreenUtils.SCREEN_HEIGHT)
				return false;
		}
		if (x >= ScreenUtils.SCREEN_WIDTH && y < ScreenUtils.SCREEN_HEIGHT) {
			return false;
		}
		return true;
	}

	private int setDirection() {

		if (forward >= 0) {
			forward = 0;
			return forward;
		} else if (right >= 0) {
			right = 0;
			return right;
		} else if (backwards >= 0) {
			backwards = 0;
			return backwards;
		} else if (left >= 0) {
			left = 0;
			return left;
		} else {
			return 0;
		}

	}

	private boolean checkIsMoving() {
		if (forward == 1 || backwards == 1 || left == 1 || right == 1) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if the player is moving
	 * 
	 * @return false if is not moving. true if moving.
	 * */
	public boolean isMoving() {
		if (checkIsMoving() == true) {
			return true;
		}
		return false;
	}

	/** gets the players username */
	public String getUsername() {
		return userName;
	}

	/**
	 * Sets the players username
	 * 
	 * @param user
	 *            input for the username
	 */
	public String setUsername(String user) {
		userName = user;
		return userName;
	}

}
