package v2;

import v1.g1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g1 f13119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f13120b;

    public p(int i, g1 g1Var, int[] iArr) {
        if (iArr.length == 0) {
            y1.b.h("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
        }
        this.f13119a = g1Var;
        this.f13120b = iArr;
    }
}
