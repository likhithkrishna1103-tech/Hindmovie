package v3;

import a3.q;
import java.io.EOFException;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f13144a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f13145b = new t(0, new byte[65025]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13146c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f13148e;

    public final int a(int i) {
        int i10;
        int i11 = 0;
        this.f13147d = 0;
        do {
            int i12 = this.f13147d;
            int i13 = i + i12;
            f fVar = this.f13144a;
            if (i13 >= fVar.f13151c) {
                break;
            }
            int[] iArr = fVar.f;
            this.f13147d = i12 + 1;
            i10 = iArr[i13];
            i11 += i10;
        } while (i10 == 255);
        return i11;
    }

    public final boolean b(q qVar) {
        int i;
        y1.d.g(qVar != null);
        boolean z10 = this.f13148e;
        t tVar = this.f13145b;
        if (z10) {
            this.f13148e = false;
            tVar.G(0);
        }
        while (!this.f13148e) {
            int i10 = this.f13146c;
            f fVar = this.f13144a;
            if (i10 < 0) {
                if (fVar.b(qVar, -1L) && fVar.a(qVar, true)) {
                    int iA = fVar.f13152d;
                    if ((fVar.f13149a & 1) == 1 && tVar.f14611c == 0) {
                        iA += a(0);
                        i = this.f13147d;
                    } else {
                        i = 0;
                    }
                    try {
                        qVar.n(iA);
                        this.f13146c = i;
                    } catch (EOFException unused) {
                    }
                }
                return false;
            }
            int iA2 = a(this.f13146c);
            int i11 = this.f13146c + this.f13147d;
            if (iA2 > 0) {
                tVar.c(tVar.f14611c + iA2);
                try {
                    qVar.readFully(tVar.f14609a, tVar.f14611c, iA2);
                    tVar.I(tVar.f14611c + iA2);
                    this.f13148e = fVar.f[i11 + (-1)] != 255;
                } catch (EOFException unused2) {
                    return false;
                }
            }
            if (i11 == fVar.f13151c) {
                i11 = -1;
            }
            this.f13146c = i11;
        }
        return true;
    }
}
