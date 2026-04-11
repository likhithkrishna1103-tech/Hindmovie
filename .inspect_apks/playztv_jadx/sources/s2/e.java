package s2;

import java.util.Arrays;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11735d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f11732a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11733b = 65536;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11736e = 0;
    public a[] f = new a[100];

    public final synchronized int a() {
        return this.f11735d * this.f11733b;
    }

    public final synchronized void b(int i) {
        boolean z2 = i < this.f11734c;
        this.f11734c = i;
        if (z2) {
            c();
        }
    }

    public final synchronized void c() {
        int iMax = Math.max(0, b0.f(this.f11734c, this.f11733b) - this.f11735d);
        int i = this.f11736e;
        if (iMax >= i) {
            return;
        }
        Arrays.fill(this.f, iMax, i, (Object) null);
        this.f11736e = iMax;
    }
}
