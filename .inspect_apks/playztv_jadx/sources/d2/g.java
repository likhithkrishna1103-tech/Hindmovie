package d2;

import aa.l0;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import k8.a0;
import k8.c0;
import n.a1;
import o2.d0;
import o2.u;
import p1.b0;
import p1.g0;
import p1.h0;
import s2.p;
import v1.e0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends o2.a {
    public final boolean B;
    public final v1.g C;
    public final l0 D;
    public final c0 E;
    public final f2.n F;
    public final a0 G;
    public final ub.o H;
    public final long I;
    public final long J;
    public final l0 K;
    public final s2.o L;
    public final rc.b M;
    public final Object N;
    public final SparseArray O;
    public final c P;
    public final c Q;
    public final wb.c R;
    public final s2.n S;
    public v1.h T;
    public s2.m U;
    public e0 V;
    public c6.c W;
    public Handler X;
    public b0 Y;
    public Uri Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final Uri f3718a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public e2.c f3719b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f3720c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public long f3721d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public long f3722e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public long f3723f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public int f3724g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public long f3725h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public int f3726i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public g0 f3727j0;

    static {
        h0.a("media3.exoplayer.dash");
    }

    /* JADX WARN: Type inference failed for: r2v11, types: [d2.c] */
    /* JADX WARN: Type inference failed for: r2v12, types: [d2.c] */
    public g(g0 g0Var, v1.g gVar, s2.o oVar, l0 l0Var, c0 c0Var, f2.n nVar, a0 a0Var, long j5, long j8) {
        this.f3727j0 = g0Var;
        this.Y = g0Var.f9758c;
        p1.c0 c0Var2 = g0Var.f9757b;
        c0Var2.getClass();
        Uri uri = c0Var2.f9665a;
        this.Z = uri;
        this.f3718a0 = uri;
        this.f3719b0 = null;
        this.C = gVar;
        this.L = oVar;
        this.D = l0Var;
        this.F = nVar;
        this.G = a0Var;
        this.I = j5;
        this.J = j8;
        this.E = c0Var;
        this.H = new ub.o(10);
        this.B = false;
        this.K = b(null);
        this.N = new Object();
        this.O = new SparseArray();
        this.R = new wb.c(9, this);
        this.f3725h0 = -9223372036854775807L;
        this.f3723f0 = -9223372036854775807L;
        this.M = new rc.b(7, this);
        this.S = new u5.c(9, this);
        final int i = 0;
        this.P = new Runnable(this) { // from class: d2.c

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ g f3707v;

            {
                this.f3707v = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        this.f3707v.E();
                        break;
                    default:
                        this.f3707v.C(false);
                        break;
                }
            }
        };
        final int i10 = 1;
        this.Q = new Runnable(this) { // from class: d2.c

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ g f3707v;

            {
                this.f3707v = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        this.f3707v.E();
                        break;
                    default:
                        this.f3707v.C(false);
                        break;
                }
            }
        };
    }

    public static boolean y(e2.h hVar) {
        List list = hVar.f4330c;
        for (int i = 0; i < list.size(); i++) {
            int i10 = ((e2.a) list.get(i)).f4291b;
            if (i10 == 1 || i10 == 2) {
                return true;
            }
        }
        return false;
    }

    public final void A(p pVar, long j5) {
        long j8 = pVar.f11770u;
        Uri uri = pVar.f11773x.f13128w;
        u uVar = new u(j5);
        this.G.getClass();
        this.K.m(uVar, pVar.f11772w, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }

    public final void B(IOException iOException) {
        s1.b.h("DashMediaSource", "Failed to resolve time offset.", iOException);
        this.f3723f0 = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        C(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x03c0  */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17, types: [int] */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r15v10, types: [int] */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r5v25, types: [r2.r] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void C(boolean r44) {
        /*
            Method dump skipped, instruction units count: 1243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.g.C(boolean):void");
    }

    public final void D(e2.u uVar, s2.o oVar) {
        v1.h hVar = this.T;
        Uri uri = Uri.parse(uVar.f4370c);
        Map map = Collections.EMPTY_MAP;
        s1.d.i(uri, "The uri must be set.");
        this.U.f(new p(hVar, new v1.m(uri, 0L, 1, null, map, 0L, -1L, null, 1), 5, oVar), new d(this), 1);
    }

    public final void E() {
        Uri uri;
        this.X.removeCallbacks(this.P);
        if (this.U.c()) {
            return;
        }
        if (this.U.d()) {
            this.f3720c0 = true;
            return;
        }
        synchronized (this.N) {
            uri = this.Z;
        }
        this.f3720c0 = false;
        Map map = Collections.EMPTY_MAP;
        s1.d.i(uri, "The uri must be set.");
        p pVar = new p(this.T, new v1.m(uri, 0L, 1, null, map, 0L, -1L, null, 1), 4, this.L);
        rc.b bVar = this.M;
        this.G.getClass();
        this.U.f(pVar, bVar, 3);
    }

    @Override // o2.a
    public final boolean a(g0 g0Var) {
        g0 g0VarJ = j();
        p1.c0 c0Var = g0VarJ.f9757b;
        c0Var.getClass();
        p1.c0 c0Var2 = g0Var.f9757b;
        return c0Var2 != null && c0Var2.f9665a.equals(c0Var.f9665a) && c0Var2.f9669e.equals(c0Var.f9669e) && Objects.equals(c0Var2.f9667c, c0Var.f9667c) && g0VarJ.f9758c.equals(g0Var.f9758c);
    }

    @Override // o2.a
    public final o2.b0 c(d0 d0Var, s2.e eVar, long j5) {
        int iIntValue = ((Integer) d0Var.f9090a).intValue() - this.f3726i0;
        l0 l0VarB = b(d0Var);
        f2.k kVar = new f2.k(this.f9054x.f4741c, 0, d0Var);
        int i = this.f3726i0 + iIntValue;
        e2.c cVar = this.f3719b0;
        e0 e0Var = this.V;
        long j8 = this.f3723f0;
        b2.o oVar = this.A;
        s1.d.h(oVar);
        b bVar = new b(i, cVar, this.H, iIntValue, this.D, e0Var, this.F, kVar, this.G, l0VarB, j8, this.S, eVar, this.E, this.R, oVar);
        this.O.put(i, bVar);
        return bVar;
    }

    @Override // o2.a
    public final synchronized g0 j() {
        return this.f3727j0;
    }

    @Override // o2.a
    public final void n() {
        this.S.b();
    }

    @Override // o2.a
    public final void p(e0 e0Var) {
        this.V = e0Var;
        Looper looperMyLooper = Looper.myLooper();
        b2.o oVar = this.A;
        s1.d.h(oVar);
        f2.n nVar = this.F;
        nVar.g(looperMyLooper, oVar);
        nVar.d();
        if (this.B) {
            C(false);
            return;
        }
        this.T = this.C.g();
        this.U = new s2.m("DashMediaSource");
        this.X = s1.b0.n(null);
        E();
    }

    @Override // o2.a
    public final void r(o2.b0 b0Var) {
        b bVar = (b) b0Var;
        o oVar = bVar.G;
        oVar.C = true;
        oVar.f3764x.removeCallbacksAndMessages(null);
        for (p2.i iVar : bVar.L) {
            iVar.C(bVar);
        }
        bVar.K = null;
        this.O.remove(bVar.f3700u);
    }

    @Override // o2.a
    public final void t() {
        this.f3720c0 = false;
        this.T = null;
        s2.m mVar = this.U;
        if (mVar != null) {
            mVar.e(null);
            this.U = null;
        }
        this.f3721d0 = 0L;
        this.f3722e0 = 0L;
        this.Z = this.f3718a0;
        this.W = null;
        Handler handler = this.X;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.X = null;
        }
        this.f3723f0 = -9223372036854775807L;
        this.f3724g0 = 0;
        this.f3725h0 = -9223372036854775807L;
        this.O.clear();
        ub.o oVar = this.H;
        ((HashMap) oVar.f12868v).clear();
        ((HashMap) oVar.f12869w).clear();
        ((HashMap) oVar.f12870x).clear();
        this.F.release();
    }

    @Override // o2.a
    public final synchronized void x(g0 g0Var) {
        this.f3727j0 = g0Var;
    }

    public final void z() {
        boolean z2;
        s2.m mVar = this.U;
        d dVar = new d(this);
        synchronized (t2.b.f12068b) {
            z2 = t2.b.f12069c;
        }
        if (z2) {
            dVar.a();
            return;
        }
        if (mVar == null) {
            mVar = new s2.m("SntpClient");
        }
        mVar.f(new c0(26), new a1(dVar), 1);
    }
}
