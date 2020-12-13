package dev.cobblesword.hardcoregames.match.states;

import dev.cobblesword.hardcoregames.match.Match;
import dev.cobblesword.hardcoregames.match.MatchState;

public class GenerateState extends StateBase
{
    public GenerateState(Match match)
    {
        super(MatchState.GRACE_PERIOD, match);
    }

    @Override
    public void onStart()
    {

    }

    @Override
    public void onSeconds()
    {
        // Wait for all chunks to load
        this.setState(MatchState.WAITING_FOR_PLAYERS);
    }

    @Override
    public void onFinish()
    {

    }
}
