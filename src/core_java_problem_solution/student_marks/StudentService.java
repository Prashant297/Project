package core_java_problem_solution.student_marks;

import java.io.IOException;
import java.util.Map;

public interface StudentService {
    Map<Integer,Student> addStudentDetail() throws IOException;
}
