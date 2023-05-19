package com.happeo.userprovisioning.demo2api.model.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    private String email;
    private Name name;
    private String id;
    private String applicationId;
}
