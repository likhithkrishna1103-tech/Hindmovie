package ue;

import androidx.lifecycle.j0;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f12995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f12996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f12997c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final nd.i f12998d;

    public l(b0 b0Var, h hVar, List list, ae.a aVar) {
        this.f12995a = b0Var;
        this.f12996b = hVar;
        this.f12997c = list;
        this.f12998d = new nd.i(new j0(aVar));
    }

    public final List a() {
        return (List) this.f12998d.getValue();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return lVar.f12995a == this.f12995a && be.h.a(lVar.f12996b, this.f12996b) && be.h.a(lVar.a(), a()) && be.h.a(lVar.f12997c, this.f12997c);
    }

    public final int hashCode() {
        return this.f12997c.hashCode() + ((a().hashCode() + ((this.f12996b.hashCode() + ((this.f12995a.hashCode() + 527) * 31)) * 31)) * 31);
    }

    public final String toString() {
        String type;
        String type2;
        List<Certificate> listA = a();
        ArrayList arrayList = new ArrayList(od.k.U(listA));
        for (Certificate certificate : listA) {
            if (certificate instanceof X509Certificate) {
                type2 = ((X509Certificate) certificate).getSubjectDN().toString();
            } else {
                type2 = certificate.getType();
                be.h.d(type2, "type");
            }
            arrayList.add(type2);
        }
        String string = arrayList.toString();
        StringBuilder sb2 = new StringBuilder("Handshake{tlsVersion=");
        sb2.append(this.f12995a);
        sb2.append(" cipherSuite=");
        sb2.append(this.f12996b);
        sb2.append(" peerCertificates=");
        sb2.append(string);
        sb2.append(" localCertificates=");
        List<Certificate> list = this.f12997c;
        ArrayList arrayList2 = new ArrayList(od.k.U(list));
        for (Certificate certificate2 : list) {
            if (certificate2 instanceof X509Certificate) {
                type = ((X509Certificate) certificate2).getSubjectDN().toString();
            } else {
                type = certificate2.getType();
                be.h.d(type, "type");
            }
            arrayList2.add(type);
        }
        sb2.append(arrayList2);
        sb2.append('}');
        return sb2.toString();
    }
}
