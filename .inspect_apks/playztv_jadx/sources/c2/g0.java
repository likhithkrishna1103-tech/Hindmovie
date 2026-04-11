package c2;

import a2.a2;
import a2.d1;
import a2.l0;
import a2.r0;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioTrack;
import android.media.LoudnessCodecController;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.k4;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashSet;
import java.util.Objects;
import p1.q0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g0 extends j2.s implements d1 {

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public final Context f2313b1;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public final k4 f2314c1;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public final e0 f2315d1;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public final a7.b f2316e1;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public int f2317f1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public boolean f2318g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public boolean f2319h1;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public p1.q f2320i1;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public p1.q f2321j1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public long f2322k1;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public boolean f2323l1;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public boolean f2324m1;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public boolean f2325n1;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    public int f2326o1;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public boolean f2327p1;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    public long f2328q1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(Context context, j2.l lVar, boolean z2, Handler handler, l0 l0Var, e0 e0Var) {
        super(1, lVar, z2, 44100.0f);
        a7.b bVar = Build.VERSION.SDK_INT >= 35 ? new a7.b(25) : null;
        this.f2313b1 = context.getApplicationContext();
        this.f2315d1 = e0Var;
        this.f2316e1 = bVar;
        this.f2326o1 = -1000;
        this.f2314c1 = new k4(handler, (j) l0Var);
        this.f2328q1 = -9223372036854775807L;
        e0Var.f2291s = new u5.d(6, this);
    }

    public final void A0() {
        l();
        long jI = this.f2315d1.i();
        if (jI != Long.MIN_VALUE) {
            if (!this.f2323l1) {
                jI = Math.max(this.f2322k1, jI);
            }
            this.f2322k1 = jI;
            this.f2323l1 = false;
        }
    }

    @Override // j2.s
    public final a2.i D(j2.p pVar, p1.q qVar, p1.q qVar2) {
        a2.i iVarB = pVar.b(qVar, qVar2);
        int i = iVarB.f276e;
        if (this.f6729a0 == null && t0(qVar2)) {
            i |= 32768;
        }
        if (z0(pVar, qVar2) > this.f2317f1) {
            i |= 64;
        }
        int i10 = i;
        return new a2.i(pVar.f6710a, qVar, qVar2, i10 != 0 ? 0 : iVarB.f275d, i10);
    }

    @Override // j2.s
    public final float M(float f, p1.q qVar, p1.q[] qVarArr) {
        int iMax = -1;
        for (p1.q qVar2 : qVarArr) {
            int i = qVar2.G;
            if (i != -1) {
                iMax = Math.max(iMax, i);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return iMax * f;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
    @Override // j2.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.ArrayList N(j2.k r4, p1.q r5, boolean r6) {
        /*
            r3 = this;
            java.lang.String r0 = r5.f10023n
            r1 = 0
            if (r0 != 0) goto L8
            aa.c1 r4 = aa.c1.f650y
            goto L2f
        L8:
            c2.e0 r0 = r3.f2315d1
            boolean r0 = r0.F(r5)
            if (r0 == 0) goto L2b
            java.lang.String r0 = "audio/raw"
            java.util.List r0 = j2.y.d(r0, r1, r1)
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L1e
            r0 = 0
            goto L24
        L1e:
            java.lang.Object r0 = r0.get(r1)
            j2.p r0 = (j2.p) r0
        L24:
            if (r0 == 0) goto L2b
            aa.c1 r4 = aa.j0.v(r0)
            goto L2f
        L2b:
            aa.c1 r4 = j2.y.f(r4, r5, r6, r1)
        L2f:
            java.util.HashMap r6 = j2.y.f6759a
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>(r4)
            a2.f0 r4 = new a2.f0
            r0 = 27
            r4.<init>(r0, r5)
            j2.t r5 = new j2.t
            r5.<init>(r1, r4)
            java.util.Collections.sort(r6, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.g0.N(j2.k, p1.q, boolean):java.util.ArrayList");
    }

    @Override // j2.s
    public final long O(long j5, long j8) {
        boolean z2 = this.f2328q1 != -9223372036854775807L;
        if (this.f2327p1) {
            e0 e0Var = this.f2315d1;
            long jH = e0Var.h();
            if (z2 && jH != -9223372036854775807L) {
                float fMin = Math.min(jH, this.f2328q1 - j5);
                q0 q0Var = e0Var.D;
                float f = q0Var != null ? q0Var.f10038a : 1.0f;
                this.A.getClass();
                return Math.max(10000L, ((long) ((fMin / f) / 2.0f)) - (s1.b0.O(SystemClock.elapsedRealtime()) - j8));
            }
        } else if (z2 || this.O0) {
            return 1000000L;
        }
        return 10000L;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d5  */
    @Override // j2.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b2.g P(j2.p r13, p1.q r14, android.media.MediaCrypto r15, float r16) {
        /*
            Method dump skipped, instruction units count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.g0.P(j2.p, p1.q, android.media.MediaCrypto, float):b2.g");
    }

    @Override // j2.s
    public final void Q(DecoderInputBuffer decoderInputBuffer) {
        p1.q qVar;
        y yVar;
        if (Build.VERSION.SDK_INT < 29 || (qVar = decoderInputBuffer.format) == null || !Objects.equals(qVar.f10023n, "audio/opus") || !this.B0) {
            return;
        }
        ByteBuffer byteBuffer = decoderInputBuffer.supplementalData;
        byteBuffer.getClass();
        p1.q qVar2 = decoderInputBuffer.format;
        qVar2.getClass();
        int i = qVar2.I;
        if (byteBuffer.remaining() == 8) {
            int i10 = (int) ((byteBuffer.order(ByteOrder.LITTLE_ENDIAN).getLong() * 48000) / 1000000000);
            e0 e0Var = this.f2315d1;
            AudioTrack audioTrack = e0Var.f2295w;
            if (audioTrack == null || !e0.r(audioTrack) || (yVar = e0Var.f2293u) == null || !yVar.f2426k) {
                return;
            }
            e0Var.f2295w.setOffloadDelayPadding(i, i10);
        }
    }

    @Override // j2.s
    public final void W(Exception exc) {
        s1.b.h("MediaCodecAudioRenderer", "Audio codec error", exc);
        k4 k4Var = this.f2314c1;
        Handler handler = (Handler) k4Var.f3070u;
        if (handler != null) {
            handler.post(new h(k4Var, exc, 0));
        }
    }

    @Override // j2.s
    public final void X(long j5, long j8, String str) {
        k4 k4Var = this.f2314c1;
        Handler handler = (Handler) k4Var.f3070u;
        if (handler != null) {
            handler.post(new h(k4Var, str, j5, j8));
        }
    }

    @Override // j2.s
    public final void Y(String str) {
        k4 k4Var = this.f2314c1;
        Handler handler = (Handler) k4Var.f3070u;
        if (handler != null) {
            handler.post(new h(k4Var, str, 3));
        }
    }

    @Override // j2.s
    public final a2.i Z(h4.z zVar) throws a2.q {
        p1.q qVar = (p1.q) zVar.f5868w;
        qVar.getClass();
        this.f2320i1 = qVar;
        a2.i iVarZ = super.Z(zVar);
        k4 k4Var = this.f2314c1;
        Handler handler = (Handler) k4Var.f3070u;
        if (handler != null) {
            handler.post(new h(k4Var, qVar, iVarZ));
        }
        return iVarZ;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0104 A[Catch: l -> 0x0102, TryCatch #0 {l -> 0x0102, blocks: (B:44:0x00d9, B:47:0x00e1, B:49:0x00e5, B:51:0x00ee, B:55:0x00fc, B:58:0x0104, B:62:0x010b, B:63:0x0110), top: B:67:0x00d9 }] */
    @Override // j2.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a0(p1.q r9, android.media.MediaFormat r10) throws a2.q {
        /*
            Method dump skipped, instruction units count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.g0.a0(p1.q, android.media.MediaFormat):void");
    }

    @Override // a2.g, a2.w1
    public final void b(int i, Object obj) {
        wb.c cVar;
        a7.b bVar;
        e0 e0Var = this.f2315d1;
        if (i == 2) {
            obj.getClass();
            float fFloatValue = ((Float) obj).floatValue();
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
            p1.d dVar = (p1.d) obj;
            dVar.getClass();
            e0Var.z(dVar);
            return;
        }
        if (i == 6) {
            p1.e eVar = (p1.e) obj;
            eVar.getClass();
            e0Var.C(eVar);
            return;
        }
        if (i == 12) {
            AudioDeviceInfo audioDeviceInfo = (AudioDeviceInfo) obj;
            if (audioDeviceInfo == null) {
                cVar = null;
            } else {
                e0Var.getClass();
                cVar = new wb.c(6, audioDeviceInfo);
            }
            e0Var.f2266b0 = cVar;
            f fVar = e0Var.f2297y;
            if (fVar != null) {
                fVar.b(audioDeviceInfo);
            }
            AudioTrack audioTrack = e0Var.f2295w;
            if (audioTrack != null) {
                wb.c cVar2 = e0Var.f2266b0;
                audioTrack.setPreferredDevice(cVar2 != null ? (AudioDeviceInfo) cVar2.f14088v : null);
                return;
            }
            return;
        }
        if (i == 16) {
            obj.getClass();
            this.f2326o1 = ((Integer) obj).intValue();
            j2.m mVar = this.f6735g0;
            if (mVar != null && Build.VERSION.SDK_INT >= 35) {
                Bundle bundle = new Bundle();
                bundle.putInt("importance", Math.max(0, -this.f2326o1));
                mVar.b(bundle);
                return;
            }
            return;
        }
        if (i == 9) {
            obj.getClass();
            e0Var.E = ((Boolean) obj).booleanValue();
            y yVar = e0Var.f2293u;
            z zVar = new z((yVar == null || !yVar.f2425j) ? e0Var.D : q0.f10036d, -9223372036854775807L, -9223372036854775807L);
            if (e0Var.q()) {
                e0Var.B = zVar;
                return;
            } else {
                e0Var.C = zVar;
                return;
            }
        }
        if (i != 10) {
            if (i == 11) {
                r0 r0Var = (r0) obj;
                r0Var.getClass();
                this.f6730b0 = r0Var;
                return;
            }
            return;
        }
        obj.getClass();
        int iIntValue = ((Integer) obj).intValue();
        e0Var.A(iIntValue);
        if (Build.VERSION.SDK_INT < 35 || (bVar = this.f2316e1) == null) {
            return;
        }
        bVar.D(iIntValue);
    }

    @Override // j2.s
    public final void b0() {
        this.f2315d1.getClass();
    }

    @Override // j2.s
    public final void d0() {
        this.f2315d1.M = true;
    }

    @Override // a2.d1
    public final void e(q0 q0Var) {
        this.f2315d1.E(q0Var);
    }

    @Override // a2.g
    public final String g() {
        return "MediaCodecAudioRenderer";
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    @Override // j2.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g0(long r1, long r3, j2.m r5, java.nio.ByteBuffer r6, int r7, int r8, int r9, long r10, boolean r12, boolean r13, p1.q r14) throws a2.q {
        /*
            r0 = this;
            r6.getClass()
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0.f2328q1 = r1
            p1.q r1 = r0.f2321j1
            r2 = 1
            if (r1 == 0) goto L1a
            r1 = r8 & 2
            if (r1 == 0) goto L1a
            r5.getClass()
            r5.i(r7)
            return r2
        L1a:
            c2.e0 r1 = r0.f2315d1
            if (r12 == 0) goto L2d
            if (r5 == 0) goto L23
            r5.i(r7)
        L23:
            a2.h r3 = r0.S0
            int r4 = r3.f
            int r4 = r4 + r9
            r3.f = r4
            r1.M = r2
            return r2
        L2d:
            boolean r1 = r1.n(r10, r9, r6)     // Catch: c2.p -> L44 c2.m -> L5e
            if (r1 == 0) goto L40
            if (r5 == 0) goto L38
            r5.i(r7)
        L38:
            a2.h r1 = r0.S0
            int r3 = r1.f248e
            int r3 = r3 + r9
            r1.f248e = r3
            return r2
        L40:
            r0.f2328q1 = r10
            r1 = 0
            return r1
        L44:
            r1 = move-exception
            boolean r2 = r0.B0
            if (r2 == 0) goto L55
            a2.a2 r2 = r0.f234x
            r2.getClass()
            int r2 = r2.f156a
            if (r2 == 0) goto L55
            r2 = 5003(0x138b, float:7.01E-42)
            goto L57
        L55:
            r2 = 5002(0x138a, float:7.009E-42)
        L57:
            boolean r3 = r1.f2367v
            a2.q r1 = r0.a(r1, r14, r3, r2)
            throw r1
        L5e:
            r1 = move-exception
            p1.q r2 = r0.f2320i1
            boolean r3 = r0.B0
            if (r3 == 0) goto L71
            a2.a2 r3 = r0.f234x
            r3.getClass()
            int r3 = r3.f156a
            if (r3 == 0) goto L71
            r3 = 5004(0x138c, float:7.012E-42)
            goto L73
        L71:
            r3 = 5001(0x1389, float:7.008E-42)
        L73:
            boolean r4 = r1.f2364v
            a2.q r1 = r0.a(r1, r2, r4, r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.g0.g0(long, long, j2.m, java.nio.ByteBuffer, int, int, int, long, boolean, boolean, p1.q):boolean");
    }

    @Override // a2.d1
    public final q0 h() {
        return this.f2315d1.D;
    }

    @Override // a2.d1
    public final boolean i() {
        boolean z2 = this.f2325n1;
        this.f2325n1 = false;
        return z2;
    }

    @Override // a2.d1
    public final long j() {
        if (this.B == 2) {
            A0();
        }
        return this.f2322k1;
    }

    @Override // j2.s
    public final void j0() throws a2.q {
        try {
            this.f2315d1.w();
            long j5 = this.M0;
            if (j5 != -9223372036854775807L) {
                this.f2328q1 = j5;
            }
        } catch (p e10) {
            throw a(e10, e10.f2368w, e10.f2367v, this.B0 ? 5003 : 5002);
        }
    }

    @Override // a2.g
    public final boolean l() {
        if (!this.O0) {
            return false;
        }
        e0 e0Var = this.f2315d1;
        if (e0Var.q()) {
            return e0Var.T && !e0Var.o();
        }
        return true;
    }

    @Override // j2.s, a2.g
    public final boolean m() {
        return this.f2315d1.o() || super.m();
    }

    @Override // j2.s, a2.g
    public final void o() {
        k4 k4Var = this.f2314c1;
        this.f2324m1 = true;
        this.f2320i1 = null;
        this.f2328q1 = -9223372036854775807L;
        try {
            this.f2315d1.g();
            try {
                super.o();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.o();
                throw th;
            } finally {
            }
        }
    }

    @Override // a2.g
    public final void p(boolean z2, boolean z10) {
        a2.h hVar = new a2.h();
        this.S0 = hVar;
        k4 k4Var = this.f2314c1;
        Handler handler = (Handler) k4Var.f3070u;
        if (handler != null) {
            handler.post(new h(k4Var, hVar, 4));
        }
        a2 a2Var = this.f234x;
        a2Var.getClass();
        boolean z11 = a2Var.f157b;
        e0 e0Var = this.f2315d1;
        if (z11) {
            s1.d.g(e0Var.X);
            if (!e0Var.f2268c0) {
                e0Var.f2268c0 = true;
                e0Var.g();
            }
        } else if (e0Var.f2268c0) {
            e0Var.f2268c0 = false;
            e0Var.g();
        }
        b2.o oVar = this.f236z;
        oVar.getClass();
        e0Var.f2290r = oVar;
        s1.w wVar = this.A;
        wVar.getClass();
        e0Var.f2276h.G = wVar;
    }

    @Override // j2.s, a2.g
    public final void q(boolean z2, long j5) throws a2.q {
        super.q(z2, j5);
        this.f2315d1.g();
        this.f2322k1 = j5;
        this.f2328q1 = -9223372036854775807L;
        this.f2325n1 = false;
        this.f2323l1 = true;
    }

    @Override // a2.g
    public final void r() {
        a7.b bVar;
        f fVar = this.f2315d1.f2297y;
        if (fVar != null) {
            Context context = (Context) fVar.f2300b;
            if (fVar.f2299a) {
                fVar.f2305h = null;
                c cVar = (c) fVar.f2303e;
                if (cVar != null) {
                    q1.c.C(context).unregisterAudioDeviceCallback(cVar);
                }
                context.unregisterReceiver((e) fVar.f);
                d dVar = (d) fVar.f2304g;
                if (dVar != null) {
                    dVar.f2254a.unregisterContentObserver(dVar);
                }
                fVar.f2299a = false;
            }
        }
        if (Build.VERSION.SDK_INT < 35 || (bVar = this.f2316e1) == null) {
            return;
        }
        ((HashSet) bVar.f618v).clear();
        LoudnessCodecController loudnessCodecController = (LoudnessCodecController) bVar.f620x;
        if (loudnessCodecController != null) {
            loudnessCodecController.close();
        }
    }

    @Override // a2.g
    public final void s() {
        e0 e0Var = this.f2315d1;
        this.f2325n1 = false;
        this.f2328q1 = -9223372036854775807L;
        try {
            try {
                this.B0 = false;
                k0();
                i0();
            } finally {
                e6.j.t(this.f6729a0, null);
                this.f6729a0 = null;
            }
        } finally {
            if (this.f2324m1) {
                this.f2324m1 = false;
                e0Var.y();
            }
        }
    }

    @Override // a2.g
    public final void t() {
        this.f2315d1.u();
        this.f2327p1 = true;
    }

    @Override // j2.s
    public final boolean t0(p1.q qVar) {
        a2 a2Var = this.f234x;
        a2Var.getClass();
        if (a2Var.f156a != 0) {
            int iY0 = y0(qVar);
            if ((iY0 & 512) != 0) {
                a2 a2Var2 = this.f234x;
                a2Var2.getClass();
                if (a2Var2.f156a == 2 || (iY0 & 1024) != 0) {
                    return true;
                }
                if (qVar.I == 0 && qVar.J == 0) {
                    return true;
                }
            }
        }
        return this.f2315d1.F(qVar);
    }

    @Override // a2.g
    public final void u() {
        A0();
        this.f2327p1 = false;
        this.f2315d1.t();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009b  */
    @Override // j2.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int u0(j2.k r18, p1.q r19) {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.g0.u0(j2.k, p1.q):int");
    }

    public final int y0(p1.q qVar) {
        g gVarJ = this.f2315d1.j(qVar);
        if (!gVarJ.f2310a) {
            return 0;
        }
        int i = gVarJ.f2311b ? 1536 : 512;
        return gVarJ.f2312c ? i | 2048 : i;
    }

    public final int z0(j2.p pVar, p1.q qVar) {
        int i;
        if (!"OMX.google.raw.decoder".equals(pVar.f6710a) || (i = Build.VERSION.SDK_INT) >= 24 || (i == 23 && s1.b0.M(this.f2313b1))) {
            return qVar.f10024o;
        }
        return -1;
    }

    @Override // a2.g
    public final d1 f() {
        return this;
    }
}
