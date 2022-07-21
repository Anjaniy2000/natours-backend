package com.natours.natoursbackend.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Document("tour_guides")
public class TourGuide {
    @Id
    private String id;

    @Field("name")
    private String name;

    @Field("photo")
    private String photo;
}
