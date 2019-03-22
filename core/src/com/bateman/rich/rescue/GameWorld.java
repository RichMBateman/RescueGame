package com.bateman.rich.rescue;

import java.util.ArrayList;

/**
 * Highest level object containing everything related to the game world.
 */
public class GameWorld {
    private MissionMap m_map;
    private ArrayList<Agent> m_agents;
    public Agent ActiveAgent;
    public final int NUM_AGENTS = 3;

    public void initialize() {
        m_map = new MissionMap(4, 4);
        m_agents = new ArrayList<Agent>();
        MissionCell startCell = m_map.getCell(0, 0);
        for(int i = 0; i < NUM_AGENTS; i++) {
            Agent a = new Agent();
            a.setCurrentCell(startCell);
            m_agents.add(a);
        }
        ActiveAgent = m_agents.get(0);
    }
    public MissionMap getMissionMap() {
        return m_map;
    }
    public Agent getAgent(int index) {
        return m_agents.get(index);
    }
}
