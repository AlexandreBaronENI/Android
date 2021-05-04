package eni.fr;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ArticleDAO {
    private SQLiteDatabase db;
    private BddHelper helper;

    public ArticleDAO(Context ctx){
        helper = new BddHelper(ctx);
    }

    public long insert(Article article){
        db = helper.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(ArticleContract.COL_NOM, article.nom);
        cv.put(ArticleContract.COL_PRIX, article.prix);
        cv.put(ArticleContract.COL_DESC, article.description);
        cv.put(ArticleContract.COL_NOTE, article.degreEnvie);
        cv.put(ArticleContract.COL_URL, article.url);
        cv.put(ArticleContract.COL_ACHETE, article.isAchete);

        long id = db.insert(ArticleContract.TABLE_NAME, null, cv);

        helper.close();

        return id;
    }

    public ArrayList<Article> get(boolean tri)
    {
        db = helper.getWritableDatabase();

        ArrayList<Article> resultat = new ArrayList<Article>();

        String orderBy = tri?ArticleContract.COL_PRIX + " ASC":"";

        Cursor curseur = db.query(ArticleContract.TABLE_NAME, ArticleContract.ALL_COLUMN, null, null, null, null, orderBy);

        while (curseur.moveToNext())
        {
            Article article = new Article(
                    curseur.getInt(0), // id
                    curseur.getString(1), // Nom
                    curseur.getString(2),// Description
                    curseur.getDouble(3), // Prix
                    curseur.getInt(4), // DegreEnvie
                    curseur.getString(5), // Url
                    curseur.getInt(6)==1 // Achete
            );

            resultat.add(article);
        }

        curseur.close();

        helper.close();
        return resultat;
    }

    public Article get(int id)
    {
        db = helper.getWritableDatabase();

        Article articles = new Article();

        Cursor curseur = db.query(ArticleContract.TABLE_NAME, ArticleContract.ALL_COLUMN, ArticleContract._ID+" == ?", new String[]{Integer.toString(id)}, null, null, null);

        if (curseur.moveToNext())
        {
            articles = new Article(
                    curseur.getInt(0), // id
                    curseur.getString(1), // Nom
                    curseur.getString(2),// Description
                    curseur.getDouble(3), // Prix
                    curseur.getInt(4), // DegreEnvie
                    curseur.getString(5), // Url
                    curseur.getInt(6)==1 // Achete
            );
        }

        curseur.close();

        helper.close();
        return articles;
    }

    public void update(Article article)
    {
        db = helper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(ArticleContract.COL_NOM, article.nom);
        cv.put(ArticleContract.COL_PRIX, article.prix);
        cv.put(ArticleContract.COL_DESC, article.description);
        cv.put(ArticleContract.COL_NOTE, article.degreEnvie);
        cv.put(ArticleContract.COL_URL, article.url);
        cv.put(ArticleContract.COL_ACHETE, article.isAchete);

        int nbLignesModifiess = db.update(ArticleContract.TABLE_NAME, cv, ArticleContract._ID + " == ?", new String[]{Integer.toString(article.id)});

        helper.close();
    }

    public void delete(Article article)
    {
        db = helper.getWritableDatabase();

        int nbDeleted = db.delete(ArticleContract.TABLE_NAME, ArticleContract._ID + " == ?", new String[]{Integer.toString(article.id)});

        helper.close();
    }
}
