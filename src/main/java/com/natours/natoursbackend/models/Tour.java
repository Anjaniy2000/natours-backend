package com.natours.natoursbackend.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Document("tours")
public class Tour {

    @Id
    private String id;

    @Field("name")
    private String name;

    @Field("difficulty")
    private String difficulty;

    @Field("summary")
    private String summary;

    @Field("description")
    private String description;

    @Field("imageCover")
    private String imageCover;

    @Field("images")
    private String[] images;

    @Field("startDates")
    private String[] startDates;

    @Field("ratingsAverage")
    private double ratingsAverage;

    @Field("ratingsQuantity")
    private int ratingsQuantity;

    @Field("duration")
    private int duration;

    @Field("maxGroupSize")
    private int maxGroupSize;

    @Field("price")
    private double price;

    @Field("locations")
    private List<Location> locations;

    @Field("startLocation")
    private StartLocation startLocation;

    @Field("guides")
    private List<TourGuide> tourGuides;
}
