package com.company;

import com.company.commands.PingCommand;
import net.dv8tion.jda.core.*;
import com.company.utils.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import java.util.*;

public class Main {

    private static JDA jda;

    public static final CommandParser parser = new CommandParser();

    public static HashMap<String, Command> commands = new HashMap<String, Command>();

    public static void main(String[] args) {
	    try {
            jda = new JDABuilder(AccountType.BOT).addEventListener(new BotListener())
                    .setToken(Secret.DISCORD_TOKEN).buildBlocking();
            jda.setAutoReconnect(true);
        } catch(Exception e) {
            e.printStackTrace();
        }

        commands.put("ping", new PingCommand());
    }

    public static void handleCommand(CommandParser.CommandContainer cmd) {
        if (commands.containsKey(cmd.invoke)) {
            boolean safe = commands.get(cmd.invoke).called(cmd.args, cmd.event);

            if(safe) {
                commands.get(cmd.invoke).action(cmd.args, cmd.event);
                commands.get(cmd.invoke).executed(safe, cmd.event);
            } else {
                commands.get(cmd.invoke).executed(safe, cmd.event);
            }
        }
    }
}
