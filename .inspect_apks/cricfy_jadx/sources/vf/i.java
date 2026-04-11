package vf;

import javax.net.ssl.SSLSocket;
import org.conscrypt.Conscrypt;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements l {
    @Override // vf.l
    public final boolean c(SSLSocket sSLSocket) {
        return k.f13740b && Conscrypt.isConscrypt(sSLSocket);
    }

    @Override // vf.l
    public final n g(SSLSocket sSLSocket) {
        return new k();
    }
}
