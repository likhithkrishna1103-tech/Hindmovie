package g7;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 implements z6.b0 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f5167v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f5168w;

    public /* synthetic */ a0(int i, Object obj) {
        this.f5167v = i;
        this.f5168w = obj;
    }

    @Override // z6.b0
    public final int c() {
        switch (this.f5167v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return s7.m.c((Bitmap) this.f5168w);
            case 1:
                return ((byte[]) this.f5168w).length;
            case 2:
                return s7.m.d(Bitmap.Config.ARGB_8888) * ((AnimatedImageDrawable) this.f5168w).getIntrinsicHeight() * ((AnimatedImageDrawable) this.f5168w).getIntrinsicWidth() * 2;
            default:
                return 1;
        }
    }

    @Override // z6.b0
    public final Class d() {
        switch (this.f5167v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return Bitmap.class;
            case 1:
                return byte[].class;
            case 2:
                return Drawable.class;
            default:
                return ((File) this.f5168w).getClass();
        }
    }

    @Override // z6.b0
    public final void e() {
        switch (this.f5167v) {
            case 2:
                ((AnimatedImageDrawable) this.f5168w).stop();
                ((AnimatedImageDrawable) this.f5168w).clearAnimationCallbacks();
                break;
        }
    }

    @Override // z6.b0
    public final Object get() {
        switch (this.f5167v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return (Bitmap) this.f5168w;
            case 1:
                return (byte[]) this.f5168w;
            case 2:
                return (AnimatedImageDrawable) this.f5168w;
            default:
                return (File) this.f5168w;
        }
    }

    public a0(byte[] bArr) {
        this.f5167v = 1;
        s7.f.c(bArr, "Argument must not be null");
        this.f5168w = bArr;
    }

    public a0(File file) {
        this.f5167v = 3;
        s7.f.c(file, "Argument must not be null");
        this.f5168w = file;
    }

    private final void a() {
    }

    private final void b() {
    }

    private final void f() {
    }
}
