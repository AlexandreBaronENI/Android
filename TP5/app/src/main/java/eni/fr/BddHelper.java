package eni.fr;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BddHelper extends SQLiteOpenHelper {
    public BddHelper(Context context) {
        super(context, "ENI_ANDROID_ARTICLE.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ArticleContract.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ArticleContract.DROP_TABLE);
        onCreate(db);
    }
}
