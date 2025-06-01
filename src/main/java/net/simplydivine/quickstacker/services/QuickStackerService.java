package net.simplydivine.quickstacker.services;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Container;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;

import java.util.ArrayList;
import java.util.List;

public class QuickStackerService {
    public  List<Container> GetNearbyContainers(Level world, BlockPos pos, int radius, boolean includeEmpty) {
        List<Container> nearbyContainers = new ArrayList<>();

        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    BlockPos checkPos = pos.offset(x, y, z);
                    BlockEntity blockEntity = world.getBlockEntity(checkPos);

                    if (blockEntity instanceof Container container) {
                        if (container.isEmpty() == includeEmpty) {
                            nearbyContainers.add(container);
                        }
                    }
                }
            }
        }

        return nearbyContainers;
    }

    public void FindMatchingItems(LocalPlayer player, List<ChestBlockEntity> chests) {
        var inventory = player.getInventory();
        for (var chest : chests) {
            if (chest.isEmpty()) {
                continue;
            }
            for (int i = 0; i < inventory.getContainerSize(); i++) {
                var j = 1;
            }
        }
    }

    public void MoveItems(LocalPlayer player, ChestBlockEntity chest) {

    }
}
