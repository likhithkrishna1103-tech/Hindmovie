package i2;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioTrack;
import android.media.LoudnessCodecController;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import androidx.media3.decoder.DecoderInputBuffer;
import g2.o1;
import g2.t0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashSet;
import java.util.Objects;
import v1.q0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h0 extends p2.r implements t0 {
    public final Context c1;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public final k f6048d1;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public final f0 f6049e1;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public final l7.a f6050f1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public int f6051g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public boolean f6052h1;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public boolean f6053i1;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public v1.p f6054j1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public v1.p f6055k1;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public long f6056l1;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public boolean f6057m1;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public boolean f6058n1;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    public boolean f6059o1;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public int f6060p1;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    public boolean f6061q1;

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    public long f6062r1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(Context context, p2.k kVar, boolean z10, Handler handler, g2.d0 d0Var, f0 f0Var) {
        super(1, kVar, z10, 44100.0f);
        l7.a aVar = Build.VERSION.SDK_INT >= 35 ? new l7.a(9) : null;
        this.c1 = context.getApplicationContext();
        this.f6049e1 = f0Var;
        this.f6050f1 = aVar;
        this.f6060p1 = -1000;
        this.f6048d1 = new k(handler, (l) d0Var);
        this.f6062r1 = -9223372036854775807L;
        f0Var.f6031s = new p6.d(25, this);
    }

    public final void A0() {
        l();
        long jI = this.f6049e1.i();
        if (jI != Long.MIN_VALUE) {
            if (!this.f6057m1) {
                jI = Math.max(this.f6056l1, jI);
            }
            this.f6056l1 = jI;
            this.f6057m1 = false;
        }
    }

    @Override // p2.r
    public final g2.g D(p2.o oVar, v1.p pVar, v1.p pVar2) {
        g2.g gVarB = oVar.b(pVar, pVar2);
        int i = gVarB.f4688e;
        if (this.f9947b0 == null && t0(pVar2)) {
            i |= 32768;
        }
        if (z0(oVar, pVar2) > this.f6051g1) {
            i |= 64;
        }
        int i10 = i;
        return new g2.g(oVar.f9925a, pVar, pVar2, i10 != 0 ? 0 : gVarB.f4687d, i10);
    }

    @Override // p2.r
    public final float M(float f, v1.p pVar, v1.p[] pVarArr) {
        int iMax = -1;
        for (v1.p pVar2 : pVarArr) {
            int i = pVar2.G;
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
    @Override // p2.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.ArrayList N(p2.j r4, v1.p r5, boolean r6) {
        /*
            r3 = this;
            java.lang.String r0 = r5.f12946n
            r1 = 0
            if (r0 != 0) goto L8
            ua.z0 r4 = ua.z0.f12413z
            goto L2f
        L8:
            i2.f0 r0 = r3.f6049e1
            boolean r0 = r0.F(r5)
            if (r0 == 0) goto L2b
            java.lang.String r0 = "audio/raw"
            java.util.List r0 = p2.x.d(r0, r1, r1)
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L1e
            r0 = 0
            goto L24
        L1e:
            java.lang.Object r0 = r0.get(r1)
            p2.o r0 = (p2.o) r0
        L24:
            if (r0 == 0) goto L2b
            ua.z0 r4 = ua.i0.o(r0)
            goto L2f
        L2b:
            ua.z0 r4 = p2.x.f(r4, r5, r6, r1)
        L2f:
            java.util.HashMap r6 = p2.x.f9976a
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>(r4)
            kb.d r4 = new kb.d
            r0 = 7
            r4.<init>(r0, r5)
            p2.s r5 = new p2.s
            r5.<init>(r1, r4)
            java.util.Collections.sort(r6, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.h0.N(p2.j, v1.p, boolean):java.util.ArrayList");
    }

    @Override // p2.r
    public final long O(long j4, long j7) {
        boolean z10 = this.f6062r1 != -9223372036854775807L;
        if (this.f6061q1) {
            f0 f0Var = this.f6049e1;
            long jH = f0Var.h();
            if (z10 && jH != -9223372036854775807L) {
                float fMin = Math.min(jH, this.f6062r1 - j4);
                q0 q0Var = f0Var.D;
                float f = q0Var != null ? q0Var.f12968a : 1.0f;
                this.B.getClass();
                return Math.max(10000L, ((long) ((fMin / f) / 2.0f)) - (y1.a0.O(SystemClock.elapsedRealtime()) - j7));
            }
        } else if (z10 || this.P0) {
            return 1000000L;
        }
        return 10000L;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d5  */
    @Override // p2.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final c2.o P(p2.o r13, v1.p r14, android.media.MediaCrypto r15, float r16) {
        /*
            Method dump skipped, instruction units count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.h0.P(p2.o, v1.p, android.media.MediaCrypto, float):c2.o");
    }

    @Override // p2.r
    public final void Q(DecoderInputBuffer decoderInputBuffer) {
        v1.p pVar;
        y yVar;
        if (Build.VERSION.SDK_INT < 29 || (pVar = decoderInputBuffer.format) == null || !Objects.equals(pVar.f12946n, "audio/opus") || !this.C0) {
            return;
        }
        ByteBuffer byteBuffer = decoderInputBuffer.supplementalData;
        byteBuffer.getClass();
        v1.p pVar2 = decoderInputBuffer.format;
        pVar2.getClass();
        int i = pVar2.I;
        if (byteBuffer.remaining() == 8) {
            int i10 = (int) ((byteBuffer.order(ByteOrder.LITTLE_ENDIAN).getLong() * 48000) / 1000000000);
            f0 f0Var = this.f6049e1;
            AudioTrack audioTrack = f0Var.f6035w;
            if (audioTrack == null || !f0.r(audioTrack) || (yVar = f0Var.f6033u) == null || !yVar.f6157k) {
                return;
            }
            f0Var.f6035w.setOffloadDelayPadding(i, i10);
        }
    }

    @Override // p2.r
    public final void W(Exception exc) {
        y1.b.h("MediaCodecAudioRenderer", "Audio codec error", exc);
        k kVar = this.f6048d1;
        Handler handler = (Handler) kVar.f6085v;
        if (handler != null) {
            handler.post(new i(kVar, exc, 0));
        }
    }

    @Override // p2.r
    public final void X(long j4, long j7, String str) {
        k kVar = this.f6048d1;
        Handler handler = (Handler) kVar.f6085v;
        if (handler != null) {
            handler.post(new i(kVar, str, j4, j7));
        }
    }

    @Override // p2.r
    public final void Y(String str) {
        k kVar = this.f6048d1;
        Handler handler = (Handler) kVar.f6085v;
        if (handler != null) {
            handler.post(new i(kVar, str, 3));
        }
    }

    @Override // p2.r
    public final g2.g Z(l4.c0 c0Var) throws g2.n {
        v1.p pVar = (v1.p) c0Var.f7706x;
        pVar.getClass();
        this.f6054j1 = pVar;
        g2.g gVarZ = super.Z(c0Var);
        k kVar = this.f6048d1;
        Handler handler = (Handler) kVar.f6085v;
        if (handler != null) {
            handler.post(new i(kVar, pVar, gVarZ));
        }
        return gVarZ;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0104 A[Catch: n -> 0x0102, TryCatch #0 {n -> 0x0102, blocks: (B:44:0x00d9, B:47:0x00e1, B:49:0x00e5, B:51:0x00ee, B:55:0x00fc, B:58:0x0104, B:62:0x010b, B:63:0x0110), top: B:67:0x00d9 }] */
    @Override // p2.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a0(v1.p r9, android.media.MediaFormat r10) throws g2.n {
        /*
            Method dump skipped, instruction units count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.h0.a0(v1.p, android.media.MediaFormat):void");
    }

    @Override // g2.e, g2.k1
    public final void b(int i, Object obj) {
        p6.d dVar;
        l7.a aVar;
        f0 f0Var = this.f6049e1;
        if (i == 2) {
            obj.getClass();
            float fFloatValue = ((Float) obj).floatValue();
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
            v1.c cVar = (v1.c) obj;
            cVar.getClass();
            f0Var.z(cVar);
            return;
        }
        if (i == 6) {
            v1.d dVar2 = (v1.d) obj;
            dVar2.getClass();
            f0Var.C(dVar2);
            return;
        }
        if (i == 12) {
            AudioDeviceInfo audioDeviceInfo = (AudioDeviceInfo) obj;
            if (audioDeviceInfo == null) {
                dVar = null;
            } else {
                f0Var.getClass();
                dVar = new p6.d(24, audioDeviceInfo);
            }
            f0Var.f6005b0 = dVar;
            f fVar = f0Var.f6037y;
            if (fVar != null) {
                fVar.f(audioDeviceInfo);
            }
            AudioTrack audioTrack = f0Var.f6035w;
            if (audioTrack != null) {
                p6.d dVar3 = f0Var.f6005b0;
                audioTrack.setPreferredDevice(dVar3 != null ? (AudioDeviceInfo) dVar3.f10037w : null);
                return;
            }
            return;
        }
        if (i == 16) {
            obj.getClass();
            this.f6060p1 = ((Integer) obj).intValue();
            p2.l lVar = this.f9953h0;
            if (lVar != null && Build.VERSION.SDK_INT >= 35) {
                Bundle bundle = new Bundle();
                bundle.putInt("importance", Math.max(0, -this.f6060p1));
                lVar.a(bundle);
                return;
            }
            return;
        }
        if (i == 9) {
            obj.getClass();
            f0Var.E = ((Boolean) obj).booleanValue();
            y yVar = f0Var.f6033u;
            z zVar = new z((yVar == null || !yVar.f6156j) ? f0Var.D : q0.f12966d, -9223372036854775807L, -9223372036854775807L);
            if (f0Var.q()) {
                f0Var.B = zVar;
                return;
            } else {
                f0Var.C = zVar;
                return;
            }
        }
        if (i != 10) {
            if (i == 11) {
                g2.i0 i0Var = (g2.i0) obj;
                i0Var.getClass();
                this.f9948c0 = i0Var;
                return;
            }
            return;
        }
        obj.getClass();
        int iIntValue = ((Integer) obj).intValue();
        f0Var.A(iIntValue);
        if (Build.VERSION.SDK_INT < 35 || (aVar = this.f6050f1) == null) {
            return;
        }
        aVar.I(iIntValue);
    }

    @Override // p2.r
    public final void b0() {
        this.f6049e1.getClass();
    }

    @Override // g2.t0
    public final q0 d() {
        return this.f6049e1.D;
    }

    @Override // p2.r
    public final void d0() {
        this.f6049e1.M = true;
    }

    @Override // g2.t0
    public final void f(q0 q0Var) {
        this.f6049e1.E(q0Var);
    }

    @Override // g2.t0
    public final boolean g() {
        boolean z10 = this.f6059o1;
        this.f6059o1 = false;
        return z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    @Override // p2.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g0(long r1, long r3, p2.l r5, java.nio.ByteBuffer r6, int r7, int r8, int r9, long r10, boolean r12, boolean r13, v1.p r14) throws g2.n {
        /*
            r0 = this;
            r6.getClass()
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0.f6062r1 = r1
            v1.p r1 = r0.f6055k1
            r2 = 1
            if (r1 == 0) goto L1a
            r1 = r8 & 2
            if (r1 == 0) goto L1a
            r5.getClass()
            r5.f(r7)
            return r2
        L1a:
            i2.f0 r1 = r0.f6049e1
            if (r12 == 0) goto L2d
            if (r5 == 0) goto L23
            r5.f(r7)
        L23:
            g2.f r3 = r0.T0
            int r4 = r3.f
            int r4 = r4 + r9
            r3.f = r4
            r1.M = r2
            return r2
        L2d:
            boolean r1 = r1.n(r10, r9, r6)     // Catch: i2.r -> L44 i2.o -> L5e
            if (r1 == 0) goto L40
            if (r5 == 0) goto L38
            r5.f(r7)
        L38:
            g2.f r1 = r0.T0
            int r3 = r1.f4672e
            int r3 = r3 + r9
            r1.f4672e = r3
            return r2
        L40:
            r0.f6062r1 = r10
            r1 = 0
            return r1
        L44:
            r1 = move-exception
            boolean r2 = r0.C0
            if (r2 == 0) goto L55
            g2.o1 r2 = r0.f4660y
            r2.getClass()
            int r2 = r2.f4852a
            if (r2 == 0) goto L55
            r2 = 5003(0x138b, float:7.01E-42)
            goto L57
        L55:
            r2 = 5002(0x138a, float:7.009E-42)
        L57:
            boolean r3 = r1.f6103w
            g2.n r1 = r0.a(r1, r14, r3, r2)
            throw r1
        L5e:
            r1 = move-exception
            v1.p r2 = r0.f6054j1
            boolean r3 = r0.C0
            if (r3 == 0) goto L71
            g2.o1 r3 = r0.f4660y
            r3.getClass()
            int r3 = r3.f4852a
            if (r3 == 0) goto L71
            r3 = 5004(0x138c, float:7.012E-42)
            goto L73
        L71:
            r3 = 5001(0x1389, float:7.008E-42)
        L73:
            boolean r4 = r1.f6100w
            g2.n r1 = r0.a(r1, r2, r4, r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.h0.g0(long, long, p2.l, java.nio.ByteBuffer, int, int, int, long, boolean, boolean, v1.p):boolean");
    }

    @Override // g2.t0
    public final long h() {
        if (this.C == 2) {
            A0();
        }
        return this.f6056l1;
    }

    @Override // g2.e
    public final String j() {
        return "MediaCodecAudioRenderer";
    }

    @Override // p2.r
    public final void j0() throws g2.n {
        try {
            this.f6049e1.w();
            long j4 = this.N0;
            if (j4 != -9223372036854775807L) {
                this.f6062r1 = j4;
            }
        } catch (r e9) {
            throw a(e9, e9.f6104x, e9.f6103w, this.C0 ? 5003 : 5002);
        }
    }

    @Override // g2.e
    public final boolean l() {
        if (!this.P0) {
            return false;
        }
        f0 f0Var = this.f6049e1;
        if (f0Var.q()) {
            return f0Var.T && !f0Var.o();
        }
        return true;
    }

    @Override // p2.r, g2.e
    public final boolean m() {
        return this.f6049e1.o() || super.m();
    }

    @Override // p2.r, g2.e
    public final void o() {
        k kVar = this.f6048d1;
        this.f6058n1 = true;
        this.f6054j1 = null;
        this.f6062r1 = -9223372036854775807L;
        try {
            this.f6049e1.g();
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

    @Override // g2.e
    public final void p(boolean z10, boolean z11) {
        g2.f fVar = new g2.f();
        this.T0 = fVar;
        k kVar = this.f6048d1;
        Handler handler = (Handler) kVar.f6085v;
        if (handler != null) {
            handler.post(new i(kVar, fVar, 4));
        }
        o1 o1Var = this.f4660y;
        o1Var.getClass();
        boolean z12 = o1Var.f4853b;
        f0 f0Var = this.f6049e1;
        if (z12) {
            y1.d.g(f0Var.X);
            if (!f0Var.f6007c0) {
                f0Var.f6007c0 = true;
                f0Var.g();
            }
        } else if (f0Var.f6007c0) {
            f0Var.f6007c0 = false;
            f0Var.g();
        }
        h2.l lVar = this.A;
        lVar.getClass();
        f0Var.f6030r = lVar;
        y1.v vVar = this.B;
        vVar.getClass();
        f0Var.f6015h.G = vVar;
    }

    @Override // p2.r, g2.e
    public final void q(boolean z10, long j4) throws g2.n {
        super.q(z10, j4);
        this.f6049e1.g();
        this.f6056l1 = j4;
        this.f6062r1 = -9223372036854775807L;
        this.f6059o1 = false;
        this.f6057m1 = true;
    }

    @Override // g2.e
    public final void r() {
        l7.a aVar;
        f fVar = this.f6049e1.f6037y;
        if (fVar != null) {
            Context context = (Context) fVar.f5993b;
            if (fVar.f5992a) {
                fVar.f5998h = null;
                d dVar = (d) fVar.f5996e;
                if (dVar != null) {
                    w1.d.g(context).unregisterAudioDeviceCallback(dVar);
                }
                context.unregisterReceiver((com.bumptech.glide.manager.r) fVar.f);
                e eVar = (e) fVar.f5997g;
                if (eVar != null) {
                    eVar.f5988a.unregisterContentObserver(eVar);
                }
                fVar.f5992a = false;
            }
        }
        if (Build.VERSION.SDK_INT < 35 || (aVar = this.f6050f1) == null) {
            return;
        }
        ((HashSet) aVar.f7866w).clear();
        LoudnessCodecController loudnessCodecController = (LoudnessCodecController) aVar.f7868y;
        if (loudnessCodecController != null) {
            loudnessCodecController.close();
        }
    }

    @Override // g2.e
    public final void s() {
        f0 f0Var = this.f6049e1;
        this.f6059o1 = false;
        this.f6062r1 = -9223372036854775807L;
        try {
            try {
                this.C0 = false;
                k0();
                i0();
            } finally {
                l0.e.t(this.f9947b0, null);
                this.f9947b0 = null;
            }
        } finally {
            if (this.f6058n1) {
                this.f6058n1 = false;
                f0Var.y();
            }
        }
    }

    @Override // g2.e
    public final void t() {
        this.f6049e1.u();
        this.f6061q1 = true;
    }

    @Override // p2.r
    public final boolean t0(v1.p pVar) {
        o1 o1Var = this.f4660y;
        o1Var.getClass();
        if (o1Var.f4852a != 0) {
            int iY0 = y0(pVar);
            if ((iY0 & 512) != 0) {
                o1 o1Var2 = this.f4660y;
                o1Var2.getClass();
                if (o1Var2.f4852a == 2 || (iY0 & 1024) != 0) {
                    return true;
                }
                if (pVar.I == 0 && pVar.J == 0) {
                    return true;
                }
            }
        }
        return this.f6049e1.F(pVar);
    }

    @Override // g2.e
    public final void u() {
        A0();
        this.f6061q1 = false;
        this.f6049e1.t();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009b  */
    @Override // p2.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int u0(p2.j r18, v1.p r19) {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.h0.u0(p2.j, v1.p):int");
    }

    public final int y0(v1.p pVar) {
        h hVarJ = this.f6049e1.j(pVar);
        if (!hVarJ.f6045a) {
            return 0;
        }
        int i = hVarJ.f6046b ? 1536 : 512;
        return hVarJ.f6047c ? i | 2048 : i;
    }

    public final int z0(p2.o oVar, v1.p pVar) {
        int i;
        if (!"OMX.google.raw.decoder".equals(oVar.f9925a) || (i = Build.VERSION.SDK_INT) >= 24 || (i == 23 && y1.a0.M(this.c1))) {
            return pVar.f12947o;
        }
        return -1;
    }

    @Override // g2.e
    public final t0 i() {
        return this;
    }
}
