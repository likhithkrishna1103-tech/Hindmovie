package vc;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f13692a = new q(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q f13693b = new q(2);

    public static ArrayList a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ge.i.e(context, "context");
        int i = context.getApplicationInfo().uid;
        String str = context.getApplicationInfo().processName;
        Object systemService = context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            runningAppProcesses = sd.p.f11669v;
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
        ArrayList arrayList3 = new ArrayList(sd.l.f0(arrayList2, 10));
        int size2 = arrayList2.size();
        while (i10 < size2) {
            Object obj3 = arrayList2.get(i10);
            i10++;
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) obj3;
            String str2 = runningAppProcessInfo.processName;
            ge.i.d(str2, "processName");
            arrayList3.add(new d0(str2, runningAppProcessInfo.pid, runningAppProcessInfo.importance, ge.i.a(runningAppProcessInfo.processName, str)));
        }
        return arrayList3;
    }

    public static d0 b(Context context) {
        Object obj;
        String strB;
        ge.i.e(context, "context");
        int iMyPid = Process.myPid();
        ArrayList arrayListA = a(context);
        int size = arrayListA.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = arrayListA.get(i);
            i++;
            if (((d0) obj).f13599b == iMyPid) {
                break;
            }
        }
        d0 d0Var = (d0) obj;
        if (d0Var != null) {
            return d0Var;
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 > 33) {
            strB = Process.myProcessName();
            ge.i.d(strB, "myProcessName(...)");
        } else if ((i10 < 28 || (strB = Application.getProcessName()) == null) && (strB = s8.b.b()) == null) {
            strB = "";
        }
        return new d0(strB, iMyPid, 0, false);
    }
}
