package pa;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import da.e0;
import o.a1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x extends LinearLayout {
    public PorterDuff.Mode A;
    public int B;
    public ImageView.ScaleType C;
    public View.OnLongClickListener D;
    public boolean E;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final TextInputLayout f10134v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final a1 f10135w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public CharSequence f10136x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final CheckableImageButton f10137y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ColorStateList f10138z;

    public x(TextInputLayout textInputLayout, l7.a aVar) {
        CharSequence text;
        super(textInputLayout.getContext());
        this.f10134v = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(k9.h.design_text_input_start_icon, (ViewGroup) this, false);
        this.f10137y = checkableImageButton;
        a1 a1Var = new a1(getContext(), null);
        this.f10135w = a1Var;
        if (com.bumptech.glide.c.z(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginEnd(0);
        }
        View.OnLongClickListener onLongClickListener = this.D;
        checkableImageButton.setOnClickListener(null);
        u8.a.B(checkableImageButton, onLongClickListener);
        this.D = null;
        checkableImageButton.setOnLongClickListener(null);
        u8.a.B(checkableImageButton, null);
        int i = k9.l.TextInputLayout_startIconTint;
        TypedArray typedArray = (TypedArray) aVar.f7867x;
        if (typedArray.hasValue(i)) {
            this.f10138z = com.bumptech.glide.c.j(getContext(), aVar, k9.l.TextInputLayout_startIconTint);
        }
        if (typedArray.hasValue(k9.l.TextInputLayout_startIconTintMode)) {
            this.A = e0.c(typedArray.getInt(k9.l.TextInputLayout_startIconTintMode, -1), null);
        }
        if (typedArray.hasValue(k9.l.TextInputLayout_startIconDrawable)) {
            b(aVar.u(k9.l.TextInputLayout_startIconDrawable));
            if (typedArray.hasValue(k9.l.TextInputLayout_startIconContentDescription) && checkableImageButton.getContentDescription() != (text = typedArray.getText(k9.l.TextInputLayout_startIconContentDescription))) {
                checkableImageButton.setContentDescription(text);
            }
            checkableImageButton.setCheckable(typedArray.getBoolean(k9.l.TextInputLayout_startIconCheckable, true));
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(k9.l.TextInputLayout_startIconMinSize, getResources().getDimensionPixelSize(k9.d.mtrl_min_touch_target_size));
        if (dimensionPixelSize < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (dimensionPixelSize != this.B) {
            this.B = dimensionPixelSize;
            checkableImageButton.setMinimumWidth(dimensionPixelSize);
            checkableImageButton.setMinimumHeight(dimensionPixelSize);
        }
        if (typedArray.hasValue(k9.l.TextInputLayout_startIconScaleType)) {
            ImageView.ScaleType scaleTypeK = u8.a.k(typedArray.getInt(k9.l.TextInputLayout_startIconScaleType, -1));
            this.C = scaleTypeK;
            checkableImageButton.setScaleType(scaleTypeK);
        }
        a1Var.setVisibility(8);
        a1Var.setId(k9.f.textinput_prefix_text);
        a1Var.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        a1Var.setAccessibilityLiveRegion(1);
        a1Var.setTextAppearance(typedArray.getResourceId(k9.l.TextInputLayout_prefixTextAppearance, 0));
        if (typedArray.hasValue(k9.l.TextInputLayout_prefixTextColor)) {
            a1Var.setTextColor(aVar.r(k9.l.TextInputLayout_prefixTextColor));
        }
        CharSequence text2 = typedArray.getText(k9.l.TextInputLayout_prefixText);
        this.f10136x = TextUtils.isEmpty(text2) ? null : text2;
        a1Var.setText(text2);
        e();
        addView(checkableImageButton);
        addView(a1Var);
    }

    public final int a() {
        int marginEnd;
        CheckableImageButton checkableImageButton = this.f10137y;
        if (checkableImageButton.getVisibility() == 0) {
            marginEnd = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginEnd() + checkableImageButton.getMeasuredWidth();
        } else {
            marginEnd = 0;
        }
        return this.f10135w.getPaddingStart() + getPaddingStart() + marginEnd;
    }

    public final void b(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f10137y;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = this.f10138z;
            PorterDuff.Mode mode = this.A;
            TextInputLayout textInputLayout = this.f10134v;
            u8.a.b(textInputLayout, checkableImageButton, colorStateList, mode);
            c(true);
            u8.a.y(textInputLayout, checkableImageButton, this.f10138z);
            return;
        }
        c(false);
        View.OnLongClickListener onLongClickListener = this.D;
        checkableImageButton.setOnClickListener(null);
        u8.a.B(checkableImageButton, onLongClickListener);
        this.D = null;
        checkableImageButton.setOnLongClickListener(null);
        u8.a.B(checkableImageButton, null);
        if (checkableImageButton.getContentDescription() != null) {
            checkableImageButton.setContentDescription(null);
        }
    }

    public final void c(boolean z10) {
        CheckableImageButton checkableImageButton = this.f10137y;
        if ((checkableImageButton.getVisibility() == 0) != z10) {
            checkableImageButton.setVisibility(z10 ? 0 : 8);
            d();
            e();
        }
    }

    public final void d() {
        EditText editText = this.f10134v.f2992z;
        if (editText == null) {
            return;
        }
        this.f10135w.setPaddingRelative(this.f10137y.getVisibility() == 0 ? 0 : editText.getPaddingStart(), editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(k9.d.material_input_text_to_prefix_suffix_padding), editText.getCompoundPaddingBottom());
    }

    public final void e() {
        int i = (this.f10136x == null || this.E) ? 8 : 0;
        setVisibility((this.f10137y.getVisibility() == 0 || i == 0) ? 0 : 8);
        this.f10135w.setVisibility(i);
        this.f10134v.s();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i10) {
        super.onMeasure(i, i10);
        d();
    }
}
