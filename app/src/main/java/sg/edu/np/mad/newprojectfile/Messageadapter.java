package sg.edu.np.mad.newprojectfile;



import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;
import java.util.Random;

public class Messageadapter extends RecyclerView.Adapter<Messageholder> {


    public  ArrayList<user> list;

    public Messageadapter(Context context) {
        DBapadter db = new DBapadter(context);
        this.list = db.getUsers();
    }

    @Override

    public int getItemViewType(int position  ) {
        user vv = list.get(position);
        if(vv.name.endsWith("7")){
            return 0;
        }
        else {
            return 1;
        }
    }

    @NonNull
    @Override
    public Messageholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item =  null;
        if (viewType == 1 )
            item =LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle,null,false);
        else {
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.lastdigit7,parent,false);
        }
        return new Messageholder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull Messageholder holder, int position) {
        user vv = list.get(position);

        holder.name.setText(vv.name);
        holder.des.setText(vv.description);

        holder.pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder qiren =new AlertDialog.Builder(holder.pic.getContext());
                qiren.setTitle("Profile");
                qiren.setMessage(vv.name);
                qiren.setNegativeButton("close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                qiren.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Bundle extras = new Bundle();

                        extras.putInt("pos1",position);
                        extras.putString("randval",vv.name);
                        extras.putString("des",vv.description);
                        Intent next = new Intent(holder.pic.getContext(),MainActivity.class);

                        next.putExtras(extras);

                        holder.pic.getContext().startActivity(next);

                    }
                });
                AlertDialog dialog = qiren.create();
                dialog.show();
            }

        });




    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
