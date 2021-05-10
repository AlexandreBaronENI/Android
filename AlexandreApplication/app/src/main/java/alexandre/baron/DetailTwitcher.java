package alexandre.baron;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import alexandre.baron.bo.Twitcher;

public class DetailTwitcher extends AppCompatActivity {

    Twitcher twitcher;
    TextView pseudo, firstname, lastname, nbfollows, nbsubs;
    ImageView profilepic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_twitcher);

        twitcher = getIntent().getParcelableExtra("twitcher");

        pseudo = findViewById(R.id.tv_pseudo_twitcher);
        firstname = findViewById(R.id.tv_firstname_twitcher);
        lastname = findViewById(R.id.tv_lastname_twitcher);
        nbfollows = findViewById(R.id.tv_nbfollows_twitcher);
        nbsubs = findViewById(R.id.tv_nbsubs_twitcher);
        profilepic = findViewById(R.id.iv_profile_pic);


        pseudo.setText(twitcher.getPseudo());
        firstname.setText(twitcher.getFirstname());
        lastname.setText(twitcher.getLastname());
        nbfollows.setText(twitcher.getFollows().size()+" follows");
        nbsubs.setText(twitcher.getSubs().size()+ " subs");
        Picasso.get().load(twitcher.getProfilePicture()).into(profilepic);
    }
}