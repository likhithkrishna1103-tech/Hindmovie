package v2;

import androidx.media3.decoder.DecoderInputBuffer;
import h4.z;
import java.nio.ByteBuffer;
import p1.q;
import s1.b0;
import s1.u;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends a2.g {
    public final DecoderInputBuffer M;
    public final u N;
    public a O;
    public long P;

    public b() {
        super(6);
        this.M = new DecoderInputBuffer(1);
        this.N = new u();
    }

    @Override // a2.g
    public final int A(q qVar) {
        return "application/x-camera-motion".equals(qVar.f10023n) ? l4.a.g(4, 0, 0, 0) : l4.a.g(0, 0, 0, 0);
    }

    @Override // a2.g, a2.w1
    public final void b(int i, Object obj) {
        if (i == 8) {
            this.O = (a) obj;
        }
    }

    @Override // a2.g
    public final String g() {
        return "CameraMotionRenderer";
    }

    @Override // a2.g
    public final boolean l() {
        return k();
    }

    @Override // a2.g
    public final boolean m() {
        return true;
    }

    @Override // a2.g
    public final void o() {
        a aVar = this.O;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // a2.g
    public final void q(boolean z2, long j5) {
        this.P = Long.MIN_VALUE;
        a aVar = this.O;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // a2.g
    public final void x(long j5, long j8) {
        float[] fArr;
        while (!k() && this.P < 100000 + j5) {
            DecoderInputBuffer decoderInputBuffer = this.M;
            decoderInputBuffer.clear();
            z zVar = this.f233w;
            zVar.F();
            if (w(zVar, decoderInputBuffer, 0) != -4 || decoderInputBuffer.isEndOfStream()) {
                return;
            }
            long j10 = decoderInputBuffer.timeUs;
            this.P = j10;
            boolean z2 = j10 < this.F;
            if (this.O != null && !z2) {
                decoderInputBuffer.flip();
                ByteBuffer byteBuffer = decoderInputBuffer.data;
                int i = b0.f11647a;
                if (byteBuffer.remaining() != 16) {
                    fArr = null;
                } else {
                    byte[] bArrArray = byteBuffer.array();
                    int iLimit = byteBuffer.limit();
                    u uVar = this.N;
                    uVar.H(iLimit, bArrArray);
                    uVar.J(byteBuffer.arrayOffset() + 4);
                    float[] fArr2 = new float[3];
                    for (int i10 = 0; i10 < 3; i10++) {
                        fArr2[i10] = Float.intBitsToFloat(uVar.l());
                    }
                    fArr = fArr2;
                }
                if (fArr != null) {
                    this.O.a(this.P - this.E, fArr);
                }
            }
        }
    }
}
