package alexandre.baron.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import alexandre.baron.bo.Sub;

@Dao
public interface SubDao {
    @Query("SELECT * FROM Sub")
    List<Sub> getAll();
    @Delete
    void delete(Sub Sub);
    @Insert
    void insert(Sub Sub);
}
