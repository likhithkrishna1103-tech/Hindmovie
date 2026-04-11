package h9;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements TypeEvaluator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f5978a = new float[9];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f5979b = new float[9];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f5980c = new Matrix();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ i f5981d;

    public d(i iVar) {
        this.f5981d = iVar;
    }

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float f, Object obj, Object obj2) {
        this.f5981d.f6008p = f;
        float[] fArr = this.f5978a;
        ((Matrix) obj).getValues(fArr);
        float[] fArr2 = this.f5979b;
        ((Matrix) obj2).getValues(fArr2);
        for (int i = 0; i < 9; i++) {
            float f4 = fArr2[i];
            float f10 = fArr[i];
            fArr2[i] = e6.j.g(f4, f10, f, f10);
        }
        Matrix matrix = this.f5980c;
        matrix.setValues(fArr2);
        return matrix;
    }
}
