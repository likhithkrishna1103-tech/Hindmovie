package g7;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements x6.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a7.b f5174b;

    public c() {
        this.f5173a = 0;
        this.f5174b = new o8.j(1);
    }

    @Override // x6.j
    public final /* bridge */ /* synthetic */ boolean a(Object obj, x6.h hVar) {
        switch (this.f5173a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                androidx.emoji2.text.b.v(obj);
                break;
            default:
                break;
        }
        return true;
    }

    @Override // x6.j
    public final z6.b0 b(Object obj, int i, int i10, x6.h hVar) {
        switch (this.f5173a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return c(androidx.emoji2.text.b.g(obj), i, i10, hVar);
            default:
                return d.b(this.f5174b, ((v6.d) obj).b());
        }
    }

    public d c(ImageDecoder.Source source, int i, int i10, x6.h hVar) throws IOException {
        Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(source, new f7.b(i, i10, hVar));
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            Log.v("BitmapImageDecoder", "Decoded [" + bitmapDecodeBitmap.getWidth() + "x" + bitmapDecodeBitmap.getHeight() + "] for [" + i + "x" + i10 + "]");
        }
        return new d((o8.j) this.f5174b, bitmapDecodeBitmap);
    }

    public c(a7.b bVar) {
        this.f5173a = 1;
        this.f5174b = bVar;
    }
}
