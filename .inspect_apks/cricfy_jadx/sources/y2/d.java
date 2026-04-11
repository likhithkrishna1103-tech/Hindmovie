package y2;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f14643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f14644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f14645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f14646d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f14647e;
    public long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean[] f14648g = new boolean[15];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14649h;

    public final boolean a() {
        return this.f14646d > 15 && this.f14649h == 0;
    }

    public final void b(long j4) {
        long j7 = this.f14646d;
        if (j7 == 0) {
            this.f14643a = j4;
        } else if (j7 == 1) {
            long j10 = j4 - this.f14643a;
            this.f14644b = j10;
            this.f = j10;
            this.f14647e = 1L;
        } else {
            long j11 = j4 - this.f14645c;
            int i = (int) (j7 % 15);
            long jAbs = Math.abs(j11 - this.f14644b);
            boolean[] zArr = this.f14648g;
            if (jAbs <= 1000000) {
                this.f14647e++;
                this.f += j11;
                if (zArr[i]) {
                    zArr[i] = false;
                    this.f14649h--;
                }
            } else if (!zArr[i]) {
                zArr[i] = true;
                this.f14649h++;
            }
        }
        this.f14646d++;
        this.f14645c = j4;
    }

    public final void c() {
        this.f14646d = 0L;
        this.f14647e = 0L;
        this.f = 0L;
        this.f14649h = 0;
        Arrays.fill(this.f14648g, false);
    }
}
