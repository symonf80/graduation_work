package ru.netology.cloudstorage.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorizationResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -8268626665487253090L;

    @JsonProperty("auth-token")
    private String authToken;

}
