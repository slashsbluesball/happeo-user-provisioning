package com.happeo.userprovisioning.demo2api.model.users;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"password"})
@Document(collection = "users")
public class User {

    @Id
    private String id;                      // Happeo User’s internal autogenerated id
    private String externalId;              // ID of the user in the external system (null for internal user of Happeo)

    @Indexed(unique = false)
    private String organisationId;          // Organisation ID of the user

    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private Boolean isActive;
}
