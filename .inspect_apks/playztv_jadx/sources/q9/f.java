package q9;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class f extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f11090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f9.a f11091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ColorStateList f11092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ColorStateList f11093d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ColorStateList f11094e;
    public PorterDuff.Mode f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Rect f11095g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f11096h;
    public float i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f11097j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f11098k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f11099l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f11100m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f11101n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f11102o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f11103p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Paint.Style f11104q;

    public f(k kVar) {
        this.f11092c = null;
        this.f11093d = null;
        this.f11094e = null;
        this.f = PorterDuff.Mode.SRC_IN;
        this.f11095g = null;
        this.f11096h = 1.0f;
        this.i = 1.0f;
        this.f11098k = 255;
        this.f11099l = 0.0f;
        this.f11100m = 0.0f;
        this.f11101n = 0;
        this.f11102o = 0;
        this.f11103p = 0;
        this.f11104q = Paint.Style.FILL_AND_STROKE;
        this.f11090a = kVar;
        this.f11091b = null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        g gVar = new g(this);
        gVar.f11109y = true;
        return gVar;
    }

    public f(f fVar) {
        this.f11092c = null;
        this.f11093d = null;
        this.f11094e = null;
        this.f = PorterDuff.Mode.SRC_IN;
        this.f11095g = null;
        this.f11096h = 1.0f;
        this.i = 1.0f;
        this.f11098k = 255;
        this.f11099l = 0.0f;
        this.f11100m = 0.0f;
        this.f11101n = 0;
        this.f11102o = 0;
        this.f11103p = 0;
        this.f11104q = Paint.Style.FILL_AND_STROKE;
        this.f11090a = fVar.f11090a;
        this.f11091b = fVar.f11091b;
        this.f11097j = fVar.f11097j;
        this.f11092c = fVar.f11092c;
        this.f11093d = fVar.f11093d;
        this.f = fVar.f;
        this.f11094e = fVar.f11094e;
        this.f11098k = fVar.f11098k;
        this.f11096h = fVar.f11096h;
        this.f11102o = fVar.f11102o;
        this.i = fVar.i;
        this.f11099l = fVar.f11099l;
        this.f11100m = fVar.f11100m;
        this.f11101n = fVar.f11101n;
        this.f11103p = fVar.f11103p;
        this.f11104q = fVar.f11104q;
        if (fVar.f11095g != null) {
            this.f11095g = new Rect(fVar.f11095g);
        }
    }
}
