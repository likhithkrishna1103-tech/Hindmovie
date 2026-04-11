package z6;

import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements f, Runnable, Comparable, t7.b {

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final x6.g f15275c0 = new x6.g("glide_thread_priority_override", null, x6.g.f14398e);
    public com.bumptech.glide.g C;
    public x6.e D;
    public com.bumptech.glide.h E;
    public t F;
    public int G;
    public int H;
    public m I;
    public x6.h J;
    public r K;
    public int L;
    public long M;
    public Object N;
    public pc.c O;
    public Supplier P;
    public Thread Q;
    public x6.e R;
    public x6.e S;
    public Object T;
    public com.bumptech.glide.load.data.d U;
    public volatile g V;
    public volatile boolean W;
    public volatile boolean X;
    public boolean Y;
    public int Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f15276a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f15277b0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final l8.i f15281y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final s0.c f15282z;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final h f15278v = new h();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList f15279w = new ArrayList();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final t7.e f15280x = new t7.e();
    public final e A = new e();
    public final i2.g B = new i2.g();

    public k(l8.i iVar, l7.a aVar) {
        this.f15281y = iVar;
        this.f15282z = aVar;
    }

    @Override // z6.f
    public final void a(x6.e eVar, Exception exc, com.bumptech.glide.load.data.d dVar, int i) {
        dVar.b();
        x xVar = new x("Fetching data failed", Collections.singletonList(exc));
        Class clsA = dVar.a();
        xVar.f15325w = eVar;
        xVar.f15326x = i;
        xVar.f15327y = clsA;
        this.f15279w.add(xVar);
        if (Thread.currentThread() != this.Q) {
            o(2);
        } else {
            q();
        }
    }

    @Override // t7.b
    public final t7.e b() {
        return this.f15280x;
    }

    @Override // z6.f
    public final void c(x6.e eVar, Object obj, com.bumptech.glide.load.data.d dVar, int i, x6.e eVar2) {
        this.R = eVar;
        this.T = obj;
        this.U = dVar;
        this.f15277b0 = i;
        this.S = eVar2;
        this.Y = eVar != this.f15278v.a().get(0);
        if (Thread.currentThread() != this.Q) {
            o(3);
        } else {
            f();
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        k kVar = (k) obj;
        int iOrdinal = this.E.ordinal() - kVar.E.ordinal();
        return iOrdinal == 0 ? this.L - kVar.L : iOrdinal;
    }

    public final b0 d(com.bumptech.glide.load.data.d dVar, Object obj, int i) {
        if (obj == null) {
            return null;
        }
        try {
            int i10 = s7.h.f11599b;
            long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            b0 b0VarE = e(i, obj);
            if (Log.isLoggable("DecodeJob", 2)) {
                i(jElapsedRealtimeNanos, "Decoded result " + b0VarE, null);
            }
            return b0VarE;
        } finally {
            dVar.b();
        }
    }

    public final b0 e(int i, Object obj) {
        Class<?> cls = obj.getClass();
        h hVar = this.f15278v;
        z zVarC = hVar.c(cls);
        x6.h hVar2 = this.J;
        if (Build.VERSION.SDK_INT >= 26) {
            boolean z10 = i == 4 || hVar.f15274r;
            x6.g gVar = g7.p.i;
            Boolean bool = (Boolean) hVar2.c(gVar);
            if (bool == null || (bool.booleanValue() && !z10)) {
                hVar2 = new x6.h();
                s7.c cVar = this.J.f14403b;
                s7.c cVar2 = hVar2.f14403b;
                cVar2.g(cVar);
                cVar2.put(gVar, Boolean.valueOf(z10));
            }
        }
        x6.h hVar3 = hVar2;
        com.bumptech.glide.load.data.f fVarH = this.C.b().h(obj);
        try {
            return zVarC.a(this.G, this.H, new ag.o(i, 12, this), fVarH, hVar3);
        } finally {
            fVarH.b();
        }
    }

    public final void f() {
        b0 b0VarD;
        boolean zB;
        Supplier supplier;
        if (Log.isLoggable("DecodeJob", 2)) {
            i(this.M, "Retrieved data", "data: " + this.T + ", cache key: " + this.R + ", fetcher: " + this.U);
        }
        a0 a0Var = null;
        if (((Map) this.O.f10180v).containsKey(com.bumptech.glide.e.class) && (supplier = this.P) != null && supplier.get() != null) {
            try {
                Process.setThreadPriority(Process.myTid(), ((Integer) this.P.get()).intValue());
            } catch (IllegalArgumentException | SecurityException e9) {
                this.P = null;
                if (Log.isLoggable("DecodeJob", 2)) {
                    Log.v("DecodeJob", "Failed to set thread priority; using default priority for any subsequent jobs.", e9);
                }
            }
        }
        try {
            b0VarD = d(this.U, this.T, this.f15277b0);
        } catch (x e10) {
            x6.e eVar = this.S;
            int i = this.f15277b0;
            e10.f15325w = eVar;
            e10.f15326x = i;
            e10.f15327y = null;
            this.f15279w.add(e10);
            b0VarD = null;
        }
        if (b0VarD == null) {
            q();
            return;
        }
        int i10 = this.f15277b0;
        boolean z10 = this.Y;
        if (b0VarD instanceof y) {
            ((y) b0VarD).a();
        }
        if (((a0) this.A.f15253c) != null) {
            a0Var = (a0) a0.f15227z.i();
            a0Var.f15231y = false;
            a0Var.f15230x = true;
            a0Var.f15229w = b0VarD;
            b0VarD = a0Var;
        }
        j(b0VarD, i10, z10);
        this.Z = 5;
        try {
            e eVar2 = this.A;
            if (((a0) eVar2.f15253c) != null) {
                l8.i iVar = this.f15281y;
                x6.h hVar = this.J;
                eVar2.getClass();
                try {
                    iVar.a().h((x6.e) eVar2.f15251a, new e((x6.k) eVar2.f15252b, (a0) eVar2.f15253c, hVar));
                    ((a0) eVar2.f15253c).a();
                } catch (Throwable th) {
                    ((a0) eVar2.f15253c).a();
                    throw th;
                }
            }
            i2.g gVar = this.B;
            synchronized (gVar) {
                gVar.f6040b = true;
                zB = gVar.b();
            }
            if (zB) {
                n();
            }
        } finally {
            if (a0Var != null) {
                a0Var.a();
            }
        }
    }

    public final g g() {
        int iC = y.e.c(this.Z);
        h hVar = this.f15278v;
        if (iC == 1) {
            return new c0(hVar, this);
        }
        if (iC == 2) {
            return new c(hVar.a(), hVar, this);
        }
        if (iC == 3) {
            return new e0(hVar, this);
        }
        if (iC == 5) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: ".concat(j.a(this.Z)));
    }

    public final int h(int i) {
        boolean z10;
        boolean z11;
        int iC = y.e.c(i);
        if (iC == 0) {
            switch (this.I.f15291a) {
                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                case 1:
                    z10 = false;
                    break;
                default:
                    z10 = true;
                    break;
            }
            if (z10) {
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
            throw new IllegalArgumentException("Unrecognized stage: ".concat(j.a(i)));
        }
        switch (this.I.f15291a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                z11 = false;
                break;
            case 1:
            default:
                z11 = true;
                break;
        }
        if (z11) {
            return 3;
        }
        return h(3);
    }

    public final void i(long j4, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(s7.h.a(j4));
        sb.append(", load key: ");
        sb.append(this.F);
        sb.append(str2 != null ? ", ".concat(str2) : "");
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }

    public final void j(b0 b0Var, int i, boolean z10) {
        if (((Map) this.O.f10180v).containsKey(com.bumptech.glide.e.class)) {
            p();
        }
        t();
        r rVar = this.K;
        synchronized (rVar) {
            rVar.I = b0Var;
            rVar.J = i;
            rVar.Q = z10;
        }
        rVar.h();
    }

    public final void k() {
        if (((Map) this.O.f10180v).containsKey(com.bumptech.glide.e.class)) {
            p();
        }
        t();
        x xVar = new x("Failed to load resource", new ArrayList(this.f15279w));
        r rVar = this.K;
        synchronized (rVar) {
            rVar.L = xVar;
        }
        rVar.g();
        l();
    }

    public final void l() {
        boolean zB;
        i2.g gVar = this.B;
        synchronized (gVar) {
            gVar.f6041c = true;
            zB = gVar.b();
        }
        if (zB) {
            n();
        }
    }

    public final void m() {
        boolean zB;
        i2.g gVar = this.B;
        synchronized (gVar) {
            gVar.f6039a = true;
            zB = gVar.b();
        }
        if (zB) {
            n();
        }
    }

    public final void n() {
        i2.g gVar = this.B;
        synchronized (gVar) {
            gVar.f6040b = false;
            gVar.f6039a = false;
            gVar.f6041c = false;
        }
        e eVar = this.A;
        eVar.f15251a = null;
        eVar.f15252b = null;
        eVar.f15253c = null;
        h hVar = this.f15278v;
        hVar.f15261c = null;
        hVar.f15262d = null;
        hVar.f15270n = null;
        hVar.f15264g = null;
        hVar.f15267k = null;
        hVar.i = null;
        hVar.f15271o = null;
        hVar.f15266j = null;
        hVar.f15272p = null;
        hVar.f15259a.clear();
        hVar.f15268l = false;
        hVar.f15260b.clear();
        hVar.f15269m = false;
        this.W = false;
        this.C = null;
        this.D = null;
        this.J = null;
        this.E = null;
        this.F = null;
        this.K = null;
        this.Z = 0;
        this.V = null;
        this.Q = null;
        this.R = null;
        this.T = null;
        this.f15277b0 = 0;
        this.U = null;
        this.M = 0L;
        this.X = false;
        this.N = null;
        this.f15279w.clear();
        this.f15282z.b(this);
    }

    public final void o(int i) {
        this.f15276a0 = i;
        r rVar = this.K;
        (rVar.H ? rVar.D : rVar.C).execute(this);
    }

    public final void p() {
        if (!((Map) this.O.f10180v).containsKey(com.bumptech.glide.e.class)) {
            throw new IllegalStateException("OverrideGlideThreadPriority experiment is not enabled.");
        }
        Supplier supplier = this.P;
        if (supplier == null || supplier.get() == null) {
            return;
        }
        try {
            Process.setThreadPriority(Process.myTid(), 9);
        } catch (IllegalArgumentException | SecurityException e9) {
            this.P = null;
            if (Log.isLoggable("DecodeJob", 2)) {
                Log.v("DecodeJob", "Failed to set thread priority; using default priority for any subsequent jobs.", e9);
            }
        }
    }

    public final void q() {
        this.Q = Thread.currentThread();
        int i = s7.h.f11599b;
        this.M = SystemClock.elapsedRealtimeNanos();
        boolean zB = false;
        while (!this.X && this.V != null && !(zB = this.V.b())) {
            this.Z = h(this.Z);
            this.V = g();
            if (this.Z == 4) {
                o(2);
                return;
            }
        }
        if ((this.Z == 6 || this.X) && !zB) {
            k();
        }
    }

    public final void r() {
        int iC = y.e.c(this.f15276a0);
        if (iC == 0) {
            this.Z = h(1);
            this.V = g();
            q();
        } else if (iC == 1) {
            q();
        } else if (iC == 2) {
            f();
        } else {
            int i = this.f15276a0;
            throw new IllegalStateException("Unrecognized run reason: ".concat(i != 1 ? i != 2 ? i != 3 ? "null" : "DECODE_DATA" : "SWITCH_TO_SOURCE_SERVICE" : "INITIALIZE"));
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bumptech.glide.load.data.d dVar = this.U;
        try {
            try {
                if (this.X) {
                    k();
                    if (dVar != null) {
                        dVar.b();
                        return;
                    }
                    return;
                }
                r();
                if (dVar != null) {
                    dVar.b();
                }
            } catch (Throwable th) {
                if (dVar != null) {
                    dVar.b();
                }
                throw th;
            }
        } catch (b e9) {
            throw e9;
        } catch (Throwable th2) {
            if (Log.isLoggable("DecodeJob", 3)) {
                Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.X + ", stage: " + j.a(this.Z), th2);
            }
            if (this.Z != 5) {
                this.f15279w.add(th2);
                k();
            }
            if (!this.X) {
                throw th2;
            }
            throw th2;
        }
    }

    public final void t() {
        Throwable th;
        this.f15280x.a();
        if (!this.W) {
            this.W = true;
            return;
        }
        if (this.f15279w.isEmpty()) {
            th = null;
        } else {
            ArrayList arrayList = this.f15279w;
            th = (Throwable) arrayList.get(arrayList.size() - 1);
        }
        throw new IllegalStateException("Already notified", th);
    }
}
