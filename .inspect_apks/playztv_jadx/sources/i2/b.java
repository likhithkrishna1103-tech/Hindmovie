package i2;

import android.content.Context;
import android.graphics.Point;
import androidx.media3.decoder.DecoderInputBuffer;
import cf.l;
import java.io.IOException;
import java.nio.ByteBuffer;
import p1.n0;
import p1.q;
import s1.b0;
import y1.h;
import y1.i;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends i {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Context f6188o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f6189p;

    public b(Context context) {
        super(new DecoderInputBuffer[1], new a[1]);
        this.f6188o = context;
        this.f6189p = -1;
    }

    @Override // y1.i
    public final DecoderInputBuffer b() {
        return new DecoderInputBuffer(1);
    }

    @Override // y1.i
    public final h c() {
        return new a(this);
    }

    @Override // y1.i
    public final y1.e d(Throwable th) {
        return new c("Unexpected decode error", th);
    }

    @Override // y1.i
    public final y1.e e(DecoderInputBuffer decoderInputBuffer, h hVar, boolean z2) {
        a aVar = (a) hVar;
        ByteBuffer byteBuffer = decoderInputBuffer.data;
        byteBuffer.getClass();
        s1.d.g(byteBuffer.hasArray());
        s1.d.b(byteBuffer.arrayOffset() == 0);
        try {
            int iMax = this.f6189p;
            if (iMax == -1) {
                Context context = this.f6188o;
                if (context != null) {
                    Point pointU = b0.u(context);
                    int i = pointU.x;
                    int i10 = pointU.y;
                    q qVar = decoderInputBuffer.format;
                    if (qVar != null) {
                        int i11 = qVar.M;
                        if (i11 != -1) {
                            i *= i11;
                        }
                        int i12 = qVar.N;
                        if (i12 != -1) {
                            i10 *= i12;
                        }
                    }
                    iMax = (Math.max(i, i10) * 2) - 1;
                } else {
                    iMax = 4096;
                }
            }
            aVar.f6186u = l.m(byteBuffer.array(), byteBuffer.remaining(), iMax);
            aVar.timeUs = decoderInputBuffer.timeUs;
            return null;
        } catch (n0 e10) {
            return new c("Could not decode image data with BitmapFactory.", e10);
        } catch (IOException e11) {
            return new c(e11);
        }
    }
}
