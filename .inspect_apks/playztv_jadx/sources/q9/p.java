package q9;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p extends r {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final RectF f11140h = new RectF();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f11141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f11142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f11143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f11144e;
    public float f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f11145g;

    public p(float f, float f4, float f10, float f11) {
        this.f11141b = f;
        this.f11142c = f4;
        this.f11143d = f10;
        this.f11144e = f11;
    }

    @Override // q9.r
    public final void a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f11148a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        float f = this.f11143d;
        float f4 = this.f11144e;
        RectF rectF = f11140h;
        rectF.set(this.f11141b, this.f11142c, f, f4);
        path.arcTo(rectF, this.f, this.f11145g, false);
        path.transform(matrix);
    }
}
