package d7;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0 f3512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f3513b;

    public x(l7.a aVar) {
        a0 a0Var = new a0(aVar);
        this.f3513b = new w(0);
        this.f3512a = a0Var;
    }

    public final synchronized ArrayList a(Class cls) {
        return this.f3512a.d(cls);
    }
}
