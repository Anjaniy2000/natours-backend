package com.natours.natoursbackend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document("refresh_token")
public class RefreshToken {

    @Id
    @Field("_id")
    private String id;

    @Field("token")
    private String token;

    @Field("createdDate")
    private Instant createdDate;
}
