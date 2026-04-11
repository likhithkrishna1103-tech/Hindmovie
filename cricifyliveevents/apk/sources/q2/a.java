package q2;

import o3.h;
import q3.c;
import v1.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10356a = new a();

    public final u8.a a(p pVar) {
        String str = pVar.f12946n;
        if (str != null) {
            switch (str) {
                case "application/vnd.dvb.ait":
                    return new k3.b(0);
                case "application/x-icy":
                    return new n3.a();
                case "application/id3":
                    return new h(null);
                case "application/x-emsg":
                    return new k3.b(1);
                case "application/x-scte35":
                    return new c();
            }
        }
        throw new IllegalArgumentException(q4.a.n("Attempted to create decoder for unsupported MIME type: ", str));
    }

    public final boolean b(p pVar) {
        String str = pVar.f12946n;
        return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str);
    }
}
