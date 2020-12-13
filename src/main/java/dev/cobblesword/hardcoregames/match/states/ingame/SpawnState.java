package dev.cobblesword.hardcoregames.match.states.ingame;

import dev.cobblesword.hardcoregames.match.Match;
import dev.cobblesword.hardcoregames.match.MatchState;
import dev.cobblesword.hardcoregames.match.states.StateBase;

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
