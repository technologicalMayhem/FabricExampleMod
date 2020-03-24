package technologicalmayhem.testmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import technologicalmayhem.testmod.item.FirstItem;

public class TestMod implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "testmod";
    public static final String MOD_NAME = "Test Mod";

//    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(
//            new Identifier("testmod", "general"))
//            .icon(() -> new ItemStack(Blocks.COBBLESTONE))
//            .build();

    public static final Item FIRST_ITEM = new FirstItem(new Item.Settings().maxCount(8));

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "first_item"), FIRST_ITEM);

        FabricItemGroupBuilder.create(new Identifier("testmod", "general"))
                .icon(() -> new ItemStack(FIRST_ITEM))
                .appendItems(itemStacks -> {
                    itemStacks.add(new ItemStack(FIRST_ITEM));
                })
                .build();
    }

    public static void log(Level level, String message) {
        LOGGER.log(level, "[" + MOD_NAME + "] " + message);
    }

}