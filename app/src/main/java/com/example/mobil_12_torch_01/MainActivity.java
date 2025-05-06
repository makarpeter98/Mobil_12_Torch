package com.example.mobil_12_torch_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //Teszt
    public static String myAppID = "hu.unideb.mobil_123456789";
    public static final String TORCH_KEY = myAppID + ".TORCH_KEY";
    public static final String SHR_FILENAME = myAppID + ".SHR_FILENAME";

    //static final String TORCH_KEY = BuildConfig.APPLICATION_ID + ".TORCH_KEY";
    //static final String SHR_FILENAME = BuildConfig.APPLICATION_ID + ".SHR_FILENAME";
    private Button torchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private boolean torch;

    public void torchAction(View view) {

    }
}