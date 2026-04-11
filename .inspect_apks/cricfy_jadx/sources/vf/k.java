package vf;

import f9.b0;
import java.util.List;
import javax.net.ssl.SSLSocket;
import org.conscrypt.Conscrypt;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f13739a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f13740b;

    static {
        boolean z10 = false;
        try {
            Class.forName("org.conscrypt.Conscrypt$Version", false, j.class.getClassLoader());
            if (Conscrypt.isAvailable()) {
                if (j.a()) {
                    z10 = true;
                }
            }
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        f13740b = z10;
    }

    @Override // vf.n
    public final String a(SSLSocket sSLSocket) {
        if (c(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return null;
    }

    @Override // vf.n
    public final boolean b() {
        return f13740b;
    }

    @Override // vf.n
    public final boolean c(SSLSocket sSLSocket) {
        return Conscrypt.isConscrypt(sSLSocket);
    }

    @Override // vf.n
    public final void d(SSLSocket sSLSocket, String str, List list) {
        ge.i.e(list, "protocols");
        if (c(sSLSocket)) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            uf.f fVar = uf.f.f12506a;
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) b0.w(list).toArray(new String[0]));
        }
    }
}
