/*
package com.karthik.mapper;

import com.karthik.bean.StudentBean;
import com.karthik.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",uses = DateMapper.class)
public interface StudentMapper {

    @Mapping(target = "birthDate", source = "birthDate", qualifiedByName = {"dateMapper","localDateToString"})
    StudentBean entityToDto(Student student);
    @Mapping(target = "birthDate", source = "birthDate",qualifiedByName = {"dateMapper","stringToLocalDate"})
    Student dtoToEntity(StudentBean studentBean);
    List<StudentBean> toStudentDTOs(List<Student> students);

}
*/
