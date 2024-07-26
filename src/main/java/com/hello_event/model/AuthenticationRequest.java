package com.hello_event.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
public class AuthenticationRequest {
    private String username;
    private String password;
}
