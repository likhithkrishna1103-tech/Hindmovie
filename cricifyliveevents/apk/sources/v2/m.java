package v2;

import v1.g1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f13107v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final g1 f13108w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f13109x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final v1.p f13110y;

    public m(int i, g1 g1Var, int i10) {
        this.f13107v = i;
        this.f13108w = g1Var;
        this.f13109x = i10;
        this.f13110y = g1Var.f12705d[i10];
    }

    public abstract int a();

    public abstract boolean b(m mVar);
}
