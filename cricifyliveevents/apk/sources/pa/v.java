package pa;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.Filterable;
import android.widget.ListAdapter;
import com.google.android.material.textfield.TextInputLayout;
import da.d0;
import java.util.List;
import java.util.Locale;
import o.g2;
import o.j0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v extends o.o {
    public final AccessibilityManager A;
    public final Rect B;
    public final int C;
    public final float D;
    public ColorStateList E;
    public int F;
    public ColorStateList G;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final g2 f10131z;

    /* JADX WARN: Illegal instructions before constructor call */
    public v(Context context, AttributeSet attributeSet) {
        int i = g.a.autoCompleteTextViewStyle;
        super(ra.a.a(context, attributeSet, i, 0), attributeSet, i);
        this.B = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayD = d0.d(context2, attributeSet, k9.l.MaterialAutoCompleteTextView, i, g.i.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        if (typedArrayD.hasValue(k9.l.MaterialAutoCompleteTextView_android_inputType) && typedArrayD.getInt(k9.l.MaterialAutoCompleteTextView_android_inputType, 0) == 0) {
            setKeyListener(null);
        }
        this.C = typedArrayD.getResourceId(k9.l.MaterialAutoCompleteTextView_simpleItemLayout, k9.h.mtrl_auto_complete_simple_item);
        this.D = typedArrayD.getDimensionPixelOffset(k9.l.MaterialAutoCompleteTextView_android_popupElevation, k9.d.mtrl_exposed_dropdown_menu_popup_elevation);
        if (typedArrayD.hasValue(k9.l.MaterialAutoCompleteTextView_dropDownBackgroundTint)) {
            this.E = ColorStateList.valueOf(typedArrayD.getColor(k9.l.MaterialAutoCompleteTextView_dropDownBackgroundTint, 0));
        }
        this.F = typedArrayD.getColor(k9.l.MaterialAutoCompleteTextView_simpleItemSelectedColor, 0);
        this.G = com.bumptech.glide.c.i(context2, typedArrayD, k9.l.MaterialAutoCompleteTextView_simpleItemSelectedRippleColor);
        this.A = (AccessibilityManager) context2.getSystemService("accessibility");
        g2 g2Var = new g2(context2, null, g.a.listPopupWindowStyle, 0);
        this.f10131z = g2Var;
        g2Var.T = true;
        g2Var.U.setFocusable(true);
        g2Var.J = this;
        g2Var.U.setInputMethodMode(2);
        g2Var.p(getAdapter());
        g2Var.K = new j0(2, this);
        if (typedArrayD.hasValue(k9.l.MaterialAutoCompleteTextView_simpleItems)) {
            setSimpleItems(typedArrayD.getResourceId(k9.l.MaterialAutoCompleteTextView_simpleItems, 0));
        }
        typedArrayD.recycle();
    }

    public final TextInputLayout b() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    public final boolean c() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        AccessibilityManager accessibilityManager = this.A;
        if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled()) {
            return true;
        }
        if (accessibilityManager == null || !accessibilityManager.isEnabled() || (enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(16)) == null) {
            return false;
        }
        for (AccessibilityServiceInfo accessibilityServiceInfo : enabledAccessibilityServiceList) {
            if (accessibilityServiceInfo.getSettingsActivityName() != null && accessibilityServiceInfo.getSettingsActivityName().contains("SwitchAccess")) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.AutoCompleteTextView
    public final void dismissDropDown() {
        if (c()) {
            this.f10131z.dismiss();
        } else {
            super.dismissDropDown();
        }
    }

    public ColorStateList getDropDownBackgroundTintList() {
        return this.E;
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout textInputLayoutB = b();
        return (textInputLayoutB == null || !textInputLayoutB.f2967d0) ? super.getHint() : textInputLayoutB.getHint();
    }

    public float getPopupElevation() {
        return this.D;
    }

    public int getSimpleItemSelectedColor() {
        return this.F;
    }

    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.G;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayoutB = b();
        if (textInputLayoutB != null && textInputLayoutB.f2967d0 && super.getHint() == null) {
            String str = Build.MANUFACTURER;
            if ((str != null ? str.toLowerCase(Locale.ENGLISH) : "").equals("meizu")) {
                setHint("");
            }
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f10131z.dismiss();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i10) {
        super.onMeasure(i, i10);
        if (View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            int measuredWidth = getMeasuredWidth();
            ListAdapter adapter = getAdapter();
            TextInputLayout textInputLayoutB = b();
            int measuredWidth2 = 0;
            if (adapter != null && textInputLayoutB != null) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
                g2 g2Var = this.f10131z;
                int iMin = Math.min(adapter.getCount(), Math.max(0, !g2Var.U.isShowing() ? -1 : g2Var.f9231x.getSelectedItemPosition()) + 15);
                View view = null;
                int iMax = 0;
                for (int iMax2 = Math.max(0, iMin - 15); iMax2 < iMin; iMax2++) {
                    int itemViewType = adapter.getItemViewType(iMax2);
                    if (itemViewType != measuredWidth2) {
                        view = null;
                        measuredWidth2 = itemViewType;
                    }
                    view = adapter.getView(iMax2, view, textInputLayoutB);
                    if (view.getLayoutParams() == null) {
                        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    }
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    iMax = Math.max(iMax, view.getMeasuredWidth());
                }
                Drawable background = g2Var.U.getBackground();
                if (background != null) {
                    Rect rect = this.B;
                    background.getPadding(rect);
                    iMax += rect.left + rect.right;
                }
                measuredWidth2 = textInputLayoutB.getEndIconView().getMeasuredWidth() + iMax;
            }
            setMeasuredDimension(Math.min(Math.max(measuredWidth, measuredWidth2), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean z10) {
        if (c()) {
            return;
        }
        super.onWindowFocusChanged(z10);
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t10) {
        super.setAdapter(t10);
        this.f10131z.p(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundDrawable(Drawable drawable) {
        super.setDropDownBackgroundDrawable(drawable);
        g2 g2Var = this.f10131z;
        if (g2Var != null) {
            g2Var.h(drawable);
        }
    }

    public void setDropDownBackgroundTint(int i) {
        setDropDownBackgroundTintList(ColorStateList.valueOf(i));
    }

    public void setDropDownBackgroundTintList(ColorStateList colorStateList) {
        this.E = colorStateList;
        Drawable dropDownBackground = getDropDownBackground();
        if (dropDownBackground instanceof ka.i) {
            ((ka.i) dropDownBackground).q(this.E);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super.setOnItemSelectedListener(onItemSelectedListener);
        this.f10131z.L = getOnItemSelectedListener();
    }

    @Override // android.widget.TextView
    public void setRawInputType(int i) {
        super.setRawInputType(i);
        TextInputLayout textInputLayoutB = b();
        if (textInputLayoutB != null) {
            textInputLayoutB.u();
        }
    }

    public void setSimpleItemSelectedColor(int i) {
        this.F = i;
        if (getAdapter() instanceof u) {
            ((u) getAdapter()).a();
        }
    }

    public void setSimpleItemSelectedRippleColor(ColorStateList colorStateList) {
        this.G = colorStateList;
        if (getAdapter() instanceof u) {
            ((u) getAdapter()).a();
        }
    }

    public void setSimpleItems(int i) {
        setSimpleItems(getResources().getStringArray(i));
    }

    @Override // android.widget.AutoCompleteTextView
    public final void showDropDown() {
        if (c()) {
            this.f10131z.d();
        } else {
            super.showDropDown();
        }
    }

    public void setSimpleItems(String[] strArr) {
        setAdapter(new u(this, getContext(), this.C, strArr));
    }
}
