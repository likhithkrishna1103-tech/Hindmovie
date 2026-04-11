package f9;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p2 implements Runnable {
    public final /* synthetic */ boolean A;
    public final /* synthetic */ boolean B;
    public final /* synthetic */ x2 C;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ String f4323v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ String f4324w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ long f4325x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Bundle f4326y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ boolean f4327z;

    public p2(x2 x2Var, String str, String str2, long j4, Bundle bundle, boolean z10, boolean z11, boolean z12) {
        this.f4323v = str;
        this.f4324w = str2;
        this.f4325x = j4;
        this.f4326y = bundle;
        this.f4327z = z10;
        this.A = z11;
        this.B = z12;
        this.C = x2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.C.v1(this.f4323v, this.f4324w, this.f4325x, this.f4326y, this.f4327z, this.A, this.B);
    }
}
