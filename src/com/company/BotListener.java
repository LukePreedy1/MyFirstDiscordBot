package com.company;

import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class BotListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getMessage().getContent().startsWith("~!")
                && !event.getMessage().getAuthor().getId()
                .equals(event.getJDA().getSelfUser().getId())) {
            Main.handleCommand(Main.parser.parse(event.getMessage().getContent().toLowerCase(), event));
        }
    }

    @Override
    public void onReady(ReadyEvent event) {
        //Main.log("status", "Logged in as: " + event.getJDA().getSelfUser().getName());
    }
}
