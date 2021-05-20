package ru.sgt1503.redroses_animation.DB.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sgt1503.redroses_animation.DB.Entity.Prize;

/**
 * todo Document type PrizeRepo
 */
public interface PrizeRepo extends JpaRepository<Prize, Long> {
    Prize findByNameOfPrize(String name);
}
