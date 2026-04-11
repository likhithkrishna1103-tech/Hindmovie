package q7;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.internal.measurement.k4;
import g4.k0;
import h4.z;
import java.io.File;
import java.util.concurrent.CopyOnWriteArraySet;
import t7.v;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h implements x6.g {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static h f11046w;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Object f11047u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile Object f11048v;

    public /* synthetic */ h(Object obj) {
        this.f11047u = obj;
    }

    public static h b(Context context) {
        v.h(context);
        synchronized (h.class) {
            try {
                if (f11046w == null) {
                    q.a(context);
                    f11046w = new h(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f11046w;
    }

    public static final n d(PackageInfo packageInfo, n... nVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            o oVar = new o(packageInfo.signatures[0].toByteArray());
            for (int i = 0; i < nVarArr.length; i++) {
                if (nVarArr[i].equals(oVar)) {
                    return nVarArr[i];
                }
            }
        }
        return null;
    }

    public static final boolean e(PackageInfo packageInfo, boolean z2) {
        PackageInfo packageInfo2;
        if (!z2) {
            packageInfo2 = packageInfo;
        } else if (packageInfo != null) {
            if ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName)) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                z2 = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
            }
            packageInfo2 = packageInfo;
        } else {
            packageInfo2 = null;
        }
        if (packageInfo != null && packageInfo2.signatures != null) {
            if ((z2 ? d(packageInfo2, p.f11057a) : d(packageInfo2, p.f11057a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    public g6.a a() {
        if (((g6.a) this.f11048v) == null) {
            synchronized (this) {
                try {
                    if (((g6.a) this.f11048v) == null) {
                        File cacheDir = ((c7.k) ((u5.c) this.f11047u).f12782v).f2563u.getCacheDir();
                        k0 k0Var = null;
                        File file = cacheDir == null ? null : new File(cacheDir, "image_manager_disk_cache");
                        if (file != null && (file.isDirectory() || file.mkdirs())) {
                            k0Var = new k0();
                            k0Var.f5099w = new k4(13);
                            k0Var.f5098v = file;
                            k0Var.f5100x = 262144000L;
                            k0Var.f5097u = new z(16);
                        }
                        this.f11048v = k0Var;
                    }
                    if (((g6.a) this.f11048v) == null) {
                        this.f11048v = new lb.e(13);
                    }
                } finally {
                }
            }
        }
        return (g6.a) this.f11048v;
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x01a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean c(int r18) {
        /*
            Method dump skipped, instruction units count: 527
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.h.c(int):boolean");
    }

    @Override // x6.g
    public Object get() {
        if (this.f11048v == null) {
            synchronized (this) {
                try {
                    if (this.f11048v == null) {
                        Object obj = ((x6.g) this.f11047u).get();
                        x6.f.c(obj, "Argument must not be null");
                        this.f11048v = obj;
                    }
                } finally {
                }
            }
        }
        return this.f11048v;
    }

    public h(Context context) {
        this.f11047u = context.getApplicationContext();
    }

    public h() {
        this.f11047u = new CopyOnWriteArraySet();
    }
}
