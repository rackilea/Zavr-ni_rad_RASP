package hr.fer.android.rasp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import hr.fer.android.rasp.RootDetection;

/*
 * Created by lracki on 19.04.2018..
 */

public class MainActivity extends AppCompatActivity implements TimeoutHandler.TimeoutListener{

    private TextView tamperingLbl, rootDetectionLbl, debugDetectionLbl;
    private ImageView tamperingImage, rootDetectionImage, debugdetectionImage;

    private RootDetection rootDetection = new RootDetection();

    private boolean isDebug;
    private boolean isRoot;

    private TimeoutHandler mTimeoutHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTimeoutHandler = new TimeoutHandler(this, TimeoutHandler.EVENT_TIMEOUT, this);

        tamperingLbl = findViewById(R.id.tampering_lbl);
        rootDetectionLbl = findViewById(R.id.root_detection_lbl);
        debugDetectionLbl = findViewById(R.id.debug_detection_lbl);

        tamperingImage = findViewById(R.id.image_tampering_detection);
        rootDetectionImage = findViewById(R.id.image_root_detection);
        debugdetectionImage = findViewById(R.id.image_debug_detection);
    }

    @Override
    protected void onResume() {
        super.onResume();
            checkIfTampering();
    }

    private void checkIfTampering() {
        isDebug = DebugDetection.isDebuggerPresent();
        try {
            isRoot = rootDetection.isRootDetected(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (isRoot || isDebug){
            notifyIfTampering();
        }
    }

    private void notifyIfTampering(){
        if (isRoot || isDebug){
            if (isRoot){
                rootDetectionLbl.setText(R.string.lbl__device_rooted);
                rootDetectionImage.setImageDrawable(getResources().getDrawable(R.drawable.x_icon));

                tamperingLbl.setText(R.string.lbl__tampering_in_progress);
                tamperingImage.setImageDrawable(getResources().getDrawable(R.drawable.x_icon));
            }
            if (isDebug){
                debugDetectionLbl.setText(R.string.lbl__debugger_attached);
                debugdetectionImage.setImageDrawable(getResources().getDrawable(R.drawable.x_icon));

                tamperingLbl.setText(R.string.lbl__tampering_in_progress);
                tamperingImage.setImageDrawable(getResources().getDrawable(R.drawable.x_icon));
            } else {
                debugDetectionLbl.setText(R.string.lbl__no_debugger_attached);
                debugdetectionImage.setImageDrawable(getResources().getDrawable(R.drawable.check_icon));
            }
        } else {
            rootDetectionLbl.setText(R.string.lbl__device_not_rooted);
            rootDetectionImage.setImageDrawable(getResources().getDrawable(R.drawable.check_icon));

            debugDetectionLbl.setText(R.string.lbl__no_debugger_attached);
            debugdetectionImage.setImageDrawable(getResources().getDrawable(R.drawable.check_icon));

            tamperingLbl.setText(R.string.lbl__no_tampering_in_progress);
            tamperingImage.setImageDrawable(getResources().getDrawable(R.drawable.check_icon));
        }
    }

    public void resetTimer() {
        this.mTimeoutHandler.resetTimer();
    }

    @Override
    public void onTimeout() {
        resetTimer();
        checkIfTampering();
        notifyIfTampering();
    }
}
