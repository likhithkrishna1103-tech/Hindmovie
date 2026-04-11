package v4;

import android.R;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends f0 {
    public static final int[] C = {R.attr.state_pressed};
    public static final int[] D = new int[0];
    public int A;
    public final androidx.fragment.app.m B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StateListDrawable f13267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Drawable f13268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f13269e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final StateListDrawable f13270g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Drawable f13271h;
    public final int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f13272j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f13273k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f13274l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f13275m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f13276n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f13277o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f13278p;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final RecyclerView f13281s;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ValueAnimator f13288z;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f13279q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f13280r = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f13282t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f13283u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f13284v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f13285w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int[] f13286x = new int[2];

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int[] f13287y = new int[2];

    public j(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i10, int i11) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f13288z = valueAnimatorOfFloat;
        this.A = 0;
        androidx.fragment.app.m mVar = new androidx.fragment.app.m(28, this);
        this.B = mVar;
        i iVar = new i(this);
        this.f13267c = stateListDrawable;
        this.f13268d = drawable;
        this.f13270g = stateListDrawable2;
        this.f13271h = drawable2;
        this.f13269e = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.f = Math.max(i, drawable.getIntrinsicWidth());
        this.i = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.f13272j = Math.max(i, drawable2.getIntrinsicWidth());
        this.f13265a = i10;
        this.f13266b = i11;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        valueAnimatorOfFloat.addListener(new ba.e(this));
        valueAnimatorOfFloat.addUpdateListener(new oa.b(3, this));
        RecyclerView recyclerView2 = this.f13281s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            ArrayList arrayList = recyclerView2.K;
            h0 h0Var = recyclerView2.I;
            if (h0Var != null) {
                h0Var.c("Cannot remove item decoration during a scroll  or layout");
            }
            arrayList.remove(this);
            if (arrayList.isEmpty()) {
                recyclerView2.setWillNotDraw(recyclerView2.getOverScrollMode() == 2);
            }
            recyclerView2.R();
            recyclerView2.requestLayout();
            RecyclerView recyclerView3 = this.f13281s;
            recyclerView3.L.remove(this);
            if (recyclerView3.M == this) {
                recyclerView3.M = null;
            }
            ArrayList arrayList2 = this.f13281s.D0;
            if (arrayList2 != null) {
                arrayList2.remove(iVar);
            }
            this.f13281s.removeCallbacks(mVar);
        }
        this.f13281s = recyclerView;
        recyclerView.i(this);
        this.f13281s.L.add(this);
        this.f13281s.j(iVar);
    }

    public static int e(float f, float f10, int[] iArr, int i, int i10, int i11) {
        int i12 = iArr[1] - iArr[0];
        if (i12 != 0) {
            int i13 = i - i11;
            int i14 = (int) (((f10 - f) / i12) * i13);
            int i15 = i10 + i14;
            if (i15 < i13 && i15 >= 0) {
                return i14;
            }
        }
        return 0;
    }

    @Override // v4.f0
    public final void b(Canvas canvas, RecyclerView recyclerView) {
        if (this.f13279q != this.f13281s.getWidth() || this.f13280r != this.f13281s.getHeight()) {
            this.f13279q = this.f13281s.getWidth();
            this.f13280r = this.f13281s.getHeight();
            f(0);
            return;
        }
        if (this.A != 0) {
            if (this.f13282t) {
                int i = this.f13279q;
                int i10 = this.f13269e;
                int i11 = i - i10;
                int i12 = this.f13274l;
                int i13 = this.f13273k;
                int i14 = i12 - (i13 / 2);
                StateListDrawable stateListDrawable = this.f13267c;
                stateListDrawable.setBounds(0, 0, i10, i13);
                int i15 = this.f;
                int i16 = this.f13280r;
                Drawable drawable = this.f13268d;
                drawable.setBounds(0, 0, i15, i16);
                if (this.f13281s.getLayoutDirection() == 1) {
                    drawable.draw(canvas);
                    canvas.translate(i10, i14);
                    canvas.scale(-1.0f, 1.0f);
                    stateListDrawable.draw(canvas);
                    canvas.scale(-1.0f, 1.0f);
                    canvas.translate(-i10, -i14);
                } else {
                    canvas.translate(i11, 0.0f);
                    drawable.draw(canvas);
                    canvas.translate(0.0f, i14);
                    stateListDrawable.draw(canvas);
                    canvas.translate(-i11, -i14);
                }
            }
            if (this.f13283u) {
                int i17 = this.f13280r;
                int i18 = this.i;
                int i19 = i17 - i18;
                int i20 = this.f13277o;
                int i21 = this.f13276n;
                int i22 = i20 - (i21 / 2);
                StateListDrawable stateListDrawable2 = this.f13270g;
                stateListDrawable2.setBounds(0, 0, i21, i18);
                int i23 = this.f13279q;
                int i24 = this.f13272j;
                Drawable drawable2 = this.f13271h;
                drawable2.setBounds(0, 0, i23, i24);
                canvas.translate(0.0f, i19);
                drawable2.draw(canvas);
                canvas.translate(i22, 0.0f);
                stateListDrawable2.draw(canvas);
                canvas.translate(-i22, -i19);
            }
        }
    }

    public final boolean c(float f, float f10) {
        if (f10 < this.f13280r - this.i) {
            return false;
        }
        int i = this.f13277o;
        int i10 = this.f13276n;
        return f >= ((float) (i - (i10 / 2))) && f <= ((float) ((i10 / 2) + i));
    }

    public final boolean d(float f, float f10) {
        int layoutDirection = this.f13281s.getLayoutDirection();
        int i = this.f13269e;
        if (layoutDirection == 1) {
            if (f > i) {
                return false;
            }
        } else if (f < this.f13279q - i) {
            return false;
        }
        int i10 = this.f13274l;
        int i11 = this.f13273k / 2;
        return f10 >= ((float) (i10 - i11)) && f10 <= ((float) (i11 + i10));
    }

    public final void f(int i) {
        androidx.fragment.app.m mVar = this.B;
        StateListDrawable stateListDrawable = this.f13267c;
        if (i == 2 && this.f13284v != 2) {
            stateListDrawable.setState(C);
            this.f13281s.removeCallbacks(mVar);
        }
        if (i == 0) {
            this.f13281s.invalidate();
        } else {
            g();
        }
        if (this.f13284v == 2 && i != 2) {
            stateListDrawable.setState(D);
            this.f13281s.removeCallbacks(mVar);
            this.f13281s.postDelayed(mVar, 1200);
        } else if (i == 1) {
            this.f13281s.removeCallbacks(mVar);
            this.f13281s.postDelayed(mVar, 1500);
        }
        this.f13284v = i;
    }

    public final void g() {
        int i = this.A;
        ValueAnimator valueAnimator = this.f13288z;
        if (i != 0) {
            if (i != 3) {
                return;
            } else {
                valueAnimator.cancel();
            }
        }
        this.A = 1;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        valueAnimator.setDuration(500L);
        valueAnimator.setStartDelay(0L);
        valueAnimator.start();
    }
}
