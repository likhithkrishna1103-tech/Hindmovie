package u2;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f12564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f12565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f12566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f12567d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f12568e;
    public long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean[] f12569g = new boolean[15];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f12570h;

    public final boolean a() {
        return this.f12567d > 15 && this.f12570h == 0;
    }

    public final void b(long j5) {
        long j8 = this.f12567d;
        if (j8 == 0) {
            this.f12564a = j5;
        } else if (j8 == 1) {
            long j10 = j5 - this.f12564a;
            this.f12565b = j10;
            this.f = j10;
            this.f12568e = 1L;
        } else {
            long j11 = j5 - this.f12566c;
            int i = (int) (j8 % 15);
            long jAbs = Math.abs(j11 - this.f12565b);
            boolean[] zArr = this.f12569g;
            if (jAbs <= 1000000) {
                this.f12568e++;
                this.f += j11;
                if (zArr[i]) {
                    zArr[i] = false;
                    this.f12570h--;
                }
            } else if (!zArr[i]) {
                zArr[i] = true;
                this.f12570h++;
            }
        }
        this.f12567d++;
        this.f12566c = j5;
    }

    public final void c() {
        this.f12567d = 0L;
        this.f12568e = 0L;
        this.f = 0L;
        this.f12570h = 0;
        Arrays.fill(this.f12569g, false);
    }
}
