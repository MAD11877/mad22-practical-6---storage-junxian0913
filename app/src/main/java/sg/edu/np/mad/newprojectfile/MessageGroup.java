package sg.edu.np.mad.newprojectfile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MessageGroup extends AppCompatActivity {
    Button gp1, gp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_group);

        gp1 = findViewById(R.id.button2);
        gp2 = findViewById(R.id.button3);

        gp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rfrag(new  group1());

            }
        });

        gp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rfrag(new  group2fragment());
            }
        });


    }

    private void rfrag(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fraglayout,fragment);
        fragmentTransaction.commit();

    }
}