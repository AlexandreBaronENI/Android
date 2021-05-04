package eni.fr;

import android.provider.BaseColumns;

public class ArticleContract implements BaseColumns {
    public static final String TABLE_NAME = "Articles";

    public static final String[] ALL_COLUMN = new String[]{
            ArticleContract._ID,
            ArticleContract.COL_NOM,
            ArticleContract.COL_PRIX,
            ArticleContract.COL_DESC,
            ArticleContract.COL_NOTE,
            ArticleContract.COL_URL,
            ArticleContract.COL_ACHETE };

    public static final String COL_NOM = "nom";
    public static final String COL_PRIX = "prix";
    public static final String COL_DESC = "description";
    public static final String COL_NOTE = "note";
    public static final String COL_URL = "url";
    public static final String COL_ACHETE = "achete";

    public static final String CREATE_TABLE = "CREATE TABLE " +
            TABLE_NAME +
            " ( " +
            _ID + " INTEGER PRIMARY KEY," +
            COL_NOM + " TEXT ," +
            COL_PRIX + " REAL ," +
            COL_DESC + " TEXT ," +
            COL_NOTE + " INTEGER ," +
            COL_URL + " TEXT ," +
            COL_ACHETE + " INTEGER" +
            " )";


    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
}
