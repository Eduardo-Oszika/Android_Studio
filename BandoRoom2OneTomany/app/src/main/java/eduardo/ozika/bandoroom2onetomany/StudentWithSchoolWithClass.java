package eduardo.ozika.bandoroom2onetomany;
import androidx.room.Embedded;
import androidx.room.Relation;
import java.util.List;


public class StudentWithSchoolWithClass {
    @Embedded
    Student student;


    @Relation(entity = School.class,parentColumn = "school_id", entityColumn = "school_id")
    List<School> schoolList;
    @Relation(entity = Class.class,parentColumn = "class_id",entityColumn = "class_id")
    List<Class> classList;
}
