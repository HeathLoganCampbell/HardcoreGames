package dev.cobblesword.hardcoregames.match.states.ingame;

import dev.cobblesword.hardcoregames.match.Match;
import dev.cobblesword.hardcoregames.match.MatchState;
import dev.cobblesword.hardcoregames.match.states.StateBase;
import org.bukkit.Bukkit;

public class GracePeriodState extends StateBase
{
    private int secondsLeft = 0;
    public GracePeriodState(Match match)
    {
        super(MatchState.GRACE_PERIOD, match);
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
            this.setState(MatchState.LIVE);
            return;
        }

        if(secondsLeft % 30 == 0 || secondsLeft <= 10)
        {
            Bukkit.broadcastMessage(secondsLeft + " seconds til grace period ends");
        }
        secondsLeft--;
    }

    @Override
    public void onFinish()
    {

    }
}
