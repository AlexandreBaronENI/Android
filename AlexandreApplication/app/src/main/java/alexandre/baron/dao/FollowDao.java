package alexandre.baron.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import alexandre.baron.bo.Follow;

@Dao
public interface FollowDao {
    @Query("SELECT * FROM Follow")
    List<Follow> getAll();
    @Delete
    void delete(Follow Follow);
    @Insert
    void insert(Follow Follow);
}
