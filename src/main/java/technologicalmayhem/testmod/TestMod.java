package technologicalmayhem.testmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import technologicalmayhem.testmod.block.CrateBlock;
import technologicalmayhem.testmod.block.OrientableBlockBlock;
import technologicalmayhem.testmod.item.HeartItem;

public class TestMod implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "testmod";
    public static final String MOD_NAME = "Test Mod";

    //Items
    public static final Item HEART_ITEM = new HeartItem();

    //Blocks
    public static final Block CRATE_BLOCK = new CrateBlock();
    public static final Block ORIENTABLE_BLOCK = new OrientableBlockBlock();

    //Block Items
    public static final BlockItem CRATE_BLOCK_ITEM = new BlockItem(CRATE_BLOCK, new Item.Settings());
    public static final BlockItem ORIENTABLE_BLOCK_ITEM = new BlockItem(ORIENTABLE_BLOCK, new Item.Settings());

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");
        //Items
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "heart"), HEART_ITEM);

        //Blocks
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "crate"), CRATE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "orientableblock"), ORIENTABLE_BLOCK);

        //Block Items
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "crate"), CRATE_BLOCK_ITEM);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "orientableblock"), ORIENTABLE_BLOCK_ITEM);

        FabricItemGroupBuilder.create(new Identifier("testmod", "general"))
                .icon(() -> new ItemStack(HEART_ITEM))
                .appendItems(itemStacks -> {
                    //Items
                    itemStacks.add(new ItemStack(HEART_ITEM));
                    //Block Items
                    itemStacks.add(new ItemStack(CRATE_BLOCK_ITEM));
                    itemStacks.add(new ItemStack(ORIENTABLE_BLOCK_ITEM));
                })
                .build();
    }

    public static void log(Level level, String message) {
        LOGGER.log(level, "[" + MOD_NAME + "] " + message);
    }

}