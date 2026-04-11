package l6;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements c6.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f6.a f7962b;

    public c() {
        this.f7961a = 0;
        this.f7962b = new t7.j(10);
    }

    @Override // c6.k
    public final /* bridge */ /* synthetic */ boolean a(Object obj, c6.i iVar) {
        switch (this.f7961a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                androidx.emoji2.text.b.v(obj);
                break;
            default:
                break;
        }
        return true;
    }

    @Override // c6.k
    public final e6.b0 b(Object obj, int i, int i10, c6.i iVar) {
        switch (this.f7961a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return c(androidx.emoji2.text.b.g(obj), i, i10, iVar);
            default:
                return d.e(((a6.d) obj).b(), this.f7962b);
        }
    }

    public d c(ImageDecoder.Source source, int i, int i10, c6.i iVar) throws IOException {
        Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(source, new k6.b(i, i10, iVar));
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            Log.v("BitmapImageDecoder", "Decoded [" + bitmapDecodeBitmap.getWidth() + "x" + bitmapDecodeBitmap.getHeight() + "] for [" + i + "x" + i10 + "]");
        }
        return new d(bitmapDecodeBitmap, (t7.j) this.f7962b);
    }

    public c(f6.a aVar) {
        this.f7961a = 1;
        this.f7962b = aVar;
    }
}
