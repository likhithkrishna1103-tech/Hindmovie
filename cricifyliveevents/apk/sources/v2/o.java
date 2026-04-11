package v2;

import android.content.Context;
import android.media.Spatializer;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import f9.c0;
import g2.o0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.RandomAccess;
import s2.l1;
import ua.i0;
import ua.v;
import ua.x0;
import ua.z0;
import v1.g1;
import v1.h1;
import v1.j1;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o extends t {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final x0 f13112k = new v(new g4.d(12));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f13113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f13114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c0 f13115e;
    public i f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Thread f13116g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bumptech.glide.l f13117h;
    public v1.c i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Boolean f13118j;

    public o(Context context, c0 c0Var) {
        i iVar = i.f13094y0;
        this.f13113c = new Object();
        this.f13114d = context != null ? context.getApplicationContext() : null;
        this.f13115e = c0Var;
        if (iVar != null) {
            this.f = iVar;
        } else {
            iVar.getClass();
            h hVar = new h(iVar);
            hVar.e(iVar);
            this.f = new i(hVar);
        }
        this.i = v1.c.f12586h;
        if (this.f.f13100t0 && context == null) {
            y1.b.p("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }

    public static void c(l1 l1Var, i iVar, HashMap map) {
        for (int i = 0; i < l1Var.f11262a; i++) {
            h1 h1Var = (h1) iVar.D.get(l1Var.a(i));
            if (h1Var != null) {
                g1 g1Var = h1Var.f12711a;
                h1 h1Var2 = (h1) map.get(Integer.valueOf(g1Var.f12704c));
                if (h1Var2 == null || (h1Var2.f12712b.isEmpty() && !h1Var.f12712b.isEmpty())) {
                    map.put(Integer.valueOf(g1Var.f12704c), h1Var);
                }
            }
        }
    }

    public static int d(v1.p pVar, String str, boolean z10) {
        if (!TextUtils.isEmpty(str) && str.equals(pVar.f12938d)) {
            return 4;
        }
        String strG = g(str);
        String strG2 = g(pVar.f12938d);
        if (strG2 == null || strG == null) {
            return (z10 && strG2 == null) ? 1 : 0;
        }
        if (strG2.startsWith(strG) || strG.startsWith(strG2)) {
            return 3;
        }
        int i = a0.f14551a;
        return strG2.split("-", 2)[0].equals(strG.split("-", 2)[0]) ? 2 : 0;
    }

    public static String g(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    public static boolean i(i iVar, int i, v1.p pVar) {
        if ((i & 3584) == 0) {
            return false;
        }
        j1 j1Var = iVar.f12862u;
        if (j1Var.f12794c && (i & 2048) == 0) {
            return false;
        }
        if (j1Var.f12793b) {
            boolean z10 = (pVar.I == 0 && pVar.J == 0) ? false : true;
            boolean z11 = (i & 1024) != 0;
            if (z10 && !z11) {
                return false;
            }
        }
        return true;
    }

    public static Pair j(int i, s sVar, int[][][] iArr, l lVar, Comparator comparator) {
        int i10;
        RandomAccess randomAccessO;
        s sVar2 = sVar;
        ArrayList arrayList = new ArrayList();
        int i11 = sVar2.f13121a;
        int i12 = 0;
        while (i12 < i11) {
            if (i == sVar2.f13122b[i12]) {
                l1 l1Var = sVar2.f13123c[i12];
                for (int i13 = 0; i13 < l1Var.f11262a; i13++) {
                    g1 g1VarA = l1Var.a(i13);
                    z0 z0VarB = lVar.b(i12, g1VarA, iArr[i12][i13]);
                    int i14 = g1VarA.f12702a;
                    boolean[] zArr = new boolean[i14];
                    int i15 = 0;
                    while (i15 < i14) {
                        m mVar = (m) z0VarB.get(i15);
                        int iA = mVar.a();
                        if (zArr[i15] || iA == 0) {
                            i10 = i11;
                        } else {
                            if (iA == 1) {
                                randomAccessO = i0.o(mVar);
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(mVar);
                                int i16 = i15 + 1;
                                while (i16 < i14) {
                                    m mVar2 = (m) z0VarB.get(i16);
                                    int i17 = i11;
                                    if (mVar2.a() == 2 && mVar.b(mVar2)) {
                                        arrayList2.add(mVar2);
                                        zArr[i16] = true;
                                    }
                                    i16++;
                                    i11 = i17;
                                }
                                randomAccessO = arrayList2;
                            }
                            i10 = i11;
                            arrayList.add(randomAccessO);
                        }
                        i15++;
                        i11 = i10;
                    }
                }
            }
            i12++;
            sVar2 = sVar;
            i11 = i11;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i18 = 0; i18 < list.size(); i18++) {
            iArr2[i18] = ((m) list.get(i18)).f13109x;
        }
        m mVar3 = (m) list.get(0);
        return Pair.create(new p(0, mVar3.f13108w, iArr2), Integer.valueOf(mVar3.f13107v));
    }

    @Override // v2.t
    public final void a() {
        com.bumptech.glide.l lVar;
        j jVar;
        synchronized (this.f13113c) {
            try {
                Thread thread = this.f13116g;
                if (thread != null) {
                    y1.d.f("DefaultTrackSelector is accessed on the wrong thread.", thread == Thread.currentThread());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (Build.VERSION.SDK_INT >= 32 && (lVar = this.f13117h) != null) {
            Handler handler = (Handler) lVar.f2224x;
            Spatializer spatializer = (Spatializer) lVar.f2223w;
            if (spatializer != null && (jVar = (j) lVar.f2225y) != null && handler != null) {
                spatializer.removeOnSpatializerStateChangedListener(jVar);
                handler.removeCallbacksAndMessages(null);
            }
            this.f13117h = null;
        }
        this.f13126a = null;
        this.f13127b = null;
    }

    @Override // v2.t
    public final void b(v1.l1 l1Var) {
        if (l1Var instanceof i) {
            k((i) l1Var);
        }
        h hVar = new h(e());
        hVar.e(l1Var);
        k(new i(hVar));
    }

    public final i e() {
        i iVar;
        synchronized (this.f13113c) {
            iVar = this.f;
        }
        return iVar;
    }

    public final void f() {
        boolean z10;
        o0 o0Var;
        com.bumptech.glide.l lVar;
        synchronized (this.f13113c) {
            try {
                z10 = this.f.f13100t0 && Build.VERSION.SDK_INT >= 32 && (lVar = this.f13117h) != null && lVar.f2222v;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z10 || (o0Var = this.f13126a) == null) {
            return;
        }
        o0Var.C.e(10);
    }

    public final void h() {
        synchronized (this.f13113c) {
            this.f.getClass();
        }
    }

    public final void k(i iVar) {
        boolean zEquals;
        iVar.getClass();
        synchronized (this.f13113c) {
            zEquals = this.f.equals(iVar);
            this.f = iVar;
        }
        if (zEquals) {
            return;
        }
        if (iVar.f13100t0 && this.f13114d == null) {
            y1.b.p("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
        o0 o0Var = this.f13126a;
        if (o0Var != null) {
            o0Var.C.e(10);
        }
    }
}
