package k1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f6814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f6815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f6817d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f6818e;
    public double f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f6819g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f6820h;
    public double i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e f6821j;

    public g() {
        this.f6814a = Math.sqrt(1500.0d);
        this.f6815b = 0.5d;
        this.f6816c = false;
        this.i = Double.MAX_VALUE;
        this.f6821j = new e();
    }

    public final e a(double d10, double d11, long j4) {
        double dSin;
        double dCos;
        if (!this.f6816c) {
            if (this.i == Double.MAX_VALUE) {
                throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
            }
            double d12 = this.f6815b;
            if (d12 > 1.0d) {
                double d13 = this.f6814a;
                this.f = (Math.sqrt((d12 * d12) - 1.0d) * d13) + ((-d12) * d13);
                double d14 = this.f6815b;
                double d15 = this.f6814a;
                this.f6819g = ((-d14) * d15) - (Math.sqrt((d14 * d14) - 1.0d) * d15);
            } else if (d12 >= 0.0d && d12 < 1.0d) {
                this.f6820h = Math.sqrt(1.0d - (d12 * d12)) * this.f6814a;
            }
            this.f6816c = true;
        }
        double d16 = j4 / 1000.0d;
        double d17 = d10 - this.i;
        double d18 = this.f6815b;
        if (d18 > 1.0d) {
            double d19 = this.f6819g;
            double d20 = ((d19 * d17) - d11) / (d19 - this.f);
            double d21 = d17 - d20;
            dSin = (Math.pow(2.718281828459045d, this.f * d16) * d20) + (Math.pow(2.718281828459045d, d19 * d16) * d21);
            double d22 = this.f6819g;
            double dPow = Math.pow(2.718281828459045d, d22 * d16) * d21 * d22;
            double d23 = this.f;
            dCos = (Math.pow(2.718281828459045d, d23 * d16) * d20 * d23) + dPow;
        } else if (d18 == 1.0d) {
            double d24 = this.f6814a;
            double d25 = (d24 * d17) + d11;
            double d26 = (d25 * d16) + d17;
            double dPow2 = Math.pow(2.718281828459045d, (-d24) * d16) * d26;
            double dPow3 = Math.pow(2.718281828459045d, (-this.f6814a) * d16) * d26;
            double d27 = -this.f6814a;
            dCos = (Math.pow(2.718281828459045d, d27 * d16) * d25) + (dPow3 * d27);
            dSin = dPow2;
        } else {
            double d28 = 1.0d / this.f6820h;
            double d29 = this.f6814a;
            double d30 = ((d18 * d29 * d17) + d11) * d28;
            dSin = ((Math.sin(this.f6820h * d16) * d30) + (Math.cos(this.f6820h * d16) * d17)) * Math.pow(2.718281828459045d, (-d18) * d29 * d16);
            double d31 = this.f6814a;
            double d32 = this.f6815b;
            double d33 = (-d31) * dSin * d32;
            double dPow4 = Math.pow(2.718281828459045d, (-d32) * d31 * d16);
            double d34 = this.f6820h;
            double dSin2 = Math.sin(d34 * d16) * (-d34) * d17;
            double d35 = this.f6820h;
            dCos = (((Math.cos(d35 * d16) * d30 * d35) + dSin2) * dPow4) + d33;
        }
        float f = (float) (dSin + this.i);
        e eVar = this.f6821j;
        eVar.f6796a = f;
        eVar.f6797b = (float) dCos;
        return eVar;
    }

    public g(float f) {
        this.f6814a = Math.sqrt(1500.0d);
        this.f6815b = 0.5d;
        this.f6816c = false;
        this.f6821j = new e();
        this.i = f;
    }
}
