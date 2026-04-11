package e4;

import java.util.NoSuchElementException;
import s1.u;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e implements q3.c {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f4414u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f4415v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f4416w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f4417x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f4418y;

    @Override // q3.c
    public int a() {
        return -1;
    }

    @Override // q3.c
    public int b() {
        return this.f4414u;
    }

    @Override // q3.c
    public int c() {
        u uVar = (u) this.f4418y;
        int i = this.f4415v;
        if (i == 8) {
            return uVar.x();
        }
        if (i == 16) {
            return uVar.D();
        }
        int i10 = this.f4416w;
        this.f4416w = i10 + 1;
        if (i10 % 2 != 0) {
            return this.f4417x & 15;
        }
        int iX = uVar.x();
        this.f4417x = iX;
        return (iX & 240) >> 4;
    }

    public long d() {
        int i = this.f4416w;
        if (i == 0) {
            throw new NoSuchElementException();
        }
        long[] jArr = (long[]) this.f4418y;
        int i10 = this.f4414u;
        long j5 = jArr[i10];
        this.f4414u = this.f4417x & (i10 + 1);
        this.f4416w = i - 1;
        return j5;
    }
}
