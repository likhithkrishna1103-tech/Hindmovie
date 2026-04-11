package d0;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final SparseIntArray f3174j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f3178d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f3179e;
    public float f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3180g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f3181h;
    public int i;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f3174j = sparseIntArray;
        sparseIntArray.append(r.Motion_motionPathRotate, 1);
        sparseIntArray.append(r.Motion_pathMotionArc, 2);
        sparseIntArray.append(r.Motion_transitionEasing, 3);
        sparseIntArray.append(r.Motion_drawPath, 4);
        sparseIntArray.append(r.Motion_animateRelativeTo, 5);
        sparseIntArray.append(r.Motion_animateCircleAngleTo, 6);
        sparseIntArray.append(r.Motion_motionStagger, 7);
        sparseIntArray.append(r.Motion_quantizeMotionSteps, 8);
        sparseIntArray.append(r.Motion_quantizeMotionPhase, 9);
        sparseIntArray.append(r.Motion_quantizeMotionInterpolator, 10);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.Motion);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            switch (f3174j.get(index)) {
                case 1:
                    this.f3179e = typedArrayObtainStyledAttributes.getFloat(index, this.f3179e);
                    break;
                case 2:
                    this.f3177c = typedArrayObtainStyledAttributes.getInt(index, this.f3177c);
                    break;
                case 3:
                    if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                        typedArrayObtainStyledAttributes.getString(index);
                    } else {
                        String str = z.a.f15057a[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                    }
                    break;
                case g1.h.LONG_FIELD_NUMBER /* 4 */:
                    typedArrayObtainStyledAttributes.getInt(index, 0);
                    break;
                case g1.h.STRING_FIELD_NUMBER /* 5 */:
                    this.f3175a = n.f(typedArrayObtainStyledAttributes, index, this.f3175a);
                    break;
                case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                    this.f3176b = typedArrayObtainStyledAttributes.getInteger(index, this.f3176b);
                    break;
                case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                    this.f3178d = typedArrayObtainStyledAttributes.getFloat(index, this.f3178d);
                    break;
                case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                    this.f3180g = typedArrayObtainStyledAttributes.getInteger(index, this.f3180g);
                    break;
                case 9:
                    this.f = typedArrayObtainStyledAttributes.getFloat(index, this.f);
                    break;
                case 10:
                    int i10 = typedArrayObtainStyledAttributes.peekValue(index).type;
                    if (i10 == 1) {
                        this.i = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                    } else if (i10 == 3) {
                        String string = typedArrayObtainStyledAttributes.getString(index);
                        this.f3181h = string;
                        if (string.indexOf("/") > 0) {
                            this.i = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                        }
                    } else {
                        typedArrayObtainStyledAttributes.getInteger(index, this.i);
                    }
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
