package com.chc.tanda.concepthubclassessbackend.assistors;

import com.chc.tanda.concepthubclassessbackend.model.StudentRegistrationByAdmin;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 11, 2020
 */
@Spec(path = "retired", constVal = "false", spec = Equal.class)
public interface NotDeletedStudentSearchApiSpecification extends Specification<StudentRegistrationByAdmin> {
}
