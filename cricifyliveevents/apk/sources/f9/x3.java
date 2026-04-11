package f9;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x3 implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4481v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ long f4482w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ b4 f4483x;

    public x3(b4 b4Var, long j4, int i) {
        this.f4481v = i;
        switch (i) {
            case 1:
                this.f4482w = j4;
                Objects.requireNonNull(b4Var);
                this.f4483x = b4Var;
                break;
            default:
                this.f4482w = j4;
                Objects.requireNonNull(b4Var);
                this.f4483x = b4Var;
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00b1  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.x3.run():void");
    }
}
