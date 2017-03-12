package ch.k42.suspendablecoffee.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;

import ch.k42.suspendablecoffee.MainActivity;
import ch.k42.suspendablecoffee.R;

public class ScanFragment extends Fragment {
    static boolean found = false;

    public ScanFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        found = false;

        final View fragment = inflater.inflate(R.layout.fragment_scan, container, false);
        // Inflate the layout for this fragment
        final SurfaceView cameraView = (SurfaceView) fragment.findViewById(R.id.camera_view);

        final BarcodeDetector barcodeDetector =
                new BarcodeDetector.Builder(getActivity())
                        .setBarcodeFormats(Barcode.QR_CODE)
                        .build();

        final CameraSource cameraSource = new CameraSource
                .Builder(getActivity(), barcodeDetector)
                .setRequestedPreviewSize(1080, 1440)
                .build();

        cameraView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try {
                    cameraSource.start(cameraView.getHolder());
                } catch (IOException ie) {
                    Log.e("CAMERA SOURCE", ie.getMessage());
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                cameraSource.stop();
            }
        });

        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {
            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> barcodes = detections.getDetectedItems();
                if (!found && barcodes.size() != 0) {
                    found = true;
                    String strCount = barcodes.valueAt(0).displayValue;
                    int count = Integer.parseInt(strCount);
                    Snackbar.make(fragment, "Donated " + strCount + " coffees", Snackbar.LENGTH_LONG).show();
                    updateHotCount(count);
                }

            }
        });

        return fragment;
    }

    void updateHotCount(int i) {
        MainActivity main = (MainActivity)getActivity();
        main.updateHotCount(i);
    }
}
