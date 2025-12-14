package main.tutorial;

import arc.Core;
import arc.Events;
import arc.util.Log;
import arc.util.Time;
import main.tutorial.content.TutorialBlocks;
import main.tutorial.content.TutorialItems;
import main.tutorial.content.TutorialLiquids;
import mindustry.game.EventType.ClientLoadEvent;
import mindustry.mod.Mod;
import mindustry.ui.dialogs.BaseDialog;


public class TutorialMod extends Mod {

    public TutorialMod() {
        Log.info("Loaded TutorialMod constructor.");

        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("frog");
                dialog.cont.add("图片").row();
                //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
                dialog.cont.image(Core.atlas.find("tutorial-frog")).pad(20f).row();
                dialog.cont.button("看不到", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
    }

    @Override
    public void loadContent() {
        TutorialItems.load();
        TutorialLiquids.load();
        TutorialBlocks.load();
    }
}
