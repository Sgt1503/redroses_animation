package ru.sgt1503.redroses_animation.DB.Service;

import org.springframework.stereotype.Service;
import ru.sgt1503.redroses_animation.DB.Entity.Follower;

import java.util.List;

@Service
public interface FollowerService {
    Follower addFollower(Follower follower);
    void incrementAbobaCounterById(String id);
    Follower getFollowerById(Long id);
    Follower getFollowerByUserName(String username);
    Follower getFollowerByUserId(String id);
    Follower editAbobaCounterOfFollower(Follower follower);
    Follower editMessageCounterOfFollower(Follower follower);
    Boolean existByUserId(String id);
    List<Follower> getAllFollowers();
    Follower getRandomFollower();
    void cleanAbobaForAll();
}
