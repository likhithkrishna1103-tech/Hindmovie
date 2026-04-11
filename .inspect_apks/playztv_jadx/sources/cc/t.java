package cc;

import android.app.Application;
import android.os.Build;
import android.os.Process;
import android.util.Base64;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f2711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f2712b;

    static {
        String strB;
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            strB = Process.myProcessName();
            be.h.d(strB, "myProcessName()");
        } else if ((i < 28 || (strB = Application.getProcessName()) == null) && (strB = x7.b.b()) == null) {
            strB = "";
        }
        byte[] bytes = strB.getBytes(ie.a.f6599a);
        be.h.d(bytes, "getBytes(...)");
        String strEncodeToString = Base64.encodeToString(bytes, 10);
        f2711a = e6.j.n("firebase_session_", strEncodeToString, "_data");
        f2712b = e6.j.n("firebase_session_", strEncodeToString, "_settings");
    }
}
