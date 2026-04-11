package qa;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.media.session.b;
import android.util.TypedValue;
import k9.l;
import o.a1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends a1 {
    public static int g(Context context, TypedArray typedArray, int... iArr) {
        int dimensionPixelSize = -1;
        for (int i = 0; i < iArr.length && dimensionPixelSize < 0; i++) {
            int i10 = iArr[i];
            TypedValue typedValue = new TypedValue();
            if (typedArray.getValue(i10, typedValue) && typedValue.type == 2) {
                TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
                int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
                typedArrayObtainStyledAttributes.recycle();
                dimensionPixelSize = dimensionPixelSize2;
            } else {
                dimensionPixelSize = typedArray.getDimensionPixelSize(i10, -1);
            }
        }
        return dimensionPixelSize;
    }

    @Override // o.a1, android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (b.H(context, k9.b.textAppearanceLineHeightEnabled, true)) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(i, l.MaterialTextAppearance);
            int iG = g(getContext(), typedArrayObtainStyledAttributes, l.MaterialTextAppearance_android_lineHeight, l.MaterialTextAppearance_lineHeight);
            typedArrayObtainStyledAttributes.recycle();
            if (iG >= 0) {
                setLineHeight(iG);
            }
        }
    }
}
