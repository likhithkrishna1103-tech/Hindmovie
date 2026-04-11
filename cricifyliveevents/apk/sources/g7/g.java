package g7;

import android.graphics.ImageDecoder;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements x6.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f5183b;

    public g(int i) {
        this.f5182a = i;
        switch (i) {
            case 1:
                this.f5183b = new c();
                break;
            default:
                this.f5183b = new c();
                break;
        }
    }

    @Override // x6.j
    public final /* bridge */ /* synthetic */ boolean a(Object obj, x6.h hVar) {
        switch (this.f5182a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                break;
            default:
                break;
        }
        return true;
    }

    @Override // x6.j
    public final z6.b0 b(Object obj, int i, int i10, x6.h hVar) {
        switch (this.f5182a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return this.f5183b.c(ImageDecoder.createSource((ByteBuffer) obj), i, i10, hVar);
            default:
                return this.f5183b.c(ImageDecoder.createSource(s7.b.b((InputStream) obj)), i, i10, hVar);
        }
    }
}
