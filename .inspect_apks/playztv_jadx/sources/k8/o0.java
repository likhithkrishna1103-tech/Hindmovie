package k8;

import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o0 implements Runnable {
    public final Object A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7342u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f7343v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f7344w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f7345x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Object f7346y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Object f7347z;

    public o0(String str, u0 u0Var, int i, IOException iOException, byte[] bArr, Map map) {
        t7.v.h(u0Var);
        this.f7345x = u0Var;
        this.f7343v = i;
        this.f7346y = iOException;
        this.f7347z = bArr;
        this.f7344w = str;
        this.A = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7342u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                z0 z0Var = ((k1) ((p0) this.A).f2454v).B;
                k1.d(z0Var);
                if (!z0Var.f7539w) {
                    Log.println(6, ((p0) this.A).D1(), "Persisted config not initialized. Not logging error/warn");
                    return;
                }
                p0 p0Var = (p0) this.A;
                if (p0Var.f7362x == 0) {
                    e eVar = ((k1) p0Var.f2454v).A;
                    if (eVar.f7147z == null) {
                        synchronized (eVar) {
                            try {
                                if (eVar.f7147z == null) {
                                    ApplicationInfo applicationInfo = ((k1) eVar.f2454v).f7282u.getApplicationInfo();
                                    String strB = x7.b.b();
                                    if (applicationInfo != null) {
                                        String str = applicationInfo.processName;
                                        eVar.f7147z = Boolean.valueOf(str != null && str.equals(strB));
                                    }
                                    if (eVar.f7147z == null) {
                                        eVar.f7147z = Boolean.TRUE;
                                        eVar.g().A.d("My process not in the list of running processes");
                                    }
                                }
                            } finally {
                            }
                        }
                    }
                    if (eVar.f7147z.booleanValue()) {
                        ((p0) this.A).f7362x = 'C';
                    } else {
                        ((p0) this.A).f7362x = 'c';
                    }
                    break;
                }
                p0 p0Var2 = (p0) this.A;
                if (p0Var2.f7363y < 0) {
                    p0Var2.f7363y = 106000L;
                }
                char cCharAt = "01VDIWEA?".charAt(this.f7343v);
                p0 p0Var3 = (p0) this.A;
                char c9 = p0Var3.f7362x;
                long j5 = p0Var3.f7363y;
                String strU1 = p0.u1(true, this.f7344w, this.f7345x, this.f7346y, this.f7347z);
                StringBuilder sb2 = new StringBuilder("2");
                sb2.append(cCharAt);
                sb2.append(c9);
                sb2.append(j5);
                String strO = l4.a.o(sb2, ":", strU1);
                if (strO.length() > 1024) {
                    strO = this.f7344w.substring(0, 1024);
                }
                g4.k0 k0Var = z0Var.A;
                if (k0Var != null) {
                    String str2 = (String) k0Var.f5099w;
                    String str3 = (String) k0Var.f5097u;
                    z0 z0Var2 = (z0) k0Var.f5101y;
                    z0Var2.p1();
                    if (((z0) k0Var.f5101y).x1().getLong((String) k0Var.f5098v, 0L) == 0) {
                        k0Var.z();
                    }
                    if (strO == null) {
                        strO = "";
                    }
                    long j8 = z0Var2.x1().getLong(str3, 0L);
                    if (j8 <= 0) {
                        SharedPreferences.Editor editorEdit = z0Var2.x1().edit();
                        editorEdit.putString(str2, strO);
                        editorEdit.putLong(str3, 1L);
                        editorEdit.apply();
                        return;
                    }
                    long j10 = j8 + 1;
                    boolean z2 = (z0Var2.o1().D2().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / j10;
                    SharedPreferences.Editor editorEdit2 = z0Var2.x1().edit();
                    if (z2) {
                        editorEdit2.putString(str2, strO);
                    }
                    editorEdit2.putLong(str3, j10);
                    editorEdit2.apply();
                    return;
                }
                return;
            default:
                ((u0) this.f7345x).k(this.f7344w, this.f7343v, (Throwable) this.f7346y, (byte[]) this.f7347z, (Map) this.A);
                return;
        }
    }

    public o0(p0 p0Var, int i, String str, Object obj, Object obj2, Object obj3) {
        this.f7343v = i;
        this.f7344w = str;
        this.f7345x = obj;
        this.f7346y = obj2;
        this.f7347z = obj3;
        this.A = p0Var;
    }
}
