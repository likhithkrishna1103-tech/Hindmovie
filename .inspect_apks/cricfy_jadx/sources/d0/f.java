package d0;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f3108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3112e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3113g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ ConstraintLayout f3114h;

    public f(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
        this.f3114h = constraintLayout;
        this.f3108a = constraintLayout2;
    }

    public static boolean a(int i, int i10, int i11) {
        if (i == i10) {
            return true;
        }
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode2 == 1073741824) {
            return (mode == Integer.MIN_VALUE || mode == 0) && i11 == size;
        }
        return false;
    }

    public final void b(a0.d dVar, b0.b bVar) {
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        int iMax;
        boolean z10;
        int measuredWidth;
        int baseline;
        int i;
        if (dVar == null) {
            return;
        }
        a0.c cVar = dVar.K;
        a0.c cVar2 = dVar.I;
        if (dVar.f38g0 == 8) {
            bVar.f1589e = 0;
            bVar.f = 0;
            bVar.f1590g = 0;
            return;
        }
        if (dVar.T == null) {
            return;
        }
        s sVar = ConstraintLayout.K;
        int i10 = bVar.f1585a;
        int i11 = bVar.f1586b;
        int i12 = bVar.f1587c;
        int i13 = bVar.f1588d;
        int i14 = this.f3109b + this.f3110c;
        int i15 = this.f3111d;
        View view = dVar.f36f0;
        int iC = y.e.c(i10);
        if (iC == 0) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
        } else if (iC == 1) {
            iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f, i15, -2);
        } else if (iC == 2) {
            iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f, i15, -2);
            boolean z11 = dVar.f56r == 1;
            int i16 = bVar.f1592j;
            if (i16 == 1 || i16 == 2) {
                boolean z12 = view.getMeasuredHeight() == dVar.k();
                if (bVar.f1592j == 2 || !z11 || ((z11 && z12) || dVar.A())) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(dVar.q(), 1073741824);
                }
            }
        } else if (iC != 3) {
            iMakeMeasureSpec = 0;
        } else {
            int i17 = this.f;
            int i18 = cVar2 != null ? cVar2.f24g : 0;
            if (cVar != null) {
                i18 += cVar.f24g;
            }
            iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(i17, i15 + i18, -1);
        }
        int iC2 = y.e.c(i11);
        if (iC2 == 0) {
            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
        } else if (iC2 == 1) {
            iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f3113g, i14, -2);
        } else if (iC2 == 2) {
            iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f3113g, i14, -2);
            boolean z13 = dVar.f57s == 1;
            int i19 = bVar.f1592j;
            if (i19 == 1 || i19 == 2) {
                boolean z14 = view.getMeasuredWidth() == dVar.q();
                if (bVar.f1592j == 2 || !z13 || ((z13 && z14) || dVar.B())) {
                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(dVar.k(), 1073741824);
                }
            }
        } else if (iC2 != 3) {
            iMakeMeasureSpec2 = 0;
        } else {
            int i20 = this.f3113g;
            int i21 = cVar2 != null ? dVar.J.f24g : 0;
            if (cVar != null) {
                i21 += dVar.L.f24g;
            }
            iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(i20, i14 + i21, -1);
        }
        a0.e eVar = (a0.e) dVar.T;
        ConstraintLayout constraintLayout = this.f3114h;
        if (eVar != null && a0.j.c(constraintLayout.D, 256) && view.getMeasuredWidth() == dVar.q() && view.getMeasuredWidth() < eVar.q() && view.getMeasuredHeight() == dVar.k() && view.getMeasuredHeight() < eVar.k() && view.getBaseline() == dVar.f27a0 && !dVar.z() && a(dVar.G, iMakeMeasureSpec, dVar.q()) && a(dVar.H, iMakeMeasureSpec2, dVar.k())) {
            bVar.f1589e = dVar.q();
            bVar.f = dVar.k();
            bVar.f1590g = dVar.f27a0;
            return;
        }
        boolean z15 = i10 == 3;
        boolean z16 = i11 == 3;
        boolean z17 = i11 == 4 || i11 == 1;
        boolean z18 = i10 == 4 || i10 == 1;
        boolean z19 = z15 && dVar.W > 0.0f;
        boolean z20 = z16 && dVar.W > 0.0f;
        if (view == null) {
            return;
        }
        e eVar2 = (e) view.getLayoutParams();
        int i22 = bVar.f1592j;
        if (i22 != 1 && i22 != 2 && z15 && dVar.f56r == 0 && z16 && dVar.f57s == 0) {
            z10 = false;
            measuredWidth = 0;
            baseline = 0;
            i = -1;
            iMax = 0;
        } else {
            if ((view instanceof t) && (dVar instanceof a0.g)) {
                ((t) view).j((a0.g) dVar, iMakeMeasureSpec, iMakeMeasureSpec2);
            } else {
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            }
            dVar.G = iMakeMeasureSpec;
            dVar.H = iMakeMeasureSpec2;
            dVar.f37g = false;
            int measuredWidth2 = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int baseline2 = view.getBaseline();
            int i23 = dVar.f59u;
            int iMax2 = i23 > 0 ? Math.max(i23, measuredWidth2) : measuredWidth2;
            int i24 = dVar.f60v;
            if (i24 > 0) {
                iMax2 = Math.min(i24, iMax2);
            }
            int i25 = dVar.f62x;
            iMax = i25 > 0 ? Math.max(i25, measuredHeight) : measuredHeight;
            int i26 = iMakeMeasureSpec2;
            int i27 = dVar.f63y;
            if (i27 > 0) {
                iMax = Math.min(i27, iMax);
            }
            if (!a0.j.c(constraintLayout.D, 1)) {
                if (z19 && z17) {
                    iMax2 = (int) ((iMax * dVar.W) + 0.5f);
                } else if (z20 && z18) {
                    iMax = (int) ((iMax2 / dVar.W) + 0.5f);
                }
            }
            if (measuredWidth2 == iMax2 && measuredHeight == iMax) {
                baseline = baseline2;
                measuredWidth = iMax2;
                z10 = false;
            } else {
                if (measuredWidth2 != iMax2) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax2, 1073741824);
                }
                int iMakeMeasureSpec3 = measuredHeight != iMax ? View.MeasureSpec.makeMeasureSpec(iMax, 1073741824) : i26;
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec3);
                dVar.G = iMakeMeasureSpec;
                dVar.H = iMakeMeasureSpec3;
                z10 = false;
                dVar.f37g = false;
                measuredWidth = view.getMeasuredWidth();
                int measuredHeight2 = view.getMeasuredHeight();
                baseline = view.getBaseline();
                iMax = measuredHeight2;
            }
            i = -1;
        }
        boolean z21 = baseline != i ? true : z10;
        bVar.i = (measuredWidth == bVar.f1587c && iMax == bVar.f1588d) ? z10 : true;
        boolean z22 = eVar2.f3074c0 ? true : z21;
        if (z22 && baseline != -1 && dVar.f27a0 != baseline) {
            bVar.i = true;
        }
        bVar.f1589e = measuredWidth;
        bVar.f = iMax;
        bVar.f1591h = z22;
        bVar.f1590g = baseline;
    }
}
