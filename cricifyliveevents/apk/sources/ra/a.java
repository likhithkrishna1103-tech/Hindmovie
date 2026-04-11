package ra;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import k9.b;
import m.c;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f10918a = {R.attr.theme, g.a.theme};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f10919b = {b.materialThemeOverlay};

    public static Context a(Context context, AttributeSet attributeSet, int i, int i10) {
        return b(context, attributeSet, i, i10, new int[0]);
    }

    public static Context b(Context context, AttributeSet attributeSet, int i, int i10, int[] iArr) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f10919b, i, i10);
        int[] iArr2 = {typedArrayObtainStyledAttributes.getResourceId(0, 0)};
        typedArrayObtainStyledAttributes.recycle();
        int i11 = iArr2[0];
        boolean z10 = (context instanceof c) && ((c) context).f7968a == i11;
        if (i11 == 0 || z10) {
            return context;
        }
        c cVar = new c(context, i11);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        if (iArr.length > 0) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i, i10);
            for (int i12 = 0; i12 < iArr.length; i12++) {
                iArr3[i12] = typedArrayObtainStyledAttributes2.getResourceId(i12, 0);
            }
            typedArrayObtainStyledAttributes2.recycle();
        }
        for (int i13 = 0; i13 < length; i13++) {
            int i14 = iArr3[i13];
            if (i14 != 0) {
                cVar.getTheme().applyStyle(i14, true);
            }
        }
        TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f10918a);
        int resourceId = typedArrayObtainStyledAttributes3.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes3.getResourceId(1, 0);
        typedArrayObtainStyledAttributes3.recycle();
        if (resourceId == 0) {
            resourceId = resourceId2;
        }
        if (resourceId != 0) {
            cVar.getTheme().applyStyle(resourceId, true);
        }
        return cVar;
    }
}
