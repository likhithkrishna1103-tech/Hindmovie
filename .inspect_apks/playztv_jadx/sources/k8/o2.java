package k8;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o2 implements Runnable {
    public final /* synthetic */ boolean A;
    public final /* synthetic */ g2 B;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ String f7350u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ String f7351v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ long f7352w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Bundle f7353x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ boolean f7354y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ boolean f7355z;

    public o2(g2 g2Var, String str, String str2, long j5, Bundle bundle, boolean z2, boolean z10, boolean z11) {
        this.f7350u = str;
        this.f7351v = str2;
        this.f7352w = j5;
        this.f7353x = bundle;
        this.f7354y = z2;
        this.f7355z = z10;
        this.A = z11;
        this.B = g2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.B.A1(this.f7350u, this.f7351v, this.f7352w, this.f7353x, this.f7354y, this.f7355z, this.A);
    }
}
