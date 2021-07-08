package ru.sgt1503.redroses_animation.DB.Service;

import org.springframework.stereotype.Service;
import ru.sgt1503.redroses_animation.DB.Entity.Prize;

/**
 * todo Document type PrizeService
 */
@Service
public interface PrizeService {
    Prize getPrizeByName(String name);
    Prize getPrizeById(Long id);
    Long count();
    void deleteLast();
}
