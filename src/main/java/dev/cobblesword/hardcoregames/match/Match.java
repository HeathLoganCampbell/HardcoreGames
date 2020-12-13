package dev.cobblesword.hardcoregames.match;

import dev.cobblesword.hardcoregames.match.states.*;

import java.util.EnumMap;

public class Match implements Runnable
{
    private MatchState state = MatchState.GENERATE;
    private int secondsLeft = 120;
    private EnumMap<MatchState, StateBase> stateHandlers = new EnumMap<>(MatchState.class);

    public Match()
    {
        stateHandlers.put(MatchState.GENERATE, new GenerateState(this));
        stateHandlers.put(MatchState.WAITING_FOR_PLAYERS, new WaitingForPlayersState(this));
        stateHandlers.put(MatchState.COUNTDOWN, new CountdownState(this));
        stateHandlers.put(MatchState.SPAWN, new SpawnState(this));
        stateHandlers.put(MatchState.GRACE_PERIOD, new GracePeriodState(this));
        stateHandlers.put(MatchState.LIVE, new LiveState(this));
        stateHandlers.put(MatchState.CHAMPION, new ChampionState(this));
        stateHandlers.put(MatchState.FINISH, new FinishState(this));
    }

    public void setState(MatchState state)
    {
        System.out.println("HG ] " + this.state + " => " + state);
        StateBase oldStateHandler = this.stateHandlers.get(this.state);
        StateBase newStateHandler = this.stateHandlers.get(state);
        oldStateHandler.onFinish();
        newStateHandler.onStart();
        this.state = state;
    }

    public int getPlayerCount()
    {
        return 0;
    }

    public int getAlivePlayerCount()
    {
        return 0;
    }

    @Override
    public void run()
    {
        StateBase stateBase = this.stateHandlers.get(this.state);
        stateBase.onSeconds();
    }
}
