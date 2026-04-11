package f9;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g3 implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ f3 f4191v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ f3 f4192w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ long f4193x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ boolean f4194y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ j3 f4195z;

    public g3(j3 j3Var, f3 f3Var, f3 f3Var2, long j4, boolean z10) {
        this.f4191v = f3Var;
        this.f4192w = f3Var2;
        this.f4193x = j4;
        this.f4194y = z10;
        this.f4195z = j3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4195z.w1(this.f4191v, this.f4192w, this.f4193x, this.f4194y, null);
    }
}
