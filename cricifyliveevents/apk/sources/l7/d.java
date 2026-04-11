package l7;

import androidx.media3.decoder.DecoderInputBuffer;
import b2.q;
import g7.a0;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;
import k7.g;
import x6.h;
import z6.b0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements b {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final d f7872w = new d(0);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f7873v;

    public /* synthetic */ d(int i) {
        this.f7873v = i;
    }

    @Override // l7.b
    public final b0 e(b0 b0Var, h hVar) {
        q qVar;
        byte[] bArrArray;
        switch (this.f7873v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return b0Var;
            default:
                ByteBuffer byteBufferAsReadOnlyBuffer = ((g) ((k7.b) b0Var.get()).f7212v.f1841b).f7225a.f13481d.asReadOnlyBuffer();
                AtomicReference atomicReference = s7.b.f11590a;
                if (byteBufferAsReadOnlyBuffer.isReadOnly() || !byteBufferAsReadOnlyBuffer.hasArray()) {
                    qVar = null;
                } else {
                    byte[] bArrArray2 = byteBufferAsReadOnlyBuffer.array();
                    int iArrayOffset = byteBufferAsReadOnlyBuffer.arrayOffset();
                    int iLimit = byteBufferAsReadOnlyBuffer.limit();
                    qVar = new q();
                    qVar.f1728x = bArrArray2;
                    qVar.f1726v = iArrayOffset;
                    qVar.f1727w = iLimit;
                }
                if (qVar != null && qVar.f1726v == 0 && qVar.f1727w == ((byte[]) qVar.f1728x).length) {
                    bArrArray = byteBufferAsReadOnlyBuffer.array();
                } else {
                    ByteBuffer byteBufferAsReadOnlyBuffer2 = byteBufferAsReadOnlyBuffer.asReadOnlyBuffer();
                    byte[] bArr = new byte[byteBufferAsReadOnlyBuffer2.limit()];
                    byteBufferAsReadOnlyBuffer2.get(bArr);
                    bArrArray = bArr;
                }
                return new a0(bArrArray);
        }
    }
}
