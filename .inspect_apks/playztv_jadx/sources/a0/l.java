package a0;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final SparseIntArray f121j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f125d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f126e;
    public float f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f127g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f128h;
    public int i;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f121j = sparseIntArray;
        sparseIntArray.append(s.Motion_motionPathRotate, 1);
        sparseIntArray.append(s.Motion_pathMotionArc, 2);
        sparseIntArray.append(s.Motion_transitionEasing, 3);
        sparseIntArray.append(s.Motion_drawPath, 4);
        sparseIntArray.append(s.Motion_animateRelativeTo, 5);
        sparseIntArray.append(s.Motion_animateCircleAngleTo, 6);
        sparseIntArray.append(s.Motion_motionStagger, 7);
        sparseIntArray.append(s.Motion_quantizeMotionSteps, 8);
        sparseIntArray.append(s.Motion_quantizeMotionPhase, 9);
        sparseIntArray.append(s.Motion_quantizeMotionInterpolator, 10);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.Motion);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            switch (f121j.get(index)) {
                case 1:
                    this.f126e = typedArrayObtainStyledAttributes.getFloat(index, this.f126e);
                    break;
                case 2:
                    this.f124c = typedArrayObtainStyledAttributes.getInt(index, this.f124c);
                    break;
                case 3:
                    if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                        typedArrayObtainStyledAttributes.getString(index);
                    } else {
                        String str = w.a.f13503a[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                    }
                    break;
                case b1.j.LONG_FIELD_NUMBER /* 4 */:
                    typedArrayObtainStyledAttributes.getInt(index, 0);
                    break;
                case b1.j.STRING_FIELD_NUMBER /* 5 */:
                    this.f122a = o.f(typedArrayObtainStyledAttributes, index, this.f122a);
                    break;
                case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                    this.f123b = typedArrayObtainStyledAttributes.getInteger(index, this.f123b);
                    break;
                case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                    this.f125d = typedArrayObtainStyledAttributes.getFloat(index, this.f125d);
                    break;
                case 8:
                    this.f127g = typedArrayObtainStyledAttributes.getInteger(index, this.f127g);
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
                        this.f128h = string;
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
