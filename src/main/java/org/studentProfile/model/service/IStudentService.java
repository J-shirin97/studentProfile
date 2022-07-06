package org.studentProfile.model.service;

import org.studentProfile.entity.Student;

import java.util.List;

public interface IStudentService {
    Student save(Student student);

    Student getById(Long id);

    List<Student> getAll();

}

