package com.example.md4casestudy.service.user;

import com.example.md4casestudy.model.AppUser;
import com.example.md4casestudy.service.IGenerateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService extends IGenerateService {
    Page<AppUser> findAll(Pageable pageable);
}
