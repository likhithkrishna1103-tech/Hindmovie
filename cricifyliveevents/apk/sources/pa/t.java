package pa;

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
import o.a1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t {
    public ColorStateList A;
    public Typeface B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f10106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TimeInterpolator f10107d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TimeInterpolator f10108e;
    public final TimeInterpolator f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f10109g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextInputLayout f10110h;
    public LinearLayout i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f10111j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public FrameLayout f10112k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AnimatorSet f10113l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f10114m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f10115n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f10116o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f10117p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f10118q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public a1 f10119r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CharSequence f10120s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f10121t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f10122u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ColorStateList f10123v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CharSequence f10124w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f10125x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public a1 f10126y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f10127z;

    public t(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f10109g = context;
        this.f10110h = textInputLayout;
        this.f10114m = context.getResources().getDimensionPixelSize(k9.d.design_textinput_caption_translate_y);
        this.f10104a = sd.i.C(context, k9.b.motionDurationShort4, 217);
        this.f10105b = sd.i.C(context, k9.b.motionDurationMedium4, 167);
        this.f10106c = sd.i.C(context, k9.b.motionDurationShort4, 167);
        this.f10107d = sd.i.D(context, k9.b.motionEasingEmphasizedDecelerateInterpolator, l9.a.f7928d);
        int i = k9.b.motionEasingEmphasizedDecelerateInterpolator;
        LinearInterpolator linearInterpolator = l9.a.f7925a;
        this.f10108e = sd.i.D(context, i, linearInterpolator);
        this.f = sd.i.D(context, k9.b.motionEasingLinearInterpolator, linearInterpolator);
    }

    public final void a(a1 a1Var, int i) {
        if (this.i == null && this.f10112k == null) {
            Context context = this.f10109g;
            LinearLayout linearLayout = new LinearLayout(context);
            this.i = linearLayout;
            linearLayout.setOrientation(0);
            LinearLayout linearLayout2 = this.i;
            TextInputLayout textInputLayout = this.f10110h;
            textInputLayout.addView(linearLayout2, -1, -2);
            this.f10112k = new FrameLayout(context);
            this.i.addView(this.f10112k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (textInputLayout.getEditText() != null) {
                b();
            }
        }
        if (i == 0 || i == 1) {
            this.f10112k.setVisibility(0);
            this.f10112k.addView(a1Var);
        } else {
            this.i.addView(a1Var, new LinearLayout.LayoutParams(-2, -2));
        }
        this.i.setVisibility(0);
        this.f10111j++;
    }

    public final void b() {
        if (this.i != null) {
            TextInputLayout textInputLayout = this.f10110h;
            if (textInputLayout.getEditText() != null) {
                EditText editText = textInputLayout.getEditText();
                Context context = this.f10109g;
                boolean z10 = com.bumptech.glide.c.z(context);
                LinearLayout linearLayout = this.i;
                int i = k9.d.material_helper_text_font_1_3_padding_horizontal;
                int paddingStart = editText.getPaddingStart();
                if (z10) {
                    paddingStart = context.getResources().getDimensionPixelSize(i);
                }
                int i10 = k9.d.material_helper_text_font_1_3_padding_top;
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(k9.d.material_helper_text_default_padding_top);
                if (z10) {
                    dimensionPixelSize = context.getResources().getDimensionPixelSize(i10);
                }
                int i11 = k9.d.material_helper_text_font_1_3_padding_horizontal;
                int paddingEnd = editText.getPaddingEnd();
                if (z10) {
                    paddingEnd = context.getResources().getDimensionPixelSize(i11);
                }
                linearLayout.setPaddingRelative(paddingStart, dimensionPixelSize, paddingEnd, 0);
            }
        }
    }

    public final void c() {
        AnimatorSet animatorSet = this.f10113l;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public final void d(ArrayList arrayList, boolean z10, a1 a1Var, int i, int i10, int i11) {
        if (a1Var == null || !z10) {
            return;
        }
        if (i == i11 || i == i10) {
            boolean z11 = i11 == i;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(a1Var, (Property<a1, Float>) View.ALPHA, z11 ? 1.0f : 0.0f);
            int i12 = this.f10106c;
            objectAnimatorOfFloat.setDuration(z11 ? this.f10105b : i12);
            objectAnimatorOfFloat.setInterpolator(z11 ? this.f10108e : this.f);
            if (i == i11 && i10 != 0) {
                objectAnimatorOfFloat.setStartDelay(i12);
            }
            arrayList.add(objectAnimatorOfFloat);
            if (i11 != i || i10 == 0) {
                return;
            }
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(a1Var, (Property<a1, Float>) View.TRANSLATION_Y, -this.f10114m, 0.0f);
            objectAnimatorOfFloat2.setDuration(this.f10104a);
            objectAnimatorOfFloat2.setInterpolator(this.f10107d);
            objectAnimatorOfFloat2.setStartDelay(i12);
            arrayList.add(objectAnimatorOfFloat2);
        }
    }

    public final TextView e(int i) {
        if (i == 1) {
            return this.f10119r;
        }
        if (i != 2) {
            return null;
        }
        return this.f10126y;
    }

    public final void f() {
        this.f10117p = null;
        c();
        if (this.f10115n == 1) {
            if (!this.f10125x || TextUtils.isEmpty(this.f10124w)) {
                this.f10116o = 0;
            } else {
                this.f10116o = 2;
            }
        }
        i(this.f10115n, this.f10116o, h(this.f10119r, ""));
    }

    public final void g(a1 a1Var, int i) {
        FrameLayout frameLayout;
        LinearLayout linearLayout = this.i;
        if (linearLayout == null) {
            return;
        }
        if ((i == 0 || i == 1) && (frameLayout = this.f10112k) != null) {
            frameLayout.removeView(a1Var);
        } else {
            linearLayout.removeView(a1Var);
        }
        int i10 = this.f10111j - 1;
        this.f10111j = i10;
        LinearLayout linearLayout2 = this.i;
        if (i10 == 0) {
            linearLayout2.setVisibility(8);
        }
    }

    public final boolean h(a1 a1Var, CharSequence charSequence) {
        TextInputLayout textInputLayout = this.f10110h;
        if (textInputLayout.isLaidOut() && textInputLayout.isEnabled()) {
            return (this.f10116o == this.f10115n && a1Var != null && TextUtils.equals(a1Var.getText(), charSequence)) ? false : true;
        }
        return false;
    }

    public final void i(int i, int i10, boolean z10) {
        TextView textViewE;
        TextView textViewE2;
        if (i == i10) {
            return;
        }
        if (z10) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f10113l = animatorSet;
            ArrayList arrayList = new ArrayList();
            d(arrayList, this.f10125x, this.f10126y, 2, i, i10);
            d(arrayList, this.f10118q, this.f10119r, 1, i, i10);
            com.bumptech.glide.e.l(animatorSet, arrayList);
            animatorSet.addListener(new r(this, i10, e(i), i, e(i10)));
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
            this.f10115n = i10;
        }
        TextInputLayout textInputLayout = this.f10110h;
        textInputLayout.t();
        textInputLayout.w(z10, false);
        textInputLayout.z();
    }
}
