package g5;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class e0 extends cf.d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f5268d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f5269e = true;
    public static boolean f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f5270g = true;

    public void A(View view, Matrix matrix) {
        if (f5268d) {
            try {
                b0.b(view, matrix);
            } catch (NoSuchMethodError unused) {
                f5268d = false;
            }
        }
    }

    public void B(View view, Matrix matrix) {
        if (f5269e) {
            try {
                b0.c(view, matrix);
            } catch (NoSuchMethodError unused) {
                f5269e = false;
            }
        }
    }

    @Override // cf.d
    public void y(View view, int i) {
        if (Build.VERSION.SDK_INT == 28) {
            super.y(view, i);
        } else if (f5270g) {
            try {
                d0.a(view, i);
            } catch (NoSuchMethodError unused) {
                f5270g = false;
            }
        }
    }

    public void z(View view, int i, int i10, int i11, int i12) {
        if (f) {
            try {
                c0.a(view, i, i10, i11, i12);
            } catch (NoSuchMethodError unused) {
                f = false;
            }
        }
    }
}
