package h4;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y1.y f5828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y1.t f5829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f5831e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f5832g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f5833h;
    public long i;

    public y(int i) {
        this.f5827a = i;
        switch (i) {
            case 1:
                this.f5828b = new y1.y(0L);
                this.f5832g = -9223372036854775807L;
                this.f5833h = -9223372036854775807L;
                this.i = -9223372036854775807L;
                this.f5829c = new y1.t();
                break;
            default:
                this.f5828b = new y1.y(0L);
                this.f5832g = -9223372036854775807L;
                this.f5833h = -9223372036854775807L;
                this.i = -9223372036854775807L;
                this.f5829c = new y1.t();
                break;
        }
    }

    public static int b(int i, byte[] bArr) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public static long c(y1.t tVar) {
        int i = tVar.f14610b;
        if (tVar.a() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        tVar.h(bArr, 0, 9);
        tVar.J(i);
        byte b8 = bArr[0];
        if ((b8 & 196) == 68) {
            byte b10 = bArr[2];
            if ((b10 & 4) == 4) {
                byte b11 = bArr[4];
                if ((b11 & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3) {
                    long j4 = b8;
                    long j7 = b10;
                    return ((j7 & 3) << 13) | ((j4 & 3) << 28) | (((56 & j4) >> 3) << 30) | ((((long) bArr[1]) & 255) << 20) | (((j7 & 248) >> 3) << 15) | ((((long) bArr[3]) & 255) << 5) | ((((long) b11) & 248) >> 3);
                }
            }
        }
        return -9223372036854775807L;
    }

    public final void a(a3.q qVar) {
        switch (this.f5827a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                byte[] bArr = y1.a0.f14553c;
                y1.t tVar = this.f5829c;
                tVar.getClass();
                tVar.H(bArr.length, bArr);
                this.f5830d = true;
                qVar.k();
                break;
            default:
                byte[] bArr2 = y1.a0.f14553c;
                y1.t tVar2 = this.f5829c;
                tVar2.getClass();
                tVar2.H(bArr2.length, bArr2);
                this.f5830d = true;
                qVar.k();
                break;
        }
    }
}
