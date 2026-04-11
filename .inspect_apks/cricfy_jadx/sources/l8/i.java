package l8;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import java.io.File;
import java.util.concurrent.CopyOnWriteArraySet;
import l4.c0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements s7.g {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static i f7896x;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f7897v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile Object f7898w;

    public /* synthetic */ i(Object obj) {
        this.f7897v = obj;
    }

    public static i b(Context context) {
        o8.u.g(context);
        synchronized (i.class) {
            try {
                if (f7896x == null) {
                    r.a(context);
                    f7896x = new i(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f7896x;
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x00f6, code lost:
    
        r5 = r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean d(android.content.pm.PackageInfo r12, boolean r13) {
        /*
            Method dump skipped, instruction units count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l8.i.d(android.content.pm.PackageInfo, boolean):boolean");
    }

    public static n e(PackageInfo packageInfo, n... nVarArr) {
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

    public b7.a a() {
        if (((b7.a) this.f7898w) == null) {
            synchronized (this) {
                try {
                    if (((b7.a) this.f7898w) == null) {
                        File cacheDir = ((b7.e) ((p6.c) this.f7897v).f10035w).f1830a.getCacheDir();
                        b7.d dVar = null;
                        File file = cacheDir == null ? null : new File(cacheDir, "image_manager_disk_cache");
                        if (file != null && (file.isDirectory() || file.mkdirs())) {
                            dVar = new b7.d();
                            dVar.f1828y = new c0(9);
                            dVar.f1827x = file;
                            dVar.f1825v = 262144000L;
                            dVar.f1826w = new c0(10);
                        }
                        this.f7898w = dVar;
                    }
                    if (((b7.a) this.f7898w) == null) {
                        this.f7898w = new fc.e(5);
                    }
                } finally {
                }
            }
        }
        return (b7.a) this.f7898w;
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x01d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean c(int r18) {
        /*
            Method dump skipped, instruction units count: 541
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l8.i.c(int):boolean");
    }

    @Override // s7.g
    public Object get() {
        if (this.f7898w == null) {
            synchronized (this) {
                try {
                    if (this.f7898w == null) {
                        Object obj = ((s7.g) this.f7897v).get();
                        s7.f.c(obj, "Argument must not be null");
                        this.f7898w = obj;
                    }
                } finally {
                }
            }
        }
        return this.f7898w;
    }

    public i(Context context) {
        this.f7897v = context.getApplicationContext();
    }

    public i() {
        this.f7897v = new CopyOnWriteArraySet();
    }
}
