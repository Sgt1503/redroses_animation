package ru.sgt1503.redroses_animation.DB.Service;

import org.springframework.stereotype.Service;
import ru.sgt1503.redroses_animation.DB.Entity.BotFollower;
import ru.sgt1503.redroses_animation.DB.Entity.Winner;

/**
 * todo Document type WinnerService
 */
@Service
public interface WinnerService {
    Winner addWinner(Winner winner);
    Winner getWinnerByFollower(BotFollower follower);
    Winner getLastWinner();
}
