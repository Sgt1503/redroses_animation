package ru.sgt1503.redroses_animation.DB.Service;

import org.springframework.stereotype.Service;
import ru.sgt1503.redroses_animation.DB.Entity.BotFollower;

import java.util.List;

@Service
public interface BotFollowerService {
    BotFollower addFollower(BotFollower follower);
    void incrementAbobaCounterById(String id);
    BotFollower getFollowerById(Long id);
    BotFollower getFollowerByUserName(String username);
    BotFollower getFollowerByUserId(String id);
    BotFollower editAbobaCounterOfFollower(BotFollower follower);
    BotFollower editMessageCounterOfFollower(BotFollower follower);
    Boolean existByUserId(String id);
    List<BotFollower> getAllFollowers();
    BotFollower getRandomFollower();
    void cleanAbobaForAll();
}
