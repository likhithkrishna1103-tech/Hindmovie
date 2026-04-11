package i2;

import a2.g;
import android.graphics.Bitmap;
import android.os.Trace;
import androidx.media3.decoder.DecoderInputBuffer;
import c7.k;
import h4.z;
import java.util.ArrayDeque;
import p1.q;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f extends g {
    public final k M;
    public final DecoderInputBuffer N;
    public final ArrayDeque O;
    public boolean P;
    public boolean Q;
    public e R;
    public long S;
    public long T;
    public int U;
    public int V;
    public q W;
    public b X;
    public DecoderInputBuffer Y;
    public d Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public Bitmap f6194a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f6195b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public a7.c f6196c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public a7.c f6197d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f6198e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f6199f0;

    public f(k kVar) {
        super(4);
        this.M = kVar;
        this.Z = d.f6190a;
        this.N = DecoderInputBuffer.newNoDataInstance();
        this.R = e.f6191c;
        this.O = new ArrayDeque();
        this.T = -9223372036854775807L;
        this.S = -9223372036854775807L;
        this.U = 0;
        this.V = 1;
    }

    @Override // a2.g
    public final int A(q qVar) {
        this.M.getClass();
        return k.b(qVar);
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
    public final boolean C(long r13) throws a2.q {
        /*
            Method dump skipped, instruction units count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.f.C(long):boolean");
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
        throw new UnsupportedOperationException("Method not decompiled: i2.f.D(long):boolean");
    }

    public final void E() throws a2.q {
        if (this.f6199f0) {
            q qVar = this.W;
            qVar.getClass();
            k kVar = this.M;
            kVar.getClass();
            int iB = k.b(qVar);
            if (iB != l4.a.g(4, 0, 0, 0) && iB != l4.a.g(3, 0, 0, 0)) {
                throw a(new c("Provided decoder factory can't create decoder for format."), this.W, false, 4005);
            }
            b bVar = this.X;
            if (bVar != null) {
                bVar.release();
            }
            this.X = new b(kVar.f2563u);
            this.f6199f0 = false;
        }
    }

    public final void F() {
        this.Y = null;
        this.U = 0;
        this.T = -9223372036854775807L;
        b bVar = this.X;
        if (bVar != null) {
            bVar.release();
            this.X = null;
        }
    }

    @Override // a2.g, a2.w1
    public final void b(int i, Object obj) {
        if (i != 15) {
            return;
        }
        d dVar = obj instanceof d ? (d) obj : null;
        if (dVar == null) {
            dVar = d.f6190a;
        }
        this.Z = dVar;
    }

    @Override // a2.g
    public final String g() {
        return "ImageRenderer";
    }

    @Override // a2.g
    public final boolean l() {
        return this.Q;
    }

    @Override // a2.g
    public final boolean m() {
        int i = this.V;
        if (i != 3) {
            return i == 0 && this.f6195b0;
        }
        return true;
    }

    @Override // a2.g
    public final void o() {
        this.W = null;
        this.R = e.f6191c;
        this.O.clear();
        F();
        this.Z.getClass();
    }

    @Override // a2.g
    public final void p(boolean z2, boolean z10) {
        this.V = z10 ? 1 : 0;
    }

    @Override // a2.g
    public final void q(boolean z2, long j5) {
        this.V = Math.min(this.V, 1);
        this.Q = false;
        this.P = false;
        this.f6194a0 = null;
        this.f6196c0 = null;
        this.f6197d0 = null;
        this.f6195b0 = false;
        this.Y = null;
        b bVar = this.X;
        if (bVar != null) {
            bVar.flush();
        }
        this.O.clear();
    }

    @Override // a2.g
    public final void r() {
        F();
    }

    @Override // a2.g
    public final void s() {
        F();
        this.V = Math.min(this.V, 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
    
        if (r2 >= r6) goto L15;
     */
    @Override // a2.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(p1.q[] r5, long r6, long r8, o2.d0 r10) {
        /*
            r4 = this;
            i2.e r5 = r4.R
            long r5 = r5.f6193b
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r5 == 0) goto L31
            java.util.ArrayDeque r5 = r4.O
            boolean r6 = r5.isEmpty()
            if (r6 == 0) goto L26
            long r6 = r4.T
            int r10 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r10 == 0) goto L31
            long r2 = r4.S
            int r10 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r10 == 0) goto L26
            int r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r6 < 0) goto L26
            goto L31
        L26:
            i2.e r6 = new i2.e
            long r0 = r4.T
            r6.<init>(r0, r8)
            r5.add(r6)
            return
        L31:
            i2.e r5 = new i2.e
            r5.<init>(r0, r8)
            r4.R = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.f.v(p1.q[], long, long, o2.d0):void");
    }

    @Override // a2.g
    public final void x(long j5, long j8) throws a2.q {
        if (this.Q) {
            return;
        }
        if (this.W == null) {
            z zVar = this.f233w;
            zVar.F();
            DecoderInputBuffer decoderInputBuffer = this.N;
            decoderInputBuffer.clear();
            int iW = w(zVar, decoderInputBuffer, 2);
            if (iW != -5) {
                if (iW == -4) {
                    s1.d.g(decoderInputBuffer.isEndOfStream());
                    this.P = true;
                    this.Q = true;
                    return;
                }
                return;
            }
            q qVar = (q) zVar.f5868w;
            s1.d.h(qVar);
            this.W = qVar;
            this.f6199f0 = true;
        }
        if (this.X == null) {
            E();
        }
        try {
            Trace.beginSection("drainAndFeedDecoder");
            while (C(j5)) {
            }
            while (D(j5)) {
            }
            Trace.endSection();
        } catch (c e10) {
            throw a(e10, null, false, 4003);
        }
    }
}
