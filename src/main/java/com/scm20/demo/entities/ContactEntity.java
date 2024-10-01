package com.scm20.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contact")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactID;

    private String name;

    @Column(nullable = false)
    private String email;
    @Column(nullable = false)

    private String phoneNumber;

    private String address;

    private String picture;

    private String description;
    private boolean favourite = false;
    private String websiteLink;
    private String linkedLink;

    private String cloudinaryID;
    @ManyToOne
    @JsonIgnore
    private UserEntity user;
    @OneToMany(mappedBy = "contact",cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
    private List<SocialLink> socials = new ArrayList<>();
}
