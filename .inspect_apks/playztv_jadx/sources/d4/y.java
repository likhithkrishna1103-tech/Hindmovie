package d4;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s1.z f4065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s1.u f4066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4067d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f4068e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f4069g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f4070h;
    public long i;

    public y(int i) {
        this.f4064a = i;
        switch (i) {
            case 1:
                this.f4065b = new s1.z(0L);
                this.f4069g = -9223372036854775807L;
                this.f4070h = -9223372036854775807L;
                this.i = -9223372036854775807L;
                this.f4066c = new s1.u();
                break;
            default:
                this.f4065b = new s1.z(0L);
                this.f4069g = -9223372036854775807L;
                this.f4070h = -9223372036854775807L;
                this.i = -9223372036854775807L;
                this.f4066c = new s1.u();
                break;
        }
    }

    public static int b(int i, byte[] bArr) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public static long c(s1.u uVar) {
        int i = uVar.f11710b;
        if (uVar.a() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        uVar.h(bArr, 0, 9);
        uVar.J(i);
        byte b10 = bArr[0];
        if ((b10 & 196) == 68) {
            byte b11 = bArr[2];
            if ((b11 & 4) == 4) {
                byte b12 = bArr[4];
                if ((b12 & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3) {
                    long j5 = b10;
                    long j8 = b11;
                    return ((j8 & 3) << 13) | ((j5 & 3) << 28) | (((56 & j5) >> 3) << 30) | ((((long) bArr[1]) & 255) << 20) | (((j8 & 248) >> 3) << 15) | ((((long) bArr[3]) & 255) << 5) | ((((long) b12) & 248) >> 3);
                }
            }
        }
        return -9223372036854775807L;
    }

    public final void a(w2.p pVar) {
        switch (this.f4064a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                byte[] bArr = s1.b0.f11649c;
                s1.u uVar = this.f4066c;
                uVar.getClass();
                uVar.H(bArr.length, bArr);
                this.f4067d = true;
                pVar.l();
                break;
            default:
                byte[] bArr2 = s1.b0.f11649c;
                s1.u uVar2 = this.f4066c;
                uVar2.getClass();
                uVar2.H(bArr2.length, bArr2);
                this.f4067d = true;
                pVar.l();
                break;
        }
    }
}
