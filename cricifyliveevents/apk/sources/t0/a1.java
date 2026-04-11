package t0;

import android.graphics.Rect;
import android.util.Log;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a1 extends f1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Field f11725e = null;
    public static boolean f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Constructor f11726g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f11727h = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WindowInsets f11728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l0.c f11729d;

    public a1() {
        this.f11728c = i();
    }

    private static WindowInsets i() {
        if (!f) {
            try {
                f11725e = WindowInsets.class.getDeclaredField("CONSUMED");
            } catch (ReflectiveOperationException e9) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e9);
            }
            f = true;
        }
        Field field = f11725e;
        if (field != null) {
            try {
                WindowInsets windowInsets = (WindowInsets) field.get(null);
                if (windowInsets != null) {
                    return new WindowInsets(windowInsets);
                }
            } catch (ReflectiveOperationException e10) {
                Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e10);
            }
        }
        if (!f11727h) {
            try {
                f11726g = WindowInsets.class.getConstructor(Rect.class);
            } catch (ReflectiveOperationException e11) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e11);
            }
            f11727h = true;
        }
        Constructor constructor = f11726g;
        if (constructor != null) {
            try {
                return (WindowInsets) constructor.newInstance(new Rect());
            } catch (ReflectiveOperationException e12) {
                Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e12);
            }
        }
        return null;
    }

    @Override // t0.f1
    public p1 b() {
        a();
        p1 p1VarH = p1.h(null, this.f11728c);
        l0.c[] cVarArr = this.f11744b;
        m1 m1Var = p1VarH.f11791a;
        m1Var.p(cVarArr);
        m1Var.r(this.f11729d);
        return p1VarH;
    }

    @Override // t0.f1
    public void e(l0.c cVar) {
        this.f11729d = cVar;
    }

    @Override // t0.f1
    public void g(l0.c cVar) {
        WindowInsets windowInsets = this.f11728c;
        if (windowInsets != null) {
            this.f11728c = windowInsets.replaceSystemWindowInsets(cVar.f7602a, cVar.f7603b, cVar.f7604c, cVar.f7605d);
        }
    }

    public a1(p1 p1Var) {
        super(p1Var);
        this.f11728c = p1Var.g();
    }
}
