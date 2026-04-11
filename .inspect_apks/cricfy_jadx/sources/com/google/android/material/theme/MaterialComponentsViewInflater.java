package com.google.android.material.theme;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.media.session.b;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import com.google.android.material.button.MaterialButton;
import da.d0;
import g.a;
import h.e0;
import k9.l;
import o.a0;
import o.a1;
import o.o;
import o.p;
import pa.v;
import u9.c;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class MaterialComponentsViewInflater extends e0 {
    @Override // h.e0
    public final o a(Context context, AttributeSet attributeSet) {
        return new v(context, attributeSet);
    }

    @Override // h.e0
    public final AppCompatButton b(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    @Override // h.e0
    public final p c(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // h.e0
    public final a0 d(Context context, AttributeSet attributeSet) {
        int i = a.radioButtonStyle;
        int i10 = ga.a.B;
        ga.a aVar = new ga.a(ra.a.a(context, attributeSet, i, i10), attributeSet, i);
        Context context2 = aVar.getContext();
        TypedArray typedArrayD = d0.d(context2, attributeSet, l.MaterialRadioButton, i, i10, new int[0]);
        if (typedArrayD.hasValue(l.MaterialRadioButton_buttonTint)) {
            aVar.setButtonTintList(com.bumptech.glide.c.i(context2, typedArrayD, l.MaterialRadioButton_buttonTint));
        }
        aVar.A = typedArrayD.getBoolean(l.MaterialRadioButton_useMaterialThemeColors, false);
        typedArrayD.recycle();
        return aVar;
    }

    @Override // h.e0
    public final a1 e(Context context, AttributeSet attributeSet) {
        qa.a aVar = new qa.a(ra.a.a(context, attributeSet, R.attr.textViewStyle, 0), attributeSet, R.attr.textViewStyle);
        Context context2 = aVar.getContext();
        if (b.H(context2, k9.b.textAppearanceLineHeightEnabled, true)) {
            Resources.Theme theme = context2.getTheme();
            TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, l.MaterialTextView, R.attr.textViewStyle, 0);
            int iG = qa.a.g(context2, typedArrayObtainStyledAttributes, l.MaterialTextView_android_lineHeight, l.MaterialTextView_lineHeight);
            typedArrayObtainStyledAttributes.recycle();
            if (iG == -1) {
                TypedArray typedArrayObtainStyledAttributes2 = theme.obtainStyledAttributes(attributeSet, l.MaterialTextView, R.attr.textViewStyle, 0);
                int resourceId = typedArrayObtainStyledAttributes2.getResourceId(l.MaterialTextView_android_textAppearance, -1);
                typedArrayObtainStyledAttributes2.recycle();
                if (resourceId != -1) {
                    TypedArray typedArrayObtainStyledAttributes3 = theme.obtainStyledAttributes(resourceId, l.MaterialTextAppearance);
                    int iG2 = qa.a.g(aVar.getContext(), typedArrayObtainStyledAttributes3, l.MaterialTextAppearance_android_lineHeight, l.MaterialTextAppearance_lineHeight);
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
