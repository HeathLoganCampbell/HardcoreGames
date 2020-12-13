package dev.cobblesword.hardcoregames.match.states.pregame;

import dev.cobblesword.hardcoregames.match.Match;
import dev.cobblesword.hardcoregames.match.MatchState;
import dev.cobblesword.hardcoregames.match.states.StateBase;
import org.bukkit.Bukkit;

public class CountdownState extends StateBase
{
    private int secondsLeft = 0;

    public CountdownState(Match match)
    {
        super(MatchState.COUNTDOWN, match);
    }

    @Override
    public void onStart()
    {
        this.secondsLeft = 120;
    }

    @Override
    public void onSeconds()
    {
        if (this.secondsLeft == 0)
        {
            this.setState(MatchState.SPAWN);
            return;
        }

        if (this.getMatch().getPlayerCount() <= this.getOptions().minPlayers)
        {
            this.setState(MatchState.WAITING_FOR_PLAYERS);
            return;
        }

        if(secondsLeft % 30 == 0 || secondsLeft <= 10)
        {
            Bukkit.broadcastMessage(secondsLeft + " seconds til start");
        }

        this.secondsLeft--;
    }

    @Override
    public void onFinish()
    {
        Bukkit.broadcastMessage("Game starting!");
    }
}
