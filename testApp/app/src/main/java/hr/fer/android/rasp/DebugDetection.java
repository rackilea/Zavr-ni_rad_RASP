package hr.fer.android.rasp;

/*
 * Created by lracki on 08.04.2018..
 */

public final class DebugDetection {

    public boolean isDebuggerConnectedCheck() {
        try {
            return android.os.Debug.isDebuggerConnected();

        } catch (final Exception e) {
            e.printStackTrace();
        }

        return true;
    }
}
