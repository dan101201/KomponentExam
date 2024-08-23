import dk.sdu.student.daref21.common.services.IEntityProcessingService;
import dk.sdu.student.daref21.common.services.IGamePluginService;
import dk.sdu.student.daref21.common.services.IPostEntityProcessingService;
import dk.sdu.student.daref21.common.services.IPreEntityProcessingService;

module Core {
    requires java.desktop;
    requires spring.context;
    requires Player;
    requires EnemyDefault;
    requires Common;
    requires com.badlogic.gdx;

    uses IGamePluginService;
    uses IEntityProcessingService;
    uses IPostEntityProcessingService;
    uses IPreEntityProcessingService;

    exports dk.sdu.student.daref21.main;
    exports dk.sdu.student.daref21.util;
}