package f4;

import a3.k0;
import android.graphics.Rect;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f3957d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3958e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Rect f3959g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f3954a = new int[4];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3960h = -1;
    public int i = -1;

    public static int a(int[] iArr, int i) {
        return (i < 0 || i >= iArr.length) ? iArr[0] : iArr[i];
    }

    public static int c(int i, int i10) {
        return (i & 16777215) | ((i10 * 17) << 24);
    }

    public final void b(k0 k0Var, boolean z10, Rect rect, int[] iArr) {
        int i;
        int i10;
        int iWidth = rect.width();
        int iHeight = rect.height();
        int i11 = !z10 ? 1 : 0;
        int i12 = i11 * iWidth;
        while (true) {
            int i13 = 0;
            do {
                int i14 = 0;
                for (int i15 = 1; i14 < i15 && i15 <= 64; i15 <<= 2) {
                    if (k0Var.b() < 4) {
                        i = -1;
                        i10 = 0;
                        break;
                    }
                    i14 = (i14 << 4) | k0Var.i(4);
                }
                i = i14 & 3;
                i10 = i14 < 4 ? iWidth : i14 >> 2;
                int iMin = Math.min(i10, iWidth - i13);
                if (iMin > 0) {
                    int i16 = i12 + iMin;
                    Arrays.fill(iArr, i12, i16, this.f3954a[i]);
                    i13 += iMin;
                    i12 = i16;
                }
            } while (i13 < iWidth);
            i11 += 2;
            if (i11 >= iHeight) {
                return;
            }
            i12 = i11 * iWidth;
            k0Var.c();
        }
    }
}
