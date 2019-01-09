package com.app.library.widght;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.app.library.R;


/**
 * Created by cample on 2018/6/19.
 */
public class Toasty {
    private static Toast toast;
    private Toasty(){}
    public static void showTip(Context context, String message){
        if(toast!=null)
        {
            toast.cancel();
            toast=null;
        }
         toast=Toast.makeText(context,message,Toast.LENGTH_SHORT);
        ViewGroup viewGroup=(ViewGroup) LayoutInflater.from(context).inflate(R.layout.layout_tip_toast,null,false);
        TextView tipText=viewGroup.findViewById(R.id.msgTv);
        tipText.setText(message);
        toast.setView(viewGroup);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }
}
