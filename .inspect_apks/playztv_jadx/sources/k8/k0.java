package k8;

import java.math.BigInteger;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k0 extends y0 {
    public String A;
    public long B;
    public long C;
    public List D;
    public String E;
    public int F;
    public String G;
    public String H;
    public String I;
    public long J;
    public String K;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f7276x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f7277y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f7278z;

    @Override // k8.y0
    public final boolean v1() {
        return true;
    }

    public final String w1() {
        t1();
        t7.v.h(this.f7276x);
        return this.f7276x;
    }

    public final String x1() {
        p1();
        t1();
        t7.v.h(this.G);
        return this.G;
    }

    public final void y1() {
        String str;
        p1();
        if (n1().z1().i(y1.f7555w)) {
            byte[] bArr = new byte[16];
            o1().D2().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        } else {
            g().H.d("Analytics Storage consent is not granted");
            str = null;
        }
        g().H.d("Resetting session stitching token to ".concat(str == null ? "null" : "not null"));
        this.I = str;
        ((k1) this.f2454v).H.getClass();
        this.J = System.currentTimeMillis();
    }
}
