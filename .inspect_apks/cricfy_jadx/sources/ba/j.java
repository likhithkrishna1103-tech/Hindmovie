package ba;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import ka.m;
import ka.w;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f1876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f1877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RippleDrawable f1878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f1879d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RippleDrawable f1880e;
    public boolean f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f1882h;
    public float i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f1883j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1884k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public StateListAnimator f1885l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Animator f1886m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public l9.d f1887n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public l9.d f1888o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f1890q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final FloatingActionButton f1892s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final pc.c f1893t;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final q1.a f1874y = l9.a.f7927c;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f1875z = k9.b.motionDurationLong2;
    public static final int A = k9.b.motionEasingEmphasizedInterpolator;
    public static final int B = k9.b.motionDurationMedium1;
    public static final int C = k9.b.motionEasingEmphasizedAccelerateInterpolator;
    public static final int[] D = {R.attr.state_pressed, R.attr.state_enabled};
    public static final int[] E = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
    public static final int[] F = {R.attr.state_focused, R.attr.state_enabled};
    public static final int[] G = {R.attr.state_hovered, R.attr.state_enabled};
    public static final int[] H = {R.attr.state_enabled};
    public static final int[] I = new int[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1881g = true;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f1889p = 1.0f;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f1891r = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Rect f1894u = new Rect();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final RectF f1895v = new RectF();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final RectF f1896w = new RectF();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Matrix f1897x = new Matrix();

    public j(FloatingActionButton floatingActionButton, pc.c cVar) {
        this.f1892s = floatingActionButton;
        this.f1893t = cVar;
    }

    public final void a(float f, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.f1892s.getDrawable();
        if (drawable == null || this.f1890q == 0) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        RectF rectF = this.f1895v;
        rectF.set(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
        float f10 = this.f1890q;
        RectF rectF2 = this.f1896w;
        rectF2.set(0.0f, 0.0f, f10, f10);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        float f11 = this.f1890q / 2.0f;
        matrix.postScale(f, f, f11, f11);
    }

    public final AnimatorSet b(l9.d dVar, float f, float f10, float f11) {
        ArrayList arrayList = new ArrayList();
        Property property = View.ALPHA;
        float[] fArr = {f};
        FloatingActionButton floatingActionButton = this.f1892s;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) property, fArr);
        dVar.d("opacity").a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.SCALE_X, f10);
        dVar.d("scale").a(objectAnimatorOfFloat2);
        int i = Build.VERSION.SDK_INT;
        if (i == 26) {
            objectAnimatorOfFloat2.setEvaluator(new h(0));
        }
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.SCALE_Y, f10);
        dVar.d("scale").a(objectAnimatorOfFloat3);
        if (i == 26) {
            objectAnimatorOfFloat3.setEvaluator(new h(0));
        }
        arrayList.add(objectAnimatorOfFloat3);
        Matrix matrix = this.f1897x;
        a(f11, matrix);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(floatingActionButton, new l9.c(), new g(this), new Matrix(matrix));
        dVar.d("iconScale").a(objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        com.bumptech.glide.e.l(animatorSet, arrayList);
        return animatorSet;
    }

    public final AnimatorSet c(final float f, final float f10, final float f11, int i, int i10) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        FloatingActionButton floatingActionButton = this.f1892s;
        final float alpha = floatingActionButton.getAlpha();
        final float scaleX = floatingActionButton.getScaleX();
        final float scaleY = floatingActionButton.getScaleY();
        final float f12 = this.f1889p;
        final Matrix matrix = new Matrix(this.f1897x);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ba.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                j jVar = this.f1856a;
                jVar.getClass();
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FloatingActionButton floatingActionButton2 = jVar.f1892s;
                floatingActionButton2.setAlpha(l9.a.b(alpha, f, 0.0f, 0.2f, fFloatValue));
                float f13 = scaleX;
                float f14 = f10;
                floatingActionButton2.setScaleX(l9.a.a(f13, f14, fFloatValue));
                floatingActionButton2.setScaleY(l9.a.a(scaleY, f14, fFloatValue));
                float f15 = f12;
                float f16 = f11;
                jVar.f1889p = l9.a.a(f15, f16, fFloatValue);
                float fA = l9.a.a(f15, f16, fFloatValue);
                Matrix matrix2 = matrix;
                jVar.a(fA, matrix2);
                floatingActionButton2.setImageMatrix(matrix2);
            }
        });
        arrayList.add(valueAnimatorOfFloat);
        com.bumptech.glide.e.l(animatorSet, arrayList);
        animatorSet.setDuration(sd.i.C(floatingActionButton.getContext(), i, floatingActionButton.getContext().getResources().getInteger(k9.g.material_motion_duration_long_1)));
        animatorSet.setInterpolator(sd.i.D(floatingActionButton.getContext(), i10, l9.a.f7926b));
        return animatorSet;
    }

    public final AnimatorSet d(float f, float f10) {
        AnimatorSet animatorSet = new AnimatorSet();
        float[] fArr = {f};
        FloatingActionButton floatingActionButton = this.f1892s;
        animatorSet.play(ObjectAnimator.ofFloat(floatingActionButton, "elevation", fArr).setDuration(0L)).with(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f10).setDuration(100L));
        animatorSet.setInterpolator(f1874y);
        return animatorSet;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void e(float f, float f10, float f11) {
        int i = Build.VERSION.SDK_INT;
        FloatingActionButton floatingActionButton = this.f1892s;
        if (floatingActionButton.getStateListAnimator() == this.f1885l) {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(D, d(f, f11));
            stateListAnimator.addState(E, d(f, f10));
            stateListAnimator.addState(F, d(f, f10));
            stateListAnimator.addState(G, d(f, f10));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, "elevation", f).setDuration(0L));
            if (i <= 24) {
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(f1874y);
            stateListAnimator.addState(H, animatorSet);
            stateListAnimator.addState(I, d(0.0f, 0.0f));
            this.f1885l = stateListAnimator;
            floatingActionButton.setStateListAnimator(stateListAnimator);
        }
        if (((FloatingActionButton) this.f1893t.f10180v).F || (this.f && floatingActionButton.getSizeDimension() < this.f1884k)) {
            h();
        }
    }

    public final void g(m mVar) {
        this.f1876a = mVar;
        i iVar = this.f1877b;
        if (iVar != null) {
            iVar.setShapeAppearanceModel(mVar);
        }
        Drawable.Callback callback = this.f1878c;
        if (callback instanceof w) {
            ((w) callback).setShapeAppearanceModel(mVar);
        }
        b bVar = this.f1879d;
        if (bVar != null) {
            bVar.f1854o = mVar;
            bVar.invalidateSelf();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h() {
        /*
            r10 = this;
            pc.c r0 = r10.f1893t
            java.lang.Object r1 = r0.f10180v
            com.google.android.material.floatingactionbutton.FloatingActionButton r1 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r1
            java.lang.Object r2 = r0.f10180v
            com.google.android.material.floatingactionbutton.FloatingActionButton r2 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r2
            boolean r1 = r1.F
            android.graphics.Rect r3 = r10.f1894u
            com.google.android.material.floatingactionbutton.FloatingActionButton r4 = r10.f1892s
            r5 = 0
            if (r1 == 0) goto L4c
            boolean r1 = r10.f
            if (r1 == 0) goto L24
            int r1 = r10.f1884k
            int r6 = r4.getSizeDimension()
            int r1 = r1 - r6
            int r1 = r1 / 2
            int r5 = java.lang.Math.max(r1, r5)
        L24:
            boolean r1 = r10.f1881g
            if (r1 == 0) goto L30
            float r1 = r4.getElevation()
            float r6 = r10.f1883j
            float r1 = r1 + r6
            goto L31
        L30:
            r1 = 0
        L31:
            double r6 = (double) r1
            double r6 = java.lang.Math.ceil(r6)
            int r6 = (int) r6
            int r6 = java.lang.Math.max(r5, r6)
            r7 = 1069547520(0x3fc00000, float:1.5)
            float r1 = r1 * r7
            double r7 = (double) r1
            double r7 = java.lang.Math.ceil(r7)
            int r1 = (int) r7
            int r1 = java.lang.Math.max(r5, r1)
            r3.set(r6, r1, r6, r1)
            goto L66
        L4c:
            boolean r1 = r10.f
            if (r1 == 0) goto L63
            int r1 = r4.getSizeDimension()
            int r6 = r10.f1884k
            if (r1 >= r6) goto L63
            int r1 = r4.getSizeDimension()
            int r6 = r6 - r1
            int r6 = r6 / 2
            r3.set(r6, r6, r6, r6)
            goto L66
        L63:
            r3.set(r5, r5, r5, r5)
        L66:
            android.graphics.drawable.RippleDrawable r1 = r10.f1880e
            java.lang.String r5 = "Didn't initialize content background"
            com.bumptech.glide.f.f(r1, r5)
            java.lang.Object r0 = r0.f10180v
            com.google.android.material.floatingactionbutton.FloatingActionButton r0 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r0
            boolean r0 = r0.F
            if (r0 != 0) goto L8a
            boolean r0 = r10.f
            if (r0 == 0) goto L82
            int r0 = r4.getSizeDimension()
            int r1 = r10.f1884k
            if (r0 >= r1) goto L82
            goto L8a
        L82:
            android.graphics.drawable.RippleDrawable r0 = r10.f1880e
            if (r0 == 0) goto L9c
            com.google.android.material.floatingactionbutton.FloatingActionButton.b(r2, r0)
            goto L9c
        L8a:
            android.graphics.drawable.InsetDrawable r4 = new android.graphics.drawable.InsetDrawable
            android.graphics.drawable.RippleDrawable r5 = r10.f1880e
            int r6 = r3.left
            int r7 = r3.top
            int r8 = r3.right
            int r9 = r3.bottom
            r4.<init>(r5, r6, r7, r8, r9)
            com.google.android.material.floatingactionbutton.FloatingActionButton.b(r2, r4)
        L9c:
            int r0 = r3.left
            int r1 = r3.top
            int r4 = r3.right
            int r3 = r3.bottom
            android.graphics.Rect r5 = r2.G
            r5.set(r0, r1, r4, r3)
            int r5 = r2.D
            int r0 = r0 + r5
            int r1 = r1 + r5
            int r4 = r4 + r5
            int r3 = r3 + r5
            r2.setPadding(r0, r1, r4, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ba.j.h():void");
    }

    public final void f() {
    }
}
