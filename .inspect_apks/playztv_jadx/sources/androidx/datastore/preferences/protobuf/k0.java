package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t f1081b = new t(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1082a;

    public k0(k kVar) {
        z.a(kVar, "output");
        this.f1082a = kVar;
        kVar.f1077c = this;
    }

    public void a(int i, g gVar) {
        ((k) this.f1082a).G(i, gVar);
    }

    public void b(int i, Object obj, b1 b1Var) throws IOException {
        k kVar = (k) this.f1082a;
        kVar.R(i, 3);
        b1Var.a((a) obj, kVar.f1077c);
        kVar.R(i, 4);
    }

    public k0() {
        q0 q0Var;
        try {
            q0Var = (q0) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            q0Var = f1081b;
        }
        q0[] q0VarArr = {t.f1132b, q0Var};
        j0 j0Var = new j0();
        j0Var.f1070a = q0VarArr;
        Charset charset = z.f1147a;
        this.f1082a = j0Var;
    }
}
