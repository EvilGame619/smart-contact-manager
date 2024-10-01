package com.scm20.demo.entities;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SocialLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long socialID;

    private String link;
    private String  title;
    @ManyToOne
    private ContactEntity contact;
}
