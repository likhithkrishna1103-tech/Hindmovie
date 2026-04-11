package n6;

import android.graphics.ImageDecoder;
import android.os.Build;
import androidx.media3.decoder.DecoderInputBuffer;
import c6.i;
import c6.k;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import e6.b0;
import f6.f;
import h4.z;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f8818b;

    public /* synthetic */ a(z zVar, int i) {
        this.f8817a = i;
        this.f8818b = zVar;
    }

    @Override // c6.k
    public final boolean a(Object obj, i iVar) throws IOException {
        switch (this.f8817a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ImageHeaderParser$ImageType imageHeaderParser$ImageTypeQ = t1.q((ArrayList) this.f8818b.f5867v, (ByteBuffer) obj);
                if (imageHeaderParser$ImageTypeQ == ImageHeaderParser$ImageType.ANIMATED_WEBP || (Build.VERSION.SDK_INT >= 31 && imageHeaderParser$ImageTypeQ == ImageHeaderParser$ImageType.ANIMATED_AVIF)) {
                }
                break;
            default:
                z zVar = this.f8818b;
                ImageHeaderParser$ImageType imageHeaderParser$ImageTypeP = t1.p((ArrayList) zVar.f5867v, (InputStream) obj, (f) zVar.f5868w);
                if (imageHeaderParser$ImageTypeP == ImageHeaderParser$ImageType.ANIMATED_WEBP || (Build.VERSION.SDK_INT >= 31 && imageHeaderParser$ImageTypeP == ImageHeaderParser$ImageType.ANIMATED_AVIF)) {
                }
                break;
        }
        return true;
    }

    @Override // c6.k
    public final b0 b(Object obj, int i, int i10, i iVar) {
        switch (this.f8817a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return z.J(ImageDecoder.createSource((ByteBuffer) obj), i, i10, iVar);
            default:
                return z.J(ImageDecoder.createSource(x6.b.b((InputStream) obj)), i, i10, iVar);
        }
    }
}
