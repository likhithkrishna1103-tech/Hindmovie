package f9;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q4 f4329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4330b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4331c = a();

    public p4(q4 q4Var) {
        this.f4329a = q4Var;
    }

    public final long a() {
        q4 q4Var = this.f4329a;
        o8.u.g(q4Var);
        long jLongValue = ((Long) f0.f4158v.a(null)).longValue();
        long jLongValue2 = ((Long) f0.f4160w.a(null)).longValue();
        for (int i = 1; i < this.f4330b; i++) {
            jLongValue += jLongValue;
            if (jLongValue >= jLongValue2) {
                break;
            }
        }
        q4Var.A0().getClass();
        return Math.min(jLongValue, jLongValue2) + System.currentTimeMillis();
    }
}
