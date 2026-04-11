package q6;

import a0.g;
import androidx.media3.decoder.DecoderInputBuffer;
import c6.i;
import e6.b0;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;
import l6.y;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final d f11022v = new d(0);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f11023u;

    public /* synthetic */ d(int i) {
        this.f11023u = i;
    }

    @Override // q6.a
    public final b0 f(b0 b0Var, i iVar) {
        g gVar;
        byte[] bArrArray;
        switch (this.f11023u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return b0Var;
            default:
                ByteBuffer byteBufferAsReadOnlyBuffer = ((p6.g) ((p6.b) b0Var.get()).f10213u.f5886b).f10228a.f596d.asReadOnlyBuffer();
                AtomicReference atomicReference = x6.b.f14274a;
                if (byteBufferAsReadOnlyBuffer.isReadOnly() || !byteBufferAsReadOnlyBuffer.hasArray()) {
                    gVar = null;
                } else {
                    byte[] bArrArray2 = byteBufferAsReadOnlyBuffer.array();
                    int iArrayOffset = byteBufferAsReadOnlyBuffer.arrayOffset();
                    int iLimit = byteBufferAsReadOnlyBuffer.limit();
                    gVar = new g();
                    gVar.f61w = bArrArray2;
                    gVar.f59u = iArrayOffset;
                    gVar.f60v = iLimit;
                }
                if (gVar != null && gVar.f59u == 0 && gVar.f60v == ((byte[]) gVar.f61w).length) {
                    bArrArray = byteBufferAsReadOnlyBuffer.array();
                } else {
                    ByteBuffer byteBufferAsReadOnlyBuffer2 = byteBufferAsReadOnlyBuffer.asReadOnlyBuffer();
                    byte[] bArr = new byte[byteBufferAsReadOnlyBuffer2.limit()];
                    byteBufferAsReadOnlyBuffer2.get(bArr);
                    bArrArray = bArr;
                }
                return new y(bArrArray);
        }
    }
}
