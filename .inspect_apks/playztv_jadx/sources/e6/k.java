package e6;

import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k implements f, Runnable, Comparable, y6.b {
    public com.bumptech.glide.e B;
    public c6.f C;
    public com.bumptech.glide.f D;
    public t E;
    public int F;
    public int G;
    public m H;
    public c6.i I;
    public r J;
    public int K;
    public long L;
    public Object M;
    public Thread N;
    public c6.f O;
    public c6.f P;
    public Object Q;
    public com.bumptech.glide.load.data.e R;
    public volatile g S;
    public volatile boolean T;
    public volatile boolean U;
    public boolean V;
    public int W;
    public int X;
    public int Y;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final q7.h f4527x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final p0.c f4528y;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final h f4524u = new h();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList f4525v = new ArrayList();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final y6.e f4526w = new y6.e();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final a7.b f4529z = new a7.b(15, false);
    public final bb.b A = new bb.b();

    public k(q7.h hVar, kc.b bVar) {
        this.f4527x = hVar;
        this.f4528y = bVar;
    }

    @Override // y6.b
    public final y6.e a() {
        return this.f4526w;
    }

    @Override // e6.f
    public final void b(c6.f fVar, Object obj, com.bumptech.glide.load.data.e eVar, int i, c6.f fVar2) {
        this.O = fVar;
        this.Q = obj;
        this.R = eVar;
        this.Y = i;
        this.P = fVar2;
        this.V = fVar != this.f4524u.a().get(0);
        if (Thread.currentThread() != this.N) {
            o(3);
        } else {
            f();
        }
    }

    @Override // e6.f
    public final void c(c6.f fVar, Exception exc, com.bumptech.glide.load.data.e eVar, int i) {
        eVar.b();
        x xVar = new x("Fetching data failed", Collections.singletonList(exc));
        Class clsA = eVar.a();
        xVar.f4575v = fVar;
        xVar.f4576w = i;
        xVar.f4577x = clsA;
        this.f4525v.add(xVar);
        if (Thread.currentThread() != this.N) {
            o(2);
        } else {
            p();
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        k kVar = (k) obj;
        int iOrdinal = this.D.ordinal() - kVar.D.ordinal();
        return iOrdinal == 0 ? this.K - kVar.K : iOrdinal;
    }

    public final b0 d(com.bumptech.glide.load.data.e eVar, Object obj, int i) {
        if (obj == null) {
            return null;
        }
        try {
            int i10 = x6.h.f14283b;
            long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            b0 b0VarE = e(i, obj);
            if (Log.isLoggable("DecodeJob", 2)) {
                i(jElapsedRealtimeNanos, "Decoded result " + b0VarE, null);
            }
            return b0VarE;
        } finally {
            eVar.b();
        }
    }

    public final b0 e(int i, Object obj) {
        Class<?> cls = obj.getClass();
        h hVar = this.f4524u;
        z zVarC = hVar.c(cls);
        c6.i iVar = this.I;
        if (Build.VERSION.SDK_INT >= 26) {
            boolean z2 = i == 4 || hVar.f4521r;
            c6.h hVar2 = l6.o.i;
            Boolean bool = (Boolean) iVar.c(hVar2);
            if (bool == null || (bool.booleanValue() && !z2)) {
                iVar = new c6.i();
                x6.c cVar = this.I.f2521b;
                x6.c cVar2 = iVar.f2521b;
                cVar2.g(cVar);
                cVar2.put(hVar2, Boolean.valueOf(z2));
            }
        }
        c6.i iVar2 = iVar;
        com.bumptech.glide.load.data.g gVarH = this.B.b().h(obj);
        try {
            return zVarC.a(this.F, this.G, iVar2, gVarH, new i(i, this));
        } finally {
            gVarH.b();
        }
    }

    public final void f() {
        b0 b0VarD;
        if (Log.isLoggable("DecodeJob", 2)) {
            i(this.L, "Retrieved data", "data: " + this.Q + ", cache key: " + this.O + ", fetcher: " + this.R);
        }
        a0 a0Var = null;
        try {
            b0VarD = d(this.R, this.Q, this.Y);
        } catch (x e10) {
            c6.f fVar = this.P;
            int i = this.Y;
            e10.f4575v = fVar;
            e10.f4576w = i;
            e10.f4577x = null;
            this.f4525v.add(e10);
            b0VarD = null;
        }
        if (b0VarD == null) {
            p();
            return;
        }
        int i10 = this.Y;
        boolean z2 = this.V;
        if (b0VarD instanceof y) {
            ((y) b0VarD).a();
        }
        boolean z10 = true;
        if (((a0) this.f4529z.f620x) != null) {
            a0Var = (a0) a0.f4468y.i();
            a0Var.f4472x = false;
            a0Var.f4471w = true;
            a0Var.f4470v = b0VarD;
            b0VarD = a0Var;
        }
        r();
        r rVar = this.J;
        synchronized (rVar) {
            rVar.H = b0VarD;
            rVar.I = i10;
            rVar.P = z2;
        }
        rVar.h();
        this.W = 5;
        try {
            a7.b bVar = this.f4529z;
            if (((a0) bVar.f620x) == null) {
                z10 = false;
            }
            if (z10) {
                q7.h hVar = this.f4527x;
                c6.i iVar = this.I;
                bVar.getClass();
                try {
                    hVar.a().b((c6.f) bVar.f618v, new a7.b((c6.l) bVar.f619w, (a0) bVar.f620x, iVar, 14));
                    ((a0) bVar.f620x).e();
                } catch (Throwable th) {
                    ((a0) bVar.f620x).e();
                    throw th;
                }
            }
            k();
        } finally {
            if (a0Var != null) {
                a0Var.e();
            }
        }
    }

    public final g g() {
        int iC = v.e.c(this.W);
        h hVar = this.f4524u;
        if (iC == 1) {
            return new c0(hVar, this);
        }
        if (iC == 2) {
            return new d(hVar.a(), hVar, this);
        }
        if (iC == 3) {
            return new g0(hVar, this);
        }
        if (iC == 5) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: ".concat(j.u(this.W)));
    }

    public final int h(int i) {
        boolean z2;
        boolean z10;
        int iC = v.e.c(i);
        if (iC == 0) {
            switch (this.H.f4538a) {
                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                case 1:
                    z2 = false;
                    break;
                default:
                    z2 = true;
                    break;
            }
            if (z2) {
                return 2;
            }
            return h(2);
        }
        if (iC != 1) {
            if (iC == 2) {
                return 4;
            }
            if (iC == 3 || iC == 5) {
                return 6;
            }
            throw new IllegalArgumentException("Unrecognized stage: ".concat(j.u(i)));
        }
        switch (this.H.f4538a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                z10 = false;
                break;
            case 1:
            default:
                z10 = true;
                break;
        }
        if (z10) {
            return 3;
        }
        return h(3);
    }

    public final void i(long j5, String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" in ");
        sb2.append(x6.h.a(j5));
        sb2.append(", load key: ");
        sb2.append(this.E);
        sb2.append(str2 != null ? ", ".concat(str2) : "");
        sb2.append(", thread: ");
        sb2.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb2.toString());
    }

    public final void j() {
        r();
        x xVar = new x("Failed to load resource", new ArrayList(this.f4525v));
        r rVar = this.J;
        synchronized (rVar) {
            rVar.K = xVar;
        }
        rVar.g();
        l();
    }

    public final void k() {
        boolean zB;
        bb.b bVar = this.A;
        synchronized (bVar) {
            bVar.f1978b = true;
            zB = bVar.b();
        }
        if (zB) {
            n();
        }
    }

    public final void l() {
        boolean zB;
        bb.b bVar = this.A;
        synchronized (bVar) {
            bVar.f1979c = true;
            zB = bVar.b();
        }
        if (zB) {
            n();
        }
    }

    public final void m() {
        boolean zB;
        bb.b bVar = this.A;
        synchronized (bVar) {
            bVar.f1977a = true;
            zB = bVar.b();
        }
        if (zB) {
            n();
        }
    }

    public final void n() {
        bb.b bVar = this.A;
        synchronized (bVar) {
            bVar.f1978b = false;
            bVar.f1977a = false;
            bVar.f1979c = false;
        }
        a7.b bVar2 = this.f4529z;
        bVar2.f618v = null;
        bVar2.f619w = null;
        bVar2.f620x = null;
        h hVar = this.f4524u;
        hVar.f4508c = null;
        hVar.f4509d = null;
        hVar.f4517n = null;
        hVar.f4511g = null;
        hVar.f4514k = null;
        hVar.i = null;
        hVar.f4518o = null;
        hVar.f4513j = null;
        hVar.f4519p = null;
        hVar.f4506a.clear();
        hVar.f4515l = false;
        hVar.f4507b.clear();
        hVar.f4516m = false;
        this.T = false;
        this.B = null;
        this.C = null;
        this.I = null;
        this.D = null;
        this.E = null;
        this.J = null;
        this.W = 0;
        this.S = null;
        this.N = null;
        this.O = null;
        this.Q = null;
        this.Y = 0;
        this.R = null;
        this.L = 0L;
        this.U = false;
        this.M = null;
        this.f4525v.clear();
        this.f4528y.b(this);
    }

    public final void o(int i) {
        this.X = i;
        r rVar = this.J;
        (rVar.G ? rVar.C : rVar.B).execute(this);
    }

    public final void p() {
        this.N = Thread.currentThread();
        int i = x6.h.f14283b;
        this.L = SystemClock.elapsedRealtimeNanos();
        boolean zA = false;
        while (!this.U && this.S != null && !(zA = this.S.a())) {
            this.W = h(this.W);
            this.S = g();
            if (this.W == 4) {
                o(2);
                return;
            }
        }
        if ((this.W == 6 || this.U) && !zA) {
            j();
        }
    }

    public final void q() {
        int iC = v.e.c(this.X);
        if (iC == 0) {
            this.W = h(1);
            this.S = g();
            p();
        } else if (iC == 1) {
            p();
        } else if (iC == 2) {
            f();
        } else {
            int i = this.X;
            throw new IllegalStateException("Unrecognized run reason: ".concat(i != 1 ? i != 2 ? i != 3 ? "null" : "DECODE_DATA" : "SWITCH_TO_SOURCE_SERVICE" : "INITIALIZE"));
        }
    }

    public final void r() {
        Throwable th;
        this.f4526w.a();
        if (!this.T) {
            this.T = true;
            return;
        }
        if (this.f4525v.isEmpty()) {
            th = null;
        } else {
            ArrayList arrayList = this.f4525v;
            th = (Throwable) arrayList.get(arrayList.size() - 1);
        }
        throw new IllegalStateException("Already notified", th);
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bumptech.glide.load.data.e eVar = this.R;
        try {
            try {
                if (this.U) {
                    j();
                    if (eVar != null) {
                        eVar.b();
                        return;
                    }
                    return;
                }
                q();
                if (eVar != null) {
                    eVar.b();
                }
            } catch (Throwable th) {
                if (eVar != null) {
                    eVar.b();
                }
                throw th;
            }
        } catch (c e10) {
            throw e10;
        } catch (Throwable th2) {
            if (Log.isLoggable("DecodeJob", 3)) {
                Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.U + ", stage: " + j.u(this.W), th2);
            }
            if (this.W != 5) {
                this.f4525v.add(th2);
                j();
            }
            if (!this.U) {
                throw th2;
            }
            throw th2;
        }
    }
}
