package q0;

import android.graphics.Rect;
import android.util.Log;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c1 extends h1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Field f10423e = null;
    public static boolean f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Constructor f10424g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f10425h = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WindowInsets f10426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i0.d f10427d;

    public c1() {
        this.f10426c = i();
    }

    private static WindowInsets i() {
        if (!f) {
            try {
                f10423e = WindowInsets.class.getDeclaredField("CONSUMED");
            } catch (ReflectiveOperationException e10) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e10);
            }
            f = true;
        }
        Field field = f10423e;
        if (field != null) {
            try {
                WindowInsets windowInsets = (WindowInsets) field.get(null);
                if (windowInsets != null) {
                    return new WindowInsets(windowInsets);
                }
            } catch (ReflectiveOperationException e11) {
                Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e11);
            }
        }
        if (!f10425h) {
            try {
                f10424g = WindowInsets.class.getConstructor(Rect.class);
            } catch (ReflectiveOperationException e12) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e12);
            }
            f10425h = true;
        }
        Constructor constructor = f10424g;
        if (constructor != null) {
            try {
                return (WindowInsets) constructor.newInstance(new Rect());
            } catch (ReflectiveOperationException e13) {
                Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e13);
            }
        }
        return null;
    }

    @Override // q0.h1
    public r1 b() {
        a();
        r1 r1VarH = r1.h(null, this.f10426c);
        i0.d[] dVarArr = this.f10449b;
        o1 o1Var = r1VarH.f10492a;
        o1Var.p(dVarArr);
        o1Var.r(this.f10427d);
        return r1VarH;
    }

    @Override // q0.h1
    public void e(i0.d dVar) {
        this.f10427d = dVar;
    }

    @Override // q0.h1
    public void g(i0.d dVar) {
        WindowInsets windowInsets = this.f10426c;
        if (windowInsets != null) {
            this.f10426c = windowInsets.replaceSystemWindowInsets(dVar.f6161a, dVar.f6162b, dVar.f6163c, dVar.f6164d);
        }
    }

    public c1(r1 r1Var) {
        super(r1Var);
        this.f10426c = r1Var.g();
    }
}
