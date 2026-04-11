package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import f9.a0;
import java.util.ArrayList;
import k9.f;
import l9.a;
import l9.b;
import l9.d;
import l9.e;
import nb.w;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    public final int[] A;
    public float B;
    public float C;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Rect f3017x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final RectF f3018y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final RectF f3019z;

    public FabTransformationBehavior() {
        this.f3017x = new Rect();
        this.f3018y = new RectF();
        this.f3019z = new RectF();
        this.A = new int[2];
    }

    public static float B(w wVar, e eVar, float f) {
        long j4 = eVar.f7934a;
        long j7 = eVar.f7935b;
        e eVarD = ((d) wVar.f9016w).d("expansion");
        return a.a(f, 0.0f, eVar.b().getInterpolation((((eVarD.f7934a + eVarD.f7935b) + 17) - j4) / j7));
    }

    public static Pair y(float f, float f10, boolean z10, w wVar) {
        e eVarD;
        e eVarD2;
        if (f == 0.0f || f10 == 0.0f) {
            eVarD = ((d) wVar.f9016w).d("translationXLinear");
            eVarD2 = ((d) wVar.f9016w).d("translationYLinear");
        } else if ((!z10 || f10 >= 0.0f) && (z10 || f10 <= 0.0f)) {
            eVarD = ((d) wVar.f9016w).d("translationXCurveDownwards");
            eVarD2 = ((d) wVar.f9016w).d("translationYCurveDownwards");
        } else {
            eVarD = ((d) wVar.f9016w).d("translationXCurveUpwards");
            eVarD2 = ((d) wVar.f9016w).d("translationYCurveUpwards");
        }
        return new Pair(eVarD, eVarD2);
    }

    public final float A(View view, View view2, a0 a0Var) {
        RectF rectF = this.f3018y;
        C(view, rectF);
        rectF.offset(this.B, this.C);
        RectF rectF2 = this.f3019z;
        C(view2, rectF2);
        a0Var.getClass();
        return (rectF2.centerY() - rectF.centerY()) + 0.0f;
    }

    public final void C(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.A);
        rectF.offsetTo(r0[0], r0[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    public abstract w D(Context context, boolean z10);

    @Override // com.google.android.material.transformation.ExpandableBehavior, f0.b
    public final boolean f(View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        if (!(view2 instanceof FloatingActionButton)) {
            return false;
        }
        int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
        return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
    }

    @Override // f0.b
    public final void g(f0.e eVar) {
        if (eVar.f3903h == 0) {
            eVar.f3903h = 80;
        }
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public final AnimatorSet x(View view, View view2, boolean z10, boolean z11) {
        ObjectAnimator objectAnimatorOfFloat;
        int i;
        float f;
        ObjectAnimator objectAnimatorOfFloat2;
        ObjectAnimator objectAnimatorOfFloat3;
        ObjectAnimator objectAnimatorOfFloat4;
        w wVarD = D(view2.getContext(), z10);
        if (z10) {
            this.B = view.getTranslationX();
            this.C = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        float elevation = view2.getElevation() - view.getElevation();
        if (z10) {
            if (!z11) {
                view2.setTranslationZ(-elevation);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -elevation);
        }
        ((d) wVarD.f9016w).d("elevation").a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        float fZ = z(view, view2, (a0) wVarD.f9017x);
        float fA = A(view, view2, (a0) wVarD.f9017x);
        Pair pairY = y(fZ, fA, z10, wVarD);
        e eVar = (e) pairY.first;
        e eVar2 = (e) pairY.second;
        RectF rectF = this.f3018y;
        if (z10) {
            if (!z11) {
                view2.setTranslationX(-fZ);
                view2.setTranslationY(-fA);
            }
            i = 0;
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            f = 0.0f;
            objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            float fB = B(wVarD, eVar, -fZ);
            float fB2 = B(wVarD, eVar2, -fA);
            Rect rect = this.f3017x;
            view2.getWindowVisibleDisplayFrame(rect);
            rectF.set(rect);
            RectF rectF2 = this.f3019z;
            C(view2, rectF2);
            rectF2.offset(fB, fB2);
            rectF2.intersect(rectF);
            rectF.set(rectF2);
        } else {
            i = 0;
            f = 0.0f;
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -fZ);
            objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -fA);
        }
        eVar.a(objectAnimatorOfFloat2);
        eVar2.a(objectAnimatorOfFloat3);
        arrayList.add(objectAnimatorOfFloat2);
        arrayList.add(objectAnimatorOfFloat3);
        rectF.width();
        rectF.height();
        float fZ2 = z(view, view2, (a0) wVarD.f9017x);
        float fA2 = A(view, view2, (a0) wVarD.f9017x);
        Pair pairY2 = y(fZ2, fA2, z10, wVarD);
        e eVar3 = (e) pairY2.first;
        e eVar4 = (e) pairY2.second;
        Property property = View.TRANSLATION_X;
        if (!z10) {
            fZ2 = this.B;
        }
        float[] fArr = new float[1];
        fArr[i] = fZ2;
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
        Property property2 = View.TRANSLATION_Y;
        if (!z10) {
            fA2 = this.C;
        }
        float[] fArr2 = new float[1];
        fArr2[i] = fA2;
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fArr2);
        eVar3.a(objectAnimatorOfFloat5);
        eVar4.a(objectAnimatorOfFloat6);
        arrayList.add(objectAnimatorOfFloat5);
        arrayList.add(objectAnimatorOfFloat6);
        if (view2 instanceof ViewGroup) {
            View viewFindViewById = view2.findViewById(f.mtrl_child_content_container);
            ViewGroup viewGroup = viewFindViewById != null ? viewFindViewById instanceof ViewGroup ? (ViewGroup) viewFindViewById : null : (ViewGroup) view2;
            if (viewGroup != null) {
                if (z10) {
                    if (!z11) {
                        b.f7930a.set(viewGroup, Float.valueOf(f));
                    }
                    b bVar = b.f7930a;
                    float[] fArr3 = new float[1];
                    fArr3[i] = 1.0f;
                    objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(viewGroup, bVar, fArr3);
                } else {
                    b bVar2 = b.f7930a;
                    float[] fArr4 = new float[1];
                    fArr4[i] = f;
                    objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(viewGroup, bVar2, fArr4);
                }
                ((d) wVarD.f9016w).d("contentFade").a(objectAnimatorOfFloat4);
                arrayList.add(objectAnimatorOfFloat4);
            }
        }
        AnimatorSet animatorSet = new AnimatorSet();
        com.bumptech.glide.e.l(animatorSet, arrayList);
        animatorSet.addListener(new sa.b(z10, view2, view));
        int size = arrayList2.size();
        for (int i10 = i; i10 < size; i10++) {
            animatorSet.addListener((Animator.AnimatorListener) arrayList2.get(i10));
        }
        return animatorSet;
    }

    public final float z(View view, View view2, a0 a0Var) {
        RectF rectF = this.f3018y;
        C(view, rectF);
        rectF.offset(this.B, this.C);
        RectF rectF2 = this.f3019z;
        C(view2, rectF2);
        a0Var.getClass();
        return (rectF2.centerX() - rectF.centerX()) + 0.0f;
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3017x = new Rect();
        this.f3018y = new RectF();
        this.f3019z = new RectF();
        this.A = new int[2];
    }
}
