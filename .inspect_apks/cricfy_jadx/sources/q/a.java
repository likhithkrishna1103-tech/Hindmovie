package q;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends f {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final HashMap f10306z = new HashMap();

    @Override // q.f
    public final c a(Object obj) {
        return (c) this.f10306z.get(obj);
    }

    @Override // q.f
    public final Object b(Object obj) {
        Object objB = super.b(obj);
        this.f10306z.remove(obj);
        return objB;
    }
}
