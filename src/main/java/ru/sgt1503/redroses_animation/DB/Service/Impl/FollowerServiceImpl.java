package ru.sgt1503.redroses_animation.DB.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sgt1503.redroses_animation.DB.Entity.Follower;
import ru.sgt1503.redroses_animation.DB.Repo.FollowerRepo;
import ru.sgt1503.redroses_animation.DB.Service.FollowerService;

import java.util.List;

@Service
public class FollowerServiceImpl implements FollowerService {
    private final FollowerRepo followerRepo;

    @Autowired
    public FollowerServiceImpl(FollowerRepo followerRepo) {
        this.followerRepo = followerRepo;
    }

    @Override
    public Follower addFollower(Follower follower) {
        return followerRepo.save(follower);
    }

    @Override
    public void incrementAbobaCounterById(String id) {
        Long abobaCount = followerRepo.findByUserID(id).getAbobaCounter();
        followerRepo.findByUserID(id).setAbobaCounter(abobaCount+1);
    }

    @Override
    public Follower getFollowerById(Long id) {
        return followerRepo.findById(id).orElse(null);
    }

    @Override
    public Follower getFollowerByUserName(String username) {
        return followerRepo.findByUsername(username);
    }

    @Override
    public Follower getFollowerByUserId(String id) {
        return followerRepo.findByUserID(id);
    }

    @Override
    public Follower editAbobaCounterOfFollower(Follower follower) {
        Follower followerEdited;
        Long newCount = follower.getAbobaCounter() + 1;
        followerEdited = new Follower(follower.getId(), follower.getUsername(), follower.getUserID(), newCount, follower.getSteamID(), follower.getMessageCounter());
        follower = followerEdited;
        return followerRepo.save(follower);
    }

    @Override
    public Follower editMessageCounterOfFollower(Follower follower) {
        Follower followerEdited;
        Long newCount = follower.getMessageCounter() + 1;
        followerEdited = new Follower(follower.getId(), follower.getUsername(), follower.getUserID(), follower.getAbobaCounter(), follower.getSteamID(), newCount);
        follower = followerEdited;
        return followerRepo.save(follower);
    }

    @Override
    public Boolean existByUserId(String id) {
        return followerRepo.existsFollowerByUserID(id);
    }

    @Override
    public List<Follower> getAllFollowers() {
        return followerRepo.findAll();
    }

    @Override
    public Follower getRandomFollower() {
        return getRandomFollower();
    }

    @Override
    public void cleanAbobaForAll() {
        followerRepo.setZeroAbobaCounterForAll();
    }
}
