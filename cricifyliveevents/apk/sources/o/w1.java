package o;

import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class w1 implements View.OnTouchListener, View.OnAttachStateChangeListener {
    public v1 A;
    public boolean B;
    public int C;
    public final int[] D = new int[2];

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final float f9397v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f9398w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f9399x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final View f9400y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public v1 f9401z;

    public w1(View view) {
        this.f9400y = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f9397v = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f9398w = tapTimeout;
        this.f9399x = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public final void a() {
        v1 v1Var = this.A;
        View view = this.f9400y;
        if (v1Var != null) {
            view.removeCallbacks(v1Var);
        }
        v1 v1Var2 = this.f9401z;
        if (v1Var2 != null) {
            view.removeCallbacks(v1Var2);
        }
    }

    public abstract n.a0 b();

    public abstract boolean c();

    public boolean d() {
        n.a0 a0VarB = b();
        if (a0VarB == null || !a0VarB.a()) {
            return true;
        }
        a0VarB.dismiss();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0100  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r13, android.view.MotionEvent r14) {
        /*
            Method dump skipped, instruction units count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o.w1.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.B = false;
        this.C = -1;
        v1 v1Var = this.f9401z;
        if (v1Var != null) {
            this.f9400y.removeCallbacks(v1Var);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
