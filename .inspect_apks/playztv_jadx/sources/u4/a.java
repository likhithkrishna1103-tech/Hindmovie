package u4;

import be.h;
import java.io.IOException;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements y4.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final z4.a f12762u;

    public a(z4.a aVar) {
        h.e(aVar, "db");
        this.f12762u = aVar;
    }

    @Override // y4.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final g e0(String str) {
        h.e(str, "sql");
        z4.a aVar = this.f12762u;
        h.e(aVar, "db");
        String string = ie.e.b0(str).toString();
        if (string.length() >= 3) {
            String strSubstring = string.substring(0, 3);
            h.d(strSubstring, "substring(...)");
            String upperCase = strSubstring.toUpperCase(Locale.ROOT);
            h.d(upperCase, "toUpperCase(...)");
            int iHashCode = upperCase.hashCode();
            if (iHashCode == 79487 ? upperCase.equals("PRA") : !(iHashCode == 81978 ? !upperCase.equals("SEL") : !(iHashCode == 85954 && upperCase.equals("WIT")))) {
                e eVar = new e(aVar, str);
                eVar.f12768x = new int[0];
                eVar.f12769y = new long[0];
                eVar.f12770z = new double[0];
                eVar.A = new String[0];
                eVar.B = new byte[0][];
                return eVar;
            }
        }
        return new f(aVar, str);
    }

    @Override // java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f12762u.close();
    }
}
