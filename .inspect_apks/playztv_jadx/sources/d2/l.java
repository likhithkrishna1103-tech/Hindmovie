package d2;

import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.k4;
import h4.z;
import o2.c1;
import p1.q;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l implements c1 {
    public int A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final q f3748u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long[] f3750w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f3751x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public e2.g f3752y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f3753z;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final k4 f3749v = new k4(16);
    public long B = -9223372036854775807L;

    public l(e2.g gVar, q qVar, boolean z2) {
        this.f3748u = qVar;
        this.f3752y = gVar;
        this.f3750w = gVar.f4325b;
        a(gVar, z2);
    }

    public final void a(e2.g gVar, boolean z2) {
        int i = this.A;
        long j5 = -9223372036854775807L;
        long j8 = i == 0 ? -9223372036854775807L : this.f3750w[i - 1];
        this.f3751x = z2;
        this.f3752y = gVar;
        long[] jArr = gVar.f4325b;
        this.f3750w = jArr;
        long j10 = this.B;
        if (j10 == -9223372036854775807L) {
            if (j8 != -9223372036854775807L) {
                this.A = b0.a(jArr, j8, false);
            }
        } else {
            int iA = b0.a(jArr, j10, true);
            this.A = iA;
            if (this.f3751x && iA == this.f3750w.length) {
                j5 = j10;
            }
            this.B = j5;
        }
    }

    @Override // o2.c1
    public final int e(z zVar, DecoderInputBuffer decoderInputBuffer, int i) {
        int i10 = this.A;
        boolean z2 = i10 == this.f3750w.length;
        if (z2 && !this.f3751x) {
            decoderInputBuffer.setFlags(4);
            return -4;
        }
        if ((i & 2) != 0 || !this.f3753z) {
            zVar.f5868w = this.f3748u;
            this.f3753z = true;
            return -5;
        }
        if (z2) {
            return -3;
        }
        if ((i & 1) == 0) {
            this.A = i10 + 1;
        }
        if ((i & 4) == 0) {
            byte[] bArrT = this.f3749v.t(this.f3752y.f4324a[i10]);
            decoderInputBuffer.ensureSpaceForWrite(bArrT.length);
            decoderInputBuffer.data.put(bArrT);
        }
        decoderInputBuffer.timeUs = this.f3750w[i10];
        decoderInputBuffer.setFlags(1);
        return -4;
    }

    @Override // o2.c1
    public final boolean j() {
        return true;
    }

    @Override // o2.c1
    public final int q(long j5) {
        int iMax = Math.max(this.A, b0.a(this.f3750w, j5, true));
        int i = iMax - this.A;
        this.A = iMax;
        return i;
    }

    @Override // o2.c1
    public final void b() {
    }
}
