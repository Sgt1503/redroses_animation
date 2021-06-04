package ru.sgt1503.redroses_animation.DB.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Table(name = "winner")
public class Winner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "botfollower_username")
    private BotFollower botFollower;

    @OneToOne
    @JoinColumn(name = "prize_nameOfPrize")
    private Prize prize;




//    public Winner(Follower follower, Win win) {
//        this.follower = follower;
//        this.win = win;
//    }

    public Winner(BotFollower follower, Prize prize) {
        this.botFollower = follower;
        this.prize = prize;
    }
}
