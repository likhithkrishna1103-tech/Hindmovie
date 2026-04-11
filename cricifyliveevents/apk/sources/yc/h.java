package yc;

import d1.f1;
import d1.n1;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f15039a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f15040b = new g(null, null, null, null, null);

    @Override // d1.f1
    public final /* bridge */ /* synthetic */ Object a() {
        return f15040b;
    }

    @Override // d1.f1
    public final void b(Object obj, n1 n1Var) throws IOException {
        byte[] bytes = ef.b.f3892d.b(g.Companion.serializer(), (g) obj).getBytes(ne.a.f9126a);
        ge.i.d(bytes, "getBytes(...)");
        n1Var.write(bytes);
    }

    @Override // d1.f1
    public final Object c(FileInputStream fileInputStream) throws d1.c {
        try {
            ef.b bVar = ef.b.f3892d;
            String str = new String(com.bumptech.glide.d.y(fileInputStream), ne.a.f9126a);
            bVar.getClass();
            return (g) bVar.a(g.Companion.serializer(), str);
        } catch (Exception e9) {
            throw new d1.c("Cannot parse session configs", e9);
        }
    }
}
