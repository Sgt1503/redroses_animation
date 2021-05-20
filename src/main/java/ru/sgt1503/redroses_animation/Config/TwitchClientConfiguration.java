
package ru.sgt1503.redroses_animation.Config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.sgt1503.redroses_animation.DB.Service.BotFollowerService;
import ru.sgt1503.redroses_animation.DB.Service.FollowerService;
import ru.sgt1503.redroses_animation.DB.Service.PrizeService;
import ru.sgt1503.redroses_animation.DB.Service.WinnerService;
import ru.sgt1503.redroses_animation.Raffle;

@Component
public class TwitchClientConfiguration {

    private FollowerService followerService;
    private WinnerService winnerService;
    private BotFollowerService botFollowerService;
    private PrizeService prizeService;

    @Bean
    public void registerFeatures() {
        // Register Event-based features
        Raffle raffle = new Raffle(prizeService, botFollowerService, winnerService);

    }

}