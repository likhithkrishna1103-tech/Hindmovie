package d4;

import p1.m0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s1.u f4020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w2.z f4021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4023d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f4024e;
    public w2.h0 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f4025g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4026h = 0;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f4027j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f4028k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f4029l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f4030m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f4031n;

    public u(int i, String str, String str2) {
        s1.u uVar = new s1.u(4);
        this.f4020a = uVar;
        uVar.f11709a[0] = -1;
        this.f4021b = new w2.z();
        this.f4031n = -9223372036854775807L;
        this.f4022c = str;
        this.f4023d = i;
        this.f4024e = str2;
    }

    @Override // d4.i
    public final void a() {
        this.f4026h = 0;
        this.i = 0;
        this.f4028k = false;
        this.f4031n = -9223372036854775807L;
    }

    @Override // d4.i
    public final void d(s1.u uVar) {
        s1.d.h(this.f);
        while (uVar.a() > 0) {
            int i = this.f4026h;
            s1.u uVar2 = this.f4020a;
            if (i == 0) {
                byte[] bArr = uVar.f11709a;
                int i10 = uVar.f11710b;
                int i11 = uVar.f11711c;
                while (true) {
                    if (i10 >= i11) {
                        uVar.J(i11);
                        break;
                    }
                    byte b10 = bArr[i10];
                    boolean z2 = (b10 & 255) == 255;
                    boolean z10 = this.f4028k && (b10 & 224) == 224;
                    this.f4028k = z2;
                    if (z10) {
                        uVar.J(i10 + 1);
                        this.f4028k = false;
                        uVar2.f11709a[1] = bArr[i10];
                        this.i = 2;
                        this.f4026h = 1;
                        break;
                    }
                    i10++;
                }
            } else if (i == 1) {
                int iMin = Math.min(uVar.a(), 4 - this.i);
                uVar.h(uVar2.f11709a, this.i, iMin);
                int i12 = this.i + iMin;
                this.i = i12;
                if (i12 >= 4) {
                    uVar2.J(0);
                    int iJ = uVar2.j();
                    w2.z zVar = this.f4021b;
                    if (zVar.a(iJ)) {
                        this.f4030m = zVar.f13699b;
                        if (!this.f4027j) {
                            this.f4029l = (((long) zVar.f) * 1000000) / ((long) zVar.f13700c);
                            p1.p pVar = new p1.p();
                            pVar.f9957a = this.f4025g;
                            pVar.f9966l = m0.p(this.f4024e);
                            pVar.f9967m = m0.p((String) zVar.f13703g);
                            pVar.f9968n = 4096;
                            pVar.E = zVar.f13701d;
                            pVar.F = zVar.f13700c;
                            pVar.f9960d = this.f4022c;
                            pVar.f = this.f4023d;
                            this.f.d(new p1.q(pVar));
                            this.f4027j = true;
                        }
                        uVar2.J(0);
                        this.f.f(4, uVar2);
                        this.f4026h = 2;
                    } else {
                        this.i = 0;
                        this.f4026h = 1;
                    }
                }
            } else {
                if (i != 2) {
                    throw new IllegalStateException();
                }
                int iMin2 = Math.min(uVar.a(), this.f4030m - this.i);
                this.f.f(iMin2, uVar);
                int i13 = this.i + iMin2;
                this.i = i13;
                if (i13 >= this.f4030m) {
                    s1.d.g(this.f4031n != -9223372036854775807L);
                    this.f.a(this.f4031n, 1, this.f4030m, 0, null);
                    this.f4031n += this.f4029l;
                    this.i = 0;
                    this.f4026h = 0;
                }
            }
        }
    }

    @Override // d4.i
    public final void f(int i, long j5) {
        this.f4031n = j5;
    }

    @Override // d4.i
    public final void g(w2.q qVar, h0 h0Var) {
        h0Var.a();
        h0Var.b();
        this.f4025g = h0Var.f3889e;
        h0Var.b();
        this.f = qVar.q(h0Var.f3888d, 1);
    }

    @Override // d4.i
    public final void e(boolean z2) {
    }
}
