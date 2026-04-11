package ka;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r extends t {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final RectF f7367h = new RectF();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f7368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f7369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f7370d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f7371e;
    public float f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f7372g;

    public r(float f, float f10, float f11, float f12) {
        this.f7368b = f;
        this.f7369c = f10;
        this.f7370d = f11;
        this.f7371e = f12;
    }

    @Override // ka.t
    public final void a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f7375a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        float f = this.f7370d;
        float f10 = this.f7371e;
        RectF rectF = f7367h;
        rectF.set(this.f7368b, this.f7369c, f, f10);
        path.arcTo(rectF, this.f, this.f7372g, false);
        path.transform(matrix);
    }
}
