package androidx.media3.decoder.ffmpeg;

import android.media.AudioDeviceInfo;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Trace;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.SimpleDecoderOutputBuffer;
import e2.j;
import g2.f;
import g2.g;
import g2.n;
import g2.o1;
import g2.t0;
import i2.f0;
import i2.i;
import i2.k;
import i2.l;
import i2.r;
import i2.s;
import i2.y;
import i2.z;
import l2.h;
import l4.c0;
import ua.i0;
import v1.m0;
import v1.o;
import v1.p;
import v1.q0;
import y1.a0;
import y1.v;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends g2.e implements t0 {
    public final k N;
    public final s O;
    public final DecoderInputBuffer P;
    public f Q;
    public p R;
    public int S;
    public int T;
    public boolean U;
    public e2.d V;
    public DecoderInputBuffer W;
    public SimpleDecoderOutputBuffer X;
    public h Y;
    public h Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f1247a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f1248b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f1249c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public long f1250d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f1251e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f1252f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public boolean f1253g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public long f1254h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final long[] f1255i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public int f1256j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f1257k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public boolean f1258l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public long f1259m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public long f1260n0;
    public long o0;

    public c(Handler handler, l lVar, s sVar) {
        super(1);
        this.N = new k(handler, lVar);
        this.O = sVar;
        ((f0) sVar).f6031s = new pc.c(this);
        this.P = DecoderInputBuffer.newNoDataInstance();
        this.f1247a0 = 0;
        this.f1249c0 = true;
        I(-9223372036854775807L);
        this.f1255i0 = new long[10];
        this.f1259m0 = -9223372036854775807L;
        this.f1260n0 = -9223372036854775807L;
        this.o0 = -9223372036854775807L;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0050  */
    @Override // g2.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int A(v1.p r8) {
        /*
            r7 = this;
            java.lang.String r0 = r8.f12946n
            int r1 = r8.G
            int r2 = r8.F
            boolean r0 = v1.m0.k(r0)
            r3 = 0
            if (r0 != 0) goto L12
            int r8 = q4.a.d(r3, r3, r3, r3)
            return r8
        L12:
            java.lang.String r0 = r8.f12946n
            r0.getClass()
            androidx.media3.decoder.ffmpeg.e r4 = androidx.media3.decoder.ffmpeg.FfmpegLibrary.f1238a
            boolean r4 = r4.a()
            r5 = 2
            if (r4 == 0) goto L52
            boolean r4 = v1.m0.k(r0)
            if (r4 != 0) goto L27
            goto L52
        L27:
            boolean r0 = androidx.media3.decoder.ffmpeg.FfmpegLibrary.d(r0)
            if (r0 == 0) goto L50
            v1.p r0 = y1.a0.A(r5, r2, r1)
            i2.s r4 = r7.O
            r6 = r4
            i2.f0 r6 = (i2.f0) r6
            boolean r0 = r6.F(r0)
            r6 = 4
            if (r0 != 0) goto L4a
            v1.p r0 = y1.a0.A(r6, r2, r1)
            i2.f0 r4 = (i2.f0) r4
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
            int r8 = q4.a.d(r6, r3, r3, r3)
            return r8
        L5a:
            r8 = r6 | 168(0xa8, float:2.35E-43)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.decoder.ffmpeg.c.A(v1.p):int");
    }

    @Override // g2.e
    public final int B() {
        return 8;
    }

    public final e2.d C(p pVar) {
        Trace.beginSection("createFfmpegAudioDecoder");
        int i = pVar.f12947o;
        int i10 = pVar.G;
        int i11 = pVar.F;
        if (i == -1) {
            i = 5760;
        }
        p pVarA = a0.A(2, i11, i10);
        s sVar = this.O;
        boolean zEquals = true;
        if (((f0) sVar).F(pVarA)) {
            zEquals = ((f0) sVar).k(a0.A(4, i11, i10)) != 2 ? false : true ^ "audio/ac3".equals(pVar.f12946n);
        }
        FfmpegAudioDecoder ffmpegAudioDecoder = new FfmpegAudioDecoder(i, pVar, zEquals);
        Trace.endSection();
        return ffmpegAudioDecoder;
    }

    public final boolean D() throws n, i2.n {
        if (this.X == null) {
            SimpleDecoderOutputBuffer simpleDecoderOutputBuffer = (SimpleDecoderOutputBuffer) ((j) this.V).dequeueOutputBuffer();
            this.X = simpleDecoderOutputBuffer;
            if (simpleDecoderOutputBuffer == null) {
                return false;
            }
            int i = simpleDecoderOutputBuffer.skippedOutputBufferCount;
            if (i > 0) {
                this.Q.f += i;
                ((f0) this.O).M = true;
            }
            if (simpleDecoderOutputBuffer.isFirstSample()) {
                long[] jArr = this.f1255i0;
                ((f0) this.O).M = true;
                if (this.f1256j0 != 0) {
                    I(jArr[0]);
                    int i10 = this.f1256j0 - 1;
                    this.f1256j0 = i10;
                    System.arraycopy(jArr, 1, jArr, 0, i10);
                }
            }
        }
        if (this.X.isEndOfStream()) {
            if (this.f1247a0 == 2) {
                H();
                F();
                this.f1249c0 = true;
                return false;
            }
            this.X.release();
            this.X = null;
            try {
                this.f1253g0 = true;
                ((f0) this.O).w();
                this.o0 = this.f1260n0;
                return false;
            } catch (r e9) {
                throw a(e9, e9.f6104x, e9.f6103w, 5002);
            }
        }
        this.o0 = -9223372036854775807L;
        if (this.f1249c0) {
            FfmpegAudioDecoder ffmpegAudioDecoder = (FfmpegAudioDecoder) this.V;
            ffmpegAudioDecoder.getClass();
            o oVar = new o();
            oVar.f12893m = m0.p("audio/raw");
            oVar.E = ffmpegAudioDecoder.f1236u;
            oVar.F = ffmpegAudioDecoder.f1237v;
            oVar.G = ffmpegAudioDecoder.f1232q;
            o oVarA = new p(oVar).a();
            oVarA.H = this.S;
            oVarA.I = this.T;
            p pVar = this.R;
            oVarA.f12891k = pVar.f12944l;
            oVarA.f12883a = pVar.f12935a;
            oVarA.f12884b = pVar.f12936b;
            oVarA.f12885c = i0.k(pVar.f12937c);
            p pVar2 = this.R;
            oVarA.f12886d = pVar2.f12938d;
            oVarA.f12887e = pVar2.f12939e;
            oVarA.f = pVar2.f;
            ((f0) this.O).d(new p(oVarA), null);
            this.f1249c0 = false;
        }
        s sVar = this.O;
        SimpleDecoderOutputBuffer simpleDecoderOutputBuffer2 = this.X;
        if (!((f0) sVar).n(simpleDecoderOutputBuffer2.timeUs, 1, simpleDecoderOutputBuffer2.f1228w)) {
            this.o0 = this.X.timeUs;
            return false;
        }
        this.Q.f4672e++;
        this.X.release();
        this.X = null;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean E() throws g2.n {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.decoder.ffmpeg.c.E():boolean");
    }

    public final void F() throws n {
        k kVar = this.N;
        if (this.V != null) {
            return;
        }
        h hVar = this.Z;
        l0.e.t(this.Y, hVar);
        this.Y = hVar;
        if (hVar != null && hVar.g() == null && this.Y.f() == null) {
            return;
        }
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Trace.beginSection("createAudioDecoder");
            e2.d dVarC = C(this.R);
            this.V = dVarC;
            ((j) dVarC).setOutputStartTimeUs(this.G);
            Trace.endSection();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            String strK = ((FfmpegAudioDecoder) this.V).k();
            long j4 = jElapsedRealtime2 - jElapsedRealtime;
            Handler handler = (Handler) kVar.f6085v;
            if (handler != null) {
                handler.post(new i(kVar, strK, jElapsedRealtime2, j4));
            }
            this.Q.f4668a++;
        } catch (e2.e e9) {
            y1.b.h("DecoderAudioRenderer", "Audio codec error", e9);
            Handler handler2 = (Handler) kVar.f6085v;
            if (handler2 != null) {
                handler2.post(new i(kVar, e9, 0));
            }
            throw a(e9, this.R, false, 4001);
        } catch (OutOfMemoryError e10) {
            throw a(e10, this.R, false, 4001);
        }
    }

    public final void G(c0 c0Var) throws n {
        p pVar = (p) c0Var.f7706x;
        pVar.getClass();
        h hVar = (h) c0Var.f7705w;
        l0.e.t(this.Z, hVar);
        this.Z = hVar;
        p pVar2 = this.R;
        this.R = pVar;
        this.S = pVar.I;
        this.T = pVar.J;
        e2.d dVar = this.V;
        k kVar = this.N;
        if (dVar == null) {
            F();
            p pVar3 = this.R;
            Handler handler = (Handler) kVar.f6085v;
            if (handler != null) {
                handler.post(new i(kVar, pVar3, (g) null));
                return;
            }
            return;
        }
        g gVar = hVar != this.Y ? new g(((FfmpegAudioDecoder) dVar).k(), pVar2, pVar, 0, 128) : new g(((FfmpegAudioDecoder) dVar).k(), pVar2, pVar, 0, 1);
        if (gVar.f4687d == 0) {
            if (this.f1248b0) {
                this.f1247a0 = 1;
            } else {
                H();
                F();
                this.f1249c0 = true;
            }
        }
        p pVar4 = this.R;
        Handler handler2 = (Handler) kVar.f6085v;
        if (handler2 != null) {
            handler2.post(new i(kVar, pVar4, gVar));
        }
    }

    public final void H() {
        this.W = null;
        this.X = null;
        this.f1247a0 = 0;
        this.f1248b0 = false;
        this.f1259m0 = -9223372036854775807L;
        this.f1260n0 = -9223372036854775807L;
        e2.d dVar = this.V;
        if (dVar != null) {
            this.Q.f4669b++;
            ((FfmpegAudioDecoder) dVar).release();
            String strK = ((FfmpegAudioDecoder) this.V).k();
            k kVar = this.N;
            Handler handler = (Handler) kVar.f6085v;
            if (handler != null) {
                handler.post(new i(kVar, strK, 3));
            }
            this.V = null;
        }
        l0.e.t(this.Y, null);
        this.Y = null;
    }

    public final void I(long j4) {
        this.f1254h0 = j4;
        if (j4 != -9223372036854775807L) {
            this.O.getClass();
        }
    }

    public final void J() {
        l();
        long jI = ((f0) this.O).i();
        if (jI != Long.MIN_VALUE) {
            if (!this.f1251e0) {
                jI = Math.max(this.f1250d0, jI);
            }
            this.f1250d0 = jI;
            this.f1251e0 = false;
        }
    }

    @Override // g2.e, g2.k1
    public final void b(int i, Object obj) {
        p6.d dVar;
        s sVar = this.O;
        if (i == 2) {
            float fFloatValue = ((Float) obj).floatValue();
            f0 f0Var = (f0) sVar;
            if (f0Var.P != fFloatValue) {
                f0Var.P = fFloatValue;
                if (f0Var.q()) {
                    f0Var.f6035w.setVolume(f0Var.P);
                    return;
                }
                return;
            }
            return;
        }
        if (i == 3) {
            ((f0) sVar).z((v1.c) obj);
            return;
        }
        if (i == 6) {
            ((f0) sVar).C((v1.d) obj);
            return;
        }
        if (i != 12) {
            if (i != 9) {
                if (i != 10) {
                    return;
                }
                ((f0) sVar).A(((Integer) obj).intValue());
                return;
            }
            f0 f0Var2 = (f0) sVar;
            f0Var2.E = ((Boolean) obj).booleanValue();
            y yVar = f0Var2.f6033u;
            z zVar = new z((yVar == null || !yVar.f6156j) ? f0Var2.D : q0.f12966d, -9223372036854775807L, -9223372036854775807L);
            if (f0Var2.q()) {
                f0Var2.B = zVar;
                return;
            } else {
                f0Var2.C = zVar;
                return;
            }
        }
        AudioDeviceInfo audioDeviceInfo = (AudioDeviceInfo) obj;
        f0 f0Var3 = (f0) sVar;
        if (audioDeviceInfo == null) {
            dVar = null;
        } else {
            f0Var3.getClass();
            dVar = new p6.d(24, audioDeviceInfo);
        }
        f0Var3.f6005b0 = dVar;
        i2.f fVar = f0Var3.f6037y;
        if (fVar != null) {
            fVar.f(audioDeviceInfo);
        }
        AudioTrack audioTrack = f0Var3.f6035w;
        if (audioTrack != null) {
            p6.d dVar2 = f0Var3.f6005b0;
            audioTrack.setPreferredDevice(dVar2 != null ? (AudioDeviceInfo) dVar2.f10037w : null);
        }
    }

    @Override // g2.t0
    public final q0 d() {
        return ((f0) this.O).D;
    }

    @Override // g2.e
    public final long e(long j4, long j7) {
        boolean z10 = this.o0 != -9223372036854775807L;
        if (this.f1258l0) {
            long jH = ((f0) this.O).h();
            if (z10 && jH != -9223372036854775807L) {
                float fMin = Math.min(jH, this.o0 - j4);
                float f = d() != null ? d().f12968a : 1.0f;
                this.B.getClass();
                return Math.max(10000L, ((long) ((fMin / f) / 2.0f)) - (a0.O(SystemClock.elapsedRealtime()) - j7));
            }
        } else if (z10 || this.f1253g0) {
            return 1000000L;
        }
        return 10000L;
    }

    @Override // g2.t0
    public final void f(q0 q0Var) {
        ((f0) this.O).E(q0Var);
    }

    @Override // g2.t0
    public final boolean g() {
        boolean z10 = this.f1257k0;
        this.f1257k0 = false;
        return z10;
    }

    @Override // g2.t0
    public final long h() {
        if (this.C == 2) {
            J();
        }
        return this.f1250d0;
    }

    @Override // g2.e
    public final String j() {
        return "FfmpegAudioRenderer";
    }

    @Override // g2.e
    public final boolean l() {
        if (!this.f1253g0) {
            return false;
        }
        f0 f0Var = (f0) this.O;
        if (f0Var.q()) {
            return f0Var.T && !f0Var.o();
        }
        return true;
    }

    @Override // g2.e
    public final boolean m() {
        if (((f0) this.O).o()) {
            return true;
        }
        if (this.R != null) {
            return n() || this.X != null;
        }
        return false;
    }

    @Override // g2.e
    public final void o() {
        k kVar = this.N;
        this.R = null;
        this.f1249c0 = true;
        I(-9223372036854775807L);
        this.f1257k0 = false;
        this.o0 = -9223372036854775807L;
        try {
            l0.e.t(this.Z, null);
            this.Z = null;
            H();
            ((f0) this.O).y();
        } finally {
            kVar.g(this.Q);
        }
    }

    @Override // g2.e
    public final void p(boolean z10, boolean z11) {
        f fVar = new f();
        this.Q = fVar;
        k kVar = this.N;
        Handler handler = (Handler) kVar.f6085v;
        if (handler != null) {
            handler.post(new i(kVar, fVar, 4));
        }
        o1 o1Var = this.f4660y;
        o1Var.getClass();
        boolean z12 = o1Var.f4853b;
        s sVar = this.O;
        if (z12) {
            f0 f0Var = (f0) sVar;
            y1.d.g(f0Var.X);
            if (!f0Var.f6007c0) {
                f0Var.f6007c0 = true;
                f0Var.g();
            }
        } else {
            f0 f0Var2 = (f0) sVar;
            if (f0Var2.f6007c0) {
                f0Var2.f6007c0 = false;
                f0Var2.g();
            }
        }
        h2.l lVar = this.A;
        lVar.getClass();
        f0 f0Var3 = (f0) sVar;
        f0Var3.f6030r = lVar;
        v vVar = this.B;
        vVar.getClass();
        f0Var3.f6015h.G = vVar;
    }

    @Override // g2.e
    public final void q(boolean z10, long j4) throws n {
        ((f0) this.O).g();
        this.f1250d0 = j4;
        this.o0 = -9223372036854775807L;
        this.f1257k0 = false;
        this.f1251e0 = true;
        this.f1252f0 = false;
        this.f1253g0 = false;
        if (this.V != null) {
            if (this.f1247a0 != 0) {
                H();
                F();
                return;
            }
            this.W = null;
            SimpleDecoderOutputBuffer simpleDecoderOutputBuffer = this.X;
            if (simpleDecoderOutputBuffer != null) {
                simpleDecoderOutputBuffer.release();
                this.X = null;
            }
            e2.d dVar = this.V;
            dVar.getClass();
            j jVar = (j) dVar;
            jVar.flush();
            jVar.setOutputStartTimeUs(this.G);
            this.f1248b0 = false;
        }
    }

    @Override // g2.e
    public final void t() {
        ((f0) this.O).u();
        this.f1258l0 = true;
    }

    @Override // g2.e
    public final void u() {
        J();
        ((f0) this.O).t();
        this.f1258l0 = false;
    }

    @Override // g2.e
    public final void v(p[] pVarArr, long j4, long j7, s2.c0 c0Var) {
        this.U = false;
        if (this.f1254h0 == -9223372036854775807L) {
            I(j7);
            return;
        }
        int i = this.f1256j0;
        long[] jArr = this.f1255i0;
        if (i == jArr.length) {
            y1.b.p("DecoderAudioRenderer", "Too many stream changes, so dropping offset: " + jArr[this.f1256j0 - 1]);
        } else {
            this.f1256j0 = i + 1;
        }
        jArr[this.f1256j0 - 1] = j7;
    }

    @Override // g2.e
    public final void x(long j4, long j7) throws n {
        if (this.f1253g0) {
            try {
                ((f0) this.O).w();
                this.o0 = this.f1260n0;
                return;
            } catch (r e9) {
                throw a(e9, e9.f6104x, e9.f6103w, 5002);
            }
        }
        if (this.R == null) {
            c0 c0Var = this.f4659x;
            c0Var.q();
            this.P.clear();
            int iW = w(c0Var, this.P, 2);
            if (iW != -5) {
                if (iW == -4) {
                    y1.d.g(this.P.isEndOfStream());
                    this.f1252f0 = true;
                    try {
                        this.f1253g0 = true;
                        ((f0) this.O).w();
                        this.o0 = this.f1260n0;
                        return;
                    } catch (r e10) {
                        throw a(e10, null, false, 5002);
                    }
                }
                return;
            }
            G(c0Var);
        }
        F();
        if (this.V != null) {
            try {
                Trace.beginSection("drainAndFeed");
                while (D()) {
                }
                while (E()) {
                }
                Trace.endSection();
                synchronized (this.Q) {
                }
            } catch (e2.e e11) {
                y1.b.h("DecoderAudioRenderer", "Audio codec error", e11);
                k kVar = this.N;
                Handler handler = (Handler) kVar.f6085v;
                if (handler != null) {
                    handler.post(new i(kVar, e11, 0));
                }
                throw a(e11, this.R, false, 4003);
            } catch (i2.n e12) {
                throw a(e12, e12.f6098v, false, 5001);
            } catch (i2.o e13) {
                throw a(e13, e13.f6101x, e13.f6100w, 5001);
            } catch (r e14) {
                throw a(e14, e14.f6104x, e14.f6103w, 5002);
            }
        }
    }

    @Override // g2.e
    public final t0 i() {
        return this;
    }
}
