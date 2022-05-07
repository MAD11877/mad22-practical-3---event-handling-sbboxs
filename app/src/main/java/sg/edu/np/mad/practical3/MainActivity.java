package sg.edu.np.mad.practical3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String TAG = "Main activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User user = new User();
        Intent receiving = getIntent();
        int id = receiving.getIntExtra("UserID",0);

        Log.v(TAG,"On Create!");
        user.setId(id);
        user.setName("Tester");
        user.setFollowed(false);
        TextView idInfo = findViewById(R.id.idDisplay);
        idInfo.setText("MAD "+ id);
        Button myButton = findViewById(R.id.followButton);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(TAG, "Button Pressed");
                String buttonText = (String) myButton.getText();
                Log.v(TAG,buttonText);

                Context context = getApplicationContext();
                CharSequence text = "Toast message";

                if(!user.isFollowed()){
                    myButton.setText("UNFOLLOW");
                    user.setFollowed((true));
                    text = "Followed";
                }else if (buttonText == "UNFOLLOW"){
                    user.setFollowed((false));
                    myButton.setText("FOLLOW");
                    text = "Unfollowed";
                }
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            }

        });
    }
}