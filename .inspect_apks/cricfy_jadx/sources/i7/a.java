package i7;

import a7.g;
import android.graphics.ImageDecoder;
import android.os.Build;
import androidx.media3.decoder.DecoderInputBuffer;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import i2.k;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import x6.h;
import x6.j;
import z6.b0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f6345b;

    public /* synthetic */ a(k kVar, int i) {
        this.f6344a = i;
        this.f6345b = kVar;
    }

    @Override // x6.j
    public final boolean a(Object obj, h hVar) throws IOException {
        switch (this.f6344a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ImageHeaderParser$ImageType imageHeaderParser$ImageTypeU = com.bumptech.glide.c.u((ArrayList) this.f6345b.f6085v, (ByteBuffer) obj);
                if (imageHeaderParser$ImageTypeU == ImageHeaderParser$ImageType.ANIMATED_WEBP || (Build.VERSION.SDK_INT >= 31 && imageHeaderParser$ImageTypeU == ImageHeaderParser$ImageType.ANIMATED_AVIF)) {
                }
                break;
            default:
                k kVar = this.f6345b;
                ImageHeaderParser$ImageType imageHeaderParser$ImageTypeT = com.bumptech.glide.c.t((ArrayList) kVar.f6085v, (InputStream) obj, (g) kVar.f6086w);
                if (imageHeaderParser$ImageTypeT == ImageHeaderParser$ImageType.ANIMATED_WEBP || (Build.VERSION.SDK_INT >= 31 && imageHeaderParser$ImageTypeT == ImageHeaderParser$ImageType.ANIMATED_AVIF)) {
                }
                break;
        }
        return true;
    }

    @Override // x6.j
    public final b0 b(Object obj, int i, int i10, h hVar) {
        switch (this.f6344a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return k.e(ImageDecoder.createSource((ByteBuffer) obj), i, i10, hVar);
            default:
                return k.e(ImageDecoder.createSource(s7.b.b((InputStream) obj)), i, i10, hVar);
        }
    }
}
