package ob;

import j9.i;
import j9.p;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p.a f9738a = new p.a(1);

    public static p a(p pVar, p pVar2) {
        pc.c cVar = new pc.c(25);
        i iVar = new i((pc.c) cVar.f10180v);
        c8.b bVar = new c8.b(iVar, new AtomicBoolean(false), cVar, 9);
        p.a aVar = f9738a;
        pVar.f(aVar, bVar);
        pVar2.f(aVar, bVar);
        return iVar.f6688a;
    }
}
