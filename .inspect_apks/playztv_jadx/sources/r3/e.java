package r3;

import java.io.EOFException;
import s1.u;
import w2.p;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f11374a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f11375b = new u(0, new byte[65025]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11376c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f11378e;

    public final int a(int i) {
        int i10;
        int i11 = 0;
        this.f11377d = 0;
        do {
            int i12 = this.f11377d;
            int i13 = i + i12;
            f fVar = this.f11374a;
            if (i13 >= fVar.f11381c) {
                break;
            }
            int[] iArr = fVar.f;
            this.f11377d = i12 + 1;
            i10 = iArr[i13];
            i11 += i10;
        } while (i10 == 255);
        return i11;
    }

    public final boolean b(p pVar) {
        int i;
        s1.d.g(pVar != null);
        boolean z2 = this.f11378e;
        u uVar = this.f11375b;
        if (z2) {
            this.f11378e = false;
            uVar.G(0);
        }
        while (!this.f11378e) {
            int i10 = this.f11376c;
            f fVar = this.f11374a;
            if (i10 < 0) {
                if (fVar.b(pVar, -1L) && fVar.a(pVar, true)) {
                    int iA = fVar.f11382d;
                    if ((fVar.f11379a & 1) == 1 && uVar.f11711c == 0) {
                        iA += a(0);
                        i = this.f11377d;
                    } else {
                        i = 0;
                    }
                    try {
                        pVar.m(iA);
                        this.f11376c = i;
                    } catch (EOFException unused) {
                    }
                }
                return false;
            }
            int iA2 = a(this.f11376c);
            int i11 = this.f11376c + this.f11377d;
            if (iA2 > 0) {
                uVar.c(uVar.f11711c + iA2);
                try {
                    pVar.readFully(uVar.f11709a, uVar.f11711c, iA2);
                    uVar.I(uVar.f11711c + iA2);
                    this.f11378e = fVar.f[i11 + (-1)] != 255;
                } catch (EOFException unused2) {
                    return false;
                }
            }
            if (i11 == fVar.f11381c) {
                i11 = -1;
            }
            this.f11376c = i11;
        }
        return true;
    }
}
