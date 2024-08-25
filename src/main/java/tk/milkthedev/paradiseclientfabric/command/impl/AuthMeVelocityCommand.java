package tk.milkthedev.paradiseclientfabric.command.impl;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.packet.c2s.common.CustomPayloadC2SPacket;
import tk.milkthedev.paradiseclientfabric.command.Command;
import tk.milkthedev.paradiseclientfabric.packet.AuthMeVelocityPayloadPacket;

public class AuthMeVelocityCommand extends Command {
    public AuthMeVelocityCommand() {
        super("paradiseauthmebypass", "Bypasses AuthMe if the server is using AuthMeVelocity");
    }

    @Override
    public LiteralArgumentBuilder<FabricClientCommandSource> build() {
        return literal(getName())
                .executes(context -> {
                    MinecraftClient.getInstance().getNetworkHandler().sendPacket(new CustomPayloadC2SPacket(new AuthMeVelocityPayloadPacket()));
                    return SINGLE_SUCCESS;
                });
    }
}
