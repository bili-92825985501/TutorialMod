package main.tutorial.content;

import arc.graphics.Color;
import mindustry.type.Liquid;

public class TutorialLiquids {
    public static Liquid sampleLiquid;
    public static Liquid phaseLiquid;
    public static void load() {
        sampleLiquid = new Liquid("tutorial-liquid", Color.valueOf("00ffcc")) {{
            gas = false;
            lightColor = Color.valueOf("00ffcc");
            flammability = 0;
            temperature = -128;
            heatCapacity = 10;
            viscosity = -1;
            coolant = true;
            moveThroughBlocks = true;
            capPuddles = false;
        }};
        phaseLiquid = new Liquid("phase-liquid",Color.valueOf("66009d")){{
           gas = false;
           flammability =0;
           temperature = .3f;
           heatCapacity = .5f;
           viscosity = 0.99f;
           coolant = false;
           capPuddles = true;
        }};
    }
}
