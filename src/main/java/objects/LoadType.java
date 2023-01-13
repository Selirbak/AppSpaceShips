package objects;

public class LoadType {
    private boolean isPeople;
    private boolean isSupplies;
    private boolean isEquipment;

    public LoadType(boolean isPeople, boolean isSupplies, boolean isEquipment) {
        this.isPeople = isPeople;
        this.isSupplies = isSupplies;
        this.isEquipment = isEquipment;
    }

    public boolean isPeople() {
        return isPeople;
    }

    public boolean isSupplies() {
        return isSupplies;
    }

    public boolean isEquipment() {
        return isEquipment;
    }
}
