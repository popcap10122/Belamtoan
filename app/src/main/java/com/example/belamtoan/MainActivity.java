package com.example.belamtoan;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    final Context context = this;
    EditText so1,so2,dapso;
    TextView tv_kq;
    Button btn_baimoi, btn_check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        so1= (EditText) findViewById(R.id.edit_sothunhat);
        so2= (EditText) findViewById(R.id.edit_sothuhai);
        dapso = (EditText) findViewById(R.id.edit_dapso);
        tv_kq= (TextView) findViewById(R.id.textView_ketqua);
        btn_baimoi = (Button) findViewById(R.id.btn_baimoi);
        btn_baimoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sothu1 = 0 +(int)(Math.random()*((10-0)+1));
                so1.setText(""+sothu1);
                int sothu2 = 0 +(int)(Math.random()*((10-0)+1));
                so2.setText(""+sothu2);


//
//                ketqua=(dapso_cuabe==kq)?"Be gioi qua" :"Be sai roi ket qua la"+kq ;
//                tv_kq.setText(ketqua);
            }
        });
        btn_check= (Button) findViewById(R.id.btn_check);
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);
                String ketqua="";
                int sothunhat= Integer.parseInt(so1.getText().toString());
                int sothuhai= Integer.parseInt(so2.getText().toString());
                int dapso_cuabe =Integer.parseInt( dapso.getText().toString());
                if(String.valueOf(dapso_cuabe)=="")
                {
                    alertDialogBuilder
                            .setMessage("Click yes to exit!")
                            .setCancelable(false)
                            .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    // if this button is clicked, close
                                    // current activity
                                    MainActivity.this.finish();
                                }
                            })
                            .setNegativeButton("No",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    // if this button is clicked, just close
                                    // the dialog box and do nothing
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    // show it
                    alertDialog.show();
                }
                int kq=sothunhat+sothuhai;
                ketqua = (dapso_cuabe==kq)?"Be gioi qua":"Be sai roi ket qua la"+kq;
                tv_kq.setText(ketqua);
            }
        });
    }
}
