package ru.sgt1503.redroses_animation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sgt1503.redroses_animation.DB.Entity.Winner;
import ru.sgt1503.redroses_animation.DB.Service.PrizeService;
import ru.sgt1503.redroses_animation.DB.Service.WinnerService;

@RestController
@RequestMapping(value = "raffle")
public class MainController {

    private WinnerService winnerService;
    private PrizeService prizeService;

    @Autowired
    public MainController(WinnerService winnerService, PrizeService prizeService) {
        this.winnerService = winnerService;
        this.prizeService = prizeService;
    }

    @GetMapping("/getWinner")
    public Winner getWinner(){
        Winner winner = winnerService.getLastWinner();
        return winner;
    }

}
