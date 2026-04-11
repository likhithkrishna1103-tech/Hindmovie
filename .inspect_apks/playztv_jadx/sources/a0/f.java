package a0;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f52a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f53b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f54c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f55d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f56e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f57g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ ConstraintLayout f58h;

    public f(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
        this.f58h = constraintLayout;
        this.f52a = constraintLayout2;
    }

    public static boolean a(int i, int i10, int i11) {
        if (i == i10) {
            return true;
        }
        int mode = View.MeasureSpec.getMode(i);
        View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode2 == 1073741824) {
            return (mode == Integer.MIN_VALUE || mode == 0) && i11 == size;
        }
        return false;
    }

    public final void b(x.e eVar, y.b bVar) {
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        int iMax;
        boolean z2;
        int measuredWidth;
        int baseline;
        int i;
        if (eVar == null) {
            return;
        }
        x.d dVar = eVar.K;
        x.d dVar2 = eVar.I;
        if (eVar.f14133g0 == 8) {
            bVar.f14377e = 0;
            bVar.f = 0;
            bVar.f14378g = 0;
            return;
        }
        if (eVar.T == null) {
            return;
        }
        int i10 = bVar.f14373a;
        int i11 = bVar.f14374b;
        int i12 = bVar.f14375c;
        int i13 = bVar.f14376d;
        int i14 = this.f53b + this.f54c;
        int i15 = this.f55d;
        View view = eVar.f14131f0;
        int iC = v.e.c(i10);
        if (iC == 0) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
        } else if (iC == 1) {
            iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f, i15, -2);
        } else if (iC == 2) {
            iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f, i15, -2);
            boolean z10 = eVar.f14151r == 1;
            int i16 = bVar.f14380j;
            if (i16 == 1 || i16 == 2) {
                boolean z11 = view.getMeasuredHeight() == eVar.k();
                if (bVar.f14380j == 2 || !z10 || ((z10 && z11) || eVar.A())) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(eVar.q(), 1073741824);
                }
            }
        } else if (iC != 3) {
            iMakeMeasureSpec = 0;
        } else {
            int i17 = this.f;
            int i18 = dVar2 != null ? dVar2.f14119g : 0;
            if (dVar != null) {
                i18 += dVar.f14119g;
            }
            iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(i17, i15 + i18, -1);
        }
        int iC2 = v.e.c(i11);
        if (iC2 == 0) {
            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
        } else if (iC2 == 1) {
            iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f57g, i14, -2);
        } else if (iC2 == 2) {
            iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f57g, i14, -2);
            boolean z12 = eVar.f14152s == 1;
            int i19 = bVar.f14380j;
            if (i19 == 1 || i19 == 2) {
                boolean z13 = view.getMeasuredWidth() == eVar.q();
                if (bVar.f14380j == 2 || !z12 || ((z12 && z13) || eVar.B())) {
                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(eVar.k(), 1073741824);
                }
            }
        } else if (iC2 != 3) {
            iMakeMeasureSpec2 = 0;
        } else {
            int i20 = this.f57g;
            int i21 = dVar2 != null ? eVar.J.f14119g : 0;
            if (dVar != null) {
                i21 += eVar.L.f14119g;
            }
            iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(i20, i14 + i21, -1);
        }
        x.f fVar = (x.f) eVar.T;
        ConstraintLayout constraintLayout = this.f58h;
        if (fVar != null && x.k.c(constraintLayout.C, 256) && view.getMeasuredWidth() == eVar.q() && view.getMeasuredWidth() < fVar.q() && view.getMeasuredHeight() == eVar.k() && view.getMeasuredHeight() < fVar.k() && view.getBaseline() == eVar.f14122a0 && !eVar.z() && a(eVar.G, iMakeMeasureSpec, eVar.q()) && a(eVar.H, iMakeMeasureSpec2, eVar.k())) {
            bVar.f14377e = eVar.q();
            bVar.f = eVar.k();
            bVar.f14378g = eVar.f14122a0;
            return;
        }
        boolean z14 = i10 == 3;
        boolean z15 = i11 == 3;
        boolean z16 = i11 == 4 || i11 == 1;
        boolean z17 = i10 == 4 || i10 == 1;
        boolean z18 = z14 && eVar.W > 0.0f;
        boolean z19 = z15 && eVar.W > 0.0f;
        if (view == null) {
            return;
        }
        e eVar2 = (e) view.getLayoutParams();
        int i22 = bVar.f14380j;
        if (i22 != 1 && i22 != 2 && z14 && eVar.f14151r == 0 && z15 && eVar.f14152s == 0) {
            z2 = false;
            measuredWidth = 0;
            baseline = 0;
            i = -1;
            iMax = 0;
        } else {
            if ((view instanceof u) && (eVar instanceof x.h)) {
                ((u) view).j((x.h) eVar, iMakeMeasureSpec, iMakeMeasureSpec2);
            } else {
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            }
            eVar.G = iMakeMeasureSpec;
            eVar.H = iMakeMeasureSpec2;
            eVar.f14132g = false;
            int measuredWidth2 = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int baseline2 = view.getBaseline();
            int i23 = eVar.f14154u;
            int iMax2 = i23 > 0 ? Math.max(i23, measuredWidth2) : measuredWidth2;
            int i24 = eVar.f14155v;
            if (i24 > 0) {
                iMax2 = Math.min(i24, iMax2);
            }
            int i25 = eVar.f14157x;
            iMax = i25 > 0 ? Math.max(i25, measuredHeight) : measuredHeight;
            int i26 = iMakeMeasureSpec2;
            int i27 = eVar.f14158y;
            if (i27 > 0) {
                iMax = Math.min(i27, iMax);
            }
            if (!x.k.c(constraintLayout.C, 1)) {
                if (z18 && z16) {
                    iMax2 = (int) ((iMax * eVar.W) + 0.5f);
                } else if (z19 && z17) {
                    iMax = (int) ((iMax2 / eVar.W) + 0.5f);
                }
            }
            if (measuredWidth2 == iMax2 && measuredHeight == iMax) {
                baseline = baseline2;
                measuredWidth = iMax2;
                z2 = false;
            } else {
                if (measuredWidth2 != iMax2) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax2, 1073741824);
                }
                int iMakeMeasureSpec3 = measuredHeight != iMax ? View.MeasureSpec.makeMeasureSpec(iMax, 1073741824) : i26;
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec3);
                eVar.G = iMakeMeasureSpec;
                eVar.H = iMakeMeasureSpec3;
                z2 = false;
                eVar.f14132g = false;
                measuredWidth = view.getMeasuredWidth();
                int measuredHeight2 = view.getMeasuredHeight();
                baseline = view.getBaseline();
                iMax = measuredHeight2;
            }
            i = -1;
        }
        boolean z20 = baseline != i ? true : z2;
        bVar.i = (measuredWidth == bVar.f14375c && iMax == bVar.f14376d) ? z2 : true;
        boolean z21 = eVar2.f18c0 ? true : z20;
        if (z21 && baseline != -1 && eVar.f14122a0 != baseline) {
            bVar.i = true;
        }
        bVar.f14377e = measuredWidth;
        bVar.f = iMax;
        bVar.f14379h = z21;
        bVar.f14378g = baseline;
    }
}
