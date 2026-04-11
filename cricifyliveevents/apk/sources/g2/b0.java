package g2;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b0 implements y1.m, k4.c1 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4628v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ List f4629w;

    public /* synthetic */ b0(int i, ua.z0 z0Var) {
        this.f4628v = i;
        this.f4629w = z0Var;
    }

    @Override // y1.m
    public void a(Object obj) {
        ((v1.u0) obj).w(this.f4629w);
    }

    @Override // k4.c1
    public Object i(k4.b0 b0Var, k4.s sVar, int i) {
        switch (this.f4628v) {
        }
        return b0Var.l(sVar, this.f4629w);
    }
}
