package p2;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.media3.decoder.DecoderInputBuffer;
import i2.i0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import l4.c0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class r extends g2.e {

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public static final byte[] f9944b1 = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};
    public boolean A0;
    public boolean B0;
    public boolean C0;
    public boolean D0;
    public boolean E0;
    public boolean F0;
    public int G0;
    public int H0;
    public int I0;
    public boolean J0;
    public boolean K0;
    public boolean L0;
    public long M0;
    public final k N;
    public long N0;
    public final j O;
    public boolean O0;
    public final boolean P;
    public boolean P0;
    public final float Q;
    public boolean Q0;
    public final DecoderInputBuffer R;
    public boolean R0;
    public final DecoderInputBuffer S;
    public g2.n S0;
    public final DecoderInputBuffer T;
    public g2.f T0;
    public final h U;
    public q U0;
    public final MediaCodec.BufferInfo V;
    public long V0;
    public final ArrayDeque W;
    public boolean W0;
    public final i0 X;
    public boolean X0;
    public v1.p Y;
    public boolean Y0;
    public v1.p Z;
    public long Z0;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public l2.h f9945a0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public long f9946a1;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public l2.h f9947b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public g2.i0 f9948c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public MediaCrypto f9949d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final long f9950e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public float f9951f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public float f9952g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public l f9953h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public v1.p f9954i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public MediaFormat f9955j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f9956k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public float f9957l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public ArrayDeque f9958m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public p f9959n0;
    public o o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f9960p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public boolean f9961q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public boolean f9962r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public boolean f9963s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public boolean f9964t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public boolean f9965u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public long f9966v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public long f9967w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public int f9968x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public int f9969y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public ByteBuffer f9970z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(int i, k kVar, boolean z10, float f) {
        super(i);
        j jVar = j.f9923w;
        this.N = kVar;
        this.O = jVar;
        this.P = z10;
        this.Q = f;
        this.R = DecoderInputBuffer.newNoDataInstance();
        this.S = new DecoderInputBuffer(0);
        this.T = new DecoderInputBuffer(2);
        h hVar = new h(2);
        hVar.f9920x = 32;
        this.U = hVar;
        this.V = new MediaCodec.BufferInfo();
        this.f9951f0 = 1.0f;
        this.f9952g0 = 1.0f;
        this.f9950e0 = -9223372036854775807L;
        this.W = new ArrayDeque();
        this.U0 = q.f9939e;
        hVar.ensureSpaceForWrite(0);
        hVar.data.order(ByteOrder.nativeOrder());
        i0 i0Var = new i0();
        i0Var.f6067a = w1.h.f13795a;
        i0Var.f6069c = 0;
        i0Var.f6068b = 2;
        this.X = i0Var;
        this.f9957l0 = -1.0f;
        this.f9960p0 = 0;
        this.G0 = 0;
        this.f9968x0 = -1;
        this.f9969y0 = -1;
        this.f9967w0 = -9223372036854775807L;
        this.M0 = -9223372036854775807L;
        this.N0 = -9223372036854775807L;
        this.V0 = -9223372036854775807L;
        this.f9966v0 = -9223372036854775807L;
        this.H0 = 0;
        this.I0 = 0;
        this.T0 = new g2.f();
        this.Z0 = -9223372036854775807L;
        this.f9946a1 = -9223372036854775807L;
    }

    @Override // g2.e
    public final int A(v1.p pVar) throws g2.n {
        try {
            return u0(this.O, pVar);
        } catch (u e9) {
            throw a(e9, pVar, false, 4002);
        }
    }

    @Override // g2.e
    public final int B() {
        return 8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02fb  */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r24v0, types: [g2.e, p2.r] */
    /* JADX WARN: Type inference failed for: r4v16, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v35, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean C(long r25, long r27) throws g2.n {
        /*
            Method dump skipped, instruction units count: 807
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p2.r.C(long, long):boolean");
    }

    public abstract g2.g D(o oVar, v1.p pVar, v1.p pVar2);

    public n E(IllegalStateException illegalStateException, o oVar) {
        return new n(illegalStateException, oVar);
    }

    public final boolean F() throws g2.n {
        if (!this.J0) {
            w0();
            return true;
        }
        this.H0 = 1;
        if (this.f9962r0) {
            this.I0 = 3;
            return false;
        }
        this.I0 = 2;
        return true;
    }

    public final boolean G(long j4, long j7) throws g2.n {
        l lVar = this.f9953h0;
        lVar.getClass();
        int i = this.f9969y0;
        MediaCodec.BufferInfo bufferInfo = this.V;
        if (i < 0) {
            int iE = lVar.e(bufferInfo);
            if (iE < 0) {
                if (iE == -2) {
                    this.L0 = true;
                    l lVar2 = this.f9953h0;
                    lVar2.getClass();
                    MediaFormat mediaFormatM = lVar2.m();
                    if (this.f9960p0 != 0 && mediaFormatM.getInteger("width") == 32 && mediaFormatM.getInteger("height") == 32) {
                        this.f9964t0 = true;
                        return true;
                    }
                    this.f9955j0 = mediaFormatM;
                    this.f9956k0 = true;
                    return true;
                }
                if (this.f9965u0 && (this.O0 || this.H0 == 2)) {
                    f0();
                }
                long j10 = this.f9966v0;
                if (j10 != -9223372036854775807L) {
                    long j11 = j10 + 100;
                    this.B.getClass();
                    if (j11 < System.currentTimeMillis()) {
                        f0();
                        return false;
                    }
                }
                return false;
            }
            if (this.f9964t0) {
                this.f9964t0 = false;
                lVar.f(iE);
                return true;
            }
            if (bufferInfo.size == 0 && (bufferInfo.flags & 4) != 0) {
                f0();
                return false;
            }
            this.f9969y0 = iE;
            ByteBuffer byteBufferQ = lVar.q(iE);
            this.f9970z0 = byteBufferQ;
            if (byteBufferQ != null) {
                byteBufferQ.position(bufferInfo.offset);
                this.f9970z0.limit(bufferInfo.offset + bufferInfo.size);
            }
            x0(bufferInfo.presentationTimeUs);
        }
        long j12 = bufferInfo.presentationTimeUs;
        this.A0 = j12 < this.G;
        long j13 = this.N0;
        this.B0 = j13 != -9223372036854775807L && j13 <= j12;
        if (this.Y0) {
            long j14 = this.Z0;
            if (j14 == -9223372036854775807L || j12 > j14) {
                this.Z0 = j12;
                this.A0 = true;
                this.B0 = false;
            } else {
                this.Y0 = false;
                this.Z0 = -9223372036854775807L;
            }
        }
        ByteBuffer byteBuffer = this.f9970z0;
        int i10 = this.f9969y0;
        int i11 = bufferInfo.flags;
        boolean z10 = this.A0;
        boolean z11 = this.B0;
        v1.p pVar = this.Z;
        pVar.getClass();
        if (!g0(j4, j7, lVar, byteBuffer, i10, i11, 1, j12, z10, z11, pVar)) {
            return false;
        }
        c0(bufferInfo.presentationTimeUs);
        boolean z12 = (bufferInfo.flags & 4) != 0;
        if (!z12 && this.K0 && this.B0) {
            this.B.getClass();
            this.f9966v0 = System.currentTimeMillis();
        }
        this.f9969y0 = -1;
        this.f9970z0 = null;
        if (!z12) {
            return true;
        }
        f0();
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean H() throws g2.n {
        /*
            Method dump skipped, instruction units count: 477
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p2.r.H():boolean");
    }

    public final void I() {
        try {
            l lVar = this.f9953h0;
            y1.d.h(lVar);
            lVar.flush();
        } finally {
            l0();
        }
    }

    public final boolean J() {
        if (this.f9953h0 != null) {
            if (s0()) {
                i0();
                return true;
            }
            if (q0()) {
                I();
                return false;
            }
            long j4 = this.f9946a1;
            if (j4 != -9223372036854775807L && this.G <= j4 && this.V0 < j4) {
                this.Y0 = true;
                this.f9946a1 = -9223372036854775807L;
            }
        }
        return false;
    }

    public final List K(boolean z10) {
        v1.p pVar = this.Y;
        pVar.getClass();
        j jVar = this.O;
        ArrayList arrayListN = N(jVar, pVar, z10);
        if (!arrayListN.isEmpty() || !z10) {
            return arrayListN;
        }
        ArrayList arrayListN2 = N(jVar, pVar, false);
        if (!arrayListN2.isEmpty()) {
            y1.b.p("MediaCodecRenderer", "Drm session requires secure decoder for " + pVar.f12946n + ", but no secure decoder available. Trying to proceed with " + arrayListN2 + ".");
        }
        return arrayListN2;
    }

    public int L(DecoderInputBuffer decoderInputBuffer) {
        return 0;
    }

    public abstract float M(float f, v1.p pVar, v1.p[] pVarArr);

    public abstract ArrayList N(j jVar, v1.p pVar, boolean z10);

    public long O(long j4, long j7) {
        return super.e(j4, j7);
    }

    public abstract c2.o P(o oVar, v1.p pVar, MediaCrypto mediaCrypto, float f);

    public abstract void Q(DecoderInputBuffer decoderInputBuffer);

    /* JADX WARN: Removed duplicated region for block: B:27:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void R(p2.o r12, android.media.MediaCrypto r13) {
        /*
            Method dump skipped, instruction units count: 449
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p2.r.R(p2.o, android.media.MediaCrypto):void");
    }

    public final boolean S(long j4, long j7) {
        if (j7 >= j4) {
            return false;
        }
        v1.p pVar = this.Z;
        return pVar == null || !Objects.equals(pVar.f12946n, "audio/opus") || j4 - j7 > 80000;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void T() throws g2.n {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p2.r.T():void");
    }

    public final void U(MediaCrypto mediaCrypto, boolean z10) throws p {
        v1.p pVar = this.Y;
        pVar.getClass();
        if (this.f9958m0 == null) {
            try {
                List listK = K(z10);
                ArrayDeque arrayDeque = new ArrayDeque();
                this.f9958m0 = arrayDeque;
                if (this.P) {
                    arrayDeque.addAll(listK);
                } else {
                    ArrayList arrayList = (ArrayList) listK;
                    if (!arrayList.isEmpty()) {
                        this.f9958m0.add((o) arrayList.get(0));
                    }
                }
                this.f9959n0 = null;
            } catch (u e9) {
                throw new p(pVar, e9, z10, -49998);
            }
        }
        if (this.f9958m0.isEmpty()) {
            throw new p(pVar, null, z10, -49999);
        }
        ArrayDeque arrayDeque2 = this.f9958m0;
        arrayDeque2.getClass();
        while (this.f9953h0 == null) {
            o oVar = (o) arrayDeque2.peekFirst();
            oVar.getClass();
            if (!V(pVar) || !r0(oVar)) {
                return;
            }
            try {
                R(oVar, mediaCrypto);
            } catch (Exception e10) {
                y1.b.q("MediaCodecRenderer", "Failed to initialize decoder: " + oVar, e10);
                arrayDeque2.removeFirst();
                p pVar2 = new p("Decoder init failed: " + oVar.f9925a + ", " + pVar, e10, pVar.f12946n, z10, oVar, e10 instanceof MediaCodec.CodecException ? ((MediaCodec.CodecException) e10).getDiagnosticInfo() : null);
                W(pVar2);
                p pVar3 = this.f9959n0;
                if (pVar3 == null) {
                    this.f9959n0 = pVar2;
                } else {
                    this.f9959n0 = new p(pVar3.getMessage(), pVar3.getCause(), pVar3.f9935v, pVar3.f9936w, pVar3.f9937x, pVar3.f9938y);
                }
                if (arrayDeque2.isEmpty()) {
                    throw this.f9959n0;
                }
            }
        }
        this.f9958m0 = null;
    }

    public boolean V(v1.p pVar) {
        return true;
    }

    public abstract void W(Exception exc);

    public abstract void X(long j4, long j7, String str);

    public abstract void Y(String str);

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d9, code lost:
    
        if (r4.e(r2) != false) goto L120;
     */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public g2.g Z(l4.c0 r13) throws g2.n {
        /*
            Method dump skipped, instruction units count: 428
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p2.r.Z(l4.c0):g2.g");
    }

    public abstract void a0(v1.p pVar, MediaFormat mediaFormat);

    public void c0(long j4) {
        this.V0 = j4;
        while (true) {
            ArrayDeque arrayDeque = this.W;
            if (arrayDeque.isEmpty() || j4 < ((q) arrayDeque.peek()).f9940a) {
                return;
            }
            q qVar = (q) arrayDeque.poll();
            qVar.getClass();
            o0(qVar);
            d0();
        }
    }

    public abstract void d0();

    @Override // g2.e
    public final long e(long j4, long j7) {
        return O(j4, j7);
    }

    public final void f0() throws g2.n {
        int i = this.I0;
        if (i == 1) {
            I();
            return;
        }
        if (i == 2) {
            I();
            w0();
        } else if (i != 3) {
            this.P0 = true;
            j0();
        } else {
            i0();
            T();
        }
    }

    public abstract boolean g0(long j4, long j7, l lVar, ByteBuffer byteBuffer, int i, int i10, int i11, long j10, boolean z10, boolean z11, v1.p pVar);

    public final boolean h0(int i) throws g2.n {
        c0 c0Var = this.f4659x;
        c0Var.q();
        DecoderInputBuffer decoderInputBuffer = this.R;
        decoderInputBuffer.clear();
        int iW = w(c0Var, decoderInputBuffer, i | 4);
        if (iW == -5) {
            Z(c0Var);
            return true;
        }
        if (iW != -4 || !decoderInputBuffer.isEndOfStream()) {
            return false;
        }
        this.O0 = true;
        f0();
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i0() {
        try {
            l lVar = this.f9953h0;
            if (lVar != null) {
                lVar.release();
                this.T0.f4669b++;
                o oVar = this.o0;
                oVar.getClass();
                Y(oVar.f9925a);
            }
            this.f9953h0 = null;
            try {
                MediaCrypto mediaCrypto = this.f9949d0;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
            }
        } catch (Throwable th) {
            this.f9953h0 = null;
            try {
                MediaCrypto mediaCrypto2 = this.f9949d0;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th;
            } finally {
            }
        }
    }

    public abstract void j0();

    public final void k0() {
        this.M0 = -9223372036854775807L;
        this.N0 = -9223372036854775807L;
        this.V0 = -9223372036854775807L;
        this.E0 = false;
        this.U.clear();
        this.T.clear();
        this.D0 = false;
        i0 i0Var = this.X;
        i0Var.getClass();
        i0Var.f6067a = w1.h.f13795a;
        i0Var.f6069c = 0;
        i0Var.f6068b = 2;
    }

    public void l0() {
        this.f9968x0 = -1;
        this.S.data = null;
        this.f9969y0 = -1;
        this.f9970z0 = null;
        this.M0 = -9223372036854775807L;
        this.N0 = -9223372036854775807L;
        this.V0 = -9223372036854775807L;
        this.f9967w0 = -9223372036854775807L;
        this.K0 = false;
        this.f9966v0 = -9223372036854775807L;
        this.J0 = false;
        this.f9963s0 = false;
        this.f9964t0 = false;
        this.A0 = false;
        this.B0 = false;
        this.H0 = 0;
        this.I0 = 0;
        this.G0 = this.F0 ? 1 : 0;
        this.Y0 = false;
        this.Z0 = -9223372036854775807L;
        this.f9946a1 = -9223372036854775807L;
    }

    @Override // g2.e
    public boolean m() {
        if (this.Y == null) {
            return false;
        }
        if (n() || this.f9969y0 >= 0) {
            return true;
        }
        if (this.f9967w0 == -9223372036854775807L) {
            return false;
        }
        this.B.getClass();
        return SystemClock.elapsedRealtime() < this.f9967w0;
    }

    public final void m0() {
        l0();
        this.S0 = null;
        this.f9958m0 = null;
        this.o0 = null;
        this.f9954i0 = null;
        this.f9955j0 = null;
        this.f9956k0 = false;
        this.L0 = false;
        this.f9957l0 = -1.0f;
        this.f9960p0 = 0;
        this.f9961q0 = false;
        this.f9962r0 = false;
        this.f9965u0 = false;
        this.F0 = false;
        this.G0 = 0;
    }

    public final void n0(l2.h hVar) {
        l0.e.t(this.f9945a0, hVar);
        this.f9945a0 = hVar;
    }

    @Override // g2.e
    public void o() {
        this.Y = null;
        o0(q.f9939e);
        this.W.clear();
        if (!this.C0) {
            J();
        } else {
            this.C0 = false;
            k0();
        }
    }

    public final void o0(q qVar) {
        this.U0 = qVar;
        if (qVar.f9942c != -9223372036854775807L) {
            this.W0 = true;
            b0();
        }
    }

    public boolean p0(DecoderInputBuffer decoderInputBuffer) {
        return false;
    }

    @Override // g2.e
    public void q(boolean z10, long j4) throws g2.n {
        this.O0 = false;
        this.P0 = false;
        this.R0 = false;
        if (this.C0) {
            k0();
        } else if (J()) {
            T();
        }
        if (this.U0.f9943d.h() > 0) {
            this.Q0 = true;
        }
        this.U0.f9943d.b();
        this.W.clear();
    }

    public boolean q0() {
        return true;
    }

    public boolean r0(o oVar) {
        return true;
    }

    public boolean s0() {
        int i = this.I0;
        if (i == 3 || ((this.f9961q0 && !this.L0) || (this.f9962r0 && this.K0))) {
            return true;
        }
        if (i != 2) {
            return false;
        }
        try {
            w0();
            return false;
        } catch (g2.n e9) {
            y1.b.q("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e9);
            return true;
        }
    }

    public boolean t0(v1.p pVar) {
        return false;
    }

    public abstract int u0(j jVar, v1.p pVar);

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        if (r4 >= r0) goto L16;
     */
    @Override // g2.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void v(v1.p[] r12, long r13, long r15, s2.c0 r17) {
        /*
            r11 = this;
            p2.q r12 = r11.U0
            long r0 = r12.f9942c
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r12 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r12 != 0) goto L24
            p2.q r4 = new p2.q
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = r13
            r9 = r15
            r4.<init>(r5, r7, r9)
            r11.o0(r4)
            boolean r12 = r11.X0
            if (r12 == 0) goto L56
            r11.d0()
            return
        L24:
            java.util.ArrayDeque r12 = r11.W
            boolean r0 = r12.isEmpty()
            if (r0 == 0) goto L57
            long r0 = r11.M0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L3c
            long r4 = r11.V0
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 == 0) goto L57
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 < 0) goto L57
        L3c:
            p2.q r4 = new p2.q
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = r13
            r9 = r15
            r4.<init>(r5, r7, r9)
            r11.o0(r4)
            p2.q r12 = r11.U0
            long r12 = r12.f9942c
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 == 0) goto L56
            r11.d0()
        L56:
            return
        L57:
            p2.q r0 = new p2.q
            long r1 = r11.M0
            r3 = r13
            r5 = r15
            r0.<init>(r1, r3, r5)
            r12.add(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p2.r.v(v1.p[], long, long, s2.c0):void");
    }

    public final boolean v0(v1.p pVar) throws g2.n {
        if (this.f9953h0 != null && this.I0 != 3 && this.C != 0) {
            float f = this.f9952g0;
            pVar.getClass();
            v1.p[] pVarArr = this.E;
            pVarArr.getClass();
            float fM = M(f, pVar, pVarArr);
            float f10 = this.f9957l0;
            if (f10 != fM) {
                if (fM == -1.0f) {
                    if (this.J0) {
                        this.H0 = 1;
                        this.I0 = 3;
                        return false;
                    }
                    i0();
                    T();
                    return false;
                }
                if (f10 != -1.0f || fM > this.Q) {
                    Bundle bundle = new Bundle();
                    bundle.putFloat("operating-rate", fM);
                    l lVar = this.f9953h0;
                    lVar.getClass();
                    lVar.a(bundle);
                    this.f9957l0 = fM;
                }
            }
        }
        return true;
    }

    public final void w0() throws g2.n {
        l2.h hVar = this.f9947b0;
        hVar.getClass();
        e2.b bVarG = hVar.g();
        if (bVarG instanceof l2.v) {
            try {
                MediaCrypto mediaCrypto = this.f9949d0;
                mediaCrypto.getClass();
                mediaCrypto.setMediaDrmSession(((l2.v) bVarG).f7683b);
            } catch (MediaCryptoException e9) {
                throw a(e9, this.Y, false, 6006);
            }
        }
        n0(this.f9947b0);
        this.H0 = 0;
        this.I0 = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0078 A[LOOP:1: B:31:0x0053->B:41:0x0078, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0099 A[LOOP:2: B:42:0x0079->B:52:0x0099, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0079 A[EDGE_INSN: B:87:0x0079->B:90:? BREAK  A[LOOP:1: B:31:0x0053->B:41:0x0078], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x009a A[EDGE_INSN: B:88:0x009a->B:53:0x009a BREAK  A[LOOP:2: B:42:0x0079->B:52:0x0099], SYNTHETIC] */
    @Override // g2.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void x(long r12, long r14) throws g2.n {
        /*
            Method dump skipped, instruction units count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p2.r.x(long, long):void");
    }

    public final void x0(long j4) {
        v1.p pVar = (v1.p) this.U0.f9943d.f(j4);
        if (pVar == null && this.W0 && this.f9955j0 != null) {
            pVar = (v1.p) this.U0.f9943d.e();
        }
        if (pVar != null) {
            this.Z = pVar;
        } else if (!this.f9956k0 || this.Z == null) {
            return;
        }
        v1.p pVar2 = this.Z;
        pVar2.getClass();
        a0(pVar2, this.f9955j0);
        this.f9956k0 = false;
        this.W0 = false;
    }

    @Override // g2.e
    public void z(float f, float f10) throws g2.n {
        this.f9951f0 = f;
        this.f9952g0 = f10;
        v0(this.f9954i0);
    }

    public void b0() {
    }

    public void e0(DecoderInputBuffer decoderInputBuffer) {
    }
}
