package com.company;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public interface Command {

    // has the command been called?
    public boolean called(String[] args, MessageReceivedEvent event);

    // performs the action that the command is supposed to perform
    public void action(String[] args, MessageReceivedEvent event);

    // returns the command's HELP String
    public String help();

    public void executed(boolean success, MessageReceivedEvent event);
}
