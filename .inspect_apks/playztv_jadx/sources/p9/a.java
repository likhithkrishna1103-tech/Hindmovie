package p9;

import android.graphics.Paint;
import android.graphics.Path;
import i0.b;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final int[] i = new int[3];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float[] f10287j = {0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f10288k = new int[4];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final float[] f10289l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f10290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f10291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f10292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10293d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10294e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f10295g = new Path();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f10296h;

    public a() {
        Paint paint = new Paint();
        this.f10296h = paint;
        this.f10290a = new Paint();
        a(-16777216);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.f10291b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f10292c = new Paint(paint2);
    }

    public final void a(int i10) {
        this.f10293d = b.d(i10, 68);
        this.f10294e = b.d(i10, 20);
        this.f = b.d(i10, 0);
        this.f10290a.setColor(this.f10293d);
    }
}
