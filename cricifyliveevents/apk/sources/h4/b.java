package h4;

import a3.i0;
import a3.k0;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k0 f5552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y1.t f5553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f5554d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f5555e;
    public final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f5556g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public i0 f5557h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f5558j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f5559k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f5560l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public v1.p f5561m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f5562n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f5563o;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(String str) {
        this(0, 0, null, str);
        this.f5551a = 0;
    }

    @Override // h4.i
    public final void a() {
        switch (this.f5551a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.i = 0;
                this.f5558j = 0;
                this.f5559k = false;
                this.f5563o = -9223372036854775807L;
                break;
            default:
                this.i = 0;
                this.f5558j = 0;
                this.f5559k = false;
                this.f5563o = -9223372036854775807L;
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
    @Override // h4.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(y1.t r23) {
        /*
            Method dump skipped, instruction units count: 1274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.b.b(y1.t):void");
    }

    @Override // h4.i
    public final void c(boolean z10) {
        int i = this.f5551a;
    }

    @Override // h4.i
    public final void d(int i, long j4) {
        switch (this.f5551a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f5563o = j4;
                break;
            default:
                this.f5563o = j4;
                break;
        }
    }

    @Override // h4.i
    public final void e(a3.r rVar, g0 g0Var) {
        switch (this.f5551a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                g0Var.a();
                g0Var.b();
                this.f5556g = g0Var.f5646e;
                g0Var.b();
                this.f5557h = rVar.p(g0Var.f5645d, 1);
                break;
            default:
                g0Var.a();
                g0Var.b();
                this.f5556g = g0Var.f5646e;
                g0Var.b();
                this.f5557h = rVar.p(g0Var.f5645d, 1);
                break;
        }
    }

    public b(int i, int i10, String str, String str2) {
        this.f5551a = i10;
        switch (i10) {
            case 1:
                k0 k0Var = new k0(16, new byte[16]);
                this.f5552b = k0Var;
                this.f5553c = new y1.t(k0Var.f208b);
                this.i = 0;
                this.f5558j = 0;
                this.f5559k = false;
                this.f5563o = -9223372036854775807L;
                this.f5554d = str;
                this.f5555e = i;
                this.f = str2;
                break;
            default:
                k0 k0Var2 = new k0(128, new byte[128]);
                this.f5552b = k0Var2;
                this.f5553c = new y1.t(k0Var2.f208b);
                this.i = 0;
                this.f5563o = -9223372036854775807L;
                this.f5554d = str;
                this.f5555e = i;
                this.f = str2;
                break;
        }
    }

    private final void f(boolean z10) {
    }

    private final void g(boolean z10) {
    }
}
