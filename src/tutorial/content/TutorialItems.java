package main.tutorial.content;

import arc.graphics.Color;
import mindustry.type.Item;

public class TutorialItems {
    public static Item sampleItem;

    public static void load(){
         sampleItem = new Item("test-item", Color.valueOf("ff0000")){{
            cost =2.5f;
            explosiveness = 0.01f;
            flammability = 500f;
            hardness = 5;
            radioactivity =500f;
            charge = 655.36f;
        }};
    }
}
