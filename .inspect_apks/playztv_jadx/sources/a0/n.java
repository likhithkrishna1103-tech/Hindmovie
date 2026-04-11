package a0;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final SparseIntArray f133n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f138e;
    public float f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f139g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f140h;
    public float i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f141j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f142k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f143l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f144m;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f133n = sparseIntArray;
        sparseIntArray.append(s.Transform_android_rotation, 1);
        sparseIntArray.append(s.Transform_android_rotationX, 2);
        sparseIntArray.append(s.Transform_android_rotationY, 3);
        sparseIntArray.append(s.Transform_android_scaleX, 4);
        sparseIntArray.append(s.Transform_android_scaleY, 5);
        sparseIntArray.append(s.Transform_android_transformPivotX, 6);
        sparseIntArray.append(s.Transform_android_transformPivotY, 7);
        sparseIntArray.append(s.Transform_android_translationX, 8);
        sparseIntArray.append(s.Transform_android_translationY, 9);
        sparseIntArray.append(s.Transform_android_translationZ, 10);
        sparseIntArray.append(s.Transform_android_elevation, 11);
        sparseIntArray.append(s.Transform_transformPivotTarget, 12);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.Transform);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            switch (f133n.get(index)) {
                case 1:
                    this.f134a = typedArrayObtainStyledAttributes.getFloat(index, this.f134a);
                    break;
                case 2:
                    this.f135b = typedArrayObtainStyledAttributes.getFloat(index, this.f135b);
                    break;
                case 3:
                    this.f136c = typedArrayObtainStyledAttributes.getFloat(index, this.f136c);
                    break;
                case b1.j.LONG_FIELD_NUMBER /* 4 */:
                    this.f137d = typedArrayObtainStyledAttributes.getFloat(index, this.f137d);
                    break;
                case b1.j.STRING_FIELD_NUMBER /* 5 */:
                    this.f138e = typedArrayObtainStyledAttributes.getFloat(index, this.f138e);
                    break;
                case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                    this.f = typedArrayObtainStyledAttributes.getDimension(index, this.f);
                    break;
                case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                    this.f139g = typedArrayObtainStyledAttributes.getDimension(index, this.f139g);
                    break;
                case 8:
                    this.i = typedArrayObtainStyledAttributes.getDimension(index, this.i);
                    break;
                case 9:
                    this.f141j = typedArrayObtainStyledAttributes.getDimension(index, this.f141j);
                    break;
                case 10:
                    this.f142k = typedArrayObtainStyledAttributes.getDimension(index, this.f142k);
                    break;
                case 11:
                    this.f143l = true;
                    this.f144m = typedArrayObtainStyledAttributes.getDimension(index, this.f144m);
                    break;
                case 12:
                    this.f140h = o.f(typedArrayObtainStyledAttributes, index, this.f140h);
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
