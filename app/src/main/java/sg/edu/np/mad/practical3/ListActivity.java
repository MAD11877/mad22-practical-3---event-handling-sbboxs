package sg.edu.np.mad.practical3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {
    private String TAG = "List Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Log.v(TAG,"On Create!");

        ImageView imageButton = findViewById(R.id.imageView);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "Image Pressed");
                AlertDialog alertDialog = new AlertDialog.Builder(ListActivity.this).create();
                alertDialog.setTitle("Profile");
                alertDialog.setMessage("MADness");
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Close",
                    new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int which){
                            dialog.dismiss();
                        }
                    });
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "View",
                        new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int which){
                                long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
                                Log.v(TAG, String.valueOf(number));
                                int userID = (int)number;
                                Intent myIntent = new Intent(ListActivity.this,MainActivity.class);
                                myIntent.putExtra("UserID", userID);
                                startActivity(myIntent);
                            }
                        });
                alertDialog.show();
            }
        });
    }
}