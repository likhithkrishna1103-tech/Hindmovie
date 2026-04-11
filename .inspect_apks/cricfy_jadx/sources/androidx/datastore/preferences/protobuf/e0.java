package androidx.datastore.preferences.protobuf;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s f696b = new s(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f697a;

    public e0(l lVar) {
        x.a(lVar, "output");
        this.f697a = lVar;
        lVar.i = this;
    }

    public void a(int i, Object obj, u0 u0Var) {
        l lVar = (l) this.f697a;
        lVar.Z(i, 3);
        u0Var.b((a) obj, lVar.i);
        lVar.Z(i, 4);
    }

    public e0() {
        k0 k0Var;
        r0 r0Var = r0.f786c;
        try {
            k0Var = (k0) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            k0Var = f696b;
        }
        k0[] k0VarArr = {s.f789b, k0Var};
        d0 d0Var = new d0();
        d0Var.f694a = k0VarArr;
        Charset charset = x.f808a;
        this.f697a = d0Var;
    }
}
