package alexandre.baron.dao;

import android.content.Context;

import androidx.room.Room;

public class Connection {
    public static AppDatabase getConnection(Context context){
        return Room.databaseBuilder(context, AppDatabase.class,"AlexandreAppTwitch").fallbackToDestructiveMigration().build();
    }
}
