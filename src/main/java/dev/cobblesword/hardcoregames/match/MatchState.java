package dev.cobblesword.hardcoregames.match;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MatchState
{
    GENERATE(false, false),
    WAITING_FOR_PLAYERS(true, true),
    COUNTDOWN(true, true),
    SPAWN(false, true),
    GRACE_PERIOD(false, true),
    LIVE(false, true),
    CHAMPION(false, true),
    FINISH(false, false);

    private boolean joinable;
    private boolean joinableStaff;
}
