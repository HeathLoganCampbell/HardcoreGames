package dev.cobblesword.hardcoregames.match.states;

import dev.cobblesword.hardcoregames.match.Match;
import dev.cobblesword.hardcoregames.match.MatchState;

public class WaitingForPlayersState extends StateBase
{
    public WaitingForPlayersState(Match match)
    {
        super(MatchState.WAITING_FOR_PLAYERS, match);
    }

    @Override
    public void onStart()
    {

    }

    @Override
    public void onSeconds()
    {
        if (this.getMatch().getPlayerCount() > 12)
        {
            this.setState(MatchState.COUNTDOWN);
        }
    }

    @Override
    public void onFinish()
    {

    }
}
