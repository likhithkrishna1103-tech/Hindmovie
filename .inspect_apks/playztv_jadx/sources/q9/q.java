package q9;

import android.graphics.Matrix;
import android.graphics.Path;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q extends r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f11146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f11147c;

    @Override // q9.r
    public final void a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f11148a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        path.lineTo(this.f11146b, this.f11147c);
        path.transform(matrix);
    }
}
