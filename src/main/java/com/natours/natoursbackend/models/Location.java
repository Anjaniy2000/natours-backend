package com.natours.natoursbackend.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Location {
    @Id
    private String id;

    @Field("description")
    private String description;

    @Field("type")
    private String type;

    @Field("coordinates")
    private double[] coordinates;

    @Field("day")
    private int day;
}
