package vc;

import d1.n1;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h0 implements d1.f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r0 f13632a;

    public h0(r0 r0Var) {
        ge.i.e(r0Var, "sessionGenerator");
        this.f13632a = r0Var;
    }

    @Override // d1.f1
    public final Object a() {
        return new g0(this.f13632a.a(null), null, null);
    }

    @Override // d1.f1
    public final void b(Object obj, n1 n1Var) throws IOException {
        byte[] bytes = ef.b.f3892d.b(g0.Companion.serializer(), (g0) obj).getBytes(ne.a.f9126a);
        ge.i.d(bytes, "getBytes(...)");
        n1Var.write(bytes);
    }

    @Override // d1.f1
    public final Object c(FileInputStream fileInputStream) throws d1.c {
        try {
            ef.b bVar = ef.b.f3892d;
            String str = new String(com.bumptech.glide.d.y(fileInputStream), ne.a.f9126a);
            bVar.getClass();
            return (g0) bVar.a(g0.Companion.serializer(), str);
        } catch (Exception e9) {
            throw new d1.c("Cannot parse session data", e9);
        }
    }
}
