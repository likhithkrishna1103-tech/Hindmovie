package t8;

import android.view.View;
import android.view.ViewParent;
import com.google.android.material.behavior.SwipeDismissBehavior;
import java.util.WeakHashMap;
import q0.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12345b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SwipeDismissBehavior f12346c;

    public a(SwipeDismissBehavior swipeDismissBehavior) {
        this.f12346c = swipeDismissBehavior;
    }

    @Override // a.a
    public final void F(View view, int i) {
        this.f12345b = i;
        this.f12344a = view.getLeft();
        ViewParent parent = view.getParent();
        if (parent != null) {
            SwipeDismissBehavior swipeDismissBehavior = this.f12346c;
            swipeDismissBehavior.f3331w = true;
            parent.requestDisallowInterceptTouchEvent(true);
            swipeDismissBehavior.f3331w = false;
        }
    }

    @Override // a.a
    public final void H(View view, int i, int i10) {
        float width = view.getWidth();
        SwipeDismissBehavior swipeDismissBehavior = this.f12346c;
        float f = width * swipeDismissBehavior.f3333y;
        float width2 = view.getWidth() * swipeDismissBehavior.f3334z;
        float fAbs = Math.abs(i - this.f12344a);
        if (fAbs <= f) {
            view.setAlpha(1.0f);
        } else if (fAbs >= width2) {
            view.setAlpha(0.0f);
        } else {
            view.setAlpha(Math.min(Math.max(0.0f, 1.0f - ((fAbs - f) / (width2 - f))), 1.0f));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0067  */
    @Override // a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void I(android.view.View r9, float r10, float r11) {
        /*
            r8 = this;
            r11 = -1
            r8.f12345b = r11
            int r11 = r9.getWidth()
            r0 = 0
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            r2 = 0
            com.google.android.material.behavior.SwipeDismissBehavior r3 = r8.f12346c
            r4 = 1
            if (r1 == 0) goto L39
            java.util.WeakHashMap r5 = q0.o0.f10475a
            int r5 = r9.getLayoutDirection()
            if (r5 != r4) goto L1a
            r5 = r4
            goto L1b
        L1a:
            r5 = r2
        L1b:
            int r6 = r3.f3332x
            r7 = 2
            if (r6 != r7) goto L21
            goto L52
        L21:
            if (r6 != 0) goto L2d
            if (r5 == 0) goto L2a
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L67
            goto L52
        L2a:
            if (r1 <= 0) goto L67
            goto L52
        L2d:
            if (r6 != r4) goto L67
            if (r5 == 0) goto L34
            if (r1 <= 0) goto L67
            goto L52
        L34:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L67
            goto L52
        L39:
            int r1 = r9.getLeft()
            int r5 = r8.f12344a
            int r1 = r1 - r5
            int r5 = r9.getWidth()
            float r5 = (float) r5
            r6 = 1056964608(0x3f000000, float:0.5)
            float r5 = r5 * r6
            int r5 = java.lang.Math.round(r5)
            int r1 = java.lang.Math.abs(r1)
            if (r1 < r5) goto L67
        L52:
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 < 0) goto L61
            int r10 = r9.getLeft()
            int r0 = r8.f12344a
            if (r10 >= r0) goto L5f
            goto L61
        L5f:
            int r0 = r0 + r11
            goto L65
        L61:
            int r10 = r8.f12344a
            int r0 = r10 - r11
        L65:
            r2 = r4
            goto L69
        L67:
            int r0 = r8.f12344a
        L69:
            y0.d r10 = r3.f3329u
            int r11 = r9.getTop()
            boolean r10 = r10.q(r0, r11)
            if (r10 == 0) goto L7f
            p7.i r10 = new p7.i
            r10.<init>(r3, r9, r2)
            java.util.WeakHashMap r11 = q0.o0.f10475a
            r9.postOnAnimation(r10)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: t8.a.I(android.view.View, float, float):void");
    }

    @Override // a.a
    public final boolean P(View view, int i) {
        int i10 = this.f12345b;
        return (i10 == -1 || i10 == i) && this.f12346c.w(view);
    }

    @Override // a.a
    public final int a(View view, int i) {
        int width;
        int width2;
        int width3;
        WeakHashMap weakHashMap = o0.f10475a;
        boolean z2 = view.getLayoutDirection() == 1;
        int i10 = this.f12346c.f3332x;
        if (i10 == 0) {
            if (z2) {
                width = this.f12344a - view.getWidth();
                width2 = this.f12344a;
            } else {
                width = this.f12344a;
                width3 = view.getWidth();
                width2 = width3 + width;
            }
        } else if (i10 != 1) {
            width = this.f12344a - view.getWidth();
            width2 = view.getWidth() + this.f12344a;
        } else if (z2) {
            width = this.f12344a;
            width3 = view.getWidth();
            width2 = width3 + width;
        } else {
            width = this.f12344a - view.getWidth();
            width2 = this.f12344a;
        }
        return Math.min(Math.max(width, i), width2);
    }

    @Override // a.a
    public final int b(View view, int i) {
        return view.getTop();
    }

    @Override // a.a
    public final int t(View view) {
        return view.getWidth();
    }

    @Override // a.a
    public final void G(int i) {
    }
}
