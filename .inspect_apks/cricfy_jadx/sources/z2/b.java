package z2;

import androidx.media3.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;
import l4.c0;
import v1.p;
import y1.a0;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends g2.e {
    public final DecoderInputBuffer N;
    public final t O;
    public a P;
    public long Q;

    public b() {
        super(6);
        this.N = new DecoderInputBuffer(1);
        this.O = new t();
    }

    @Override // g2.e
    public final int A(p pVar) {
        return "application/x-camera-motion".equals(pVar.f12946n) ? q4.a.d(4, 0, 0, 0) : q4.a.d(0, 0, 0, 0);
    }

    @Override // g2.e, g2.k1
    public final void b(int i, Object obj) {
        if (i == 8) {
            this.P = (a) obj;
        }
    }

    @Override // g2.e
    public final String j() {
        return "CameraMotionRenderer";
    }

    @Override // g2.e
    public final boolean l() {
        return k();
    }

    @Override // g2.e
    public final boolean m() {
        return true;
    }

    @Override // g2.e
    public final void o() {
        a aVar = this.P;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // g2.e
    public final void q(boolean z10, long j4) {
        this.Q = Long.MIN_VALUE;
        a aVar = this.P;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // g2.e
    public final void x(long j4, long j7) {
        float[] fArr;
        while (!k() && this.Q < 100000 + j4) {
            DecoderInputBuffer decoderInputBuffer = this.N;
            decoderInputBuffer.clear();
            c0 c0Var = this.f4659x;
            c0Var.q();
            if (w(c0Var, decoderInputBuffer, 0) != -4 || decoderInputBuffer.isEndOfStream()) {
                return;
            }
            long j10 = decoderInputBuffer.timeUs;
            this.Q = j10;
            boolean z10 = j10 < this.G;
            if (this.P != null && !z10) {
                decoderInputBuffer.flip();
                ByteBuffer byteBuffer = decoderInputBuffer.data;
                int i = a0.f14551a;
                if (byteBuffer.remaining() != 16) {
                    fArr = null;
                } else {
                    byte[] bArrArray = byteBuffer.array();
                    int iLimit = byteBuffer.limit();
                    t tVar = this.O;
                    tVar.H(iLimit, bArrArray);
                    tVar.J(byteBuffer.arrayOffset() + 4);
                    float[] fArr2 = new float[3];
                    for (int i10 = 0; i10 < 3; i10++) {
                        fArr2[i10] = Float.intBitsToFloat(tVar.l());
                    }
                    fArr = fArr2;
                }
                if (fArr != null) {
                    this.P.a(this.Q - this.F, fArr);
                }
            }
        }
    }
}
