package ba;

import android.animation.FloatEvaluator;
import android.animation.TypeEvaluator;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements TypeEvaluator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f1873b;

    public h(int i) {
        this.f1872a = i;
        switch (i) {
            case 1:
                break;
            default:
                this.f1873b = new FloatEvaluator();
                break;
        }
    }

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float f, Object obj, Object obj2) {
        switch (this.f1872a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                float fFloatValue = ((FloatEvaluator) this.f1873b).evaluate(f, (Number) obj, (Number) obj2).floatValue();
                if (fFloatValue < 0.1f) {
                    fFloatValue = 0.0f;
                }
                return Float.valueOf(fFloatValue);
            default:
                l0.f[] fVarArr = (l0.f[]) obj;
                l0.f[] fVarArr2 = (l0.f[]) obj2;
                if (!u8.a.e(fVarArr, fVarArr2)) {
                    throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
                }
                if (!u8.a.e((l0.f[]) this.f1873b, fVarArr)) {
                    this.f1873b = u8.a.q(fVarArr);
                }
                for (int i = 0; i < fVarArr.length; i++) {
                    l0.f fVar = ((l0.f[]) this.f1873b)[i];
                    l0.f fVar2 = fVarArr[i];
                    l0.f fVar3 = fVarArr2[i];
                    fVar.getClass();
                    fVar.f7607a = fVar2.f7607a;
                    int i10 = 0;
                    while (true) {
                        float[] fArr = fVar2.f7608b;
                        if (i10 < fArr.length) {
                            fVar.f7608b[i10] = (fVar3.f7608b[i10] * f) + ((1.0f - f) * fArr[i10]);
                            i10++;
                        }
                    }
                }
                return (l0.f[]) this.f1873b;
        }
    }
}
