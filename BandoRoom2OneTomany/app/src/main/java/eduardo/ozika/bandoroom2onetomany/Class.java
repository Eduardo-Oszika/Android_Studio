package eduardo.ozika.bandoroom2onetomany;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity(tableName = "_class")

public class Class {
    @PrimaryKey
    @ColumnInfo(name = "class_id")
    Long ClassId;
    @NonNull
    @ColumnInfo(name = "class_name")
    String ClassName;


    Class(){}


    @Ignore
    Class(String className) {
        this.ClassName = className;
    }

}
