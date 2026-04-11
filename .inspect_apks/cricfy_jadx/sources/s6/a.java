package s6;

import android.graphics.Color;
import android.graphics.Matrix;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f11541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f11542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f11543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11544d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f11545e = null;

    public a(a aVar) {
        this.f11541a = 0.0f;
        this.f11542b = 0.0f;
        this.f11543c = 0.0f;
        this.f11544d = 0;
        this.f11541a = aVar.f11541a;
        this.f11542b = aVar.f11542b;
        this.f11543c = aVar.f11543c;
        this.f11544d = aVar.f11544d;
    }

    public final void a(int i, h6.a aVar) {
        int iAlpha = Color.alpha(this.f11544d);
        int iC = g.c(i);
        Matrix matrix = i.f11583a;
        int i10 = (int) ((((iAlpha / 255.0f) * iC) / 255.0f) * 255.0f);
        if (i10 <= 0) {
            aVar.clearShadowLayer();
        } else {
            aVar.setShadowLayer(Math.max(this.f11541a, Float.MIN_VALUE), this.f11542b, this.f11543c, Color.argb(i10, Color.red(this.f11544d), Color.green(this.f11544d), Color.blue(this.f11544d)));
        }
    }

    public final void b(int i) {
        this.f11544d = Color.argb(Math.round((g.c(i) * Color.alpha(this.f11544d)) / 255.0f), Color.red(this.f11544d), Color.green(this.f11544d), Color.blue(this.f11544d));
    }

    public final void c(Matrix matrix) {
        if (this.f11545e == null) {
            this.f11545e = new float[2];
        }
        float[] fArr = this.f11545e;
        fArr[0] = this.f11542b;
        fArr[1] = this.f11543c;
        matrix.mapVectors(fArr);
        float[] fArr2 = this.f11545e;
        this.f11542b = fArr2[0];
        this.f11543c = fArr2[1];
        this.f11541a = matrix.mapRadius(this.f11541a);
    }
}
