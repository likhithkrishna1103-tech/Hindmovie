package kf;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f7508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f7509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f7510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final rd.j f7511d;

    public n(d0 d0Var, h hVar, List list, fe.a aVar) {
        this.f7508a = d0Var;
        this.f7509b = hVar;
        this.f7510c = list;
        this.f7511d = new rd.j(new c.d0(6, aVar));
    }

    public final List a() {
        return (List) this.f7511d.getValue();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return nVar.f7508a == this.f7508a && ge.i.a(nVar.f7509b, this.f7509b) && ge.i.a(nVar.a(), a()) && ge.i.a(nVar.f7510c, this.f7510c);
    }

    public final int hashCode() {
        return this.f7510c.hashCode() + ((a().hashCode() + ((this.f7509b.hashCode() + ((this.f7508a.hashCode() + 527) * 31)) * 31)) * 31);
    }

    public final String toString() {
        String type;
        String type2;
        List<Certificate> listA = a();
        ArrayList arrayList = new ArrayList(sd.l.f0(listA, 10));
        for (Certificate certificate : listA) {
            if (certificate instanceof X509Certificate) {
                type2 = ((X509Certificate) certificate).getSubjectDN().toString();
            } else {
                type2 = certificate.getType();
                ge.i.d(type2, "getType(...)");
            }
            arrayList.add(type2);
        }
        String string = arrayList.toString();
        StringBuilder sb = new StringBuilder("Handshake{tlsVersion=");
        sb.append(this.f7508a);
        sb.append(" cipherSuite=");
        sb.append(this.f7509b);
        sb.append(" peerCertificates=");
        sb.append(string);
        sb.append(" localCertificates=");
        List<Certificate> list = this.f7510c;
        ArrayList arrayList2 = new ArrayList(sd.l.f0(list, 10));
        for (Certificate certificate2 : list) {
            if (certificate2 instanceof X509Certificate) {
                type = ((X509Certificate) certificate2).getSubjectDN().toString();
            } else {
                type = certificate2.getType();
                ge.i.d(type, "getType(...)");
            }
            arrayList2.add(type);
        }
        sb.append(arrayList2);
        sb.append('}');
        return sb.toString();
    }
}
