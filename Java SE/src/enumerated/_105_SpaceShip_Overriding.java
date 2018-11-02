package enumerated;

public enum _105_SpaceShip_Overriding {
    
    SCOUT, CARGO, TRANSPORT, CRUISER, BATTLESHIP, MOTHERSHIP;
    
    @Override
    public String toString() {
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower;
    }

    public static void main(String[] args) {
        for (_105_SpaceShip_Overriding s : values()) {
            System.out.println(s);
        }
    }
}