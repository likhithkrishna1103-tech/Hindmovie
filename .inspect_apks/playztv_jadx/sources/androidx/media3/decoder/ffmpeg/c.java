package androidx.media3.decoder.ffmpeg;

import a2.a2;
import a2.d1;
import a2.g;
import a2.h;
import aa.j0;
import android.media.AudioDeviceInfo;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Trace;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.SimpleDecoderOutputBuffer;
import b2.o;
import c2.e0;
import c2.f;
import c2.j;
import c2.l;
import c2.m;
import c2.p;
import c2.q;
import c2.y;
import com.google.android.gms.internal.measurement.k4;
import h4.z;
import o2.d0;
import p1.m0;
import p1.q0;
import s1.b0;
import s1.w;
import y1.i;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends g implements d1 {
    public final k4 M;
    public final q N;
    public final DecoderInputBuffer O;
    public h P;
    public p1.q Q;
    public int R;
    public int S;
    public boolean T;
    public y1.d U;
    public DecoderInputBuffer V;
    public SimpleDecoderOutputBuffer W;
    public f2.h X;
    public f2.h Y;
    public int Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f1550a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f1551b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public long f1552c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f1553d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f1554e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f1555f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public long f1556g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final long[] f1557h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public int f1558i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public boolean f1559j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f1560k0;
    public long l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public long f1561m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public long f1562n0;

    public c(Handler handler, j jVar, q qVar) {
        super(1);
        this.M = new k4(handler, jVar);
        this.N = qVar;
        ((e0) qVar).f2291s = new rc.b(6, this);
        this.O = DecoderInputBuffer.newNoDataInstance();
        this.Z = 0;
        this.f1551b0 = true;
        I(-9223372036854775807L);
        this.f1557h0 = new long[10];
        this.l0 = -9223372036854775807L;
        this.f1561m0 = -9223372036854775807L;
        this.f1562n0 = -9223372036854775807L;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0050  */
    @Override // a2.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int A(p1.q r8) {
        /*
            r7 = this;
            java.lang.String r0 = r8.f10023n
            int r1 = r8.G
            int r2 = r8.F
            boolean r0 = p1.m0.k(r0)
            r3 = 0
            if (r0 != 0) goto L12
            int r8 = l4.a.g(r3, r3, r3, r3)
            return r8
        L12:
            java.lang.String r0 = r8.f10023n
            r0.getClass()
            androidx.media3.decoder.ffmpeg.e r4 = androidx.media3.decoder.ffmpeg.FfmpegLibrary.f1542a
            boolean r4 = r4.a()
            r5 = 2
            if (r4 == 0) goto L52
            boolean r4 = p1.m0.k(r0)
            if (r4 != 0) goto L27
            goto L52
        L27:
            boolean r0 = androidx.media3.decoder.ffmpeg.FfmpegLibrary.d(r0)
            if (r0 == 0) goto L50
            p1.q r0 = s1.b0.A(r5, r2, r1)
            c2.q r4 = r7.N
            r6 = r4
            c2.e0 r6 = (c2.e0) r6
            boolean r0 = r6.F(r0)
            r6 = 4
            if (r0 != 0) goto L4a
            p1.q r0 = s1.b0.A(r6, r2, r1)
            c2.e0 r4 = (c2.e0) r4
            boolean r0 = r4.F(r0)
            if (r0 != 0) goto L4a
            goto L50
        L4a:
            int r8 = r8.O
            if (r8 == 0) goto L53
            r6 = r5
            goto L53
        L50:
            r6 = 1
            goto L53
        L52:
            r6 = r3
        L53:
            if (r6 > r5) goto L5a
            int r8 = l4.a.g(r6, r3, r3, r3)
            return r8
        L5a:
            r8 = r6 | 168(0xa8, float:2.35E-43)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.decoder.ffmpeg.c.A(p1.q):int");
    }

    @Override // a2.g
    public final int B() {
        return 8;
    }

    public final y1.d C(p1.q qVar) {
        Trace.beginSection("createFfmpegAudioDecoder");
        int i = qVar.f10024o;
        int i10 = qVar.G;
        int i11 = qVar.F;
        if (i == -1) {
            i = 5760;
        }
        p1.q qVarA = b0.A(2, i11, i10);
        q qVar2 = this.N;
        boolean zEquals = true;
        if (((e0) qVar2).F(qVarA)) {
            zEquals = ((e0) qVar2).k(b0.A(4, i11, i10)) != 2 ? false : true ^ "audio/ac3".equals(qVar.f10023n);
        }
        FfmpegAudioDecoder ffmpegAudioDecoder = new FfmpegAudioDecoder(i, qVar, zEquals);
        Trace.endSection();
        return ffmpegAudioDecoder;
    }

    public final boolean D() throws l, a2.q {
        if (this.W == null) {
            SimpleDecoderOutputBuffer simpleDecoderOutputBuffer = (SimpleDecoderOutputBuffer) ((i) this.U).dequeueOutputBuffer();
            this.W = simpleDecoderOutputBuffer;
            if (simpleDecoderOutputBuffer == null) {
                return false;
            }
            int i = simpleDecoderOutputBuffer.skippedOutputBufferCount;
            if (i > 0) {
                this.P.f += i;
                ((e0) this.N).M = true;
            }
            if (simpleDecoderOutputBuffer.isFirstSample()) {
                long[] jArr = this.f1557h0;
                ((e0) this.N).M = true;
                if (this.f1558i0 != 0) {
                    I(jArr[0]);
                    int i10 = this.f1558i0 - 1;
                    this.f1558i0 = i10;
                    System.arraycopy(jArr, 1, jArr, 0, i10);
                }
            }
        }
        if (this.W.isEndOfStream()) {
            if (this.Z == 2) {
                H();
                F();
                this.f1551b0 = true;
                return false;
            }
            this.W.release();
            this.W = null;
            try {
                this.f1555f0 = true;
                ((e0) this.N).w();
                this.f1562n0 = this.f1561m0;
                return false;
            } catch (p e10) {
                throw a(e10, e10.f2368w, e10.f2367v, 5002);
            }
        }
        this.f1562n0 = -9223372036854775807L;
        if (this.f1551b0) {
            FfmpegAudioDecoder ffmpegAudioDecoder = (FfmpegAudioDecoder) this.U;
            ffmpegAudioDecoder.getClass();
            p1.p pVar = new p1.p();
            pVar.f9967m = m0.p("audio/raw");
            pVar.E = ffmpegAudioDecoder.f1540u;
            pVar.F = ffmpegAudioDecoder.f1541v;
            pVar.G = ffmpegAudioDecoder.f1536q;
            p1.p pVarA = new p1.q(pVar).a();
            pVarA.H = this.R;
            pVarA.I = this.S;
            p1.q qVar = this.Q;
            pVarA.f9965k = qVar.f10021l;
            pVarA.f9957a = qVar.f10012a;
            pVarA.f9958b = qVar.f10013b;
            pVarA.f9959c = j0.r(qVar.f10014c);
            p1.q qVar2 = this.Q;
            pVarA.f9960d = qVar2.f10015d;
            pVarA.f9961e = qVar2.f10016e;
            pVarA.f = qVar2.f;
            ((e0) this.N).d(new p1.q(pVarA), null);
            this.f1551b0 = false;
        }
        q qVar3 = this.N;
        SimpleDecoderOutputBuffer simpleDecoderOutputBuffer2 = this.W;
        if (!((e0) qVar3).n(simpleDecoderOutputBuffer2.timeUs, 1, simpleDecoderOutputBuffer2.f1532v)) {
            this.f1562n0 = this.W.timeUs;
            return false;
        }
        this.P.f248e++;
        this.W.release();
        this.W = null;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean E() throws a2.q {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.decoder.ffmpeg.c.E():boolean");
    }

    public final void F() throws a2.q {
        k4 k4Var = this.M;
        if (this.U != null) {
            return;
        }
        f2.h hVar = this.Y;
        e6.j.t(this.X, hVar);
        this.X = hVar;
        if (hVar != null && hVar.g() == null && this.X.f() == null) {
            return;
        }
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Trace.beginSection("createAudioDecoder");
            y1.d dVarC = C(this.Q);
            this.U = dVarC;
            ((i) dVarC).setOutputStartTimeUs(this.F);
            Trace.endSection();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            String strK = ((FfmpegAudioDecoder) this.U).k();
            long j5 = jElapsedRealtime2 - jElapsedRealtime;
            Handler handler = (Handler) k4Var.f3070u;
            if (handler != null) {
                handler.post(new c2.h(k4Var, strK, jElapsedRealtime2, j5));
            }
            this.P.f244a++;
        } catch (OutOfMemoryError e10) {
            throw a(e10, this.Q, false, 4001);
        } catch (y1.e e11) {
            s1.b.h("DecoderAudioRenderer", "Audio codec error", e11);
            Handler handler2 = (Handler) k4Var.f3070u;
            if (handler2 != null) {
                handler2.post(new c2.h(k4Var, e11, 0));
            }
            throw a(e11, this.Q, false, 4001);
        }
    }

    public final void G(z zVar) throws a2.q {
        p1.q qVar = (p1.q) zVar.f5868w;
        qVar.getClass();
        f2.h hVar = (f2.h) zVar.f5867v;
        e6.j.t(this.Y, hVar);
        this.Y = hVar;
        p1.q qVar2 = this.Q;
        this.Q = qVar;
        this.R = qVar.I;
        this.S = qVar.J;
        y1.d dVar = this.U;
        k4 k4Var = this.M;
        if (dVar == null) {
            F();
            p1.q qVar3 = this.Q;
            Handler handler = (Handler) k4Var.f3070u;
            if (handler != null) {
                handler.post(new c2.h(k4Var, qVar3, (a2.i) null));
                return;
            }
            return;
        }
        a2.i iVar = hVar != this.X ? new a2.i(((FfmpegAudioDecoder) dVar).k(), qVar2, qVar, 0, 128) : new a2.i(((FfmpegAudioDecoder) dVar).k(), qVar2, qVar, 0, 1);
        if (iVar.f275d == 0) {
            if (this.f1550a0) {
                this.Z = 1;
            } else {
                H();
                F();
                this.f1551b0 = true;
            }
        }
        p1.q qVar4 = this.Q;
        Handler handler2 = (Handler) k4Var.f3070u;
        if (handler2 != null) {
            handler2.post(new c2.h(k4Var, qVar4, iVar));
        }
    }

    public final void H() {
        this.V = null;
        this.W = null;
        this.Z = 0;
        this.f1550a0 = false;
        this.l0 = -9223372036854775807L;
        this.f1561m0 = -9223372036854775807L;
        y1.d dVar = this.U;
        if (dVar != null) {
            this.P.f245b++;
            ((FfmpegAudioDecoder) dVar).release();
            String strK = ((FfmpegAudioDecoder) this.U).k();
            k4 k4Var = this.M;
            Handler handler = (Handler) k4Var.f3070u;
            if (handler != null) {
                handler.post(new c2.h(k4Var, strK, 3));
            }
            this.U = null;
        }
        e6.j.t(this.X, null);
        this.X = null;
    }

    public final void I(long j5) {
        this.f1556g0 = j5;
        if (j5 != -9223372036854775807L) {
            this.N.getClass();
        }
    }

    public final void J() {
        l();
        long jI = ((e0) this.N).i();
        if (jI != Long.MIN_VALUE) {
            if (!this.f1553d0) {
                jI = Math.max(this.f1552c0, jI);
            }
            this.f1552c0 = jI;
            this.f1553d0 = false;
        }
    }

    @Override // a2.g, a2.w1
    public final void b(int i, Object obj) {
        wb.c cVar;
        q qVar = this.N;
        if (i == 2) {
            float fFloatValue = ((Float) obj).floatValue();
            e0 e0Var = (e0) qVar;
            if (e0Var.P != fFloatValue) {
                e0Var.P = fFloatValue;
                if (e0Var.q()) {
                    e0Var.f2295w.setVolume(e0Var.P);
                    return;
                }
                return;
            }
            return;
        }
        if (i == 3) {
            ((e0) qVar).z((p1.d) obj);
            return;
        }
        if (i == 6) {
            ((e0) qVar).C((p1.e) obj);
            return;
        }
        if (i != 12) {
            if (i != 9) {
                if (i != 10) {
                    return;
                }
                ((e0) qVar).A(((Integer) obj).intValue());
                return;
            }
            e0 e0Var2 = (e0) qVar;
            e0Var2.E = ((Boolean) obj).booleanValue();
            y yVar = e0Var2.f2293u;
            c2.z zVar = new c2.z((yVar == null || !yVar.f2425j) ? e0Var2.D : q0.f10036d, -9223372036854775807L, -9223372036854775807L);
            if (e0Var2.q()) {
                e0Var2.B = zVar;
                return;
            } else {
                e0Var2.C = zVar;
                return;
            }
        }
        AudioDeviceInfo audioDeviceInfo = (AudioDeviceInfo) obj;
        e0 e0Var3 = (e0) qVar;
        if (audioDeviceInfo == null) {
            cVar = null;
        } else {
            e0Var3.getClass();
            cVar = new wb.c(6, audioDeviceInfo);
        }
        e0Var3.f2266b0 = cVar;
        f fVar = e0Var3.f2297y;
        if (fVar != null) {
            fVar.b(audioDeviceInfo);
        }
        AudioTrack audioTrack = e0Var3.f2295w;
        if (audioTrack != null) {
            wb.c cVar2 = e0Var3.f2266b0;
            audioTrack.setPreferredDevice(cVar2 != null ? (AudioDeviceInfo) cVar2.f14088v : null);
        }
    }

    @Override // a2.g
    public final long d(long j5, long j8) {
        boolean z2 = this.f1562n0 != -9223372036854775807L;
        if (this.f1560k0) {
            long jH = ((e0) this.N).h();
            if (z2 && jH != -9223372036854775807L) {
                float fMin = Math.min(jH, this.f1562n0 - j5);
                float f = h() != null ? h().f10038a : 1.0f;
                this.A.getClass();
                return Math.max(10000L, ((long) ((fMin / f) / 2.0f)) - (b0.O(SystemClock.elapsedRealtime()) - j8));
            }
        } else if (z2 || this.f1555f0) {
            return 1000000L;
        }
        return 10000L;
    }

    @Override // a2.d1
    public final void e(q0 q0Var) {
        ((e0) this.N).E(q0Var);
    }

    @Override // a2.g
    public final String g() {
        return "FfmpegAudioRenderer";
    }

    @Override // a2.d1
    public final q0 h() {
        return ((e0) this.N).D;
    }

    @Override // a2.d1
    public final boolean i() {
        boolean z2 = this.f1559j0;
        this.f1559j0 = false;
        return z2;
    }

    @Override // a2.d1
    public final long j() {
        if (this.B == 2) {
            J();
        }
        return this.f1552c0;
    }

    @Override // a2.g
    public final boolean l() {
        if (!this.f1555f0) {
            return false;
        }
        e0 e0Var = (e0) this.N;
        if (e0Var.q()) {
            return e0Var.T && !e0Var.o();
        }
        return true;
    }

    @Override // a2.g
    public final boolean m() {
        if (((e0) this.N).o()) {
            return true;
        }
        if (this.Q != null) {
            return n() || this.W != null;
        }
        return false;
    }

    @Override // a2.g
    public final void o() {
        k4 k4Var = this.M;
        this.Q = null;
        this.f1551b0 = true;
        I(-9223372036854775807L);
        this.f1559j0 = false;
        this.f1562n0 = -9223372036854775807L;
        try {
            e6.j.t(this.Y, null);
            this.Y = null;
            H();
            ((e0) this.N).y();
        } finally {
            k4Var.q(this.P);
        }
    }

    @Override // a2.g
    public final void p(boolean z2, boolean z10) {
        h hVar = new h();
        this.P = hVar;
        k4 k4Var = this.M;
        Handler handler = (Handler) k4Var.f3070u;
        if (handler != null) {
            handler.post(new c2.h(k4Var, hVar, 4));
        }
        a2 a2Var = this.f234x;
        a2Var.getClass();
        boolean z11 = a2Var.f157b;
        q qVar = this.N;
        if (z11) {
            e0 e0Var = (e0) qVar;
            s1.d.g(e0Var.X);
            if (!e0Var.f2268c0) {
                e0Var.f2268c0 = true;
                e0Var.g();
            }
        } else {
            e0 e0Var2 = (e0) qVar;
            if (e0Var2.f2268c0) {
                e0Var2.f2268c0 = false;
                e0Var2.g();
            }
        }
        o oVar = this.f236z;
        oVar.getClass();
        e0 e0Var3 = (e0) qVar;
        e0Var3.f2290r = oVar;
        w wVar = this.A;
        wVar.getClass();
        e0Var3.f2276h.G = wVar;
    }

    @Override // a2.g
    public final void q(boolean z2, long j5) throws a2.q {
        ((e0) this.N).g();
        this.f1552c0 = j5;
        this.f1562n0 = -9223372036854775807L;
        this.f1559j0 = false;
        this.f1553d0 = true;
        this.f1554e0 = false;
        this.f1555f0 = false;
        if (this.U != null) {
            if (this.Z != 0) {
                H();
                F();
                return;
            }
            this.V = null;
            SimpleDecoderOutputBuffer simpleDecoderOutputBuffer = this.W;
            if (simpleDecoderOutputBuffer != null) {
                simpleDecoderOutputBuffer.release();
                this.W = null;
            }
            y1.d dVar = this.U;
            dVar.getClass();
            i iVar = (i) dVar;
            iVar.flush();
            iVar.setOutputStartTimeUs(this.F);
            this.f1550a0 = false;
        }
    }

    @Override // a2.g
    public final void t() {
        ((e0) this.N).u();
        this.f1560k0 = true;
    }

    @Override // a2.g
    public final void u() {
        J();
        ((e0) this.N).t();
        this.f1560k0 = false;
    }

    @Override // a2.g
    public final void v(p1.q[] qVarArr, long j5, long j8, d0 d0Var) {
        this.T = false;
        if (this.f1556g0 == -9223372036854775807L) {
            I(j8);
            return;
        }
        int i = this.f1558i0;
        long[] jArr = this.f1557h0;
        if (i == jArr.length) {
            s1.b.p("DecoderAudioRenderer", "Too many stream changes, so dropping offset: " + jArr[this.f1558i0 - 1]);
        } else {
            this.f1558i0 = i + 1;
        }
        jArr[this.f1558i0 - 1] = j8;
    }

    @Override // a2.g
    public final void x(long j5, long j8) throws a2.q {
        if (this.f1555f0) {
            try {
                ((e0) this.N).w();
                this.f1562n0 = this.f1561m0;
                return;
            } catch (p e10) {
                throw a(e10, e10.f2368w, e10.f2367v, 5002);
            }
        }
        if (this.Q == null) {
            z zVar = this.f233w;
            zVar.F();
            this.O.clear();
            int iW = w(zVar, this.O, 2);
            if (iW != -5) {
                if (iW == -4) {
                    s1.d.g(this.O.isEndOfStream());
                    this.f1554e0 = true;
                    try {
                        this.f1555f0 = true;
                        ((e0) this.N).w();
                        this.f1562n0 = this.f1561m0;
                        return;
                    } catch (p e11) {
                        throw a(e11, null, false, 5002);
                    }
                }
                return;
            }
            G(zVar);
        }
        F();
        if (this.U != null) {
            try {
                Trace.beginSection("drainAndFeed");
                while (D()) {
                }
                while (E()) {
                }
                Trace.endSection();
                synchronized (this.P) {
                }
            } catch (l e12) {
                throw a(e12, e12.f2362u, false, 5001);
            } catch (m e13) {
                throw a(e13, e13.f2365w, e13.f2364v, 5001);
            } catch (p e14) {
                throw a(e14, e14.f2368w, e14.f2367v, 5002);
            } catch (y1.e e15) {
                s1.b.h("DecoderAudioRenderer", "Audio codec error", e15);
                k4 k4Var = this.M;
                Handler handler = (Handler) k4Var.f3070u;
                if (handler != null) {
                    handler.post(new c2.h(k4Var, e15, 0));
                }
                throw a(e15, this.Q, false, 4003);
            }
        }
    }

    @Override // a2.g
    public final d1 f() {
        return this;
    }
}
