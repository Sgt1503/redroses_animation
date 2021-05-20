package ru.sgt1503.redroses_animation.DB.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.sgt1503.redroses_animation.DB.Entity.Follower;

@Repository
public interface FollowerRepo extends JpaRepository<Follower, Long> {
    Follower findByUsername(String username);
    Follower findByUserID(String id);
    Boolean existsFollowerByUserID(String id);
    @Query(value="UPDATE follower SET aboba_counter = 1", nativeQuery = true)
    void setZeroAbobaCounterForAll();
}
