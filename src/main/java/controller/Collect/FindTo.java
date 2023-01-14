package controller.Collect;

import controller.database.ConnectionDB;
import objects.LoadType;
import objects.SpaceShip;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindTo extends ConnectionDB implements Grouping {
    @Override
    public Map<String, List<SpaceShip>> toTypeShip() {
        return shipList
                .stream()
                .collect(Collectors.groupingBy(SpaceShip::getTypeShip));
    }

    public Map<String, List<SpaceShip>> toTypeShip(List<SpaceShip> shipList) {
        return shipList
                .stream()
                .collect(Collectors.groupingBy(SpaceShip::getTypeShip));
    }

    @Override
    public Map<String, List<SpaceShip>> toOrigin() {
        return shipList
                .stream()
                .filter(spaceShip -> spaceShip.getOrigin() != null)
                .collect(Collectors.groupingBy(SpaceShip::getOrigin));
    }

    @Override
    public Map<String, List<SpaceShip>> toFueld() {
        return shipList
                .stream()
                .filter(spaceShip -> spaceShip.getFuelType() != null)
                .collect(Collectors.groupingBy(SpaceShip::getFuelType));
    }

    @Override
    public Map<Boolean, List<SpaceShip>> toIsActive() {
        return shipList
                .stream()
                .collect(Collectors.groupingBy(SpaceShip::getActiva));
    }

    @Override
    public Map<Boolean, List<SpaceShip>> toUsedFuel() {
        return shipList
                .stream()
                .collect(Collectors.groupingBy(SpaceShip::isUseFuel));
    }


}
