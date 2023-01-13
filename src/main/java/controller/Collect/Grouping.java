package controller.Collect;

import objects.SpaceShip;

import java.util.List;
import java.util.Map;

interface Grouping {
    Map<String, List<SpaceShip>> toTypeShip();

    Map<String, List<SpaceShip>> toOrigin();

    Map<String, List<SpaceShip>> toFueld();

    Map<Boolean, List<SpaceShip>> toIsActive();
    Map<Boolean, List<SpaceShip>> toUsedFuel();

}
