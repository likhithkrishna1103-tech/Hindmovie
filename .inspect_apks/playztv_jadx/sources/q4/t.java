package q4;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10921a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView f10922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h0 f10923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f10925e;
    public View f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final r0 f10926g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f10927h;
    public final LinearInterpolator i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DecelerateInterpolator f10928j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PointF f10929k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final DisplayMetrics f10930l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f10931m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f10932n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f10933o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f10934p;

    public t(Context context) {
        r0 r0Var = new r0();
        r0Var.f10915d = -1;
        r0Var.f = false;
        r0Var.f10917g = 0;
        r0Var.f10912a = 0;
        r0Var.f10913b = 0;
        r0Var.f10914c = Integer.MIN_VALUE;
        r0Var.f10916e = null;
        this.f10926g = r0Var;
        this.i = new LinearInterpolator();
        this.f10928j = new DecelerateInterpolator();
        this.f10931m = false;
        this.f10933o = 0;
        this.f10934p = 0;
        this.f10930l = context.getResources().getDisplayMetrics();
    }

    public static int a(int i, int i10, int i11, int i12, int i13) {
        if (i13 == -1) {
            return i11 - i;
        }
        if (i13 != 0) {
            if (i13 == 1) {
                return i12 - i10;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i14 = i11 - i;
        if (i14 > 0) {
            return i14;
        }
        int i15 = i12 - i10;
        if (i15 < 0) {
            return i15;
        }
        return 0;
    }

    public int b(View view, int i) {
        h0 h0Var = this.f10923c;
        if (h0Var == null || !h0Var.d()) {
            return 0;
        }
        i0 i0Var = (i0) view.getLayoutParams();
        return a((view.getLeft() - ((i0) view.getLayoutParams()).f10832b.left) - ((ViewGroup.MarginLayoutParams) i0Var).leftMargin, view.getRight() + ((i0) view.getLayoutParams()).f10832b.right + ((ViewGroup.MarginLayoutParams) i0Var).rightMargin, h0Var.D(), h0Var.f10828n - h0Var.E(), i);
    }

    public int c(View view, int i) {
        h0 h0Var = this.f10923c;
        if (h0Var == null || !h0Var.e()) {
            return 0;
        }
        i0 i0Var = (i0) view.getLayoutParams();
        return a((view.getTop() - ((i0) view.getLayoutParams()).f10832b.top) - ((ViewGroup.MarginLayoutParams) i0Var).topMargin, view.getBottom() + ((i0) view.getLayoutParams()).f10832b.bottom + ((ViewGroup.MarginLayoutParams) i0Var).bottomMargin, h0Var.F(), h0Var.f10829o - h0Var.C(), i);
    }

    public float d(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public int e(int i) {
        float fAbs = Math.abs(i);
        if (!this.f10931m) {
            this.f10932n = d(this.f10930l);
            this.f10931m = true;
        }
        return (int) Math.ceil(fAbs * this.f10932n);
    }

    public PointF f(int i) {
        Object obj = this.f10923c;
        if (obj instanceof s0) {
            return ((s0) obj).a(i);
        }
        Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + s0.class.getCanonicalName());
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(int r9, int r10) {
        /*
            Method dump skipped, instruction units count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q4.t.g(int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h(android.view.View r7, q4.r0 r8) {
        /*
            r6 = this;
            android.graphics.PointF r0 = r6.f10929k
            r1 = 0
            r2 = -1
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L15
            float r0 = r0.x
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 != 0) goto Lf
            goto L15
        Lf:
            if (r0 <= 0) goto L13
            r0 = r3
            goto L16
        L13:
            r0 = r2
            goto L16
        L15:
            r0 = r1
        L16:
            int r0 = r6.b(r7, r0)
            android.graphics.PointF r5 = r6.f10929k
            if (r5 == 0) goto L2a
            float r5 = r5.y
            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r4 != 0) goto L25
            goto L2a
        L25:
            if (r4 <= 0) goto L29
            r1 = r3
            goto L2a
        L29:
            r1 = r2
        L2a:
            int r7 = r6.c(r7, r1)
            int r1 = r0 * r0
            int r2 = r7 * r7
            int r2 = r2 + r1
            double r1 = (double) r2
            double r1 = java.lang.Math.sqrt(r1)
            int r1 = (int) r1
            int r1 = r6.e(r1)
            double r1 = (double) r1
            r4 = 4599717252057688074(0x3fd57a786c22680a, double:0.3356)
            double r1 = r1 / r4
            double r1 = java.lang.Math.ceil(r1)
            int r1 = (int) r1
            if (r1 <= 0) goto L59
            int r0 = -r0
            int r7 = -r7
            r8.f10912a = r0
            r8.f10913b = r7
            r8.f10914c = r1
            android.view.animation.DecelerateInterpolator r7 = r6.f10928j
            r8.f10916e = r7
            r8.f = r3
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q4.t.h(android.view.View, q4.r0):void");
    }

    public final void i() {
        if (this.f10925e) {
            this.f10925e = false;
            this.f10934p = 0;
            this.f10933o = 0;
            this.f10929k = null;
            this.f10922b.A0.f10935a = -1;
            this.f = null;
            this.f10921a = -1;
            this.f10924d = false;
            h0 h0Var = this.f10923c;
            if (h0Var.f10821e == this) {
                h0Var.f10821e = null;
            }
            this.f10923c = null;
            this.f10922b = null;
        }
    }
}
