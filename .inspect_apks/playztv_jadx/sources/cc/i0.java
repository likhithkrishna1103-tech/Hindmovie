package cc;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i0 f2660a = new i0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final u5.d f2661b;

    static {
        ib.d dVar = new ib.d();
        dVar.a(h0.class, g.f2638a);
        dVar.a(p0.class, h.f2646a);
        dVar.a(j.class, e.f2622a);
        dVar.a(b.class, d.f2614a);
        dVar.a(a.class, c.f2606a);
        dVar.a(s.class, f.f2628a);
        dVar.f6481d = true;
        f2661b = new u5.d(17, dVar);
    }

    public static b a(ga.g gVar) {
        Object obj;
        String strB;
        gVar.a();
        Context context = gVar.f5346a;
        be.h.d(context, "firebaseApp.applicationContext");
        String packageName = context.getPackageName();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        String strValueOf = Build.VERSION.SDK_INT >= 28 ? String.valueOf(packageInfo.getLongVersionCode()) : String.valueOf(packageInfo.versionCode);
        gVar.a();
        String str = gVar.f5348c.f5360b;
        be.h.d(str, "firebaseApp.options.applicationId");
        be.h.d(Build.MODEL, "MODEL");
        be.h.d(Build.VERSION.RELEASE, "RELEASE");
        be.h.d(packageName, "packageName");
        String str2 = packageInfo.versionName;
        if (str2 == null) {
            str2 = strValueOf;
        }
        be.h.d(Build.MANUFACTURER, "MANUFACTURER");
        gVar.a();
        int iMyPid = Process.myPid();
        ArrayList arrayListA = z.a(context);
        int size = arrayListA.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = arrayListA.get(i);
            i++;
            if (((s) obj).f2707b == iMyPid) {
                break;
            }
        }
        s sVar = (s) obj;
        if (sVar == null) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 33) {
                strB = Process.myProcessName();
                be.h.d(strB, "myProcessName()");
            } else if ((i10 < 28 || (strB = Application.getProcessName()) == null) && (strB = x7.b.b()) == null) {
                strB = "";
            }
            sVar = new s(iMyPid, 0, strB, false);
        }
        gVar.a();
        return new b(str, new a(packageName, str2, strValueOf, sVar, z.a(context)));
    }
}
