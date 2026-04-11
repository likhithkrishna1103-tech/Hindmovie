package l6;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements e6.b0, e6.y {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7963u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f7964v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f7965w;

    public d(Bitmap bitmap, f6.a aVar) {
        x6.f.c(bitmap, "Bitmap must not be null");
        this.f7964v = bitmap;
        x6.f.c(aVar, "BitmapPool must not be null");
        this.f7965w = aVar;
    }

    public static d e(Bitmap bitmap, f6.a aVar) {
        if (bitmap == null) {
            return null;
        }
        return new d(bitmap, aVar);
    }

    @Override // e6.y
    public final void a() {
        switch (this.f7963u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((Bitmap) this.f7964v).prepareToDraw();
                break;
            default:
                e6.b0 b0Var = (e6.b0) this.f7965w;
                if (b0Var instanceof e6.y) {
                    ((e6.y) b0Var).a();
                }
                break;
        }
    }

    @Override // e6.b0
    public final int b() {
        switch (this.f7963u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return x6.m.c((Bitmap) this.f7964v);
            default:
                return ((e6.b0) this.f7965w).b();
        }
    }

    @Override // e6.b0
    public final Class c() {
        switch (this.f7963u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return Bitmap.class;
            default:
                return BitmapDrawable.class;
        }
    }

    @Override // e6.b0
    public final void d() {
        switch (this.f7963u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((f6.a) this.f7965w).f((Bitmap) this.f7964v);
                break;
            default:
                ((e6.b0) this.f7965w).d();
                break;
        }
    }

    @Override // e6.b0
    public final Object get() {
        switch (this.f7963u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return (Bitmap) this.f7964v;
            default:
                return new BitmapDrawable((Resources) this.f7964v, (Bitmap) ((e6.b0) this.f7965w).get());
        }
    }

    public d(Resources resources, e6.b0 b0Var) {
        x6.f.c(resources, "Argument must not be null");
        this.f7964v = resources;
        x6.f.c(b0Var, "Argument must not be null");
        this.f7965w = b0Var;
    }
}
