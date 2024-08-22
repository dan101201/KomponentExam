package dk.sdu.student.daref21.common.services;

import dk.sdu.student.daref21.common.data.GameData;
import dk.sdu.student.daref21.common.data.World;

public interface IGamePluginService {
    void start(GameData gameData, World world);

    void stop(GameData gameData, World world);
}
