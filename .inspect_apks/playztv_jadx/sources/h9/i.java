package h9;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import cf.l;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import q9.u;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q9.k f5995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q9.g f5996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f5997c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f5998d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LayerDrawable f5999e;
    public boolean f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f6001h;
    public float i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f6002j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6003k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Animator f6004l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public q8.d f6005m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public q8.d f6006n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f6007o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6009q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final FloatingActionButton f6011s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final rc.b f6012t;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public c0.f f6017y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final k1.a f5994z = q8.a.f11074c;
    public static final int A = p8.b.motionDurationLong2;
    public static final int B = p8.b.motionEasingEmphasizedInterpolator;
    public static final int C = p8.b.motionDurationMedium1;
    public static final int D = p8.b.motionEasingEmphasizedAccelerateInterpolator;
    public static final int[] E = {R.attr.state_pressed, R.attr.state_enabled};
    public static final int[] F = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
    public static final int[] G = {R.attr.state_focused, R.attr.state_enabled};
    public static final int[] H = {R.attr.state_hovered, R.attr.state_enabled};
    public static final int[] I = {R.attr.state_enabled};
    public static final int[] J = new int[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f6000g = true;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f6008p = 1.0f;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f6010r = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Rect f6013u = new Rect();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final RectF f6014v = new RectF();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final RectF f6015w = new RectF();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Matrix f6016x = new Matrix();

    public i(FloatingActionButton floatingActionButton, rc.b bVar) {
        this.f6011s = floatingActionButton;
        this.f6012t = bVar;
        a7.b bVar2 = new a7.b(26);
        k kVar = (k) this;
        bVar2.h(E, d(new g(kVar, 1)));
        bVar2.h(F, d(new g(kVar, 0)));
        bVar2.h(G, d(new g(kVar, 0)));
        bVar2.h(H, d(new g(kVar, 0)));
        bVar2.h(I, d(new g(kVar, 2)));
        bVar2.h(J, d(new f(kVar)));
        this.f6007o = floatingActionButton.getRotation();
    }

    public static ValueAnimator d(h hVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(f5994z);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(hVar);
        valueAnimator.addUpdateListener(hVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    public final void a(float f, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.f6011s.getDrawable();
        if (drawable == null || this.f6009q == 0) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        RectF rectF = this.f6014v;
        rectF.set(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
        float f4 = this.f6009q;
        RectF rectF2 = this.f6015w;
        rectF2.set(0.0f, 0.0f, f4, f4);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        float f10 = this.f6009q / 2.0f;
        matrix.postScale(f, f, f10, f10);
    }

    public final AnimatorSet b(q8.d dVar, float f, float f4, float f10) {
        ArrayList arrayList = new ArrayList();
        Property property = View.ALPHA;
        int i = 1;
        float[] fArr = {f};
        FloatingActionButton floatingActionButton = this.f6011s;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) property, fArr);
        dVar.d("opacity").a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.SCALE_X, f4);
        dVar.d("scale").a(objectAnimatorOfFloat2);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 == 26) {
            h5.g gVar = new h5.g(i);
            gVar.f5893b = new FloatEvaluator();
            objectAnimatorOfFloat2.setEvaluator(gVar);
        }
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.SCALE_Y, f4);
        dVar.d("scale").a(objectAnimatorOfFloat3);
        if (i10 == 26) {
            h5.g gVar2 = new h5.g(i);
            gVar2.f5893b = new FloatEvaluator();
            objectAnimatorOfFloat3.setEvaluator(gVar2);
        }
        arrayList.add(objectAnimatorOfFloat3);
        Matrix matrix = this.f6016x;
        a(f10, matrix);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(floatingActionButton, new q8.c(), new d(this), new Matrix(matrix));
        dVar.d("iconScale").a(objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        com.bumptech.glide.d.E(animatorSet, arrayList);
        return animatorSet;
    }

    public final AnimatorSet c(float f, float f4, float f10, int i, int i10) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        FloatingActionButton floatingActionButton = this.f6011s;
        valueAnimatorOfFloat.addUpdateListener(new e(this, floatingActionButton.getAlpha(), f, floatingActionButton.getScaleX(), f4, floatingActionButton.getScaleY(), this.f6008p, f10, new Matrix(this.f6016x)));
        arrayList.add(valueAnimatorOfFloat);
        com.bumptech.glide.d.E(animatorSet, arrayList);
        animatorSet.setDuration(b8.h.x(floatingActionButton.getContext(), i, floatingActionButton.getContext().getResources().getInteger(p8.g.material_motion_duration_long_1)));
        animatorSet.setInterpolator(b8.h.y(floatingActionButton.getContext(), i10, q8.a.f11073b));
        return animatorSet;
    }

    public abstract float e();

    public void f(Rect rect) {
        int iMax = this.f ? Math.max((this.f6003k - this.f6011s.getSizeDimension()) / 2, 0) : 0;
        int iMax2 = Math.max(iMax, (int) Math.ceil(this.f6000g ? e() + this.f6002j : 0.0f));
        int iMax3 = Math.max(iMax, (int) Math.ceil(r0 * 1.5f));
        rect.set(iMax2, iMax3, iMax2, iMax3);
    }

    public abstract void g(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i);

    public abstract void h();

    public abstract void i();

    public abstract void j(int[] iArr);

    public abstract void k(float f, float f4, float f10);

    public void m(ColorStateList colorStateList) {
        Drawable drawable = this.f5997c;
        if (drawable != null) {
            drawable.setTintList(o9.a.c(colorStateList));
        }
    }

    public final void n(q9.k kVar) {
        this.f5995a = kVar;
        q9.g gVar = this.f5996b;
        if (gVar != null) {
            gVar.setShapeAppearanceModel(kVar);
        }
        Object obj = this.f5997c;
        if (obj instanceof u) {
            ((u) obj).setShapeAppearanceModel(kVar);
        }
        a aVar = this.f5998d;
        if (aVar != null) {
            aVar.f5973o = kVar;
            aVar.invalidateSelf();
        }
    }

    public abstract boolean o();

    public abstract void p();

    public final void q() {
        Rect rect = this.f6013u;
        f(rect);
        l.j(this.f5999e, "Didn't initialize content background");
        boolean zO = o();
        rc.b bVar = this.f6012t;
        if (zO) {
            super/*android.widget.ImageButton*/.setBackgroundDrawable(new InsetDrawable((Drawable) this.f5999e, rect.left, rect.top, rect.right, rect.bottom));
        } else {
            LayerDrawable layerDrawable = this.f5999e;
            if (layerDrawable != null) {
                super/*android.widget.ImageButton*/.setBackgroundDrawable(layerDrawable);
            } else {
                bVar.getClass();
            }
        }
        int i = rect.left;
        int i10 = rect.top;
        int i11 = rect.right;
        int i12 = rect.bottom;
        FloatingActionButton floatingActionButton = (FloatingActionButton) bVar.f11562v;
        floatingActionButton.F.set(i, i10, i11, i12);
        int i13 = floatingActionButton.C;
        floatingActionButton.setPadding(i + i13, i10 + i13, i11 + i13, i12 + i13);
    }

    public final void l() {
    }
}
