package ka;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class g extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f7316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d0 f7317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public z9.a f7318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ColorStateList f7319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ColorStateList f7320e;
    public ColorStateList f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PorterDuff.Mode f7321g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Rect f7322h;
    public final float i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f7323j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f7324k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f7325l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f7326m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f7327n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f7328o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f7329p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Paint.Style f7330q;

    public g(m mVar) {
        this.f7319d = null;
        this.f7320e = null;
        this.f = null;
        this.f7321g = PorterDuff.Mode.SRC_IN;
        this.f7322h = null;
        this.i = 1.0f;
        this.f7323j = 1.0f;
        this.f7325l = 255;
        this.f7326m = 0.0f;
        this.f7327n = 0.0f;
        this.f7328o = 0;
        this.f7329p = 0;
        this.f7330q = Paint.Style.FILL_AND_STROKE;
        this.f7316a = mVar;
        this.f7318c = null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        i iVar = new i(this);
        iVar.A = true;
        iVar.B = true;
        return iVar;
    }

    public g(g gVar) {
        this.f7319d = null;
        this.f7320e = null;
        this.f = null;
        this.f7321g = PorterDuff.Mode.SRC_IN;
        this.f7322h = null;
        this.i = 1.0f;
        this.f7323j = 1.0f;
        this.f7325l = 255;
        this.f7326m = 0.0f;
        this.f7327n = 0.0f;
        this.f7328o = 0;
        this.f7329p = 0;
        this.f7330q = Paint.Style.FILL_AND_STROKE;
        this.f7316a = gVar.f7316a;
        this.f7317b = gVar.f7317b;
        this.f7318c = gVar.f7318c;
        this.f7324k = gVar.f7324k;
        this.f7319d = gVar.f7319d;
        this.f7320e = gVar.f7320e;
        this.f7321g = gVar.f7321g;
        this.f = gVar.f;
        this.f7325l = gVar.f7325l;
        this.i = gVar.i;
        this.f7329p = gVar.f7329p;
        this.f7323j = gVar.f7323j;
        this.f7326m = gVar.f7326m;
        this.f7327n = gVar.f7327n;
        this.f7328o = gVar.f7328o;
        this.f7330q = gVar.f7330q;
        if (gVar.f7322h != null) {
            this.f7322h = new Rect(gVar.f7322h);
        }
    }
}
