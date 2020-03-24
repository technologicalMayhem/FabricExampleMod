package technologicalmayhem.testmod.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.apache.logging.log4j.Level;
import technologicalmayhem.testmod.TestMod;

import java.util.List;

public class FirstItem extends Item {

    public FirstItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user.hasStatusEffect(StatusEffects.REGENERATION) || user.getHealth() == user.getMaximumHealth() ) {
            return new TypedActionResult<>(ActionResult.FAIL, user.getStackInHand(hand));
        }
        user.playSound(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 500));
        user.getStackInHand(hand).decrement(1);
        return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand));
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.testmod.first_item.tooltip1").formatted(Formatting.DARK_GRAY));
        tooltip.add(new TranslatableText("item.testmod.first_item.tooltip2").formatted(Formatting.DARK_GRAY));
    }
}
