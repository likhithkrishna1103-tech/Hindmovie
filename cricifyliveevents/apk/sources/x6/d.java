package x6;

import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public interface d {
    ImageHeaderParser$ImageType a(ByteBuffer byteBuffer);

    boolean b(InputStream inputStream, a7.g gVar);

    int c(ByteBuffer byteBuffer, a7.g gVar);

    boolean d(ByteBuffer byteBuffer, a7.g gVar);

    ImageHeaderParser$ImageType e(InputStream inputStream);

    int f(InputStream inputStream, a7.g gVar);
}
