package p2;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements n {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f10126u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f10127v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f10128w;

    public b(long j5, long j8) {
        this.f10126u = j5;
        this.f10127v = j8;
        this.f10128w = j5 - 1;
    }

    public final void a() {
        long j5 = this.f10128w;
        if (j5 < this.f10126u || j5 > this.f10127v) {
            throw new NoSuchElementException();
        }
    }

    @Override // p2.n
    public final boolean next() {
        long j5 = this.f10128w + 1;
        this.f10128w = j5;
        return !(j5 > this.f10127v);
    }
}
