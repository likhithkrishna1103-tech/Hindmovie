package of;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends nf.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ s f9811e;
    public final /* synthetic */ f9.r f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(String str, s sVar, f9.r rVar) {
        super(str);
        this.f9811e = sVar;
        this.f = rVar;
    }

    @Override // nf.a
    public final long a() throws InterruptedException {
        r rVar;
        s sVar = this.f9811e;
        try {
            rVar = sVar.g();
        } catch (Throwable th) {
            rVar = new r(sVar, th, 2);
        }
        f9.r rVar2 = this.f;
        if (!((CopyOnWriteArrayList) rVar2.A).contains(sVar)) {
            return -1L;
        }
        ((LinkedBlockingDeque) rVar2.B).put(rVar);
        return -1L;
    }
}
