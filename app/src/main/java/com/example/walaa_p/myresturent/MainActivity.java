package com.example.walaa_p.myresturent;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import android.app.ProgressDialog;
import android.content.Intent;

import android.widget.TextView;


import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {


    String url = "http://path";
    ArrayList<HashMap<String, String>> Item_List;
    ProgressDialog PD;
    public static final String name = "name";
    public static final String password = "password";
    EditText etName;
    EditText etPass;
    TextView tv;
///////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylog);
        etName=(EditText)findViewById(R.id.username);
        etPass=(EditText)findViewById(R.id.password);
        //tv=(TextView)findViewById(R.id.textView);
        Item_List = new ArrayList<HashMap<String, String>>();
        PD = new ProgressDialog(this);


        Button login=(Button) findViewById(R.id.login);//login
        Button REG=(Button) findViewById(R.id.sigup);//login
        REG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(i);

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ReadDataFromDB();
               Intent i=new Intent(MainActivity.this, Resturentlist.class);
                startActivity(i);

            }
        });



    }
    private void ReadDataFromDB() {

        final String pass = etPass.getText().toString();
        final String name = etName.getText().toString();

        PD.setMessage("Loading.....");
        PD.setCancelable(false);
        PD.show();

       /* JsonObjectRequest jreq = new JsonObjectRequest(DownloadManager.Request.Method.GET, url,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try {

                            int success = response.getInt("Resturent");
                            Boolean b = false;
                            if (success == 1) {
                                JSONArray ja = response.getJSONArray("users");

                                for (int i = 0; i < ja.length(); i++) {

                                    JSONObject jobj = ja.getJSONObject(i);
                                    if(jobj.getString(NAME).equals(name)&&jobj.getString(PASS).equals(pass)) {
                                        b = true;
                                        break;
                                    }
                                } // for loop ends
                                if(b){
                                    PD.dismiss();

                                    Intent intent = new Intent(LoginActivity.this,Resturentlist.class);
                                    startActivity(intent);}
                                else{
                                    PD.dismiss();
                                    tv.setText("Wrong username or password!");
                                }
                            } // if ends


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        catch (Exception e){
                        }

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                PD.dismiss();
            }
        });

        // Adding request to request queue
        //MyApplication.getInstance().addToReqQueue(jreq);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}}
