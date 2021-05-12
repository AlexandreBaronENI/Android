package alexandre.baron.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import alexandre.baron.bo.Viewer;

@Dao
public interface ViewerDao {
    @Query("SELECT * FROM Viewer")
    List<Viewer> getAll();
    @Query("SELECT * FROM Viewer WHERE id = :id")
    Viewer get(int id);
    @Query("SELECT * FROM Viewer WHERE pseudo LIKE :pseudo")
    Viewer getByPseudo(String pseudo);
    @Query("SELECT * FROM Viewer WHERE pseudo = :pseudo AND password = :password")
    Viewer getByPseudoPassword(String pseudo, String password);
    @Delete
    void delete(Viewer Viewer);
    @Insert
    void insert(Viewer Viewer);
    @Update
    void update(Viewer Viewer);
}
