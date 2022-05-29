package sg.edu.np.mad.newprojectfile;

import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Messageholder extends RecyclerView.ViewHolder {
    TextView name;
    TextView des;
    ImageView pic;




    public Messageholder (View Item){

        super(Item);
        name = Item.findViewById(R.id.textView);
        des = Item.findViewById(R.id.textView2);
        pic = Item.findViewById(R.id.imageView2);

    }
}