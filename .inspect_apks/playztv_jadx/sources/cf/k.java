package cf;

import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import ue.t;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k extends n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f2750c;

    static {
        String property = System.getProperty("java.specification.version");
        Integer numF = property != null ? ie.m.F(property) : null;
        boolean z2 = false;
        if (numF == null) {
            try {
                SSLSocket.class.getMethod("getApplicationProtocol", null);
                z2 = true;
            } catch (NoSuchMethodException unused) {
            }
        } else if (numF.intValue() >= 9) {
            z2 = true;
        }
        f2750c = z2;
    }

    @Override // cf.n
    public final void d(SSLSocket sSLSocket, String str, List list) {
        be.h.e(list, "protocols");
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((t) obj) != t.f13046v) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(od.k.U(arrayList));
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj2 = arrayList.get(i);
            i++;
            arrayList2.add(((t) obj2).f13051u);
        }
        sSLParameters.setApplicationProtocols((String[]) arrayList2.toArray(new String[0]));
        sSLSocket.setSSLParameters(sSLParameters);
    }

    @Override // cf.n
    public final String f(SSLSocket sSLSocket) {
        try {
            String applicationProtocol = sSLSocket.getApplicationProtocol();
            if (applicationProtocol == null ? true : applicationProtocol.equals("")) {
                return null;
            }
            return applicationProtocol;
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }
}
