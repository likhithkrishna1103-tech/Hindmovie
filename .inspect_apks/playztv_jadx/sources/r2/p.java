package r2;

import a2.x0;
import aa.a1;
import aa.c1;
import aa.j0;
import android.content.Context;
import android.media.Spatializer;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.RandomAccess;
import k8.z;
import o2.n1;
import p1.g1;
import p1.h1;
import p1.j1;
import p1.l1;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p extends u {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a1 f11341k = new aa.v(new c4.d(10));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f11342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f11343d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final z f11344e;
    public j f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Thread f11345g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a2.c f11346h;
    public p1.d i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Boolean f11347j;

    public p(Context context, z zVar) {
        j jVar = j.f11320y0;
        this.f11342c = new Object();
        this.f11343d = context != null ? context.getApplicationContext() : null;
        this.f11344e = zVar;
        if (jVar != null) {
            this.f = jVar;
        } else {
            jVar.getClass();
            i iVar = new i(jVar);
            iVar.e(jVar);
            this.f = new j(iVar);
        }
        this.i = p1.d.f9682h;
        if (this.f.f11327t0 && context == null) {
            s1.b.p("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }

    public static void c(n1 n1Var, j jVar, HashMap map) {
        for (int i = 0; i < n1Var.f9178a; i++) {
            h1 h1Var = (h1) jVar.D.get(n1Var.a(i));
            if (h1Var != null) {
                g1 g1Var = h1Var.f9783a;
                h1 h1Var2 = (h1) map.get(Integer.valueOf(g1Var.f9764c));
                if (h1Var2 == null || (h1Var2.f9784b.isEmpty() && !h1Var.f9784b.isEmpty())) {
                    map.put(Integer.valueOf(g1Var.f9764c), h1Var);
                }
            }
        }
    }

    public static int d(p1.q qVar, String str, boolean z2) {
        if (!TextUtils.isEmpty(str) && str.equals(qVar.f10015d)) {
            return 4;
        }
        String strG = g(str);
        String strG2 = g(qVar.f10015d);
        if (strG2 == null || strG == null) {
            return (z2 && strG2 == null) ? 1 : 0;
        }
        if (strG2.startsWith(strG) || strG.startsWith(strG2)) {
            return 3;
        }
        int i = b0.f11647a;
        return strG2.split("-", 2)[0].equals(strG.split("-", 2)[0]) ? 2 : 0;
    }

    public static String g(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    public static boolean i(j jVar, int i, p1.q qVar) {
        if ((i & 3584) == 0) {
            return false;
        }
        j1 j1Var = jVar.f9929u;
        if (j1Var.f9865c && (i & 2048) == 0) {
            return false;
        }
        if (j1Var.f9864b) {
            boolean z2 = (qVar.I == 0 && qVar.J == 0) ? false : true;
            boolean z10 = (i & 1024) != 0;
            if (z2 && !z10) {
                return false;
            }
        }
        return true;
    }

    public static Pair j(int i, t tVar, int[][][] iArr, m mVar, Comparator comparator) {
        int i10;
        RandomAccess randomAccessV;
        t tVar2 = tVar;
        ArrayList arrayList = new ArrayList();
        int i11 = tVar2.f11350a;
        int i12 = 0;
        while (i12 < i11) {
            if (i == tVar2.f11351b[i12]) {
                n1 n1Var = tVar2.f11352c[i12];
                for (int i13 = 0; i13 < n1Var.f9178a; i13++) {
                    g1 g1VarA = n1Var.a(i13);
                    c1 c1VarG = mVar.g(i12, g1VarA, iArr[i12][i13]);
                    int i14 = g1VarA.f9762a;
                    boolean[] zArr = new boolean[i14];
                    int i15 = 0;
                    while (i15 < i14) {
                        n nVar = (n) c1VarG.get(i15);
                        int iA = nVar.a();
                        if (zArr[i15] || iA == 0) {
                            i10 = i11;
                        } else {
                            if (iA == 1) {
                                randomAccessV = j0.v(nVar);
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(nVar);
                                int i16 = i15 + 1;
                                while (i16 < i14) {
                                    n nVar2 = (n) c1VarG.get(i16);
                                    int i17 = i11;
                                    if (nVar2.a() == 2 && nVar.b(nVar2)) {
                                        arrayList2.add(nVar2);
                                        zArr[i16] = true;
                                    }
                                    i16++;
                                    i11 = i17;
                                }
                                randomAccessV = arrayList2;
                            }
                            i10 = i11;
                            arrayList.add(randomAccessV);
                        }
                        i15++;
                        i11 = i10;
                    }
                }
            }
            i12++;
            tVar2 = tVar;
            i11 = i11;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i18 = 0; i18 < list.size(); i18++) {
            iArr2[i18] = ((n) list.get(i18)).f11337w;
        }
        n nVar3 = (n) list.get(0);
        return Pair.create(new q(0, nVar3.f11336v, iArr2), Integer.valueOf(nVar3.f11335u));
    }

    @Override // r2.u
    public final void a() {
        a2.c cVar;
        k kVar;
        synchronized (this.f11342c) {
            try {
                Thread thread = this.f11345g;
                if (thread != null) {
                    s1.d.f("DefaultTrackSelector is accessed on the wrong thread.", thread == Thread.currentThread());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (Build.VERSION.SDK_INT >= 32 && (cVar = this.f11346h) != null) {
            Handler handler = (Handler) cVar.f174w;
            Spatializer spatializer = (Spatializer) cVar.f173v;
            if (spatializer != null && (kVar = (k) cVar.f175x) != null && handler != null) {
                spatializer.removeOnSpatializerStateChangedListener(kVar);
                handler.removeCallbacksAndMessages(null);
            }
            this.f11346h = null;
        }
        this.f11355a = null;
        this.f11356b = null;
    }

    @Override // r2.u
    public final void b(l1 l1Var) {
        if (l1Var instanceof j) {
            k((j) l1Var);
        }
        i iVar = new i(e());
        iVar.e(l1Var);
        k(new j(iVar));
    }

    public final j e() {
        j jVar;
        synchronized (this.f11342c) {
            jVar = this.f;
        }
        return jVar;
    }

    public final void f() {
        boolean z2;
        x0 x0Var;
        a2.c cVar;
        synchronized (this.f11342c) {
            try {
                z2 = this.f.f11327t0 && Build.VERSION.SDK_INT >= 32 && (cVar = this.f11346h) != null && cVar.f172u;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z2 || (x0Var = this.f11355a) == null) {
            return;
        }
        x0Var.B.e(10);
    }

    public final void h() {
        synchronized (this.f11342c) {
            this.f.getClass();
        }
    }

    public final void k(j jVar) {
        boolean zEquals;
        jVar.getClass();
        synchronized (this.f11342c) {
            zEquals = this.f.equals(jVar);
            this.f = jVar;
        }
        if (zEquals) {
            return;
        }
        if (jVar.f11327t0 && this.f11343d == null) {
            s1.b.p("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
        x0 x0Var = this.f11355a;
        if (x0Var != null) {
            x0Var.B.e(10);
        }
    }
}
