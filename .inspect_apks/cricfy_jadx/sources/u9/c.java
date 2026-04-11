package u9;

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
import com.bumptech.glide.f;
import com.google.android.gms.internal.measurement.j4;
import da.d0;
import da.e0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import k9.e;
import k9.j;
import k9.k;
import k9.l;
import m5.d;
import o.p;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends p {
    public static final int T = k.Widget_MaterialComponents_CompoundButton_CheckBox;
    public static final int[] U = {k9.b.state_indeterminate};
    public static final int[] V;
    public static final int[][] W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final int f12294a0;
    public final LinkedHashSet A;
    public ColorStateList B;
    public boolean C;
    public boolean D;
    public boolean E;
    public CharSequence F;
    public Drawable G;
    public Drawable H;
    public boolean I;
    public ColorStateList J;
    public ColorStateList K;
    public PorterDuff.Mode L;
    public int M;
    public int[] N;
    public boolean O;
    public CharSequence P;
    public CompoundButton.OnCheckedChangeListener Q;
    public final d R;
    public final a S;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final LinkedHashSet f12295z;

    static {
        int i = k9.b.state_error;
        V = new int[]{i};
        W = new int[][]{new int[]{R.attr.state_enabled, i}, new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
        f12294a0 = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public c(Context context, AttributeSet attributeSet) throws Throwable {
        d dVar;
        int next;
        int i = g.a.checkboxStyle;
        super(ra.a.a(context, attributeSet, i, T), attributeSet, i);
        this.f12295z = new LinkedHashSet();
        this.A = new LinkedHashSet();
        Context context2 = getContext();
        int i10 = e.mtrl_checkbox_button_checked_unchecked;
        if (Build.VERSION.SDK_INT >= 24) {
            dVar = new d(context2, 0);
            Resources resources = context2.getResources();
            Resources.Theme theme = context2.getTheme();
            ThreadLocal threadLocal = k0.k.f6774a;
            Drawable drawable = resources.getDrawable(i10, theme);
            dVar.f8321v = drawable;
            drawable.setCallback(dVar.A);
            new ba.a(2, dVar.f8321v.getConstantState());
        } else {
            int i11 = d.B;
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
                d dVar2 = new d(context2, 0);
                dVar2.inflate(resources2, xml, attributeSetAsAttributeSet, theme2);
                dVar = dVar2;
            } catch (IOException e9) {
                Log.e("AnimatedVDCompat", "parser error", e9);
                dVar = null;
            } catch (XmlPullParserException e10) {
                Log.e("AnimatedVDCompat", "parser error", e10);
                dVar = null;
            }
        }
        this.R = dVar;
        this.S = new a(this);
        Context context3 = getContext();
        this.G = getButtonDrawable();
        this.J = getSuperButtonTintList();
        setSupportButtonTintList(null);
        int[] iArr = l.MaterialCheckBox;
        int i12 = T;
        d0.a(context3, attributeSet, i, i12);
        d0.b(context3, attributeSet, iArr, i, i12, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context3.obtainStyledAttributes(attributeSet, iArr, i, i12);
        l7.a aVar = new l7.a(context3, typedArrayObtainStyledAttributes);
        this.H = aVar.u(l.MaterialCheckBox_buttonIcon);
        if (this.G != null && android.support.v4.media.session.b.H(context3, k9.b.isMaterial3Theme, false)) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(l.MaterialCheckBox_android_button, 0);
            int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(l.MaterialCheckBox_buttonCompat, 0);
            if (resourceId == f12294a0 && resourceId2 == 0) {
                super.setButtonDrawable((Drawable) null);
                this.G = j4.i(context3, e.mtrl_checkbox_button);
                this.I = true;
                if (this.H == null) {
                    this.H = j4.i(context3, e.mtrl_checkbox_button_icon);
                }
            }
        }
        this.K = com.bumptech.glide.c.j(context3, aVar, l.MaterialCheckBox_buttonIconTint);
        this.L = e0.c(typedArrayObtainStyledAttributes.getInt(l.MaterialCheckBox_buttonIconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.C = typedArrayObtainStyledAttributes.getBoolean(l.MaterialCheckBox_useMaterialThemeColors, false);
        this.D = typedArrayObtainStyledAttributes.getBoolean(l.MaterialCheckBox_centerIfNoTextEnabled, true);
        this.E = typedArrayObtainStyledAttributes.getBoolean(l.MaterialCheckBox_errorShown, false);
        this.F = typedArrayObtainStyledAttributes.getText(l.MaterialCheckBox_errorAccessibilityLabel);
        if (typedArrayObtainStyledAttributes.hasValue(l.MaterialCheckBox_checkedState)) {
            setCheckedState(typedArrayObtainStyledAttributes.getInt(l.MaterialCheckBox_checkedState, 0));
        }
        aVar.G();
        a();
    }

    private String getButtonStateDescription() {
        int i = this.M;
        return i == 1 ? getResources().getString(j.mtrl_checkbox_state_description_checked) : i == 0 ? getResources().getString(j.mtrl_checkbox_state_description_unchecked) : getResources().getString(j.mtrl_checkbox_state_description_indeterminate);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.B == null) {
            int iN = f.n(this, g.a.colorControlActivated);
            int iN2 = f.n(this, g.a.colorError);
            int iN3 = f.n(this, k9.b.colorSurface);
            int iN4 = f.n(this, k9.b.colorOnSurface);
            this.B = new ColorStateList(W, new int[]{f.D(1.0f, iN3, iN2), f.D(1.0f, iN3, iN), f.D(0.54f, iN3, iN4), f.D(0.38f, iN3, iN4), f.D(0.38f, iN3, iN4)});
        }
        return this.B;
    }

    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.J;
        return colorStateList != null ? colorStateList : super.getButtonTintList() != null ? super.getButtonTintList() : getSupportButtonTintList();
    }

    public final void a() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ba.f fVar;
        Drawable drawableMutate = this.G;
        ColorStateList colorStateList3 = this.J;
        PorterDuff.Mode buttonTintMode = getButtonTintMode();
        if (drawableMutate == null) {
            drawableMutate = null;
        } else if (colorStateList3 != null) {
            drawableMutate = drawableMutate.mutate();
            if (buttonTintMode != null) {
                drawableMutate.setTintMode(buttonTintMode);
            }
        }
        this.G = drawableMutate;
        Drawable drawableMutate2 = this.H;
        ColorStateList colorStateList4 = this.K;
        PorterDuff.Mode mode = this.L;
        if (drawableMutate2 == null) {
            drawableMutate2 = null;
        } else if (colorStateList4 != null) {
            drawableMutate2 = drawableMutate2.mutate();
            if (mode != null) {
                drawableMutate2.setTintMode(mode);
            }
        }
        this.H = drawableMutate2;
        if (this.I) {
            d dVar = this.R;
            if (dVar != null) {
                m5.c cVar = dVar.f8316w;
                Drawable drawable = dVar.f8321v;
                a aVar = this.S;
                if (drawable != null) {
                    AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) drawable;
                    if (aVar.f12291a == null) {
                        aVar.f12291a = new m5.b(aVar);
                    }
                    animatedVectorDrawable.unregisterAnimationCallback(aVar.f12291a);
                }
                ArrayList arrayList = dVar.f8319z;
                if (arrayList != null && aVar != null) {
                    arrayList.remove(aVar);
                    if (dVar.f8319z.size() == 0 && (fVar = dVar.f8318y) != null) {
                        cVar.f8313b.removeListener(fVar);
                        dVar.f8318y = null;
                    }
                }
                Drawable drawable2 = dVar.f8321v;
                if (drawable2 != null) {
                    AnimatedVectorDrawable animatedVectorDrawable2 = (AnimatedVectorDrawable) drawable2;
                    if (aVar.f12291a == null) {
                        aVar.f12291a = new m5.b(aVar);
                    }
                    animatedVectorDrawable2.registerAnimationCallback(aVar.f12291a);
                } else if (aVar != null) {
                    if (dVar.f8319z == null) {
                        dVar.f8319z = new ArrayList();
                    }
                    if (!dVar.f8319z.contains(aVar)) {
                        dVar.f8319z.add(aVar);
                        if (dVar.f8318y == null) {
                            dVar.f8318y = new ba.f(4, dVar);
                        }
                        cVar.f8313b.addListener(dVar.f8318y);
                    }
                }
            }
            if (Build.VERSION.SDK_INT >= 24) {
                Drawable drawable3 = this.G;
                if ((drawable3 instanceof AnimatedStateListDrawable) && dVar != null) {
                    ((AnimatedStateListDrawable) drawable3).addTransition(k9.f.checked, k9.f.unchecked, dVar, false);
                    ((AnimatedStateListDrawable) this.G).addTransition(k9.f.indeterminate, k9.f.unchecked, dVar, false);
                }
            }
        }
        Drawable drawable4 = this.G;
        if (drawable4 != null && (colorStateList2 = this.J) != null) {
            drawable4.setTintList(colorStateList2);
        }
        Drawable drawable5 = this.H;
        if (drawable5 != null && (colorStateList = this.K) != null) {
            drawable5.setTintList(colorStateList);
        }
        Drawable drawable6 = this.G;
        Drawable drawable7 = this.H;
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
        return this.G;
    }

    public Drawable getButtonIconDrawable() {
        return this.H;
    }

    public ColorStateList getButtonIconTintList() {
        return this.K;
    }

    public PorterDuff.Mode getButtonIconTintMode() {
        return this.L;
    }

    @Override // android.widget.CompoundButton
    public ColorStateList getButtonTintList() {
        return this.J;
    }

    public int getCheckedState() {
        return this.M;
    }

    public CharSequence getErrorAccessibilityLabel() {
        return this.F;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final boolean isChecked() {
        return this.M == 1;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.C && this.J == null && this.K == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrCopyOf;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, U);
        }
        if (this.E) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, V);
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
        this.N = iArrCopyOf;
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        Drawable buttonDrawable;
        if (!this.D || !TextUtils.isEmpty(getText()) || (buttonDrawable = getButtonDrawable()) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - buttonDrawable.getIntrinsicWidth()) / 2) * (getLayoutDirection() == 1 ? -1 : 1);
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
        if (accessibilityNodeInfo != null && this.E) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.F));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        setCheckedState(bVar.f12293v);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f12293v = getCheckedState();
        return bVar;
    }

    @Override // o.p, android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(j4.i(getContext(), i));
    }

    public void setButtonIconDrawable(Drawable drawable) {
        this.H = drawable;
        a();
    }

    public void setButtonIconDrawableResource(int i) {
        setButtonIconDrawable(j4.i(getContext(), i));
    }

    public void setButtonIconTintList(ColorStateList colorStateList) {
        if (this.K == colorStateList) {
            return;
        }
        this.K = colorStateList;
        a();
    }

    public void setButtonIconTintMode(PorterDuff.Mode mode) {
        if (this.L == mode) {
            return;
        }
        this.L = mode;
        a();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(ColorStateList colorStateList) {
        if (this.J == colorStateList) {
            return;
        }
        this.J = colorStateList;
        a();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        a();
    }

    public void setCenterIfNoTextEnabled(boolean z10) {
        this.D = z10;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        setCheckedState(z10 ? 1 : 0);
    }

    public void setCheckedState(int i) {
        AutofillManager autofillManager;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.M != i) {
            this.M = i;
            super.setChecked(i == 1);
            refreshDrawableState();
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30 && this.P == null) {
                super.setStateDescription(getButtonStateDescription());
            }
            if (this.O) {
                return;
            }
            this.O = true;
            LinkedHashSet linkedHashSet = this.A;
            if (linkedHashSet != null) {
                Iterator it = linkedHashSet.iterator();
                if (it.hasNext()) {
                    throw q4.a.l(it);
                }
            }
            if (this.M != 2 && (onCheckedChangeListener = this.Q) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            if (i10 >= 26 && (autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class)) != null) {
                autofillManager.notifyValueChanged(this);
            }
            this.O = false;
        }
    }

    public void setErrorAccessibilityLabel(CharSequence charSequence) {
        this.F = charSequence;
    }

    public void setErrorAccessibilityLabelResource(int i) {
        setErrorAccessibilityLabel(i != 0 ? getResources().getText(i) : null);
    }

    public void setErrorShown(boolean z10) {
        if (this.E == z10) {
            return;
        }
        this.E = z10;
        refreshDrawableState();
        Iterator it = this.f12295z.iterator();
        if (it.hasNext()) {
            throw q4.a.l(it);
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.Q = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public void setStateDescription(CharSequence charSequence) {
        this.P = charSequence;
        if (charSequence != null) {
            super.setStateDescription(charSequence);
        } else {
            if (Build.VERSION.SDK_INT < 30 || charSequence != null) {
                return;
            }
            super.setStateDescription(getButtonStateDescription());
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.C = z10;
        if (z10) {
            setButtonTintList(getMaterialThemeColorsTintList());
        } else {
            setButtonTintList(null);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // o.p, android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        this.G = drawable;
        this.I = false;
        a();
    }
}
