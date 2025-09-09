package eduardo.ozika.bandoroom2onetomany;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity(
        tableName = "_student", foreignKeys = {
        @ForeignKey(
                entity = School.class,
                parentColumns = {"school_id"},
                childColumns = {"school_id"},
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE
        ),
        @ForeignKey(
                entity = Class.class,
                parentColumns = {"class_id"},
                childColumns = {"class_id"},
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE
        )
}
)

public class Student {
    @PrimaryKey
    @ColumnInfo(name = "student_id")
    Long StudentId;
    @ColumnInfo(name = "Student_name")
    String StudentName;
    @ColumnInfo(name = "school_id", index = true)
    Long SchoolId;
    @ColumnInfo(name = "class_id", index = true)
    Long ClassId;


    Student(){}


    @Ignore
    Student(String studentName, long schoolId, long classId) {
        this.StudentName = studentName;
        this.SchoolId = schoolId;
        this.ClassId = classId;
    }
}
