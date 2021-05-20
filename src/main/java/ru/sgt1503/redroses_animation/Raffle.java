package ru.sgt1503.redroses_animation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sgt1503.redroses_animation.DB.Entity.BotFollower;
import ru.sgt1503.redroses_animation.DB.Entity.Winner;
import ru.sgt1503.redroses_animation.DB.Service.BotFollowerService;
import ru.sgt1503.redroses_animation.DB.Service.PrizeService;
import ru.sgt1503.redroses_animation.DB.Service.WinnerService;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.MINUTES;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * todo Document type Raffle
 */
@Component
public class Raffle {

    private BotFollowerService botFollowerService;
    private WinnerService winnerService;
    private PrizeService prizeService;

    @Autowired
    public Raffle(PrizeService prizeService, BotFollowerService botFollowerService, WinnerService winnerService) {
        this.botFollowerService = botFollowerService;
        this.winnerService = winnerService;
        this.prizeService = prizeService;
        beepForAnHour();
    }

    private final ScheduledExecutorService scheduler =
        Executors.newScheduledThreadPool(1);

    public void beepForAnHour() throws NullPointerException{
        final Runnable beeper = new Runnable() {
            public void run() {
                List<BotFollower> followers = botFollowerService.getAllFollowers();
                int maxF = followers.size();
                int minF = 1;
                double winner = (Math.random() * ((maxF - minF) + 1)) + minF;
                String winnerId = followers.get((int) winner).getUserID();
                BotFollower follower = botFollowerService.getFollowerByUserId(winnerId);

                long maxP = prizeService.count();
                long minP = 1;
                Random r = new Random();
                long prize = r.nextInt((int) maxP) + 1;
                winnerService.addWinner(new Winner(
                    follower,
                    prizeService.getPrizeById(prize)));
                System.out.println(
                    follower.getUsername() +
                        " выйграл: " +
                        prizeService.getPrizeById(prize).getNameOfPrize()
                );
                System.out.println(prize);
            }
        };
        final ScheduledFuture<?> beeperHandle =
            scheduler.scheduleAtFixedRate(beeper, 1, 6, SECONDS);
        scheduler.schedule(new Runnable() {
            public void run() { beeperHandle.cancel(true); }
        }, 60 * 24, MINUTES);
    }
}
