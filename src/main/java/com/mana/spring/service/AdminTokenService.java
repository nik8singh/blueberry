package com.mana.spring.service;

import com.mana.spring.domain.AdminToken;

import java.util.List;

public interface AdminTokenService {

    AdminToken generate();

    List listActiveTokens();
}
