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
@Table(name = "prize")
public class Prize {
    @Id
    private Long id;

    @Column
    private String nameOfPrize;

    @Column
    private String urlToPng;
}
