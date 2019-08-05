package com.stackroute.trackservice.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class Track {

    @Id
    private int id;
    private String name;
    private String comment;



}
