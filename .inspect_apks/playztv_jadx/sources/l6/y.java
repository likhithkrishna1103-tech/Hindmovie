package l6;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class y implements e6.b0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f8016u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f8017v;

    public /* synthetic */ y(int i, Object obj) {
        this.f8016u = i;
        this.f8017v = obj;
    }

    @Override // e6.b0
    public final int b() {
        switch (this.f8016u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return x6.m.c((Bitmap) this.f8017v);
            case 1:
                return ((byte[]) this.f8017v).length;
            case 2:
                return x6.m.d(Bitmap.Config.ARGB_8888) * ((AnimatedImageDrawable) this.f8017v).getIntrinsicHeight() * ((AnimatedImageDrawable) this.f8017v).getIntrinsicWidth() * 2;
            default:
                return 1;
        }
    }

    @Override // e6.b0
    public final Class c() {
        switch (this.f8016u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return Bitmap.class;
            case 1:
                return byte[].class;
            case 2:
                return Drawable.class;
            default:
                return ((File) this.f8017v).getClass();
        }
    }

    @Override // e6.b0
    public final void d() {
        switch (this.f8016u) {
            case 2:
                ((AnimatedImageDrawable) this.f8017v).stop();
                ((AnimatedImageDrawable) this.f8017v).clearAnimationCallbacks();
                break;
        }
    }

    @Override // e6.b0
    public final Object get() {
        switch (this.f8016u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return (Bitmap) this.f8017v;
            case 1:
                return (byte[]) this.f8017v;
            case 2:
                return (AnimatedImageDrawable) this.f8017v;
            default:
                return (File) this.f8017v;
        }
    }

    public y(byte[] bArr) {
        this.f8016u = 1;
        x6.f.c(bArr, "Argument must not be null");
        this.f8017v = bArr;
    }

    public y(File file) {
        this.f8016u = 3;
        x6.f.c(file, "Argument must not be null");
        this.f8017v = file;
    }

    private final void a() {
    }

    private final void e() {
    }

    private final void f() {
    }
}
