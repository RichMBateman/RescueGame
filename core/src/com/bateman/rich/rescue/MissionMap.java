package com.bateman.rich.rescue;

/**
 * Represents the space that a mission can take place in.
 */
public class MissionMap {
    /**
     * 2d array of cells.  You specify a position by row number (Y axis) and then column number (X axis)
     */
    private MissionCell[][] m_missionCells;
    private final int m_numCols;
    private final int m_numRows;

    private final int MAP_WIDTH_IN_WORLD;
    private final int MAP_HEIGHT_IN_WORLD;

    public MissionMap(int width, int height) {
        m_missionCells=new MissionCell[height][width];
        m_numCols =width;
        m_numRows=height;
        MAP_WIDTH_IN_WORLD=m_numRows*MissionCell.CELL_SIZE_IN_WORLD;
        MAP_HEIGHT_IN_WORLD=m_numCols*MissionCell.CELL_SIZE_IN_WORLD;

        initializeCells();
    }

    private void initializeCells() {
        for(int row = 0; row < m_numRows; row++) {
            for(int col = 0; col < m_numCols; col++) {
                m_missionCells[row][col] = new MissionCell(row, col);
            }
        }
    }
}
