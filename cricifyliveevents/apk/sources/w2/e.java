package w2;

import java.util.Arrays;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13848d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f13845a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13846b = 65536;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13849e = 0;
    public a[] f = new a[100];

    public final synchronized int a() {
        return this.f13848d * this.f13846b;
    }

    public final synchronized void b(int i) {
        boolean z10 = i < this.f13847c;
        this.f13847c = i;
        if (z10) {
            c();
        }
    }

    public final synchronized void c() {
        int iMax = Math.max(0, a0.f(this.f13847c, this.f13846b) - this.f13848d);
        int i = this.f13849e;
        if (iMax >= i) {
            return;
        }
        Arrays.fill(this.f, iMax, i, (Object) null);
        this.f13849e = iMax;
    }
}
