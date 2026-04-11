package k2;

import com.bumptech.glide.c;
import k3.h;
import p1.q;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6974a = new a();

    public final c a(q qVar) {
        String str = qVar.f10023n;
        if (str != null) {
            switch (str) {
                case "application/vnd.dvb.ait":
                    return new g3.b(0);
                case "application/x-icy":
                    return new j3.a();
                case "application/id3":
                    return new h(null);
                case "application/x-emsg":
                    return new g3.b(1);
                case "application/x-scte35":
                    return new m3.c();
            }
        }
        throw new IllegalArgumentException(l4.a.m("Attempted to create decoder for unsupported MIME type: ", str));
    }

    public final boolean b(q qVar) {
        String str = qVar.f10023n;
        return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str);
    }
}
