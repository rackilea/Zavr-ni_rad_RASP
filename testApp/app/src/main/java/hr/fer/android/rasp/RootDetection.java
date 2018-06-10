package hr.fer.android.rasp;

/*
 * Created by lracki on 03.04.2018..
 */

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class RootDetection {

    private static final String SU_COMMAND = "su";

    private static final String ROOT_PACKAGE_0 = "com.noshufou.android.su";
    private static final String ROOT_PACKAGE_1 = "com.thirdparty.superuser";
    private static final String ROOT_PACKAGE_2 = "eu.chainfire.supersu";
    private static final String ROOT_PACKAGE_3 = "com.koushikdu.superuser";
    private static final String ROOT_PACKAGE_4 = "com.zachspong.temprootremovejb";
    private static final String ROOT_PACKAGE_5 = "com.ramdroid.appquarantine";
    private static final String ROOT_PACKAGE_6 = "com.genymotion.superuser";

    public boolean isRootDetected(Context context) throws Exception {
        return canSudoCommandBeExecuted() | areTestKeysIncluded() | areRootPackagesInstalled(context) | hasSuperuserApk();
    }

    private boolean canSudoCommandBeExecuted() {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(SU_COMMAND);
            return true;
        } catch (final Exception e) {
            return false;
        } finally {
            if (process != null) {
                process.destroy();
            }
        }
    }

    private boolean areTestKeysIncluded() {
        try {
            return Build.TAGS.equals("test-keys");
        } catch (final Exception e) {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    private boolean areRootPackagesInstalled(final Context context) throws Exception {

        final Set<String> set = new HashSet<>();
        set.add(ROOT_PACKAGE_0);
        set.add(ROOT_PACKAGE_1);
        set.add(ROOT_PACKAGE_2);
        set.add(ROOT_PACKAGE_3);
        set.add(ROOT_PACKAGE_4);
        set.add(ROOT_PACKAGE_5);
        set.add(ROOT_PACKAGE_6);

        final List<PackageInfo> packageInfos = context.getPackageManager().getInstalledPackages(0);
        for (final PackageInfo packageInfo : packageInfos) {
            if (set.contains(packageInfo.packageName)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasSuperuserApk() {
        return new File("/system/app/Superuser.apk").exists();
    }
}
