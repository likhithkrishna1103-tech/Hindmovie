package j2;

import a2.r0;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.media3.decoder.DecoderInputBuffer;
import c2.h0;
import h4.z;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class s extends a2.g {
    public static final byte[] a1 = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};
    public boolean A0;
    public boolean B0;
    public boolean C0;
    public boolean D0;
    public boolean E0;
    public int F0;
    public int G0;
    public int H0;
    public boolean I0;
    public boolean J0;
    public boolean K0;
    public long L0;
    public final l M;
    public long M0;
    public final k N;
    public boolean N0;
    public final boolean O;
    public boolean O0;
    public final float P;
    public boolean P0;
    public final DecoderInputBuffer Q;
    public boolean Q0;
    public final DecoderInputBuffer R;
    public a2.q R0;
    public final DecoderInputBuffer S;
    public a2.h S0;
    public final i T;
    public r T0;
    public final MediaCodec.BufferInfo U;
    public long U0;
    public final ArrayDeque V;
    public boolean V0;
    public final h0 W;
    public boolean W0;
    public p1.q X;
    public boolean X0;
    public p1.q Y;
    public long Y0;
    public f2.h Z;
    public long Z0;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public f2.h f6729a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public r0 f6730b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public MediaCrypto f6731c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final long f6732d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public float f6733e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public float f6734f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public m f6735g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public p1.q f6736h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public MediaFormat f6737i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public boolean f6738j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public float f6739k0;
    public ArrayDeque l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public q f6740m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public p f6741n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public int f6742o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f6743p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public boolean f6744q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public boolean f6745r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public boolean f6746s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public boolean f6747t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public long f6748u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public long f6749v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public int f6750w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public int f6751x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public ByteBuffer f6752y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public boolean f6753z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(int i, l lVar, boolean z2, float f) {
        super(i);
        k kVar = k.f6708v;
        this.M = lVar;
        this.N = kVar;
        this.O = z2;
        this.P = f;
        this.Q = DecoderInputBuffer.newNoDataInstance();
        this.R = new DecoderInputBuffer(0);
        this.S = new DecoderInputBuffer(2);
        i iVar = new i(2);
        iVar.f6705w = 32;
        this.T = iVar;
        this.U = new MediaCodec.BufferInfo();
        this.f6733e0 = 1.0f;
        this.f6734f0 = 1.0f;
        this.f6732d0 = -9223372036854775807L;
        this.V = new ArrayDeque();
        this.T0 = r.f6724e;
        iVar.ensureSpaceForWrite(0);
        iVar.data.order(ByteOrder.nativeOrder());
        h0 h0Var = new h0();
        h0Var.f2333a = q1.g.f10547a;
        h0Var.f2335c = 0;
        h0Var.f2334b = 2;
        this.W = h0Var;
        this.f6739k0 = -1.0f;
        this.f6742o0 = 0;
        this.F0 = 0;
        this.f6750w0 = -1;
        this.f6751x0 = -1;
        this.f6749v0 = -9223372036854775807L;
        this.L0 = -9223372036854775807L;
        this.M0 = -9223372036854775807L;
        this.U0 = -9223372036854775807L;
        this.f6748u0 = -9223372036854775807L;
        this.G0 = 0;
        this.H0 = 0;
        this.S0 = new a2.h();
        this.Y0 = -9223372036854775807L;
        this.Z0 = -9223372036854775807L;
    }

    @Override // a2.g
    public final int A(p1.q qVar) throws a2.q {
        try {
            return u0(this.N, qVar);
        } catch (v e10) {
            throw a(e10, qVar, false, 4002);
        }
    }

    @Override // a2.g
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
    /* JADX WARN: Type inference failed for: r24v0, types: [a2.g, j2.s] */
    /* JADX WARN: Type inference failed for: r4v16, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v35, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean C(long r25, long r27) throws a2.q {
        /*
            Method dump skipped, instruction units count: 807
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j2.s.C(long, long):boolean");
    }

    public abstract a2.i D(p pVar, p1.q qVar, p1.q qVar2);

    public o E(IllegalStateException illegalStateException, p pVar) {
        return new o(illegalStateException, pVar);
    }

    public final boolean F() throws a2.q {
        if (!this.I0) {
            w0();
            return true;
        }
        this.G0 = 1;
        if (this.f6744q0) {
            this.H0 = 3;
            return false;
        }
        this.H0 = 2;
        return true;
    }

    public final boolean G(long j5, long j8) throws a2.q {
        m mVar = this.f6735g0;
        mVar.getClass();
        int i = this.f6751x0;
        MediaCodec.BufferInfo bufferInfo = this.U;
        if (i < 0) {
            int iG = mVar.g(bufferInfo);
            if (iG < 0) {
                if (iG == -2) {
                    this.K0 = true;
                    m mVar2 = this.f6735g0;
                    mVar2.getClass();
                    MediaFormat mediaFormatQ = mVar2.q();
                    if (this.f6742o0 != 0 && mediaFormatQ.getInteger("width") == 32 && mediaFormatQ.getInteger("height") == 32) {
                        this.f6746s0 = true;
                        return true;
                    }
                    this.f6737i0 = mediaFormatQ;
                    this.f6738j0 = true;
                    return true;
                }
                if (this.f6747t0 && (this.N0 || this.G0 == 2)) {
                    f0();
                }
                long j10 = this.f6748u0;
                if (j10 != -9223372036854775807L) {
                    long j11 = j10 + 100;
                    this.A.getClass();
                    if (j11 < System.currentTimeMillis()) {
                        f0();
                        return false;
                    }
                }
                return false;
            }
            if (this.f6746s0) {
                this.f6746s0 = false;
                mVar.i(iG);
                return true;
            }
            if (bufferInfo.size == 0 && (bufferInfo.flags & 4) != 0) {
                f0();
                return false;
            }
            this.f6751x0 = iG;
            ByteBuffer byteBufferV = mVar.v(iG);
            this.f6752y0 = byteBufferV;
            if (byteBufferV != null) {
                byteBufferV.position(bufferInfo.offset);
                this.f6752y0.limit(bufferInfo.offset + bufferInfo.size);
            }
            x0(bufferInfo.presentationTimeUs);
        }
        long j12 = bufferInfo.presentationTimeUs;
        this.f6753z0 = j12 < this.F;
        long j13 = this.M0;
        this.A0 = j13 != -9223372036854775807L && j13 <= j12;
        if (this.X0) {
            long j14 = this.Y0;
            if (j14 == -9223372036854775807L || j12 > j14) {
                this.Y0 = j12;
                this.f6753z0 = true;
                this.A0 = false;
            } else {
                this.X0 = false;
                this.Y0 = -9223372036854775807L;
            }
        }
        ByteBuffer byteBuffer = this.f6752y0;
        int i10 = this.f6751x0;
        int i11 = bufferInfo.flags;
        boolean z2 = this.f6753z0;
        boolean z10 = this.A0;
        p1.q qVar = this.Y;
        qVar.getClass();
        if (!g0(j5, j8, mVar, byteBuffer, i10, i11, 1, j12, z2, z10, qVar)) {
            return false;
        }
        c0(bufferInfo.presentationTimeUs);
        boolean z11 = (bufferInfo.flags & 4) != 0;
        if (!z11 && this.J0 && this.A0) {
            this.A.getClass();
            this.f6748u0 = System.currentTimeMillis();
        }
        this.f6751x0 = -1;
        this.f6752y0 = null;
        if (!z11) {
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
    public final boolean H() throws a2.q {
        /*
            Method dump skipped, instruction units count: 477
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j2.s.H():boolean");
    }

    public final void I() {
        try {
            m mVar = this.f6735g0;
            s1.d.h(mVar);
            mVar.flush();
        } finally {
            l0();
        }
    }

    public final boolean J() {
        if (this.f6735g0 != null) {
            if (s0()) {
                i0();
                return true;
            }
            if (q0()) {
                I();
                return false;
            }
            long j5 = this.Z0;
            if (j5 != -9223372036854775807L && this.F <= j5 && this.U0 < j5) {
                this.X0 = true;
                this.Z0 = -9223372036854775807L;
            }
        }
        return false;
    }

    public final List K(boolean z2) {
        p1.q qVar = this.X;
        qVar.getClass();
        k kVar = this.N;
        ArrayList arrayListN = N(kVar, qVar, z2);
        if (!arrayListN.isEmpty() || !z2) {
            return arrayListN;
        }
        ArrayList arrayListN2 = N(kVar, qVar, false);
        if (!arrayListN2.isEmpty()) {
            s1.b.p("MediaCodecRenderer", "Drm session requires secure decoder for " + qVar.f10023n + ", but no secure decoder available. Trying to proceed with " + arrayListN2 + ".");
        }
        return arrayListN2;
    }

    public int L(DecoderInputBuffer decoderInputBuffer) {
        return 0;
    }

    public abstract float M(float f, p1.q qVar, p1.q[] qVarArr);

    public abstract ArrayList N(k kVar, p1.q qVar, boolean z2);

    public long O(long j5, long j8) {
        return super.d(j5, j8);
    }

    public abstract b2.g P(p pVar, p1.q qVar, MediaCrypto mediaCrypto, float f);

    public abstract void Q(DecoderInputBuffer decoderInputBuffer);

    /* JADX WARN: Removed duplicated region for block: B:27:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void R(j2.p r12, android.media.MediaCrypto r13) {
        /*
            Method dump skipped, instruction units count: 451
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j2.s.R(j2.p, android.media.MediaCrypto):void");
    }

    public final boolean S(long j5, long j8) {
        if (j8 >= j5) {
            return false;
        }
        p1.q qVar = this.Y;
        return qVar == null || !Objects.equals(qVar.f10023n, "audio/opus") || j5 - j8 > 80000;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void T() throws a2.q {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j2.s.T():void");
    }

    public final void U(MediaCrypto mediaCrypto, boolean z2) throws q {
        p1.q qVar = this.X;
        qVar.getClass();
        if (this.l0 == null) {
            try {
                List listK = K(z2);
                ArrayDeque arrayDeque = new ArrayDeque();
                this.l0 = arrayDeque;
                if (this.O) {
                    arrayDeque.addAll(listK);
                } else {
                    ArrayList arrayList = (ArrayList) listK;
                    if (!arrayList.isEmpty()) {
                        this.l0.add((p) arrayList.get(0));
                    }
                }
                this.f6740m0 = null;
            } catch (v e10) {
                throw new q(qVar, e10, z2, -49998);
            }
        }
        if (this.l0.isEmpty()) {
            throw new q(qVar, null, z2, -49999);
        }
        ArrayDeque arrayDeque2 = this.l0;
        arrayDeque2.getClass();
        while (this.f6735g0 == null) {
            p pVar = (p) arrayDeque2.peekFirst();
            pVar.getClass();
            if (!V(qVar) || !r0(pVar)) {
                return;
            }
            try {
                R(pVar, mediaCrypto);
            } catch (Exception e11) {
                s1.b.q("MediaCodecRenderer", "Failed to initialize decoder: " + pVar, e11);
                arrayDeque2.removeFirst();
                q qVar2 = new q("Decoder init failed: " + pVar.f6710a + ", " + qVar, e11, qVar.f10023n, z2, pVar, e11 instanceof MediaCodec.CodecException ? ((MediaCodec.CodecException) e11).getDiagnosticInfo() : null);
                W(qVar2);
                q qVar3 = this.f6740m0;
                if (qVar3 == null) {
                    this.f6740m0 = qVar2;
                } else {
                    this.f6740m0 = new q(qVar3.getMessage(), qVar3.getCause(), qVar3.f6720u, qVar3.f6721v, qVar3.f6722w, qVar3.f6723x);
                }
                if (arrayDeque2.isEmpty()) {
                    throw this.f6740m0;
                }
            }
        }
        this.l0 = null;
    }

    public boolean V(p1.q qVar) {
        return true;
    }

    public abstract void W(Exception exc);

    public abstract void X(long j5, long j8, String str);

    public abstract void Y(String str);

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d9, code lost:
    
        if (r4.e(r2) != false) goto L120;
     */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a2.i Z(h4.z r13) throws a2.q {
        /*
            Method dump skipped, instruction units count: 428
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j2.s.Z(h4.z):a2.i");
    }

    public abstract void a0(p1.q qVar, MediaFormat mediaFormat);

    public void c0(long j5) {
        this.U0 = j5;
        while (true) {
            ArrayDeque arrayDeque = this.V;
            if (arrayDeque.isEmpty() || j5 < ((r) arrayDeque.peek()).f6725a) {
                return;
            }
            r rVar = (r) arrayDeque.poll();
            rVar.getClass();
            o0(rVar);
            d0();
        }
    }

    @Override // a2.g
    public final long d(long j5, long j8) {
        return O(j5, j8);
    }

    public abstract void d0();

    public final void f0() throws a2.q {
        int i = this.H0;
        if (i == 1) {
            I();
            return;
        }
        if (i == 2) {
            I();
            w0();
        } else if (i != 3) {
            this.O0 = true;
            j0();
        } else {
            i0();
            T();
        }
    }

    public abstract boolean g0(long j5, long j8, m mVar, ByteBuffer byteBuffer, int i, int i10, int i11, long j10, boolean z2, boolean z10, p1.q qVar);

    public final boolean h0(int i) throws a2.q {
        z zVar = this.f233w;
        zVar.F();
        DecoderInputBuffer decoderInputBuffer = this.Q;
        decoderInputBuffer.clear();
        int iW = w(zVar, decoderInputBuffer, i | 4);
        if (iW == -5) {
            Z(zVar);
            return true;
        }
        if (iW != -4 || !decoderInputBuffer.isEndOfStream()) {
            return false;
        }
        this.N0 = true;
        f0();
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i0() {
        try {
            m mVar = this.f6735g0;
            if (mVar != null) {
                mVar.release();
                this.S0.f245b++;
                p pVar = this.f6741n0;
                pVar.getClass();
                Y(pVar.f6710a);
            }
            this.f6735g0 = null;
            try {
                MediaCrypto mediaCrypto = this.f6731c0;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
            }
        } catch (Throwable th) {
            this.f6735g0 = null;
            try {
                MediaCrypto mediaCrypto2 = this.f6731c0;
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
        this.L0 = -9223372036854775807L;
        this.M0 = -9223372036854775807L;
        this.U0 = -9223372036854775807L;
        this.D0 = false;
        this.T.clear();
        this.S.clear();
        this.C0 = false;
        h0 h0Var = this.W;
        h0Var.getClass();
        h0Var.f2333a = q1.g.f10547a;
        h0Var.f2335c = 0;
        h0Var.f2334b = 2;
    }

    public void l0() {
        this.f6750w0 = -1;
        this.R.data = null;
        this.f6751x0 = -1;
        this.f6752y0 = null;
        this.L0 = -9223372036854775807L;
        this.M0 = -9223372036854775807L;
        this.U0 = -9223372036854775807L;
        this.f6749v0 = -9223372036854775807L;
        this.J0 = false;
        this.f6748u0 = -9223372036854775807L;
        this.I0 = false;
        this.f6745r0 = false;
        this.f6746s0 = false;
        this.f6753z0 = false;
        this.A0 = false;
        this.G0 = 0;
        this.H0 = 0;
        this.F0 = this.E0 ? 1 : 0;
        this.X0 = false;
        this.Y0 = -9223372036854775807L;
        this.Z0 = -9223372036854775807L;
    }

    @Override // a2.g
    public boolean m() {
        if (this.X == null) {
            return false;
        }
        if (n() || this.f6751x0 >= 0) {
            return true;
        }
        if (this.f6749v0 == -9223372036854775807L) {
            return false;
        }
        this.A.getClass();
        return SystemClock.elapsedRealtime() < this.f6749v0;
    }

    public final void m0() {
        l0();
        this.R0 = null;
        this.l0 = null;
        this.f6741n0 = null;
        this.f6736h0 = null;
        this.f6737i0 = null;
        this.f6738j0 = false;
        this.K0 = false;
        this.f6739k0 = -1.0f;
        this.f6742o0 = 0;
        this.f6743p0 = false;
        this.f6744q0 = false;
        this.f6747t0 = false;
        this.E0 = false;
        this.F0 = 0;
    }

    public final void n0(f2.h hVar) {
        e6.j.t(this.Z, hVar);
        this.Z = hVar;
    }

    @Override // a2.g
    public void o() {
        this.X = null;
        o0(r.f6724e);
        this.V.clear();
        if (!this.B0) {
            J();
        } else {
            this.B0 = false;
            k0();
        }
    }

    public final void o0(r rVar) {
        this.T0 = rVar;
        if (rVar.f6727c != -9223372036854775807L) {
            this.V0 = true;
            b0();
        }
    }

    public boolean p0(DecoderInputBuffer decoderInputBuffer) {
        return false;
    }

    @Override // a2.g
    public void q(boolean z2, long j5) throws a2.q {
        this.N0 = false;
        this.O0 = false;
        this.Q0 = false;
        if (this.B0) {
            k0();
        } else if (J()) {
            T();
        }
        if (this.T0.f6728d.h() > 0) {
            this.P0 = true;
        }
        this.T0.f6728d.b();
        this.V.clear();
    }

    public boolean q0() {
        return true;
    }

    public boolean r0(p pVar) {
        return true;
    }

    public boolean s0() {
        int i = this.H0;
        if (i == 3 || ((this.f6743p0 && !this.K0) || (this.f6744q0 && this.J0))) {
            return true;
        }
        if (i != 2) {
            return false;
        }
        try {
            w0();
            return false;
        } catch (a2.q e10) {
            s1.b.q("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e10);
            return true;
        }
    }

    public boolean t0(p1.q qVar) {
        return false;
    }

    public abstract int u0(k kVar, p1.q qVar);

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        if (r4 >= r0) goto L16;
     */
    @Override // a2.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void v(p1.q[] r12, long r13, long r15, o2.d0 r17) {
        /*
            r11 = this;
            j2.r r12 = r11.T0
            long r0 = r12.f6727c
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r12 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r12 != 0) goto L24
            j2.r r4 = new j2.r
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = r13
            r9 = r15
            r4.<init>(r5, r7, r9)
            r11.o0(r4)
            boolean r12 = r11.W0
            if (r12 == 0) goto L56
            r11.d0()
            return
        L24:
            java.util.ArrayDeque r12 = r11.V
            boolean r0 = r12.isEmpty()
            if (r0 == 0) goto L57
            long r0 = r11.L0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L3c
            long r4 = r11.U0
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 == 0) goto L57
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 < 0) goto L57
        L3c:
            j2.r r4 = new j2.r
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = r13
            r9 = r15
            r4.<init>(r5, r7, r9)
            r11.o0(r4)
            j2.r r12 = r11.T0
            long r12 = r12.f6727c
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 == 0) goto L56
            r11.d0()
        L56:
            return
        L57:
            j2.r r0 = new j2.r
            long r1 = r11.L0
            r3 = r13
            r5 = r15
            r0.<init>(r1, r3, r5)
            r12.add(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j2.s.v(p1.q[], long, long, o2.d0):void");
    }

    public final boolean v0(p1.q qVar) throws a2.q {
        if (this.f6735g0 != null && this.H0 != 3 && this.B != 0) {
            float f = this.f6734f0;
            qVar.getClass();
            p1.q[] qVarArr = this.D;
            qVarArr.getClass();
            float fM = M(f, qVar, qVarArr);
            float f4 = this.f6739k0;
            if (f4 != fM) {
                if (fM == -1.0f) {
                    if (this.I0) {
                        this.G0 = 1;
                        this.H0 = 3;
                        return false;
                    }
                    i0();
                    T();
                    return false;
                }
                if (f4 != -1.0f || fM > this.P) {
                    Bundle bundle = new Bundle();
                    bundle.putFloat("operating-rate", fM);
                    m mVar = this.f6735g0;
                    mVar.getClass();
                    mVar.b(bundle);
                    this.f6739k0 = fM;
                }
            }
        }
        return true;
    }

    public final void w0() throws a2.q {
        f2.h hVar = this.f6729a0;
        hVar.getClass();
        y1.b bVarG = hVar.g();
        if (bVarG instanceof f2.v) {
            try {
                MediaCrypto mediaCrypto = this.f6731c0;
                mediaCrypto.getClass();
                mediaCrypto.setMediaDrmSession(((f2.v) bVarG).f4750b);
            } catch (MediaCryptoException e10) {
                throw a(e10, this.X, false, 6006);
            }
        }
        n0(this.f6729a0);
        this.G0 = 0;
        this.H0 = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0078 A[LOOP:1: B:31:0x0053->B:41:0x0078, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0099 A[LOOP:2: B:42:0x0079->B:52:0x0099, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0079 A[EDGE_INSN: B:87:0x0079->B:90:? BREAK  A[LOOP:1: B:31:0x0053->B:41:0x0078], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x009a A[EDGE_INSN: B:88:0x009a->B:53:0x009a BREAK  A[LOOP:2: B:42:0x0079->B:52:0x0099], SYNTHETIC] */
    @Override // a2.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void x(long r12, long r14) throws a2.q {
        /*
            Method dump skipped, instruction units count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j2.s.x(long, long):void");
    }

    public final void x0(long j5) {
        p1.q qVar = (p1.q) this.T0.f6728d.f(j5);
        if (qVar == null && this.V0 && this.f6737i0 != null) {
            qVar = (p1.q) this.T0.f6728d.e();
        }
        if (qVar != null) {
            this.Y = qVar;
        } else if (!this.f6738j0 || this.Y == null) {
            return;
        }
        p1.q qVar2 = this.Y;
        qVar2.getClass();
        a0(qVar2, this.f6737i0);
        this.f6738j0 = false;
        this.V0 = false;
    }

    @Override // a2.g
    public void z(float f, float f4) throws a2.q {
        this.f6733e0 = f;
        this.f6734f0 = f4;
        v0(this.f6736h0);
    }

    public void b0() {
    }

    public void e0(DecoderInputBuffer decoderInputBuffer) {
    }
}
