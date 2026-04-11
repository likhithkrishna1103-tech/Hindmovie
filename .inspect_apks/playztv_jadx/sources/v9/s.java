package v9;

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
import j9.e0;
import java.util.List;
import java.util.Locale;
import n.f2;
import n.l0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s extends n.o {
    public final Rect A;
    public final int B;
    public final float C;
    public ColorStateList D;
    public int E;
    public ColorStateList F;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final f2 f13413y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final AccessibilityManager f13414z;

    /* JADX WARN: Illegal instructions before constructor call */
    public s(Context context, AttributeSet attributeSet) {
        int i = p8.b.autoCompleteTextViewStyle;
        super(x9.a.a(context, attributeSet, i, 0), attributeSet, i);
        this.A = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayD = e0.d(context2, attributeSet, p8.l.MaterialAutoCompleteTextView, i, p8.k.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        if (typedArrayD.hasValue(p8.l.MaterialAutoCompleteTextView_android_inputType) && typedArrayD.getInt(p8.l.MaterialAutoCompleteTextView_android_inputType, 0) == 0) {
            setKeyListener(null);
        }
        this.B = typedArrayD.getResourceId(p8.l.MaterialAutoCompleteTextView_simpleItemLayout, p8.h.mtrl_auto_complete_simple_item);
        this.C = typedArrayD.getDimensionPixelOffset(p8.l.MaterialAutoCompleteTextView_android_popupElevation, p8.d.mtrl_exposed_dropdown_menu_popup_elevation);
        if (typedArrayD.hasValue(p8.l.MaterialAutoCompleteTextView_dropDownBackgroundTint)) {
            this.D = ColorStateList.valueOf(typedArrayD.getColor(p8.l.MaterialAutoCompleteTextView_dropDownBackgroundTint, 0));
        }
        this.E = typedArrayD.getColor(p8.l.MaterialAutoCompleteTextView_simpleItemSelectedColor, 0);
        this.F = a.a.i(context2, typedArrayD, p8.l.MaterialAutoCompleteTextView_simpleItemSelectedRippleColor);
        this.f13414z = (AccessibilityManager) context2.getSystemService("accessibility");
        f2 f2Var = new f2(context2, null, g.a.listPopupWindowStyle, 0);
        this.f13413y = f2Var;
        f2Var.S = true;
        f2Var.T.setFocusable(true);
        f2Var.I = this;
        f2Var.T.setInputMethodMode(2);
        f2Var.o(getAdapter());
        f2Var.J = new l0(2, this);
        if (typedArrayD.hasValue(p8.l.MaterialAutoCompleteTextView_simpleItems)) {
            setSimpleItems(typedArrayD.getResourceId(p8.l.MaterialAutoCompleteTextView_simpleItems, 0));
        }
        typedArrayD.recycle();
    }

    public static void a(s sVar, Object obj) {
        sVar.setText(sVar.convertSelectionToString(obj), false);
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
        AccessibilityManager accessibilityManager = this.f13414z;
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
            this.f13413y.dismiss();
        } else {
            super.dismissDropDown();
        }
    }

    public ColorStateList getDropDownBackgroundTintList() {
        return this.D;
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout textInputLayoutB = b();
        return (textInputLayoutB == null || !textInputLayoutB.f3501b0) ? super.getHint() : textInputLayoutB.getHint();
    }

    public float getPopupElevation() {
        return this.C;
    }

    public int getSimpleItemSelectedColor() {
        return this.E;
    }

    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.F;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayoutB = b();
        if (textInputLayoutB != null && textInputLayoutB.f3501b0 && super.getHint() == null) {
            String str = Build.MANUFACTURER;
            if ((str != null ? str.toLowerCase(Locale.ENGLISH) : "").equals("meizu")) {
                setHint("");
            }
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f13413y.dismiss();
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
                f2 f2Var = this.f13413y;
                int iMin = Math.min(adapter.getCount(), Math.max(0, !f2Var.T.isShowing() ? -1 : f2Var.f8383w.getSelectedItemPosition()) + 15);
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
                Drawable background = f2Var.T.getBackground();
                if (background != null) {
                    Rect rect = this.A;
                    background.getPadding(rect);
                    iMax += rect.left + rect.right;
                }
                measuredWidth2 = textInputLayoutB.getEndIconView().getMeasuredWidth() + iMax;
            }
            setMeasuredDimension(Math.min(Math.max(measuredWidth, measuredWidth2), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean z2) {
        if (c()) {
            return;
        }
        super.onWindowFocusChanged(z2);
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t10) {
        super.setAdapter(t10);
        this.f13413y.o(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundDrawable(Drawable drawable) {
        super.setDropDownBackgroundDrawable(drawable);
        f2 f2Var = this.f13413y;
        if (f2Var != null) {
            f2Var.g(drawable);
        }
    }

    public void setDropDownBackgroundTint(int i) {
        setDropDownBackgroundTintList(ColorStateList.valueOf(i));
    }

    public void setDropDownBackgroundTintList(ColorStateList colorStateList) {
        this.D = colorStateList;
        Drawable dropDownBackground = getDropDownBackground();
        if (dropDownBackground instanceof q9.g) {
            ((q9.g) dropDownBackground).l(this.D);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super.setOnItemSelectedListener(onItemSelectedListener);
        this.f13413y.K = getOnItemSelectedListener();
    }

    @Override // android.widget.TextView
    public void setRawInputType(int i) {
        super.setRawInputType(i);
        TextInputLayout textInputLayoutB = b();
        if (textInputLayoutB != null) {
            textInputLayoutB.s();
        }
    }

    public void setSimpleItemSelectedColor(int i) {
        this.E = i;
        if (getAdapter() instanceof r) {
            ((r) getAdapter()).a();
        }
    }

    public void setSimpleItemSelectedRippleColor(ColorStateList colorStateList) {
        this.F = colorStateList;
        if (getAdapter() instanceof r) {
            ((r) getAdapter()).a();
        }
    }

    public void setSimpleItems(int i) {
        setSimpleItems(getResources().getStringArray(i));
    }

    @Override // android.widget.AutoCompleteTextView
    public final void showDropDown() {
        if (c()) {
            this.f13413y.d();
        } else {
            super.showDropDown();
        }
    }

    public void setSimpleItems(String[] strArr) {
        setAdapter(new r(this, getContext(), this.B, strArr));
    }
}
