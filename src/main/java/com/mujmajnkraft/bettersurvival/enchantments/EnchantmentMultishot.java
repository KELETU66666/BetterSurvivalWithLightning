package com.mujmajnkraft.bettersurvival.enchantments;

import com.mujmajnkraft.bettersurvival.Reference;
import com.mujmajnkraft.bettersurvival.config.ConfigHandler;
import com.mujmajnkraft.bettersurvival.init.ModEnchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;

public class EnchantmentMultishot extends Enchantment {
	
	public EnchantmentMultishot() {
		super(Rarity.UNCOMMON, EnumEnchantmentType.BOW, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
		this.setRegistryName("multishot");
		this.setName(Reference.MOD_ID + ".multishot");
	}
	
	public int getMinEnchantability(int enchantmentLevel)
    {
        return 10 + 20*(enchantmentLevel-1);
    }

    /**
     * Returns the maximum value of enchantability nedded on the enchantment level passed.
     */
    public int getMaxEnchantability(int enchantmentLevel)
    {
        return 50;
    }

    /**
     * Returns the maximum level that the enchantment can have.
     */
    public int getMaxLevel()
    {
        return ConfigHandler.multishotlevel;
    }
    
    public boolean canApplyTogether(Enchantment ench)
    {
        return super.canApplyTogether(ench) && ench != ModEnchantments.blast;
    }
    
    public boolean isTreasureEnchantment()
    {
    	return ConfigHandler.multishot;
    }
	
	public boolean isAllowedOnBooks()
    {
		return ConfigHandler.multishotlevel != 0;
    }
}
