package remotevehicle.grid;

import remotevehicle.exception.GridTypeNotFoundExeption;

/**
 * A factory for creating GridManager objects.
 */
public class GridManagerFactory {

	/**
	 * Gets the grid manager according to gridManagerType.
	 *
	 * @param gridManagerType the grid manager type
	 * @return the grid manager
	 */
	public GridManager getGridManager(String gridManagerType) {

		if (gridManagerType.equals("PLANE_EMPTY_POSITIVE")) {
			return new PositivePlaneEmptyGridManager();
		} else {
			throw new GridTypeNotFoundExeption("Grid type not found :" + gridManagerType);
		}
	}
}
