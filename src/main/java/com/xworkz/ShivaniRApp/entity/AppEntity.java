package com.xworkz.ShivaniRApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "App")
@NamedQueries({

        //  LOGIN
        @NamedQuery(
                name = "checkUserExists",
                query = "select app.password from AppEntity app where app.email=:email"
        ),

        //  LOGIN ATTEMPT COUNT
        @NamedQuery(
                name = "updateCount",
                query = "update AppEntity app set app.failedAttempts = app.failedAttempts + 1 where app.email=:eMail"
        ),

        @NamedQuery(
                name = "getCount",
                query = "select app.failedAttempts from AppEntity app where app.email=:eMail"
        ),

        @NamedQuery(
                name = "setCountToZero",
                query = "update AppEntity app set app.failedAttempts = 0 where app.email=:eMail"
        ),

        //  DUPLICATE CHECK
        @NamedQuery(
                name = "checkUserExistsByEmail",
                query = "select count(app) from AppEntity app where app.email=:email"
        ),

        @NamedQuery(
                name = "checkUserExistsByPhone",
                query = "select count(app) from AppEntity app where app.phoneNumber=:phNo"
        )
})
public class AppEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "password")
    private String password;

    @Column(name = "failed_attempts")
    private int failedAttempts;

    @Column(name = "account_locked")
    private boolean accountLocked;

    @Column(name = "otp")
    private String otp;

    @Column(name = "otp_expiry")
    private LocalDateTime otpExpiry;

}














