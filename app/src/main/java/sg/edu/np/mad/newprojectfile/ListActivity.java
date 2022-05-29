package sg.edu.np.mad.newprojectfile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {


    public ArrayList<user> list2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        RecyclerView justin = findViewById(R.id.picture);

        Messageadapter ks = new Messageadapter(this);

        LinearLayoutManager vic = new LinearLayoutManager(this);
        justin.setLayoutManager(vic);
        justin.setItemAnimator(new DefaultItemAnimator());
        justin.setAdapter(ks);

        ImageView picture = findViewById(R.id.imageView4);
        ListActivity obj = new ListActivity();

        //user chengann = new user("junxian","royce",1,false);
        DBapadter db = new DBapadter(this);



        for (int i = 0; i<20; i++){
            Random rand = new Random();
            int ow = rand.nextInt(1000000000);
            int jun = rand.nextInt(1000000000);
            int xian = i+1;
            String name, description;
            boolean followed;


            name = "Name " +   ow ;
            description = "Description  "+ jun;
            followed = rand.nextBoolean();
            user royce = new user(name, description, xian,followed);
            db.insertmessage(royce);
            list2.add(royce);
        }





    }





    }
