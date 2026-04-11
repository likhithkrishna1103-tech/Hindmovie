package y5;

import android.graphics.PointF;
import android.view.animation.BaseInterpolator;
import android.view.animation.Interpolator;
import l5.j;
import s5.c;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f14521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f14522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f14523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Interpolator f14524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Interpolator f14525e;
    public final Interpolator f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f14526g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Float f14527h;
    public float i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f14528j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f14529k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f14530l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f14531m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f14532n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public PointF f14533o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public PointF f14534p;

    public a(j jVar, Object obj, Object obj2, BaseInterpolator baseInterpolator, float f, Float f4) {
        this.i = -3987645.8f;
        this.f14528j = -3987645.8f;
        this.f14529k = 784923401;
        this.f14530l = 784923401;
        this.f14531m = Float.MIN_VALUE;
        this.f14532n = Float.MIN_VALUE;
        this.f14533o = null;
        this.f14534p = null;
        this.f14521a = jVar;
        this.f14522b = obj;
        this.f14523c = obj2;
        this.f14524d = baseInterpolator;
        this.f14525e = null;
        this.f = null;
        this.f14526g = f;
        this.f14527h = f4;
    }

    public final float a() {
        j jVar = this.f14521a;
        if (jVar == null) {
            return 1.0f;
        }
        if (this.f14532n == Float.MIN_VALUE) {
            if (this.f14527h == null) {
                this.f14532n = 1.0f;
            } else {
                this.f14532n = ((this.f14527h.floatValue() - this.f14526g) / (jVar.f7867m - jVar.f7866l)) + b();
            }
        }
        return this.f14532n;
    }

    public final float b() {
        j jVar = this.f14521a;
        if (jVar == null) {
            return 0.0f;
        }
        if (this.f14531m == Float.MIN_VALUE) {
            float f = jVar.f7866l;
            this.f14531m = (this.f14526g - f) / (jVar.f7867m - f);
        }
        return this.f14531m;
    }

    public final boolean c() {
        return this.f14524d == null && this.f14525e == null && this.f == null;
    }

    public final String toString() {
        return "Keyframe{startValue=" + this.f14522b + ", endValue=" + this.f14523c + ", startFrame=" + this.f14526g + ", endFrame=" + this.f14527h + ", interpolator=" + this.f14524d + '}';
    }

    public a(j jVar, Object obj, Object obj2, BaseInterpolator baseInterpolator, BaseInterpolator baseInterpolator2, float f) {
        this.i = -3987645.8f;
        this.f14528j = -3987645.8f;
        this.f14529k = 784923401;
        this.f14530l = 784923401;
        this.f14531m = Float.MIN_VALUE;
        this.f14532n = Float.MIN_VALUE;
        this.f14533o = null;
        this.f14534p = null;
        this.f14521a = jVar;
        this.f14522b = obj;
        this.f14523c = obj2;
        this.f14524d = null;
        this.f14525e = baseInterpolator;
        this.f = baseInterpolator2;
        this.f14526g = f;
        this.f14527h = null;
    }

    public a(j jVar, Object obj, Object obj2, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f, Float f4) {
        this.i = -3987645.8f;
        this.f14528j = -3987645.8f;
        this.f14529k = 784923401;
        this.f14530l = 784923401;
        this.f14531m = Float.MIN_VALUE;
        this.f14532n = Float.MIN_VALUE;
        this.f14533o = null;
        this.f14534p = null;
        this.f14521a = jVar;
        this.f14522b = obj;
        this.f14523c = obj2;
        this.f14524d = interpolator;
        this.f14525e = interpolator2;
        this.f = interpolator3;
        this.f14526g = f;
        this.f14527h = f4;
    }

    public a(Object obj) {
        this.i = -3987645.8f;
        this.f14528j = -3987645.8f;
        this.f14529k = 784923401;
        this.f14530l = 784923401;
        this.f14531m = Float.MIN_VALUE;
        this.f14532n = Float.MIN_VALUE;
        this.f14533o = null;
        this.f14534p = null;
        this.f14521a = null;
        this.f14522b = obj;
        this.f14523c = obj;
        this.f14524d = null;
        this.f14525e = null;
        this.f = null;
        this.f14526g = Float.MIN_VALUE;
        this.f14527h = Float.valueOf(Float.MAX_VALUE);
    }

    public a(c cVar, c cVar2) {
        this.i = -3987645.8f;
        this.f14528j = -3987645.8f;
        this.f14529k = 784923401;
        this.f14530l = 784923401;
        this.f14531m = Float.MIN_VALUE;
        this.f14532n = Float.MIN_VALUE;
        this.f14533o = null;
        this.f14534p = null;
        this.f14521a = null;
        this.f14522b = cVar;
        this.f14523c = cVar2;
        this.f14524d = null;
        this.f14525e = null;
        this.f = null;
        this.f14526g = Float.MIN_VALUE;
        this.f14527h = Float.valueOf(Float.MAX_VALUE);
    }
}
