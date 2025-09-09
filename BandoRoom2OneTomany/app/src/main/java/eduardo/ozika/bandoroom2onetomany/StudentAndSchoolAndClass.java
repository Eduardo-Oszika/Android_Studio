package eduardo.ozika.bandoroom2onetomany;
import androidx.room.Embedded;


public class StudentAndSchoolAndClass {
    @Embedded
    Student student;
    String school_name;
    String class_name;
}
