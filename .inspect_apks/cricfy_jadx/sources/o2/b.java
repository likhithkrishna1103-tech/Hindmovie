package o2;

import android.content.Context;
import android.graphics.Point;
import androidx.media3.decoder.DecoderInputBuffer;
import e2.h;
import e2.j;
import java.io.IOException;
import java.nio.ByteBuffer;
import qb.t1;
import v1.n0;
import v1.p;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends j {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Context f9425o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f9426p;

    public b(Context context) {
        super(new DecoderInputBuffer[1], new a[1]);
        this.f9425o = context;
        this.f9426p = -1;
    }

    @Override // e2.j
    public final DecoderInputBuffer b() {
        return new DecoderInputBuffer(1);
    }

    @Override // e2.j
    public final h c() {
        return new a(this);
    }

    @Override // e2.j
    public final e2.e d(Throwable th) {
        return new c("Unexpected decode error", th);
    }

    @Override // e2.j
    public final e2.e e(DecoderInputBuffer decoderInputBuffer, h hVar, boolean z10) {
        a aVar = (a) hVar;
        ByteBuffer byteBuffer = decoderInputBuffer.data;
        byteBuffer.getClass();
        y1.d.g(byteBuffer.hasArray());
        y1.d.b(byteBuffer.arrayOffset() == 0);
        try {
            int iMax = this.f9426p;
            if (iMax == -1) {
                Context context = this.f9425o;
                if (context != null) {
                    Point pointU = a0.u(context);
                    int i = pointU.x;
                    int i10 = pointU.y;
                    p pVar = decoderInputBuffer.format;
                    if (pVar != null) {
                        int i11 = pVar.M;
                        if (i11 != -1) {
                            i *= i11;
                        }
                        int i12 = pVar.N;
                        if (i12 != -1) {
                            i10 *= i12;
                        }
                    }
                    iMax = (Math.max(i, i10) * 2) - 1;
                } else {
                    iMax = 4096;
                }
            }
            aVar.f9423v = t1.e(byteBuffer.array(), byteBuffer.remaining(), iMax);
            aVar.timeUs = decoderInputBuffer.timeUs;
            return null;
        } catch (n0 e9) {
            return new c("Could not decode image data with BitmapFactory.", e9);
        } catch (IOException e10) {
            return new c(e10);
        }
    }
}
