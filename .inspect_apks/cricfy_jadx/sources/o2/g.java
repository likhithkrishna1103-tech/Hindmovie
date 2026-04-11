package o2;

import android.graphics.Bitmap;
import android.os.Trace;
import androidx.media3.decoder.DecoderInputBuffer;
import g2.n;
import java.util.ArrayDeque;
import l4.c0;
import v1.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends g2.e {
    public final b7.e N;
    public final DecoderInputBuffer O;
    public final ArrayDeque P;
    public boolean Q;
    public boolean R;
    public e S;
    public long T;
    public long U;
    public int V;
    public int W;
    public p X;
    public b Y;
    public DecoderInputBuffer Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public d f9434a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public Bitmap f9435b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f9436c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public f f9437d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public f f9438e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public int f9439f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public boolean f9440g0;

    public g(b7.e eVar) {
        super(4);
        this.N = eVar;
        this.f9434a0 = d.f9427a;
        this.O = DecoderInputBuffer.newNoDataInstance();
        this.S = e.f9428c;
        this.P = new ArrayDeque();
        this.U = -9223372036854775807L;
        this.T = -9223372036854775807L;
        this.V = 0;
        this.W = 1;
    }

    @Override // g2.e
    public final int A(p pVar) {
        this.N.getClass();
        return b7.e.d(pVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean C(long r13) throws g2.n {
        /*
            Method dump skipped, instruction units count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o2.g.C(long):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean D(long r12) {
        /*
            Method dump skipped, instruction units count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o2.g.D(long):boolean");
    }

    public final void E() throws n {
        if (this.f9440g0) {
            p pVar = this.X;
            pVar.getClass();
            b7.e eVar = this.N;
            eVar.getClass();
            int iD = b7.e.d(pVar);
            if (iD != q4.a.d(4, 0, 0, 0) && iD != q4.a.d(3, 0, 0, 0)) {
                throw a(new c("Provided decoder factory can't create decoder for format."), this.X, false, 4005);
            }
            b bVar = this.Y;
            if (bVar != null) {
                bVar.release();
            }
            this.Y = new b(eVar.f1830a);
            this.f9440g0 = false;
        }
    }

    public final void F() {
        this.Z = null;
        this.V = 0;
        this.U = -9223372036854775807L;
        b bVar = this.Y;
        if (bVar != null) {
            bVar.release();
            this.Y = null;
        }
    }

    @Override // g2.e, g2.k1
    public final void b(int i, Object obj) {
        if (i != 15) {
            return;
        }
        d dVar = obj instanceof d ? (d) obj : null;
        if (dVar == null) {
            dVar = d.f9427a;
        }
        this.f9434a0 = dVar;
    }

    @Override // g2.e
    public final String j() {
        return "ImageRenderer";
    }

    @Override // g2.e
    public final boolean l() {
        return this.R;
    }

    @Override // g2.e
    public final boolean m() {
        int i = this.W;
        if (i != 3) {
            return i == 0 && this.f9436c0;
        }
        return true;
    }

    @Override // g2.e
    public final void o() {
        this.X = null;
        this.S = e.f9428c;
        this.P.clear();
        F();
        this.f9434a0.getClass();
    }

    @Override // g2.e
    public final void p(boolean z10, boolean z11) {
        this.W = z11 ? 1 : 0;
    }

    @Override // g2.e
    public final void q(boolean z10, long j4) {
        this.W = Math.min(this.W, 1);
        this.R = false;
        this.Q = false;
        this.f9435b0 = null;
        this.f9437d0 = null;
        this.f9438e0 = null;
        this.f9436c0 = false;
        this.Z = null;
        b bVar = this.Y;
        if (bVar != null) {
            bVar.flush();
        }
        this.P.clear();
    }

    @Override // g2.e
    public final void r() {
        F();
    }

    @Override // g2.e
    public final void s() {
        F();
        this.W = Math.min(this.W, 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
    
        if (r2 >= r6) goto L15;
     */
    @Override // g2.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(v1.p[] r5, long r6, long r8, s2.c0 r10) {
        /*
            r4 = this;
            o2.e r5 = r4.S
            long r5 = r5.f9430b
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r5 == 0) goto L31
            java.util.ArrayDeque r5 = r4.P
            boolean r6 = r5.isEmpty()
            if (r6 == 0) goto L26
            long r6 = r4.U
            int r10 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r10 == 0) goto L31
            long r2 = r4.T
            int r10 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r10 == 0) goto L26
            int r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r6 < 0) goto L26
            goto L31
        L26:
            o2.e r6 = new o2.e
            long r0 = r4.U
            r6.<init>(r0, r8)
            r5.add(r6)
            return
        L31:
            o2.e r5 = new o2.e
            r5.<init>(r0, r8)
            r4.S = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o2.g.v(v1.p[], long, long, s2.c0):void");
    }

    @Override // g2.e
    public final void x(long j4, long j7) throws n {
        if (this.R) {
            return;
        }
        if (this.X == null) {
            c0 c0Var = this.f4659x;
            c0Var.q();
            DecoderInputBuffer decoderInputBuffer = this.O;
            decoderInputBuffer.clear();
            int iW = w(c0Var, decoderInputBuffer, 2);
            if (iW != -5) {
                if (iW == -4) {
                    y1.d.g(decoderInputBuffer.isEndOfStream());
                    this.Q = true;
                    this.R = true;
                    return;
                }
                return;
            }
            p pVar = (p) c0Var.f7706x;
            y1.d.h(pVar);
            this.X = pVar;
            this.f9440g0 = true;
        }
        if (this.Y == null) {
            E();
        }
        try {
            Trace.beginSection("drainAndFeedDecoder");
            while (C(j4)) {
            }
            while (D(j4)) {
            }
            Trace.endSection();
        } catch (c e9) {
            throw a(e9, null, false, 4003);
        }
    }
}
