package umc.study.domain;


import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.mapping.Like;
import umc.study.domain.mapping.Rent;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Alarm> alarmList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Rent> rentList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Like> likeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<BookAlarm> bookAlarmList = new ArrayList<>();

}

enum Gender{
    MALE, FEMALE
}