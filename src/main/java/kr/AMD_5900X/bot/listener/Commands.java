package kr.AMD_5900X.bot.listener;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import static kr.AMD_5900X.bot.JDAWithSpigotBot.*;

@SuppressWarnings("all")
public class Commands extends ListenerAdapter {

    /* [ <-- Simple Command --> ] */
    public void onMessageReceived(MessageReceivedEvent e) {
        if (!e.getMessage().getContentRaw().startsWith(BotCommandPrefix)) {
            return;
        }
        if (e.getAuthor().isBot()) {
            return;
        }

        if (!e.isFromGuild()) {
            e.getMessage().reply("You can't use this command in DMs!").queue();
            return;
        }

        User user = e.getAuthor();
        TextChannel tc = e.getChannel().asTextChannel();
        Message msg = e.getMessage();
        String[] args = msg.getContentDisplay().split(" ");

        if (args[0].equalsIgnoreCase(BotCommandPrefix + "hello")) {
            msg.reply("Hello, " + user.getAsMention() + "!").queue();
        }
    }
}
