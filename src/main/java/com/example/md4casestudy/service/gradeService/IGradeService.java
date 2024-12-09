package com.example.md4casestudy.service.gradeService;

import com.example.md4casestudy.model.Grades;
import com.example.md4casestudy.service.IGenerateService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IGradeService extends IGenerateService<Grades>, UserDetailsService {
}
