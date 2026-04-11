package n6;

import a6.d;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.media3.decoder.DecoderInputBuffer;
import com.bumptech.glide.m;
import com.google.android.gms.internal.measurement.k4;
import e6.b0;
import e6.y;
import p6.g;
import x6.f;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements b0, y {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Drawable f8819u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f8820v;

    public b(Drawable drawable, int i) {
        this.f8820v = i;
        f.c(drawable, "Argument must not be null");
        this.f8819u = drawable;
    }

    @Override // e6.y
    public void a() {
        switch (this.f8820v) {
            case 1:
                ((g) ((p6.b) this.f8819u).f10213u.f5886b).f10237l.prepareToDraw();
                break;
            default:
                Drawable drawable = this.f8819u;
                if (drawable instanceof BitmapDrawable) {
                    ((BitmapDrawable) drawable).getBitmap().prepareToDraw();
                } else if (drawable instanceof p6.b) {
                    ((g) ((p6.b) drawable).f10213u.f5886b).f10237l.prepareToDraw();
                }
                break;
        }
    }

    @Override // e6.b0
    public final int b() {
        switch (this.f8820v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Drawable drawable = this.f8819u;
                return Math.max(1, drawable.getIntrinsicHeight() * drawable.getIntrinsicWidth() * 4);
            default:
                g gVar = (g) ((p6.b) this.f8819u).f10213u.f5886b;
                d dVar = gVar.f10228a;
                return (dVar.f600j.length * 4) + dVar.f596d.limit() + dVar.i.length + gVar.f10239n;
        }
    }

    @Override // e6.b0
    public final Class c() {
        switch (this.f8820v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return this.f8819u.getClass();
            default:
                return p6.b.class;
        }
    }

    @Override // e6.b0
    public final void d() {
        f6.f fVar;
        f6.f fVar2;
        f6.f fVar3;
        switch (this.f8820v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                break;
            default:
                p6.b bVar = (p6.b) this.f8819u;
                bVar.stop();
                bVar.f10216x = true;
                g gVar = (g) bVar.f10213u.f5886b;
                m mVar = gVar.f10231d;
                gVar.f10230c.clear();
                Bitmap bitmap = gVar.f10237l;
                if (bitmap != null) {
                    gVar.f10232e.f(bitmap);
                    gVar.f10237l = null;
                }
                gVar.f = false;
                p6.d dVar = gVar.i;
                if (dVar != null) {
                    mVar.p(dVar);
                    gVar.i = null;
                }
                p6.d dVar2 = gVar.f10236k;
                if (dVar2 != null) {
                    mVar.p(dVar2);
                    gVar.f10236k = null;
                }
                p6.d dVar3 = gVar.f10238m;
                if (dVar3 != null) {
                    mVar.p(dVar3);
                    gVar.f10238m = null;
                }
                d dVar4 = gVar.f10228a;
                k4 k4Var = dVar4.f595c;
                dVar4.f602l = null;
                byte[] bArr = dVar4.i;
                if (bArr != null && (fVar3 = (f6.f) k4Var.f3071v) != null) {
                    fVar3.h(bArr);
                }
                int[] iArr = dVar4.f600j;
                if (iArr != null && (fVar2 = (f6.f) k4Var.f3071v) != null) {
                    fVar2.h(iArr);
                }
                Bitmap bitmap2 = dVar4.f603m;
                if (bitmap2 != null) {
                    ((f6.a) k4Var.f3070u).f(bitmap2);
                }
                dVar4.f603m = null;
                dVar4.f596d = null;
                dVar4.f609s = null;
                byte[] bArr2 = dVar4.f597e;
                if (bArr2 != null && (fVar = (f6.f) k4Var.f3071v) != null) {
                    fVar.h(bArr2);
                }
                gVar.f10235j = true;
                break;
        }
    }

    @Override // e6.b0
    public final Object get() {
        Drawable drawable = this.f8819u;
        Drawable.ConstantState constantState = drawable.getConstantState();
        return constantState == null ? drawable : constantState.newDrawable();
    }

    private final void e() {
    }
}
