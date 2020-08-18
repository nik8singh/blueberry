package com.mana.spring.dao;

import com.mana.spring.domain.AdminToken;

import java.util.List;

public interface AdminTokenDAO {

    void generate(AdminToken adminToken);

    List listActiveTokens();

    void delete(String adminToken);
}
