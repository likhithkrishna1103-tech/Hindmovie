package p6;

import a3.k;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.n0;
import androidx.fragment.app.r0;
import d1.t;
import f9.b4;
import f9.f1;
import f9.f2;
import f9.h;
import f9.j2;
import f9.r1;
import f9.w0;
import f9.x2;
import j2.i;
import j9.f;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import ka.j;
import l0.e;
import nb.w;
import o.h1;
import o.m3;
import rd.l;
import t0.m0;
import t0.m1;
import t0.o;
import t0.p1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements e.b, se.c, z7.b, o, h1, m3, f, i {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f10034v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f10035w;

    public /* synthetic */ c(int i, Object obj) {
        this.f10034v = i;
        this.f10035w = obj;
    }

    public static String n(String str, b bVar, boolean z10) {
        String strConcat = bVar.f10033v;
        if (z10) {
            strConcat = ".temp".concat(strConcat);
        }
        String strReplaceAll = str.replaceAll("\\W+", "");
        int length = 242 - strConcat.length();
        if (strReplaceAll.length() > length) {
            try {
                byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(strReplaceAll.getBytes());
                StringBuilder sb = new StringBuilder();
                for (byte b8 : bArrDigest) {
                    sb.append(String.format("%02x", Byte.valueOf(b8)));
                }
                strReplaceAll = sb.toString();
            } catch (NoSuchAlgorithmException unused) {
                strReplaceAll = strReplaceAll.substring(0, length);
            }
        }
        return e.k("lottie_cache_", strReplaceAll, strConcat);
    }

    public void A(long j4) {
        b4 b4Var = (b4) this.f10035w;
        b4Var.m1();
        r1 r1Var = (r1) b4Var.f307w;
        if (r1Var.a()) {
            f1 f1Var = r1Var.f4367z;
            r1.e(f1Var);
            f1Var.L.e(j4);
            r1Var.F.getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.J.b(Long.valueOf(jElapsedRealtime), "Session started, time");
            long j7 = j4 / 1000;
            Long lValueOf = Long.valueOf(j7);
            x2 x2Var = r1Var.H;
            r1.f(x2Var);
            x2Var.x1(j4, lValueOf, "auto", "_sid");
            r1.e(f1Var);
            f1Var.M.e(j7);
            f1Var.H.b(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", j7);
            r1.f(x2Var);
            x2Var.u1(j4, bundle, "auto", "_s");
            String strR = f1Var.R.r();
            if (TextUtils.isEmpty(strR)) {
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("_ffr", strR);
            r1.f(x2Var);
            x2Var.u1(j4, bundle2, "auto", "_ssr");
        }
    }

    public void B(f2 f2Var, h hVar) {
        ((EnumMap) this.f10035w).put(f2Var, hVar);
    }

    @Override // j9.f
    public void a(Object obj) {
        ((j9.i) ((c) this.f10035w).f10035w).f6688a.o();
    }

    @Override // j2.i
    public long b(long j4) {
        return 0L;
    }

    @Override // j2.i
    public long c(long j4, long j7) {
        return 0L;
    }

    public void d(k kVar) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.f10035w;
        long[] jArr = kVar.f206e;
        if (jArr.length <= 0 || linkedHashMap.containsKey(Long.valueOf(jArr[0]))) {
            return;
        }
        linkedHashMap.put(Long.valueOf(kVar.f206e[0]), kVar);
    }

    public ka.d e(ka.d dVar) {
        return dVar instanceof j ? dVar : new ka.b(-((ka.i) this.f10035w).j(), dVar);
    }

    public String g(Object obj) {
        StringWriter stringWriter = new StringWriter();
        try {
            cc.d dVar = (cc.d) this.f10035w;
            cc.e eVar = new cc.e(stringWriter, dVar.f2133a, dVar.f2134b, dVar.f2135c, dVar.f2136d);
            eVar.h(obj);
            eVar.j();
            eVar.f2138b.flush();
        } catch (IOException unused) {
        }
        return stringWriter.toString();
    }

    @Override // qd.a
    public Object get() {
        return new e8.k(Integer.valueOf(e8.k.f3848y).intValue(), (Context) ((qd.a) this.f10035w).get(), "com.google.android.datatransport.events");
    }

    @Override // j2.i
    public long h(long j4, long j7) {
        return 0L;
    }

    @Override // e.b
    public void i(Object obj) {
        Map map = (Map) obj;
        r0 r0Var = (r0) this.f10035w;
        ArrayList arrayList = new ArrayList(map.values());
        int[] iArr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            iArr[i] = ((Boolean) arrayList.get(i)).booleanValue() ? 0 : -1;
        }
        n0 n0Var = (n0) r0Var.D.pollFirst();
        if (n0Var == null) {
            Log.w("FragmentManager", "No permissions were requested for " + this);
        } else {
            String str = n0Var.f1024v;
            if (r0Var.f1046c.k(str) == null) {
                Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
            }
        }
    }

    @Override // t0.o
    public p1 k(View view, p1 p1Var) {
        m1 m1Var = p1Var.f11791a;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f10035w;
        if (!Objects.equals(coordinatorLayout.I, p1Var)) {
            coordinatorLayout.I = p1Var;
            boolean z10 = p1Var.d() > 0;
            coordinatorLayout.J = z10;
            coordinatorLayout.setWillNotDraw(!z10 && coordinatorLayout.getBackground() == null);
            if (!m1Var.n()) {
                int childCount = coordinatorLayout.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = coordinatorLayout.getChildAt(i);
                    WeakHashMap weakHashMap = m0.f11777a;
                    if (childAt.getFitsSystemWindows() && ((f0.e) childAt.getLayoutParams()).f3897a != null && m1Var.n()) {
                        break;
                    }
                }
            }
            coordinatorLayout.requestLayout();
        }
        return p1Var;
    }

    @Override // j2.i
    public long l(long j4, long j7) {
        return -9223372036854775807L;
    }

    @Override // j2.i
    public k2.j m(long j4) {
        return (k2.j) this.f10035w;
    }

    @Override // j2.i
    public boolean o() {
        return true;
    }

    public File p(String str) {
        File file = new File(r(), n(str, b.f10029w, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(r(), n(str, b.f10030x, false));
        if (file2.exists()) {
            return file2;
        }
        File file3 = new File(r(), n(str, b.f10031y, false));
        if (file3.exists()) {
            return file3;
        }
        return null;
    }

    @Override // j2.i
    public long q() {
        return 0L;
    }

    public File r() {
        File file = new File(((Context) ((androidx.fragment.app.f1) this.f10035w).f986w).getCacheDir(), "lottie_network_cache");
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public File s(String str, InputStream inputStream, b bVar) throws IOException {
        File file = new File(r(), n(str, bVar, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return file;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } finally {
            inputStream.close();
        }
    }

    public void t() {
        b4 b4Var = (b4) this.f10035w;
        b4Var.m1();
        r1 r1Var = (r1) b4Var.f307w;
        f1 f1Var = r1Var.f4367z;
        r1.e(f1Var);
        s8.a aVar = r1Var.F;
        aVar.getClass();
        if (f1Var.w1(System.currentTimeMillis())) {
            f1 f1Var2 = r1Var.f4367z;
            r1.e(f1Var2);
            f1Var2.H.b(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                w0 w0Var = r1Var.A;
                r1.g(w0Var);
                w0Var.J.a("Detected application was in foreground");
                aVar.getClass();
                A(System.currentTimeMillis());
            }
        }
    }

    public String toString() {
        switch (this.f10034v) {
            case 11:
                StringBuilder sb = new StringBuilder("1");
                for (f2 f2Var : f2.values()) {
                    h hVar = (h) ((EnumMap) this.f10035w).get(f2Var);
                    if (hVar == null) {
                        hVar = h.UNSET;
                    }
                    sb.append(hVar.f4201v);
                }
                return sb.toString();
            default:
                return super.toString();
        }
    }

    @Override // j2.i
    public long u(long j4) {
        return 1L;
    }

    public boolean v() {
        w0 w0Var = ((r1) this.f10035w).A;
        r1.g(w0Var);
        return Log.isLoggable(w0Var.w1(), 3);
    }

    @Override // j2.i
    public long w(long j4, long j7) {
        return 1L;
    }

    public void x(long j4) {
        b4 b4Var = (b4) this.f10035w;
        b4Var.m1();
        b4Var.q1();
        r1 r1Var = (r1) b4Var.f307w;
        f1 f1Var = r1Var.f4367z;
        r1.e(f1Var);
        if (f1Var.w1(j4)) {
            r1.e(f1Var);
            f1Var.H.b(true);
            r1Var.l().r1();
        }
        r1.e(f1Var);
        f1Var.L.e(j4);
        if (f1Var.H.a()) {
            A(j4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void y(f9.f2 r2, int r3) {
        /*
            r1 = this;
            r0 = -30
            if (r3 == r0) goto L1e
            r0 = -20
            if (r3 == r0) goto L1b
            r0 = -10
            if (r3 == r0) goto L18
            if (r3 == 0) goto L1b
            r0 = 30
            if (r3 == r0) goto L15
            f9.h r3 = f9.h.UNSET
            goto L20
        L15:
            f9.h r3 = f9.h.INITIALIZATION
            goto L20
        L18:
            f9.h r3 = f9.h.MANIFEST
            goto L20
        L1b:
            f9.h r3 = f9.h.API
            goto L20
        L1e:
            f9.h r3 = f9.h.TCF
        L20:
            java.lang.Object r0 = r1.f10035w
            java.util.EnumMap r0 = (java.util.EnumMap) r0
            r0.put(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p6.c.y(f9.f2, int):void");
    }

    @Override // se.c
    public Object z(se.d dVar, xd.c cVar) {
        Object objZ = ((w) this.f10035w).z(new t(0, dVar), cVar);
        return objZ == wd.a.f14143v ? objZ : l.f11003a;
    }

    public c(j2 j2Var, r1 r1Var) {
        this.f10034v = 13;
        this.f10035w = r1Var;
    }

    public c(d dVar, i2.k kVar) {
        this.f10034v = 15;
        this.f10035w = kVar;
        dVar.s(new fb.b(1, this));
    }

    public c(pc.c cVar, c cVar2) {
        this.f10034v = 23;
        this.f10035w = cVar2;
        Objects.requireNonNull(cVar);
    }

    public c(EnumMap enumMap) {
        this.f10034v = 11;
        EnumMap enumMap2 = new EnumMap(f2.class);
        this.f10035w = enumMap2;
        enumMap2.putAll(enumMap);
    }

    public c(Context context) {
        this.f10034v = 5;
        this.f10035w = new b7.e(context);
    }

    public c(int i) {
        this.f10034v = i;
        switch (i) {
            case 11:
                this.f10035w = new EnumMap(f2.class);
                break;
            case 16:
                this.f10035w = new ConcurrentHashMap(16);
                break;
            case 17:
                this.f10035w = new HashSet();
                break;
            default:
                this.f10035w = new LinkedHashMap();
                break;
        }
    }

    @Override // j2.i
    public long f(long j4, long j7) {
        return j7;
    }
}
