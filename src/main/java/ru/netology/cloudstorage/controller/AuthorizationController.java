package ru.netology.cloudstorage.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.cloudstorage.model.AuthorizationRequest;
import ru.netology.cloudstorage.model.AuthorizationResponse;
import ru.netology.cloudstorage.service.AuthorizationService;


@RestController
@AllArgsConstructor
public class AuthorizationController {
    private final AuthorizationService service;

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorizationResponse> login(@RequestBody AuthorizationRequest authorizationRequest) {
        AuthorizationResponse response = service.login(authorizationRequest);
        if (response.getAuthToken() == null)
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/logout")
    public ResponseEntity<?>logout(@RequestHeader("auth-token") String authToken) {
        service.logout(authToken);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
