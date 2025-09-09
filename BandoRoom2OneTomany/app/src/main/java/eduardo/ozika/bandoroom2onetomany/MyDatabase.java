package eduardo.ozika.bandoroom2onetomany;
import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {School.class,Class.class,Student.class},version = 1)
public abstract class MyDatabase extends RoomDatabase {
    abstract AllDao allDao();
}
