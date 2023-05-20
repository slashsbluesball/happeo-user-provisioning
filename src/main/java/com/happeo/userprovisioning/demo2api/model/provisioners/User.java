package com.happeo.userprovisioning.demo2api.model.provisioners;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "provisioners")
public class User {
  @Id
  private String id;
  private String username;
  private String email;
  private String password;

  @DBRef
  @Builder.Default
  private Set<Role> roles = new HashSet<>();
}
