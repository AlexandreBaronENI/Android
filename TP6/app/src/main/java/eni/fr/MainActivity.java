package eni.fr;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.MenuItem;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;
    private Article article;
    public static final int SELECT_PHONE_NUMBER = 1;
    private String msg, phoneNo;

    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        article = getIntent().getParcelableExtra("article");

        android.widget.TextView nom = findViewById(R.id.nom);
        android.widget.TextView prix = findViewById(R.id.prix);
        RatingBar degreEnvie = findViewById(R.id.degreEnvie);
        android.widget.TextView description = findViewById(R.id.description);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        nom.setText(article.nom);
        description.setText(article.description);
        prix.setText(Double.toString(article.prix) + " €");
        degreEnvie.setRating(article.degreEnvie);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.menumain, menu);
        return true;
    }

    public void GoToUrl(android.view.View view) {
        Intent intent = new Intent(this, InfoUrlActivity.class);
        intent.putExtra("article", article);

        startActivity(intent);
    }

    public void Menu(android.view.View view) {
        Intent intent = new Intent(this, ListeArticlesActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.edit:
                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                intent.putExtra("article", article);
                startActivity(intent);
                break;
            case R.id.delete:
                ArticleDAO dao = new ArticleDAO(this);
                dao.delete(article);

                Intent intent2 = new Intent(this, ListeArticlesActivity.class);
                startActivity(intent2);
                break;
            case R.id.send:
                Intent i = new Intent(Intent.ACTION_PICK);
                i.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                startActivityForResult(i, SELECT_PHONE_NUMBER);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case SELECT_PHONE_NUMBER:
                    Cursor cursor = null;
                    try {
                        Uri uri = data.getData();
                        cursor = getContentResolver().query(uri, null, null, null, null);
                        cursor.moveToFirst();
                        int phoneIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                        int nameIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
                        phoneNo = cursor.getString(phoneIndex);
                        msg = "J'aimerai bien avoir cet article pour Noël : " + article.nom;

                        sendSMSMessage(phoneNo, msg);

                        Log.i("Message envoyé", "Le message à bien été envoyé");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        } else {
            Log.e("Failed", "Not able to pick contact");
        }
    }

    protected void sendSMSMessage(String phoneNo, String message) {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }
        SmsManager smsManager = SmsManager.getDefault();
        // Send Message
        smsManager.sendTextMessage(phoneNo,
                null,
                message,
                null,
                null);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNo, null, msg, null, null);
                    Toast.makeText(getApplicationContext(), "SMS envoyé",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }
    }
}