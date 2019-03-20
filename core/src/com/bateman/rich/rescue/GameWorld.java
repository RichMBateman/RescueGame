package com.bateman.rich.rescue;

/**
 * Highest level object containing everything related to the game world.
 */
public class GameWorld {
    private MissionMap m_map;

    public void initialize() {
        m_map = new MissionMap(4, 4);
    }
}
