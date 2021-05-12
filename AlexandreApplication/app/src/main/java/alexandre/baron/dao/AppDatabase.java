package alexandre.baron.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import alexandre.baron.bo.Follow;
import alexandre.baron.bo.Sub;
import alexandre.baron.bo.Twitcher;
import alexandre.baron.bo.Viewer;


@Database(entities = {Twitcher.class, Viewer.class, Follow.class, Sub.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TwitcherDao twitcherDao();
    public abstract ViewerDao viewerDao();
    public abstract FollowDao followDao();
    public abstract SubDao subDao();
}
