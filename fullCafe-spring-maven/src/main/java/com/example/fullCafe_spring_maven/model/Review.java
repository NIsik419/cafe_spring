package com.example.fullCafe_spring_maven.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Review {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private int numOfStar;
    @Column(nullable = false)
    private List<String> who;
    @Column(nullable = false)
    private List<String> convenient;
    @Column(nullable = false)
    private List<String> object;
    @Column(nullable = false)
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid", nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cafeName", nullable = false)
    private Cafe cafe;

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", numOfStar=" + numOfStar +
                ", who=" + who +
                ", convenient=" + convenient +
                ", object=" + object +
                ", content='" + content + '\'' +
                '}';
    }
}