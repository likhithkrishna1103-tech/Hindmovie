package e5;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f4434a = new RectF();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f4435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f4436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f4437d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f4438e;
    public float f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f4439g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f4440h;
    public int[] i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f4441j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f4442k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f4443l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f4444m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f4445n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Path f4446o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f4447p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f4448q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f4449r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f4450s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f4451t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f4452u;

    public d() {
        Paint paint = new Paint();
        this.f4435b = paint;
        Paint paint2 = new Paint();
        this.f4436c = paint2;
        Paint paint3 = new Paint();
        this.f4437d = paint3;
        this.f4438e = 0.0f;
        this.f = 0.0f;
        this.f4439g = 0.0f;
        this.f4440h = 5.0f;
        this.f4447p = 1.0f;
        this.f4451t = 255;
        paint.setStrokeCap(Paint.Cap.SQUARE);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true);
        paint3.setColor(0);
    }

    public final void a(int i) {
        this.f4441j = i;
        this.f4452u = this.i[i];
    }
}
