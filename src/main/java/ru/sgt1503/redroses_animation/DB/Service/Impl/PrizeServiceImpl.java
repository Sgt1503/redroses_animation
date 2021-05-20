package ru.sgt1503.redroses_animation.DB.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sgt1503.redroses_animation.DB.Entity.Prize;
import ru.sgt1503.redroses_animation.DB.Repo.PrizeRepo;
import ru.sgt1503.redroses_animation.DB.Service.PrizeService;

/**
 * todo Document type PrizeServiceImpl
 */
@Service
public class PrizeServiceImpl implements PrizeService {

    private PrizeRepo prizeRepo;

    @Autowired
    public PrizeServiceImpl(PrizeRepo prizeRepo) {
        this.prizeRepo = prizeRepo;
    }

    @Override
    public Prize getPrizeByName(String name) {
        return prizeRepo.findByNameOfPrize(name);
    }

    @Override
    public Prize getPrizeById(Long id) {
        return prizeRepo.findById(id).orElse(null);
    }

    @Override
    public Long count() {
        return prizeRepo.count();
    }
}
