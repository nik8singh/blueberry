package com.mana.spring.service.impl;

import com.mana.spring.dao.AdminTokenDAO;
import com.mana.spring.domain.AdminToken;
import com.mana.spring.service.AdminTokenService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


@Transactional
public class AdminTokenServiceImpl implements AdminTokenService {

    @Autowired
    AdminTokenDAO adminTokenDAO;

    @Override
    public AdminToken generate() {

        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        AdminToken adminToken = new AdminToken();
        adminToken.setAdminToken(generatedString);

        Date newDate = DateUtils.addHours(new Date(), 1);

        adminToken.setExpiration(newDate);
        adminTokenDAO.generate(adminToken);
        return adminToken;

    }

    @Override
    public List listActiveTokens() {
        return (ArrayList<AdminToken>) adminTokenDAO.listActiveTokens();
    }
}
