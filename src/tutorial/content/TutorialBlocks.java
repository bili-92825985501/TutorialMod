package main.tutorial.content;


import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.blocks.defense.ForceProjector;
import mindustry.world.blocks.production.Drill;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.production.Separator;
import mindustry.world.blocks.production.SolidPump;

import static mindustry.type.ItemStack.with;

public class TutorialBlocks {
    public static GenericCrafter tutorial_crafter;
    public static Separator tutorial_separator;
    public static ForceProjector tutorialProjector;
    public static SolidPump normaldrill;
    public static Drill smalldrill;
    public static void load() {
        tutorial_crafter = new GenericCrafter("tutorial-crafter") {{
            //基础属性
            health = 100;
            size = 2;
            //使用此重载，Anuke会贴心地帮你设置成BuildVisibility.shown
            requirements(Category.crafting, ItemStack.with(Items.copper, 50, Items.lead, 50));
            //消耗
            //consumeItem(Items.copper,1);
            consumeItems(ItemStack.with(Items.copper,1,Items.lead,2));
            //consumeLiquid(Liquids.water,1f);
            consumeLiquids(LiquidStack.with(Liquids.water,1f,Liquids.slag,2f));
            consumePower(1f);

            outputItem = new ItemStack( TutorialItems.sampleItem ,2);
            outputLiquid = new LiquidStack( TutorialLiquids.sampleLiquid, 2f);
            ignoreLiquidFullness=true;
        }};
        tutorial_separator = new Separator("tutorial-separator"){{
           health = 210;
           size =3;
           requirements(Category.crafting,ItemStack.with(Items.silicon,30,Items.metaglass,10,Items.graphite,20));
           consumeLiquid(Liquids.oil,0.5f);
           consumeItem(Items.titanium,1);
           craftTime = 30;
           consumePower(1.5f);
           results = ItemStack.with(Items.plastanium,2,Items.coal,3,Items.scrap,5);

        }};
        tutorialProjector = new ForceProjector("tutorial-projector"){{
            requirements(Category.effect, with(Items.lead, 100, Items.titanium, 75, Items.silicon, 125));
            size = 3;
            sides = 5;
            shieldRotation = 15f;

            phaseRadiusBoost = 10f;
            phaseShieldBoost = 32768f;
            radius = 120f;
            shieldHealth = 64f;

            //consumeCoolant = true;
            cooldownNormal = 1.5f;
            cooldownLiquid = 1.2f;
            cooldownBrokenBase = 35f;

            phaseUseTime = 2f;
            coolantConsumption = 0.5f;
            itemConsumer = consumeItems(ItemStack.with(Items.phaseFabric,1, TutorialItems.sampleItem,1)).boost();
            consumePower(4f);
        }};
        normaldrill = new SolidPump("normal-drill"){{
            requirements(Category.production,with(TutorialItems.sampleItem,10,Items.metaglass,15,Items.graphite,5));
            health = 50;
            size =2;

            pumpAmount =.11f;
            liquidCapacity = 40f;
            //attribute = Attribute.heat;
            result = Liquids.slag;
        }};
        smalldrill = new Drill("small-drill"){{
            requirements(Category.production,ItemStack.with(TutorialItems.sampleItem,10,Items.metaglass,15,Items.graphite,5));
            health = 50;
            size =2;

            tier = 1;
            drillTime = 5;
            consumeLiquid(TutorialLiquids.sampleLiquid, 0.05f).boost();
            liquidBoostIntensity =1.6f;
            consumePower(5f);
        }};
    }
}
