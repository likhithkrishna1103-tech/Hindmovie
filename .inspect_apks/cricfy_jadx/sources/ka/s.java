package ka;

import android.graphics.Matrix;
import android.graphics.Path;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s extends t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f7373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f7374c;

    @Override // ka.t
    public final void a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f7375a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        path.lineTo(this.f7373b, this.f7374c);
        path.transform(matrix);
    }
}
