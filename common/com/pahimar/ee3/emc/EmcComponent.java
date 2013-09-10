package com.pahimar.ee3.emc;

public class EmcComponent implements Comparable<EmcComponent> {

    // Unit components for the various EmcTypes
    public static final EmcComponent OMNI_UNIT_COMPONENT = new EmcComponent(EmcType.OMNI);
    public static final EmcComponent CORPOREAL_UNIT_COMPONENT = new EmcComponent(EmcType.CORPOREAL);
    public static final EmcComponent KINETIC_UNIT_COMPONENT = new EmcComponent(EmcType.KINETIC);
    public static final EmcComponent TEMPORAL_UNIT_COMPONENT = new EmcComponent(EmcType.TEMPORAL);
    public static final EmcComponent ESSENTIA_UNIT_COMPONENT = new EmcComponent(EmcType.ESSENTIA);
    public static final EmcComponent AMORPHOUS_UNIT_COMPONENT = new EmcComponent(EmcType.AMORPHOUS);
    public static final EmcComponent VOID_UNIT_COMPONENT = new EmcComponent(EmcType.VOID);
    
    private final EmcType type;
    private final int ratioWeight;

    public EmcComponent(EmcType type, int ratioWeight) {

        this.type = type;
        this.ratioWeight = ratioWeight;
    }
    
    public EmcComponent(EmcType type) {
        
        this(type, 1);
    }

    public EmcType getType() {

        return type;
    }

    public int getRatioWeight() {

        return ratioWeight;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof EmcComponent)) {
            return false;
        }

        EmcComponent emcComponent = (EmcComponent) object;

        return ((this.type == emcComponent.type) && (this.ratioWeight == emcComponent.ratioWeight));
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("<EMC Type: %s, Ratio Weight: %s>", type, ratioWeight));

        return stringBuilder.toString();
    }

    @Override
    public int compareTo(EmcComponent emcComponent) {

        if (emcComponent != null) {
            if (this.type == emcComponent.type) {
                return (this.ratioWeight - emcComponent.ratioWeight);
            }
            else {
                return this.type.compareTo(emcComponent.type);
            }
        }
        else {
            return 1;
        }
    }
}
