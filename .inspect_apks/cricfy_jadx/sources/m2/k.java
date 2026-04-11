package m2;

import android.net.Uri;
import h4.e0;
import java.io.EOFException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import ua.g0;
import ua.i0;
import ua.z0;
import y1.y;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k extends t2.k {

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final AtomicInteger f8075h0 = new AtomicInteger();
    public final int F;
    public final int G;
    public final Uri H;
    public final boolean I;
    public final int J;
    public final b2.h K;
    public final b2.o L;
    public final b M;
    public final boolean N;
    public final boolean O;
    public final y P;
    public final c Q;
    public final List R;
    public final v1.l S;
    public final o3.h T;
    public final y1.t U;
    public final boolean V;
    public final boolean W;
    public b X;
    public r Y;
    public int Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f8076a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public volatile boolean f8077b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f8078c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public i0 f8079d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f8080e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public long f8081f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public boolean f8082g0;

    public k(c cVar, b2.h hVar, b2.o oVar, v1.p pVar, boolean z10, b2.h hVar2, b2.o oVar2, boolean z11, Uri uri, List list, int i, Object obj, long j4, long j7, long j10, int i10, boolean z12, int i11, boolean z13, boolean z14, y yVar, v1.l lVar, b bVar, o3.h hVar3, y1.t tVar, boolean z15, boolean z16, h2.l lVar2) {
        super(hVar, oVar, pVar, i, obj, j4, j7, j10);
        this.V = z10;
        this.J = i10;
        this.f8081f0 = z12 ? j7 - j4 : -9223372036854775807L;
        this.G = i11;
        this.L = oVar2;
        this.K = hVar2;
        this.f8076a0 = oVar2 != null;
        this.W = z11;
        this.H = uri;
        this.N = z14;
        this.P = yVar;
        this.O = z13;
        this.Q = cVar;
        this.R = list;
        this.S = lVar;
        this.M = bVar;
        this.T = hVar3;
        this.U = tVar;
        this.f8082g0 = z15;
        this.I = z16;
        g0 g0Var = i0.f12341w;
        this.f8079d0 = z0.f12413z;
        this.F = f8075h0.getAndIncrement();
    }

    public static byte[] f(String str) {
        if (android.support.v4.media.session.b.O(str).startsWith("0x")) {
            str = str.substring(2);
        }
        byte[] byteArray = new BigInteger(str, 16).toByteArray();
        byte[] bArr = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr, (16 - byteArray.length) + length, byteArray.length - length);
        return bArr;
    }

    @Override // w2.k
    public final void a() {
        b bVar;
        this.Y.getClass();
        if (this.X == null && (bVar = this.M) != null) {
            a3.p pVarA = bVar.f8042a.a();
            if ((pVarA instanceof e0) || (pVarA instanceof u3.j)) {
                this.X = this.M;
                this.f8076a0 = false;
            }
        }
        b2.o oVar = this.L;
        b2.h hVar = this.K;
        if (this.f8076a0) {
            hVar.getClass();
            oVar.getClass();
            e(hVar, oVar, this.W, false);
            this.Z = 0;
            this.f8076a0 = false;
        }
        if (this.f8077b0) {
            return;
        }
        if (!this.O) {
            e(this.D, this.f11849w, this.V, true);
        }
        this.f8078c0 = !this.f8077b0;
    }

    @Override // t2.k
    public final boolean c() {
        throw null;
    }

    @Override // w2.k
    public final void d() {
        this.f8077b0 = true;
    }

    public final void e(b2.h hVar, b2.o oVar, boolean z10, boolean z11) {
        b2.o oVarC;
        boolean z12;
        long j4;
        if (z10) {
            z12 = this.Z != 0;
            oVarC = oVar;
        } else {
            oVarC = oVar.c(this.Z);
            z12 = false;
        }
        try {
            a3.l lVarI = i(hVar, oVarC, z11);
            if (z12) {
                lVarI.r(this.Z, false);
            }
            while (!this.f8077b0 && this.X.f8042a.i(lVarI, b.f) == 0) {
                try {
                    try {
                    } catch (Throwable th) {
                        this.Z = (int) (lVarI.f215y - oVar.f);
                        throw th;
                    }
                } catch (EOFException e9) {
                    if ((this.f11851y.f & 16384) == 0) {
                        throw e9;
                    }
                    this.X.f8042a.e(0L, 0L);
                    j4 = lVarI.f215y;
                }
            }
            j4 = lVarI.f215y;
            this.Z = (int) (j4 - oVar.f);
        } finally {
            u8.a.g(hVar);
        }
    }

    public final int g(int i) {
        y1.d.g(!this.f8082g0);
        if (i >= this.f8079d0.size()) {
            return 0;
        }
        return ((Integer) this.f8079d0.get(i)).intValue();
    }

    public final boolean h() {
        return this.f8081f0 != -9223372036854775807L;
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
    public final a3.l i(b2.h r34, b2.o r35, boolean r36) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1019
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m2.k.i(b2.h, b2.o, boolean):a3.l");
    }
}
