package eduardo.ozika.bandoroom2onetomany;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity(tableName = "_school")

public class School {
    @PrimaryKey
    @ColumnInfo(name = "school_id")
    Long Schoolid;
    @NonNull
    @ColumnInfo(name = "school_name")
    String SchoolName;


    School(){}


    @Ignore
    School(String schoolName) {
        this.SchoolName = schoolName;
    }
}

