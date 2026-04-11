package g7;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements z6.b0, z6.y {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f5175v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f5176w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f5177x;

    public d(a7.b bVar, Bitmap bitmap) {
        s7.f.c(bitmap, "Bitmap must not be null");
        this.f5176w = bitmap;
        s7.f.c(bVar, "BitmapPool must not be null");
        this.f5177x = bVar;
    }

    public static d b(a7.b bVar, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return new d(bVar, bitmap);
    }

    @Override // z6.y
    public final void a() {
        switch (this.f5175v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((Bitmap) this.f5176w).prepareToDraw();
                break;
            default:
                z6.b0 b0Var = (z6.b0) this.f5177x;
                if (b0Var instanceof z6.y) {
                    ((z6.y) b0Var).a();
                }
                break;
        }
    }

    @Override // z6.b0
    public final int c() {
        switch (this.f5175v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return s7.m.c((Bitmap) this.f5176w);
            default:
                return ((z6.b0) this.f5177x).c();
        }
    }

    @Override // z6.b0
    public final Class d() {
        switch (this.f5175v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return Bitmap.class;
            default:
                return BitmapDrawable.class;
        }
    }

    @Override // z6.b0
    public final void e() {
        switch (this.f5175v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((a7.b) this.f5177x).d((Bitmap) this.f5176w);
                break;
            default:
                ((z6.b0) this.f5177x).e();
                break;
        }
    }

    @Override // z6.b0
    public final Object get() {
        switch (this.f5175v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return (Bitmap) this.f5176w;
            default:
                return new BitmapDrawable((Resources) this.f5176w, (Bitmap) ((z6.b0) this.f5177x).get());
        }
    }

    public d(Resources resources, z6.b0 b0Var) {
        s7.f.c(resources, "Argument must not be null");
        this.f5176w = resources;
        s7.f.c(b0Var, "Argument must not be null");
        this.f5177x = b0Var;
    }
}
