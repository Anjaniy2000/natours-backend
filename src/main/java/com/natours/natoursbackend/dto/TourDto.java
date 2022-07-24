package com.natours.natoursbackend.dto;
import com.natours.natoursbackend.models.Location;
import com.natours.natoursbackend.models.StartLocation;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TourDto {

    private String id;

    private String name;

    private String difficulty;

    private String summary;

    private String description;

    private String imageCover;

    private String[] images;

    private String[] startDates;

    private double ratingsAverage;

    private int ratingsQuantity;

    private int duration;

    private int maxGroupSize;

    private double price;

    private List<Location> locations;

    private StartLocation startLocation;

    private String[] tourGuides;
}
