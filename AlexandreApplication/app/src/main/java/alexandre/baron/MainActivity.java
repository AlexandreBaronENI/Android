package alexandre.baron;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import alexandre.baron.Adapter.TwitcherAdapter;
import alexandre.baron.bo.Follow;
import alexandre.baron.bo.Sub;
import alexandre.baron.bo.Twitcher;
import alexandre.baron.bo.Viewer;
import alexandre.baron.dao.AppDatabase;
import alexandre.baron.dao.Connection;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvtwitchers;
    private List<Twitcher> twitchers;
    private TwitcherAdapter twitcherAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.ConfigureRecyclerView();
    }

    private void ConfigureRecyclerView(){

        Twitcher t1 = new Twitcher(1, "Drucker", "Michel", "michmich", new Date(), "test", "michmich@mail.com", new ArrayList<Sub>(), new ArrayList<Follow>(), "https://images.unsplash.com/photo-1511367461989-f85a21fda167");
        Twitcher t2 = new Twitcher(2, "Trump", "Donal", "dona", new Date(), "test", "donatournetoi@mail.com", new ArrayList<Sub>(), new ArrayList<Follow>(), "https://images.unsplash.com/photo-1511367461989-f85a21fda167");
        Twitcher t3 = new Twitcher(3, "Holidays", "Johnny", "jojo", new Date(), "test", "jojo@mail.com", new ArrayList<Sub>(), new ArrayList<Follow>(), "https://images.unsplash.com/photo-1511367461989-f85a21fda167");
        Twitcher t4 = new Twitcher(4, "Nadal", "Rafael", "rafa", new Date(), "test", "rafa@mail.com", new ArrayList<Sub>(), new ArrayList<Follow>(), "https://images.unsplash.com/photo-1511367461989-f85a21fda167");
        Twitcher t5 = new Twitcher(5, "BourgPalette", "Sacha", "sacha", new Date(), "test", "sacha@mail.com", new ArrayList<Sub>(), new ArrayList<Follow>(), "https://images.unsplash.com/photo-1511367461989-f85a21fda167");
        Twitcher t6 = new Twitcher(6, "Macron", "Manu", "manu", new Date(), "test", "manu@mail.com", new ArrayList<Sub>(), new ArrayList<Follow>(), "https://images.unsplash.com/photo-1511367461989-f85a21fda167");

        new Thread(new Runnable() {
            @Override
            public void run() {

                AppDatabase db = Connection.getConnection(MainActivity.this);

                //db.twitcherDao().insert(t1);
                //db.twitcherDao().insert(t2);
                //db.twitcherDao().insert(t3);
                //db.twitcherDao().insert(t4);
                //db.twitcherDao().insert(t5);
                //db.twitcherDao().insert(t6);

                twitchers = db.twitcherDao().getAll();

                for (int i = 0; i < twitchers.size(); i++){
                    Log.i("sssss", twitchers.get(i).toString());
                }

                twitcherAdapter = new TwitcherAdapter(twitchers, onClickListener);



                recyclerView = findViewById(R.id.rv_list_twitchers);
                recyclerView.setAdapter(twitcherAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            }
        }).start();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int position = Integer.parseInt(v.getTag().toString());
            Intent intent = new Intent(MainActivity.this, DetailTwitcher.class);
            intent.putExtra("twitcher", twitchers.get(position));
            startActivity(intent);
        }
    };
}
