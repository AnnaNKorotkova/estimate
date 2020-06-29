package ru.topjava.estimate.to;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequestTo {
    private String email;
    private String password;
}
