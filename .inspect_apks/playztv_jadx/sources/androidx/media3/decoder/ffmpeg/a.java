package androidx.media3.decoder.ffmpeg;

import a2.g;
import a2.i;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Trace;
import android.view.Surface;
import androidx.media3.decoder.DecoderInputBuffer;
import e6.j;
import f2.h;
import h4.z;
import o2.d0;
import p1.q;
import p1.r1;
import u2.b0;
import u2.c0;
import u2.t;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends g {
    public final long M;
    public final pb.c N;
    public final q3.d O;
    public final DecoderInputBuffer P;
    public q Q;
    public int R;
    public Object S;
    public Surface T;
    public t U;
    public h V;
    public h W;
    public int X;
    public long Y;
    public boolean Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public r1 f1545a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public long f1546b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f1547c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public a2.h f1548d0;

    public a(long j5, Handler handler, c0 c0Var, int i) {
        super(2);
        this.M = j5;
        this.Y = -9223372036854775807L;
        this.O = new q3.d();
        this.P = DecoderInputBuffer.newNoDataInstance();
        this.N = new pb.c(handler, c0Var);
        this.R = -1;
        this.X = 0;
        this.f1548d0 = new a2.h();
    }

    @Override // a2.g
    public final int A(q qVar) {
        return l4.a.g(0, 0, 0, 0);
    }

    public final void C() throws a2.q {
        h hVar = this.W;
        j.t(this.V, hVar);
        this.V = hVar;
        if (hVar != null && hVar.g() == null && this.V.f() == null) {
            return;
        }
        try {
            SystemClock.elapsedRealtime();
            this.Q.getClass();
            Trace.beginSection("createFfmpegVideoDecoder");
            Trace.endSection();
            throw null;
        } catch (OutOfMemoryError e10) {
            throw a(e10, this.Q, false, 4001);
        } catch (y1.e e11) {
            s1.b.h("DecoderVideoRenderer", "Video codec error", e11);
            pb.c cVar = this.N;
            Handler handler = (Handler) cVar.f10310v;
            if (handler != null) {
                handler.post(new b0(1, e11, cVar));
            }
            throw a(e11, this.Q, false, 4001);
        }
    }

    @Override // a2.g, a2.w1
    public final void b(int i, Object obj) {
        Object obj2;
        if (i != 1) {
            if (i == 7) {
                return;
            }
            return;
        }
        if (obj instanceof Surface) {
            this.T = (Surface) obj;
            this.U = null;
            this.R = 1;
        } else if (obj instanceof t) {
            this.T = null;
            this.U = (t) obj;
            this.R = 0;
        } else {
            this.T = null;
            this.U = null;
            this.R = -1;
            obj = null;
        }
        Object obj3 = this.S;
        pb.c cVar = this.N;
        if (obj3 == obj) {
            if (obj != null) {
                r1 r1Var = this.f1545a0;
                if (r1Var != null) {
                    cVar.p(r1Var);
                }
                if (this.X != 3 || (obj2 = this.S) == null) {
                    return;
                }
                cVar.n(obj2);
                return;
            }
            return;
        }
        this.S = obj;
        if (obj == null) {
            this.f1545a0 = null;
            this.X = Math.min(this.X, 1);
            return;
        }
        r1 r1Var2 = this.f1545a0;
        if (r1Var2 != null) {
            cVar.p(r1Var2);
        }
        this.X = Math.min(this.X, 1);
        if (this.B == 2) {
            long j5 = this.M;
            this.Y = j5 > 0 ? SystemClock.elapsedRealtime() + j5 : -9223372036854775807L;
        }
    }

    @Override // a2.g
    public final void c() {
        if (this.X == 0) {
            this.X = 1;
        }
    }

    @Override // a2.g
    public final String g() {
        return "ExperimentalFfmpegVideoRenderer";
    }

    @Override // a2.g
    public final boolean l() {
        return this.Z;
    }

    @Override // a2.g
    public final boolean m() {
        if (this.Q != null && n() && (this.X == 3 || this.R == -1)) {
            this.Y = -9223372036854775807L;
            return true;
        }
        if (this.Y == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.Y) {
            return true;
        }
        this.Y = -9223372036854775807L;
        return false;
    }

    @Override // a2.g
    public final void o() {
        pb.c cVar = this.N;
        this.Q = null;
        this.f1545a0 = null;
        this.X = Math.min(this.X, 0);
        try {
            j.t(this.W, null);
            this.W = null;
            j.t(this.V, null);
            this.V = null;
        } finally {
            cVar.b(this.f1548d0);
        }
    }

    @Override // a2.g
    public final void p(boolean z2, boolean z10) {
        a2.h hVar = new a2.h();
        this.f1548d0 = hVar;
        pb.c cVar = this.N;
        Handler handler = (Handler) cVar.f10310v;
        if (handler != null) {
            handler.post(new b0(5, hVar, cVar));
        }
        this.X = z10 ? 1 : 0;
    }

    @Override // a2.g
    public final void q(boolean z2, long j5) {
        this.Z = false;
        this.X = Math.min(this.X, 1);
        if (z2) {
            long j8 = this.M;
            this.Y = j8 > 0 ? SystemClock.elapsedRealtime() + j8 : -9223372036854775807L;
        } else {
            this.Y = -9223372036854775807L;
        }
        this.O.b();
    }

    @Override // a2.g
    public final void t() {
        this.f1547c0 = 0;
        this.f1546b0 = SystemClock.elapsedRealtime();
        SystemClock.elapsedRealtime();
        int i = s1.b0.f11647a;
    }

    @Override // a2.g
    public final void u() {
        this.Y = -9223372036854775807L;
        if (this.f1547c0 > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j5 = jElapsedRealtime - this.f1546b0;
            int i = this.f1547c0;
            pb.c cVar = this.N;
            Handler handler = (Handler) cVar.f10310v;
            if (handler != null) {
                handler.post(new b0(cVar, i, j5));
            }
            this.f1547c0 = 0;
            this.f1546b0 = jElapsedRealtime;
        }
    }

    @Override // a2.g
    public final void x(long j5, long j8) throws a2.q {
        if (this.Z) {
            return;
        }
        if (this.Q == null) {
            z zVar = this.f233w;
            zVar.F();
            DecoderInputBuffer decoderInputBuffer = this.P;
            decoderInputBuffer.clear();
            int iW = w(zVar, decoderInputBuffer, 2);
            if (iW != -5) {
                if (iW == -4) {
                    s1.d.g(decoderInputBuffer.isEndOfStream());
                    this.Z = true;
                    return;
                }
                return;
            }
            q qVar = (q) zVar.f5868w;
            qVar.getClass();
            h hVar = (h) zVar.f5867v;
            j.t(this.W, hVar);
            this.W = hVar;
            this.Q = qVar;
            C();
            q qVar2 = this.Q;
            qVar2.getClass();
            pb.c cVar = this.N;
            Handler handler = (Handler) cVar.f10310v;
            if (handler != null) {
                handler.post(new b0(cVar, qVar2, (i) null));
            }
        }
        C();
    }

    @Override // a2.g
    public final void v(q[] qVarArr, long j5, long j8, d0 d0Var) {
    }
}
