package v9;

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
import j9.f0;
import java.util.WeakHashMap;
import n.d1;
import q0.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u extends LinearLayout {
    public int A;
    public ImageView.ScaleType B;
    public View.OnLongClickListener C;
    public boolean D;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final TextInputLayout f13417u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final d1 f13418v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CharSequence f13419w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final CheckableImageButton f13420x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ColorStateList f13421y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public PorterDuff.Mode f13422z;

    public u(TextInputLayout textInputLayout, kc.b bVar) {
        CharSequence text;
        super(textInputLayout.getContext());
        this.f13417u = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(p8.h.design_text_input_start_icon, (ViewGroup) this, false);
        this.f13420x = checkableImageButton;
        d1 d1Var = new d1(getContext(), null);
        this.f13418v = d1Var;
        if (a.a.y(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginEnd(0);
        }
        View.OnLongClickListener onLongClickListener = this.C;
        checkableImageButton.setOnClickListener(null);
        i5.a.M(checkableImageButton, onLongClickListener);
        this.C = null;
        checkableImageButton.setOnLongClickListener(null);
        i5.a.M(checkableImageButton, null);
        int i = p8.l.TextInputLayout_startIconTint;
        TypedArray typedArray = (TypedArray) bVar.f7621w;
        if (typedArray.hasValue(i)) {
            this.f13421y = a.a.j(getContext(), bVar, p8.l.TextInputLayout_startIconTint);
        }
        if (typedArray.hasValue(p8.l.TextInputLayout_startIconTintMode)) {
            this.f13422z = f0.e(typedArray.getInt(p8.l.TextInputLayout_startIconTintMode, -1), null);
        }
        if (typedArray.hasValue(p8.l.TextInputLayout_startIconDrawable)) {
            b(bVar.s(p8.l.TextInputLayout_startIconDrawable));
            if (typedArray.hasValue(p8.l.TextInputLayout_startIconContentDescription) && checkableImageButton.getContentDescription() != (text = typedArray.getText(p8.l.TextInputLayout_startIconContentDescription))) {
                checkableImageButton.setContentDescription(text);
            }
            checkableImageButton.setCheckable(typedArray.getBoolean(p8.l.TextInputLayout_startIconCheckable, true));
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(p8.l.TextInputLayout_startIconMinSize, getResources().getDimensionPixelSize(p8.d.mtrl_min_touch_target_size));
        if (dimensionPixelSize < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (dimensionPixelSize != this.A) {
            this.A = dimensionPixelSize;
            checkableImageButton.setMinimumWidth(dimensionPixelSize);
            checkableImageButton.setMinimumHeight(dimensionPixelSize);
        }
        if (typedArray.hasValue(p8.l.TextInputLayout_startIconScaleType)) {
            ImageView.ScaleType scaleTypeF = i5.a.f(typedArray.getInt(p8.l.TextInputLayout_startIconScaleType, -1));
            this.B = scaleTypeF;
            checkableImageButton.setScaleType(scaleTypeF);
        }
        d1Var.setVisibility(8);
        d1Var.setId(p8.f.textinput_prefix_text);
        d1Var.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        WeakHashMap weakHashMap = o0.f10475a;
        d1Var.setAccessibilityLiveRegion(1);
        d1Var.setTextAppearance(typedArray.getResourceId(p8.l.TextInputLayout_prefixTextAppearance, 0));
        if (typedArray.hasValue(p8.l.TextInputLayout_prefixTextColor)) {
            d1Var.setTextColor(bVar.q(p8.l.TextInputLayout_prefixTextColor));
        }
        CharSequence text2 = typedArray.getText(p8.l.TextInputLayout_prefixText);
        this.f13419w = TextUtils.isEmpty(text2) ? null : text2;
        d1Var.setText(text2);
        e();
        addView(checkableImageButton);
        addView(d1Var);
    }

    public final int a() {
        int marginEnd;
        CheckableImageButton checkableImageButton = this.f13420x;
        if (checkableImageButton.getVisibility() == 0) {
            marginEnd = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginEnd() + checkableImageButton.getMeasuredWidth();
        } else {
            marginEnd = 0;
        }
        WeakHashMap weakHashMap = o0.f10475a;
        return this.f13418v.getPaddingStart() + getPaddingStart() + marginEnd;
    }

    public final void b(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f13420x;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = this.f13421y;
            PorterDuff.Mode mode = this.f13422z;
            TextInputLayout textInputLayout = this.f13417u;
            i5.a.b(textInputLayout, checkableImageButton, colorStateList, mode);
            c(true);
            i5.a.H(textInputLayout, checkableImageButton, this.f13421y);
            return;
        }
        c(false);
        View.OnLongClickListener onLongClickListener = this.C;
        checkableImageButton.setOnClickListener(null);
        i5.a.M(checkableImageButton, onLongClickListener);
        this.C = null;
        checkableImageButton.setOnLongClickListener(null);
        i5.a.M(checkableImageButton, null);
        if (checkableImageButton.getContentDescription() != null) {
            checkableImageButton.setContentDescription(null);
        }
    }

    public final void c(boolean z2) {
        CheckableImageButton checkableImageButton = this.f13420x;
        if ((checkableImageButton.getVisibility() == 0) != z2) {
            checkableImageButton.setVisibility(z2 ? 0 : 8);
            d();
            e();
        }
    }

    public final void d() {
        int paddingStart;
        EditText editText = this.f13417u.f3525x;
        if (editText == null) {
            return;
        }
        if (this.f13420x.getVisibility() == 0) {
            paddingStart = 0;
        } else {
            WeakHashMap weakHashMap = o0.f10475a;
            paddingStart = editText.getPaddingStart();
        }
        int compoundPaddingTop = editText.getCompoundPaddingTop();
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(p8.d.material_input_text_to_prefix_suffix_padding);
        int compoundPaddingBottom = editText.getCompoundPaddingBottom();
        WeakHashMap weakHashMap2 = o0.f10475a;
        this.f13418v.setPaddingRelative(paddingStart, compoundPaddingTop, dimensionPixelSize, compoundPaddingBottom);
    }

    public final void e() {
        int i = (this.f13419w == null || this.D) ? 8 : 0;
        setVisibility((this.f13420x.getVisibility() == 0 || i == 0) ? 0 : 8);
        this.f13418v.setVisibility(i);
        this.f13417u.q();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i10) {
        super.onMeasure(i, i10);
        d();
    }
}
