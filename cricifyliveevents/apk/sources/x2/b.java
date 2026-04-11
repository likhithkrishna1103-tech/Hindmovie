package x2;

import ag.h;
import android.os.SystemClock;
import lf.d;
import v1.p;
import vd.g;
import w2.k;
import x3.n;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements k, n, g {
    public static final String f(h hVar, h[] hVarArr, int i) {
        int i10;
        boolean z10;
        int i11;
        int i12;
        h hVar2 = xf.a.f14503b;
        int iA = hVar.a();
        int i13 = 0;
        while (i13 < iA) {
            int i14 = (i13 + iA) / 2;
            while (i14 > -1 && hVar.d(i14) != 10) {
                i14--;
            }
            int i15 = i14 + 1;
            int i16 = 1;
            while (true) {
                i10 = i15 + i16;
                if (hVar.d(i10) == 10) {
                    break;
                }
                i16++;
            }
            int i17 = i10 - i15;
            int i18 = i;
            boolean z11 = false;
            int i19 = 0;
            int i20 = 0;
            while (true) {
                if (z11) {
                    i11 = 46;
                    z10 = false;
                } else {
                    byte bD = hVarArr[i18].d(i19);
                    byte[] bArr = d.f7960a;
                    int i21 = bD & 255;
                    z10 = z11;
                    i11 = i21;
                }
                byte bD2 = hVar.d(i15 + i20);
                byte[] bArr2 = d.f7960a;
                i12 = i11 - (bD2 & 255);
                if (i12 != 0) {
                    break;
                }
                i20++;
                i19++;
                if (i20 == i17) {
                    break;
                }
                if (hVarArr[i18].a() != i19) {
                    z11 = z10;
                } else {
                    if (i18 == hVarArr.length - 1) {
                        break;
                    }
                    i18++;
                    i19 = -1;
                    z11 = true;
                }
            }
            if (i12 >= 0) {
                if (i12 <= 0) {
                    int i22 = i17 - i20;
                    int iA2 = hVarArr[i18].a() - i19;
                    int length = hVarArr.length;
                    for (int i23 = i18 + 1; i23 < length; i23++) {
                        iA2 += hVarArr[i23].a();
                    }
                    if (iA2 >= i22) {
                        if (iA2 <= i22) {
                            return hVar.h(i15, i17 + i15).g(ne.a.f9126a);
                        }
                    }
                }
                i13 = i10 + 1;
            }
            iA = i14;
        }
        return null;
    }

    @Override // w2.k
    public void a() {
        synchronized (c.f14288a) {
            Object obj = c.f14289b;
            synchronized (obj) {
                if (c.f14290c) {
                    return;
                }
                long jA = c.a();
                synchronized (obj) {
                    SystemClock.elapsedRealtime();
                    c.f14291d = jA;
                    c.f14290c = true;
                }
            }
        }
    }

    @Override // x3.n
    public int b(p pVar) {
        return 1;
    }

    @Override // x3.n
    public x3.p c(p pVar) {
        throw new IllegalStateException("This SubtitleParser.Factory doesn't support any formats.");
    }

    @Override // x3.n
    public boolean e(p pVar) {
        return false;
    }

    @Override // w2.k
    public void d() {
    }
}
