package k8;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m3 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7317u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ long f7318v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ k3 f7319w;

    public /* synthetic */ m3(k3 k3Var, long j5, int i) {
        this.f7317u = i;
        this.f7318v = j5;
        this.f7319w = k3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7317u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                k3 k3Var = this.f7319w;
                k3Var.p1();
                k3Var.w1();
                r0 r0Var = k3Var.g().I;
                long j5 = this.f7318v;
                r0Var.c(Long.valueOf(j5), "Activity paused, time");
                com.google.android.gms.internal.measurement.k4 k4Var = k3Var.B;
                k3 k3Var2 = (k3) k4Var.f3071v;
                ((k1) k3Var2.f2454v).H.getClass();
                n3 n3Var = new n3(k4Var, System.currentTimeMillis(), j5);
                k4Var.f3070u = n3Var;
                k3Var2.f7289x.postDelayed(n3Var, 2000L);
                if (((k1) k3Var.f2454v).A.C1()) {
                    ((p3) k3Var.A.f7358w).a();
                }
                break;
            default:
                k3 k3Var3 = this.f7319w;
                k3Var3.p1();
                o3 o3Var = k3Var3.A;
                k3Var3.w1();
                r0 r0Var2 = k3Var3.g().I;
                long j8 = this.f7318v;
                r0Var2.c(Long.valueOf(j8), "Activity resumed, time");
                e eVar = ((k1) k3Var3.f2454v).A;
                if (eVar.A1(null, w.O0)) {
                    if (eVar.C1() || k3Var3.f7290y) {
                        ((k3) o3Var.f7359x).p1();
                        ((p3) o3Var.f7358w).a();
                        o3Var.f7356u = j8;
                        o3Var.f7357v = j8;
                    }
                } else if (eVar.C1() || k3Var3.n1().O.b()) {
                    ((k3) o3Var.f7359x).p1();
                    ((p3) o3Var.f7358w).a();
                    o3Var.f7356u = j8;
                    o3Var.f7357v = j8;
                }
                com.google.android.gms.internal.measurement.k4 k4Var2 = k3Var3.B;
                k3 k3Var4 = (k3) k4Var2.f3071v;
                k3Var4.p1();
                n3 n3Var2 = (n3) k4Var2.f3070u;
                if (n3Var2 != null) {
                    k3Var4.f7289x.removeCallbacks(n3Var2);
                }
                k3Var4.n1().O.a(false);
                k3Var4.p1();
                k3Var4.f7290y = false;
                if (((k1) k3Var4.f2454v).A.A1(null, w.L0) && k3Var4.q1().H) {
                    k3Var4.g().I.d("Retrying trigger URI registration in foreground");
                    k3Var4.q1().P1();
                }
                u5.c cVar = k3Var3.f7291z;
                k3 k3Var5 = (k3) cVar.f12782v;
                k1 k1Var = (k1) k3Var5.f2454v;
                k3Var5.p1();
                if (k1Var.h()) {
                    k1Var.H.getClass();
                    cVar.s(System.currentTimeMillis());
                }
                break;
        }
    }
}
