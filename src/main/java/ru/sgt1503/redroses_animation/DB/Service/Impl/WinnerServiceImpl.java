package ru.sgt1503.redroses_animation.DB.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sgt1503.redroses_animation.DB.Entity.BotFollower;
import ru.sgt1503.redroses_animation.DB.Entity.Winner;
import ru.sgt1503.redroses_animation.DB.Repo.WinnerRepo;
import ru.sgt1503.redroses_animation.DB.Service.WinnerService;

import java.util.List;

/**
 * todo Document type WinnerServiceImpl
 */
@Service
public class WinnerServiceImpl implements WinnerService {

    private WinnerRepo winnerRepo;

    @Autowired
    public WinnerServiceImpl(WinnerRepo winnerRepo) {
        this.winnerRepo = winnerRepo;
    }

    @Override
    public Winner addWinner(Winner winner) {
        return winnerRepo.save(winner);
    }



    @Override
    public Winner getLastWinner() {
        List<Winner> winners = winnerRepo.findAll();
        return winners.get(winners.size()-1);
    }
}
