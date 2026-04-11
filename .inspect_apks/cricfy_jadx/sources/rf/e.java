package rf;

import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ag.q f11067c;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f11070g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11065a = 4096;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f11066b = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d[] f11068d = new d[8];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11069e = 7;

    public e(t tVar) {
        this.f11067c = vf.g.d(tVar);
    }

    public final int a(int i) {
        int i10;
        int i11 = 0;
        if (i > 0) {
            int length = this.f11068d.length;
            while (true) {
                length--;
                i10 = this.f11069e;
                if (length < i10 || i <= 0) {
                    break;
                }
                d dVar = this.f11068d[length];
                ge.i.b(dVar);
                int i12 = dVar.f11063c;
                i -= i12;
                this.f11070g -= i12;
                this.f--;
                i11++;
            }
            d[] dVarArr = this.f11068d;
            System.arraycopy(dVarArr, i10 + 1, dVarArr, i10 + 1 + i11, this.f);
            this.f11069e += i11;
        }
        return i11;
    }

    public final ag.h b(int i) throws IOException {
        if (i >= 0) {
            d[] dVarArr = g.f11078a;
            if (i <= dVarArr.length - 1) {
                return dVarArr[i].f11061a;
            }
        }
        int length = this.f11069e + 1 + (i - g.f11078a.length);
        if (length >= 0) {
            d[] dVarArr2 = this.f11068d;
            if (length < dVarArr2.length) {
                d dVar = dVarArr2[length];
                ge.i.b(dVar);
                return dVar.f11061a;
            }
        }
        throw new IOException("Header index too large " + (i + 1));
    }

    public final void c(d dVar) {
        this.f11066b.add(dVar);
        int i = dVar.f11063c;
        int i10 = this.f11065a;
        if (i > i10) {
            d[] dVarArr = this.f11068d;
            sd.i.p(dVarArr, 0, dVarArr.length);
            this.f11069e = this.f11068d.length - 1;
            this.f = 0;
            this.f11070g = 0;
            return;
        }
        a((this.f11070g + i) - i10);
        int i11 = this.f + 1;
        d[] dVarArr2 = this.f11068d;
        if (i11 > dVarArr2.length) {
            d[] dVarArr3 = new d[dVarArr2.length * 2];
            System.arraycopy(dVarArr2, 0, dVarArr3, dVarArr2.length, dVarArr2.length);
            this.f11069e = this.f11068d.length - 1;
            this.f11068d = dVarArr3;
        }
        int i12 = this.f11069e;
        this.f11069e = i12 - 1;
        this.f11068d[i12] = dVar;
        this.f++;
        this.f11070g += i;
    }

    public final ag.h d() {
        ag.q qVar = this.f11067c;
        byte b8 = qVar.readByte();
        byte[] bArr = lf.d.f7960a;
        int i = b8 & 255;
        int i10 = 0;
        boolean z10 = (b8 & 128) == 128;
        long jE = e(i, 127);
        if (!z10) {
            return qVar.k(jE);
        }
        ag.e eVar = new ag.e();
        int[] iArr = a0.f11045a;
        ge.i.e(qVar, "source");
        b2.q qVar2 = a0.f11047c;
        b2.q qVar3 = qVar2;
        int i11 = 0;
        for (long j4 = 0; j4 < jE; j4++) {
            byte b10 = qVar.readByte();
            byte[] bArr2 = lf.d.f7960a;
            i10 = (i10 << 8) | (b10 & 255);
            i11 += 8;
            while (i11 >= 8) {
                b2.q[] qVarArr = (b2.q[]) qVar3.f1728x;
                ge.i.b(qVarArr);
                qVar3 = qVarArr[(i10 >>> (i11 - 8)) & 255];
                ge.i.b(qVar3);
                if (((b2.q[]) qVar3.f1728x) == null) {
                    eVar.i0(qVar3.f1726v);
                    i11 -= qVar3.f1727w;
                    qVar3 = qVar2;
                } else {
                    i11 -= 8;
                }
            }
        }
        while (i11 > 0) {
            b2.q[] qVarArr2 = (b2.q[]) qVar3.f1728x;
            ge.i.b(qVarArr2);
            b2.q qVar4 = qVarArr2[(i10 << (8 - i11)) & 255];
            ge.i.b(qVar4);
            int i12 = qVar4.f1727w;
            if (((b2.q[]) qVar4.f1728x) != null || i12 > i11) {
                break;
            }
            eVar.i0(qVar4.f1726v);
            i11 -= i12;
            qVar3 = qVar2;
        }
        return eVar.k(eVar.f429w);
    }

    public final int e(int i, int i10) {
        int i11 = i & i10;
        if (i11 < i10) {
            return i11;
        }
        int i12 = 0;
        while (true) {
            byte b8 = this.f11067c.readByte();
            byte[] bArr = lf.d.f7960a;
            int i13 = b8 & 255;
            if ((b8 & 128) == 0) {
                return i10 + (i13 << i12);
            }
            i10 += (b8 & 127) << i12;
            i12 += 7;
        }
    }
}
