package cc;

import android.app.Application;
import android.os.Build;
import android.os.Process;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x extends be.i implements ae.l {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final x f2724v = new x(1);

    @Override // ae.l
    public final Object a(Object obj) {
        String strB;
        z0.a aVar = (z0.a) obj;
        be.h.e(aVar, "ex");
        StringBuilder sb2 = new StringBuilder("CorruptionException in sessions DataStore in ");
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            strB = Process.myProcessName();
            be.h.d(strB, "myProcessName()");
        } else if ((i < 28 || (strB = Application.getProcessName()) == null) && (strB = x7.b.b()) == null) {
            strB = "";
        }
        sb2.append(strB);
        sb2.append('.');
        Log.w("FirebaseSessionsRepo", sb2.toString(), aVar);
        return new c1.b(true);
    }
}
