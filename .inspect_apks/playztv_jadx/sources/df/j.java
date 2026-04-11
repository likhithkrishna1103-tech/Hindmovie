package df;

import javax.net.ssl.SSLSocket;
import org.conscrypt.Conscrypt;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j implements l {
    @Override // df.l
    public final boolean a(SSLSocket sSLSocket) {
        return cf.h.f2741d && Conscrypt.isConscrypt(sSLSocket);
    }

    @Override // df.l
    public final n b(SSLSocket sSLSocket) {
        return new k();
    }
}
