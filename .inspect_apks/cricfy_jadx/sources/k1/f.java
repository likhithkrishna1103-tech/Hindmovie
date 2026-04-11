package k1;

import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.Choreographer;
import i2.k;
import java.util.ArrayList;
import ka.w;
import w4.v;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final d f6798m = new d(1);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final d f6799n = new d(2);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final d f6800o = new d(3);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final d f6801p = new d(4);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final d f6802q = new d(5);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final d f6803r = new d(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w f6806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v f6807d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f6809g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public g f6811j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f6812k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f6813l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f6804a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f6805b = Float.MAX_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f6808e = false;
    public long f = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f6810h = new ArrayList();
    public final ArrayList i = new ArrayList();

    public f(w wVar, v vVar) {
        this.f6806c = wVar;
        this.f6807d = vVar;
        if (vVar == f6800o || vVar == f6801p || vVar == f6802q) {
            this.f6809g = 0.1f;
        } else if (vVar == f6803r) {
            this.f6809g = 0.00390625f;
        } else if (vVar == f6798m || vVar == f6799n) {
            this.f6809g = 0.002f;
        } else {
            this.f6809g = 1.0f;
        }
        this.f6811j = null;
        this.f6812k = Float.MAX_VALUE;
        this.f6813l = false;
    }

    public static c b() {
        ThreadLocal threadLocal = c.i;
        if (threadLocal.get() == null) {
            threadLocal.set(new c(new k(8)));
        }
        return (c) threadLocal.get();
    }

    /* JADX WARN: Type inference failed for: r1v19, types: [java.lang.Object, k1.a] */
    public final void a(float f) {
        if (this.f6808e) {
            this.f6812k = f;
            return;
        }
        if (this.f6811j == null) {
            this.f6811j = new g(f);
        }
        g gVar = this.f6811j;
        double d10 = f;
        gVar.i = d10;
        double d11 = (float) d10;
        if (d11 > Float.MAX_VALUE) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (d11 < -3.4028235E38f) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
        double dAbs = Math.abs(this.f6809g * 0.75f);
        gVar.f6817d = dAbs;
        gVar.f6818e = dAbs * 62.5d;
        k kVar = b().f6793e;
        kVar.getClass();
        if (Thread.currentThread() != ((Looper) kVar.f6086w).getThread()) {
            throw new AndroidRuntimeException("Animations may only be started on the same thread as the animation handler");
        }
        boolean z10 = this.f6808e;
        if (z10 || z10) {
            return;
        }
        this.f6808e = true;
        float fJ = this.f6807d.j(this.f6806c);
        this.f6805b = fJ;
        if (fJ > Float.MAX_VALUE || fJ < -3.4028235E38f) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        c cVarB = b();
        ArrayList arrayList = cVarB.f6790b;
        if (arrayList.size() == 0) {
            ((Choreographer) cVarB.f6793e.f6085v).postFrameCallback(new b(cVarB.f6792d));
            if (Build.VERSION.SDK_INT >= 33) {
                cVarB.f6794g = ValueAnimator.getDurationScale();
                if (cVarB.f6795h == null) {
                    cVarB.f6795h = new k(cVarB);
                }
                final k kVar2 = cVarB.f6795h;
                if (((a) kVar2.f6085v) == null) {
                    ?? r12 = new ValueAnimator.DurationScaleChangeListener() { // from class: k1.a
                        @Override // android.animation.ValueAnimator.DurationScaleChangeListener
                        public final void onChanged(float f10) {
                            ((c) kVar2.f6086w).f6794g = f10;
                        }
                    };
                    kVar2.f6085v = r12;
                    ValueAnimator.registerDurationScaleChangeListener(r12);
                }
            }
        }
        if (arrayList.contains(this)) {
            return;
        }
        arrayList.add(this);
    }

    public final void c(float f) {
        this.f6807d.u(this.f6806c, f);
        int i = 0;
        while (true) {
            ArrayList arrayList = this.i;
            if (i >= arrayList.size()) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (arrayList.get(size) == null) {
                        arrayList.remove(size);
                    }
                }
                return;
            }
            if (arrayList.get(i) != null) {
                throw q4.a.k(i, arrayList);
            }
            i++;
        }
    }

    public final void d() {
        if (this.f6811j.f6815b <= 0.0d) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        }
        k kVar = b().f6793e;
        kVar.getClass();
        if (Thread.currentThread() != ((Looper) kVar.f6086w).getThread()) {
            throw new AndroidRuntimeException("Animations may only be started on the same thread as the animation handler");
        }
        if (this.f6808e) {
            this.f6813l = true;
        }
    }
}
