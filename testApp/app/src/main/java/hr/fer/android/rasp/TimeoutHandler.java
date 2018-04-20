package hr.fer.android.rasp;

/*
 * Created by lracki on 20.04.2018..
 */

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;


@SuppressLint({"HandlerLeak"})
public class TimeoutHandler {
    public static final String EVENT_TIMEOUT = ".EVENT_ON_TIMEOUT";

    private static final int HANDLER_TIMEOUT_MESSAGE = 12345;

    private TimeoutHandler.TimeoutListener timeoutListener = null;
    private Handler mTimeoutHandler = null;
    private final Context mContext;

    private boolean mTimeoutHandled = false;
    private long mLastTimer;
    private long mTimeoutInMiliSeconds;
    private String mTimeoutAction;

    public TimeoutHandler(Context context, String timeoutAction, TimeoutHandler.TimeoutListener listener) {
        mLastTimer = SystemClock.elapsedRealtime();
        mContext = context.getApplicationContext();
        mTimeoutInMiliSeconds = 2000;
        mTimeoutAction = timeoutAction;
        timeoutListener = listener;

        mTimeoutHandler = new Handler() {
            public void handleMessage(Message msg) {
                synchronized(TimeoutHandler.this) {
                    handleTimeout();
                }
            }
        };

        mTimeoutHandler.sendEmptyMessageDelayed(HANDLER_TIMEOUT_MESSAGE, mTimeoutInMiliSeconds);
    }

    private synchronized void handleTimeout() {
        if(!isTimeoutHandled()) {
            mTimeoutHandled = true;

            Intent intent = new Intent(mTimeoutAction);
            LocalBroadcastManager.getInstance(mContext).sendBroadcast(intent);
            if(timeoutListener != null) {
                timeoutListener.onTimeout();
            }

        }
    }

    private boolean isTimeoutHandled() {
        return mTimeoutHandled;
    }

    @SuppressLint({"HandlerLeak"})
    void resetTimer() {
        synchronized(this) {
            mTimeoutHandled = false;
        }

        mLastTimer = SystemClock.elapsedRealtime();
        mTimeoutHandler.removeMessages(HANDLER_TIMEOUT_MESSAGE);
        mTimeoutHandler.sendEmptyMessageDelayed(HANDLER_TIMEOUT_MESSAGE, mTimeoutInMiliSeconds);
    }

    public interface TimeoutListener {
        void onTimeout();
    }
}

