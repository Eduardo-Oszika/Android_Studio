package eduardo.ozika.bandoroom2onetomany;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import java.util.List;


@Dao
public interface AllDao {
    @Insert
    Long insertSchool(School s);
    @Insert
    Long insertClass(Class c);
    @Insert
    Long insertStudent(Student s);


    @Query("SELECT * FROM _school")
    List<School> getAllSchools();
    @Query("SELECT * FROM _school WHERE school_id = :school_id ")
    School getSchoolById(Long school_id);
    @Query("SELECT * FROM _class")
    List<Class> getAllClasses();
    @Query("SELECT * FROM _class WHERE class_id = :class_id")
    Class getClassById(Long class_id);


    @Query("SELECT * FROM _student JOIN _school ON _school.school_id = _student.school_id JOIN _class ON _class.class_id = _student.class_id")
    List<StudentAndSchoolAndClass> getStudentAndSchoolAndClass();


    @Query("SELECT * FROM _student")
    List<StudentWithSchoolWithClass> getStudentWithSchoolWithClass();


}
