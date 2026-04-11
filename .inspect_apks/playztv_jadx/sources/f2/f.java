package f2;

import a2.g0;
import aa.c1;
import aa.h0;
import aa.j0;
import aa.o0;
import aa.q1;
import android.media.ResourceBusyException;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import cc.q0;
import com.google.android.gms.internal.measurement.k4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import p1.m0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f implements n {
    public final boolean A;
    public final k4 B;
    public final k8.a0 C;
    public final wb.c D;
    public final long E;
    public final ArrayList F;
    public final Set G;
    public final Set H;
    public int I;
    public u J;
    public c K;
    public c L;
    public Looper M;
    public Handler N;
    public byte[] O;
    public b2.o P;
    public volatile q0 Q;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final UUID f4727u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final s f4728v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final z f4729w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final HashMap f4730x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f4731y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int[] f4732z;

    public f(UUID uuid, s sVar, z zVar, HashMap map, boolean z2, int[] iArr, boolean z10, k8.a0 a0Var) {
        uuid.getClass();
        s1.d.a("Use C.CLEARKEY_UUID instead", !p1.g.f9746b.equals(uuid));
        this.f4727u = uuid;
        this.f4728v = sVar;
        this.f4729w = zVar;
        this.f4730x = map;
        this.f4731y = z2;
        this.f4732z = iArr;
        this.A = z10;
        this.C = a0Var;
        this.B = new k4(11);
        this.D = new wb.c(12, this);
        this.F = new ArrayList();
        this.G = Collections.newSetFromMap(new IdentityHashMap());
        this.H = Collections.newSetFromMap(new IdentityHashMap());
        this.E = 300000L;
    }

    public static boolean b(c cVar) {
        cVar.o();
        if (cVar.f4713o != 1) {
            return false;
        }
        g gVarF = cVar.f();
        gVarF.getClass();
        Throwable cause = gVarF.getCause();
        return (cause instanceof ResourceBusyException) || cf.l.w(cause);
    }

    public static ArrayList j(p1.m mVar, UUID uuid, boolean z2) {
        ArrayList arrayList = new ArrayList(mVar.f9938x);
        for (int i = 0; i < mVar.f9938x; i++) {
            p1.l lVar = mVar.f9935u[i];
            if ((lVar.a(uuid) || (p1.g.f9747c.equals(uuid) && lVar.a(p1.g.f9746b))) && (lVar.f9895y != null || z2)) {
                arrayList.add(lVar);
            }
        }
        return arrayList;
    }

    public final h a(Looper looper, k kVar, p1.q qVar, boolean z2) {
        ArrayList arrayListJ;
        if (this.Q == null) {
            this.Q = new q0(this, looper, 2);
        }
        p1.m mVar = qVar.f10027r;
        int i = 0;
        c cVar = null;
        if (mVar == null) {
            int i10 = m0.i(qVar.f10023n);
            u uVar = this.J;
            uVar.getClass();
            if (uVar.i() != 2 || !v.f4748c) {
                int[] iArr = this.f4732z;
                while (true) {
                    if (i >= iArr.length) {
                        i = -1;
                        break;
                    }
                    if (iArr[i] == i10) {
                        break;
                    }
                    i++;
                }
                if (i != -1 && uVar.i() != 1) {
                    c cVar2 = this.K;
                    if (cVar2 == null) {
                        h0 h0Var = j0.f690v;
                        c cVarI = i(c1.f650y, true, null, z2);
                        this.F.add(cVarI);
                        this.K = cVarI;
                    } else {
                        cVar2.b(null);
                    }
                    return this.K;
                }
            }
            return null;
        }
        if (this.O == null) {
            arrayListJ = j(mVar, this.f4727u, false);
            if (arrayListJ.isEmpty()) {
                d dVar = new d("Media does not support uuid: " + this.f4727u);
                s1.b.h("DefaultDrmSessionMgr", "DRM error", dVar);
                if (kVar != null) {
                    kVar.d(dVar);
                }
                return new q(new g(dVar, 6003));
            }
        } else {
            arrayListJ = null;
        }
        if (this.f4731y) {
            ArrayList arrayList = this.F;
            int size = arrayList.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    break;
                }
                Object obj = arrayList.get(i11);
                i11++;
                c cVar3 = (c) obj;
                if (Objects.equals(cVar3.f4701a, arrayListJ)) {
                    cVar = cVar3;
                    break;
                }
            }
        } else {
            cVar = this.L;
        }
        if (cVar != null) {
            cVar.b(kVar);
            return cVar;
        }
        c cVarI2 = i(arrayListJ, false, kVar, z2);
        if (!this.f4731y) {
            this.L = cVarI2;
        }
        this.F.add(cVarI2);
        return cVarI2;
    }

    public final c c(List list, boolean z2, k kVar) {
        this.J.getClass();
        boolean z10 = this.A | z2;
        u uVar = this.J;
        byte[] bArr = this.O;
        Looper looper = this.M;
        looper.getClass();
        b2.o oVar = this.P;
        oVar.getClass();
        c cVar = new c(this.f4727u, uVar, this.B, this.D, list, z10, z2, bArr, this.f4730x, this.f4729w, looper, this.C, oVar);
        cVar.b(kVar);
        if (this.E != -9223372036854775807L) {
            cVar.b(null);
        }
        return cVar;
    }

    @Override // f2.n
    public final void d() {
        l(true);
        int i = this.I;
        this.I = i + 1;
        if (i != 0) {
            return;
        }
        if (this.J == null) {
            u uVarD = this.f4728v.d(this.f4727u);
            this.J = uVarD;
            uVarD.e(new u5.d(9, this));
        } else {
            if (this.E == -9223372036854775807L) {
                return;
            }
            int i10 = 0;
            while (true) {
                ArrayList arrayList = this.F;
                if (i10 >= arrayList.size()) {
                    return;
                }
                ((c) arrayList.get(i10)).b(null);
                i10++;
            }
        }
    }

    @Override // f2.n
    public final m e(k kVar, p1.q qVar) {
        s1.d.g(this.I > 0);
        s1.d.h(this.M);
        e eVar = new e(this, kVar);
        Handler handler = this.N;
        handler.getClass();
        handler.post(new g0(eVar, 13, qVar));
        return eVar;
    }

    @Override // f2.n
    public final int f(p1.q qVar) {
        l(false);
        u uVar = this.J;
        uVar.getClass();
        int i = uVar.i();
        p1.m mVar = qVar.f10027r;
        if (mVar == null) {
            int i10 = m0.i(qVar.f10023n);
            int i11 = 0;
            while (true) {
                int[] iArr = this.f4732z;
                if (i11 >= iArr.length) {
                    i11 = -1;
                    break;
                }
                if (iArr[i11] == i10) {
                    break;
                }
                i11++;
            }
            if (i11 == -1) {
                return 0;
            }
        } else if (this.O == null) {
            UUID uuid = this.f4727u;
            if (j(mVar, uuid, true).isEmpty()) {
                if (mVar.f9938x == 1 && mVar.f9935u[0].a(p1.g.f9746b)) {
                    s1.b.p("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + uuid);
                }
                return 1;
            }
            String str = mVar.f9937w;
            if (str != null && !"cenc".equals(str) && (!"cbcs".equals(str) ? "cbc1".equals(str) || "cens".equals(str) : Build.VERSION.SDK_INT < 25)) {
                return 1;
            }
        }
        return i;
    }

    @Override // f2.n
    public final void g(Looper looper, b2.o oVar) {
        synchronized (this) {
            try {
                Looper looper2 = this.M;
                if (looper2 == null) {
                    this.M = looper;
                    this.N = new Handler(looper);
                } else {
                    s1.d.g(looper2 == looper);
                    this.N.getClass();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.P = oVar;
    }

    @Override // f2.n
    public final h h(k kVar, p1.q qVar) {
        l(false);
        s1.d.g(this.I > 0);
        s1.d.h(this.M);
        return a(this.M, kVar, qVar, true);
    }

    public final c i(List list, boolean z2, k kVar, boolean z10) {
        c cVarC = c(list, z2, kVar);
        boolean zB = b(cVarC);
        long j5 = this.E;
        Set set = this.H;
        if (zB && !set.isEmpty()) {
            q1 it = o0.r(set).iterator();
            while (it.hasNext()) {
                ((h) it.next()).c(null);
            }
            cVarC.c(kVar);
            if (j5 != -9223372036854775807L) {
                cVarC.c(null);
            }
            cVarC = c(list, z2, kVar);
        }
        if (b(cVarC) && z10) {
            Set set2 = this.G;
            if (!set2.isEmpty()) {
                q1 it2 = o0.r(set2).iterator();
                while (it2.hasNext()) {
                    ((e) it2.next()).release();
                }
                if (!set.isEmpty()) {
                    q1 it3 = o0.r(set).iterator();
                    while (it3.hasNext()) {
                        ((h) it3.next()).c(null);
                    }
                }
                cVarC.c(kVar);
                if (j5 != -9223372036854775807L) {
                    cVarC.c(null);
                }
                return c(list, z2, kVar);
            }
        }
        return cVarC;
    }

    public final void k() {
        if (this.J != null && this.I == 0 && this.F.isEmpty() && this.G.isEmpty()) {
            u uVar = this.J;
            uVar.getClass();
            uVar.release();
            this.J = null;
        }
    }

    public final void l(boolean z2) {
        if (z2 && this.M == null) {
            s1.b.q("DefaultDrmSessionMgr", "DefaultDrmSessionManager accessed before setPlayer(), possibly on the wrong thread.", new IllegalStateException());
            return;
        }
        Thread threadCurrentThread = Thread.currentThread();
        Looper looper = this.M;
        looper.getClass();
        if (threadCurrentThread != looper.getThread()) {
            s1.b.q("DefaultDrmSessionMgr", "DefaultDrmSessionManager accessed on the wrong thread.\nCurrent thread: " + Thread.currentThread().getName() + "\nExpected thread: " + this.M.getThread().getName(), new IllegalStateException());
        }
    }

    @Override // f2.n
    public final void release() {
        l(true);
        int i = this.I - 1;
        this.I = i;
        if (i != 0) {
            return;
        }
        if (this.E != -9223372036854775807L) {
            ArrayList arrayList = new ArrayList(this.F);
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                ((c) arrayList.get(i10)).c(null);
            }
        }
        q1 it = o0.r(this.G).iterator();
        while (it.hasNext()) {
            ((e) it.next()).release();
        }
        k();
    }
}
