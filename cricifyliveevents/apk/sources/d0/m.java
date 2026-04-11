package d0;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final SparseIntArray f3186n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f3187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f3188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f3189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f3190d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f3191e;
    public float f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f3192g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3193h;
    public float i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f3194j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f3195k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f3196l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f3197m;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f3186n = sparseIntArray;
        sparseIntArray.append(r.Transform_android_rotation, 1);
        sparseIntArray.append(r.Transform_android_rotationX, 2);
        sparseIntArray.append(r.Transform_android_rotationY, 3);
        sparseIntArray.append(r.Transform_android_scaleX, 4);
        sparseIntArray.append(r.Transform_android_scaleY, 5);
        sparseIntArray.append(r.Transform_android_transformPivotX, 6);
        sparseIntArray.append(r.Transform_android_transformPivotY, 7);
        sparseIntArray.append(r.Transform_android_translationX, 8);
        sparseIntArray.append(r.Transform_android_translationY, 9);
        sparseIntArray.append(r.Transform_android_translationZ, 10);
        sparseIntArray.append(r.Transform_android_elevation, 11);
        sparseIntArray.append(r.Transform_transformPivotTarget, 12);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.Transform);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            switch (f3186n.get(index)) {
                case 1:
                    this.f3187a = typedArrayObtainStyledAttributes.getFloat(index, this.f3187a);
                    break;
                case 2:
                    this.f3188b = typedArrayObtainStyledAttributes.getFloat(index, this.f3188b);
                    break;
                case 3:
                    this.f3189c = typedArrayObtainStyledAttributes.getFloat(index, this.f3189c);
                    break;
                case g1.h.LONG_FIELD_NUMBER /* 4 */:
                    this.f3190d = typedArrayObtainStyledAttributes.getFloat(index, this.f3190d);
                    break;
                case g1.h.STRING_FIELD_NUMBER /* 5 */:
                    this.f3191e = typedArrayObtainStyledAttributes.getFloat(index, this.f3191e);
                    break;
                case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                    this.f = typedArrayObtainStyledAttributes.getDimension(index, this.f);
                    break;
                case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                    this.f3192g = typedArrayObtainStyledAttributes.getDimension(index, this.f3192g);
                    break;
                case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                    this.i = typedArrayObtainStyledAttributes.getDimension(index, this.i);
                    break;
                case 9:
                    this.f3194j = typedArrayObtainStyledAttributes.getDimension(index, this.f3194j);
                    break;
                case 10:
                    this.f3195k = typedArrayObtainStyledAttributes.getDimension(index, this.f3195k);
                    break;
                case 11:
                    this.f3196l = true;
                    this.f3197m = typedArrayObtainStyledAttributes.getDimension(index, this.f3197m);
                    break;
                case 12:
                    this.f3193h = n.f(typedArrayObtainStyledAttributes, index, this.f3193h);
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
