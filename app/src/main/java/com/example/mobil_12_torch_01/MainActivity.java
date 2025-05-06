package com.example.mobil_12_torch_01;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static String myAppID = "hu.unideb.mobil_123456789";
    public static final String TORCH_KEY = myAppID + ".TORCH_KEY";
    public static final String SHR_FILENAME = myAppID + ".SHR_FILENAME";

    //static final String TORCH_KEY = BuildConfig.APPLICATION_ID + ".TORCH_KEY";
    //static final String SHR_FILENAME = BuildConfig.APPLICATION_ID + ".SHR_FILENAME";
    private Button torchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        torchButton = findViewById(R.id.torch_button);
    }

    private boolean torch;

    public void torchAction(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(SHR_FILENAME, 0);
        torch = sharedPreferences.getBoolean(TORCH_KEY, true);

        CameraManager camManager =  (CameraManager) this.getSystemService(Context.CAMERA_SERVICE);
        String cameraId = null;

        try {
            cameraId = camManager.getCameraIdList()[0];
            camManager.setTorchMode(cameraId, torch);
            torch = !torch;
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

        torchButton.setText("Torch " + (torch ? "on" : "off"));
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putBoolean(TORCH_KEY, torch);
        prefEditor.apply();
    }
}