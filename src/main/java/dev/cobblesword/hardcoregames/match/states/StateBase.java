package dev.cobblesword.hardcoregames.match.states;

import dev.cobblesword.hardcoregames.match.Match;
import dev.cobblesword.hardcoregames.match.MatchOptions;
import dev.cobblesword.hardcoregames.match.MatchState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.event.Listener;

@AllArgsConstructor
public abstract class StateBase implements Listener
{
    private MatchState state;
    @Getter
    private Match match;

    public abstract void onStart();
    public abstract void onSeconds();
    public abstract void onFinish();

    public void setState(MatchState state)
    {
        this.match.setState(state);
    }

    public MatchOptions getOptions()
    {
        return this.getMatch().getOptions();
    }
}
