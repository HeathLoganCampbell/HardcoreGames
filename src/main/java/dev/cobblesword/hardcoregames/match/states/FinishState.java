package dev.cobblesword.hardcoregames.match.states;

import dev.cobblesword.hardcoregames.match.Match;
import dev.cobblesword.hardcoregames.match.MatchState;

public class FinishState extends StateBase
{
    public FinishState(Match match)
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

    }

    @Override
    public void onFinish()
    {

    }
}
