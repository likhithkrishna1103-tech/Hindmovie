package l2;

import android.media.ResourceBusyException;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import ua.g0;
import ua.i0;
import ua.n1;
import ua.z0;
import v1.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements n {
    public final int[] A;
    public final boolean B;
    public final i2.k C;
    public final f9.a0 D;
    public final p6.d E;
    public final long F;
    public final ArrayList G;
    public final Set H;
    public final Set I;
    public int J;
    public u K;
    public c L;
    public c M;
    public Looper N;
    public Handler O;
    public byte[] P;
    public h2.l Q;
    public volatile h.d R;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final UUID f7660v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final s f7661w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final z f7662x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final HashMap f7663y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f7664z;

    public f(UUID uuid, s sVar, z zVar, HashMap map, boolean z10, int[] iArr, boolean z11, f9.a0 a0Var) {
        uuid.getClass();
        y1.d.a("Use C.CLEARKEY_UUID instead", !v1.f.f12658b.equals(uuid));
        this.f7660v = uuid;
        this.f7661w = sVar;
        this.f7662x = zVar;
        this.f7663y = map;
        this.f7664z = z10;
        this.A = iArr;
        this.B = z11;
        this.D = a0Var;
        this.C = new i2.k(14);
        this.E = new p6.d(27, this);
        this.G = new ArrayList();
        this.H = Collections.newSetFromMap(new IdentityHashMap());
        this.I = Collections.newSetFromMap(new IdentityHashMap());
        this.F = 300000L;
    }

    public static boolean c(c cVar) {
        cVar.o();
        if (cVar.f7646o != 1) {
            return false;
        }
        g gVarF = cVar.f();
        gVarF.getClass();
        Throwable cause = gVarF.getCause();
        return (cause instanceof ResourceBusyException) || w4.v.l(cause);
    }

    public static ArrayList g(v1.l lVar, UUID uuid, boolean z10) {
        ArrayList arrayList = new ArrayList(lVar.f12827y);
        for (int i = 0; i < lVar.f12827y; i++) {
            v1.k kVar = lVar.f12824v[i];
            if ((kVar.a(uuid) || (v1.f.f12659c.equals(uuid) && kVar.a(v1.f.f12658b))) && (kVar.f12799z != null || z10)) {
                arrayList.add(kVar);
            }
        }
        return arrayList;
    }

    public final h a(Looper looper, k kVar, v1.p pVar, boolean z10) {
        ArrayList arrayListG;
        if (this.R == null) {
            this.R = new h.d(this, looper, 3);
        }
        v1.l lVar = pVar.f12950r;
        int i = 0;
        c cVar = null;
        if (lVar == null) {
            int i10 = m0.i(pVar.f12946n);
            u uVar = this.K;
            uVar.getClass();
            if (uVar.j() != 2 || !v.f7681c) {
                int[] iArr = this.A;
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
                if (i != -1 && uVar.j() != 1) {
                    c cVar2 = this.L;
                    if (cVar2 == null) {
                        g0 g0Var = i0.f12341w;
                        c cVarE = e(z0.f12413z, true, null, z10);
                        this.G.add(cVarE);
                        this.L = cVarE;
                    } else {
                        cVar2.d(null);
                    }
                    return this.L;
                }
            }
            return null;
        }
        if (this.P == null) {
            arrayListG = g(lVar, this.f7660v, false);
            if (arrayListG.isEmpty()) {
                d dVar = new d("Media does not support uuid: " + this.f7660v);
                y1.b.h("DefaultDrmSessionMgr", "DRM error", dVar);
                if (kVar != null) {
                    kVar.d(dVar);
                }
                return new q(new g(dVar, 6003));
            }
        } else {
            arrayListG = null;
        }
        if (this.f7664z) {
            ArrayList arrayList = this.G;
            int size = arrayList.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    break;
                }
                Object obj = arrayList.get(i11);
                i11++;
                c cVar3 = (c) obj;
                if (Objects.equals(cVar3.f7634a, arrayListG)) {
                    cVar = cVar3;
                    break;
                }
            }
        } else {
            cVar = this.M;
        }
        if (cVar != null) {
            cVar.d(kVar);
            return cVar;
        }
        c cVarE2 = e(arrayListG, false, kVar, z10);
        if (!this.f7664z) {
            this.M = cVarE2;
        }
        this.G.add(cVarE2);
        return cVarE2;
    }

    @Override // l2.n
    public final void b() {
        l(true);
        int i = this.J;
        this.J = i + 1;
        if (i != 0) {
            return;
        }
        if (this.K == null) {
            u uVarD = this.f7661w.d(this.f7660v);
            this.K = uVarD;
            uVarD.e(new p6.c(29, this));
        } else {
            if (this.F == -9223372036854775807L) {
                return;
            }
            int i10 = 0;
            while (true) {
                ArrayList arrayList = this.G;
                if (i10 >= arrayList.size()) {
                    return;
                }
                ((c) arrayList.get(i10)).d(null);
                i10++;
            }
        }
    }

    public final c d(List list, boolean z10, k kVar) {
        this.K.getClass();
        boolean z11 = this.B | z10;
        u uVar = this.K;
        byte[] bArr = this.P;
        Looper looper = this.N;
        looper.getClass();
        h2.l lVar = this.Q;
        lVar.getClass();
        c cVar = new c(this.f7660v, uVar, this.C, this.E, list, z11, z10, bArr, this.f7663y, this.f7662x, looper, this.D, lVar);
        cVar.d(kVar);
        if (this.F != -9223372036854775807L) {
            cVar.d(null);
        }
        return cVar;
    }

    public final c e(List list, boolean z10, k kVar, boolean z11) {
        c cVarD = d(list, z10, kVar);
        boolean zC = c(cVarD);
        long j4 = this.F;
        Set set = this.I;
        if (zC && !set.isEmpty()) {
            n1 n1VarH = ua.m0.k(set).iterator();
            while (n1VarH.hasNext()) {
                ((h) n1VarH.next()).c(null);
            }
            cVarD.c(kVar);
            if (j4 != -9223372036854775807L) {
                cVarD.c(null);
            }
            cVarD = d(list, z10, kVar);
        }
        if (c(cVarD) && z11) {
            Set set2 = this.H;
            if (!set2.isEmpty()) {
                n1 n1VarH2 = ua.m0.k(set2).iterator();
                while (n1VarH2.hasNext()) {
                    ((e) n1VarH2.next()).release();
                }
                if (!set.isEmpty()) {
                    n1 n1VarH3 = ua.m0.k(set).iterator();
                    while (n1VarH3.hasNext()) {
                        ((h) n1VarH3.next()).c(null);
                    }
                }
                cVarD.c(kVar);
                if (j4 != -9223372036854775807L) {
                    cVarD.c(null);
                }
                return d(list, z10, kVar);
            }
        }
        return cVarD;
    }

    @Override // l2.n
    public final m f(k kVar, v1.p pVar) {
        y1.d.g(this.J > 0);
        y1.d.h(this.N);
        e eVar = new e(this, kVar);
        Handler handler = this.O;
        handler.getClass();
        handler.post(new androidx.fragment.app.d(26, eVar, pVar));
        return eVar;
    }

    @Override // l2.n
    public final int h(v1.p pVar) {
        l(false);
        u uVar = this.K;
        uVar.getClass();
        int iJ = uVar.j();
        v1.l lVar = pVar.f12950r;
        if (lVar == null) {
            int i = m0.i(pVar.f12946n);
            int i10 = 0;
            while (true) {
                int[] iArr = this.A;
                if (i10 >= iArr.length) {
                    i10 = -1;
                    break;
                }
                if (iArr[i10] == i) {
                    break;
                }
                i10++;
            }
            if (i10 == -1) {
                return 0;
            }
        } else if (this.P == null) {
            UUID uuid = this.f7660v;
            if (g(lVar, uuid, true).isEmpty()) {
                if (lVar.f12827y == 1 && lVar.f12824v[0].a(v1.f.f12658b)) {
                    y1.b.p("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + uuid);
                }
                return 1;
            }
            String str = lVar.f12826x;
            if (str != null && !"cenc".equals(str) && (!"cbcs".equals(str) ? "cbc1".equals(str) || "cens".equals(str) : Build.VERSION.SDK_INT < 25)) {
                return 1;
            }
        }
        return iJ;
    }

    @Override // l2.n
    public final h i(k kVar, v1.p pVar) {
        l(false);
        y1.d.g(this.J > 0);
        y1.d.h(this.N);
        return a(this.N, kVar, pVar, true);
    }

    public final void j() {
        if (this.K != null && this.J == 0 && this.G.isEmpty() && this.H.isEmpty()) {
            u uVar = this.K;
            uVar.getClass();
            uVar.release();
            this.K = null;
        }
    }

    @Override // l2.n
    public final void k(Looper looper, h2.l lVar) {
        synchronized (this) {
            try {
                Looper looper2 = this.N;
                if (looper2 == null) {
                    this.N = looper;
                    this.O = new Handler(looper);
                } else {
                    y1.d.g(looper2 == looper);
                    this.O.getClass();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.Q = lVar;
    }

    public final void l(boolean z10) {
        if (z10 && this.N == null) {
            y1.b.q("DefaultDrmSessionMgr", "DefaultDrmSessionManager accessed before setPlayer(), possibly on the wrong thread.", new IllegalStateException());
            return;
        }
        Thread threadCurrentThread = Thread.currentThread();
        Looper looper = this.N;
        looper.getClass();
        if (threadCurrentThread != looper.getThread()) {
            y1.b.q("DefaultDrmSessionMgr", "DefaultDrmSessionManager accessed on the wrong thread.\nCurrent thread: " + Thread.currentThread().getName() + "\nExpected thread: " + this.N.getThread().getName(), new IllegalStateException());
        }
    }

    @Override // l2.n
    public final void release() {
        l(true);
        int i = this.J - 1;
        this.J = i;
        if (i != 0) {
            return;
        }
        if (this.F != -9223372036854775807L) {
            ArrayList arrayList = new ArrayList(this.G);
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                ((c) arrayList.get(i10)).c(null);
            }
        }
        n1 n1VarH = ua.m0.k(this.H).iterator();
        while (n1VarH.hasNext()) {
            ((e) n1VarH.next()).release();
        }
        j();
    }
}
