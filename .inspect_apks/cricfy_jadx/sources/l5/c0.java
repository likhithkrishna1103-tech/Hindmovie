package l5;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class c0 extends android.support.v4.media.session.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f7780e = true;
    public static boolean f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f7781g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f7782h = true;

    @Override // android.support.v4.media.session.b
    public void M(View view, int i) {
        if (Build.VERSION.SDK_INT == 28) {
            super.M(view, i);
        } else if (f7782h) {
            try {
                b0.a(view, i);
            } catch (NoSuchMethodError unused) {
                f7782h = false;
            }
        }
    }

    public void R(View view, int i, int i10, int i11, int i12) {
        if (f7781g) {
            try {
                a0.a(view, i, i10, i11, i12);
            } catch (NoSuchMethodError unused) {
                f7781g = false;
            }
        }
    }

    public void S(View view, Matrix matrix) {
        if (f7780e) {
            try {
                z.b(view, matrix);
            } catch (NoSuchMethodError unused) {
                f7780e = false;
            }
        }
    }

    public void T(View view, Matrix matrix) {
        if (f) {
            try {
                z.c(view, matrix);
            } catch (NoSuchMethodError unused) {
                f = false;
            }
        }
    }
}
