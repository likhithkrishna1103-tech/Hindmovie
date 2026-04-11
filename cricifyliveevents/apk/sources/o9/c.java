package o9;

import android.view.View;
import android.view.ViewParent;
import com.google.android.material.behavior.SwipeDismissBehavior;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends n5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9709b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SwipeDismissBehavior f9710c;

    public c(SwipeDismissBehavior swipeDismissBehavior) {
        this.f9710c = swipeDismissBehavior;
    }

    @Override // n5.a
    public final void A(View view, int i) {
        this.f9709b = i;
        this.f9708a = view.getLeft();
        ViewParent parent = view.getParent();
        if (parent != null) {
            SwipeDismissBehavior swipeDismissBehavior = this.f9710c;
            swipeDismissBehavior.f2786x = true;
            parent.requestDisallowInterceptTouchEvent(true);
            swipeDismissBehavior.f2786x = false;
        }
    }

    @Override // n5.a
    public final void C(View view, int i, int i10) {
        float width = view.getWidth();
        SwipeDismissBehavior swipeDismissBehavior = this.f9710c;
        float f = width * swipeDismissBehavior.f2788z;
        float width2 = view.getWidth() * swipeDismissBehavior.A;
        float fAbs = Math.abs(i - this.f9708a);
        if (fAbs <= f) {
            view.setAlpha(1.0f);
        } else if (fAbs >= width2) {
            view.setAlpha(0.0f);
        } else {
            view.setAlpha(Math.min(Math.max(0.0f, 1.0f - ((fAbs - f) / (width2 - f))), 1.0f));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0065  */
    @Override // n5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void D(android.view.View r9, float r10, float r11) {
        /*
            r8 = this;
            r11 = -1
            r8.f9709b = r11
            int r11 = r9.getWidth()
            r0 = 0
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            r2 = 0
            com.google.android.material.behavior.SwipeDismissBehavior r3 = r8.f9710c
            r4 = 1
            if (r1 == 0) goto L37
            int r5 = r9.getLayoutDirection()
            if (r5 != r4) goto L18
            r5 = r4
            goto L19
        L18:
            r5 = r2
        L19:
            int r6 = r3.f2787y
            r7 = 2
            if (r6 != r7) goto L1f
            goto L50
        L1f:
            if (r6 != 0) goto L2b
            if (r5 == 0) goto L28
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L65
            goto L50
        L28:
            if (r1 <= 0) goto L65
            goto L50
        L2b:
            if (r6 != r4) goto L65
            if (r5 == 0) goto L32
            if (r1 <= 0) goto L65
            goto L50
        L32:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L65
            goto L50
        L37:
            int r1 = r9.getLeft()
            int r5 = r8.f9708a
            int r1 = r1 - r5
            int r5 = r9.getWidth()
            float r5 = (float) r5
            r6 = 1056964608(0x3f000000, float:0.5)
            float r5 = r5 * r6
            int r5 = java.lang.Math.round(r5)
            int r1 = java.lang.Math.abs(r1)
            if (r1 < r5) goto L65
        L50:
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 < 0) goto L5f
            int r10 = r9.getLeft()
            int r0 = r8.f9708a
            if (r10 >= r0) goto L5d
            goto L5f
        L5d:
            int r0 = r0 + r11
            goto L63
        L5f:
            int r10 = r8.f9708a
            int r0 = r10 - r11
        L63:
            r2 = r4
            goto L67
        L65:
            int r0 = r8.f9708a
        L67:
            b1.e r10 = r3.f2784v
            int r11 = r9.getTop()
            boolean r10 = r10.q(r0, r11)
            if (r10 == 0) goto L7b
            k8.j r10 = new k8.j
            r10.<init>(r3, r9, r2)
            r9.postOnAnimation(r10)
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o9.c.D(android.view.View, float, float):void");
    }

    @Override // n5.a
    public final boolean N(View view, int i) {
        int i10 = this.f9709b;
        return (i10 == -1 || i10 == i) && this.f9710c.w(view);
    }

    @Override // n5.a
    public final int d(View view, int i) {
        int width;
        int width2;
        int width3;
        boolean z10 = view.getLayoutDirection() == 1;
        int i10 = this.f9710c.f2787y;
        if (i10 == 0) {
            if (z10) {
                width = this.f9708a - view.getWidth();
                width2 = this.f9708a;
            } else {
                width = this.f9708a;
                width3 = view.getWidth();
                width2 = width3 + width;
            }
        } else if (i10 != 1) {
            width = this.f9708a - view.getWidth();
            width2 = view.getWidth() + this.f9708a;
        } else if (z10) {
            width = this.f9708a;
            width3 = view.getWidth();
            width2 = width3 + width;
        } else {
            width = this.f9708a - view.getWidth();
            width2 = this.f9708a;
        }
        return Math.min(Math.max(width, i), width2);
    }

    @Override // n5.a
    public final int e(View view, int i) {
        return view.getTop();
    }

    @Override // n5.a
    public final int r(View view) {
        return view.getWidth();
    }

    @Override // n5.a
    public final void B(int i) {
    }
}
