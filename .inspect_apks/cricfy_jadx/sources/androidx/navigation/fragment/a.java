package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.navigation.l;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends l implements androidx.navigation.c {
    public String D;

    @Override // androidx.navigation.l
    public final void d(Context context, AttributeSet attributeSet) {
        super.d(context, attributeSet);
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, g.DialogFragmentNavigator);
        String string = typedArrayObtainAttributes.getString(g.DialogFragmentNavigator_android_name);
        if (string != null) {
            this.D = string;
        }
        typedArrayObtainAttributes.recycle();
    }
}
