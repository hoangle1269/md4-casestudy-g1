package com.example.md4casestudy.service.appUser;


import com.example.md4casestudy.model.User;
import com.example.md4casestudy.service.IGenerateService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAppUserService extends IGenerateService<User>, UserDetailsService {
}
