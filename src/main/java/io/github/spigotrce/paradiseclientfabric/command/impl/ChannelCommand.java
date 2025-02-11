package io.github.spigotrce.paradiseclientfabric.command.impl;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import io.github.spigotrce.paradiseclientfabric.command.Command;
import io.github.spigotrce.paradiseclientfabric.listener.ChannelListener;
import io.github.spigotrce.paradiseclientfabric.Helper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.command.CommandSource;

/**
 * Command to display and manage detected channels.
 */
public class ChannelCommand extends Command {

    public ChannelCommand(MinecraftClient minecraftClient) {
        super("channels", "Displays and manages detected channels", minecraftClient);
    }

    @Override
    public LiteralArgumentBuilder<CommandSource> build() {
        return LiteralArgumentBuilder.<CommandSource>literal(getName())
                .executes(context -> {
                    // Display the list of detected channels
                    if (ChannelListener.getDetectedChannels().isEmpty()) {
                        Helper.printChatMessage("&cNo channels detected at the moment.");
                    } else {
                        Helper.printChatMessage("&bList of detected channels:");
                        for (String channel : ChannelListener.getDetectedChannels()) {
                            Helper.printChatMessage("&f- &d" + channel);
                        }
                    }
                    return SINGLE_SUCCESS;
                });
    }
}
