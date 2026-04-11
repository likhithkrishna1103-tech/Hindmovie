package m9;

import android.view.VelocityTracker;
import android.view.View;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import f9.v1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e extends g {
    public int A;
    public int B;
    public int C;
    public VelocityTracker D;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public v1 f8400x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public OverScroller f8401y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f8402z;

    public final void A(CoordinatorLayout coordinatorLayout, View view, int i) {
        z(coordinatorLayout, view, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a5  */
    @Override // f0.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean k(androidx.coordinatorlayout.widget.CoordinatorLayout r8, android.view.View r9, android.view.MotionEvent r10) {
        /*
            r7 = this;
            int r0 = r7.C
            if (r0 >= 0) goto L12
            android.content.Context r0 = r8.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r7.C = r0
        L12:
            int r0 = r10.getActionMasked()
            r1 = 2
            r2 = 1
            r3 = -1
            r4 = 0
            if (r0 != r1) goto L42
            boolean r0 = r7.f8402z
            if (r0 == 0) goto L42
            int r0 = r7.A
            if (r0 != r3) goto L26
            goto La8
        L26:
            int r0 = r10.findPointerIndex(r0)
            if (r0 != r3) goto L2e
            goto La8
        L2e:
            float r0 = r10.getY(r0)
            int r0 = (int) r0
            int r1 = r7.B
            int r1 = r0 - r1
            int r1 = java.lang.Math.abs(r1)
            int r5 = r7.C
            if (r1 <= r5) goto L42
            r7.B = r0
            return r2
        L42:
            int r0 = r10.getActionMasked()
            if (r0 != 0) goto La1
            r7.A = r3
            float r0 = r10.getX()
            int r0 = (int) r0
            float r1 = r10.getY()
            int r1 = (int) r1
            r5 = r7
            com.google.android.material.appbar.AppBarLayout$BaseBehavior r5 = (com.google.android.material.appbar.AppBarLayout.BaseBehavior) r5
            r6 = r9
            com.google.android.material.appbar.AppBarLayout r6 = (com.google.android.material.appbar.AppBarLayout) r6
            java.lang.ref.WeakReference r5 = r5.I
            if (r5 == 0) goto L72
            java.lang.Object r5 = r5.get()
            android.view.View r5 = (android.view.View) r5
            if (r5 == 0) goto L7a
            boolean r6 = r5.isShown()
            if (r6 == 0) goto L7a
            boolean r3 = r5.canScrollVertically(r3)
            if (r3 != 0) goto L7a
        L72:
            boolean r8 = r8.p(r9, r0, r1)
            if (r8 == 0) goto L7a
            r8 = r2
            goto L7b
        L7a:
            r8 = r4
        L7b:
            r7.f8402z = r8
            if (r8 == 0) goto La1
            r7.B = r1
            int r8 = r10.getPointerId(r4)
            r7.A = r8
            android.view.VelocityTracker r8 = r7.D
            if (r8 != 0) goto L91
            android.view.VelocityTracker r8 = android.view.VelocityTracker.obtain()
            r7.D = r8
        L91:
            android.widget.OverScroller r8 = r7.f8401y
            if (r8 == 0) goto La1
            boolean r8 = r8.isFinished()
            if (r8 != 0) goto La1
            android.widget.OverScroller r8 = r7.f8401y
            r8.abortAnimation()
            return r2
        La1:
            android.view.VelocityTracker r8 = r7.D
            if (r8 == 0) goto La8
            r8.addMovement(r10)
        La8:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: m9.e.k(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fc A[ADDED_TO_REGION] */
    @Override // f0.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean v(androidx.coordinatorlayout.widget.CoordinatorLayout r21, android.view.View r22, android.view.MotionEvent r23) {
        /*
            Method dump skipped, instruction units count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m9.e.v(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public abstract int y();

    public abstract int z(CoordinatorLayout coordinatorLayout, View view, int i, int i10, int i11);
}
