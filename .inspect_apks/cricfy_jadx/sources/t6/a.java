package t6;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import g6.i;
import n6.c;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f11931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f11932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f11933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Interpolator f11934d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Interpolator f11935e;
    public final Interpolator f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f11936g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Float f11937h;
    public float i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f11938j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f11939k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f11940l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f11941m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f11942n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public PointF f11943o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public PointF f11944p;

    public a(i iVar, Object obj, Object obj2, Interpolator interpolator, float f, Float f10) {
        this.i = -3987645.8f;
        this.f11938j = -3987645.8f;
        this.f11939k = 784923401;
        this.f11940l = 784923401;
        this.f11941m = Float.MIN_VALUE;
        this.f11942n = Float.MIN_VALUE;
        this.f11943o = null;
        this.f11944p = null;
        this.f11931a = iVar;
        this.f11932b = obj;
        this.f11933c = obj2;
        this.f11934d = interpolator;
        this.f11935e = null;
        this.f = null;
        this.f11936g = f;
        this.f11937h = f10;
    }

    public final float a() {
        i iVar = this.f11931a;
        if (iVar == null) {
            return 1.0f;
        }
        if (this.f11942n == Float.MIN_VALUE) {
            if (this.f11937h == null) {
                this.f11942n = 1.0f;
            } else {
                this.f11942n = (float) (((double) b()) + (((double) (this.f11937h.floatValue() - this.f11936g)) / ((double) (iVar.f5096m - iVar.f5095l))));
            }
        }
        return this.f11942n;
    }

    public final float b() {
        i iVar = this.f11931a;
        if (iVar == null) {
            return 0.0f;
        }
        if (this.f11941m == Float.MIN_VALUE) {
            float f = iVar.f5095l;
            this.f11941m = (this.f11936g - f) / (iVar.f5096m - f);
        }
        return this.f11941m;
    }

    public final boolean c() {
        return this.f11934d == null && this.f11935e == null && this.f == null;
    }

    public final String toString() {
        return "Keyframe{startValue=" + this.f11932b + ", endValue=" + this.f11933c + ", startFrame=" + this.f11936g + ", endFrame=" + this.f11937h + ", interpolator=" + this.f11934d + '}';
    }

    public a(i iVar, Object obj, Object obj2, Interpolator interpolator, Interpolator interpolator2, float f) {
        this.i = -3987645.8f;
        this.f11938j = -3987645.8f;
        this.f11939k = 784923401;
        this.f11940l = 784923401;
        this.f11941m = Float.MIN_VALUE;
        this.f11942n = Float.MIN_VALUE;
        this.f11943o = null;
        this.f11944p = null;
        this.f11931a = iVar;
        this.f11932b = obj;
        this.f11933c = obj2;
        this.f11934d = null;
        this.f11935e = interpolator;
        this.f = interpolator2;
        this.f11936g = f;
        this.f11937h = null;
    }

    public a(i iVar, Object obj, Object obj2, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f, Float f10) {
        this.i = -3987645.8f;
        this.f11938j = -3987645.8f;
        this.f11939k = 784923401;
        this.f11940l = 784923401;
        this.f11941m = Float.MIN_VALUE;
        this.f11942n = Float.MIN_VALUE;
        this.f11943o = null;
        this.f11944p = null;
        this.f11931a = iVar;
        this.f11932b = obj;
        this.f11933c = obj2;
        this.f11934d = interpolator;
        this.f11935e = interpolator2;
        this.f = interpolator3;
        this.f11936g = f;
        this.f11937h = f10;
    }

    public a(Object obj) {
        this.i = -3987645.8f;
        this.f11938j = -3987645.8f;
        this.f11939k = 784923401;
        this.f11940l = 784923401;
        this.f11941m = Float.MIN_VALUE;
        this.f11942n = Float.MIN_VALUE;
        this.f11943o = null;
        this.f11944p = null;
        this.f11931a = null;
        this.f11932b = obj;
        this.f11933c = obj;
        this.f11934d = null;
        this.f11935e = null;
        this.f = null;
        this.f11936g = Float.MIN_VALUE;
        this.f11937h = Float.valueOf(Float.MAX_VALUE);
    }

    public a(c cVar, c cVar2) {
        this.i = -3987645.8f;
        this.f11938j = -3987645.8f;
        this.f11939k = 784923401;
        this.f11940l = 784923401;
        this.f11941m = Float.MIN_VALUE;
        this.f11942n = Float.MIN_VALUE;
        this.f11943o = null;
        this.f11944p = null;
        this.f11931a = null;
        this.f11932b = cVar;
        this.f11933c = cVar2;
        this.f11934d = null;
        this.f11935e = null;
        this.f = null;
        this.f11936g = Float.MIN_VALUE;
        this.f11937h = Float.valueOf(Float.MAX_VALUE);
    }
}
