package df;

import java.util.List;
import javax.net.ssl.SSLSocket;
import org.conscrypt.Conscrypt;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f4210a = new j();

    @Override // df.n
    public final boolean a(SSLSocket sSLSocket) {
        return Conscrypt.isConscrypt(sSLSocket);
    }

    @Override // df.n
    public final String b(SSLSocket sSLSocket) {
        if (a(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return null;
    }

    @Override // df.n
    public final boolean c() {
        boolean z2 = cf.h.f2741d;
        return cf.h.f2741d;
    }

    @Override // df.n
    public final void d(SSLSocket sSLSocket, String str, List list) {
        be.h.e(list, "protocols");
        if (a(sSLSocket)) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            cf.n nVar = cf.n.f2753a;
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) pa.b.d(list).toArray(new String[0]));
        }
    }
}
