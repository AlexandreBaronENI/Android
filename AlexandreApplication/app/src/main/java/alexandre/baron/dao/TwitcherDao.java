package alexandre.baron.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import alexandre.baron.bo.Twitcher;

@Dao
public interface TwitcherDao {
    @Query("SELECT * FROM Twitcher")
    List<Twitcher> getAll();
    @Query("SELECT * FROM Twitcher WHERE id = :id")
    Twitcher get(int id);
    @Query("SELECT * FROM Twitcher WHERE pseudo LIKE :pseudo")
    Twitcher getByPseudo(String pseudo);
    @Query("SELECT * FROM Twitcher WHERE pseudo = :pseudo AND password = :password")
    Twitcher getByPseudoPassword(String pseudo, String password);
    @Delete
    void delete(Twitcher twitcher);
    @Insert
    void insert(Twitcher twitcher);
    @Update
    void update(Twitcher twitcher);
}
