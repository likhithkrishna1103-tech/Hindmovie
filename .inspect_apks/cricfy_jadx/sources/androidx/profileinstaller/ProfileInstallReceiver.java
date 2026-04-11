package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import java.io.File;
import m2.e;
import p.a;
import t4.c;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Bundle extras;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if ("androidx.profileinstaller.action.INSTALL_PROFILE".equals(action)) {
            c.t(context, new a(1), new e(this), true);
            return;
        }
        if ("androidx.profileinstaller.action.SKIP_FILE".equals(action)) {
            Bundle extras2 = intent.getExtras();
            if (extras2 != null) {
                String string = extras2.getString("EXTRA_SKIP_FILE_OPERATION");
                if (!"WRITE_SKIP_FILE".equals(string)) {
                    if ("DELETE_SKIP_FILE".equals(string)) {
                        new File(context.getFilesDir(), "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
                        Log.d("ProfileInstaller", "RESULT_DELETE_SKIP_FILE_SUCCESS");
                        setResultCode(11);
                        return;
                    }
                    return;
                }
                e eVar = new e(this);
                try {
                    c.e(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
                    eVar.j(10, null);
                    return;
                } catch (PackageManager.NameNotFoundException e9) {
                    eVar.j(7, e9);
                    return;
                }
            }
            return;
        }
        if ("androidx.profileinstaller.action.SAVE_PROFILE".equals(action)) {
            e eVar2 = new e(this);
            if (Build.VERSION.SDK_INT < 24) {
                eVar2.j(13, null);
                return;
            } else {
                Process.sendSignal(Process.myPid(), 10);
                eVar2.j(12, null);
                return;
            }
        }
        if (!"androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(action) || (extras = intent.getExtras()) == null) {
            return;
        }
        String string2 = extras.getString("EXTRA_BENCHMARK_OPERATION");
        e eVar3 = new e(this);
        if (!"DROP_SHADER_CACHE".equals(string2)) {
            eVar3.j(16, null);
            return;
        }
        int i = Build.VERSION.SDK_INT;
        if (c.c(i >= 34 ? context.createDeviceProtectedStorageContext().getCacheDir() : i >= 24 ? context.createDeviceProtectedStorageContext().getCodeCacheDir() : i == 23 ? context.getCodeCacheDir() : context.getCacheDir())) {
            eVar3.j(14, null);
        } else {
            eVar3.j(15, null);
        }
    }
}
