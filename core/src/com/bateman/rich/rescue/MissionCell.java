package com.bateman.rich.rescue;

import com.badlogic.gdx.math.Rectangle;

/**
 * A particular cell within a MissionMap.
 */
public class MissionCell {
    public static final int CELL_SIZE_IN_WORLD=50;

    private Rectangle m_rect;
    private final int m_rowNum;
    private final int m_colNum;

    public MissionCell(int rowNum, int colNum) {
        m_rowNum=rowNum;
        m_colNum=colNum;

        m_rect=new Rectangle();
        m_rect.x = colNum * CELL_SIZE_IN_WORLD;
        m_rect.y = rowNum * CELL_SIZE_IN_WORLD;
        m_rect.width = CELL_SIZE_IN_WORLD;
        m_rect.height = CELL_SIZE_IN_WORLD;
    }

    public int getRowNum() {
        return m_rowNum;
    }

    public int getColNum() {
        return m_colNum;
    }
}
