package com.mana.spring.dao;

import com.mana.spring.domain.PasswordReset;

public interface PasswordResetDAO {

    long savePasswordReset(PasswordReset passwordReset);

    PasswordReset getPasswordReset(String token);

    void deleteToken(String token);
}
