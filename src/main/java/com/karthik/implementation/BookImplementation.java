package com.karthik.implementation;


import com.karthik.repository.BookRepository;
import com.karthik.repository.AuthorRepository;
import com.karthik.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookImplementation implements BookService {

    private final BookRepository courseRepository;
    private final AuthorRepository studentRepository;


   /* @Override
    public String addCourse(String email, List<CourseBean> courseBean) throws Exception {
        try {
            AuthorEntity byEmail = studentRepository.findByEmail(email);
            if(byEmail == null) {
                throw new Exception("Could not find student email "+ email);
            }
            AuthorEntity student = new AuthorEntity();
            List<BookEntity> courses = new ModelMapper().map(courseBean, new TypeToken<List<BookEntity>>() {
            }.getType());
            mapStudentDetails(student, courses, byEmail);
            studentRepository.save(student);
            return "Successfully Added Course's to Student E-mail "+byEmail.getEmail();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private static void mapStudentDetails(AuthorEntity student, List<BookEntity> courses, AuthorEntity byEmail) {
        student.setStudentId(byEmail.getStudentId());
        student.setDepartment(byEmail.getDepartment());
        student.setStudentName(byEmail.getStudentName());
        student.setEmail(byEmail.getEmail());
        student.setCity(byEmail.getCity());
        student.setBirthDate(byEmail.getBirthDate());
        student.setCourses(courses);
    }*/
}
