package u2;

import androidx.media3.decoder.DecoderInputBuffer;
import e2.j;
import java.nio.ByteBuffer;
import x3.f;
import x3.g;
import x3.h;
import x3.i;
import x3.l;
import x3.m;
import x3.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends j implements h {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final p f12067o;

    public b(String str, p pVar) {
        super(new l[2], new m[2]);
        int i = this.f3767g;
        DecoderInputBuffer[] decoderInputBufferArr = this.f3766e;
        y1.d.g(i == decoderInputBufferArr.length);
        for (DecoderInputBuffer decoderInputBuffer : decoderInputBufferArr) {
            decoderInputBuffer.ensureSpaceForWrite(1024);
        }
        this.f12067o = pVar;
    }

    @Override // e2.j
    public final DecoderInputBuffer b() {
        return new l(1);
    }

    @Override // e2.j
    public final e2.h c() {
        return new f(this);
    }

    @Override // e2.j
    public final e2.e d(Throwable th) {
        return new i("Unexpected decode error", th);
    }

    @Override // e2.j
    public final e2.e e(DecoderInputBuffer decoderInputBuffer, e2.h hVar, boolean z10) {
        l lVar = (l) decoderInputBuffer;
        m mVar = (m) hVar;
        try {
            ByteBuffer byteBuffer = lVar.data;
            byteBuffer.getClass();
            byte[] bArrArray = byteBuffer.array();
            int iLimit = byteBuffer.limit();
            p pVar = this.f12067o;
            if (z10) {
                pVar.reset();
            }
            g gVarR = pVar.r(bArrArray, 0, iLimit);
            long j4 = lVar.timeUs;
            long j7 = lVar.f14310v;
            mVar.timeUs = j4;
            mVar.f14311v = gVarR;
            if (j7 != Long.MAX_VALUE) {
                j4 = j7;
            }
            mVar.f14312w = j4;
            mVar.shouldBeSkipped = false;
            return null;
        } catch (i e9) {
            return e9;
        }
    }

    @Override // x3.h
    public final void a(long j4) {
    }
}
