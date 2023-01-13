package objects;

public class SpaceShip {
    private final String id;
    private final String name;
    private final boolean isActiva;
    private String fuelType;
    private final String origin;
    private final String typeShip;
    private final String power;
    private LoadType loadType;
    private boolean useFuel = false;

    public SpaceShip(String id, String name, boolean isActiva, String fuelType, String origin, String typeShip, String power, LoadType loadType) {
        this.id = id;
        this.name = name;
        this.isActiva = isActiva;
        this.fuelType = fuelType;
        this.origin = origin;
        this.typeShip = typeShip;
        this.power = power;
        this.loadType = loadType;
        this.useFuel = true;
    }

    public SpaceShip(String id, String name, boolean isActiva, String origin, String typeShip, String power, LoadType loadType) {
        this.id = id;
        this.name = name;
        this.isActiva = isActiva;
        this.origin = origin;
        this.typeShip = typeShip;
        this.power = power;
        this.loadType = loadType;
    }

    public SpaceShip(String id, String name, boolean isActiva, String origin, String typeShip, String power) {
        this.id = id;
        this.name = name;
        this.isActiva = isActiva;
        this.origin = origin;
        this.typeShip = typeShip;
        this.power = power;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean getActiva() {
        return isActiva;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getOrigin() {
        return origin;
    }

    public String getTypeShip() {
        return typeShip;
    }

    public String getPower() {
        return power;
    }

    public LoadType getLoadType() {
        return loadType;
    }

    public boolean isUseFuel() {
        return useFuel;
    }
}
