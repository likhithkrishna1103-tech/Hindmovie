package u5;

import java.util.HashMap;
import l0.e;
import x7.h;
import x7.l;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f12212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f12213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f12214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f12215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f12216e;
    public Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f12217g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f12218h;
    public Object i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Object f12219j;

    public void a(String str, String str2) {
        HashMap map = (HashMap) this.f;
        if (map == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        map.put(str, str2);
    }

    public h b() {
        String strJ = ((String) this.f12213b) == null ? " transportName" : "";
        if (((l) this.f12215d) == null) {
            strJ = strJ.concat(" encodedPayload");
        }
        if (((Long) this.f12216e) == null) {
            strJ = e.j(strJ, " eventMillis");
        }
        if (((Long) this.f12212a) == null) {
            strJ = e.j(strJ, " uptimeMillis");
        }
        if (((HashMap) this.f) == null) {
            strJ = e.j(strJ, " autoMetadata");
        }
        if (strJ.isEmpty()) {
            return new h((String) this.f12213b, (Integer) this.f12214c, (l) this.f12215d, ((Long) this.f12216e).longValue(), ((Long) this.f12212a).longValue(), (HashMap) this.f, (Integer) this.f12217g, (String) this.f12218h, (byte[]) this.i, (byte[]) this.f12219j);
        }
        throw new IllegalStateException("Missing required properties:".concat(strJ));
    }
}
