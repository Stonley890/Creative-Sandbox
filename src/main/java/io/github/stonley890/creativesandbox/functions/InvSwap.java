package io.github.stonley890.creativesandbox.functions;

import io.github.stonley890.creativesandbox.data.PlayerMemory;
import io.github.stonley890.creativesandbox.data.PlayerUtility;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class InvSwap {

    public static void swapInventories(@NotNull Player player) {

        PlayerMemory memory = PlayerUtility.getPlayerMemory(player.getUniqueId());

        ItemStack[] invContents;

        if (memory.creative) {
            memory.creativeInv = player.getInventory().getContents();
            if (memory.survivalInv == null) invContents = null;
            else invContents = memory.survivalInv;
        } else {
            memory.survivalInv = player.getInventory().getContents();
            if (memory.creativeInv == null) invContents = null;
            else invContents = memory.creativeInv;
        }

        if (invContents == null) player.getInventory().clear();
        else player.getInventory().setContents(invContents);
        memory.creative = !memory.creative;

        PlayerUtility.setPlayerMemory(player.getUniqueId(), memory);

    }

}