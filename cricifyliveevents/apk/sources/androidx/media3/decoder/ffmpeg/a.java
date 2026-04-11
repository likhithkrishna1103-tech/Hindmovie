package androidx.media3.decoder.ffmpeg;

import android.os.Handler;
import android.os.SystemClock;
import android.os.Trace;
import android.view.Surface;
import androidx.media3.decoder.DecoderInputBuffer;
import g2.f;
import g2.g;
import g2.n;
import l2.h;
import pa.o;
import v1.p;
import v1.r1;
import y1.a0;
import y2.b0;
import y2.c0;
import y2.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends g2.e {
    public final long N;
    public final vb.b O;
    public final o P;
    public final DecoderInputBuffer Q;
    public p R;
    public int S;
    public Object T;
    public Surface U;
    public t V;
    public h W;
    public h X;
    public int Y;
    public long Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f1241a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public r1 f1242b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public long f1243c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f1244d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public f f1245e0;

    public a(long j4, Handler handler, c0 c0Var, int i) {
        super(2);
        this.N = j4;
        this.Z = -9223372036854775807L;
        this.P = new o();
        this.Q = DecoderInputBuffer.newNoDataInstance();
        this.O = new vb.b(handler, c0Var);
        this.S = -1;
        this.Y = 0;
        this.f1245e0 = new f();
    }

    @Override // g2.e
    public final int A(p pVar) {
        return q4.a.d(0, 0, 0, 0);
    }

    public final void C() throws n {
        h hVar = this.X;
        l0.e.t(this.W, hVar);
        this.W = hVar;
        if (hVar != null && hVar.g() == null && this.W.f() == null) {
            return;
        }
        try {
            SystemClock.elapsedRealtime();
            this.R.getClass();
            Trace.beginSection("createFfmpegVideoDecoder");
            Trace.endSection();
            throw null;
        } catch (e2.e e9) {
            y1.b.h("DecoderVideoRenderer", "Video codec error", e9);
            vb.b bVar = this.O;
            Handler handler = (Handler) bVar.f13551w;
            if (handler != null) {
                handler.post(new b0(bVar, e9, 1));
            }
            throw a(e9, this.R, false, 4001);
        } catch (OutOfMemoryError e10) {
            throw a(e10, this.R, false, 4001);
        }
    }

    @Override // g2.e, g2.k1
    public final void b(int i, Object obj) {
        Object obj2;
        if (i != 1) {
            if (i == 7) {
                return;
            }
            return;
        }
        if (obj instanceof Surface) {
            this.U = (Surface) obj;
            this.V = null;
            this.S = 1;
        } else if (obj instanceof t) {
            this.U = null;
            this.V = (t) obj;
            this.S = 0;
        } else {
            this.U = null;
            this.V = null;
            this.S = -1;
            obj = null;
        }
        Object obj3 = this.T;
        vb.b bVar = this.O;
        if (obj3 == obj) {
            if (obj != null) {
                r1 r1Var = this.f1242b0;
                if (r1Var != null) {
                    bVar.l(r1Var);
                }
                if (this.Y != 3 || (obj2 = this.T) == null) {
                    return;
                }
                bVar.i(obj2);
                return;
            }
            return;
        }
        this.T = obj;
        if (obj == null) {
            this.f1242b0 = null;
            this.Y = Math.min(this.Y, 1);
            return;
        }
        r1 r1Var2 = this.f1242b0;
        if (r1Var2 != null) {
            bVar.l(r1Var2);
        }
        this.Y = Math.min(this.Y, 1);
        if (this.C == 2) {
            long j4 = this.N;
            this.Z = j4 > 0 ? SystemClock.elapsedRealtime() + j4 : -9223372036854775807L;
        }
    }

    @Override // g2.e
    public final void c() {
        if (this.Y == 0) {
            this.Y = 1;
        }
    }

    @Override // g2.e
    public final String j() {
        return "ExperimentalFfmpegVideoRenderer";
    }

    @Override // g2.e
    public final boolean l() {
        return this.f1241a0;
    }

    @Override // g2.e
    public final boolean m() {
        if (this.R != null && n() && (this.Y == 3 || this.S == -1)) {
            this.Z = -9223372036854775807L;
            return true;
        }
        if (this.Z == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.Z) {
            return true;
        }
        this.Z = -9223372036854775807L;
        return false;
    }

    @Override // g2.e
    public final void o() {
        vb.b bVar = this.O;
        this.R = null;
        this.f1242b0 = null;
        this.Y = Math.min(this.Y, 0);
        try {
            l0.e.t(this.X, null);
            this.X = null;
            l0.e.t(this.W, null);
            this.W = null;
        } finally {
            bVar.b(this.f1245e0);
        }
    }

    @Override // g2.e
    public final void p(boolean z10, boolean z11) {
        f fVar = new f();
        this.f1245e0 = fVar;
        vb.b bVar = this.O;
        Handler handler = (Handler) bVar.f13551w;
        if (handler != null) {
            handler.post(new b0(bVar, fVar, 5));
        }
        this.Y = z11 ? 1 : 0;
    }

    @Override // g2.e
    public final void q(boolean z10, long j4) {
        this.f1241a0 = false;
        this.Y = Math.min(this.Y, 1);
        if (z10) {
            long j7 = this.N;
            this.Z = j7 > 0 ? SystemClock.elapsedRealtime() + j7 : -9223372036854775807L;
        } else {
            this.Z = -9223372036854775807L;
        }
        this.P.b();
    }

    @Override // g2.e
    public final void t() {
        this.f1244d0 = 0;
        this.f1243c0 = SystemClock.elapsedRealtime();
        SystemClock.elapsedRealtime();
        int i = a0.f14551a;
    }

    @Override // g2.e
    public final void u() {
        this.Z = -9223372036854775807L;
        if (this.f1244d0 > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j4 = jElapsedRealtime - this.f1243c0;
            int i = this.f1244d0;
            vb.b bVar = this.O;
            Handler handler = (Handler) bVar.f13551w;
            if (handler != null) {
                handler.post(new b0(bVar, i, j4));
            }
            this.f1244d0 = 0;
            this.f1243c0 = jElapsedRealtime;
        }
    }

    @Override // g2.e
    public final void x(long j4, long j7) throws n {
        if (this.f1241a0) {
            return;
        }
        if (this.R == null) {
            l4.c0 c0Var = this.f4659x;
            c0Var.q();
            DecoderInputBuffer decoderInputBuffer = this.Q;
            decoderInputBuffer.clear();
            int iW = w(c0Var, decoderInputBuffer, 2);
            if (iW != -5) {
                if (iW == -4) {
                    y1.d.g(decoderInputBuffer.isEndOfStream());
                    this.f1241a0 = true;
                    return;
                }
                return;
            }
            p pVar = (p) c0Var.f7706x;
            pVar.getClass();
            h hVar = (h) c0Var.f7705w;
            l0.e.t(this.X, hVar);
            this.X = hVar;
            this.R = pVar;
            C();
            p pVar2 = this.R;
            pVar2.getClass();
            vb.b bVar = this.O;
            Handler handler = (Handler) bVar.f13551w;
            if (handler != null) {
                handler.post(new b0(bVar, pVar2, (g) null));
            }
        }
        C();
    }

    @Override // g2.e
    public final void v(p[] pVarArr, long j4, long j7, s2.c0 c0Var) {
    }
}
