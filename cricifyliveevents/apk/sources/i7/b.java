package i7;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.media3.decoder.DecoderInputBuffer;
import com.bumptech.glide.p;
import i2.k;
import k7.g;
import s7.f;
import v6.d;
import z6.b0;
import z6.y;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements b0, y {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Drawable f6346v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ int f6347w;

    public b(Drawable drawable, int i) {
        this.f6347w = i;
        f.c(drawable, "Argument must not be null");
        this.f6346v = drawable;
    }

    @Override // z6.y
    public void a() {
        switch (this.f6347w) {
            case 1:
                ((g) ((k7.b) this.f6346v).f7212v.f1841b).f7234l.prepareToDraw();
                break;
            default:
                Drawable drawable = this.f6346v;
                if (drawable instanceof BitmapDrawable) {
                    ((BitmapDrawable) drawable).getBitmap().prepareToDraw();
                } else if (drawable instanceof k7.b) {
                    ((g) ((k7.b) drawable).f7212v.f1841b).f7234l.prepareToDraw();
                }
                break;
        }
    }

    @Override // z6.b0
    public final int c() {
        switch (this.f6347w) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Drawable drawable = this.f6346v;
                return Math.max(1, drawable.getIntrinsicHeight() * drawable.getIntrinsicWidth() * 4);
            default:
                g gVar = (g) ((k7.b) this.f6346v).f7212v.f1841b;
                d dVar = gVar.f7225a;
                return (dVar.f13485j.length * 4) + dVar.f13481d.limit() + dVar.i.length + gVar.f7236n;
        }
    }

    @Override // z6.b0
    public final Class d() {
        switch (this.f6347w) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return this.f6346v.getClass();
            default:
                return k7.b.class;
        }
    }

    @Override // z6.b0
    public final void e() {
        a7.g gVar;
        a7.g gVar2;
        a7.g gVar3;
        switch (this.f6347w) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                break;
            default:
                k7.b bVar = (k7.b) this.f6346v;
                bVar.stop();
                bVar.f7215y = true;
                g gVar4 = (g) bVar.f7212v.f1841b;
                p pVar = gVar4.f7228d;
                gVar4.f7227c.clear();
                Bitmap bitmap = gVar4.f7234l;
                if (bitmap != null) {
                    gVar4.f7229e.d(bitmap);
                    gVar4.f7234l = null;
                }
                gVar4.f = false;
                k7.d dVar = gVar4.i;
                if (dVar != null) {
                    pVar.o(dVar);
                    gVar4.i = null;
                }
                k7.d dVar2 = gVar4.f7233k;
                if (dVar2 != null) {
                    pVar.o(dVar2);
                    gVar4.f7233k = null;
                }
                k7.d dVar3 = gVar4.f7235m;
                if (dVar3 != null) {
                    pVar.o(dVar3);
                    gVar4.f7235m = null;
                }
                d dVar4 = gVar4.f7225a;
                k kVar = dVar4.f13480c;
                dVar4.f13487l = null;
                byte[] bArr = dVar4.i;
                if (bArr != null && (gVar3 = (a7.g) kVar.f6086w) != null) {
                    gVar3.h(bArr);
                }
                int[] iArr = dVar4.f13485j;
                if (iArr != null && (gVar2 = (a7.g) kVar.f6086w) != null) {
                    gVar2.h(iArr);
                }
                Bitmap bitmap2 = dVar4.f13488m;
                if (bitmap2 != null) {
                    ((a7.b) kVar.f6085v).d(bitmap2);
                }
                dVar4.f13488m = null;
                dVar4.f13481d = null;
                dVar4.f13494s = null;
                byte[] bArr2 = dVar4.f13482e;
                if (bArr2 != null && (gVar = (a7.g) kVar.f6086w) != null) {
                    gVar.h(bArr2);
                }
                gVar4.f7232j = true;
                break;
        }
    }

    @Override // z6.b0
    public final Object get() {
        Drawable drawable = this.f6346v;
        Drawable.ConstantState constantState = drawable.getConstantState();
        return constantState == null ? drawable : constantState.newDrawable();
    }

    private final void b() {
    }
}
