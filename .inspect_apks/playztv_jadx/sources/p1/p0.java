package p1;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class p0 extends Exception {
    public static final String A;
    public static final String B;
    public static final String C;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f9981x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f9982y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f9983z;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f9984u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f9985v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Bundle f9986w;

    static {
        int i = s1.b0.f11647a;
        f9981x = Integer.toString(0, 36);
        f9982y = Integer.toString(1, 36);
        f9983z = Integer.toString(2, 36);
        A = Integer.toString(3, 36);
        B = Integer.toString(4, 36);
        C = Integer.toString(5, 36);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p0(String str, Throwable th, int i, long j5) {
        super(str, th);
        Bundle bundle = Bundle.EMPTY;
        this.f9984u = i;
        this.f9986w = bundle;
        this.f9985v = j5;
    }
}
