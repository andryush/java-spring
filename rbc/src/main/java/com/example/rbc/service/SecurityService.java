package com.example.rbc.service;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);

}
