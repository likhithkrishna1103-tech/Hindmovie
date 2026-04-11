package a0;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f132d;

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.PropertySet);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == s.PropertySet_android_alpha) {
                this.f131c = typedArrayObtainStyledAttributes.getFloat(index, this.f131c);
            } else if (index == s.PropertySet_android_visibility) {
                int i10 = typedArrayObtainStyledAttributes.getInt(index, this.f129a);
                this.f129a = i10;
                this.f129a = o.f145d[i10];
            } else if (index == s.PropertySet_visibilityMode) {
                this.f130b = typedArrayObtainStyledAttributes.getInt(index, this.f130b);
            } else if (index == s.PropertySet_motionProgress) {
                this.f132d = typedArrayObtainStyledAttributes.getFloat(index, this.f132d);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
