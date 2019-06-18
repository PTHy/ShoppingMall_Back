package kr.hs.dgsw.shopping_back.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.time.LocalDateTime;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String account;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String tel;

    @Column(nullable = false)
    private String zip;

    @Column(nullable = false)
    @Email
    private String email;

    @Column(nullable = false)
    private String addr;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime updated;

    public void setPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(password.getBytes(), 0, password.getBytes().length);
            this.password = new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            Logger logger = LoggerFactory.getLogger(User.class);
            logger.warn(e.getMessage());
        }
    }
}
