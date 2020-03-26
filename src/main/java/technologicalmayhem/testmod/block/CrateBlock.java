package technologicalmayhem.testmod.block;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class CrateBlock extends Block {

    public CrateBlock() {
        super(FabricBlockSettings
                .of(Material.WOOD)
                .sounds(BlockSoundGroup.WOOD)
                .build()
        );
    }
}
