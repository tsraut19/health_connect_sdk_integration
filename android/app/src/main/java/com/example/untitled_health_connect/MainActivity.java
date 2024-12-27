package com.example.untitled_health_connect;

import android.os.Bundle;
import androidx.annotation.NonNull;
import io.flutter.embedding.android.FlutterActivity;
//import androidx.health.connect.client.HealthConnectClientException;
import io.flutter.plugins.*;
import android.content.Context;
import io.flutter.embedding.engine.FlutterEngine;

import io.flutter.plugin.common.MethodChannel;
import androidx.health.connect.client.HealthConnectClient;
import androidx.health.connect.client.permission.HealthPermission;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.contract.ActivityResultContracts;

public class MainActivity extends FlutterActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
         String CHANNEL = "com.example.untitled_health_connect";
//        HealthConnectBridge bridge = new HealthConnectBridge(this);
//        bridge.registerWith(getFlutterEngine().getPlugins());

//        HealthConnectBridge bridge = new HealthConnectBridge((Context) this);
//        bridge.registerWith(getFlutterEngine().getPlugins());
        super.onCreate(savedInstanceState);
        // Check permissions when needed
        //checkPermissionsAndRequest();
        // Initialize the Health Connect Client

//        // Example of accessing data, such as heart rate or sleep sessions
        //try {
//            // Example: Reading heart rate data
//            List<HeartRate> heartRateRecords = healthConnectClient.readRecords(HeartRate.class);
//            for (HeartRate record : heartRateRecords) {
//                Log.d(TAG, "Heart rate: " + record.getBpm());
//            }
//            new MethodChannel(getFlutterEngine().getDartExecutor(), CHANNEL)
//                    .setMethodCallHandler(
//                            (call, result) -> {
//                                if (call.method.equals("getBatteryLevel")) {
//                                    // Handle the method 'getBatteryLevel'
//                                    String batteryLevel = getBatteryLevel();
//                                    if (batteryLevel != null) {
//                                        result.success(batteryLevel);  // Send the result back to Flutter
//                                    } else {
//                                        result.error("UNAVAILABLE", "Battery level not available.", null);
//                                    }
//                                } else {
//                                    result.notImplemented();  // If the method doesn't exist
//                                }
//                            }
//                    );
        new MethodChannel(getFlutterEngine().getDartExecutor(), CHANNEL)
            .setMethodCallHandler(
                (call, result) -> {
                    if (call.method.equals("exampleMethodFromNative")) {
                        String nativeResult = exampleMethodFromNative(); // Call the Java method
                        result.success(nativeResult);         // Send the result back to Flutter
                    } else {
                        result.notImplemented(); // If the method is not implemented
                    }
                }
            );
            //return "ssss";
//        } catch (Exception e) {
//            //Log.e(TAG, "Error reading health data", e);
//        }
        //return "tttt";
    }

    // A sample method in MainActivity.java
    private String exampleMethodFromNative() {
        return "Hello from Android!";
    }
}

