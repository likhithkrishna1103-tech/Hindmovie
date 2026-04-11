package g2;

import java.io.EOFException;
import java.util.Arrays;
import java.util.Objects;
import p1.m0;
import s1.u;
import w2.g0;
import w2.h0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o implements h0 {
    public static final p1.q f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final p1.q f4899g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h0 f4900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p1.q f4901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p1.q f4902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f4903d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4904e;

    static {
        p1.p pVar = new p1.p();
        pVar.f9967m = m0.p("application/id3");
        f = new p1.q(pVar);
        p1.p pVar2 = new p1.p();
        pVar2.f9967m = m0.p("application/x-emsg");
        f4899g = new p1.q(pVar2);
    }

    public o(h0 h0Var, int i) {
        this.f4900a = h0Var;
        if (i == 1) {
            this.f4901b = f;
        } else {
            if (i != 3) {
                throw new IllegalArgumentException(e6.j.l("Unknown metadataType: ", i));
            }
            this.f4901b = f4899g;
        }
        this.f4903d = new byte[0];
        this.f4904e = 0;
    }

    @Override // w2.h0
    public final void a(long j5, int i, int i10, int i11, g0 g0Var) {
        this.f4902c.getClass();
        int i12 = this.f4904e - i11;
        u uVar = new u(Arrays.copyOfRange(this.f4903d, i12 - i10, i12));
        byte[] bArr = this.f4903d;
        System.arraycopy(bArr, i12, bArr, 0, i11);
        this.f4904e = i11;
        String str = this.f4902c.f10023n;
        p1.q qVar = this.f4901b;
        String str2 = qVar.f10023n;
        String str3 = qVar.f10023n;
        if (!Objects.equals(str, str2)) {
            if (!"application/x-emsg".equals(this.f4902c.f10023n)) {
                s1.b.p("HlsSampleStreamWrapper", "Ignoring sample for unsupported format: " + this.f4902c.f10023n);
                return;
            }
            h3.a aVarY = g3.b.y(uVar);
            p1.q qVarB = aVarY.b();
            if (qVarB == null || !Objects.equals(str3, qVarB.f10023n)) {
                s1.b.p("HlsSampleStreamWrapper", "Ignoring EMSG. Expected it to contain wrapped " + str3 + " but actual wrapped format: " + aVarY.b());
                return;
            }
            byte[] bArrC = aVarY.c();
            bArrC.getClass();
            uVar = new u(bArrC);
        }
        int iA = uVar.a();
        h0 h0Var = this.f4900a;
        h0Var.f(iA, uVar);
        h0Var.a(j5, i, iA, 0, g0Var);
    }

    @Override // w2.h0
    public final void b(u uVar, int i, int i10) {
        int i11 = this.f4904e + i;
        byte[] bArr = this.f4903d;
        if (bArr.length < i11) {
            this.f4903d = Arrays.copyOf(bArr, (i11 / 2) + i11);
        }
        uVar.h(this.f4903d, this.f4904e, i);
        this.f4904e += i;
    }

    @Override // w2.h0
    public final int c(p1.i iVar, int i, boolean z2) {
        return e(iVar, i, z2);
    }

    @Override // w2.h0
    public final void d(p1.q qVar) {
        this.f4902c = qVar;
        this.f4900a.d(this.f4901b);
    }

    @Override // w2.h0
    public final int e(p1.i iVar, int i, boolean z2) throws EOFException {
        int i10 = this.f4904e + i;
        byte[] bArr = this.f4903d;
        if (bArr.length < i10) {
            this.f4903d = Arrays.copyOf(bArr, (i10 / 2) + i10);
        }
        int i11 = iVar.read(this.f4903d, this.f4904e, i);
        if (i11 != -1) {
            this.f4904e += i11;
            return i11;
        }
        if (z2) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // w2.h0
    public final /* synthetic */ void f(int i, u uVar) {
        e6.j.b(this, uVar, i);
    }
}
