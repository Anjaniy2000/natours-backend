package com.natours.natoursbackend.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class StartLocation {

    @Field("description")
    private String description;

    @Field("type")
    private String type;

    @Field("coordinates")
    private double[] coordinates;

    @Field("address")
    private String address;
}
