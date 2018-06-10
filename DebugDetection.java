package hr.fer.android.rasp;

/*
 * Created by lracki on 08.04.2018..
 */

import android.os.Debug;

public final class DebugDetection {

    public static boolean isDebuggerPresent() {
        return isDebuggerConnectedCheck() | detectThreadCpuTimeNanos();
    }

    private static boolean isDebuggerConnectedCheck() {
        try {
            return android.os.Debug.isDebuggerConnected();
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean detectThreadCpuTimeNanos() {
        long start = Debug.threadCpuTimeNanos();

        for (int i = 0; i < 1000000; ++i)
            continue;

        long stop = Debug.threadCpuTimeNanos();

        return stop - start >= 10000000;
    }
}
