package v9;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.WeakHashMap;
import n.d1;
import q0.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q {
    public ColorStateList A;
    public Typeface B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TimeInterpolator f13389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TimeInterpolator f13390e;
    public final TimeInterpolator f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f13391g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextInputLayout f13392h;
    public LinearLayout i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f13393j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public FrameLayout f13394k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AnimatorSet f13395l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f13396m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f13397n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f13398o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f13399p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f13400q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public d1 f13401r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CharSequence f13402s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f13403t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f13404u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ColorStateList f13405v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CharSequence f13406w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f13407x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public d1 f13408y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f13409z;

    public q(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f13391g = context;
        this.f13392h = textInputLayout;
        this.f13396m = context.getResources().getDimensionPixelSize(p8.d.design_textinput_caption_translate_y);
        this.f13386a = b8.h.x(context, p8.b.motionDurationShort4, 217);
        this.f13387b = b8.h.x(context, p8.b.motionDurationMedium4, 167);
        this.f13388c = b8.h.x(context, p8.b.motionDurationShort4, 167);
        this.f13389d = b8.h.y(context, p8.b.motionEasingEmphasizedDecelerateInterpolator, q8.a.f11075d);
        int i = p8.b.motionEasingEmphasizedDecelerateInterpolator;
        LinearInterpolator linearInterpolator = q8.a.f11072a;
        this.f13390e = b8.h.y(context, i, linearInterpolator);
        this.f = b8.h.y(context, p8.b.motionEasingLinearInterpolator, linearInterpolator);
    }

    public final void a(d1 d1Var, int i) {
        if (this.i == null && this.f13394k == null) {
            Context context = this.f13391g;
            LinearLayout linearLayout = new LinearLayout(context);
            this.i = linearLayout;
            linearLayout.setOrientation(0);
            LinearLayout linearLayout2 = this.i;
            TextInputLayout textInputLayout = this.f13392h;
            textInputLayout.addView(linearLayout2, -1, -2);
            this.f13394k = new FrameLayout(context);
            this.i.addView(this.f13394k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (textInputLayout.getEditText() != null) {
                b();
            }
        }
        if (i == 0 || i == 1) {
            this.f13394k.setVisibility(0);
            this.f13394k.addView(d1Var);
        } else {
            this.i.addView(d1Var, new LinearLayout.LayoutParams(-2, -2));
        }
        this.i.setVisibility(0);
        this.f13393j++;
    }

    public final void b() {
        if (this.i != null) {
            TextInputLayout textInputLayout = this.f13392h;
            if (textInputLayout.getEditText() != null) {
                EditText editText = textInputLayout.getEditText();
                Context context = this.f13391g;
                boolean zY = a.a.y(context);
                LinearLayout linearLayout = this.i;
                int i = p8.d.material_helper_text_font_1_3_padding_horizontal;
                WeakHashMap weakHashMap = o0.f10475a;
                int paddingStart = editText.getPaddingStart();
                if (zY) {
                    paddingStart = context.getResources().getDimensionPixelSize(i);
                }
                int i10 = p8.d.material_helper_text_font_1_3_padding_top;
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(p8.d.material_helper_text_default_padding_top);
                if (zY) {
                    dimensionPixelSize = context.getResources().getDimensionPixelSize(i10);
                }
                int i11 = p8.d.material_helper_text_font_1_3_padding_horizontal;
                int paddingEnd = editText.getPaddingEnd();
                if (zY) {
                    paddingEnd = context.getResources().getDimensionPixelSize(i11);
                }
                linearLayout.setPaddingRelative(paddingStart, dimensionPixelSize, paddingEnd, 0);
            }
        }
    }

    public final void c() {
        AnimatorSet animatorSet = this.f13395l;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public final void d(ArrayList arrayList, boolean z2, d1 d1Var, int i, int i10, int i11) {
        if (d1Var == null || !z2) {
            return;
        }
        if (i == i11 || i == i10) {
            boolean z10 = i11 == i;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(d1Var, (Property<d1, Float>) View.ALPHA, z10 ? 1.0f : 0.0f);
            int i12 = this.f13388c;
            objectAnimatorOfFloat.setDuration(z10 ? this.f13387b : i12);
            objectAnimatorOfFloat.setInterpolator(z10 ? this.f13390e : this.f);
            if (i == i11 && i10 != 0) {
                objectAnimatorOfFloat.setStartDelay(i12);
            }
            arrayList.add(objectAnimatorOfFloat);
            if (i11 != i || i10 == 0) {
                return;
            }
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(d1Var, (Property<d1, Float>) View.TRANSLATION_Y, -this.f13396m, 0.0f);
            objectAnimatorOfFloat2.setDuration(this.f13386a);
            objectAnimatorOfFloat2.setInterpolator(this.f13389d);
            objectAnimatorOfFloat2.setStartDelay(i12);
            arrayList.add(objectAnimatorOfFloat2);
        }
    }

    public final TextView e(int i) {
        if (i == 1) {
            return this.f13401r;
        }
        if (i != 2) {
            return null;
        }
        return this.f13408y;
    }

    public final void f() {
        this.f13399p = null;
        c();
        if (this.f13397n == 1) {
            if (!this.f13407x || TextUtils.isEmpty(this.f13406w)) {
                this.f13398o = 0;
            } else {
                this.f13398o = 2;
            }
        }
        i(this.f13397n, this.f13398o, h(this.f13401r, ""));
    }

    public final void g(d1 d1Var, int i) {
        FrameLayout frameLayout;
        LinearLayout linearLayout = this.i;
        if (linearLayout == null) {
            return;
        }
        if ((i == 0 || i == 1) && (frameLayout = this.f13394k) != null) {
            frameLayout.removeView(d1Var);
        } else {
            linearLayout.removeView(d1Var);
        }
        int i10 = this.f13393j - 1;
        this.f13393j = i10;
        LinearLayout linearLayout2 = this.i;
        if (i10 == 0) {
            linearLayout2.setVisibility(8);
        }
    }

    public final boolean h(d1 d1Var, CharSequence charSequence) {
        WeakHashMap weakHashMap = o0.f10475a;
        TextInputLayout textInputLayout = this.f13392h;
        if (textInputLayout.isLaidOut() && textInputLayout.isEnabled()) {
            return (this.f13398o == this.f13397n && d1Var != null && TextUtils.equals(d1Var.getText(), charSequence)) ? false : true;
        }
        return false;
    }

    public final void i(int i, int i10, boolean z2) {
        TextView textViewE;
        TextView textViewE2;
        if (i == i10) {
            return;
        }
        if (z2) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f13395l = animatorSet;
            ArrayList arrayList = new ArrayList();
            d(arrayList, this.f13407x, this.f13408y, 2, i, i10);
            d(arrayList, this.f13400q, this.f13401r, 1, i, i10);
            com.bumptech.glide.d.E(animatorSet, arrayList);
            animatorSet.addListener(new o(this, i10, e(i), i, e(i10)));
            animatorSet.start();
        } else if (i != i10) {
            if (i10 != 0 && (textViewE2 = e(i10)) != null) {
                textViewE2.setVisibility(0);
                textViewE2.setAlpha(1.0f);
            }
            if (i != 0 && (textViewE = e(i)) != null) {
                textViewE.setVisibility(4);
                if (i == 1) {
                    textViewE.setText((CharSequence) null);
                }
            }
            this.f13397n = i10;
        }
        TextInputLayout textInputLayout = this.f13392h;
        textInputLayout.r();
        textInputLayout.u(z2, false);
        textInputLayout.x();
    }
}
