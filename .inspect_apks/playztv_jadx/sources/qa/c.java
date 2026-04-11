package qa;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import be.h;
import java.util.ArrayList;
import java.util.List;
import od.i;
import od.k;
import od.q;
import wa.c2;
import wa.y0;
import wa.z0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f11167a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f11168b = new c();

    public static ArrayList c(Context context) {
        h.e(context, "context");
        int i = context.getApplicationInfo().uid;
        String str = context.getApplicationInfo().processName;
        Object systemService = context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager != null ? activityManager.getRunningAppProcesses() : null;
        if (runningAppProcesses == null) {
            runningAppProcesses = q.f9570u;
        }
        ArrayList arrayListW = i.W(runningAppProcesses);
        ArrayList arrayList = new ArrayList();
        int size = arrayListW.size();
        int i10 = 0;
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayListW.get(i11);
            i11++;
            if (((ActivityManager.RunningAppProcessInfo) obj).uid == i) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(k.U(arrayList));
        int size2 = arrayList.size();
        while (i10 < size2) {
            Object obj2 = arrayList.get(i10);
            i10++;
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) obj2;
            y0 y0Var = new y0();
            String str2 = runningAppProcessInfo.processName;
            if (str2 == null) {
                throw new NullPointerException("Null processName");
            }
            y0Var.f14071a = str2;
            y0Var.f14072b = runningAppProcessInfo.pid;
            byte b10 = (byte) (y0Var.f14075e | 1);
            y0Var.f14073c = runningAppProcessInfo.importance;
            y0Var.f14075e = (byte) (b10 | 2);
            y0Var.f14074d = h.a(str2, str);
            y0Var.f14075e = (byte) (y0Var.f14075e | 4);
            arrayList2.add(y0Var.a());
        }
        return arrayList2;
    }

    public boolean a(int i) {
        return 4 <= i || Log.isLoggable("FirebaseCrashlytics", i);
    }

    public void b(String str) {
        if (a(3)) {
            Log.d("FirebaseCrashlytics", str, null);
        }
    }

    public c2 d(Context context) {
        Object obj;
        String processName;
        h.e(context, "context");
        int iMyPid = Process.myPid();
        ArrayList arrayListC = c(context);
        int size = arrayListC.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = arrayListC.get(i);
            i++;
            if (((z0) ((c2) obj)).f14079b == iMyPid) {
                break;
            }
        }
        c2 c2Var = (c2) obj;
        if (c2Var != null) {
            return c2Var;
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 33) {
            processName = Process.myProcessName();
            h.d(processName, "{\n      Process.myProcessName()\n    }");
        } else if (i10 < 28 || (processName = Application.getProcessName()) == null) {
            processName = "";
        }
        h.e(processName, "processName");
        y0 y0Var = new y0();
        y0Var.f14071a = processName;
        y0Var.f14072b = iMyPid;
        byte b10 = (byte) (y0Var.f14075e | 1);
        y0Var.f14073c = 0;
        y0Var.f14074d = false;
        y0Var.f14075e = (byte) (((byte) (b10 | 2)) | 4);
        return y0Var.a();
    }

    public void e(String str) {
        if (a(2)) {
            Log.v("FirebaseCrashlytics", str, null);
        }
    }

    public void f(String str, Exception exc) {
        if (a(5)) {
            Log.w("FirebaseCrashlytics", str, exc);
        }
    }
}
