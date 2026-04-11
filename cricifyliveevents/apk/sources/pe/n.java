package pe;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n extends c1 implements m {
    public final Object c0(xd.h hVar) {
        Object obj;
        do {
            obj = c1.f10226v.get(this);
            if (!(obj instanceof s0)) {
                if (obj instanceof p) {
                    throw ((p) obj).f10263a;
                }
                return x.q(obj);
            }
        } while (Y(obj) < 0);
        z0 z0Var = new z0(u8.a.t(hVar), this);
        z0Var.w();
        z0Var.y(new e(2, x.j(this, true, new j(3, z0Var))));
        return z0Var.v();
    }
}
