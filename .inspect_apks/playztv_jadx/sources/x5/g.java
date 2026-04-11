package x5;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import b8.j;
import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f14267a = new j(2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f14268b = new j(3);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j f14269c = new j(4);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j f14270d = new j(5);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final float f14271e = (float) (Math.sqrt(2.0d) / 2.0d);

    public static void a(Path path, float f, float f4, float f10) {
        PathMeasure pathMeasure = (PathMeasure) f14267a.get();
        Path path2 = (Path) f14268b.get();
        Path path3 = (Path) f14269c.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (!(f == 1.0f && f4 == 0.0f) && length >= 1.0f && Math.abs((f4 - f) - 1.0f) >= 0.01d) {
            float f11 = f * length;
            float f12 = f4 * length;
            float f13 = f10 * length;
            float fMin = Math.min(f11, f12) + f13;
            float fMax = Math.max(f11, f12) + f13;
            if (fMin >= length && fMax >= length) {
                fMin = f.c(fMin, length);
                fMax = f.c(fMax, length);
            }
            if (fMin < 0.0f) {
                fMin = f.c(fMin, length);
            }
            if (fMax < 0.0f) {
                fMax = f.c(fMax, length);
            }
            if (fMin == fMax) {
                path.reset();
                return;
            }
            if (fMin >= fMax) {
                fMin -= length;
            }
            path2.reset();
            pathMeasure.getSegment(fMin, fMax, path2, true);
            if (fMax > length) {
                path3.reset();
                pathMeasure.getSegment(0.0f, fMax % length, path3, true);
                path2.addPath(path3);
            } else if (fMin < 0.0f) {
                path3.reset();
                pathMeasure.getSegment(fMin + length, length, path3, true);
                path2.addPath(path3);
            }
            path.set(path2);
        }
    }

    public static void b(Closeable closeable) {
        try {
            closeable.close();
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception unused) {
        }
    }

    public static float c() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static float d(Matrix matrix) {
        float[] fArr = (float[]) f14270d.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f = f14271e;
        fArr[2] = f;
        fArr[3] = f;
        matrix.mapPoints(fArr);
        return (float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
    }
}
