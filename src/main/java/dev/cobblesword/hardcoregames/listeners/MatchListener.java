package dev.cobblesword.hardcoregames.listeners;

import dev.cobblesword.hardcoregames.match.Match;
import dev.cobblesword.hardcoregames.match.MatchState;
import lombok.AllArgsConstructor;
import org.bukkit.event.Listener;

@AllArgsConstructor
public class MatchListener implements Listener
{
    private Match match;

    public boolean isState(MatchState state)
    {
        return this.match.getState() == state;
    }

    public boolean isState(MatchState... states)
    {
        for (MatchState state : states)
        {
            if(this.isState(state))
                return true;
        }
        return false;
    }
}
