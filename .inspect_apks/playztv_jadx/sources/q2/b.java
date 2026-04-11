package q2;

import androidx.media3.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;
import t3.j;
import t3.m;
import y1.h;
import y1.i;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends i implements t3.e {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final m f10588o;

    public b(String str, m mVar) {
        super(new t3.i[2], new j[2]);
        int i = this.f14471g;
        DecoderInputBuffer[] decoderInputBufferArr = this.f14470e;
        s1.d.g(i == decoderInputBufferArr.length);
        for (DecoderInputBuffer decoderInputBuffer : decoderInputBufferArr) {
            decoderInputBuffer.ensureSpaceForWrite(1024);
        }
        this.f10588o = mVar;
    }

    @Override // y1.i
    public final DecoderInputBuffer b() {
        return new t3.i(1);
    }

    @Override // y1.i
    public final h c() {
        return new t3.c(this);
    }

    @Override // y1.i
    public final y1.e d(Throwable th) {
        return new t3.f("Unexpected decode error", th);
    }

    @Override // y1.i
    public final y1.e e(DecoderInputBuffer decoderInputBuffer, h hVar, boolean z2) {
        t3.i iVar = (t3.i) decoderInputBuffer;
        j jVar = (j) hVar;
        try {
            ByteBuffer byteBuffer = iVar.data;
            byteBuffer.getClass();
            byte[] bArrArray = byteBuffer.array();
            int iLimit = byteBuffer.limit();
            m mVar = this.f10588o;
            if (z2) {
                mVar.reset();
            }
            t3.d dVarH = mVar.h(bArrArray, 0, iLimit);
            long j5 = iVar.timeUs;
            long j8 = iVar.f12089u;
            jVar.timeUs = j5;
            jVar.f12090u = dVarH;
            if (j8 != Long.MAX_VALUE) {
                j5 = j8;
            }
            jVar.f12091v = j5;
            jVar.shouldBeSkipped = false;
            return null;
        } catch (t3.f e10) {
            return e10;
        }
    }

    @Override // t3.e
    public final void a(long j5) {
    }
}
