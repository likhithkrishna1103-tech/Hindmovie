package j2;

import androidx.media3.decoder.DecoderInputBuffer;
import l4.c0;
import s2.a1;
import v1.p;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements a1 {
    public boolean A;
    public int B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final p f6570v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long[] f6572x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f6573y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public k2.g f6574z;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final i2.k f6571w = new i2.k(15);
    public long C = -9223372036854775807L;

    public l(k2.g gVar, p pVar, boolean z10) {
        this.f6570v = pVar;
        this.f6574z = gVar;
        this.f6572x = gVar.f6856b;
        a(gVar, z10);
    }

    public final void a(k2.g gVar, boolean z10) {
        int i = this.B;
        long j4 = -9223372036854775807L;
        long j7 = i == 0 ? -9223372036854775807L : this.f6572x[i - 1];
        this.f6573y = z10;
        this.f6574z = gVar;
        long[] jArr = gVar.f6856b;
        this.f6572x = jArr;
        long j10 = this.C;
        if (j10 == -9223372036854775807L) {
            if (j7 != -9223372036854775807L) {
                this.B = a0.a(jArr, j7, false);
            }
        } else {
            int iA = a0.a(jArr, j10, true);
            this.B = iA;
            if (this.f6573y && iA == this.f6572x.length) {
                j4 = j10;
            }
            this.C = j4;
        }
    }

    @Override // s2.a1
    public final boolean b() {
        return true;
    }

    @Override // s2.a1
    public final int e(long j4) {
        int iMax = Math.max(this.B, a0.a(this.f6572x, j4, true));
        int i = iMax - this.B;
        this.B = iMax;
        return i;
    }

    @Override // s2.a1
    public final int p(c0 c0Var, DecoderInputBuffer decoderInputBuffer, int i) {
        int i10 = this.B;
        boolean z10 = i10 == this.f6572x.length;
        if (z10 && !this.f6573y) {
            decoderInputBuffer.setFlags(4);
            return -4;
        }
        if ((i & 2) != 0 || !this.A) {
            c0Var.f7706x = this.f6570v;
            this.A = true;
            return -5;
        }
        if (z10) {
            return -3;
        }
        if ((i & 1) == 0) {
            this.B = i10 + 1;
        }
        if ((i & 4) == 0) {
            byte[] bArrH = this.f6571w.h(this.f6574z.f6855a[i10]);
            decoderInputBuffer.ensureSpaceForWrite(bArrH.length);
            decoderInputBuffer.data.put(bArrH);
        }
        decoderInputBuffer.timeUs = this.f6572x[i10];
        decoderInputBuffer.setFlags(1);
        return -4;
    }

    @Override // s2.a1
    public final void c() {
    }
}
