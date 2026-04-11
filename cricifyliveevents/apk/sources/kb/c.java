package kb;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import ge.i;
import java.util.ArrayList;
import java.util.List;
import qb.c2;
import qb.y0;
import qb.z0;
import sd.l;
import sd.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f7396a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f7397b = new c();

    public static ArrayList c(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        i.e(context, "context");
        int i = context.getApplicationInfo().uid;
        String str = context.getApplicationInfo().processName;
        Object systemService = context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            runningAppProcesses = p.f11669v;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : runningAppProcesses) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (i11 < size) {
            Object obj2 = arrayList.get(i11);
            i11++;
            if (((ActivityManager.RunningAppProcessInfo) obj2).uid == i) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList(l.f0(arrayList2, 10));
        int size2 = arrayList2.size();
        while (i10 < size2) {
            Object obj3 = arrayList2.get(i10);
            i10++;
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) obj3;
            y0 y0Var = new y0();
            String str2 = runningAppProcessInfo.processName;
            if (str2 == null) {
                throw new NullPointerException("Null processName");
            }
            y0Var.f10774a = str2;
            y0Var.f10775b = runningAppProcessInfo.pid;
            byte b8 = (byte) (y0Var.f10778e | 1);
            y0Var.f10776c = runningAppProcessInfo.importance;
            y0Var.f10778e = (byte) (b8 | 2);
            y0Var.f10777d = i.a(str2, str);
            y0Var.f10778e = (byte) (y0Var.f10778e | 4);
            arrayList3.add(y0Var.a());
        }
        return arrayList3;
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
        i.e(context, "context");
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
            if (((z0) ((c2) obj)).f10782b == iMyPid) {
                break;
            }
        }
        c2 c2Var = (c2) obj;
        if (c2Var != null) {
            return c2Var;
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 > 33) {
            processName = Process.myProcessName();
            i.b(processName);
        } else if (i10 < 28 || (processName = Application.getProcessName()) == null) {
            processName = "";
        }
        i.e(processName, "processName");
        y0 y0Var = new y0();
        y0Var.f10774a = processName;
        y0Var.f10775b = iMyPid;
        byte b8 = (byte) (y0Var.f10778e | 1);
        y0Var.f10776c = 0;
        y0Var.f10777d = false;
        y0Var.f10778e = (byte) (((byte) (b8 | 2)) | 4);
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
