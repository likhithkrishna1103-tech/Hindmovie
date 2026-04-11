package ba;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements TypeEvaluator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f1868a = new float[9];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f1869b = new float[9];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f1870c = new Matrix();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ j f1871d;

    public g(j jVar) {
        this.f1871d = jVar;
    }

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float f, Object obj, Object obj2) {
        this.f1871d.f1889p = f;
        float[] fArr = this.f1868a;
        ((Matrix) obj).getValues(fArr);
        float[] fArr2 = this.f1869b;
        ((Matrix) obj2).getValues(fArr2);
        for (int i = 0; i < 9; i++) {
            float f10 = fArr2[i];
            float f11 = fArr[i];
            fArr2[i] = q4.a.h(f10, f11, f, f11);
        }
        Matrix matrix = this.f1870c;
        matrix.setValues(fArr2);
        return matrix;
    }
}
