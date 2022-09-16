package de.tum.in.ase.eist.gameboardui.rendering;

import java.awt.*;

public enum Fonts {

    IMPACT_15(new Font("Impact", Font.PLAIN, 15)),
    IMPACT_30(new Font("Impact", Font.PLAIN, 30)),
    IMPACT_60(new Font("Impact", Font.PLAIN, 60)),
    IMPACT_100(new Font("Impact", Font.PLAIN, 100)),
    IMPACT_8(new Font("Impact", Font.PLAIN, 8));
    private final Font font;

    Fonts(Font font) {
        this.font = font;
    }


    Font font() {
        return font;
    }
}
