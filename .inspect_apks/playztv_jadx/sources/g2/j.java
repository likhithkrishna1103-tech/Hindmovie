package g2;

import aa.c1;
import aa.h0;
import aa.j0;
import android.net.Uri;
import d4.f0;
import java.io.EOFException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import s1.u;
import s1.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j extends p2.m {

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final AtomicInteger f4881g0 = new AtomicInteger();
    public final int E;
    public final int F;
    public final Uri G;
    public final boolean H;
    public final int I;
    public final v1.h J;
    public final v1.m K;
    public final b L;
    public final boolean M;
    public final boolean N;
    public final z O;
    public final c P;
    public final List Q;
    public final p1.m R;
    public final k3.h S;
    public final u T;
    public final boolean U;
    public final boolean V;
    public b W;
    public q X;
    public int Y;
    public boolean Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public volatile boolean f4882a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f4883b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public j0 f4884c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f4885d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public long f4886e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f4887f0;

    public j(c cVar, v1.h hVar, v1.m mVar, p1.q qVar, boolean z2, v1.h hVar2, v1.m mVar2, boolean z10, Uri uri, List list, int i, Object obj, long j5, long j8, long j10, int i10, boolean z11, int i11, boolean z12, boolean z13, z zVar, p1.m mVar3, b bVar, k3.h hVar3, u uVar, boolean z14, boolean z15, b2.o oVar) {
        super(hVar, mVar, qVar, i, obj, j5, j8, j10);
        this.U = z2;
        this.I = i10;
        this.f4886e0 = z11 ? j8 - j5 : -9223372036854775807L;
        this.F = i11;
        this.K = mVar2;
        this.J = hVar2;
        this.Z = mVar2 != null;
        this.V = z10;
        this.G = uri;
        this.M = z13;
        this.O = zVar;
        this.N = z12;
        this.P = cVar;
        this.Q = list;
        this.R = mVar3;
        this.L = bVar;
        this.S = hVar3;
        this.T = uVar;
        this.f4887f0 = z14;
        this.H = z15;
        h0 h0Var = j0.f690v;
        this.f4884c0 = c1.f650y;
        this.E = f4881g0.getAndIncrement();
    }

    public static byte[] f(String str) {
        if (com.bumptech.glide.d.X(str).startsWith("0x")) {
            str = str.substring(2);
        }
        byte[] byteArray = new BigInteger(str, 16).toByteArray();
        byte[] bArr = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr, (16 - byteArray.length) + length, byteArray.length - length);
        return bArr;
    }

    @Override // s2.j
    public final void b() {
        b bVar;
        this.X.getClass();
        if (this.W == null && (bVar = this.L) != null) {
            w2.o oVarA = bVar.f4849a.a();
            if ((oVarA instanceof f0) || (oVarA instanceof q3.k)) {
                this.W = this.L;
                this.Z = false;
            }
        }
        v1.m mVar = this.K;
        v1.h hVar = this.J;
        if (this.Z) {
            hVar.getClass();
            mVar.getClass();
            e(hVar, mVar, this.V, false);
            this.Y = 0;
            this.Z = false;
        }
        if (this.f4882a0) {
            return;
        }
        if (!this.N) {
            e(this.C, this.f10144v, this.U, true);
        }
        this.f4883b0 = !this.f4882a0;
    }

    @Override // s2.j
    public final void c() {
        this.f4882a0 = true;
    }

    @Override // p2.m
    public final boolean d() {
        throw null;
    }

    public final void e(v1.h hVar, v1.m mVar, boolean z2, boolean z10) {
        v1.m mVarC;
        boolean z11;
        long j5;
        if (z2) {
            z11 = this.Y != 0;
            mVarC = mVar;
        } else {
            mVarC = mVar.c(this.Y);
            z11 = false;
        }
        try {
            w2.l lVarI = i(hVar, mVarC, z10);
            if (z11) {
                lVarI.n(this.Y, false);
            }
            while (!this.f4882a0 && this.W.f4849a.l(lVarI, b.f) == 0) {
                try {
                    try {
                    } catch (Throwable th) {
                        this.Y = (int) (lVarI.f13653x - mVar.f);
                        throw th;
                    }
                } catch (EOFException e10) {
                    if ((this.f10146x.f & 16384) == 0) {
                        throw e10;
                    }
                    this.W.f4849a.f(0L, 0L);
                    j5 = lVarI.f13653x;
                }
            }
            j5 = lVarI.f13653x;
            this.Y = (int) (j5 - mVar.f);
        } finally {
            com.bumptech.glide.c.f(hVar);
        }
    }

    public final int g(int i) {
        s1.d.g(!this.f4887f0);
        if (i >= this.f4884c0.size()) {
            return 0;
        }
        return ((Integer) this.f4884c0.get(i)).intValue();
    }

    public final boolean h() {
        return this.f4886e0 != -9223372036854775807L;
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final w2.l i(v1.h r35, v1.m r36, boolean r37) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1023
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.j.i(v1.h, v1.m, boolean):w2.l");
    }
}
