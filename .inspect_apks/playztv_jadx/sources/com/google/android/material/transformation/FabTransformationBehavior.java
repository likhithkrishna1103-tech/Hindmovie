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
import java.util.ArrayList;
import java.util.WeakHashMap;
import k8.b0;
import p8.f;
import pb.c;
import q0.f0;
import q0.o0;
import q8.a;
import q8.b;
import q8.d;
import q8.e;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    public float A;
    public float B;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Rect f3554w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final RectF f3555x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final RectF f3556y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int[] f3557z;

    public FabTransformationBehavior() {
        this.f3554w = new Rect();
        this.f3555x = new RectF();
        this.f3556y = new RectF();
        this.f3557z = new int[2];
    }

    public static float B(c cVar, e eVar, float f) {
        long j5 = eVar.f11081a;
        long j8 = eVar.f11082b;
        e eVarD = ((d) cVar.f10310v).d("expansion");
        return a.a(f, 0.0f, eVar.b().getInterpolation((((eVarD.f11081a + eVarD.f11082b) + 17) - j5) / j8));
    }

    public static Pair y(float f, float f4, boolean z2, c cVar) {
        e eVarD;
        e eVarD2;
        if (f == 0.0f || f4 == 0.0f) {
            eVarD = ((d) cVar.f10310v).d("translationXLinear");
            eVarD2 = ((d) cVar.f10310v).d("translationYLinear");
        } else if ((!z2 || f4 >= 0.0f) && (z2 || f4 <= 0.0f)) {
            eVarD = ((d) cVar.f10310v).d("translationXCurveDownwards");
            eVarD2 = ((d) cVar.f10310v).d("translationYCurveDownwards");
        } else {
            eVarD = ((d) cVar.f10310v).d("translationXCurveUpwards");
            eVarD2 = ((d) cVar.f10310v).d("translationYCurveUpwards");
        }
        return new Pair(eVarD, eVarD2);
    }

    public final float A(View view, View view2, b0 b0Var) {
        RectF rectF = this.f3555x;
        C(view, rectF);
        rectF.offset(this.A, this.B);
        RectF rectF2 = this.f3556y;
        C(view2, rectF2);
        b0Var.getClass();
        return (rectF2.centerY() - rectF.centerY()) + 0.0f;
    }

    public final void C(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.f3557z);
        rectF.offsetTo(r0[0], r0[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    public abstract c D(Context context, boolean z2);

    @Override // com.google.android.material.transformation.ExpandableBehavior, c0.b
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

    @Override // c0.b
    public final void g(c0.e eVar) {
        if (eVar.f2215h == 0) {
            eVar.f2215h = 80;
        }
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public final AnimatorSet x(View view, View view2, boolean z2, boolean z10) {
        ObjectAnimator objectAnimatorOfFloat;
        int i;
        float f;
        ObjectAnimator objectAnimatorOfFloat2;
        ObjectAnimator objectAnimatorOfFloat3;
        ObjectAnimator objectAnimatorOfFloat4;
        c cVarD = D(view2.getContext(), z2);
        if (z2) {
            this.A = view.getTranslationX();
            this.B = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        WeakHashMap weakHashMap = o0.f10475a;
        float fE = f0.e(view2) - f0.e(view);
        if (z2) {
            if (!z10) {
                view2.setTranslationZ(-fE);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -fE);
        }
        ((d) cVarD.f10310v).d("elevation").a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        float fZ = z(view, view2, (b0) cVarD.f10311w);
        float fA = A(view, view2, (b0) cVarD.f10311w);
        Pair pairY = y(fZ, fA, z2, cVarD);
        e eVar = (e) pairY.first;
        e eVar2 = (e) pairY.second;
        RectF rectF = this.f3555x;
        if (z2) {
            if (!z10) {
                view2.setTranslationX(-fZ);
                view2.setTranslationY(-fA);
            }
            i = 0;
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            f = 0.0f;
            objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            float fB = B(cVarD, eVar, -fZ);
            float fB2 = B(cVarD, eVar2, -fA);
            Rect rect = this.f3554w;
            view2.getWindowVisibleDisplayFrame(rect);
            rectF.set(rect);
            RectF rectF2 = this.f3556y;
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
        float fZ2 = z(view, view2, (b0) cVarD.f10311w);
        float fA2 = A(view, view2, (b0) cVarD.f10311w);
        Pair pairY2 = y(fZ2, fA2, z2, cVarD);
        e eVar3 = (e) pairY2.first;
        e eVar4 = (e) pairY2.second;
        Property property = View.TRANSLATION_X;
        if (!z2) {
            fZ2 = this.A;
        }
        float[] fArr = new float[1];
        fArr[i] = fZ2;
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
        Property property2 = View.TRANSLATION_Y;
        if (!z2) {
            fA2 = this.B;
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
                if (z2) {
                    if (!z10) {
                        b.f11077a.set(viewGroup, Float.valueOf(f));
                    }
                    b bVar = b.f11077a;
                    float[] fArr3 = new float[1];
                    fArr3[i] = 1.0f;
                    objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(viewGroup, bVar, fArr3);
                } else {
                    b bVar2 = b.f11077a;
                    float[] fArr4 = new float[1];
                    fArr4[i] = f;
                    objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(viewGroup, bVar2, fArr4);
                }
                ((d) cVarD.f10310v).d("contentFade").a(objectAnimatorOfFloat4);
                arrayList.add(objectAnimatorOfFloat4);
            }
        }
        AnimatorSet animatorSet = new AnimatorSet();
        com.bumptech.glide.d.E(animatorSet, arrayList);
        animatorSet.addListener(new y9.b(z2, view2, view));
        int size = arrayList2.size();
        for (int i10 = i; i10 < size; i10++) {
            animatorSet.addListener((Animator.AnimatorListener) arrayList2.get(i10));
        }
        return animatorSet;
    }

    public final float z(View view, View view2, b0 b0Var) {
        RectF rectF = this.f3555x;
        C(view, rectF);
        rectF.offset(this.A, this.B);
        RectF rectF2 = this.f3556y;
        C(view2, rectF2);
        b0Var.getClass();
        return (rectF2.centerX() - rectF.centerX()) + 0.0f;
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3554w = new Rect();
        this.f3555x = new RectF();
        this.f3556y = new RectF();
        this.f3557z = new int[2];
    }
}
