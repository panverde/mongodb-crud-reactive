package com.reactiva.demomongodbreact.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Document(collection = "user")
public class User implements Serializable {
    @Id
    private String userId;
    private String name;
    private Date creationDate = new Date();
    private Map<String, String> userSettings = new HashMap<>();
    private Boolean delete = Boolean.FALSE;
}
