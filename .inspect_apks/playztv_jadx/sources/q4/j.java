package q4;

import android.R;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j extends f0 {
    public static final int[] C = {R.attr.state_pressed};
    public static final int[] D = new int[0];
    public int A;
    public final androidx.fragment.app.e B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StateListDrawable f10837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Drawable f10838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f10839e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final StateListDrawable f10840g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Drawable f10841h;
    public final int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f10842j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f10843k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f10844l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f10845m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f10846n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f10847o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f10848p;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final RecyclerView f10851s;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ValueAnimator f10858z;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f10849q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f10850r = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f10852t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f10853u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f10854v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f10855w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int[] f10856x = new int[2];

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int[] f10857y = new int[2];

    public j(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i10, int i11) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f10858z = valueAnimatorOfFloat;
        this.A = 0;
        androidx.fragment.app.e eVar = new androidx.fragment.app.e(19, this);
        this.B = eVar;
        i iVar = new i(this);
        this.f10837c = stateListDrawable;
        this.f10838d = drawable;
        this.f10840g = stateListDrawable2;
        this.f10841h = drawable2;
        this.f10839e = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.f = Math.max(i, drawable.getIntrinsicWidth());
        this.i = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.f10842j = Math.max(i, drawable2.getIntrinsicWidth());
        this.f10835a = i10;
        this.f10836b = i11;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        valueAnimatorOfFloat.addListener(new h9.c(this));
        valueAnimatorOfFloat.addUpdateListener(new j9.b0(1, this));
        RecyclerView recyclerView2 = this.f10851s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            ArrayList arrayList = recyclerView2.J;
            h0 h0Var = recyclerView2.H;
            if (h0Var != null) {
                h0Var.c("Cannot remove item decoration during a scroll  or layout");
            }
            arrayList.remove(this);
            if (arrayList.isEmpty()) {
                recyclerView2.setWillNotDraw(recyclerView2.getOverScrollMode() == 2);
            }
            recyclerView2.R();
            recyclerView2.requestLayout();
            RecyclerView recyclerView3 = this.f10851s;
            recyclerView3.K.remove(this);
            if (recyclerView3.L == this) {
                recyclerView3.L = null;
            }
            ArrayList arrayList2 = this.f10851s.C0;
            if (arrayList2 != null) {
                arrayList2.remove(iVar);
            }
            this.f10851s.removeCallbacks(eVar);
        }
        this.f10851s = recyclerView;
        recyclerView.i(this);
        this.f10851s.K.add(this);
        this.f10851s.j(iVar);
    }

    public static int e(float f, float f4, int[] iArr, int i, int i10, int i11) {
        int i12 = iArr[1] - iArr[0];
        if (i12 != 0) {
            int i13 = i - i11;
            int i14 = (int) (((f4 - f) / i12) * i13);
            int i15 = i10 + i14;
            if (i15 < i13 && i15 >= 0) {
                return i14;
            }
        }
        return 0;
    }

    @Override // q4.f0
    public final void b(Canvas canvas, RecyclerView recyclerView) {
        if (this.f10849q != this.f10851s.getWidth() || this.f10850r != this.f10851s.getHeight()) {
            this.f10849q = this.f10851s.getWidth();
            this.f10850r = this.f10851s.getHeight();
            f(0);
            return;
        }
        if (this.A != 0) {
            if (this.f10852t) {
                int i = this.f10849q;
                int i10 = this.f10839e;
                int i11 = i - i10;
                int i12 = this.f10844l;
                int i13 = this.f10843k;
                int i14 = i12 - (i13 / 2);
                StateListDrawable stateListDrawable = this.f10837c;
                stateListDrawable.setBounds(0, 0, i10, i13);
                int i15 = this.f;
                int i16 = this.f10850r;
                Drawable drawable = this.f10838d;
                drawable.setBounds(0, 0, i15, i16);
                if (this.f10851s.getLayoutDirection() == 1) {
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
            if (this.f10853u) {
                int i17 = this.f10850r;
                int i18 = this.i;
                int i19 = i17 - i18;
                int i20 = this.f10847o;
                int i21 = this.f10846n;
                int i22 = i20 - (i21 / 2);
                StateListDrawable stateListDrawable2 = this.f10840g;
                stateListDrawable2.setBounds(0, 0, i21, i18);
                int i23 = this.f10849q;
                int i24 = this.f10842j;
                Drawable drawable2 = this.f10841h;
                drawable2.setBounds(0, 0, i23, i24);
                canvas.translate(0.0f, i19);
                drawable2.draw(canvas);
                canvas.translate(i22, 0.0f);
                stateListDrawable2.draw(canvas);
                canvas.translate(-i22, -i19);
            }
        }
    }

    public final boolean c(float f, float f4) {
        if (f4 < this.f10850r - this.i) {
            return false;
        }
        int i = this.f10847o;
        int i10 = this.f10846n;
        return f >= ((float) (i - (i10 / 2))) && f <= ((float) ((i10 / 2) + i));
    }

    public final boolean d(float f, float f4) {
        int layoutDirection = this.f10851s.getLayoutDirection();
        int i = this.f10839e;
        if (layoutDirection == 1) {
            if (f > i) {
                return false;
            }
        } else if (f < this.f10849q - i) {
            return false;
        }
        int i10 = this.f10844l;
        int i11 = this.f10843k / 2;
        return f4 >= ((float) (i10 - i11)) && f4 <= ((float) (i11 + i10));
    }

    public final void f(int i) {
        androidx.fragment.app.e eVar = this.B;
        StateListDrawable stateListDrawable = this.f10837c;
        if (i == 2 && this.f10854v != 2) {
            stateListDrawable.setState(C);
            this.f10851s.removeCallbacks(eVar);
        }
        if (i == 0) {
            this.f10851s.invalidate();
        } else {
            g();
        }
        if (this.f10854v == 2 && i != 2) {
            stateListDrawable.setState(D);
            this.f10851s.removeCallbacks(eVar);
            this.f10851s.postDelayed(eVar, 1200);
        } else if (i == 1) {
            this.f10851s.removeCallbacks(eVar);
            this.f10851s.postDelayed(eVar, 1500);
        }
        this.f10854v = i;
    }

    public final void g() {
        int i = this.A;
        ValueAnimator valueAnimator = this.f10858z;
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
