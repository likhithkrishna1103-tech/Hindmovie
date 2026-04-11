package ja;

import android.graphics.Paint;
import android.graphics.Path;
import l0.b;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final int[] i = new int[3];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float[] f6712j = {0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f6713k = new int[4];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final float[] f6714l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f6715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f6716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f6717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6718d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6719e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f6720g = new Path();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f6721h;

    public a() {
        Paint paint = new Paint();
        this.f6721h = paint;
        this.f6715a = new Paint();
        a(-16777216);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.f6716b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f6717c = new Paint(paint2);
    }

    public final void a(int i10) {
        this.f6718d = b.d(i10, 68);
        this.f6719e = b.d(i10, 20);
        this.f = b.d(i10, 0);
        this.f6715a.setColor(this.f6718d);
    }
}
