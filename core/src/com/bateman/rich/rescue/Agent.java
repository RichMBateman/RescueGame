package com.bateman.rich.rescue;

public class Agent {
    private MissionCell m_currentCell;

    public MissionCell getCurrentCell() {
        return m_currentCell;
    }

    public void setCurrentCell(MissionCell currentCell) {
        m_currentCell = currentCell;
    }
}
