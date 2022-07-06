package org.studentProfile.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.studentProfile.entity.Student;

public interface StudentRepo extends PagingAndSortingRepository<Student , Long> {
}
