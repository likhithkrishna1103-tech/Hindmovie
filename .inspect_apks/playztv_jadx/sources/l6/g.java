package l6;

import android.graphics.ImageDecoder;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g implements c6.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f7975b;

    public g(int i) {
        this.f7974a = i;
        switch (i) {
            case 1:
                this.f7975b = new c();
                break;
            default:
                this.f7975b = new c();
                break;
        }
    }

    @Override // c6.k
    public final /* bridge */ /* synthetic */ boolean a(Object obj, c6.i iVar) {
        switch (this.f7974a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                break;
            default:
                break;
        }
        return true;
    }

    @Override // c6.k
    public final e6.b0 b(Object obj, int i, int i10, c6.i iVar) {
        switch (this.f7974a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return this.f7975b.c(ImageDecoder.createSource((ByteBuffer) obj), i, i10, iVar);
            default:
                return this.f7975b.c(ImageDecoder.createSource(x6.b.b((InputStream) obj)), i, i10, iVar);
        }
    }
}
