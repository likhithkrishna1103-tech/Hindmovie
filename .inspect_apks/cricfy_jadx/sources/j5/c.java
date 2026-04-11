package j5;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f6592a = new RectF();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f6593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f6594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f6595d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f6596e;
    public float f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f6597g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f6598h;
    public int[] i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f6599j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f6600k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f6601l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f6602m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f6603n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Path f6604o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f6605p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f6606q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f6607r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f6608s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f6609t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f6610u;

    public c() {
        Paint paint = new Paint();
        this.f6593b = paint;
        Paint paint2 = new Paint();
        this.f6594c = paint2;
        Paint paint3 = new Paint();
        this.f6595d = paint3;
        this.f6596e = 0.0f;
        this.f = 0.0f;
        this.f6597g = 0.0f;
        this.f6598h = 5.0f;
        this.f6605p = 1.0f;
        this.f6609t = 255;
        paint.setStrokeCap(Paint.Cap.SQUARE);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true);
        paint3.setColor(0);
    }

    public final void a(int i) {
        this.f6599j = i;
        this.f6610u = this.i[i];
    }
}
