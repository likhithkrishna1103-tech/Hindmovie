package h9;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k extends i {
    public StateListAnimator K;

    @Override // h9.i
    public final float e() {
        return this.f6011s.getElevation();
    }

    @Override // h9.i
    public final void f(Rect rect) {
        if (((FloatingActionButton) this.f6012t.f11562v).E) {
            super.f(rect);
            return;
        }
        if (this.f) {
            FloatingActionButton floatingActionButton = this.f6011s;
            int sizeDimension = floatingActionButton.getSizeDimension();
            int i = this.f6003k;
            if (sizeDimension < i) {
                int sizeDimension2 = (i - floatingActionButton.getSizeDimension()) / 2;
                rect.set(sizeDimension2, sizeDimension2, sizeDimension2, sizeDimension2);
                return;
            }
        }
        rect.set(0, 0, 0, 0);
    }

    @Override // h9.i
    public final void g(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        Drawable layerDrawable;
        q9.k kVar = this.f5995a;
        kVar.getClass();
        j jVar = new j(kVar);
        this.f5996b = jVar;
        jVar.setTintList(colorStateList);
        if (mode != null) {
            this.f5996b.setTintMode(mode);
        }
        q9.g gVar = this.f5996b;
        FloatingActionButton floatingActionButton = this.f6011s;
        gVar.j(floatingActionButton.getContext());
        if (i > 0) {
            Context context = floatingActionButton.getContext();
            q9.k kVar2 = this.f5995a;
            kVar2.getClass();
            a aVar = new a(kVar2);
            int color = context.getColor(p8.c.design_fab_stroke_top_outer_color);
            int color2 = context.getColor(p8.c.design_fab_stroke_top_inner_color);
            int color3 = context.getColor(p8.c.design_fab_stroke_end_inner_color);
            int color4 = context.getColor(p8.c.design_fab_stroke_end_outer_color);
            aVar.i = color;
            aVar.f5968j = color2;
            aVar.f5969k = color3;
            aVar.f5970l = color4;
            float f = i;
            if (aVar.f5967h != f) {
                aVar.f5967h = f;
                aVar.f5962b.setStrokeWidth(f * 1.3333f);
                aVar.f5972n = true;
                aVar.invalidateSelf();
            }
            if (colorStateList != null) {
                aVar.f5971m = colorStateList.getColorForState(aVar.getState(), aVar.f5971m);
            }
            aVar.f5974p = colorStateList;
            aVar.f5972n = true;
            aVar.invalidateSelf();
            this.f5998d = aVar;
            a aVar2 = this.f5998d;
            aVar2.getClass();
            q9.g gVar2 = this.f5996b;
            gVar2.getClass();
            layerDrawable = new LayerDrawable(new Drawable[]{aVar2, gVar2});
        } else {
            this.f5998d = null;
            layerDrawable = this.f5996b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(o9.a.c(colorStateList2), layerDrawable, null);
        this.f5997c = rippleDrawable;
        this.f5999e = rippleDrawable;
    }

    @Override // h9.i
    public final void i() {
        q();
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
    @Override // h9.i
    public final void k(float f, float f4, float f10) {
        int i = Build.VERSION.SDK_INT;
        FloatingActionButton floatingActionButton = this.f6011s;
        if (floatingActionButton.getStateListAnimator() == this.K) {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(i.E, r(f, f10));
            stateListAnimator.addState(i.F, r(f, f4));
            stateListAnimator.addState(i.G, r(f, f4));
            stateListAnimator.addState(i.H, r(f, f4));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, "elevation", f).setDuration(0L));
            if (i <= 24) {
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(i.f5994z);
            stateListAnimator.addState(i.I, animatorSet);
            stateListAnimator.addState(i.J, r(0.0f, 0.0f));
            this.K = stateListAnimator;
            floatingActionButton.setStateListAnimator(stateListAnimator);
        }
        if (o()) {
            q();
        }
    }

    @Override // h9.i
    public final void m(ColorStateList colorStateList) {
        Drawable drawable = this.f5997c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(o9.a.c(colorStateList));
        } else {
            super.m(colorStateList);
        }
    }

    @Override // h9.i
    public final boolean o() {
        if (((FloatingActionButton) this.f6012t.f11562v).E) {
            return true;
        }
        return this.f && this.f6011s.getSizeDimension() < this.f6003k;
    }

    public final AnimatorSet r(float f, float f4) {
        AnimatorSet animatorSet = new AnimatorSet();
        float[] fArr = {f};
        FloatingActionButton floatingActionButton = this.f6011s;
        animatorSet.play(ObjectAnimator.ofFloat(floatingActionButton, "elevation", fArr).setDuration(0L)).with(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f4).setDuration(100L));
        animatorSet.setInterpolator(i.f5994z);
        return animatorSet;
    }

    @Override // h9.i
    public final void h() {
    }

    @Override // h9.i
    public final void p() {
    }

    @Override // h9.i
    public final void j(int[] iArr) {
    }
}
