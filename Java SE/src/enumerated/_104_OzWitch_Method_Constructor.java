package enumerated;

import static utils.Print.*;

public enum _104_OzWitch_Method_Constructor {
    // Instances must be defined first, before methods:
    WEST("Miss Gulch, aka the Wicked Witch of the West"), NORTH("Glinda, the Good Witch of the North"), EAST("Wicked Witch of the East, wearer of the Ruby " + "Slippers, crushed by Dorothy's house"), SOUTH("Good by inference, but missing");
    private String description;

    // Constructor must be package or private access:
    // Constructor can only be used to create the enum instances that you declare inside the enum definition
    private _104_OzWitch_Method_Constructor(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for (_104_OzWitch_Method_Constructor witch : _104_OzWitch_Method_Constructor.values()) {
            print(witch + ": " + witch.getDescription());
        }
    }
}