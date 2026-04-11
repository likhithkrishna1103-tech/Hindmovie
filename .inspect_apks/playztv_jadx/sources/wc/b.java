package wc;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Process;
import e6.j;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f14093a;

    public /* synthetic */ b(Context context) {
        this.f14093a = context;
    }

    public static boolean a(String str) {
        boolean z2 = false;
        for (String str2 : a.a()) {
            String strM = j.m(str2, str);
            if (new File(str2, str).exists()) {
                ga.b.I(strM + " binary detected!");
                z2 = true;
            }
        }
        return z2;
    }

    public ApplicationInfo b(String str, int i) {
        return this.f14093a.getPackageManager().getApplicationInfo(str, i);
    }

    public PackageInfo c(String str, int i) {
        return this.f14093a.getPackageManager().getPackageInfo(str, i);
    }

    public boolean d(ArrayList arrayList) {
        PackageManager packageManager = this.f14093a.getPackageManager();
        int size = arrayList.size();
        boolean z2 = false;
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            String str = (String) obj;
            try {
                packageManager.getPackageInfo(str, 0);
                ga.b.k(str + " ROOT management app detected!");
                z2 = true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return z2;
    }

    public boolean e() {
        String nameForUid;
        int callingUid = Binder.getCallingUid();
        int iMyUid = Process.myUid();
        Context context = this.f14093a;
        if (callingUid == iMyUid) {
            return z7.a.q(context);
        }
        if (!x7.b.d() || (nameForUid = context.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return context.getPackageManager().isInstantApp(nameForUid);
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x022a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean f() {
        /*
            Method dump skipped, instruction units count: 557
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: wc.b.f():boolean");
    }
}
