package v1;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p0 extends Exception {
    public static final String A;
    public static final String B;
    public static final String C;
    public static final String D;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f12959y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f12960z;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f12961v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f12962w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Bundle f12963x;

    static {
        int i = y1.a0.f14551a;
        f12959y = Integer.toString(0, 36);
        f12960z = Integer.toString(1, 36);
        A = Integer.toString(2, 36);
        B = Integer.toString(3, 36);
        C = Integer.toString(4, 36);
        D = Integer.toString(5, 36);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p0(String str, Throwable th, int i, long j4) {
        super(str, th);
        Bundle bundle = Bundle.EMPTY;
        this.f12961v = i;
        this.f12963x = bundle;
        this.f12962w = j4;
    }
}
