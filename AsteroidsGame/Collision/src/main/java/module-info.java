import dk.sdu.student.daref21.common.services.IPostEntityProcessingService;
import dk.sdu.student.daref21.collision.CollisionDetector;

module Collision {
    requires Common;
    provides IPostEntityProcessingService with CollisionDetector;
}