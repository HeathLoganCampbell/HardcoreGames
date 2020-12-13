package dev.cobblesword.hardcoregames.match.states;

import dev.cobblesword.hardcoregames.match.Match;
import dev.cobblesword.hardcoregames.match.MatchState;

public class LiveState extends StateBase
{
    public LiveState(Match match)
    {
        super(MatchState.LIVE, match);
    }

    @Override
    public void onStart()
    {

    }

    @Override
    public void onSeconds()
    {
        if(this.getMatch().getAlivePlayerCount() == 1)
        {
            // Player found!
            // Set winner here
            this.setState(MatchState.CHAMPION);
            return;
        }

        if(this.getMatch().getAlivePlayerCount() == 0)
        {
            this.setState(MatchState.CHAMPION);
            return;
        }
    }

    @Override
    public void onFinish()
    {

    }
}
