package com.example.walaa_p.myresturent;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class SignUpActivity extends AppCompatActivity {
    private EditText editTextName;
      private EditText editTextPass;
    EditText editTextfullname;
    EditText editTextmobile;
    EditText editTextemail;
    EditText editTextddress;
    String url = "read";
    String url2 = "insert";
    private ProgressDialog PD;
    String msg1;
    String msg2;
    String msg3;
    TextView tvMsgName;
    TextView tvMsgEmail;
    TextView tvMsgPass;
    static Boolean b = true;
    public static  android.support.v7.widget.Toolbar t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        t=(android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
        this.setSupportActionBar(t);
        this.getSupportActionBar().setHomeButtonEnabled(true);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editTextName = (EditText) findViewById(R.id.name);
        editTextPass = (EditText) findViewById(R.id.password);
        editTextfullname = (EditText) findViewById(R.id.fullname);

        editTextmobile = (EditText) findViewById(R.id.mobile);
        editTextemail = (EditText) findViewById(R.id.email);
        editTextddress = (EditText) findViewById(R.id.address);
        tvMsgName = (TextView) findViewById(R.id.msgname);
        tvMsgEmail = (TextView) findViewById(R.id.msgemail);
        tvMsgPass = (TextView) findViewById(R.id.msgpass);
        Button sig=(Button)findViewById(R.id.sigup);

        PD = new ProgressDialog(this);
        PD.setMessage("Loading.....");
        PD.setCancelable(false);

        sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              insert(v);
            }
        });



    }



    public void insert(View view) {

        msg1 = "";
        msg2 = "";
        msg3 = "";
        editTextemail.setText("");
        editTextfullname.setText("");
       editTextPass.setText("");
        final String name = editTextName.getText().toString();
        final String password = editTextPass.getText().toString();
        final String fulllname = editTextfullname.getText().toString();
        final String mobille = editTextmobile.getText().toString();
        final String emaill= editTextemail.getText().toString();
        final String adddress= editTextddress.getText().toString();

        PD.show();

        JsonObjectRequest jreq = new JsonObjectRequest(Request.Method.GET, url2, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    int success = response.getInt("success");

                    if (success == 1) {
                        JSONArray ja = response.getJSONArray("register");
                        for (int i = 0; i < ja.length(); i++) {
                            JSONObject jobj = ja.getJSONObject(i);
                            if (jobj.getString("name").equals(name) || jobj.getString("email").equals(emaill)) {
                                PD.dismiss();
                                b = true;
                                Toast.makeText(getApplicationContext(),
                                        b + "This account is used", Toast.LENGTH_SHORT).show();
                                //tvMsgName.setText("This account is already used");
                                break;
                                //
                            } else {
                                PD.dismiss();

                                b = false;
                            }
                        } // for loop ends



                        if (!b && !name.equals("") && !emaill.equals("")
                                && android.util.Patterns.EMAIL_ADDRESS.matcher(emaill).matches()
                               ) {
                           StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                                    new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {
                                            PD.dismiss();
                                            Toast.makeText(getApplicationContext(),
                                                     "signed up successfully", Toast.LENGTH_SHORT).show();

                                            Intent i = new Intent(SignUpActivity.this, MainActivity.class);
                                            startActivity(i);
                                        }
                                    }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    PD.dismiss();
                                    Toast.makeText(getApplicationContext(),
                                            "failed to signed up", Toast.LENGTH_SHORT).show();
                                }
                            }) {

                                protected Map<String, String> getParams() {
                                    Map<String, String> params = new HashMap<String, String>();
                                    params.put("name", name);
                                    params.put("password", password);
                                    params.put("fullname", fulllname);
                                    params.put("mobile",mobille);
                                    params.put("email", emaill);
                                    params.put("address", adddress);
                                    return params;
                                }
                            };

                            // Adding request to request queue
                        } else {

                            if (name.equals("")) {
                                PD.dismiss();
                                msg1 = "name is required";

                            }
                            if (emaill.equals("") || !android.util.Patterns.EMAIL_ADDRESS.matcher(emaill).matches()) {
                                PD.dismiss();
                                msg2 = "valid email is required";

                            }
                            if (password.equals("")) {
                                PD.dismiss();


                                msg3 = "password is required";

                            }
                            if (password.length() < 8) {
                                PD.dismiss();
                                msg3 += "password must be at least 8chars";
                            }


                            tvMsgName.setText(msg1);
                            tvMsgEmail.setText(msg2);
                            tvMsgPass.setText(msg3);

                        }

                    } // if ends

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                PD.dismiss();
            }
        });

        // Adding request to request queue
        Volley.newRequestQueue(getBaseContext()).add(postRequest);


}




}}
