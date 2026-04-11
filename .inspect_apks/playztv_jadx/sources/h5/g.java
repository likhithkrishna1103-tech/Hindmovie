package h5;

import android.animation.FloatEvaluator;
import android.animation.TypeEvaluator;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g implements TypeEvaluator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f5893b;

    public /* synthetic */ g(int i) {
        this.f5892a = i;
    }

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float f, Object obj, Object obj2) {
        switch (this.f5892a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                i0.f[] fVarArr = (i0.f[]) obj;
                i0.f[] fVarArr2 = (i0.f[]) obj2;
                if (!ga.b.c(fVarArr, fVarArr2)) {
                    throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
                }
                if (!ga.b.c((i0.f[]) this.f5893b, fVarArr)) {
                    this.f5893b = ga.b.j(fVarArr);
                }
                for (int i = 0; i < fVarArr.length; i++) {
                    i0.f fVar = ((i0.f[]) this.f5893b)[i];
                    i0.f fVar2 = fVarArr[i];
                    i0.f fVar3 = fVarArr2[i];
                    fVar.getClass();
                    fVar.f6166a = fVar2.f6166a;
                    int i10 = 0;
                    while (true) {
                        float[] fArr = fVar2.f6167b;
                        if (i10 < fArr.length) {
                            fVar.f6167b[i10] = (fVar3.f6167b[i10] * f) + ((1.0f - f) * fArr[i10]);
                            i10++;
                        }
                    }
                }
                return (i0.f[]) this.f5893b;
            default:
                float fFloatValue = ((FloatEvaluator) this.f5893b).evaluate(f, (Number) obj, (Number) obj2).floatValue();
                if (fFloatValue < 0.1f) {
                    fFloatValue = 0.0f;
                }
                return Float.valueOf(fFloatValue);
        }
    }
}
