package ru.sgt1503.redroses_animation.DB.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Table(name = "bot_follower")
public class BotFollower {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String username;

    @Column
    private String userID;

    @Column
    private Long abobaCounter;

    @Column
    private String authToken;

    @Column
    private Long messageCounter;

    public BotFollower(String username, String userID, Long abobaCounter, String authToken, Long messageCounter) {
        this.username = username;
        this.userID = userID;
        this.abobaCounter = abobaCounter;
        this.authToken = authToken;
        this.messageCounter = messageCounter;
    }



    public BotFollower() {
    }
}
