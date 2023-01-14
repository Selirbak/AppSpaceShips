package objects;

public class SpaceShip {
    private String id;
    private String name;
    private boolean isActiva;
    private boolean useFuel;
    private String fuelType;
    private String origin;
    private String typeShip;
    private String power;
    private LoadType loadType;


    public SpaceShip() {
    }

    public SpaceShip(String id, String name, boolean isActiva, boolean useFuel, String fuelType, String origin, String typeShip, String power, LoadType loadType) {
        this.id = id;
        this.name = name;
        this.isActiva = isActiva;
        this.fuelType = fuelType;
        this.origin = origin;
        this.typeShip = typeShip;
        this.power = power;
        this.loadType = loadType;
        this.useFuel = useFuel;
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

    public void setLoadType(LoadType loadType) {
        this.loadType = loadType;
    }

    public boolean isUseFuel() {
        return useFuel;
    }
}
