package alexandre.pratique;

import android.content.Context;

import androidx.room.Room;

public class Connection {
    public static AppDatabase getConnection(Context context){
        return Room.databaseBuilder(context, AppDatabase.class,"AlexandreAppPratique").fallbackToDestructiveMigration().allowMainThreadQueries().build();
    }
}
