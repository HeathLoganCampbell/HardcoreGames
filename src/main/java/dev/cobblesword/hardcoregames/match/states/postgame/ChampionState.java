package dev.cobblesword.hardcoregames.match.states.postgame;

import dev.cobblesword.hardcoregames.match.Match;
import dev.cobblesword.hardcoregames.match.MatchState;
import dev.cobblesword.hardcoregames.match.states.StateBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ChampionState extends StateBase
{
    private int secondsLeft = 0;
    public ChampionState(Match match)
    {
        super(MatchState.CHAMPION, match);
    }

    @Override
    public void onStart()
    {
        this.secondsLeft = 20;
    }

    @Override
    public void onSeconds()
    {
        if(this.secondsLeft == 0)
        {
            this.setState(MatchState.FINISH);
            return;
        }

        Bukkit.broadcastMessage("BLAH BLAH has won!");
        this.secondsLeft--;
    }

    @Override
    public void onFinish()
    {
        // Kick all users
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayer.kickPlayer("GAME OVER BLAH BLAH WON");
        }
    }
}
