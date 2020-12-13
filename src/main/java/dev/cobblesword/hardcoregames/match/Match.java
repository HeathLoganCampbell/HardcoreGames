package dev.cobblesword.hardcoregames.match;

import dev.cobblesword.hardcoregames.HardcoreGamesPlugin;
import dev.cobblesword.hardcoregames.match.states.*;
import dev.cobblesword.hardcoregames.match.states.ingame.GracePeriodState;
import dev.cobblesword.hardcoregames.match.states.ingame.LiveState;
import dev.cobblesword.hardcoregames.match.states.postgame.ChampionState;
import dev.cobblesword.hardcoregames.match.states.postgame.FinishState;
import dev.cobblesword.hardcoregames.match.states.pregame.CountdownState;
import dev.cobblesword.hardcoregames.match.states.pregame.GenerateState;
import dev.cobblesword.hardcoregames.match.states.ingame.SpawnState;
import dev.cobblesword.hardcoregames.match.states.pregame.WaitingForPlayersState;
import lombok.Getter;
import org.bukkit.Bukkit;

import java.util.EnumMap;

public class Match implements Runnable
{
    @Getter
    private MatchState state = MatchState.GENERATE;
    private int secondsLeft = 120;
    private EnumMap<MatchState, StateBase> stateHandlers = new EnumMap<>(MatchState.class);
    @Getter
    private MatchOptions options = new MatchOptions();
    private HardcoreGamesPlugin plugin;

    public Match(HardcoreGamesPlugin plugin)
    {
        this.plugin = plugin;

        this.registerStateHandler(new GenerateState(this));
        this.registerStateHandler(new WaitingForPlayersState(this));
        this.registerStateHandler(new CountdownState(this));
        this.registerStateHandler(new SpawnState(this));
        this.registerStateHandler(new GracePeriodState(this));
        this.registerStateHandler(new LiveState(this));
        this.registerStateHandler(new ChampionState(this));
        this.registerStateHandler(new FinishState(this));
    }

    private void registerStateHandler(StateBase stateBase)
    {
        this.stateHandlers.put(stateBase.getState(), stateBase);
        Bukkit.getPluginManager().registerEvents(stateBase, plugin);
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
