package net.simplydivine.quickstacker.services;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;

import java.util.ArrayList;
import java.util.List;

public class QuickStackerService {
    public List<BlockEntity> getNearbyChests(Level world, BlockPos pos, int radius) {
        List<BlockEntity> nearbyChests = new ArrayList<>();

        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    BlockPos checkPos = pos.offset(x, y, z);
                    BlockEntity blockEntity = world.getBlockEntity(checkPos);

                    if (blockEntity instanceof ChestBlockEntity) {
                        nearbyChests.add(blockEntity);
                    }
                }
            }
        }

        return nearbyChests;
    }
}
