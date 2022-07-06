package org.studentProfile.model.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.studentProfile.entity.Student;
import org.studentProfile.model.repository.StudentRepo;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService implements IStudentService {

    private final StudentRepo studentRepo;


    @Override
    public Student save(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student getById(Long id) {
         Optional<Student> optional = studentRepo.findById(id);
         if (optional.isEmpty()){
             throw new RuntimeException();

         }
             return optional.get();

    }

    @Override
    public List<Student> getAll() {
        return  (List<Student>) studentRepo.findAll();

    }
}
