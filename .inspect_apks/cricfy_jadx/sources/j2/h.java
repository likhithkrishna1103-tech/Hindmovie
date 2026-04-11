package j2;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.media3.decoder.DecoderInputBuffer;
import b2.h0;
import f9.z;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import k2.u;
import nc.p;
import s2.t;
import v1.a0;
import v1.c0;
import v1.g0;
import w2.q;
import w2.r;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends s2.a {
    public w2.o A;
    public h0 B;
    public a2.a C;
    public Handler D;
    public a0 E;
    public Uri F;
    public final Uri G;
    public k2.c H;
    public boolean I;
    public long J;
    public long K;
    public long L;
    public int M;
    public long N;
    public int O;
    public g0 P;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f6539h;
    public final b2.g i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final f3.a f6540j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final z f6541k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final l2.n f6542l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final f9.a0 f6543m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final p f6544n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f6545o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f6546p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final f3.a f6547q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final q f6548r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final pc.c f6549s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Object f6550t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final SparseArray f6551u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final c f6552v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final c f6553w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final f f6554x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final w2.p f6555y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public b2.h f6556z;

    static {
        v1.h0.a("media3.exoplayer.dash");
    }

    /* JADX WARN: Type inference failed for: r2v11, types: [j2.c] */
    /* JADX WARN: Type inference failed for: r2v12, types: [j2.c] */
    public h(g0 g0Var, b2.g gVar, q qVar, f3.a aVar, z zVar, l2.n nVar, f9.a0 a0Var, long j4, long j7) {
        this.P = g0Var;
        this.E = g0Var.f12698c;
        c0 c0Var = g0Var.f12697b;
        c0Var.getClass();
        Uri uri = c0Var.f12605a;
        this.F = uri;
        this.G = uri;
        this.H = null;
        this.i = gVar;
        this.f6548r = qVar;
        this.f6540j = aVar;
        this.f6542l = nVar;
        this.f6543m = a0Var;
        this.f6545o = j4;
        this.f6546p = j7;
        this.f6541k = zVar;
        this.f6544n = new p(8);
        this.f6539h = false;
        this.f6547q = b(null);
        this.f6550t = new Object();
        this.f6551u = new SparseArray();
        this.f6554x = new f(this);
        this.N = -9223372036854775807L;
        this.L = -9223372036854775807L;
        this.f6549s = new pc.c(this);
        this.f6555y = new d(this);
        final int i = 0;
        this.f6552v = new Runnable(this) { // from class: j2.c

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ h f6527w;

            {
                this.f6527w = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        this.f6527w.A();
                        break;
                    default:
                        this.f6527w.y(false);
                        break;
                }
            }
        };
        final int i10 = 1;
        this.f6553w = new Runnable(this) { // from class: j2.c

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ h f6527w;

            {
                this.f6527w = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        this.f6527w.A();
                        break;
                    default:
                        this.f6527w.y(false);
                        break;
                }
            }
        };
    }

    public static boolean u(k2.h hVar) {
        List list = hVar.f6861c;
        for (int i = 0; i < list.size(); i++) {
            int i10 = ((k2.a) list.get(i)).f6823b;
            if (i10 == 1 || i10 == 2) {
                return true;
            }
        }
        return false;
    }

    public final void A() {
        Uri uri;
        this.D.removeCallbacks(this.f6552v);
        if (this.A.b()) {
            return;
        }
        if (this.A.d()) {
            this.I = true;
            return;
        }
        synchronized (this.f6550t) {
            uri = this.F;
        }
        this.I = false;
        Map map = Collections.EMPTY_MAP;
        y1.d.i(uri, "The uri must be set.");
        r rVar = new r(this.f6556z, new b2.o(uri, 0L, 1, null, map, 0L, -1L, null, 1), 4, this.f6548r);
        pc.c cVar = this.f6549s;
        this.f6543m.getClass();
        this.A.f(rVar, cVar, 3);
    }

    @Override // s2.a
    public final boolean a(g0 g0Var) {
        g0 g0VarI = i();
        c0 c0Var = g0VarI.f12697b;
        c0Var.getClass();
        c0 c0Var2 = g0Var.f12697b;
        return c0Var2 != null && c0Var2.f12605a.equals(c0Var.f12605a) && c0Var2.f12609e.equals(c0Var.f12609e) && Objects.equals(c0Var2.f12607c, c0Var.f12607c) && g0VarI.f12698c.equals(g0Var.f12698c);
    }

    @Override // s2.a
    public final s2.a0 c(s2.c0 c0Var, w2.e eVar, long j4) {
        int iIntValue = ((Integer) c0Var.f11156a).intValue() - this.O;
        f3.a aVarB = b(c0Var);
        l2.k kVar = new l2.k(this.f11150d.f7673c, 0, c0Var);
        int i = this.O + iIntValue;
        k2.c cVar = this.H;
        h0 h0Var = this.B;
        long j7 = this.L;
        h2.l lVar = this.f11152g;
        y1.d.h(lVar);
        b bVar = new b(i, cVar, this.f6544n, iIntValue, this.f6540j, h0Var, this.f6542l, kVar, this.f6543m, aVarB, j7, this.f6555y, eVar, this.f6541k, this.f6554x, lVar);
        this.f6551u.put(i, bVar);
        return bVar;
    }

    @Override // s2.a
    public final synchronized g0 i() {
        return this.P;
    }

    @Override // s2.a
    public final void k() {
        this.f6555y.c();
    }

    @Override // s2.a
    public final void m(h0 h0Var) {
        this.B = h0Var;
        Looper looperMyLooper = Looper.myLooper();
        h2.l lVar = this.f11152g;
        y1.d.h(lVar);
        l2.n nVar = this.f6542l;
        nVar.k(looperMyLooper, lVar);
        nVar.b();
        if (this.f6539h) {
            y(false);
            return;
        }
        this.f6556z = this.i.h();
        this.A = new w2.o("DashMediaSource");
        this.D = y1.a0.n(null);
        A();
    }

    @Override // s2.a
    public final void o(s2.a0 a0Var) {
        b bVar = (b) a0Var;
        o oVar = bVar.H;
        oVar.D = true;
        oVar.f6585y.removeCallbacksAndMessages(null);
        for (t2.h hVar : bVar.M) {
            hVar.C(bVar);
        }
        bVar.L = null;
        this.f6551u.remove(bVar.f6521v);
    }

    @Override // s2.a
    public final void q() {
        this.I = false;
        this.f6556z = null;
        w2.o oVar = this.A;
        if (oVar != null) {
            oVar.e(null);
            this.A = null;
        }
        this.J = 0L;
        this.K = 0L;
        this.F = this.G;
        this.C = null;
        Handler handler = this.D;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.D = null;
        }
        this.L = -9223372036854775807L;
        this.M = 0;
        this.N = -9223372036854775807L;
        this.f6551u.clear();
        p pVar = this.f6544n;
        ((HashMap) pVar.f9069a).clear();
        ((HashMap) pVar.f9070b).clear();
        ((HashMap) pVar.f9071c).clear();
        this.f6542l.release();
    }

    @Override // s2.a
    public final synchronized void t(g0 g0Var) {
        this.P = g0Var;
    }

    public final void v() {
        boolean z10;
        w2.o oVar = this.A;
        d dVar = new d(this);
        synchronized (x2.c.f14289b) {
            z10 = x2.c.f14290c;
        }
        if (z10) {
            dVar.a();
            return;
        }
        if (oVar == null) {
            oVar = new w2.o("SntpClient");
        }
        oVar.f(new x2.b(), new l4.a(dVar), 1);
    }

    public final void w(r rVar, long j4) {
        long j7 = rVar.f13887v;
        Uri uri = rVar.f13890y.f1686x;
        t tVar = new t(j4);
        this.f6543m.getClass();
        this.f6547q.n(tVar, rVar.f13889x, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }

    public final void x(IOException iOException) {
        y1.b.h("DashMediaSource", "Failed to resolve time offset.", iOException);
        this.L = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        y(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x03bd  */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17, types: [int] */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r15v10, types: [int] */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r5v25, types: [v2.q] */
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
    public final void y(boolean r44) {
        /*
            Method dump skipped, instruction units count: 1240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j2.h.y(boolean):void");
    }

    public final void z(u uVar, q qVar) {
        b2.h hVar = this.f6556z;
        Uri uri = Uri.parse(uVar.f6899c);
        Map map = Collections.EMPTY_MAP;
        y1.d.i(uri, "The uri must be set.");
        this.A.f(new r(hVar, new b2.o(uri, 0L, 1, null, map, 0L, -1L, null, 1), 5, qVar), new f(this), 1);
    }
}
