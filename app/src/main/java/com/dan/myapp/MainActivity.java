package com.dan.myapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;
/**
 * Created by dan_1 on 17-Mar-16.
 *
 * Log In and Sing up page for the app
 Copyright (C) 2016 Quest

 This program is free software; you can redistribute it and/or
 modify it under the terms of the GNU General Public License
 as published by the Free Software Foundation; either version 2
 of the License, or (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program; if not, write to the Free Software
 Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
public class MainActivity extends AppCompatActivity {

    TextView mTextFieldMail;
    TextView mTextFieldPass;
    ImageButton mButtonSignup;
    ImageButton mButtonLogIn;
    ImageButton mButtonForgot;
    ImageView mImageOwl;

    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    private RelativeLayout relativeLayout;
    Firebase mref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mTextFieldMail = (TextView) findViewById(R.id.editTextMail);
        mTextFieldPass = (TextView) findViewById(R.id.editTextPass);
        mButtonSignup = (ImageButton) findViewById(R.id.buttonSignup);
        mButtonLogIn = (ImageButton) findViewById(R.id.buttonLogin);
        mButtonForgot = (ImageButton) findViewById((R.id.buttonForget));
        relativeLayout = (RelativeLayout) findViewById(R.id.fond);
        //mImageOwl = (ImageView) findViewById(R.id.imageViewOwl);
        mref = new Firebase("https://smartpark1.firebaseio.com/");
        mTextFieldMail.setText("admin@test.com");
        mTextFieldPass.setText("admin");


       /* mImageOwl.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://questiot.webflow.io/"));
                startActivity(intent);
            }
        });
*/

        mButtonSignup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //mref.setValue("Sign In");
                mref.createUser(mTextFieldMail.getText().toString(), mTextFieldPass.getText().toString(), new Firebase.ValueResultHandler<Map<String, Object>>() {
                    @Override
                    public void onSuccess(Map<String, Object> result) {
                        System.out.println("Successfully created user account with uid: " + result.get("uid"));

                        Toast.makeText(getApplicationContext(), "Account created",
                                Toast.LENGTH_SHORT).show();
                        /*layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                        ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.popup, null);

                        popupWindow = new PopupWindow(container, 450, 50, true);
                        popupWindow.showAtLocation(relativeLayout, Gravity.NO_GRAVITY, 135, 725);

                        container.setOnTouchListener(new View.OnTouchListener() {

                            public boolean onTouch(View view, MotionEvent motionEvent) {
                                popupWindow.dismiss();
                                return true;
                            }
                        });
                        */
                    }

                    @Override
                    public void onError(FirebaseError firebaseError) {
                        Toast.makeText(getApplicationContext(), "Invalid E-Mail",
                                Toast.LENGTH_SHORT).show();
                        // there was an error
                        /*layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                        ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.popup1, null);

                        popupWindow = new PopupWindow(container, 450, 50, true);
                        popupWindow.showAtLocation(relativeLayout, Gravity.NO_GRAVITY, 135, 725);

                        container.setOnTouchListener(new View.OnTouchListener() {

                            public boolean onTouch(View view, MotionEvent motionEvent) {
                                popupWindow.dismiss();
                                return true;
                            }
                        });*/
                    }
                });
            }
        });

        mButtonLogIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                //mref.setValue("Log In");
                mref.authWithPassword(mTextFieldMail.getText().toString(), mTextFieldPass.getText().toString(), new Firebase.AuthResultHandler() {
                    @Override
                    public void onAuthenticated(AuthData authData) {
                        System.out.println("User ID: " + authData.getUid() + ", Provider: " + authData.getProvider());

                        Intent i = new Intent(MainActivity.this, MapsActivity.class);
                        i.putExtra("name", mTextFieldMail.getText().toString());
                        startActivity(i);
                    }

                    @Override
                    public void onAuthenticationError(FirebaseError firebaseError) {
                        System.out.println("The user doesn't exist");

                        Toast.makeText(getApplicationContext(), "Wrong password",
                                Toast.LENGTH_SHORT).show();
                        /*layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                        ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.popup2, null);

                        popupWindow = new PopupWindow(container, 450, 50, true);
                        popupWindow.showAtLocation(relativeLayout, Gravity.NO_GRAVITY, 135, 805);

                        container.setOnTouchListener(new View.OnTouchListener() {

                            public boolean onTouch(View view, MotionEvent motionEvent) {
                                popupWindow.dismiss();
                                return true;
                            }
                        });*/
                    }

                });


            }
        });

        mButtonForgot.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                mref.resetPassword(mTextFieldMail.getText().toString(), new Firebase.ResultHandler() {
                    @Override
                    public void onSuccess() {
                        System.out.println("The mail was sent");

                        Toast.makeText(getApplicationContext(), "Recovery E-Mail Sent",
                                Toast.LENGTH_SHORT).show();

                        /*layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                        ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.popup3, null);

                        popupWindow = new PopupWindow(container, 450, 50, true);
                        popupWindow.showAtLocation(relativeLayout, Gravity.NO_GRAVITY, 135, 725);

                        container.setOnTouchListener(new View.OnTouchListener() {

                            public boolean onTouch(View view, MotionEvent motionEvent) {
                                popupWindow.dismiss();
                                return true;
                            }
                        });
                        */
                    }


                    @Override
                    public void onError(FirebaseError firebaseError) {
                        System.out.println("The account doesn't exist");

                        Toast.makeText(getApplicationContext(), "Account doesn't exist",
                                Toast.LENGTH_SHORT).show();
                        /*layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                        ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.popup4, null);

                        popupWindow = new PopupWindow(container, 450, 50, true);
                        popupWindow.showAtLocation(relativeLayout, Gravity.NO_GRAVITY, 135, 725);

                        container.setOnTouchListener(new View.OnTouchListener() {

                            public boolean onTouch(View view, MotionEvent motionEvent) {
                                popupWindow.dismiss();
                                return true;
                            }
                        });*/
                    }
                });
            }
        });

    }

}