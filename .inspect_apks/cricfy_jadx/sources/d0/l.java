package d0;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f3184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f3185d;

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.PropertySet);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == r.PropertySet_android_alpha) {
                this.f3184c = typedArrayObtainStyledAttributes.getFloat(index, this.f3184c);
            } else if (index == r.PropertySet_android_visibility) {
                int i10 = typedArrayObtainStyledAttributes.getInt(index, this.f3182a);
                this.f3182a = i10;
                this.f3182a = n.f3198d[i10];
            } else if (index == r.PropertySet_visibilityMode) {
                this.f3183b = typedArrayObtainStyledAttributes.getInt(index, this.f3183b);
            } else if (index == r.PropertySet_motionProgress) {
                this.f3185d = typedArrayObtainStyledAttributes.getFloat(index, this.f3185d);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
