package d4;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s1.t f3783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s1.u f3784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3785d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f3786e;
    public final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f3787g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public w2.h0 f3788h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3789j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f3790k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f3791l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public p1.q f3792m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3793n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f3794o;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(String str) {
        this(0, 0, null, str);
        this.f3782a = 0;
    }

    @Override // d4.i
    public final void a() {
        switch (this.f3782a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.i = 0;
                this.f3789j = 0;
                this.f3790k = false;
                this.f3794o = -9223372036854775807L;
                break;
            default:
                this.i = 0;
                this.f3789j = 0;
                this.f3790k = false;
                this.f3794o = -9223372036854775807L;
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:180:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x03ec  */
    @Override // d4.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(s1.u r23) {
        /*
            Method dump skipped, instruction units count: 1274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d4.b.d(s1.u):void");
    }

    @Override // d4.i
    public final void e(boolean z2) {
        int i = this.f3782a;
    }

    @Override // d4.i
    public final void f(int i, long j5) {
        switch (this.f3782a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f3794o = j5;
                break;
            default:
                this.f3794o = j5;
                break;
        }
    }

    @Override // d4.i
    public final void g(w2.q qVar, h0 h0Var) {
        switch (this.f3782a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                h0Var.a();
                h0Var.b();
                this.f3787g = h0Var.f3889e;
                h0Var.b();
                this.f3788h = qVar.q(h0Var.f3888d, 1);
                break;
            default:
                h0Var.a();
                h0Var.b();
                this.f3787g = h0Var.f3889e;
                h0Var.b();
                this.f3788h = qVar.q(h0Var.f3888d, 1);
                break;
        }
    }

    public b(int i, int i10, String str, String str2) {
        this.f3782a = i10;
        switch (i10) {
            case 1:
                s1.t tVar = new s1.t(16, new byte[16]);
                this.f3783b = tVar;
                this.f3784c = new s1.u(tVar.f11703b);
                this.i = 0;
                this.f3789j = 0;
                this.f3790k = false;
                this.f3794o = -9223372036854775807L;
                this.f3785d = str;
                this.f3786e = i;
                this.f = str2;
                break;
            default:
                s1.t tVar2 = new s1.t(128, new byte[128]);
                this.f3783b = tVar2;
                this.f3784c = new s1.u(tVar2.f11703b);
                this.i = 0;
                this.f3794o = -9223372036854775807L;
                this.f3785d = str;
                this.f3786e = i;
                this.f = str2;
                break;
        }
    }

    private final void b(boolean z2) {
    }

    private final void c(boolean z2) {
    }
}
