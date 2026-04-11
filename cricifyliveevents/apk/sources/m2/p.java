package m2;

import a3.h0;
import a3.i0;
import java.io.EOFException;
import java.util.Arrays;
import java.util.Objects;
import v1.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p implements i0 {
    public static final v1.p f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final v1.p f8104g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i0 f8105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v1.p f8106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public v1.p f8107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f8108d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8109e;

    static {
        v1.o oVar = new v1.o();
        oVar.f12893m = m0.p("application/id3");
        f = new v1.p(oVar);
        v1.o oVar2 = new v1.o();
        oVar2.f12893m = m0.p("application/x-emsg");
        f8104g = new v1.p(oVar2);
    }

    public p(i0 i0Var, int i) {
        this.f8105a = i0Var;
        if (i == 1) {
            this.f8106b = f;
        } else {
            if (i != 3) {
                throw new IllegalArgumentException(l0.e.g(i, "Unknown metadataType: "));
            }
            this.f8106b = f8104g;
        }
        this.f8108d = new byte[0];
        this.f8109e = 0;
    }

    @Override // a3.i0
    public final /* synthetic */ void a(int i, y1.t tVar) {
        q4.a.a(this, tVar, i);
    }

    @Override // a3.i0
    public final int b(v1.h hVar, int i, boolean z10) {
        return d(hVar, i, z10);
    }

    @Override // a3.i0
    public final void c(y1.t tVar, int i, int i10) {
        int i11 = this.f8109e + i;
        byte[] bArr = this.f8108d;
        if (bArr.length < i11) {
            this.f8108d = Arrays.copyOf(bArr, (i11 / 2) + i11);
        }
        tVar.h(this.f8108d, this.f8109e, i);
        this.f8109e += i;
    }

    @Override // a3.i0
    public final int d(v1.h hVar, int i, boolean z10) throws EOFException {
        int i10 = this.f8109e + i;
        byte[] bArr = this.f8108d;
        if (bArr.length < i10) {
            this.f8108d = Arrays.copyOf(bArr, (i10 / 2) + i10);
        }
        int i11 = hVar.read(this.f8108d, this.f8109e, i);
        if (i11 != -1) {
            this.f8109e += i11;
            return i11;
        }
        if (z10) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // a3.i0
    public final void e(long j4, int i, int i10, int i11, h0 h0Var) {
        this.f8107c.getClass();
        int i12 = this.f8109e - i11;
        y1.t tVar = new y1.t(Arrays.copyOfRange(this.f8108d, i12 - i10, i12));
        byte[] bArr = this.f8108d;
        System.arraycopy(bArr, i12, bArr, 0, i11);
        this.f8109e = i11;
        String str = this.f8107c.f12946n;
        v1.p pVar = this.f8106b;
        String str2 = pVar.f12946n;
        String str3 = pVar.f12946n;
        if (!Objects.equals(str, str2)) {
            if (!"application/x-emsg".equals(this.f8107c.f12946n)) {
                y1.b.p("HlsSampleStreamWrapper", "Ignoring sample for unsupported format: " + this.f8107c.f12946n);
                return;
            }
            l3.a aVarT = k3.b.T(tVar);
            v1.p pVarA = aVarT.a();
            if (pVarA == null || !Objects.equals(str3, pVarA.f12946n)) {
                y1.b.p("HlsSampleStreamWrapper", "Ignoring EMSG. Expected it to contain wrapped " + str3 + " but actual wrapped format: " + aVarT.a());
                return;
            }
            byte[] bArrB = aVarT.b();
            bArrB.getClass();
            tVar = new y1.t(bArrB);
        }
        int iA = tVar.a();
        i0 i0Var = this.f8105a;
        i0Var.a(iA, tVar);
        i0Var.e(j4, i, iA, 0, h0Var);
    }

    @Override // a3.i0
    public final void f(v1.p pVar) {
        this.f8107c = pVar;
        this.f8105a.f(this.f8106b);
    }
}
