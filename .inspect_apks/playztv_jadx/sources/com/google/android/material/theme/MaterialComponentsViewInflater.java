package com.google.android.material.theme;

import a9.d;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import com.google.android.material.button.MaterialButton;
import h.f0;
import j9.e0;
import m9.a;
import n.c0;
import n.d1;
import n.o;
import n.q;
import p8.b;
import p8.l;
import v9.s;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class MaterialComponentsViewInflater extends f0 {
    @Override // h.f0
    public final o a(Context context, AttributeSet attributeSet) {
        return new s(context, attributeSet);
    }

    @Override // h.f0
    public final AppCompatButton b(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    @Override // h.f0
    public final q c(Context context, AttributeSet attributeSet) {
        return new d(context, attributeSet);
    }

    @Override // h.f0
    public final c0 d(Context context, AttributeSet attributeSet) {
        int i = b.radioButtonStyle;
        int i10 = a.A;
        a aVar = new a(x9.a.a(context, attributeSet, i, i10), attributeSet, i);
        Context context2 = aVar.getContext();
        TypedArray typedArrayD = e0.d(context2, attributeSet, l.MaterialRadioButton, i, i10, new int[0]);
        if (typedArrayD.hasValue(l.MaterialRadioButton_buttonTint)) {
            aVar.setButtonTintList(a.a.i(context2, typedArrayD, l.MaterialRadioButton_buttonTint));
        }
        aVar.f8312z = typedArrayD.getBoolean(l.MaterialRadioButton_useMaterialThemeColors, false);
        typedArrayD.recycle();
        return aVar;
    }

    @Override // h.f0
    public final d1 e(Context context, AttributeSet attributeSet) {
        w9.a aVar = new w9.a(x9.a.a(context, attributeSet, R.attr.textViewStyle, 0), attributeSet, R.attr.textViewStyle);
        Context context2 = aVar.getContext();
        if (z7.a.z(context2, b.textAppearanceLineHeightEnabled, true)) {
            Resources.Theme theme = context2.getTheme();
            TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, l.MaterialTextView, R.attr.textViewStyle, 0);
            int iG = w9.a.g(context2, typedArrayObtainStyledAttributes, l.MaterialTextView_android_lineHeight, l.MaterialTextView_lineHeight);
            typedArrayObtainStyledAttributes.recycle();
            if (iG == -1) {
                TypedArray typedArrayObtainStyledAttributes2 = theme.obtainStyledAttributes(attributeSet, l.MaterialTextView, R.attr.textViewStyle, 0);
                int resourceId = typedArrayObtainStyledAttributes2.getResourceId(l.MaterialTextView_android_textAppearance, -1);
                typedArrayObtainStyledAttributes2.recycle();
                if (resourceId != -1) {
                    TypedArray typedArrayObtainStyledAttributes3 = theme.obtainStyledAttributes(resourceId, l.MaterialTextAppearance);
                    int iG2 = w9.a.g(aVar.getContext(), typedArrayObtainStyledAttributes3, l.MaterialTextAppearance_android_lineHeight, l.MaterialTextAppearance_lineHeight);
                    typedArrayObtainStyledAttributes3.recycle();
                    if (iG2 >= 0) {
                        aVar.setLineHeight(iG2);
                    }
                }
            }
        }
        return aVar;
    }
}
