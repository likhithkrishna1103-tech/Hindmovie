package g7;

import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t implements x6.d {
    @Override // x6.d
    public final ImageHeaderParser$ImageType a(ByteBuffer byteBuffer) {
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    @Override // x6.d
    public final boolean b(InputStream inputStream, a7.g gVar) {
        return false;
    }

    @Override // x6.d
    public final int c(ByteBuffer byteBuffer, a7.g gVar) {
        AtomicReference atomicReference = s7.b.f11590a;
        return f(new s7.a(byteBuffer), gVar);
    }

    @Override // x6.d
    public final boolean d(ByteBuffer byteBuffer, a7.g gVar) {
        return false;
    }

    @Override // x6.d
    public final ImageHeaderParser$ImageType e(InputStream inputStream) {
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    @Override // x6.d
    public final int f(InputStream inputStream, a7.g gVar) {
        int iE;
        n1.g gVar2 = new n1.g(inputStream);
        n1.c cVarC = gVar2.c("Orientation");
        if (cVarC == null) {
            iE = 1;
        } else {
            try {
                iE = cVarC.e(gVar2.f);
            } catch (NumberFormatException unused) {
                iE = 1;
            }
        }
        if (iE == 0) {
            return -1;
        }
        return iE;
    }
}
