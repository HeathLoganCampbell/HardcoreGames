package dev.cobblesword.hardcoregames.match.states;

import dev.cobblesword.hardcoregames.match.Match;
import dev.cobblesword.hardcoregames.match.MatchState;

public class SpawnState extends StateBase
{
    public SpawnState(Match match)
    {
        super(MatchState.SPAWN, match);
    }

    @Override
    public void onStart()
    {
        // Teleport all players

        this.setState(MatchState.GRACE_PERIOD);
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
