package com.dragn0007.chocobos.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ChocoboNest extends Block {
    protected static final VoxelShape AABB = Shapes.or(Block.box(1, 0, 1, 15, 5, 15));

    public ChocoboNest() {
        super (Properties.copy(Blocks.HAY_BLOCK).strength(0.2f, 0.2f).noOcclusion());
    }

    public VoxelShape getShape(BlockState p_153474_, BlockGetter p_153475_, BlockPos p_153476_, CollisionContext p_153477_) {
        return AABB;
    }
}
