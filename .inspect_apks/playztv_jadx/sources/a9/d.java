package a9;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import h5.f;
import j9.e0;
import j9.f0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import n.q;
import org.xmlpull.v1.XmlPullParserException;
import p8.e;
import p8.j;
import p8.k;
import p8.l;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d extends q {
    public static final int S = k.Widget_MaterialComponents_CompoundButton_CheckBox;
    public static final int[] T = {p8.b.state_indeterminate};
    public static final int[] U;
    public static final int[][] V;
    public static final int W;
    public ColorStateList A;
    public boolean B;
    public boolean C;
    public boolean D;
    public CharSequence E;
    public Drawable F;
    public Drawable G;
    public boolean H;
    public ColorStateList I;
    public ColorStateList J;
    public PorterDuff.Mode K;
    public int L;
    public int[] M;
    public boolean N;
    public CharSequence O;
    public CompoundButton.OnCheckedChangeListener P;
    public final f Q;
    public final a R;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final LinkedHashSet f635y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final LinkedHashSet f636z;

    static {
        int i = p8.b.state_error;
        U = new int[]{i};
        V = new int[][]{new int[]{R.attr.state_enabled, i}, new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
        W = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public d(Context context, AttributeSet attributeSet) throws Throwable {
        f fVar;
        int next;
        int i = p8.b.checkboxStyle;
        super(x9.a.a(context, attributeSet, i, S), attributeSet, i);
        this.f635y = new LinkedHashSet();
        this.f636z = new LinkedHashSet();
        Context context2 = getContext();
        int i10 = e.mtrl_checkbox_button_checked_unchecked;
        if (Build.VERSION.SDK_INT >= 24) {
            fVar = new f(context2, 0);
            Resources resources = context2.getResources();
            Resources.Theme theme = context2.getTheme();
            ThreadLocal threadLocal = h0.k.f5599a;
            Drawable drawable = resources.getDrawable(i10, theme);
            fVar.f5895u = drawable;
            drawable.setCallback(fVar.f5891z);
            new h5.e(0, fVar.f5895u.getConstantState());
        } else {
            int i11 = f.A;
            try {
                XmlResourceParser xml = context2.getResources().getXml(i10);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                Resources resources2 = context2.getResources();
                Resources.Theme theme2 = context2.getTheme();
                f fVar2 = new f(context2, 0);
                fVar2.inflate(resources2, xml, attributeSetAsAttributeSet, theme2);
                fVar = fVar2;
            } catch (IOException e10) {
                Log.e("AnimatedVDCompat", "parser error", e10);
                fVar = null;
            } catch (XmlPullParserException e11) {
                Log.e("AnimatedVDCompat", "parser error", e11);
                fVar = null;
            }
        }
        this.Q = fVar;
        this.R = new a(this);
        Context context3 = getContext();
        this.F = getButtonDrawable();
        this.I = getSuperButtonTintList();
        setSupportButtonTintList(null);
        kc.b bVarE = e0.e(context3, attributeSet, l.MaterialCheckBox, i, S, new int[0]);
        TypedArray typedArray = (TypedArray) bVarE.f7621w;
        this.G = bVarE.s(l.MaterialCheckBox_buttonIcon);
        if (this.F != null && z7.a.z(context3, p8.b.isMaterial3Theme, false)) {
            int resourceId = typedArray.getResourceId(l.MaterialCheckBox_android_button, 0);
            int resourceId2 = typedArray.getResourceId(l.MaterialCheckBox_buttonCompat, 0);
            if (resourceId == W && resourceId2 == 0) {
                super.setButtonDrawable((Drawable) null);
                this.F = com.bumptech.glide.d.p(context3, e.mtrl_checkbox_button);
                this.H = true;
                if (this.G == null) {
                    this.G = com.bumptech.glide.d.p(context3, e.mtrl_checkbox_button_icon);
                }
            }
        }
        this.J = a.a.j(context3, bVarE, l.MaterialCheckBox_buttonIconTint);
        this.K = f0.e(typedArray.getInt(l.MaterialCheckBox_buttonIconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.B = typedArray.getBoolean(l.MaterialCheckBox_useMaterialThemeColors, false);
        this.C = typedArray.getBoolean(l.MaterialCheckBox_centerIfNoTextEnabled, true);
        this.D = typedArray.getBoolean(l.MaterialCheckBox_errorShown, false);
        this.E = typedArray.getText(l.MaterialCheckBox_errorAccessibilityLabel);
        if (typedArray.hasValue(l.MaterialCheckBox_checkedState)) {
            setCheckedState(typedArray.getInt(l.MaterialCheckBox_checkedState, 0));
        }
        bVarE.E();
        a();
    }

    private String getButtonStateDescription() {
        int i = this.L;
        return i == 1 ? getResources().getString(j.mtrl_checkbox_state_description_checked) : i == 0 ? getResources().getString(j.mtrl_checkbox_state_description_unchecked) : getResources().getString(j.mtrl_checkbox_state_description_indeterminate);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.A == null) {
            int iM = z7.a.m(this, p8.b.colorControlActivated);
            int iM2 = z7.a.m(this, p8.b.colorError);
            int iM3 = z7.a.m(this, p8.b.colorSurface);
            int iM4 = z7.a.m(this, p8.b.colorOnSurface);
            this.A = new ColorStateList(V, new int[]{z7.a.r(1.0f, iM3, iM2), z7.a.r(1.0f, iM3, iM), z7.a.r(0.54f, iM3, iM4), z7.a.r(0.38f, iM3, iM4), z7.a.r(0.38f, iM3, iM4)});
        }
        return this.A;
    }

    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.I;
        return colorStateList != null ? colorStateList : super.getButtonTintList() != null ? super.getButtonTintList() : getSupportButtonTintList();
    }

    public final void a() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        g5.l lVar;
        Drawable drawableMutate = this.F;
        ColorStateList colorStateList3 = this.I;
        PorterDuff.Mode buttonTintMode = getButtonTintMode();
        if (drawableMutate == null) {
            drawableMutate = null;
        } else if (colorStateList3 != null) {
            drawableMutate = drawableMutate.mutate();
            if (buttonTintMode != null) {
                drawableMutate.setTintMode(buttonTintMode);
            }
        }
        this.F = drawableMutate;
        Drawable drawableMutate2 = this.G;
        ColorStateList colorStateList4 = this.J;
        PorterDuff.Mode mode = this.K;
        if (drawableMutate2 == null) {
            drawableMutate2 = null;
        } else if (colorStateList4 != null) {
            drawableMutate2 = drawableMutate2.mutate();
            if (mode != null) {
                drawableMutate2.setTintMode(mode);
            }
        }
        this.G = drawableMutate2;
        if (this.H) {
            f fVar = this.Q;
            if (fVar != null) {
                h5.d dVar = fVar.f5887v;
                Drawable drawable = fVar.f5895u;
                a aVar = this.R;
                if (drawable != null) {
                    AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) drawable;
                    if (aVar.f631a == null) {
                        aVar.f631a = new h5.b(aVar);
                    }
                    animatedVectorDrawable.unregisterAnimationCallback(aVar.f631a);
                }
                ArrayList arrayList = fVar.f5890y;
                if (arrayList != null && aVar != null) {
                    arrayList.remove(aVar);
                    if (fVar.f5890y.size() == 0 && (lVar = fVar.f5889x) != null) {
                        dVar.f5882b.removeListener(lVar);
                        fVar.f5889x = null;
                    }
                }
                Drawable drawable2 = fVar.f5895u;
                if (drawable2 != null) {
                    AnimatedVectorDrawable animatedVectorDrawable2 = (AnimatedVectorDrawable) drawable2;
                    if (aVar.f631a == null) {
                        aVar.f631a = new h5.b(aVar);
                    }
                    animatedVectorDrawable2.registerAnimationCallback(aVar.f631a);
                } else if (aVar != null) {
                    if (fVar.f5890y == null) {
                        fVar.f5890y = new ArrayList();
                    }
                    if (!fVar.f5890y.contains(aVar)) {
                        fVar.f5890y.add(aVar);
                        if (fVar.f5889x == null) {
                            fVar.f5889x = new g5.l(1, fVar);
                        }
                        dVar.f5882b.addListener(fVar.f5889x);
                    }
                }
            }
            if (Build.VERSION.SDK_INT >= 24) {
                Drawable drawable3 = this.F;
                if ((drawable3 instanceof AnimatedStateListDrawable) && fVar != null) {
                    ((AnimatedStateListDrawable) drawable3).addTransition(p8.f.checked, p8.f.unchecked, fVar, false);
                    ((AnimatedStateListDrawable) this.F).addTransition(p8.f.indeterminate, p8.f.unchecked, fVar, false);
                }
            }
        }
        Drawable drawable4 = this.F;
        if (drawable4 != null && (colorStateList2 = this.I) != null) {
            drawable4.setTintList(colorStateList2);
        }
        Drawable drawable5 = this.G;
        if (drawable5 != null && (colorStateList = this.J) != null) {
            drawable5.setTintList(colorStateList);
        }
        Drawable drawable6 = this.F;
        Drawable drawable7 = this.G;
        if (drawable6 == null) {
            drawable6 = drawable7;
        } else if (drawable7 != null) {
            int intrinsicWidth = drawable7.getIntrinsicWidth();
            if (intrinsicWidth == -1) {
                intrinsicWidth = drawable6.getIntrinsicWidth();
            }
            int intrinsicHeight = drawable7.getIntrinsicHeight();
            if (intrinsicHeight == -1) {
                intrinsicHeight = drawable6.getIntrinsicHeight();
            }
            if (intrinsicWidth > drawable6.getIntrinsicWidth() || intrinsicHeight > drawable6.getIntrinsicHeight()) {
                float f = intrinsicWidth / intrinsicHeight;
                if (f >= drawable6.getIntrinsicWidth() / drawable6.getIntrinsicHeight()) {
                    int intrinsicWidth2 = drawable6.getIntrinsicWidth();
                    intrinsicHeight = (int) (intrinsicWidth2 / f);
                    intrinsicWidth = intrinsicWidth2;
                } else {
                    intrinsicHeight = drawable6.getIntrinsicHeight();
                    intrinsicWidth = (int) (f * intrinsicHeight);
                }
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable6, drawable7});
            layerDrawable.setLayerSize(1, intrinsicWidth, intrinsicHeight);
            layerDrawable.setLayerGravity(1, 17);
            drawable6 = layerDrawable;
        }
        super.setButtonDrawable(drawable6);
        refreshDrawableState();
    }

    @Override // android.widget.CompoundButton
    public Drawable getButtonDrawable() {
        return this.F;
    }

    public Drawable getButtonIconDrawable() {
        return this.G;
    }

    public ColorStateList getButtonIconTintList() {
        return this.J;
    }

    public PorterDuff.Mode getButtonIconTintMode() {
        return this.K;
    }

    @Override // android.widget.CompoundButton
    public ColorStateList getButtonTintList() {
        return this.I;
    }

    public int getCheckedState() {
        return this.L;
    }

    public CharSequence getErrorAccessibilityLabel() {
        return this.E;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final boolean isChecked() {
        return this.L == 1;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.B && this.I == null && this.J == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrCopyOf;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, T);
        }
        if (this.D) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, U);
        }
        int i10 = 0;
        while (true) {
            if (i10 >= iArrOnCreateDrawableState.length) {
                iArrCopyOf = Arrays.copyOf(iArrOnCreateDrawableState, iArrOnCreateDrawableState.length + 1);
                iArrCopyOf[iArrOnCreateDrawableState.length] = 16842912;
                break;
            }
            int i11 = iArrOnCreateDrawableState[i10];
            if (i11 == 16842912) {
                iArrCopyOf = iArrOnCreateDrawableState;
                break;
            }
            if (i11 == 0) {
                iArrCopyOf = (int[]) iArrOnCreateDrawableState.clone();
                iArrCopyOf[i10] = 16842912;
                break;
            }
            i10++;
        }
        this.M = iArrCopyOf;
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        Drawable buttonDrawable;
        if (!this.C || !TextUtils.isEmpty(getText()) || (buttonDrawable = getButtonDrawable()) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - buttonDrawable.getIntrinsicWidth()) / 2) * (f0.d(this) ? -1 : 1);
        int iSave = canvas.save();
        canvas.translate(width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
        if (getBackground() != null) {
            Rect bounds = buttonDrawable.getBounds();
            getBackground().setHotspotBounds(bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && this.D) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.E));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        setCheckedState(cVar.f634u);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.f634u = getCheckedState();
        return cVar;
    }

    @Override // n.q, android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(com.bumptech.glide.d.p(getContext(), i));
    }

    public void setButtonIconDrawable(Drawable drawable) {
        this.G = drawable;
        a();
    }

    public void setButtonIconDrawableResource(int i) {
        setButtonIconDrawable(com.bumptech.glide.d.p(getContext(), i));
    }

    public void setButtonIconTintList(ColorStateList colorStateList) {
        if (this.J == colorStateList) {
            return;
        }
        this.J = colorStateList;
        a();
    }

    public void setButtonIconTintMode(PorterDuff.Mode mode) {
        if (this.K == mode) {
            return;
        }
        this.K = mode;
        a();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(ColorStateList colorStateList) {
        if (this.I == colorStateList) {
            return;
        }
        this.I = colorStateList;
        a();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        a();
    }

    public void setCenterIfNoTextEnabled(boolean z2) {
        this.C = z2;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z2) {
        setCheckedState(z2 ? 1 : 0);
    }

    public void setCheckedState(int i) {
        AutofillManager autofillManager;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.L != i) {
            this.L = i;
            super.setChecked(i == 1);
            refreshDrawableState();
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30 && this.O == null) {
                super.setStateDescription(getButtonStateDescription());
            }
            if (this.N) {
                return;
            }
            this.N = true;
            LinkedHashSet linkedHashSet = this.f636z;
            if (linkedHashSet != null) {
                Iterator it = linkedHashSet.iterator();
                if (it.hasNext()) {
                    throw l4.a.k(it);
                }
            }
            if (this.L != 2 && (onCheckedChangeListener = this.P) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            if (i10 >= 26 && (autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class)) != null) {
                autofillManager.notifyValueChanged(this);
            }
            this.N = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
    }

    public void setErrorAccessibilityLabel(CharSequence charSequence) {
        this.E = charSequence;
    }

    public void setErrorAccessibilityLabelResource(int i) {
        setErrorAccessibilityLabel(i != 0 ? getResources().getText(i) : null);
    }

    public void setErrorShown(boolean z2) {
        if (this.D == z2) {
            return;
        }
        this.D = z2;
        refreshDrawableState();
        Iterator it = this.f635y.iterator();
        if (it.hasNext()) {
            throw l4.a.k(it);
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.P = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public void setStateDescription(CharSequence charSequence) {
        this.O = charSequence;
        if (charSequence != null) {
            super.setStateDescription(charSequence);
        } else {
            if (Build.VERSION.SDK_INT < 30 || charSequence != null) {
                return;
            }
            super.setStateDescription(getButtonStateDescription());
        }
    }

    public void setUseMaterialThemeColors(boolean z2) {
        this.B = z2;
        if (z2) {
            setButtonTintList(getMaterialThemeColorsTintList());
        } else {
            setButtonTintList(null);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // n.q, android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        this.F = drawable;
        this.H = false;
        a();
    }
}
