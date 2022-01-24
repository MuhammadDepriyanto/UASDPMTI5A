package ac.id.atmaluhur.mhs.TRAVEL;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ac.id.atmaluhur.mhs.TRAVEL.R;
import ac.id.atmaluhur.mhs.TRAVEL.AlertDialogManager;
import ac.id.atmaluhur.mhs.TRAVEL.session.SessionManager;

public class menuutama extends AppCompatActivity {

    AlertDialogManager alert = new AlertDialogManager();
    SessionManager session;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuutama);
        session = new SessionManager(getApplicationContext());
        session.checkLogin();

        btnLogout = findViewById(R.id.out);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                AlertDialog dialog = new AlertDialog.Builder(menuutama.this)
                        .setTitle("Anda yakin ingin keluar ?")
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                                session.logoutUser();
                            }
                        })
                        .setNegativeButton("Tidak", null)
                        .create();
                dialog.show();
            }
        });
    }

    public void profileMenu(View v) {
        Intent i = new Intent(this, profil.class);
        startActivity(i);
    }

    public void historyMenu(View v) {
        Intent i = new Intent(this, Riwayat.class);
        startActivity(i);
    }

    public void bookKereta(View v) {
        Intent i = new Intent(this, book_kereta.class);
        startActivity(i);
    }

    public void bookHotel(View v) {
        Toast.makeText(getApplicationContext(), "Mohon maaf, sistem sedang dalam pengembangan.", Toast.LENGTH_LONG).show();
    }
}
