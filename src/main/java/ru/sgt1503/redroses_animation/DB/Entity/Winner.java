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

//    @OneToOne
//    @JoinColumn(name = "follower_userid")
//    private Follower follower;

    @OneToOne
    @JoinColumn(name = "botfollower_username")
    private BotFollower botFollower;

    @OneToOne
    @JoinColumn(name = "prize_nameOfPrize")
    private Prize prize;

    @Column
    private String username;

    @Column
    private String urlToPng;

    @Column
    private String prizeName;




//    public Winner(Follower follower, Win win) {
//        this.follower = follower;
//        this.win = win;
//    }

    public Winner(BotFollower follower, Prize prize) {
        this.botFollower = follower;
        this.prize = prize;
    }

    public Winner(BotFollower botFollower, Prize prize, String username, String urlToPng, String prizeName) {
        this.botFollower = botFollower;
        this.prize = prize;
        this.username = username;
        this.urlToPng = urlToPng;
        this.prizeName = prizeName;
    }
}
