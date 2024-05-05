package com.pinktarr.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractBlock.Settings;

@Mixin(AbstractBlock.Settings.class)
public class BlockSettingsPatch {
	@Overwrite
	public Settings solid() {
        return ((Settings)(Object)this).liquid();
    }
}
