package dk.sdu.student.daref21.common.services;

import dk.sdu.student.daref21.common.data.GameData;
import dk.sdu.student.daref21.common.data.World;

public interface IPreEntityProcessingService {

    void process(GameData gameData, World world);
}