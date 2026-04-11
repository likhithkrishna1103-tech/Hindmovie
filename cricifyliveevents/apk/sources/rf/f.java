package rf;

import java.io.EOFException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ag.e f11071a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11073c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f11076g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f11077h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11072b = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11074d = 4096;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d[] f11075e = new d[8];
    public int f = 7;

    public f(ag.e eVar) {
        this.f11071a = eVar;
    }

    public final void a(int i) {
        int i10;
        if (i > 0) {
            int length = this.f11075e.length - 1;
            int i11 = 0;
            while (true) {
                i10 = this.f;
                if (length < i10 || i <= 0) {
                    break;
                }
                d dVar = this.f11075e[length];
                ge.i.b(dVar);
                i -= dVar.f11063c;
                int i12 = this.f11077h;
                d dVar2 = this.f11075e[length];
                ge.i.b(dVar2);
                this.f11077h = i12 - dVar2.f11063c;
                this.f11076g--;
                i11++;
                length--;
            }
            d[] dVarArr = this.f11075e;
            int i13 = i10 + 1;
            System.arraycopy(dVarArr, i13, dVarArr, i13 + i11, this.f11076g);
            d[] dVarArr2 = this.f11075e;
            int i14 = this.f + 1;
            Arrays.fill(dVarArr2, i14, i14 + i11, (Object) null);
            this.f += i11;
        }
    }

    public final void b(d dVar) {
        int i = dVar.f11063c;
        int i10 = this.f11074d;
        if (i > i10) {
            d[] dVarArr = this.f11075e;
            sd.i.p(dVarArr, 0, dVarArr.length);
            this.f = this.f11075e.length - 1;
            this.f11076g = 0;
            this.f11077h = 0;
            return;
        }
        a((this.f11077h + i) - i10);
        int i11 = this.f11076g + 1;
        d[] dVarArr2 = this.f11075e;
        if (i11 > dVarArr2.length) {
            d[] dVarArr3 = new d[dVarArr2.length * 2];
            System.arraycopy(dVarArr2, 0, dVarArr3, dVarArr2.length, dVarArr2.length);
            this.f = this.f11075e.length - 1;
            this.f11075e = dVarArr3;
        }
        int i12 = this.f;
        this.f = i12 - 1;
        this.f11075e[i12] = dVar;
        this.f11076g++;
        this.f11077h += i;
    }

    public final void c(ag.h hVar) throws EOFException {
        ge.i.e(hVar, "data");
        int[] iArr = a0.f11045a;
        int iA = hVar.a();
        long j4 = 0;
        long j7 = 0;
        for (int i = 0; i < iA; i++) {
            byte bD = hVar.d(i);
            byte[] bArr = lf.d.f7960a;
            j7 += (long) a0.f11046b[bD & 255];
        }
        int i10 = (int) ((j7 + ((long) 7)) >> 3);
        int iA2 = hVar.a();
        ag.e eVar = this.f11071a;
        if (i10 >= iA2) {
            e(hVar.a(), 127, 0);
            eVar.g0(hVar);
            return;
        }
        ag.e eVar2 = new ag.e();
        int[] iArr2 = a0.f11045a;
        int iA3 = hVar.a();
        int i11 = 0;
        for (int i12 = 0; i12 < iA3; i12++) {
            byte bD2 = hVar.d(i12);
            byte[] bArr2 = lf.d.f7960a;
            int i13 = bD2 & 255;
            int i14 = a0.f11045a[i13];
            byte b8 = a0.f11046b[i13];
            j4 = (j4 << b8) | ((long) i14);
            i11 += b8;
            while (i11 >= 8) {
                i11 -= 8;
                eVar2.i0((int) (j4 >> i11));
            }
        }
        if (i11 > 0) {
            eVar2.i0((int) ((j4 << (8 - i11)) | (255 >>> i11)));
        }
        ag.h hVarK = eVar2.k(eVar2.f429w);
        e(hVarK.a(), 127, 128);
        eVar.g0(hVarK);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(java.util.ArrayList r14) throws java.io.EOFException {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: rf.f.d(java.util.ArrayList):void");
    }

    public final void e(int i, int i10, int i11) {
        ag.e eVar = this.f11071a;
        if (i < i10) {
            eVar.i0(i | i11);
            return;
        }
        eVar.i0(i11 | i10);
        int i12 = i - i10;
        while (i12 >= 128) {
            eVar.i0(128 | (i12 & 127));
            i12 >>>= 7;
        }
        eVar.i0(i12);
    }
}
