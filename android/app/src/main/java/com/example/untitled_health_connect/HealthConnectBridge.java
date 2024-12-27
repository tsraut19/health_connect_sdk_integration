package com.example.untitled_health_connect;

import android.content.Context;
import androidx.health.connect.client.HealthConnectClient;
//import androidx.health.connect.client.records.StepCountRecord;
import androidx.health.connect.client.records.Record;
import androidx.health.connect.client.permission.HealthPermission;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

import java.util.List;
import java.util.concurrent.ExecutionException;

//import javax.swing.Spring;

public class HealthConnectBridge implements MethodChannel.MethodCallHandler {
    private Context context;
    private MethodChannel channel;

    public HealthConnectBridge(Context context) {
        this.context = context;
    }

    // This is where you register the bridge with Flutter
    public void registerWith(FlutterPlugin.FlutterPluginBinding binding) {
        channel = new MethodChannel(binding.getBinaryMessenger(), "com.example.untitled_health_connect");
        channel.setMethodCallHandler(this);
    }
    @Override
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        if (call.method.equals("getSteps")) {
            //getStepsData(result);
        } else {
            result.notImplemented();
        }
    }
//    private void getStepsData(MethodChannel.Result result) {
//        HealthConnectClient client = HealthConnectClient.getOrCreate(context);
//        print(context);
//        try {
//            // Request permission for step data
//            //List<HealthPermission> permissions = List.of(HealthPermission.createReadPermission(StepCountRecord.class));
//            //client.requestPermissions(permissions).get();
//
//            // Fetch the step data
//            //List<StepCountRecord> steps = client.recordsClient().read(StepCountRecord.class).get();
//
//            //result.success(steps.toString()); // You can format the data as needed
//        } catch (Exception e) {
//            e.printStackTrace();
//            result.error("ERROR", "Failed to fetch steps data", e.getMessage());
//        }
//    }
}

