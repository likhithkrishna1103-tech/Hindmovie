package j2;

import java.io.IOException;
import w2.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f6528a;

    public void a() {
        long j4;
        h hVar = this.f6528a;
        synchronized (x2.c.f14289b) {
            try {
                j4 = x2.c.f14290c ? x2.c.f14291d : -9223372036854775807L;
            } catch (Throwable th) {
                throw th;
            }
        }
        hVar.L = j4;
        hVar.y(true);
    }

    @Override // w2.p
    public void c() throws IOException {
        h hVar = this.f6528a;
        hVar.A.c();
        a2.a aVar = hVar.C;
        if (aVar != null) {
            throw aVar;
        }
    }
}
